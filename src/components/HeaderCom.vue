<template>
  <div class="header-com">
    <el-row>
      <el-col :span="10" style="height: 60px">
        <img src="../assets/band.png" alt="" class="img">
      </el-col>
      <el-col :span="4" :offset="10" class="user-info">
        欢迎,<span class="user-name" >{{userInfo.userName}}</span>
      </el-col>
    </el-row>
  </div>
</template>

<script>
    import {mapGetters} from "vuex";

    export default {
        name: "HeaderCom",
      computed:{
        ...mapGetters(["userInfo"])

      }
    }
</script>

<style scoped>
  .user-info{
    text-align: right;
    line-height: 60px;
  }
  .user-name{
    padding-left: 5px;
    color: red;
    font-weight: bold;
  }
  .img{
    height: 100%;
    max-height: 100%;
  }

</style>
