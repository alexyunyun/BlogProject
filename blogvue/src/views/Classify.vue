<template>
  <div id="classify-container">
    <h1>文章分类</h1>
    <div class="item-box">
      <ul class="ul-box">
        <li v-for="item in category" class="item-line">
          <el-link href="http://www.baidu.com" class="link" type="primary" :underline="false">{{item}}</el-link>
        </li>
      </ul>
    </div>
  </div>
</template>

<script>
export default {
  name: "Classify",
  data() {
    return {
      category: [
        'Java',
        'Vue',
        '数据库',
        'CSS',
        'HTML',
        'JavaScript'
      ]
    }
  }

}
</script>

<style scoped>
#classify-container {
  background: white;
  width: 100%;
  padding-top: 20px;
  border-radius: 3px;

}
.item-box {
  padding: 20px;
}
.item-line {
  text-align: left;
  padding-left: 25px;
  font-size: large;
  margin: 15px;
}
.link {
  font-size: large;
  text-decoration: none;
  text-underline: none;
}
.el-link--inner:hover {
  color: #fc7136;
}
</style>