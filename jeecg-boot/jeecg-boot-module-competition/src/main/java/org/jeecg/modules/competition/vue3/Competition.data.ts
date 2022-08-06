import {BasicColumn} from '/@/components/Table';
import {FormSchema} from '/@/components/Table';
import { rules} from '/@/utils/helper/validator';
import { render } from '/@/utils/common/renderUtils';
import {JVxeTypes,JVxeColumn} from '/@/components/jeecg/JVxeTable/types'
//列表数据
export const columns: BasicColumn[] = [
   {
    title: '名称',
    align:"center",
    dataIndex: 'name'
   },
   {
    title: '图片',
    align:"center",
    dataIndex: 'picture',
    customRender:render.renderImage,
   },
   {
    title: '简介',
    align:"center",
    dataIndex: 'introduction'
   },
   {
    title: '标题',
    align:"center",
    dataIndex: 'title'
   },
   {
    title: '是否需要志愿者',
    align:"center",
    dataIndex: 'needVolunteers_dictText'
   },
   {
    title: '开始时间',
    align:"center",
    dataIndex: 'startTime'
   },
   {
    title: '结束时间',
    align:"center",
    dataIndex: 'endTime'
   },
   {
    title: '赛事类型',
    align:"center",
    dataIndex: 'type_dictText'
   },
];
//查询数据
export const searchFormSchema: FormSchema[] = [
	{
      label: "名称",
      field: "name",
      component: 'Input',
      colProps: {span: 6},
 	},
];
//表单数据
export const formSchema: FormSchema[] = [
  {
    label: '名称',
    field: 'name',
    component: 'Input',
  },
  {
    label: '图片',
    field: 'picture',
     component: 'JImageUpload',
     componentProps:{
      },
  },
  {
    label: '简介',
    field: 'introduction',
    component: 'InputTextArea',
  },
  {
    label: '标题',
    field: 'title',
    component: 'Input',
  },
  {
    label: '是否需要志愿者',
    field: 'needVolunteers',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"yn"
     },
  },
  {
    label: '赛事详细介绍',
    field: 'detailIntroduce',
    component: 'JEditor',
  },
  {
    label: '赛题详细',
    field: 'problem',
    component: 'JEditor',
  },
  {
    label: '开始时间',
    field: 'startTime',
    component: 'DatePicker',
    componentProps: {
       showTime:true,
       valueFormat: 'YYYY-MM-DD HH:mm:ss'
     },
  },
  {
    label: '结束时间',
    field: 'endTime',
    component: 'DatePicker',
    componentProps: {
       showTime:true,
       valueFormat: 'YYYY-MM-DD HH:mm:ss'
     },
  },
  {
    label: '赛事类型',
    field: 'type',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"competitionType"
     },
  },
	// TODO 主键隐藏字段，目前写死为ID
	{
	  label: '',
	  field: 'id',
	  component: 'Input',
	  show: false
	},
];
//子表单数据
//子表表格配置
export const competitionPermissionColumns: JVxeColumn[] = [
    {
      title: '用户',
      key: 'userId',
      type: JVxeTypes.select,
      options:[],
      dictCode:"sys_user,username,id",
      width:"200px",
      placeholder: '请输入${title}',
      defaultValue:'',
    },
    {
      title: '类型',
      key: 'type',
      type: JVxeTypes.inputNumber,
      width:"200px",
      placeholder: '请输入${title}',
      defaultValue:'',
    },
  ]
