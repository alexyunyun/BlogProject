<template>
  <div id="table-container">
    <el-table
        :data="tableData"
        :fit="true"
        border
        class="table-box"
        @cell-click="handleLink">
      <el-table-column
          fixed
          prop="id"
          label="id"
          width="60">
      </el-table-column>
      <el-table-column
          fixed
          prop="name"
          label="项目名称"
          width="150">
      </el-table-column>
      <el-table-column
          prop="description"
          label="项目简介"
          width="350">
      </el-table-column>
      <el-table-column
          prop="link"
          label="项目链接"
          width="120"
          @cell-dbclick="handleLink">
        <template slot-scope="scope">
          <el-link :href="scope.row.link">{{ scope.row.link }}</el-link>
        </template>
      </el-table-column>
      <el-table-column
          prop="date"
          label="更新日期"
          width="100">
      </el-table-column>
      <el-table-column
          fixed="right"
          label="操作"
          width="150">
        <template slot-scope="scope">
          <el-button @click="handleClick(scope.row)" type="primary" size="small">编辑</el-button>
          <el-button type="danger" size="small">删除</el-button>
        </template>
      </el-table-column>
    </el-table>

    <el-pagination
        class="pagination"
        background
        layout="prev, pager, next"
        :total="1000">
    </el-pagination>
  </div>
</template>

<script>
import {Table, TableColumn} from "element-ui";

export default {
  name: "FindProject",
  components: {
    "el-table": Table,
    "el-table-column": TableColumn
  },
  methods: {
    handleLink(row, column, event, cell) {
      console.log(cell)
    },
    handleClick(row) {
      console.log(row.name);
    }
  },

  data() {
    return {
      tableData: [{
        id: 1,
        date: '2016-05-02',
        name: 'SpringBoot+Vue博客系统',
        link: 'https://github.com/alexyunyun/BookManageSystem',
        description: 'SpringBoot+Vue前后端分离型图书管理系统前端技术：vue+element-ui+axios后端技术: SpringBoot+SpringDataJpa数据库: MySql',
      },
        {
          id: 2,
          date: '2016-05-02',
          name: 'SpringBoot+Vue博客系统',
          link: 'https://github.com/alexyunyun/BookManageSystem',
          description: 'SpringBoot+Vue前后端分离型图书管理系统前端技术：vue+element-ui+axios后端技术: SpringBoot+SpringDataJpa数据库: MySql',
        },
        {
          id: 3,
          date: '2016-05-02',
          name: 'SpringBoot+Vue博客系统',
          link: 'https://github.com/alexyunyun/BookManageSystem',
          description: 'SpringBoot+Vue前后端分离型图书管理系统前端技术：vue+element-ui+axios后端技术: SpringBoot+SpringDataJpa数据库: MySql',
        },
        {
          id: 4,
          date: '2016-05-02',
          name: 'SpringBoot+Vue博客系统',
          link: 'https://github.com/alexyunyun/BookManageSystem',
          description: 'SpringBoot+Vue前后端分离型图书管理系统前端技术：vue+element-ui+axios后端技术: SpringBoot+SpringDataJpa数据库: MySql',
        },
        {
          id: 5,
          date: '2016-05-02',
          name: 'SpringBoot+Vue博客系统',
          link: 'https://github.com/alexyunyun/BookManageSystem',
          description: 'SpringBoot+Vue前后端分离型图书管理系统前端技术：vue+element-ui+axios后端技术: SpringBoot+SpringDataJpa数据库: MySql',
        }
      ]
    }
  }
}
</script>

<style scoped>
#table-container {
  width: 100%;
}

.table-box {
  margin:0 auto;
  border: 1px solid #d9ecff;
  border-radius: 8px;
  box-shadow: 0 2px 4px rgba(0, 0, 0, .12), 0 0 6px rgba(0, 0, 0, .04);
}

.pagination {
  margin: 20px auto;
}
</style>