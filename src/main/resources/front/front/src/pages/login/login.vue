<template>
<div>
	<div class="container" :style='{"minHeight":"100vh","alignItems":"center","background":"url(http://codegen.caihongy.cn/20230117/7929bf8c61b346319944c0d8bfe3dc60.jpg) no-repeat center bottom / 100% 100%,#fff","display":"flex","width":"100%","backgroundSize":"cover","backgroundPosition":"center center","backgroundRepeat":"no-repeat","justifyContent":"center"}'>
		<el-form ref="loginForm" :model="loginForm" :style='{"padding":"100px 0px 0px","boxShadow":"0 1px 6px rgba(64, 158, 255, .8)","margin":"10px 0","borderRadius":"100%","background":"#fff","width":"750px","position":"relative","height":"750px"}' :rules="rules">
			<div v-if="false" :style='{"margin":"0 0 10px 0","color":"rgba(64, 158, 255, 1)","textAlign":"center","width":"100%","lineHeight":"44px","fontSize":"20px","textShadow":"4px 4px 2px rgba(64, 158, 255, .5)"}'>USER / LOGIN</div>
			<div v-if="true" :style='{"margin":"30px auto 40px","color":"#333","textAlign":"center","width":"80%","lineHeight":"50px","fontSize":"22px","textShadow":"0px 0px 0px rgba(64, 158, 255, .5)"}'>大学生志愿者管理系统的设计与实现登录</div>
			<el-form-item v-if="loginType==1" class="list-item" :style='{"width":"60%","margin":"0 auto 20px"}' prop="username">
				<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}'>账号：</div>
				<input :style='{"border":"1px solid #ddd","padding":"0 10px","boxShadow":"0 0 0px rgba(64, 158, 255, .5)","color":"#333","outlineOffset":"4px","background":"linear-gradient(240deg, rgba(246,246,246,1) 0%, rgba(246,246,246,1) 50%, rgba(238,238,238,1) 50%, rgba(238,238,238,1) 100%)","width":"100%","fontSize":"14px","height":"44px"}' v-model="loginForm.username" placeholder="请输入账户">
			</el-form-item>
			<el-form-item v-if="loginType==1" class="list-item" :style='{"width":"60%","margin":"0 auto 20px"}' prop="password">
				<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}'>密码：</div>
				<input :style='{"border":"1px solid #ddd","padding":"0 10px","boxShadow":"0 0 0px rgba(64, 158, 255, .5)","color":"#333","outlineOffset":"4px","background":"linear-gradient(240deg, rgba(246,246,246,1) 0%, rgba(246,246,246,1) 50%, rgba(238,238,238,1) 50%, rgba(238,238,238,1) 100%)","width":"100%","fontSize":"14px","height":"44px"}' v-model="loginForm.password" placeholder="请输入密码" type="password">
			</el-form-item>
			<el-form-item v-if="roles.length>1" class="list-type" :style='{"width":"60%","margin":"20px auto"}' prop="role">
				<el-radio v-model="loginForm.tableName" :label="item.tableName" v-for="(item, index) in roles" :key="index" @change.native="getCurrentRow(item)">{{item.roleName}}</el-radio>
			</el-form-item>
			<el-form-item :style='{"width":"80%","margin":"20px auto"}'>
				<el-button v-if="loginType==1" :style='{"border":"0","cursor":"pointer","padding":"0 10px","margin":"0","color":"#333","bottom":"-130px","outline":"none","borderRadius":"100%","left":"-80px","background":"#32cfc4","width":"100px","fontSize":"16px","position":"absolute","height":"100px"}' @click="submitForm('loginForm')">登录</el-button>
				<el-button v-if="loginType==1" :style='{"border":"0","cursor":"pointer","padding":"0 24px","margin":"0 5px","outline":"none","color":"#fff","borderRadius":"4px","background":"rgba(64, 158, 255, 1)","display":"none","width":"auto","fontSize":"14px","height":"44px"}' @click="resetForm('loginForm')">重置</el-button>
                <el-upload v-if="loginType==2" :action="baseUrl + 'file/upload'" :show-file-list="false" :on-success="faceLogin">
                    <el-button :style='{"border":"0","cursor":"pointer","padding":"0 10px","margin":"0","color":"#333","bottom":"-130px","outline":"none","borderRadius":"100%","left":"-80px","background":"#32cfc4","width":"100px","fontSize":"16px","position":"absolute","height":"100px"}'>人脸识别登录</el-button>
                </el-upload>
			</el-form-item>
			<div :style='{"width":"60%","textAlign":"center","margin":"0 auto"}'>
			<router-link :style='{"cursor":"pointer","border":"1px solid #ddd","padding":"0 10px","margin":"0 1% 20px 0","color":"#7e5ffb","textAlign":"center","background":"linear-gradient(240deg, rgba(246,246,246,1) 0%, rgba(246,246,246,1) 50%, rgba(238,238,238,1) 50%, rgba(238,238,238,1) 100%)","display":"inline-block","width":"32%","fontSize":"16px","lineHeight":"40px","height":"40px"}' :to="{path: '/register', query: {role: item.tableName,pageFlag:'register'}}" v-if="item.hasFrontRegister=='是'" v-for="(item, index) in roles" :key="index">注册{{item.roleName.replace('注册','')}}</router-link>
			</div>
		</el-form>
    </div>
