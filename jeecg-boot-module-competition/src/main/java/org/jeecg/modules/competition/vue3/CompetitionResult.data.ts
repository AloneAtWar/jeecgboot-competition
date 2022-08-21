import {BasicColumn} from '/@/components/Table';
import {FormSchema} from '/@/components/Table';
import { rules} from '/@/utils/helper/validator';
import { render } from '/@/utils/common/renderUtils';
//列表数据
export const columns: BasicColumn[] = [
   {
    title: '大赛',
    align:"center",
    dataIndex: 'competitionId'
   },
   {
    title: '用户',
    align:"center",
    dataIndex: 'userId'
   },
   {
    title: '分数',
    align:"center",
    dataIndex: 'score'
   },
];
//查询数据
export const searchFormSchema: FormSchema[] = [
	{
      label: "大赛",
      field: 'competitionId',
      component: 'Input',
      colProps: {span: 6},
 	},
	{
      label: "用户",
      field: 'userId',
      component: 'Input',
      colProps: {span: 6},
 	},
];
//表单数据
export const formSchema: FormSchema[] = [
  {
    label: '大赛',
    field: 'competitionId',
    component: 'Input',
  },
  {
    label: '用户',
    field: 'userId',
    component: 'Input',
  },
  {
    label: '分数',
    field: 'score',
    component: 'InputNumber',
  },
	// TODO 主键隐藏字段，目前写死为ID
	{
	  label: '',
	  field: 'id',
	  component: 'Input',
	  show: false
	},
];
