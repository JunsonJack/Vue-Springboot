/**
 * 利用vue的插件机制来增加vue以及vue component的功能
 */
import {doGet,formPost,appJsonPost} from "../network/request";
export default {
  install(Vue){
    //将来在组件中就可以通过this.$doGet 来调用了,添加vue的原型对象
    Vue.prototype.$doGet = doGet
    Vue.prototype.$formPost = formPost
    Vue.prototype.$appJsonPost = appJsonPost
  }
}
