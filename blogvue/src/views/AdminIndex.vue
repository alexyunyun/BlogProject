<template>
  <div id="admin-container">
    <el-container style="border: 1px solid #eee">
      <el-aside class="aside">
        <el-menu :default-openeds="['0']" default-active="0" router>
          <el-submenu  v-for="(item,index) in $router.options.routes" :index="index+''" v-if="item.children!=null">
            <template slot="title"><i class="el-icon-setting"></i>{{ item.name }}</template>
            <el-menu-item-group>
              <el-menu-item v-for="(item2,index2) in item.children" index="index2" :index="item2.path"
                            :class="$route.path===item2.path?'is-active':''">{{ item2.name }}</el-menu-item>
            </el-menu-item-group>
          </el-submenu>
        </el-menu>
      </el-aside>
    </el-container>
  </div>
</template>

<script>
export default {
  name: "AdminIndex",

}
</script>

<style scoped>
#admin-container {
  width: 100%;
  margin: 50px;
  padding: 50px;
}
.aside {
  width: max-content !important;
}
</style>