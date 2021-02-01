<template>
  <div class="catalog-container">
    <div class="catalog-box">
      <el-row>
        <el-card :body-style="{ padding: '14px' }">
          <div style="padding: 14px;">
            <span class="catalog-title">文章目录</span>
            <div class="content clearfix">
              <el-link type="primary" class="content-item">1.Step1:克隆项目</el-link>
              <el-link type="primary" class="content-item">2.Step2:添加新的远程仓库</el-link>
              <el-link type="primary" class="content-item">3.Step3:拉取新的远程仓库</el-link>
              <el-link type="primary" class="content-item">4.Step4:切换到对应的分支</el-link>
              <el-link type="primary" class="content-item">5.Step5:提交修改，推送远程</el-link>
            </div>

            <div class="footer">
              <span class="footer-text">你已阅读了</span>
              <el-progress :percentage="50" id="progress"></el-progress>
            </div>
          </div>
        </el-card>
      </el-row>
    </div>
  </div>
</template>

<script>
export default {
  name: "Catalog"
}
</script>

<style scoped>
.catalog-title {
  display: block;
  font-size: large;
  margin-bottom: 25px;
  color: #fc6423;
}
.content {
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: start;
}
.content .content-item {
  font-size: medium;
  margin-bottom: 8px;
}
.footer {
  display: flex;
  flex-direction: column;
  justify-content: space-around;
  align-items: stretch;
  margin: 16px auto auto;
}
.clearfix:before,
.clearfix:after {
  display: table;
  content: "";
}

.clearfix:after {
  clear: both
}
</style>