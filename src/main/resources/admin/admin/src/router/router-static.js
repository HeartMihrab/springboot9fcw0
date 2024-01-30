import Vue from 'vue';
//配置路由
import VueRouter from 'vue-router'
Vue.use(VueRouter);
//1.创建组件
import Index from '@/views/index'
import Home from '@/views/home'
import Login from '@/views/login'
import NotFound from '@/views/404'
import UpdatePassword from '@/views/update-password'
import pay from '@/views/pay'
import register from '@/views/register'
import center from '@/views/center'
    import news from '@/views/modules/news/list'
    import aboutus from '@/views/modules/aboutus/list'
    import huodongbaoming from '@/views/modules/huodongbaoming/list'
    import zuzhifengcai from '@/views/modules/zuzhifengcai/list'
    import messages from '@/views/modules/messages/list'
    import zuzhibaoming from '@/views/modules/zuzhibaoming/list'
    import config from '@/views/modules/config/list'
    import zhiyuanzuzhi from '@/views/modules/zhiyuanzuzhi/list'
    import zhiyuanhuodong from '@/views/modules/zhiyuanhuodong/list'
    import zhiyuanzhe from '@/views/modules/zhiyuanzhe/list'
    import huodongleixing from '@/views/modules/huodongleixing/list'


//2.配置路由   注意：名字
const routes = [{
    path: '/index',
    name: '系统首页',
    component: Index,
    children: [{
      // 这里不设置值，是把main作为默认页面
      path: '/',
      name: '系统首页',
      component: Home,
      meta: {icon:'', title:'center'}
    }, {
      path: '/updatePassword',
      name: '修改密码',
      component: UpdatePassword,
      meta: {icon:'', title:'updatePassword'}
    }, {
      path: '/pay',
      name: '支付',
      component: pay,
      meta: {icon:'', title:'pay'}
    }, {
      path: '/center',
      name: '个人信息',
      component: center,
      meta: {icon:'', title:'center'}
    }
      ,{
	path: '/news',
        name: '公告信息',
        component: news
      }
      ,{
	path: '/aboutus',
        name: '关于我们',
        component: aboutus
      }
      ,{
	path: '/huodongbaoming',
        name: '活动报名',
        component: huodongbaoming
      }
      ,{
	path: '/zuzhifengcai',
        name: '组织风采',
        component: zuzhifengcai
      }
      ,{
	path: '/messages',
        name: '留言板管理',
        component: messages
      }
      ,{
	path: '/zuzhibaoming',
        name: '组织报名',
        component: zuzhibaoming
      }
      ,{
	path: '/config',
        name: '轮播图管理',
        component: config
      }
      ,{
	path: '/zhiyuanzuzhi',
        name: '志愿组织',
        component: zhiyuanzuzhi
      }
      ,{
	path: '/zhiyuanhuodong',
        name: '志愿活动',
        component: zhiyuanhuodong
      }
      ,{
	path: '/zhiyuanzhe',
        name: '志愿者',
        component: zhiyuanzhe
      }
      ,{
	path: '/huodongleixing',
        name: '活动类型',
        component: huodongleixing
      }
    ]
  },
  {
    path: '/login',
    name: 'login',
    component: Login,
    meta: {icon:'', title:'login'}
  },
  {
    path: '/register',
    name: 'register',
    component: register,
    meta: {icon:'', title:'register'}
  },
  {
    path: '/',
    name: '系统首页',
    redirect: '/index'
  }, /*默认跳转路由*/
  {
    path: '*',
    component: NotFound
  }
]
//3.实例化VueRouter  注意：名字
const router = new VueRouter({
  mode: 'hash',
  /*hash模式改为history*/
  routes // （缩写）相当于 routes: routes
})
const originalPush = VueRouter.prototype.push
//修改原型对象中的push方法
VueRouter.prototype.push = function push(location) {
   return originalPush.call(this, location).catch(err => err)
}
export default router;
