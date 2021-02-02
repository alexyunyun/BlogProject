<template>
  <div id="login-container">
    <div>
      <h1>管理员登录</h1>
    </div>

    <div class="main-box">
      <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
        <el-form-item label="用户名" prop="name">
          <el-input v-model="ruleForm.name"></el-input>
        </el-form-item>
        <el-form-item label="密码" prop="password">
          <el-input v-model="ruleForm.password"></el-input>
        </el-form-item>

        <el-form-item>
          <el-button type="primary" @click="submitForm('ruleForm')">登录</el-button>
          <el-button @click="resetForm('ruleForm')">重置</el-button>
        </el-form-item>
      </el-form>

    </div>

  </div>
</template>

<script>
export default {
  name: "AdminLogin",
  data() {
    return {
      ruleForm: {
        name: '',
        password: '',

      },
      rules: {
        name: [
          {required: true, message: '请输入用户名', trigger: 'blur'},
          {min: 3, max: 15, message: '用户名长度在3到15之间', trigger: 'blur'}
        ],
        password: [
          {required: true, message: '请输入密码', trigger: 'change'}
        ],
      }
    };
  },
  methods: {
    submitForm(formName) {
      this.$refs[formName].validate((valid) => {
        if (valid) {
          alert('submit!');
        } else {
          console.log('error submit!!');
          return false;
        }
      });
    },
    resetForm(formName) {
      this.$refs[formName].resetFields();
    }
  }
}
</script>

<style scoped>


#login-container {
  height: 600px;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  background: #efefef;
}

.main-box {
  width: 40%;
  margin-top: 50px;
  padding: 50px;
  background: white;
  border: 1px solid white;
  border-radius: 10px;
  text-align: center;
}
</style>