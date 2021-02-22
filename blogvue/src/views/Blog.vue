<template>
  <!--  博客详情页  -->
  <div class="blog-container">
    <div class="header-box">
      <div class="title-box">
        {{ article.title }}
      </div>
      <div class="info-box">
        发表于<span class="time">{{ article.created }}</span>
      </div>
    </div>

    <mavon-editor
        class="content-box"
        :value="article.content"
        :subfield="prop.subfield"
        :defaultOpen="prop.defaultOpen"
        :toolbarsFlag="prop.toolbarsFlag"
        :editable="prop.editable"
        :scrollStyle="prop.scrollStyle"
    ></mavon-editor>
  </div>
</template>

<script>
import Catalog from "@/components/Catalog";
import markdown from "@/assets/SSM框架学习笔记.md"

export default {
  name: "Blog",
  components: {
    Catalog
  },
  data() {
    return {
      article: {}
    }
  },
  created() {
    const _this = this
    axios.get('http://localhost:8181/blog/findById/' + _this.$route.query.id).then(function (res) {
      _this.article = res.data
    })
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
* {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
}
.content-box {
  width: 100%;
  border-radius: 5px;
  margin-bottom: 20px;
}
.header-box {
  background: #fbfbfb;
  box-shadow: 0 2px 4px rgba(0, 0, 0, .12), 0 0 6px rgba(0, 0, 0, .04);
  margin-bottom: 15px;
  border-radius: 5px;
  padding: 15px;
  text-align: center;
}
.title-box {
  font-size: x-large;
  font-family: "Helvetica Neue", Helvetica, "PingFang SC", "Hiragino Sans GB", "Microsoft YaHei", "微软雅黑", Arial, sans-serif;
  cursor: pointer;
  margin-bottom: 10px;
}

.info-box {
  background: #fbfbfb;
  font-size: medium;
}
.time {
  color: #67C23A;
}
</style>