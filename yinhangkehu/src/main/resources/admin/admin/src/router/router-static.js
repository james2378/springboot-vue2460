import Vue from 'vue';
//配置路由
import VueRouter from 'vue-router'
Vue.use(VueRouter);
    // 解决多次点击左侧菜单报错问题
    const VueRouterPush = VueRouter.prototype.push
    VueRouter.prototype.push = function push (to) {
    return VueRouterPush.call(this, to).catch(err => err)
    }
//1.创建组件
import Index from '@/views/index'
import Home from '@/views/home'
import Login from '@/views/login'
import NotFound from '@/views/404'
import UpdatePassword from '@/views/update-password'
import pay from '@/views/pay'
import register from '@/views/register'
import center from '@/views/center'
import beifen from '@/views/modules/databaseBackup/beifen'
import huanyuan from '@/views/modules/databaseBackup/huanyuan'

     import users from '@/views/modules/users/list'
    import chat from '@/views/modules/chat/list'
    import dictionary from '@/views/modules/dictionary/list'
    import gonggao from '@/views/modules/gonggao/list'
    import jinronggongju from '@/views/modules/jinronggongju/list'
    import jinronggongjuCollection from '@/views/modules/jinronggongjuCollection/list'
    import jinronggongjuCommentback from '@/views/modules/jinronggongjuCommentback/list'
    import jinronggongjuOrder from '@/views/modules/jinronggongjuOrder/list'
    import licaichanpin from '@/views/modules/licaichanpin/list'
    import licaichanpinCollection from '@/views/modules/licaichanpinCollection/list'
    import licaichanpinCommentback from '@/views/modules/licaichanpinCommentback/list'
    import licaichanpinOrder from '@/views/modules/licaichanpinOrder/list'
    import yinhangka from '@/views/modules/yinhangka/list'
    import yinhangkaCunkuan from '@/views/modules/yinhangkaCunkuan/list'
    import yinhangkaJilu from '@/views/modules/yinhangkaJilu/list'
    import yinhangkaQukuan from '@/views/modules/yinhangkaQukuan/list'
    import yinhangkaZhuanzhang from '@/views/modules/yinhangkaZhuanzhang/list'
    import yonghu from '@/views/modules/yonghu/list'
    import yuangong from '@/views/modules/yuangong/list'
    import config from '@/views/modules/config/list'
    import dictionaryChat from '@/views/modules/dictionaryChat/list'
    import dictionaryGonggao from '@/views/modules/dictionaryGonggao/list'
    import dictionaryJinronggongju from '@/views/modules/dictionaryJinronggongju/list'
    import dictionaryJinronggongjuCollection from '@/views/modules/dictionaryJinronggongjuCollection/list'
    import dictionaryJinronggongjuOrder from '@/views/modules/dictionaryJinronggongjuOrder/list'
    import dictionaryJinronggongjuOrderPayment from '@/views/modules/dictionaryJinronggongjuOrderPayment/list'
    import dictionaryJinronggongjuOrderYesno from '@/views/modules/dictionaryJinronggongjuOrderYesno/list'
    import dictionaryJinyong from '@/views/modules/dictionaryJinyong/list'
    import dictionaryLicaichanpin from '@/views/modules/dictionaryLicaichanpin/list'
    import dictionaryLicaichanpinCollection from '@/views/modules/dictionaryLicaichanpinCollection/list'
    import dictionaryLicaichanpinFengxian from '@/views/modules/dictionaryLicaichanpinFengxian/list'
    import dictionaryLicaichanpinOrder from '@/views/modules/dictionaryLicaichanpinOrder/list'
    import dictionaryLicaichanpinOrderPayment from '@/views/modules/dictionaryLicaichanpinOrderPayment/list'
    import dictionaryLicaichanpinOrderYesno from '@/views/modules/dictionaryLicaichanpinOrderYesno/list'
    import dictionarySex from '@/views/modules/dictionarySex/list'
    import dictionaryShangxia from '@/views/modules/dictionaryShangxia/list'
    import dictionaryYinhang from '@/views/modules/dictionaryYinhang/list'
    import dictionaryYinhangka from '@/views/modules/dictionaryYinhangka/list'
    import dictionaryYinhangkaJilu from '@/views/modules/dictionaryYinhangkaJilu/list'
    import dictionaryZhengxindengji from '@/views/modules/dictionaryZhengxindengji/list'
    import dictionaryZhuangtai from '@/views/modules/dictionaryZhuangtai/list'





