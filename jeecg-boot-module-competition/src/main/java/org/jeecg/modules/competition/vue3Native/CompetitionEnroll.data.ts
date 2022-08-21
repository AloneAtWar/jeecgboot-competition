import {BasicColumn} from '/@/components/Table';
import {FormSchema} from '/@/components/Table';
import { rules} from '/@/utils/helper/validator';
import { render } from '/@/utils/common/renderUtils';
//列表数据
export const columns: BasicColumn[] = [
  {
    title: '用户',
    align: "center",
    dataIndex: 'userId_dictText'
  },
  {
    title: '手机号',
    align: "center",
    dataIndex: 'phone'
  },
  {
    title: '报名大赛',
    align: "center",
    dataIndex: 'competitionId_dictText'
  },
  {
    title: '学校',
    align: "center",
    dataIndex: 'school'
  },
  {
    title: '学历',
    align: "center",
    dataIndex: 'education'
  },
  {
    title: '专业',
    align: "center",
    dataIndex: 'professional'
  },
  {
    title: '状态',
    align: "center",
    dataIndex: 'state_dictText'
  },
  {
    title: '理由',
    align: "center",
    dataIndex: 'reason'
  },
];

//查询数据
export const searchFormSchema: FormSchema[] = [
  {
    label: "用户",
    field: 'userId',
    component: 'JDictSelectTag',
    componentProps:{
      dictCode: "sys_user,username,id"
    },
    colProps: {span: 6},
  },
  {
    label: "手机号",
    field: 'phone',
    component: 'Input',
    colProps: {span: 6},
  },
  {
    label: "报名大赛",
    field: 'competitionId',
    component: 'JDictSelectTag',
    componentProps:{
      dictCode: "competition,name,id"
    },
    colProps: {span: 6},
  },
  {
    label: "学校",
    field: 'school',
    component: 'Input',
    colProps: {span: 6},
  },
  {
    label: "学历",
    field: 'education',
    component: 'Input',
    colProps: {span: 6},
  },
  {
    label: "专业",
    field: 'professional',
    component: 'Input',
    colProps: {span: 6},
  },
];

//表单数据
export const formSchema: FormSchema[] = [
  {
    label: '用户',
    field: 'userId',
    component: 'JDictSelectTag',
    componentProps:{
      dictCode: "sys_user,username,id"
    },
  },
  {
    label: '手机号',
    field: 'phone',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
      return [
              { required: false},
              { pattern: /^1[3456789]\d{9}$/, message: '请输入正确的手机号码!'},
             ];
    },
  },
  {
    label: '报名大赛',
    field: 'competitionId',
    component: 'JDictSelectTag',
    componentProps:{
      dictCode: "competition,name,id"
    },
  },
  {
    label: '学校',
    field: 'school',
    component: 'Input',
  },
  {
    label: '学历',
    field: 'education',
    component: 'Input',
  },
  {
    label: '专业',
    field: 'professional',
    component: 'Input',
  },
  {
    label: '状态',
    field: 'state',
    component: 'JDictSelectTag',
    componentProps:{
      dictCode: "competition_enroll_state"
    },
  },
  {
    label: '理由',
    field: 'reason',
    component: 'InputTextArea',
  },
	// TODO 主键隐藏字段，目前写死为ID
  {
    label: '',
    field: 'id',
    component: 'Input',
    show: false,
  },
];
