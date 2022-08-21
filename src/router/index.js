import Vue from 'vue'
import VueRouter from 'vue-router'
import Login from "../views/Login";
import Main from "../views/Main";
import StudentHome from "../views/student/StudentHome";
import StudentManage from "../views/student/StudentManage";
import Index from "../views/index/Index";
import ScoreHome from "../views/score/ScoreHome";
import ScoreManage from "../views/score/ScoreManage";
import AddScore from "../views/score/AddScore";
import UpdateScore from "../views/score/UpdateScore";
import {getItem} from "../storage";
import {USER_TOKEN_KEY} from "../config/constants";
/**
 * nprogress 加载进度条
 * 引入nprogress的js和css后
 * 开始和结束分别调用Nprogress.start()和Nprogress.done()即可
 */
import Nprogress from "nprogress";
import 'nprogress/nprogress.css';

Vue.use(VueRouter)
//定义；路由规则
const  routes =[
  //重定向路由
  {
    path: '/',
    redirect: '/login'
  },
  //登录路由
  {
    path: '/login',
    component: Login,
    name: 'Login',
    meta: {
      title : ' 登录'
    },
  }, //路由
  {
    path: '/',
    component: Main,
    name: 'Main',
    children : [
      {
        path: 'index',
        component: Index,
        name: 'Index',
        meta: {
          title : ' 首页'
        }
      },
      {
        path: 'student',
        name: 'StudentHome',
        component: StudentHome,
        children : [
          {
            path: 'manage',
            component: StudentManage,
            name: 'StudentManage',
            meta: {
              title : '学生管理'
            }
          }
        ]
      },
      {
        path: 'score',
        name: 'ScoreHome',
        component: ScoreHome,
        children : [
          {
            path: 'manage',
            component: ScoreManage,
            name: 'ScoreManage',
            meta: {
              title : '成绩管理'
            }
          },
          {
            path: 'add',
            component: AddScore,
            name: 'AddScore',
            meta: {
              title : '添加成绩'
            }
          },
          {
            path: 'manage',
            component: UpdateScore,
            name: 'UpdateScore',
            meta: {
              title : '修改成绩'
            }
          }

        ]
      }

    ]
  }
]
const router = new VueRouter({
  routes
})

const IGNORE_URLS = ['/','/login']
//前置守卫 进行权限控制
router.beforeEach((toRoute,fromRoute,next) =>{
  Nprogress.start();
  if (IGNORE_URLS.includes(toRoute.path)) {
    //要访问的路径在要忽略的URL中
    next()
  }else {
     let token = getItem(USER_TOKEN_KEY);
     if (token) {
         return next()
     }
     //无权限跳转到登录页面,/
    return next({path:IGNORE_URLS[0]})
  }
})

//后置守卫
router.afterEach((toRoute,fromRoute) => {
  Nprogress.done();
  document.title = toRoute.meta.title
})
export default router
