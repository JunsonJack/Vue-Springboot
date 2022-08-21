//getters 其实就是对state数据的加工再处理，类比computed
export default {
  userInfo(state) {
    return state.userInfo
  },
  openedTabs: state => state.openedTabs
}
