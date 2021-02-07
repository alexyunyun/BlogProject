<template>
  <div id="table-container">
    <el-table
        :data="tableData"
        fit
        border
        class="table-box">
      <el-table-column
          fixed
          prop="id"
          label="id"
          width="60">
      </el-table-column>
      <el-table-column
          fixed
          prop="name"
          label="标题"
          width="120">
      </el-table-column>
      <el-table-column
          prop="date"
          label="日期"
          width="100">
      </el-table-column>

      <el-table-column
          prop="type"
          label="类型"
          width="120">
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
export default {
  name: "FindBlog",
  methods: {
    handleClick(row) {
      console.log(row.name);
    }
  },

  data() {
    return {
      tableData: [{
        id: 1,
        date: '2016-05-02',
        name: '前端学习笔记',
        type: '编程',
        content: '使用在线主题编辑器，可以修改定制 Element 所有全局和组件的 Design Tokens，并可以方便地实时预览样式改变后的视觉。同时它还可以基于新的定制样式生成完整的样式文件包，供直接下载使用（关于如何使用下载的主题包，请参考本节「引入自定义主题」部分）。\n' +
            '\n' +
            '也可以使用主题编辑器 Chrome 插件，在任何使用 Element 开发的网站上配置并实时预览主题。\n' +
            '\n',
        classify: '前端',
        tags: ['css', 'html', 'javascript']
      },
        {
          id: 2,
          date: '2016-05-02',
          name: '前端学习笔记',
          type: '编程',
          content: '使用在线主题编辑器，可以修改定制 Element 所有全局和组件的 Design Tokens，并可以方便地实时预览样式改变后的视觉。同时它还可以基于新的定制样式生成完整的样式文件包，供直接下载使用（关于如何使用下载的主题包，请参考本节「引入自定义主题」部分）。\n' +
              '\n' +
              '也可以使用主题编辑器 Chrome 插件，在任何使用 Element 开发的网站上配置并实时预览主题。\n' +
              '\n',
          classify: '前端',
          tags: ['css', 'html', 'javascript']
        },
        {
          id: 3,
          date: '2016-05-02',
          name: '前端学习笔记',
          type: '编程',
          content: '使用在线主题编辑器，可以修改定制 Element 所有全局和组件的 Design Tokens，并可以方便地实时预览样式改变后的视觉。同时它还可以基于新的定制样式生成完整的样式文件包，供直接下载使用（关于如何使用下载的主题包，请参考本节「引入自定义主题」部分）。\n' +
              '\n' +
              '也可以使用主题编辑器 Chrome 插件，在任何使用 Element 开发的网站上配置并实时预览主题。\n' +
              '\n',
          classify: '前端',
          tags: ['css', 'html', 'javascript']
        },
        {
          id: 4,
          date: '2016-05-02',
          name: '前端学习笔记',
          type: '编程',
          content: '使用在线主题编辑器，可以修改定制 Element 所有全局和组件的 Design Tokens，并可以方便地实时预览样式改变后的视觉。同时它还可以基于新的定制样式生成完整的样式文件包，供直接下载使用（关于如何使用下载的主题包，请参考本节「引入自定义主题」部分）。\n' +
              '\n' +
              '也可以使用主题编辑器 Chrome 插件，在任何使用 Element 开发的网站上配置并实时预览主题。\n' +
              '\n',
          classify: '前端',
          tags: ['css', 'html', 'javascript']
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
  margin: 50px auto;
  border: 1px solid #d9ecff;
  border-radius: 8px;
  box-shadow: 0 2px 4px rgba(0, 0, 0, .12), 0 0 6px rgba(0, 0, 0, .04);
}

.pagination {
  margin: 20px auto;
}
</style>