<template>
  <!--  项目添加页属于管理员功能，普通用户不可见-->
  <div class="edit-container">
    <el-container>
      <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
      <el-header>
        <div style="margin-top: 15px;" class="article-title">
          <el-input placeholder="项目标题" v-model="ruleForm.name" class="input-with-select">
          </el-input>
        </div>
      </el-header>
      <el-main>
        <div class="description">
          <el-input
              type="textarea"
              autosize
              placeholder="项目描述"
              v-model="ruleForm.description">
          </el-input>
        </div>
        <div class="edit-box">
          <mavon-editor class="content-box"
                        :scroll-style=prop.scrollStyle
                        :placeholder="placeholder"
          v-model="ruleForm.content"></mavon-editor>
        </div>

      </el-main>
      <el-main>
<!--        <div class="upload">-->
<!--          <el-upload-->
<!--              action="https://jsonplaceholder.typicode.com/posts/"-->
<!--              list-type="picture-card"-->
<!--              :on-preview="handlePictureCardPreview"-->
<!--              :on-remove="handleRemove">-->
<!--            <i class="el-icon-plus"></i>-->
<!--          </el-upload>-->
<!--          <el-dialog :visible.sync="dialogVisible">-->
<!--            <img width="100%" :src="dialogImageUrl" alt="">-->
<!--          </el-dialog>-->
<!--        </div>-->
        <div class="link">
          <el-input placeholder="项目链接" v-model="ruleForm.link"></el-input>
        </div>
        <el-row type="flex" justify="end" class="buttons">
          <el-col :span="3">
            <el-button type="danger" plain @click="goBack">返回</el-button>
          </el-col>
          <el-col :span="3">
            <el-button type="success" plain @click="submitForm('ruleForm')">发布</el-button>
          </el-col>
        </el-row>
      </el-main>
      </el-form>
    </el-container>
  </div>
</template>

<script>
export default {
  name: "ProjectAdd",
  data() {
    return {
      select: '',
      title: '',
      description:'',
      link:'',
      placeholder:'在此编写项目文档',
      dialogImageUrl: '',
      dialogVisible: false,
      ruleForm: {
        id: '',
        name: '',
        author: '',
        description:'',
        content: "",
        classify: '',
        time: ''
      },
      rules: {
        title: [
          {required: true, message: '请输入项目名称', trigger: 'blur'},
          {min: 1, max: 25, message: '项目名称长度过短或过长', trigger: 'blur'}
        ],

      }

    }
  },
  methods: {
    getNowFormatDate() {
      let date = new Date();
      let separator = "-";
      let year = date.getFullYear();
      let month = date.getMonth() + 1;
      let strDate = date.getDate();
      if (month >= 1 && month <= 9) {
        month = "0" + month;
      }
      if (strDate >= 0 && strDate <= 9) {
        strDate = "0" + strDate;
      }
      let currentDate = year + separator + month + separator + strDate;
      return currentDate;
    },
    handleRemove(file, fileList) {
      console.log(file, fileList);
    },
    handlePictureCardPreview(file) {
      this.dialogImageUrl = file.url;
      this.dialogVisible = true;
    },
    submitForm(formName) {
      const _this = this
      this.$refs[formName].validate((valid) => {
        if (valid) {

          _this.ruleForm.time = _this.getNowFormatDate()
          axios.post('http://localhost:8181/project/save', _this.ruleForm).then((res) => {
            console.log(res)
            if (res.data === "success") {
              this.$message({
                message: '添加项目成功',
                type: 'success'
              });
            }
            _this.$router.push('/admin/find_project')
          })
        } else {
          console.log('error submit!!');
          return false;
        }
      });
    },
    goBack() {
      this.$message({
        message: '您正在返回博客列表',
        type: 'warning'
      });
      _this.$router.push('/admin/find_blog')
    },
  },
  computed: {
    prop() {
      let settings = {
        subfield: true,// 单双栏模式

        defaultOpen: 'edit',//edit： 默认展示编辑区域 ， preview： 默认展示预览区域
        editable: true,
        toolbarsFlag: true,
        scrollStyle: true
      }
      return settings
    }
  },
}
</script>

<style scoped>
.el-select {
  width: 130px;
}
.input-with-select .el-input-group__prepend {
  background-color: #fff;
  width: 80%;
}

.content-box {
  width: 100%;
  border-radius: 5px;
  height: max-content;
  margin-top: 40px;
}
.buttons {
  margin: 20px;
}
.upload {
  background: white;
  padding: 20px;
  border-radius: 6px;
  margin-bottom: 20px;
}
</style>