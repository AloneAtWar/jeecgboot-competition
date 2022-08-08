<template>
  <a-spin :spinning="confirmLoading">
    <j-form-container :disabled="formDisabled">
      <a-form-model ref="form" :model="model" :rules="validatorRules" slot="detail">
        <a-row>
          <a-col :span="24">
            <a-form-model-item label="用户" :labelCol="labelCol" :wrapperCol="wrapperCol" prop="userId">
              <j-dict-select-tag type="list" v-model="model.userId" dictCode="sys_user,username,id" placeholder="请选择用户" />
            </a-form-model-item>
          </a-col>
          <a-col :span="24">
            <a-form-model-item label="大赛" :labelCol="labelCol" :wrapperCol="wrapperCol" prop="competitionId">
              <j-dict-select-tag type="list" v-model="model.competitionId" dictCode="competition,name,id" placeholder="请选择大赛" />
            </a-form-model-item>
          </a-col>
          <a-col :span="24">
            <a-form-model-item label="提交时间" :labelCol="labelCol" :wrapperCol="wrapperCol" prop="createTime">
              <j-date placeholder="请选择提交时间"  v-model="model.createTime" :show-time="true" date-format="YYYY-MM-DD HH:mm:ss" style="width: 100%" />
            </a-form-model-item>
          </a-col>
          <a-col :span="24">
            <a-form-model-item label="文字部分" :labelCol="labelCol" :wrapperCol="wrapperCol" prop="data">
              <j-editor v-model="model.data" />
            </a-form-model-item>
          </a-col>
          <a-col :span="24">
            <a-form-model-item label="文件地址" :labelCol="labelCol" :wrapperCol="wrapperCol" prop="fileUrl">
              <j-upload v-model="model.fileUrl"   ></j-upload>
            </a-form-model-item>
          </a-col>
          <a-col :span="24">
            <a-form-model-item label="是否已经结算" :labelCol="labelCol" :wrapperCol="wrapperCol" prop="isSettlement">
              <j-dict-select-tag type="radio" v-model="model.isSettlement" dictCode="yn" placeholder="请选择是否已经结算" />
            </a-form-model-item>
          </a-col>
        </a-row>
      </a-form-model>
    </j-form-container>
  </a-spin>
</template>

<script>

  import { httpAction, getAction } from '@/api/manage'
  import { validateDuplicateValue } from '@/utils/util'

  export default {
    name: 'CompetitionSubmitForm',
    components: {
    },
    props: {
      //表单禁用
      disabled: {
        type: Boolean,
        default: false,
        required: false
      }
    },
    data () {
      return {
        model:{
         },
        labelCol: {
          xs: { span: 24 },
          sm: { span: 5 },
        },
        wrapperCol: {
          xs: { span: 24 },
          sm: { span: 16 },
        },
        confirmLoading: false,
        validatorRules: {
        },
        url: {
          add: "/competition/competitionSubmit/add",
          edit: "/competition/competitionSubmit/edit",
          queryById: "/competition/competitionSubmit/queryById"
        }
      }
    },
    computed: {
      formDisabled(){
        return this.disabled
      },
    },
    created () {
       //备份model原始值
      this.modelDefault = JSON.parse(JSON.stringify(this.model));
    },
    methods: {
      add () {
        this.edit(this.modelDefault);
      },
      edit (record) {
        this.model = Object.assign({}, record);
        this.visible = true;
      },
      submitForm () {
        const that = this;
        // 触发表单验证
        this.$refs.form.validate(valid => {
          if (valid) {
            that.confirmLoading = true;
            let httpurl = '';
            let method = '';
            if(!this.model.id){
              httpurl+=this.url.add;
              method = 'post';
            }else{
              httpurl+=this.url.edit;
               method = 'put';
            }
            httpAction(httpurl,this.model,method).then((res)=>{
              if(res.success){
                that.$message.success(res.message);
                that.$emit('ok');
              }else{
                that.$message.warning(res.message);
              }
            }).finally(() => {
              that.confirmLoading = false;
            })
          }
         
        })
      },
    }
  }
</script>