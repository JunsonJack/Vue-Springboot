<template>
  <div class="center-middle">
    <div>
      您好,<span class="user-name">{{userName}}</span>
      <h3 style="font-style: italic">欢迎使用</h3>
      <h1>学生成绩管理系统</h1>
    </div>
  </div>
</template>

<script>
    export default {
        name: "index",
        computed:{
            userName(){
              return this.$store.getters.userInfo.userName
            }
        }
    }
</script>

<style scoped>
  .center-middle{
    height: 90%;
    display: flex;
    justify-content: center;
    align-items: center;
  }
  h1,h2,h3,h4 {
    font-weight: normal;

  }
  .user-name{
    padding-left: 5px;
    color: red;
  }

</style>
