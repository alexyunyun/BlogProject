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
          <el-row :gutter="40">
            <el-col :span="6" :offset="1" id="fixed-box">
              <div>
                <div v-if="this.$route.path==='/blog'">
                  <Catalog id="catalog" class="fixed-box" style="opacity: 0.0001;">文章目录</Catalog>
                  <Catalog id="empty-catalog" v-show="heightOver===true"></Catalog>
                </div>
                <div
                    v-else-if="this.$route.path==='/'||this.$route.path.match('/project_details') || this.$route.path.match('/other')||this.$route.path.match('/classify')">
                  <User id="fixed-user" class="fixed-box" style="opacity: 0.0001;">用户信息框</User>
                  <User id="empty"></User>

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
      aside: true,
      boxWidth: null,
      catalogWidth: null,
      heightOver: false
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
      let banner = document.querySelector('.banner')
      let header = document.querySelector('.header')
      let clientHeight = document.documentElement.clientHeight
      let bannerHeight = 0
      if (banner!=null){
        bannerHeight = banner.offsetHeight
      }

      console.log(clientHeight)
      let scroll = Math.floor(document.documentElement.scrollTop) //滚动条距离顶部的距离

      this.heightOver = scroll > 1.2 * bannerHeight;
      if (empty != null && empty.clientWidth !== 0) {
        this.boxWidth = empty.clientWidth
        console.log("保存下来的宽度为" + this.boxWidth)
      }
      if (emptyCatalog != null && emptyCatalog.clientWidth !== 0) {
        this.catalogWidth = emptyCatalog.clientWidth
        console.log("保存目录的宽度为" + this.catalogWidth)
      }

      if (demo != null && scroll > bannerHeight) {
        //当滚动条距离顶部的距离大于了有色框距离body上边框的距离，就让页面固定。
        console.log('现在滑动了' + scroll + 'clientHeight' + clientHeight)
        demo.style.opacity = "1"
        empty.style.opacity = "0"
        demo.style.width = this.boxWidth + 'px'

      } else {
        if (demo != null) {
          demo.style.opacity = "0"
          empty.style.opacity = "1"

        }
      }
      console.log("对catalog定位")
      if (catalog != null && scroll > bannerHeight) {
        console.log("固定定位")
        catalog.style.opacity = "1"
        catalog.style.width = this.catalogWidth + 'px'
        emptyCatalog.style.opacity = "0"
      } else {
        if (catalog != null) {
          catalog.style.opacity = "0"
          emptyCatalog.style.opacity = "1"
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
    if (this.$route.path.match('/blog_edit')) {
      this.aside = false
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
  padding: 0;
  box-sizing: border-box;
}

.header {
  position: fixed;
  top: 0;
  z-index: 9999;
}

.fixed-box {
  position: fixed;
  top: 100px;
}

</style>
