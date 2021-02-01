<template>
  <div class="list-container">
    <div class="row-container" >
      <el-link href="/blog" class="link" :underline="false">
        <el-row class="title-row">
          <el-col :span="24">SpringBoot项目实战，前后端分离博客</el-col>
        </el-row>
      </el-link>
      <el-row class="description-row">
        <el-col :span="24">本项目技术栈包括springboot，vue，axios，element-ui，springbootJpa</el-col>
      </el-row>
      <div class="info-row">
        <div class="author"><i class="el-icon-user-solid"></i>旋木頵頵</div>
        <div class="time"><i class="el-icon-time"></i> 2020-01-29</div>
        <div class="tag"><i class="el-icon-collection-tag" ></i> Java SpringBoot</div>
      </div>
    </div>
    <div class="row-container" >
      <el-link href="/blog" class="link" :underline="false">
        <el-row class="title-row">
          <el-col :span="24">SpringBoot项目实战，前后端分离博客</el-col>
        </el-row>
      </el-link>
      <el-row class="description-row">
        <el-col :span="24">本项目技术栈包括springboot，vue，axios，element-ui，springbootJpa</el-col>
      </el-row>
      <div class="info-row">
        <div class="author"><i class="el-icon-user-solid"></i>旋木頵頵</div>
        <div class="time"><i class="el-icon-time"></i> 2020-01-29</div>
        <div class="tag"><i class="el-icon-collection-tag" ></i> Java SpringBoot</div>
      </div>
    </div>
    <div class="row-container" >
      <el-link href="/blog" class="link" :underline="false">
        <el-row class="title-row">
          <el-col :span="24">SpringBoot项目实战，前后端分离博客</el-col>
        </el-row>
      </el-link>
      <el-row class="description-row">
        <el-col :span="24">本项目技术栈包括springboot，vue，axios，element-ui，springbootJpa</el-col>
      </el-row>
      <div class="info-row">
        <div class="author"><i class="el-icon-user-solid"></i>旋木頵頵</div>
        <div class="time"><i class="el-icon-time"></i> 2020-01-29</div>
        <div class="tag"><i class="el-icon-collection-tag" ></i> Java SpringBoot</div>
      </div>
    </div>
    <div class="row-container" >
      <el-link href="/blog" class="link" :underline="false">
        <el-row class="title-row">
          <el-col :span="24">SpringBoot项目实战，前后端分离博客</el-col>
        </el-row>
      </el-link>
      <el-row class="description-row">
        <el-col :span="24">本项目技术栈包括springboot，vue，axios，element-ui，springbootJpa</el-col>
      </el-row>
      <div class="info-row">
        <div class="author"><i class="el-icon-user-solid"></i>旋木頵頵</div>
        <div class="time"><i class="el-icon-time"></i> 2020-01-29</div>
        <div class="tag"><i class="el-icon-collection-tag" ></i> Java SpringBoot</div>
      </div>
    </div>
    <div class="row-container" >
      <el-link href="/blog" class="link" :underline="false">
        <el-row class="title-row">
          <el-col :span="24">SpringBoot项目实战，前后端分离博客</el-col>
        </el-row>
      </el-link>
      <el-row class="description-row">
        <el-col :span="24">本项目技术栈包括springboot，vue，axios，element-ui，springbootJpa</el-col>
      </el-row>
      <div class="info-row">
        <div class="author"><i class="el-icon-user-solid"></i>旋木頵頵</div>
        <div class="time"><i class="el-icon-time"></i> 2020-01-29</div>
        <div class="tag"><i class="el-icon-collection-tag" ></i> Java SpringBoot</div>
      </div>
    </div>
    <div class="row-container" >
      <el-link href="/blog" class="link" :underline="false">
        <el-row class="title-row">
          <el-col :span="24">SpringBoot项目实战，前后端分离博客</el-col>
        </el-row>
      </el-link>
      <el-row class="description-row">
        <el-col :span="24">本项目技术栈包括springboot，vue，axios，element-ui，springbootJpa</el-col>
      </el-row>
      <div class="info-row">
        <div class="author"><i class="el-icon-user-solid"></i>旋木頵頵</div>
        <div class="time"><i class="el-icon-time"></i> 2020-01-29</div>
        <div class="tag"><i class="el-icon-collection-tag" ></i> Java SpringBoot</div>
      </div>
    </div>

  </div>
</template>

<script>
export default {
  name: "List"
}
</script>

<style scoped>
* {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
}


.list-container {
  width: 100%;
  display: flex;
  flex-direction: column;
  justify-content: space-around;
  align-items: start;
}
.row-container {
  width: 100%;
  display: flex;
  flex-direction: column;
  justify-content: space-around;
  align-items: start;
  background: white;
  border: none;
  border-radius: 8px;
  box-shadow: 0 2px 4px rgba(0, 0, 0, .12), 0 0 6px rgba(0, 0, 0, .04);
  margin-bottom: 35px;
  padding: 20px;
}

.title-row {
  font-size: x-large;
  font-family: "Helvetica Neue", Helvetica, "PingFang SC", "Hiragino Sans GB", "Microsoft YaHei", "微软雅黑", Arial, sans-serif;
  margin-bottom: 10px;
}
.description-row{
  font-size: large;
  margin-bottom: 8px;
}
.info-row {
  width: 100%;
  display: flex;
  justify-content: start;
  align-items: center;
}
.author {
  font-size: medium;
  margin-right: 35px;
}
.time {
  color: #66b1ff;
  margin-right: 25px;
}
.tag {
  color: #67C23A;
  display: flex;
  justify-content: space-around;
  align-items: center;
}


</style>