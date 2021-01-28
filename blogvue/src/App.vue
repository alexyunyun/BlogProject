<template>
  <div id="app">
    <Header>公共头部</Header>
    <el-container>
      <el-main>
        <el-row :gutter="20">
          <el-col span="5">
            <User id="fixed-user">用户信息框</User>
          </el-col>
          <el-col span="15">
            <router-view></router-view>
          </el-col>
        </el-row>
      </el-main>

    </el-container>
    <Footer>公共底部</Footer>

    <!--    <el-container>-->
    <!--      <el-header><Header>公共头部</Header></el-header>-->
    <!--      <el-container>-->
    <!--        <el-aside width="200px"><User>用户信息框</User></el-aside>-->
    <!--        <el-container>-->
    <!--          <el-main><router-view></router-view></el-main>-->

    <!--        </el-container>-->
    <!--        <el-footer><Footer>公共底部</Footer></el-footer>-->
    <!--      </el-container>-->
    <!--    </el-container>-->
  </div>
</template>

<script>
import Header from "@/components/Header";
import Home from "@/views/Home";
import Footer from "@/components/Footer";
import User from "@/components/User";

export default {
  name: 'app',
  components: {
    Footer,
    Home,
    Header,
    User
  }
}
</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

body {
  margin: 0;
}

#fixed-user {

}
</style>
