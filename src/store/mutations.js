import {STORE_USER_INFO} from "./mutation-type";
export default {
  [STORE_USER_INFO](state,userInfo){
    state.userInfo = userInfo;
  },
  addTab(state,tabToAdd){
    state.openedTabs.push(tabToAdd)
  },
  closeTab(state,tabName){
    state.openedTabs= state.openedTabs.filter(val => val.path !== tabName)
  }
}
