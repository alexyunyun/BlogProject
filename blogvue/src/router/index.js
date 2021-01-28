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

Vue.use(VueRouter)

const routes = [
    {
        path: '/',
        name: 'Home',
        component: Home,
    },
    {
        path: '/classify',
        name: 'Classify',
        component: Classify
    },
    {
        path: '/blog',
        name: 'Blog',
        component: Blog
    },
    {
        path: '/blog_edit',
        name: 'BlogEdit',
        component: BlogEdit
    },
    {
        path: '/blog_add',
        name: 'BlogAdd',
        component: BlogAdd
    },
    {
        path: '/project_details',
        name: 'ProjectDetails',
        component: ProjectDetails
    },
    {
        path: '/project_edit',
        name: 'ProjectEdit',
        component: ProjectEdit
    },
    {
        path: '/project_add',
        name: 'ProjectAdd',
        component: ProjectAdd
    },
    {
        path: '/about',
        name: 'About',
        component: About
    },
    {
        path: '/other',
        name: 'Other',
        component: Other
    },
    {
        path: '/admin_login',
        name: 'AdminLogin',
        component: AdminLogin
    },
    {
        path: '/Admin',
        name: 'Admin',
        component: Admin
    },

]

const router = new VueRouter({
    mode: 'history',
    base: process.env.BASE_URL,
    routes
})

export default router
