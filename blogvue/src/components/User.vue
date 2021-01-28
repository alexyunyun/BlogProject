<template>
  <div id="user-container">
    <div class="user-box">
      <el-row>
        <el-card :body-style="{ padding: '14px' }">
          <img src="../assets/avatar.jpg" class="image" alt="用户头像">
          <div style="padding: 14px;">
            <span>旋木頵頵</span>
            <div class="bottom clearfix">
              <i class="iconfont icon-QQ"></i>
              <i class="iconfont icon-weixin"></i>
              <i class="iconfont icon-zhihu"></i>
              <a href="https://github.com/alexyunyun"><i class="iconfont icon-GitHub"></i></a>
            </div>
            <div class="footer">
              <i class="iconfont icon-email">Email订阅</i>

              <i class="iconfont icon-rss">RSS订阅</i>
            </div>
          </div>
        </el-card>
      </el-row>
    </div>
  </div>
</template>

<script>
export default {
  name: "User",
  data() {
    return {
      currentDate: new Date(),
      userInfo: {
        username: '旋木頵頵',
        email: '1020626977@qq.com',
        links: [
          {
            name: 'github',
            link: 'https://github.com/alexyunyun'
          },
          {
            name: '知乎',
            link: ''
          }
        ]
      }
    };
  }
}
</script>

<style scoped>
a {
  text-decoration: none;
}

a:hover {
  transform: scale(1.2);
  transition: .2s;
  text-decoration: none;
}

a:visited {
  text-decoration: none;
  border: none;
}

#user-container {
}

.user-box {
  width: 100%;
}

.bottom {
  display: flex;
  justify-content: space-around;
  align-items: start;
  margin-top: 13px;
  line-height: 12px;
  font-size: large;
}

.bottom i {
  font-size: x-large;
  cursor: pointer;
  color: #8cc5ff;
}

.footer {
  display: flex;
  justify-content: space-around;
  align-items: stretch;
  margin: 16px auto auto;
}

.footer i {
  font-size: medium;
  color: #ff6524;
}

.footer i:first-child {
  color: #66b1ff;
}

.image {
  margin: auto;
  width: 50%;
  display: block;
  border: 1px solid #E4E7ED;
  border-radius: 50%;
  overflow: hidden;
  object-fit: cover;
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