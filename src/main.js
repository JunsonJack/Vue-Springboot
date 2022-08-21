// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.

//引入vue
import Vue from 'vue'
//引入App组件，他是所有组件的父组件
import  App from './App'
import router from './router'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import plugins from "./plugins/plugins";
import store from "./store";

//关闭vue的生产提示
Vue.config.productionTip = false
//引入elementUI
Vue.use(ElementUI,{size:'small'})
/* eslint-disable no-new */
Vue.use(plugins)
new Vue({
  el: '#app',
  //将App组件放入容器中
  render : h => h(App),
  router,
  store,
  components: { App },
  template: '<App/>'
})
