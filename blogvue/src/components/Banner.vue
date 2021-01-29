<template>
  <div class="banner">
    <div class="banner-info">
      <div class="title">
        旋木頵頵的个人空间
      </div>
      <div class="description">
        Stay Hungry,Stay Foolish.
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "Banner"
}
</script>

<style scoped>
  .banner {
    width: 100%;
    height: 450px;
    display: flex;
    justify-content: center;
    align-items: center;
    background: url("../assets/banner.jpg") no-repeat center/cover;
    font-family: "Helvetica Neue",Helvetica,"PingFang SC","Hiragino Sans GB","Microsoft YaHei","微软雅黑",Arial,sans-serif;
  }
  .banner .title {
    font-size: xxx-large;
    color: white;


  }
  .banner .description {
    font-size: x-large;
    color: #66b1ff;
    margin-top: 15px;
  }
</style>