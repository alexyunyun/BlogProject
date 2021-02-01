<template>
  <!--  博客详情页  -->
  <div class="blog-container">
      <mavon-editor
          class="content-box"
          :value="markdown"
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
      markdown,
      value: '## 标题二',
      articleDetail: {
        context: '### 标题三'
      }
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
.content-box {
  width: 100%;
  border-radius: 5px;
}
</style>