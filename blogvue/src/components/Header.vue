<template>
  <div id="header-container">
    <header>
      <div class="left-info">
        <img src="../assets/avatar.jpg" alt="旋木頵頵的个人空间" class="avatar">
        <h3>旋木頵頵的个人空间</h3>
      </div>
      <div class="clear-fix"></div>

    </header>
  </div>
</template>

<script>
export default {
  name: "Header",
  data () {
    return {
      url: "../assets/avatar.jpg"
    }
  }
}
</script>

<style scoped>
body {
  margin: 0;
  padding: 0;
}

.clear-fix {
  clear: both;
}

#header-container {
  width: 100%;
  background: #181818;
}

header img {
  width: 6%;
  object-fit: cover;
  border-radius: 50%;
  float: left;
}

.left-info {
  width: 50%;
  float: left;
  display: flex;
  justify-content: left;
  align-items: center;
  text-align: left;
  color: #d1d1d1;
}
.left-info .avatar {
  vertical-align: bottom;
  margin-right: 3%;
  margin-left: 5%;

}
</style>