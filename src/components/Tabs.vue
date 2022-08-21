<template>
    <div>
<!--      value:表示的是要激活name为activeTabName的tab-pane，
          保证了地址栏、tab的选中、内容区域的内容三者之间的联动
-->
      <el-tabs :value="activeTabName"
               @tab-click = "tabClick"
                @tab-remove="closeTab">
        <el-tab-pane
          v-for="item in openedTabs"
          :key="item.path"
          :label="item.text"
          :name="item.path"
          :closable="item.path !== '/index'"
        >

        </el-tab-pane>
      </el-tabs>
    </div>
</template>

<script>
    export default {
        name: 'Tabs',
        computed:{
          activeTabName(){
            //注意这里是$route不是$router
            return this.$route.path
          }
        },
      //监听当前路由的值
        watch:{
          //tab新增
          $route:{
            //页面一进来就监听
            immediate:true,
            handler(newValue,oldValue){
              //路由对象转成tab存储到vuex里面
              let tab = {
                path: newValue.path,
                text: newValue.meta.title,
                //用于保存地址栏的参数，用于回显
                fullPath: newValue.fullPath,
              }
              //如果打开了已存在的tab就不重新增加
              this.$store.dispatch("addTabIfNotExist",tab);
            }
          }

        },
        props:{
            "openedTabs":{
              type: Array,
              required: true
            }
        },
        methods:{
          //回显已有tab的内容
            tabClick(tab){
              let clickedTab = this.openedTabs.find(valObj => valObj.path === tab.name)
              this.$router.replace(clickedTab.fullPath)
            },
          //关闭tab
            closeTab(tabName){
              //关闭的不是激活项
              if (tabName !== this.activeTabName){
                this.$store.dispatch("closeTab",tabName)
                return
              }
              // 关闭后，激活紧挨着的左边的一个即可，找到关闭的tab数组下标，
              // 把激这个数组下标的前一个path给激活的path
              let tabToCloseIndex = this.openedTabs.findIndex(valObj => valObj.path === tabName);
              let tabToActive = this.openedTabs[tabToCloseIndex-1];
              //改变地址栏的地址
              this.$router.replace(tabToActive.fullPath)
              //关闭tab
              this.$store.dispatch("closeTab",tabName)

            }
        }
    }
</script>

<style scoped>

</style>
