<template>
  <div class="login">
    <img src="../assets/login.png" class="img-fluid"/>
    <el-form :model="formData" :rules="rules" ref="loginForm" >
      <el-form-item label="用户名" prop="userName">
      <el-input v-model="formData.userName"
                type="text"
                placeholder="请输入用户名"
                size="medium"
                clearable>
        <template slot="prepend"><i class="el-icon-user-solid"></i></template>
<!--        使用插槽slot，在input前面prepend-->

      </el-input>
    </el-form-item>
      <el-form-item label="密码" prop="pwd">
        <el-input v-model="formData.pwd"
                  type="password"
                  placeholder="请输入密码"
                  size="medium"
                  show-password
                  clearable>
<!--          显示密码小眼睛  show-password-->
          <template slot="prepend"><i class="el-icon-lock"></i></template>
        </el-input>
      </el-form-item>
      <el-form-item>
        <div class="btn-group">
          <el-button type="success" size="medium" @click="submitForm">
            登录
          </el-button>
          <el-button type="primary" size="medium" @click="resetForm">
           重置
          </el-button>
        </div>
      </el-form-item>
    </el-form>

  </div>

</template>

<script>
    import {saveItem} from "../storage";
    import {USER_TOKEN_KEY} from "../config/constants";

    export default {
        name: "Login",
      data() {
        return {
          formData: {
            userName: '',
            pwd: ''
          },
          rules: {
            userName: [
              { required: true, message: '请输入用户名', trigger: 'blur' },

            ],
            pwd: [
              { required: true, message: '请输入密码', trigger: 'blur' },

            ],
          }
        };
      },
      methods: {
        submitForm() {
          //对表单进行规则校验validate
          this.$refs["loginForm"].validate((valid) => {
            if (valid) {
              //校验通过
              this.$appJsonPost({
                url:'/manager/login',
                data:this.formData
              }).then(result =>{
                console.log(result)
                this.$store.dispatch("storeUserInfo",result.data)
                saveItem(USER_TOKEN_KEY,result.data.token)
                this.$router.replace("/index")
              }).catch(err =>{})
            }
          });
        },
        resetForm() {
          this.$refs["loginForm"].resetFields();
        }
      }

    }
</script>

<style scoped>
  .login{
    width: 350px;
    position: absolute;
    left: 50%;
    top: 50%;
    transform: translate(-50%,-50%);
  }
  .img-fluid{
    width: 100%;
  }
  .btn-group{
    display: flex;
    justify-content: space-around;
  }

</style>
