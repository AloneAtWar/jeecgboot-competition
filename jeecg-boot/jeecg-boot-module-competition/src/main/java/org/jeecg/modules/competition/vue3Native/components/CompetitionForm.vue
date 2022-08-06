<template>
  <a-spin :spinning="loading">
    <a-form v-bind="formItemLayout">
      <a-row>
        <a-col :span="24">
          <a-form-item label="名称" v-bind="validateInfos.name">
            <a-input v-model:value="formData.name" placeholder="请输入名称" :disabled="disabled"></a-input>
          </a-form-item>
        </a-col>
        <a-col :span="24">
          <a-form-item label="图片" v-bind="validateInfos.picture">
	          <j-image-upload  v-model:value="formData.picture" :disabled="disabled"></j-image-upload>
          </a-form-item>
        </a-col>
        <a-col :span="24">
          <a-form-item label="简介" v-bind="validateInfos.introduction">
	          <a-textarea v-model:value="formData.introduction" rows="4" placeholder="请输入简介" :disabled="disabled"/>
          </a-form-item>
        </a-col>
        <a-col :span="24">
          <a-form-item label="标题" v-bind="validateInfos.title">
            <a-input v-model:value="formData.title" placeholder="请输入标题" :disabled="disabled"></a-input>
          </a-form-item>
        </a-col>
        <a-col :span="24">
          <a-form-item label="是否需要志愿者" v-bind="validateInfos.needVolunteers">
            <j-dict-select-tag type='radio' v-model:value="formData.needVolunteers" dictCode="yn" placeholder="请选择是否需要志愿者" :disabled="disabled"/>
          </a-form-item>
        </a-col>
        <a-col :span="24">
          <a-form-item label="赛事详细介绍" v-bind="validateInfos.detailIntroduce">
	          <j-editor v-model:value="formData.detailIntroduce" :disabled="disabled"/>
          </a-form-item>
        </a-col>
        <a-col :span="24">
          <a-form-item label="赛题详细" v-bind="validateInfos.problem">
	          <j-editor v-model:value="formData.problem" :disabled="disabled"/>
          </a-form-item>
        </a-col>
        <a-col :span="24">
          <a-form-item label="开始时间" v-bind="validateInfos.startTime">
		        <a-date-picker placeholder="请选择开始时间"  v-model:value="formData.startTime" showTime value-format="YYYY-MM-DD HH:mm:ss" style="width: 100%" :disabled="disabled"/>
          </a-form-item>
        </a-col>
        <a-col :span="24">
          <a-form-item label="结束时间" v-bind="validateInfos.endTime">
		        <a-date-picker placeholder="请选择结束时间"  v-model:value="formData.endTime" showTime value-format="YYYY-MM-DD HH:mm:ss" style="width: 100%" :disabled="disabled"/>
          </a-form-item>
        </a-col>
        <a-col :span="24">
          <a-form-item label="赛事类型" v-bind="validateInfos.type">
	          <j-dict-select-tag v-model:value="formData.type" dictCode="competitionType" placeholder="请选择赛事类型" :disabled="disabled"/>
          </a-form-item>
        </a-col>
      </a-row>
    </a-form>

		<!-- 子表单区域 -->
    <a-tabs v-model:activeKey="activeKey">
      <a-tab-pane tab="大赛权限表" key="competitionPermission" :forceRender="true">
        <j-vxe-table
          :keep-source="true"
          ref="competitionPermissionTableRef"
          :loading="competitionPermissionTable.loading"
          :columns="competitionPermissionTable.columns"
          :dataSource="competitionPermissionTable.dataSource"
          :maxHeight="300"
          :disabled="formDisabled"
          :rowNumber="true"
          :rowSelection="true"
          :toolbar="true"/>
      </a-tab-pane>
    </a-tabs>
  </a-spin>
</template>

<script lang="ts">
  import { defineComponent, ref, reactive, computed, toRaw } from 'vue';
  import { useValidateAntFormAndTable } from '/@/hooks/system/useJvxeMethods';
  import { queryCompetitionPermissionListByMainId, queryDataById, saveOrUpdate } from '../Competition.api';
  import { JVxeTable } from '/@/components/jeecg/JVxeTable';
  import {competitionPermissionColumns} from '../Competition.data';
  import JDictSelectTag from '/@/components/Form/src/jeecg/components/JDictSelectTag.vue';
  import JImageUpload from '/@/components/Form/src/jeecg/components/JImageUpload.vue';
  import JEditor from '/@/components/Form/src/jeecg/components/JEditor.vue';
  import { Form } from 'ant-design-vue';
  const useForm = Form.useForm;

  export default defineComponent({
    name: "CompetitionForm",
    components:{
      JDictSelectTag,
      JImageUpload,
      JEditor,
      JVxeTable,
    },
    props:{
      disabled:{
        type: Boolean,
        default: false
      }
    },
    emits:['success'],
    setup(props, {emit}) {
      const loading = ref(false);
      const competitionPermissionTableRef = ref();
      const competitionPermissionTable = reactive<Record<string, any>>({
        loading: false,
        columns: competitionPermissionColumns,
        dataSource: []
      });
      const activeKey = ref('competitionPermission');
      const formData = reactive<Record<string, any>>({
        id: '',
        name: '',
        picture: '',
        introduction: '',
        title: '',
        needVolunteers: '',
        detailIntroduce: '',
        problem: '',
        startTime: '',
        endTime: '',
        type: '',
      });

      //表单验证
      const validatorRules = reactive({
      });
      const {resetFields, validate, validateInfos} = useForm(formData, validatorRules, {immediate: true});
      const dbData = {};
      const formItemLayout = {
        labelCol: {xs: {span: 24}, sm: {span: 5}},
        wrapperCol: {xs: {span: 24}, sm: {span: 16}},
      };

      const formDisabled = computed(() => {
        return props.disabled;
      });

      function add() {
        resetFields();
        competitionPermissionTable.dataSource = [];
      }

      async function edit(row) {
        //主表数据
        await queryMainData(row.id);
        //子表数据
        const competitionPermissionDataList = await queryCompetitionPermissionListByMainId(row['id']);
        competitionPermissionTable.dataSource = [...competitionPermissionDataList];
      }

      async function queryMainData(id) {
        const row = await queryDataById(id);
        Object.keys(row).map(k => {
          formData[k] = row[k];
        });
      }

      const {getSubFormAndTableData, transformData} = useValidateAntFormAndTable(activeKey, {
        'competitionPermission': competitionPermissionTableRef,
      });

      async function getFormData() {
        await validate();
        return transformData(toRaw(formData))
      }

      async function submitForm() {
        const mainData = await getFormData();
        const subData = await getSubFormAndTableData();
        const values = Object.assign({}, dbData, mainData, subData);
        console.log('表单提交数据', values)
        const isUpdate = values.id ? true : false
        await saveOrUpdate(values, isUpdate);
        //关闭弹窗
        emit('success');
      }
      
      function setFieldsValue(values) {
        if(values){
          Object.keys(values).map(k=>{
            formData[k] = values[k];
          });
        }
      }

      /**
       * 值改变事件触发-树控件回调
       * @param key
       * @param value
       */
      function handleFormChange(key, value) {
        formData[key] = value;
      }


      return {
        competitionPermissionTableRef,
        competitionPermissionTable,
        validatorRules,
        validateInfos,
        activeKey,
        loading,
        formData,
        setFieldsValue,
        handleFormChange,
        formItemLayout,
        formDisabled,
        getFormData,
        submitForm,
        add,
        edit
      }
    }
  });
</script>