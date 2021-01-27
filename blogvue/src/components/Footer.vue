<template>
  <div id="footer-container">
    <footer>
      Copyright &copy 2020~2021
      <div class="footer-link">
        <i class="el-icon-umbrella"></i>
        <el-link id="link" type="primary" href="https://github.com/alexyunyun">旋木頵頵</el-link>
      </div>
    </footer>
  </div>
</template>

<script>
export default {
  name: "Footer"
}
</script>

<style scoped>
body{
  margin: 0;
  padding: 0;
}
#footer-container {
  width: 100%;
}
  footer {
    background-color: #181818;
    color: #fff;
    font-size: medium;
    padding: 15px;
  }
  .footer-link {
    display: inline-block;
    justify-content: center;
    align-items: center;
    font-size: medium;
    vertical-align: center;
    margin-top: 10px;
    margin-left: 10px;
  }
  .footer-link i {
    vertical-align: middle;
    margin-right: 5px;
  }
  #link {
    font-size: medium;
  }
</style>