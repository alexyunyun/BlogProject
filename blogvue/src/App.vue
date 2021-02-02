<template>
  <div id="app">

      <Header class="header">公共头部</Header>
    <div v-if="this.$route.path.match('/admin')">
      <router-view></router-view>
    </div>
    <div v-else>
      <Banner class="banner">BANNER</Banner>

      <el-container>
        <el-main>
          <el-row :gutter="40" >
            <el-col :span="6" :offset="1" id="fixed-box">
              <div>
                <div v-if="this.$route.path==='/blog'">
                  <Catalog id="catalog" class="fixed-box">文章目录</Catalog>
                  <Catalog id="empty-catalog" style="opacity: 0.0001;"></Catalog>
                </div>
                <div v-else-if="this.$route.path==='/'||this.$route.path.match('/project') || this.$route.path.match('/other')||this.$route.path.match('/catagory')">
                  <User id="fixed-user">用户信息框</User>
                  <User id="empty" style="opacity: 0.0001;"></User>
                </div>
                <div v-else>
                </div>
              </div>
            </el-col>
            <!-- 根据侧边栏有无的属性调整右栏的跨度 -->
            <el-col :span="this.aside?17:24">
              <router-view></router-view>
            </el-col>
          </el-row>
        </el-main>
      </el-container>
    </div>

    <Footer>公共底部</Footer>
    </div>
</template>

<script>
import Header from "@/components/Header";
import Home from "@/views/Home";
import Footer from "@/components/Footer";
import User from "@/components/User";
import Banner from "@/components/Banner";
import Catalog from "@/components/Catalog";

export default {
  name: 'app',
  components: {
    Catalog,
    Banner,
    Footer,
    Home,
    Header,
    User
  },
  data() {
    return {
      aside:true,
      boxWidth: null,
      catalogWidth: null
    }
  },
  methods: {
    handleScroll() {
      // js 代码
      // console.log("滑动时获取盒子" + document.querySelector("#fixed-user"))
      let demo = document.querySelector('#fixed-user')
      let empty = document.querySelector('#empty')
      let catalog = document.querySelector("#catalog")
      let emptyCatalog = document.querySelector("#empty-catalog")
      let clientHeight = document.documentElement.clientHeight
      let scroll = Math.floor(document.documentElement.scrollTop) //滚动条距离顶部的距离

      if (empty != null && empty.clientWidth !== 0) {
        this.boxWidth = empty.clientWidth
        console.log("保存下来的宽度为" + this.boxWidth)
      }
      if (emptyCatalog != null && emptyCatalog.clientWidth !== 0) {
        this.catalogWidth = emptyCatalog.clientWidth
        console.log("保存目录的宽度为" + this.catalogWidth)
      }

      if (demo != null && scroll>= 0.55 * clientHeight) {
        //当滚动条距离顶部的距离大于了有色框距离body上边框的距离，就让页面固定。
        console.log('现在滑动了' + scroll)
        demo.style.position = 'fixed'
        demo.style.width = this.boxWidth + 'px'
        demo.style.top = '100px'
        empty.style.opacity = '0'
      } else {
        if (demo != null) {
          demo.style.position = 'relative'
          demo.style.width = '100%'
          empty.style.width = '0'
          demo.style.top = '0'
        }
      }
      console.log("对catalog定位")
      if (catalog != null && scroll>= 0.55 * clientHeight) {
        console.log("固定定位")
        catalog.style.position = 'fixed'
        catalog.style.width = this.catalogWidth + 'px'
        catalog.style.top = '100px'
      } else {
        if (catalog!=null){
          catalog.style.position = 'relative'
          catalog.style.width = '100%'
          catalog.style.top = '0'
        }

      }
    }
  },
  mounted() {
    window.addEventListener('scroll', this.handleScroll)
  },
  created() {
    //加载时判断是否为博客编辑页
    //若为博客编辑页则去掉侧边栏
    if (this.$route.path.match('/blog_edit')){
      this.aside=false
    }
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
  background: #efefef;
}

body {
  margin: 0;
}

.header {
  position: fixed;
  top: 0;
  z-index: 9999;
}

</style>
