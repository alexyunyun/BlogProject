<template>
  <div id="app">
    <Header>公共头部</Header>
<Home></Home>
    <Footer>公共底部</Footer>
  </div>
</template>

<script>
import Header from "@/components/Header";
import Home from "@/views/Home";
import Footer from "@/components/Footer";

export default {
  name: 'app',
  components: {
    Footer,
    Home,
    Header,
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
</style>
