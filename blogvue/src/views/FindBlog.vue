<template>
  <div id="table-container">
    <el-table
        :data="tableData"
        border
        class="table-box"
        :row-style="iRowStyle"
        :cell-style="iCellStyle"
        :header-row-style="iHeaderRowStyle"
        :header-cell-style="iHeaderCellStyle"
        >
      <el-table-column
          fixed
          prop="id"
          label="id"
          width="60"
      >
      </el-table-column>
      <el-table-column
          fixed
          prop="title"
          label="标题"
          width="120">
      </el-table-column>
      <el-table-column
          prop="created"
          label="日期"
          width="100">
      </el-table-column>
      <el-table-column
          prop="content"
          label="内容"
          width="350">
      </el-table-column>
      <el-table-column
          prop="classify"
          label="分类"
          width="120">
      </el-table-column>
      <el-table-column
          prop="tags"
          label="标签"
          width="150">
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
        background
        layout="prev, pager, next"
        :page-size="8"
        :total="total"
        class="pagination"
        @current-change="page">
    </el-pagination>
  </div>
</template>

<script>
export default {
  name: "FindBlog",
  methods: {
    iRowStyle:function ({row, rowIndex}) {
      return 'height:35px';
    },
    iHeaderRowStyle:function ({row, rowIndex}) {
      return 'height:35px';
    },
    iCellStyle:function ({row, column, rowIndex, columnIndex}) {
      return 'padding:0px'
    },
    iHeaderCellStyle:function ({row, column, rowIndex, columnIndex}) {
      return 'padding:0px'
    },
    page(currentPage) {
      const that = this
      axios.get('http://localhost:8181/blog/findBlog/' + currentPage + '/8').then(function (res) {
        that.total = res.data.totalElements
        that.tableData = res.data.content
        console.log(res)
      })
    },
    handleEdit(row) {
      console.log(row.id);
      this.$router.push({
        path: '/admin/blog_edit',
        query: {
          id: row.id
        }
      })
    },
    handleDelete(row) {
      const _this = this
      console.log(row.id);
      axios.get('http://localhost:8181/blog/delete/' + row.id).then(function (res) {
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
      total: 0
    }
  },
  created() {
    const _this = this
    axios.get('http://localhost:8181/blog/findBlog/1/8').then(function (res) {
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
  margin: 50px auto;
  border: 1px solid #d9ecff;
  border-radius: 8px;
  box-shadow: 0 2px 4px rgba(0, 0, 0, .12), 0 0 6px rgba(0, 0, 0, .04);
}

.table-box th,.table-box td {
  padding: 0 !important;
  height: 30px;
  line-height: 30px;
}
.pagination {
  margin: 20px auto;
}
</style>