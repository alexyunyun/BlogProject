<template>
  <!--  编辑页属于管理员功能，普通用户不可见-->
  <div class="edit-container">
    <el-container>
      <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
        <el-header>
          <div style="margin-top: 15px;" class="article-title">
            <el-input placeholder="文章标题" v-model="ruleForm.title" class="input-with-select">
              <el-select v-model="ruleForm.select" slot="prepend" placeholder="类型">
                <el-option label="原创" value="原创"></el-option>
                <el-option label="转载" value="转载"></el-option>
              </el-select>
            </el-input>
          </div>
        </el-header>
        <el-main>
          <div class="edit-box">
            <el-input type="textarea" v-model="ruleForm.description" class="desc-box" placeholder="在这里填写博客简介"></el-input>
            <mavon-editor class="content-box"
                          :scroll-style=prop.scrollStyle
                          :value="ruleForm.content"
                          v-model="ruleForm.content"
            ></mavon-editor>
          </div>

        </el-main>
        <el-main>


          <el-row :gutter="20">
            <el-col :span="12">
              <div class="article-type">
                <el-input placeholder="分类" v-model="ruleForm.classify">
                  <template slot="prepend" type="primary"><i class="el-icon-folder-opened
" style="font-size: large"></i></template>
                </el-input>
              </div>
            </el-col>
            <el-col :span="12">
              <div class="article-tag">
                <el-input placeholder="标签" v-model="ruleForm.tags">
                  <template slot="prepend"><i class="el-icon-collection-tag" style="font-size: large"></i></template>
                </el-input>
              </div>
            </el-col>
          </el-row>
          <el-row type="flex" justify="end" class="buttons">
            <el-col :span="2">
              <el-button type="danger" plain @click="goBack">返回</el-button>
            </el-col>
            <!--            <el-col :span="2">-->
            <!--              <el-button type="primary" plain>保存</el-button>-->
            <!--            </el-col>-->
            <el-col :span="2">
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
  name: "BlogEdit",
  data() {
    return {
      ruleForm: {
        id: '',
        title: '',
        select: '',
        author: '',
        description:'',
        content: "",
        classify: '',
        tag: '',
        created: ''
      },
      rules: {
        title: [
          {required: true, message: '请输入博客名称', trigger: 'blur'},
          {min: 1, max: 25, message: '博客名称长度过短或过长', trigger: 'blur'}
        ],

      }
    }
  },
  created() {
    // const _this = this
    // axios.get('http://localhost:8181/blog/findById/' + _this.$route.query.id).then(function (res) {
    //   _this.ruleForm = res.data
    // })
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
  methods: {
    goBack() {
      this.$message({
        message: '您正在返回博客列表',
        type: 'warning'
      });
      _this.$router.push('/admin/find_blog')
    },
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
    submitForm(formName) {
      const _this = this
      this.$refs[formName].validate((valid) => {
        if (valid) {

          _this.ruleForm.created = _this.getNowFormatDate()
          axios.post('http://localhost:8181/blog/save', _this.ruleForm).then((res) => {
            console.log(res)
            if (res.data === "success") {
              this.$message({
                message: '添加博客成功',
                type: 'success'
              });
            }
            _this.$router.push('/admin/find_blog')
          })
        } else {
          console.log('error submit!!');
          return false;
        }
      });
    },
  }
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

.edit-box {
  margin-top: 20px;
}
.desc-box {
  margin-top: 15px;
  margin-bottom: 15px;
}
.content-box {
  width: 100%;
  border-radius: 5px;
  height: max-content;
}

.buttons {
  margin: 20px;
}
</style>