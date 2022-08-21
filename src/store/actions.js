import {STORE_USER_INFO} from "./mutation-type";

export default {
  storeUserInfo(context,payload){
    context.commit(STORE_USER_INFO,payload);
  },
  addTabIfNotExist(context,tabToAdd){
    //判断store里面是否已经有了这个要添加的tab
    let existFlag = context.state.openedTabs.some(obj => obj.path === tabToAdd.path);
    if (existFlag) {
        return
    }
    //不存在时加入
    context.commit("addTab",tabToAdd)
  },
  closeTab(context,tabName){
    context.commit("closeTab",tabName)
  }
}
