import Vue from 'vue'
import VueRouter from 'vue-router'

import Homepage from '@/views/Homepage' //主页
import Login from "@/views/Login" //登陆

Vue.use(VueRouter)

/*

<!--
    <router-link to="/login" tag="span">登录</router-link>
    <router-view></router-view>
-->

const router = new VueRouter({
        //路由规则
        routes: [
            {
                path: '/login',
                component: 'login'
                // 放在 router-view 标签中
            },{
                path: '/lohin/:name/:id',  --> $route.params.name 能取值
                redirect: '/login'
                props: true                --> 可以直接用名称取值 比如直接写 name
                                               在组件上写上 props: ['id', 'name'] 即可
            }
        ]
    });*/

const routes = [{
    path: '/',
    name: 'login',
    component: Login
},
    {
        path: '/reg',
        name: 'reg',
        redirect: '/reg'
    }, {
        path: '/Homepage',
        name: 'Homepage',
        component: Homepage
    },
]

const router = new VueRouter({
    mode: 'history',
    base: process.env.BASE_URL,
    routes
})

export default router
