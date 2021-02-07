import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'
import BlogEdit from "@/views/BlogEdit";
import Classify from "@/views/Classify";
import Blog from "@/views/Blog";
import ProjectDetails from "@/views/ProjectDetails";
import BlogAdd from "@/views/BlogAdd";
import ProjectEdit from "@/views/ProjectEdit";
import ProjectAdd from "@/views/ProjectAdd";
import About from "@/views/About";
import Other from "@/views/Other";
import AdminLogin from "@/views/AdminLogin";
import Admin from "@/views/Admin";
import FindBlog from "@/views/FindBlog";
import FindProject from "@/views/FindProject";

Vue.use(VueRouter)

const routes = [
    {
        path: '/',
        name: '首页',
        component: Home,
    },
    {
        path: '/classify',
        name: '分类',
        component: Classify
    },
    {
        path: '/blog',
        name: '博客',
        component: Blog
    },
    {
        path: '/project_details/:id',
        name: '项目详情',
        component: ProjectDetails
    },
    {
        path: '/about',
        name: '关于',
        component: About
    },
    {
        path: '/other',
        name: '其他',
        component: Other
    },
    {
        path: '/admin_login',
        name: '管理员登录',
        component: AdminLogin
    },
    {
        path: '/admin',
        name: '管理员',
        component: Admin,
        children: [
            {
                path: '/admin/find_blog',
                name: '博客列表',
                component: FindBlog,
                show: true
            },
            {
                path: '/admin/find_project',
                name: '项目列表',
                component: FindProject,
                show: true
            },
            {
                path: '/admin/blog_add',
                name: '博客添加',
                component: BlogAdd,
                show: true

            },
            {
                path: '/admin/blog_edit',
                name: '博客编辑',
                component: BlogEdit,
                show:false
            },
            {
                path: '/admin/project_add',
                name: '项目添加',
                component: ProjectAdd,
                show: true
            },
            {
                path: '/admin/project_edit',
                name: '项目编辑',
                component: ProjectEdit,
                show:false
            },


        ]

    },

]

const router = new VueRouter({
    mode: 'history',
    base: process.env.BASE_URL,
    routes
})

export default router