//2.配置路由   注意：名字
const routes = [{
    path: '/index',
    name: '首页',
    component: Index,
    children: [{
      // 这里不设置值，是把main作为默认页面
      path: '/',
      name: '首页',
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
    }, {
        path: '/huanyuan',
        name: '数据还原',
        component: huanyuan
    }, {
        path: '/beifen',
        name: '数据备份',
        component: beifen
    }, {
        path: '/users',
        name: '管理信息',
        component: users
    }
    ,{
        path: '/dictionaryChat',
        name: '数据类型',
        component: dictionaryChat
    }
    ,{
        path: '/dictionaryGonggao',
        name: '公告类型',
        component: dictionaryGonggao
    }
    ,{
        path: '/dictionaryJinronggongju',
        name: '产品类型',
        component: dictionaryJinronggongju
    }
    ,{
        path: '/dictionaryJinronggongjuCollection',
        name: '收藏表类型',
        component: dictionaryJinronggongjuCollection
    }
    ,{
        path: '/dictionaryJinronggongjuOrder',
        name: '订单类型',
        component: dictionaryJinronggongjuOrder
    }
    ,{
        path: '/dictionaryJinronggongjuOrderPayment',
        name: '订单支付类型',
        component: dictionaryJinronggongjuOrderPayment
    }
    ,{
        path: '/dictionaryJinronggongjuOrderYesno',
        name: '审核状态',
        component: dictionaryJinronggongjuOrderYesno
    }
    ,{
        path: '/dictionaryJinyong',
        name: '账户状态',
        component: dictionaryJinyong
    }
    ,{
        path: '/dictionaryLicaichanpin',
        name: '投资类型',
        component: dictionaryLicaichanpin
    }
    ,{
        path: '/dictionaryLicaichanpinCollection',
        name: '收藏表类型',
        component: dictionaryLicaichanpinCollection
    }
    ,{
        path: '/dictionaryLicaichanpinFengxian',
        name: '风险等级',
        component: dictionaryLicaichanpinFengxian
    }
    ,{
        path: '/dictionaryLicaichanpinOrder',
        name: '订单类型',
        component: dictionaryLicaichanpinOrder
    }
    ,{
        path: '/dictionaryLicaichanpinOrderPayment',
        name: '订单支付类型',
        component: dictionaryLicaichanpinOrderPayment
    }
    ,{
        path: '/dictionaryLicaichanpinOrderYesno',
        name: '审核状态',
        component: dictionaryLicaichanpinOrderYesno
    }
    ,{
        path: '/dictionarySex',
        name: '性别类型',
        component: dictionarySex
    }
    ,{
        path: '/dictionaryShangxia',
        name: '上下架',
        component: dictionaryShangxia
    }
    ,{
        path: '/dictionaryYinhang',
        name: '银行',
        component: dictionaryYinhang
    }
    ,{
        path: '/dictionaryYinhangka',
        name: '银行卡类型',
        component: dictionaryYinhangka
    }
    ,{
        path: '/dictionaryYinhangkaJilu',
        name: '记录类型',
        component: dictionaryYinhangkaJilu
    }
    ,{
        path: '/dictionaryZhengxindengji',
        name: '征信等级',
        component: dictionaryZhengxindengji
    }
    ,{
        path: '/dictionaryZhuangtai',
        name: '状态',
        component: dictionaryZhuangtai
    }
    ,{
        path: '/config',
        name: '轮播图',
        component: config
    }


    ,{
        path: '/chat',
        name: '客服聊天',
        component: chat
      }
    ,{
        path: '/dictionary',
        name: '字典表',
        component: dictionary
      }
    ,{
        path: '/gonggao',
        name: '公告信息',
        component: gonggao
      }
    ,{
        path: '/jinronggongju',
        name: '金融工具',
        component: jinronggongju
      }
    ,{
        path: '/jinronggongjuCollection',
        name: '金融工具收藏',
        component: jinronggongjuCollection
      }
    ,{
        path: '/jinronggongjuCommentback',
        name: '金融工具评价',
        component: jinronggongjuCommentback
      }
    ,{
        path: '/jinronggongjuOrder',
        name: '借款',
        component: jinronggongjuOrder
      }
    ,{
        path: '/licaichanpin',
        name: '理财产品',
        component: licaichanpin
      }
    ,{
        path: '/licaichanpinCollection',
        name: '理财产品收藏',
        component: licaichanpinCollection
      }
    ,{
        path: '/licaichanpinCommentback',
        name: '理财产品评价',
        component: licaichanpinCommentback
      }
    ,{
        path: '/licaichanpinOrder',
        name: '理财产品订单',
        component: licaichanpinOrder
      }
    ,{
        path: '/yinhangka',
        name: '银行卡',
        component: yinhangka
      }
    ,{
        path: '/yinhangkaCunkuan',
        name: '存款',
        component: yinhangkaCunkuan
      }
    ,{
        path: '/yinhangkaJilu',
        name: '银行卡记录',
        component: yinhangkaJilu
      }
    ,{
        path: '/yinhangkaQukuan',
        name: '取款',
        component: yinhangkaQukuan
      }
    ,{
        path: '/yinhangkaZhuanzhang',
        name: '转账',
        component: yinhangkaZhuanzhang
      }
    ,{
        path: '/yonghu',
        name: '用户',
        component: yonghu
      }
    ,{
        path: '/yuangong',
        name: '员工',
        component: yuangong
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
    name: '首页',
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

export default router;
