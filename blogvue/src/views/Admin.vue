<template>
  <div id="admin-container">
    <el-container style="height: 100%; border: 1px solid #eee">
      <el-aside class="aside" width="200px" style="height: 100%">
        <el-menu
            default-openeds="['0','1']"
            default-active="/admin/find_blog"
            class="el-menu-vertical-demo"
            router
        >
          <el-submenu index="0">
            <template slot="title"><i class="el-icon-setting"></i> 管理员选项</template>
            <el-menu-item v-for="(item,index) in $router.options.routes[7].children" :index="item.path" v-if="item.show">
              <i class="el-icon-ice-drink"></i>
              <span slot="title">{{ item.name }}{{ index }}</span>
            </el-menu-item>
          </el-submenu>
        </el-menu>
      </el-aside>
      <el-container>
        <el-main>
          <router-view></router-view>
        </el-main>
      </el-container>
    </el-container>
  </div>
</template>

<script>
export default {
  name: "AdminIndex",

}
</script>

<style scoped>
* {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
}

#admin-container {
  width: 100%;
  margin-top: 50px;
  padding: 20px;
}

.aside {
  margin-top: 50px;
  position: sticky;
  position: -webkit-sticky;
  top: 150px;
}
</style>