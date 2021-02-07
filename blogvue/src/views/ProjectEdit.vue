<template>
  <!--  项目添加页属于管理员功能，普通用户不可见-->
  <div class="edit-container">
    <el-container>
      <el-header>
        <div style="margin-top: 15px;" class="article-title">
          <el-input placeholder="id" v-model="id" readonly style="margin-bottom: 15px"></el-input>
          <el-input placeholder="项目标题" v-model="title" class="input-with-select">
          </el-input>
        </div>
      </el-header>
      <el-main>
        <div class="description">
          <el-input
              type="textarea"
              autosize
              placeholder="项目描述"
              v-model="description">
          </el-input>
        </div>
        <div class="edit-box">
          <mavon-editor class="content-box"
                        :scroll-style=prop.scrollStyle
                        :placeholder="placeholder"></mavon-editor>
        </div>

      </el-main>
      <el-main>
        <div class="upload">
          <span class="small-title">在这里上传项目运行效果图</span>
          <el-upload
              action="https://jsonplaceholder.typicode.com/posts/"
              list-type="picture-card"
              :on-preview="handlePictureCardPreview"
              :on-remove="handleRemove">
            <i class="el-icon-plus"></i>
          </el-upload>
          <el-dialog :visible.sync="dialogVisible">
            <img width="100%" :src="dialogImageUrl" alt="">
          </el-dialog>
        </div>
        <div class="link">
          <el-input placeholder="项目链接" v-model="link"></el-input>
        </div>
        <el-row type="flex" justify="end" class="buttons">
          <el-col :span="3">
            <el-button type="danger" plain>返回</el-button>
          </el-col>
          <el-col :span="3">
            <el-button type="primary" plain>保存</el-button>
          </el-col>
          <el-col :span="3">
            <el-button type="success" plain>发布</el-button>
          </el-col>
        </el-row>
      </el-main>

    </el-container>
  </div>
</template>

<script>
export default {
  name: "ProjectEdit",
  data() {
    return {
      id:1,
      select: '',
      title: '',
      description:'',
      link:'',
      placeholder:'在此编写项目文档',
      dialogImageUrl: '',
      dialogVisible: false
    }
  },
  methods: {
    handleRemove(file, fileList) {
      console.log(file, fileList);
    },
    handlePictureCardPreview(file) {
      this.dialogImageUrl = file.url;
      this.dialogVisible = true;
    }
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
.article-title {
  margin-bottom: 25px;
  display: flex;
  flex-direction: column;
  justify-content: space-around;
  align-items: center;
  height: 100%;
}
.description {
  margin-top: 25px;
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
.small-title {
  font-size: x-small;
  font-family: "Helvetica Neue", Helvetica, "PingFang SC", "Hiragino Sans GB", "Microsoft YaHei", "微软雅黑", Arial, sans-serif;
  color: #d1d1d1;
  margin: 15px 15px 20px;
}
</style>