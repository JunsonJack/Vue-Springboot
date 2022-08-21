<template>
  <div>
<!--    对话框是否可见用addDiaVisible控制-->
    <el-dialog title="新增学生" :visible="addDiaVisible" :before-close="handleCancel" >
      <el-form :model="formData" :rules="rules" label-width="120px" ref="addForm" >
        <el-form-item label="学号:" prop="no">
          <el-input v-model="formData.no"/>
        </el-form-item>
        <el-form-item label="姓名:" prop="realName">
          <el-input v-model="formData.realName"></el-input>
        </el-form-item>
        <el-form-item label="入学日期:" prop="enrollTime">
          <el-date-picker type="date"
                          v-model="formData.enrollTime"
                          :editable="true"
                          prefix-icon="el-icon-date"
                          value-format="yyyy-MM-dd"
          >

          </el-date-picker>
        </el-form-item>
      </el-form>
      <div slot="footer">
        <el-button @click="handleCancel">取消</el-button>
        <el-button type="primary" @click="onSubmit">确定</el-button>
      </div>
    </el-dialog>
  </div>

</template>

<script>
    import {saveItem} from "../../storage";
    import {USER_TOKEN_KEY} from "../../config/constants";

    export default {
        name: "AddStudent",
        data(){
          return{
            formData:{
              no:'',
              realName:'',
              enrollTime:''
            },
            rules: {
              no: [
                {required: true, message: '请输入学号', trigger: 'blur' },
              ],
              realName: [
              {required: true, message: '请输入姓名', trigger: 'blur' },
              ],
              enrollTime: [
                {required: true, message: '请选择入学日期', trigger: 'blur' },
              ]

          }
          }
        },
        props:{
          addDiaVisible:{
            default: false
          }
        },
      methods:{
          onSubmit(){
            this.$refs["addForm"].validate((valid) => {
            //对表单进行规则校验validate
              if (!valid) return
                //校验不通过
                this.$appJsonPost({
                  url:'/student/add',
                  data:this.formData
                }).then(result => {
                  //成功了以后重置一下
                  this.$message.success(result.data);
                  this.$refs["addForm"].resetFields()
                  this.$emit("addSuccess")
                }).catch(result =>{})
            });
          },
        handleCancel(){
          this.$refs["addForm"].resetFields()
          this.$emit("update:addDiaVisible",false)

        }
      }
    }
</script>

<style scoped>

</style>
