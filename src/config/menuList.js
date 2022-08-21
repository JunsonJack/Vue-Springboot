//左侧菜单列表
const menuList = [
  {
    //跳转到哪里，和路由保持一致
    path : "/index",
    //path对应的组件名称
    comName: 'Index',
    //菜单的名字
    menuName : ' 首页',
    //图标的css类名称,去elementUI上去找
    iconClassName:'el-icon-s-home'
  },
  {

    path : "/student/manage",
    comName: 'StudentManage',
    menuName : '学生管理',
    iconClassName:'el-icon-s-custom'
  },
  {
    path : "/score/manage",
    comName: 'ScoreManage',
    menuName : '成绩管理',
    iconClassName:'el-icon-s-flag'
  }
]
export default menuList
