<template>
  <div>
    <section class="title-bar">
      <el-row>
        <!--        新增按钮-->
        <el-col :span="2">
          <el-button @click="toAdd" type="primary" icon="el-icon-plus">
            新增
          </el-button>
        </el-col >
        <!--        搜索框-->
        <el-col :span="22">
          <el-form :model="searchFormData" :inline="true">
            <el-form-item>
              <el-input type="text" placeholder="请输入学生姓名模糊搜索"
                        v-model="searchFormData.searchWord">
              </el-input>
            </el-form-item>
            <el-form-item>
              <el-button @click="doSearch" type="primary" >
                查询
              </el-button>
            </el-form-item>
          </el-form>
        </el-col>
      </el-row>
    </section>

    <!--    表格-->
    <section>
      <el-table
        :data="tableData.rows"
        stripe
        border
        size="mini"
        style="width: 100%">
        <el-table-column
          prop="id"
          label="系统编号"
          width="180">
        </el-table-column>
        <el-table-column
          prop="studentName"
          label="学生姓名"
        >
        </el-table-column>
        <el-table-column
          prop="examName"
          label="考试名称">
        </el-table-column>
        <el-table-column
          prop="cnScore"
          label="语文成绩">
        </el-table-column>
        <el-table-column
          prop="mathScore"
          label="数学成绩">
        </el-table-column>
        <el-table-column
          prop="enScore"
          label="英语成绩">
        </el-table-column>

        <el-table-column label="操作">
          <template slot-scope="scope">
            <el-button
              type="primary"
              size="mini"
              icon="el-icon-edit"
              @click="handleEdit(scope.$index, scope.row)">编辑</el-button>
            <el-button
              size="mini"
              type="danger"
              icon="el-icon-delete"
              @click="handleDelete(scope.$index, scope.row)">删除</el-button>
          </template>
        </el-table-column>
      </el-table>
    </section>

    <!--    分页-->
    <section>
      <el-pagination
        @size-change="handlePageSizeChange"
        @current-change="handlePageNowChange"
        :current-page="searchFormData.pageNow"
        :page-sizes="[5, 10, 15, 20]"
        :page-size="searchFormData.pageSize"
        layout="total, sizes, prev, pager, next, jumper"
        :total="tableData.total">
      </el-pagination>
    </section>


  </div>

</template>

<script>
    export default {
        name: "ScoreManage",
      data(){
        return {
          searchFormData:{
            pageNow: 1,
            pageSize: 10,
            searchWord: ''
          },
          tableData:{
            rows:[],
            total:0
          }
        }
      },
        methods:{
          doSearch(){
            //重新加载表格
            this.loadTable()
          },
          loadTable(){
            this.$appJsonPost({
              url:'/score/selectPage',
              data:this.searchFormData
            }).then(result =>{
              if (result.data ){
                this.tableData.rows = result.data;
                this.tableData.total = result.total
              }
            })
          },
          toAdd(){
            this.$router.replace('/score/add')
          },
          handleEdit(index,row){
            //跳转到修改成绩
            this.$router.replace({
              name:'UpdateScore',
              query:{
                idToUpdate: row.id

              }
            })

          },
          handleDelete(index,row){
            this.$confirm("确认要删除吗？","提示",{
              confirmButtonText:'确定',
              cancelButtonText:'取消',
              type:'warning'
            }).then(() =>{
              //console.log('点了确定')
              this.$doGet({
                url: 'score/deleteById',
                params:{'id':row.id}
              }).then(result => {
                this.$message.success(result.data);
                this.loadTable()
              })
            }).catch(() =>{
              // console.log('点了取消')
            })
          },
          //当前要变成x条每一页,则pageSize的值就是x
          handlePageSizeChange(pageSize){
            this.searchFormData.pageSize = pageSize;
            this.loadTable()
          },
          //当前要前往第几页，则此处的pageNow值就是x
          handlePageNowChange(pageNow){
            this.searchFormData.pageNow = pageNow;
            this.loadTable()
          }
      },
      created() {
          this.loadTable()
      }
    }
</script>

<style scoped>

</style>
