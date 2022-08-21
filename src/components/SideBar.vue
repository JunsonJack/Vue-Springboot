<template>
    <div>
<!--      侧边折叠-->
      <div class="collapse">
        <span
          @click="toggleCollapse"
          :class="isCollapsed?'el-icon-d-arrow-right':'el-icon-d-arrow-left'">
        </span>
      </div>
<!--      菜单列表-->
      <el-menu
        :default-active="activeName"
        :collapse="isCollapsed"
        :collapse-transition="false"
        text-color="#fff"
        active-text-color="#ffd04b">
        <el-menu-item :index="item.path"
                      v-for="item in menuList"
                      :key="item.path"
                      @click="clickMenuItem(item)"
        >
          <i :class="item.iconClassName"></i>
          <span slot="title">{{item.menuName}}</span>
        </el-menu-item>

<!--        退出-->
        <div @click="logout">
          <el-menu-item index="logout">
            <i class="el-icon-unlock"></i>
            <span slot="title">退出</span>
          </el-menu-item>
        </div>

      </el-menu>
    </div>
</template>

<script>
  import menuList from "../config/menuList";
  import {clearAll} from "../storage";
    export default {
        name: "SideBar",
        data(){
          return {
            menuList: menuList,
            //true表示折叠
            isCollapsed: false
          }
        },
      computed:{
          //当前应该激活哪一个菜单项
        activeName(){
          return this.$route.path
        }
      },
        methods:{
          toggleCollapse(){
            //修改el-aside的宽度
            if (this.isCollapsed){ //折叠的
             this.$emit("update:asideWidth","200px")
            }else {
              this.$emit("update:asideWidth","65px")
            }
          this.isCollapsed = !this.isCollapsed
          },
          clickMenuItem(item){
            this.$router.replace({
              name : item.comName
            })
          },
          logout(){
            //清除session storage里面的信息
            clearAll()
            //返回到登录页面
            this.$router.replace("/")
          }

        }
    }
</script>

<style scoped>
  .collapse{
    background-color: rgb(110,170,220);
    padding: 8px;
    color: #ffffff;
    text-align: center;
    cursor: pointer;
    line-height: 1.5;
  }
  /* 避免el-menu-item 选中的时候多1px*/
  .el-menu{
    border-right-width: 0;
  }
/*侧边栏背景*/
  aside ul,aside li {
    background-color: #003c7f;
  }
  /*多级菜单悬浮/激活时的背景*/
  li.el-submenu >>> .el-submenu_title:hover{
    background-color: rgb(0,48,102) !important;
  }

  .el-menu-item:focus,.el-menu-item:hover,.el-menu-item.is-active{
    background-color: rgb(0,48,102) !important;
  }
</style>
