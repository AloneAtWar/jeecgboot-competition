import {BasicColumn} from '/@/components/Table';
import {FormSchema} from '/@/components/Table';
import { rules} from '/@/utils/helper/validator';
import { render } from '/@/utils/common/renderUtils';
//列表数据
export const columns: BasicColumn[] = [
   {
    title: '用户',
    align:"center",
    dataIndex: 'userId'
   },
   {
    title: '大赛',
    align:"center",
    dataIndex: 'competition'
   },
   {
    title: '提交时间',
    align:"center",
    dataIndex: 'createTime'
   },
   {
    title: '文字部分',
    align:"center",
    dataIndex: 'data',
    slots: { customRender: 'htmlSlot' },
   },
   {
    title: '文件地址',
    align:"center",
    dataIndex: 'fileUrl',
    slots: { customRender: 'fileSlot' },
   },
];
//查询数据
export const searchFormSchema: FormSchema[] = [
];
//表单数据
export const formSchema: FormSchema[] = [
  {
    label: '用户',
    field: 'userId',
    component: 'Input',
  },
  {
    label: '大赛',
    field: 'competition',
    component: 'Input',
  },
  {
    label: '提交时间',
    field: 'createTime',
    component: 'DatePicker',
    componentProps: {
       showTime: true,
       valueFormat: 'YYYY-MM-DD HH:mm:ss'
     },
  },
  {
    label: '文字部分',
    field: 'data',
    component: 'JEditor',
  },
  {
    label: '文件地址',
    field: 'fileUrl',
    component: 'JUpload',
    componentProps:{
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
