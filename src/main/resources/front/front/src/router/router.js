import VueRouter from 'vue-router'

//引入组件
import Index from '../pages'
import Home from '../pages/home/home'
import Login from '../pages/login/login'
import Register from '../pages/register/register'
import Center from '../pages/center/center'
import Messages from '../pages/messages/list'
import Storeup from '../pages/storeup/list'
import News from '../pages/news/news-list'
import NewsDetail from '../pages/news/news-detail'
import zhiyuanzheList from '../pages/zhiyuanzhe/list'
import zhiyuanzheDetail from '../pages/zhiyuanzhe/detail'
import zhiyuanzheAdd from '../pages/zhiyuanzhe/add'
import zhiyuanzuzhiList from '../pages/zhiyuanzuzhi/list'
import zhiyuanzuzhiDetail from '../pages/zhiyuanzuzhi/detail'
import zhiyuanzuzhiAdd from '../pages/zhiyuanzuzhi/add'
import zuzhifengcaiList from '../pages/zuzhifengcai/list'
import zuzhifengcaiDetail from '../pages/zuzhifengcai/detail'
import zuzhifengcaiAdd from '../pages/zuzhifengcai/add'
import huodongleixingList from '../pages/huodongleixing/list'
import huodongleixingDetail from '../pages/huodongleixing/detail'
import huodongleixingAdd from '../pages/huodongleixing/add'
import zhiyuanhuodongList from '../pages/zhiyuanhuodong/list'
import zhiyuanhuodongDetail from '../pages/zhiyuanhuodong/detail'
import zhiyuanhuodongAdd from '../pages/zhiyuanhuodong/add'
import zuzhibaomingList from '../pages/zuzhibaoming/list'
import zuzhibaomingDetail from '../pages/zuzhibaoming/detail'
import zuzhibaomingAdd from '../pages/zuzhibaoming/add'
import huodongbaomingList from '../pages/huodongbaoming/list'
import huodongbaomingDetail from '../pages/huodongbaoming/detail'
import huodongbaomingAdd from '../pages/huodongbaoming/add'

const originalPush = VueRouter.prototype.push
VueRouter.prototype.push = function push(location) {
	return originalPush.call(this, location).catch(err => err)
}

//配置路由
export default new VueRouter({
	routes:[
		{
      path: '/',
      redirect: '/index/home'
    },
		{
			path: '/index',
			component: Index,
			children:[
				{
					path: 'home',
					component: Home
				},
				{
					path: 'center',
					component: Center,
				},
				{
					path: 'messages',
					component: Messages
				},
				{
					path: 'storeup',
					component: Storeup
				},
				{
					path: 'news',
					component: News
				},
				{
					path: 'newsDetail',
					component: NewsDetail
				},
				{
					path: 'zhiyuanzhe',
					component: zhiyuanzheList
				},
				{
					path: 'zhiyuanzheDetail',
					component: zhiyuanzheDetail
				},
				{
					path: 'zhiyuanzheAdd',
					component: zhiyuanzheAdd
				},
				{
					path: 'zhiyuanzuzhi',
					component: zhiyuanzuzhiList
				},
				{
					path: 'zhiyuanzuzhiDetail',
					component: zhiyuanzuzhiDetail
				},
				{
					path: 'zhiyuanzuzhiAdd',
					component: zhiyuanzuzhiAdd
				},
				{
					path: 'zuzhifengcai',
					component: zuzhifengcaiList
				},
				{
					path: 'zuzhifengcaiDetail',
					component: zuzhifengcaiDetail
				},
				{
					path: 'zuzhifengcaiAdd',
					component: zuzhifengcaiAdd
				},
				{
					path: 'huodongleixing',
					component: huodongleixingList
				},
				{
					path: 'huodongleixingDetail',
					component: huodongleixingDetail
				},
				{
					path: 'huodongleixingAdd',
					component: huodongleixingAdd
				},
				{
					path: 'zhiyuanhuodong',
					component: zhiyuanhuodongList
				},
				{
					path: 'zhiyuanhuodongDetail',
					component: zhiyuanhuodongDetail
				},
				{
					path: 'zhiyuanhuodongAdd',
					component: zhiyuanhuodongAdd
				},
				{
					path: 'zuzhibaoming',
					component: zuzhibaomingList
				},
				{
					path: 'zuzhibaomingDetail',
					component: zuzhibaomingDetail
				},
				{
					path: 'zuzhibaomingAdd',
					component: zuzhibaomingAdd
				},
				{
					path: 'huodongbaoming',
					component: huodongbaomingList
				},
				{
					path: 'huodongbaomingDetail',
					component: huodongbaomingDetail
				},
				{
					path: 'huodongbaomingAdd',
					component: huodongbaomingAdd
				},
			]
		},
		{
			path: '/login',
			component: Login
		},
		{
			path: '/register',
			component: Register
		},
	]
})
