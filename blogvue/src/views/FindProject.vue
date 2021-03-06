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
          prop="time"
          label="更新日期"
          width="100">
      </el-table-column>
      <el-table-column
          fixed="right"
          label="操作"
          width="150">
        <template slot-scope="scope">
          <el-button @click="handleEdit(scope.row)" type="primary" size="small">编辑</el-button>
          <el-button @click="handleDelete(scope.row)" type="danger" size="small">删除</el-button>
        </template>
      </el-table-column>
    </el-table>

    <el-pagination
        class="pagination"
        background
        layout="prev, pager, next"
        :total="total">
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
    handleEdit(row) {
      console.log(row.id);
      this.$router.push({
        path: '/admin/project_edit',
        query: {
          id: row.id
        }
      })
    },
    handleDelete(row) {
      const _this = this
      console.log(row.id);
      axios.get('http://localhost:8181/project/delete/' + row.id).then(function (res) {
        console.log(res)
        _this.$message({
          showClose: true,
          message: '博客删除成功',
          type: 'success'
        });
        window.location.reload()
      })
    },
  },

  data() {
    return {
      tableData: [],
      total:0
    }
  },
  created() {
    const _this = this
    axios.get('http://localhost:8181/project/findProject/1/8').then(function (res) {
      console.log(res)
      console.log(_this.total)
      _this.total = res.data.totalElements
      _this.tableData = res.data.content
    })
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