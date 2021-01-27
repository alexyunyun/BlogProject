<template>
  <div class="home">
    <img alt="Vue logo" src="../assets/logo.png">
    <List>文章列表</List>
  </div>
</template>

<script>
// @ is an alias to /src
import List from '../views/List'
export default {
  name: 'Home',
  components: {
    List,
  }
}
</script>
