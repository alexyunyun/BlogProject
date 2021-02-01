<template>
  <div id="header-container">
    <header>
      <div class="left-info">
        <a class="home-link" href="/">
          <img src="../assets/avatar.jpg" alt="旋木頵頵的个人空间" class="avatar">
          <h3>旋木頵頵的个人空间</h3>
        </a>

      </div>

      <div class="middle-box">
        <el-menu
            :default-active="activeIndex2"
            class="el-menu-demo"
            mode="horizontal"
            @select="handleSelect"
            background-color="#181818"
            text-color="#fff"
            active-text-color="#3eaf7c"
            router>
          <el-menu-item index="/" :class="$route.path==='/'?'is-active':''"><i class="el-icon-s-home"></i>主页
          </el-menu-item>
          <el-submenu index="/classify" :class="$route.path==='/classify'?'is-active':''">
            <template slot="title"><i class="el-icon-paperclip"></i>分类</template>
            <el-menu-item v-for="(item,index) in catagory" :index="'catagory_details/'+item"><i
                class="el-icon-folder"></i>{{ item }}
            </el-menu-item>
          </el-submenu>
          <!--          <el-menu-item index="/classify" :class="$route.path==='/classify'?'is-active':'no'"><i class="el-icon-paperclip"></i>文章分类</el-menu-item>-->
          <el-submenu index="/project" :class="$route.path==='/project'?'is-active':''">
            <template slot="title"><i class="el-icon-cpu"></i>实验室</template>
            <el-menu-item v-for="(item,index) in projects" :index="'project_details/'+item.id"><i
                class="el-icon-folder"></i>{{
                item.name
              }}
            </el-menu-item>
          </el-submenu>

          <el-menu-item index="/about" :class="$route.path==='/about'?'is-active':''"><i class="el-icon-user-solid"></i>关于
          </el-menu-item>
          <el-menu-item index="/other" :class="$route.path==='/other'?'is-active':''"><i class="el-icon-ice-cream"></i>其他
          </el-menu-item>
        </el-menu>
      </div>
      <div class="right-box">
        <el-input
            placeholder="在这里输入关键词搜索"
            v-model="input"
            clearable
            class="input-box"
        >
          <i slot="prefix" class="el-input__icon el-icon-search"></i>
        </el-input>

      </div>
      <div class="clear-fix"></div>

    </header>
  </div>
</template>

<script>
export default {
  name: "Header",
  data() {
    return {
      input: '',
      activeIndex: '1',
      activeIndex2: '/',
      projects: [
        {
          'id': '0',
          'name': '图书管理系统',
          'description': 'SpringBoot+Vue前后端分离的图书管理系统',
          'link': 'github'
        },
        {
          'id': '1',
          'name': '个人博客系统',
          'description': 'SpringBoot+Vue前后端分离的图书管理系统',
          'link': 'github'
        },
        {
          'id': '2',
          'name': '寻Ta微信小程序',
          'description': 'SpringBoot+Vue前后端分离的图书管理系统',
          'link': 'github'
        },
      ],
      catagory: [
        'Java',
        'Vue',
        '数据库'
      ]
    }
  },
  methods: {
    handleSelect(key, keyPath) {
      console.log(key, keyPath);
    }
  }
}
</script>

<style scoped>

body {
  margin: 0;
  padding: 0;
}

div {
  margin: 0;
  padding: 0;
}

.clear-fix {
  clear: both;
}

#header-container {
  width: 100%;
  background: #181818;
  display: flex;
  align-items: center;
  justify-content: center;
}


.left-info {
  width: 30%;
  height: 100%;
  float: left;
  display: flex;
  justify-content: left;
  align-items: center;
  text-align: left;
  color: #d1d1d1;
  vertical-align: middle;
}

.home-link {
  text-decoration: none;
  display: flex;
  justify-content: flex-start;
  align-items: center;
  margin-left: 20px;
}

.home-link:hover {
  color: #d1d1d1;
  cursor: pointer;
}

.home-link:visited {
  color: #d1d1d1;
}

.home-link:hover {
  color: #d1d1d1;
  cursor: pointer;
}

.left-info .home-link .avatar {
  vertical-align: middle;
  margin-right: 3%;
  margin-left: 5%;
  width: 10%;
  object-fit: cover;
  border-radius: 50%;
  float: left;
}

.middle-box {
  width: 50%;
  height: 100%;
  float: left;
}

.middle-box .el-menu-demo {
  float: left;
  border: none;
  vertical-align: baseline;
  font-size: xx-large;
  font-weight: bold;
  text-align: center;
  margin-right: 20px;
}

.right-box .input-box {
  display: inline-block;
  text-align: center;
  vertical-align: middle;
  width: 100%;
  margin: 10px auto;
}

.right-box {
  width: 18%;
  float: left;
  margin-right: 20px;
}


</style>