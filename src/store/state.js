import {getItem} from "../storage";
import {USER_INFO_KEY} from "../config/constants";

const state ={
  userInfo : getItem(USER_INFO_KEY) ? JSON.parse(getItem(USER_INFO_KEY)) : {
    id: -1,
    username: ''
  },
  //打开的tabs数组
  openedTabs:[
    {
      //path 当前tab对应的route路径
      path:'/index',
      //tab的名字
      text:"首页",
      //当前tab对应的route全路径
      //如果path里面有值，path和fullpath就会不同
      fullPath:"/index"

    }
  ]
}
export default state
