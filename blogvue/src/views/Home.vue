<template>
  <div class="home">
    <el-container>
      <el-main class="main">
        <List>文章列表</List>
      </el-main>
    </el-container>
  </div>
</template>

<script>
// @ is an alias to /src
import List from '../views/List'
import Banner from "@/components/Banner";
export default {
  name: 'Home',
  components: {
    List,
    Banner
  }
}
</script>
<style scoped>

</style>
