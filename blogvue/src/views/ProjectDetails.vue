<template>
  <div id="project-container">
    <el-container class="main-box">
      <el-header>
        <h1>
          SpringBoot+Vue博客系统
        </h1>
      </el-header>
      <el-main>
        <div class="technology">
          <el-tag v-for="item in tags" :type="item.type" class="tec-tag">{{ item.name }}</el-tag>
        </div>
        <div class="description">
          <span class="small-title">项目描述:</span>
          这是一个前后端分离的博客系统，主要应用的技术有springboot，vue，element-ui等
        </div>
        <div class="readme">
          <span class="small-title">项目文档:</span>
          <mavon-editor class="content-box"
                        :value="markdown"
                        :subfield="prop.subfield"
                        :defaultOpen="prop.defaultOpen"
                        :toolbarsFlag="prop.toolbarsFlag"
                        :editable="prop.editable"
                        :scrollStyle="prop.scrollStyle">

          </mavon-editor>
        </div>
        <div class="images">
          <el-carousel :interval="4000" type="card" height="200px">
            <el-carousel-item v-for="item in images">
              <el-image :src="item"></el-image>
            </el-carousel-item>
          </el-carousel>
          <span class="small-title">运行效果</span>
        </div>

        <div class="link">
          <span class="small-title">项目链接</span>
          <el-link type="primary" class="link-inner" href="https://github.com/alexyunyun/BookManageSystem">https://github.com/alexyunyun/BookManageSystem</el-link>
        </div>
      </el-main>
    </el-container>
  </div>
</template>

<script>

import markdown from '@/assets/SSM框架学习笔记.md'
export default {
  name: "ProjectDetails",
  data() {
    return {
      markdown,
      images: [
        'https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg',
        'https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg',
        'https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg',
        'https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg'

      ],
      tags: [
        {
          type: 'primary',
          name: 'SpringBoot'
        },
        {
          type: 'success',
          name: 'axios'
        },
        {
          type: 'info',
          name: 'Java'
        },
        {
          type: 'warning',
          name: 'Vue'
        },
        {
          type: 'danger',
          name: 'element-ui'
        }
      ]
    }
  },
  computed: {
    prop() {
      let settings = {
        subfield: false,// 单双栏模式
        defaultOpen: 'preview',//edit： 默认展示编辑区域 ， preview： 默认展示预览区域
        editable: false,
        toolbarsFlag: false,
        scrollStyle: true
      }
      return settings
    }
  },

}
</script>

<style scoped>
.main-box {
  text-align: center;
  width: 100%;
  background: white;
  border-radius: 3px;
  padding: 15px;
  font-family: "Helvetica Neue", Helvetica, "PingFang SC", "Hiragino Sans GB", "Microsoft YaHei", "微软雅黑", Arial, sans-serif;
}

.el-carousel__item h3 {
  color: #475669;
  font-size: 14px;
  opacity: 0.75;
  line-height: 200px;
  margin: 0;
}

.el-carousel__item:nth-child(2n) {
  background-color: #99a9bf;
}

.el-carousel__item:nth-child(2n+1) {
  background-color: #d3dce6;
}

.tec-tag {
  margin: 10px;
}

.description {
  font-size: large;
  margin-top: 20px;
  margin-bottom: 35px;
}
.images {
  margin-top: 50px;
  margin-bottom: 50px;
}
.images img {
  height: 100%;
  object-fit: cover;
}
.small-title {
  font-size: x-small;
  font-family: "Helvetica Neue", Helvetica, "PingFang SC", "Hiragino Sans GB", "Microsoft YaHei", "微软雅黑", Arial, sans-serif;
  color: #d1d1d1;
  margin: 15px 15px 20px;
}
.link {
  font-size: large;
}
.link .link-inner {
  text-decoration: none;
  font-size: medium;
}
.link-inner:hover {
  text-decoration: none;
}
.link-inner:visited {
  text-decoration: none;
}

.content-box {
  margin-top: 25px;
  width: 100%;
  border-radius: 5px;
}
</style>