</div>
</template>

<script>

export default {
	//数据集合
	data() {
		return {
            baseUrl: this.$config.baseUrl,
            loginType: 1,
			roleMenus: [{"backMenu":[{"child":[{"appFrontIcon":"cuIcon-phone","buttons":["查看","修改","删除"],"menu":"志愿者","menuJump":"列表","tableName":"zhiyuanzhe"}],"menu":"志愿者管理"},{"child":[{"appFrontIcon":"cuIcon-goods","buttons":["查看","修改","删除"],"menu":"志愿组织","menuJump":"列表","tableName":"zhiyuanzuzhi"}],"menu":"志愿组织管理"},{"child":[{"appFrontIcon":"cuIcon-qrcode","buttons":["查看","修改","删除"],"menu":"组织风采","menuJump":"列表","tableName":"zuzhifengcai"}],"menu":"组织风采管理"},{"child":[{"appFrontIcon":"cuIcon-similar","buttons":["新增","查看","修改","删除"],"menu":"活动类型","menuJump":"列表","tableName":"huodongleixing"}],"menu":"活动类型管理"},{"child":[{"appFrontIcon":"cuIcon-qrcode","buttons":["查看","修改","删除"],"menu":"志愿活动","menuJump":"列表","tableName":"zhiyuanhuodong"}],"menu":"志愿活动管理"},{"child":[{"appFrontIcon":"cuIcon-vip","buttons":["查看","修改","删除"],"menu":"组织报名","menuJump":"列表","tableName":"zuzhibaoming"}],"menu":"组织报名管理"},{"child":[{"appFrontIcon":"cuIcon-newshot","buttons":["查看","修改","删除"],"menu":"活动报名","menuJump":"列表","tableName":"huodongbaoming"}],"menu":"活动报名管理"},{"child":[{"appFrontIcon":"cuIcon-form","buttons":["查看","修改","回复","删除"],"menu":"留言板管理","tableName":"messages"}],"menu":"留言板管理"},{"child":[{"appFrontIcon":"cuIcon-explore","buttons":["查看","修改"],"menu":"轮播图管理","tableName":"config"},{"appFrontIcon":"cuIcon-news","buttons":["新增","查看","修改","删除"],"menu":"公告信息","tableName":"news"},{"appFrontIcon":"cuIcon-shop","buttons":["查看","修改"],"menu":"关于我们","tableName":"aboutus"}],"menu":"系统管理"}],"frontMenu":[{"child":[{"appFrontIcon":"cuIcon-vip","buttons":["查看","报名"],"menu":"志愿组织列表","menuJump":"列表","tableName":"zhiyuanzuzhi"}],"menu":"志愿组织模块"},{"child":[{"appFrontIcon":"cuIcon-flashlightopen","buttons":["查看"],"menu":"组织风采列表","menuJump":"列表","tableName":"zuzhifengcai"}],"menu":"组织风采模块"},{"child":[{"appFrontIcon":"cuIcon-vip","buttons":["查看","报名"],"menu":"志愿活动列表","menuJump":"列表","tableName":"zhiyuanhuodong"}],"menu":"志愿活动模块"}],"hasBackLogin":"是","hasBackRegister":"否","hasFrontLogin":"否","hasFrontRegister":"否","roleName":"管理员","tableName":"users"},{"backMenu":[{"child":[{"appFrontIcon":"cuIcon-vip","buttons":["查看"],"menu":"组织报名","menuJump":"列表","tableName":"zuzhibaoming"}],"menu":"组织报名管理"},{"child":[{"appFrontIcon":"cuIcon-newshot","buttons":["查看"],"menu":"活动报名","menuJump":"列表","tableName":"huodongbaoming"}],"menu":"活动报名管理"}],"frontMenu":[{"child":[{"appFrontIcon":"cuIcon-vip","buttons":["查看","报名"],"menu":"志愿组织列表","menuJump":"列表","tableName":"zhiyuanzuzhi"}],"menu":"志愿组织模块"},{"child":[{"appFrontIcon":"cuIcon-flashlightopen","buttons":["查看"],"menu":"组织风采列表","menuJump":"列表","tableName":"zuzhifengcai"}],"menu":"组织风采模块"},{"child":[{"appFrontIcon":"cuIcon-vip","buttons":["查看","报名"],"menu":"志愿活动列表","menuJump":"列表","tableName":"zhiyuanhuodong"}],"menu":"志愿活动模块"}],"hasBackLogin":"是","hasBackRegister":"否","hasFrontLogin":"是","hasFrontRegister":"是","roleName":"志愿者","tableName":"zhiyuanzhe"},{"backMenu":[{"child":[{"appFrontIcon":"cuIcon-qrcode","buttons":["新增","查看","修改","删除"],"menu":"组织风采","menuJump":"列表","tableName":"zuzhifengcai"}],"menu":"组织风采管理"},{"child":[{"appFrontIcon":"cuIcon-qrcode","buttons":["新增","查看","修改","删除"],"menu":"志愿活动","menuJump":"列表","tableName":"zhiyuanhuodong"}],"menu":"志愿活动管理"},{"child":[{"appFrontIcon":"cuIcon-vip","buttons":["查看","删除","审核"],"menu":"组织报名","menuJump":"列表","tableName":"zuzhibaoming"}],"menu":"组织报名管理"},{"child":[{"appFrontIcon":"cuIcon-newshot","buttons":["查看","删除","审核"],"menu":"活动报名","menuJump":"列表","tableName":"huodongbaoming"}],"menu":"活动报名管理"}],"frontMenu":[{"child":[{"appFrontIcon":"cuIcon-vip","buttons":["查看","报名"],"menu":"志愿组织列表","menuJump":"列表","tableName":"zhiyuanzuzhi"}],"menu":"志愿组织模块"},{"child":[{"appFrontIcon":"cuIcon-flashlightopen","buttons":["查看"],"menu":"组织风采列表","menuJump":"列表","tableName":"zuzhifengcai"}],"menu":"组织风采模块"},{"child":[{"appFrontIcon":"cuIcon-vip","buttons":["查看","报名"],"menu":"志愿活动列表","menuJump":"列表","tableName":"zhiyuanhuodong"}],"menu":"志愿活动模块"}],"hasBackLogin":"是","hasBackRegister":"是","hasFrontLogin":"是","hasFrontRegister":"否","roleName":"志愿组织","tableName":"zhiyuanzuzhi"}],
			loginForm: {
				username: '',
				password: '',
				tableName: '',
				code: '',
			},
			role: '',
            roles: [],
			rules: {
				username: [
					{ required: true, message: '请输入账户', trigger: 'blur' }
				],
				password: [
					{ required: true, message: '请输入密码', trigger: 'blur' }
				]
			},
			codes: [{
				num: 1,
				color: '#000',
				rotate: '10deg',
				size: '16px'
			}, {
				num: 2,
				color: '#000',
				rotate: '10deg',
				size: '16px'
			}, {
				num: 3,
				color: '#000',
				rotate: '10deg',
				size: '16px'
			}, {
				num: 4,
				color: '#000',
				rotate: '10deg',
				size: '16px'
			}]
		}
	},
	created() {
        for(let item in this.roleMenus) {
            if(this.roleMenus[item].hasFrontLogin=='是') {
                this.roles.push(this.roleMenus[item]);
            }
        }
	},
	mounted() {
	},
    //方法集合
    methods: {
		randomString() {
			var len = 4;
			var chars = [
			  'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k',
			  'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v',
			  'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G',
			  'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R',
			  'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '0', '1', '2',
			  '3', '4', '5', '6', '7', '8', '9'
			]
			var colors = ['0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f']
			var sizes = ['14', '15', '16', '17', '18']
			
			var output = []
			for (var i = 0; i < len; i++) {
			  // 随机验证码
			  var key = Math.floor(Math.random() * chars.length)
			  this.codes[i].num = chars[key]
			  // 随机验证码颜色
			  var code = '#'
			  for (var j = 0; j < 6; j++) {
			    var key = Math.floor(Math.random() * colors.length)
			    code += colors[key]
			  }
			  this.codes[i].color = code
			  // 随机验证码方向
			  var rotate = Math.floor(Math.random() * 45)
			  var plus = Math.floor(Math.random() * 2)
			  if (plus == 1) rotate = '-' + rotate
			  this.codes[i].rotate = 'rotate(' + rotate + 'deg)'
			  // 随机验证码字体大小
			  var size = Math.floor(Math.random() * sizes.length)
			  this.codes[i].size = sizes[size] + 'px'
			}
		},
      getCurrentRow(row) {
        this.role = row.roleName;
      },
      submitForm(formName) {
        if (this.roles.length!=1) {
            if (!this.role) {
                this.$message.error("请选择登录用户类型");
                return false;
            }
        } else {
            this.role = this.roles[0].roleName;
            this.loginForm.tableName = this.roles[0].tableName;
        }
        this.$refs[formName].validate((valid) => {
          if (valid) {
            this.$http.get(`${this.loginForm.tableName}/login`, {params: this.loginForm}).then(res => {
              if (res.data.code === 0) {
                localStorage.setItem('Token', res.data.token);
                localStorage.setItem('UserTableName', this.loginForm.tableName);
                localStorage.setItem('username', this.loginForm.username);
                localStorage.setItem('adminName', this.loginForm.username);
                localStorage.setItem('sessionTable', this.loginForm.tableName);
                localStorage.setItem('role', this.role);
                localStorage.setItem('keyPath', this.$config.indexNav.length+2);
                this.$router.push('/index/center');
                this.$message({
                  message: '登录成功',
                  type: 'success',
                  duration: 1500,
                });
              } else {
                this.$message.error(res.data.msg);
              }
            });
          } else {
            return false;
          }
        });
      },
      resetForm(formName) {
        this.$refs[formName].resetFields();
      }
    }
  }
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
	.container {
		position: relative;
		background: url(http://codegen.caihongy.cn/20230117/7929bf8c61b346319944c0d8bfe3dc60.jpg) no-repeat center bottom / 100% 100%,#fff;
		
		.el-form-item {
		  & /deep/ .el-form-item__content {
		    width: 100%;
		  }
		}
		
		.list-item /deep/ .el-input .el-input__inner {
			border: 1px solid #ddd;
			padding: 0 10px;
			box-shadow: 0 0 0px rgba(64, 158, 255, .5);
			color: #333;
			background: linear-gradient(240deg, rgba(246,246,246,1) 0%, rgba(246,246,246,1) 50%, rgba(238,238,238,1) 50%, rgba(238,238,238,1) 100%);
			width: 100%;
			font-size: 14px;
			outline-offset: 4px;
			height: 44px;
		}
		
		.list-code /deep/ .el-input .el-input__inner {
			border: 1px solid #ddd;
			padding: 0 10px;
			outline: none;
			color: #333;
			background: linear-gradient(240deg, rgba(246,246,246,1) 0%, rgba(246,246,246,1) 50%, rgba(238,238,238,1) 50%, rgba(238,238,238,1) 100%);
			display: inline-block;
			vertical-align: middle;
			width: calc(100% - 130px);
			font-size: 14px;
			height: 44px;
		}
		
		.list-type /deep/ .el-radio__input .el-radio__inner {
			background: rgba(53, 53, 53, 0);
			border-color: #666666;
		}
		.list-type /deep/ .el-radio__input.is-checked .el-radio__inner {
			color: #7e5ffb;
			background: #7e5ffb;
			border-color: #7e5ffb;
		}
		.list-type /deep/ .el-radio__label {
			color: #666666;
			font-size: 14px;
		}
		.list-type /deep/ .el-radio__input.is-checked+.el-radio__label {
			color: #7e5ffb;
			font-size: 14px;
		}
	}
</style>
