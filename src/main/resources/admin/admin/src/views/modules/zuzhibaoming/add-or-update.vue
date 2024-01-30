<template>
	<div class="addEdit-block" style="width: 100%;">
		<el-form
			:style='{"borderRadius":"6px","padding":"30px","boxShadow":"0 1px 6px #59362f"}'
			class="add-update-preview"
			ref="ruleForm"
			:model="ruleForm"
			:rules="rules"
			label-width="140px"
		>
			<template >
				<el-form-item :style='{"width":"45%","margin":"0 0 20px 0","display":"inline-block"}' class="input" v-if="type!='info'"  label="组织编号" prop="zuzhibianhao">
					<el-input v-model="ruleForm.zuzhibianhao" placeholder="组织编号" clearable  :readonly="ro.zuzhibianhao"></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"45%","margin":"0 0 20px 0","display":"inline-block"}' v-else class="input" label="组织编号" prop="zuzhibianhao">
					<el-input v-model="ruleForm.zuzhibianhao" placeholder="组织编号" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"45%","margin":"0 0 20px 0","display":"inline-block"}' class="input" v-if="type!='info'"  label="组织名称" prop="zuzhimingcheng">
					<el-input v-model="ruleForm.zuzhimingcheng" placeholder="组织名称" clearable  :readonly="ro.zuzhimingcheng"></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"45%","margin":"0 0 20px 0","display":"inline-block"}' v-else class="input" label="组织名称" prop="zuzhimingcheng">
					<el-input v-model="ruleForm.zuzhimingcheng" placeholder="组织名称" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"45%","margin":"0 0 20px 0","display":"inline-block"}' class="input" v-if="type!='info'"  label="志愿者账号" prop="zhiyuanzhezhanghao">
					<el-input v-model="ruleForm.zhiyuanzhezhanghao" placeholder="志愿者账号" clearable  :readonly="ro.zhiyuanzhezhanghao"></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"45%","margin":"0 0 20px 0","display":"inline-block"}' v-else class="input" label="志愿者账号" prop="zhiyuanzhezhanghao">
					<el-input v-model="ruleForm.zhiyuanzhezhanghao" placeholder="志愿者账号" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"45%","margin":"0 0 20px 0","display":"inline-block"}' class="input" v-if="type!='info'"  label="志愿者姓名" prop="zhiyuanzhexingming">
					<el-input v-model="ruleForm.zhiyuanzhexingming" placeholder="志愿者姓名" clearable  :readonly="ro.zhiyuanzhexingming"></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"45%","margin":"0 0 20px 0","display":"inline-block"}' v-else class="input" label="志愿者姓名" prop="zhiyuanzhexingming">
					<el-input v-model="ruleForm.zhiyuanzhexingming" placeholder="志愿者姓名" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"45%","margin":"0 0 20px 0","display":"inline-block"}' class="date" v-if="type!='info'" label="报名时间" prop="baomingshijian">
					<el-date-picker
						format="yyyy 年 MM 月 dd 日"
						value-format="yyyy-MM-dd"
						v-model="ruleForm.baomingshijian" 
						type="date"
						:readonly="ro.baomingshijian"
						placeholder="报名时间"
					></el-date-picker> 
				</el-form-item>
				<el-form-item :style='{"width":"45%","margin":"0 0 20px 0","display":"inline-block"}' class="input" v-else-if="ruleForm.baomingshijian" label="报名时间" prop="baomingshijian">
					<el-input v-model="ruleForm.baomingshijian" placeholder="报名时间" readonly></el-input>
				</el-form-item>
			</template>
				<el-form-item :style='{"width":"45%","margin":"0 0 20px 0","display":"inline-block"}' v-if="type!='info'"  label="申请理由" prop="shenqingliyou">
					<editor 
						style="min-width: 200px; max-width: 600px;"
						v-model="ruleForm.shenqingliyou" 
						class="editor" 
						action="file/upload">
					</editor>
				</el-form-item>
				<el-form-item :style='{"width":"45%","margin":"0 0 20px 0","display":"inline-block"}' v-else-if="ruleForm.shenqingliyou" label="申请理由" prop="shenqingliyou">
                    <span :style='{"fontSize":"14px","lineHeight":"40px","color":"#59362f","fontWeight":"500","display":"inline-block"}' v-html="ruleForm.shenqingliyou"></span>
                </el-form-item>
			<el-form-item :style='{"borderRadius":"0px 0px 30px 30px","padding":"0","margin":"0"}' class="btn">
				<el-button :style='{"border":"0","cursor":"pointer","padding":"0","margin":"0 20px 0 0","outline":"none","color":"rgba(255, 255, 255, 1)","borderRadius":"0px 0px 30px 30px","background":"rgba(154, 92, 85, 1)","width":"128px","lineHeight":"40px","fontSize":"14px","height":"40px"}'  v-if="type!='info'" type="primary" class="btn-success" @click="onSubmit">提交</el-button>
				<el-button :style='{"border":"1px solid rgba(154, 92, 85, 1)","cursor":"pointer","padding":"0","margin":"0","outline":"none","color":"rgba(154, 92, 85, 1)","borderRadius":"0px 0px 30px 30px","background":"rgba(255, 255, 255, 1)","width":"128px","lineHeight":"40px","fontSize":"14px","height":"40px"}' v-if="type!='info'" class="btn-close" @click="back()">取消</el-button>
				<el-button :style='{"border":"1px solid rgba(154, 92, 85, 1)","cursor":"pointer","padding":"0","margin":"0","outline":"none","color":"rgba(154, 92, 85, 1)","borderRadius":"0px 0px 30px 30px","background":"rgba(255, 255, 255, 1)","width":"128px","lineHeight":"40px","fontSize":"14px","height":"40px"}' v-if="type=='info'" class="btn-close" @click="back()">返回</el-button>
			</el-form-item>
		</el-form>
    

  </div>
</template>
<script>
// 数字，邮件，手机，url，身份证校验
import { isNumber,isIntNumer,isEmail,isPhone, isMobile,isURL,checkIdCard } from "@/utils/validate";
export default {
	data() {
		let self = this
		var validateIdCard = (rule, value, callback) => {
			if(!value){
				callback();
			} else if (!checkIdCard(value)) {
				callback(new Error("请输入正确的身份证号码"));
			} else {
				callback();
			}
		};
		var validateUrl = (rule, value, callback) => {
			if(!value){
				callback();
			} else if (!isURL(value)) {
				callback(new Error("请输入正确的URL地址"));
			} else {
				callback();
			}
		};
		var validateMobile = (rule, value, callback) => {
			if(!value){
				callback();
			} else if (!isMobile(value)) {
				callback(new Error("请输入正确的手机号码"));
			} else {
				callback();
			}
		};
		var validatePhone = (rule, value, callback) => {
			if(!value){
				callback();
			} else if (!isPhone(value)) {
				callback(new Error("请输入正确的电话号码"));
			} else {
				callback();
			}
		};
		var validateEmail = (rule, value, callback) => {
			if(!value){
				callback();
			} else if (!isEmail(value)) {
				callback(new Error("请输入正确的邮箱地址"));
			} else {
				callback();
			}
		};
		var validateNumber = (rule, value, callback) => {
			if(!value){
				callback();
			} else if (!isNumber(value)) {
				callback(new Error("请输入数字"));
			} else {
				callback();
			}
		};
		var validateIntNumber = (rule, value, callback) => {
			if(!value){
				callback();
			} else if (!isIntNumer(value)) {
				callback(new Error("请输入整数"));
			} else {
				callback();
			}
		};
		return {
			id: '',
			type: '',
			
			
			ro:{
				zuzhibianhao : false,
				zuzhimingcheng : false,
				zhiyuanzhezhanghao : false,
				zhiyuanzhexingming : false,
				shenqingliyou : false,
				baomingshijian : false,
				sfsh : false,
				shhf : false,
			},
			
			
			ruleForm: {
				zuzhibianhao: '',
				zuzhimingcheng: '',
				zhiyuanzhezhanghao: '',
				zhiyuanzhexingming: '',
				shenqingliyou: '',
				baomingshijian: '',
				shhf: '',
			},
		
			
			rules: {
				zuzhibianhao: [
				],
				zuzhimingcheng: [
				],
				zhiyuanzhezhanghao: [
				],
				zhiyuanzhexingming: [
				],
				shenqingliyou: [
				],
				baomingshijian: [
				],
				sfsh: [
				],
				shhf: [
				],
			}
		};
	},
	props: ["parent"],
	computed: {



	},
	created() {
		this.ruleForm.baomingshijian = this.getCurDate()
	},
	methods: {
		
		// 下载
		download(file){
			window.open(`${file}`)
		},
		// 初始化
		init(id,type) {
			if (id) {
				this.id = id;
				this.type = type;
			}
			if(this.type=='info'||this.type=='else'){
				this.info(id);
			}else if(this.type=='logistics'){
				this.logistics=false;
				this.info(id);
			}else if(this.type=='cross'){
				var obj = this.$storage.getObj('crossObj');
				for (var o in obj){
						if(o=='zuzhibianhao'){
							this.ruleForm.zuzhibianhao = obj[o];
							this.ro.zuzhibianhao = true;
							continue;
						}
						if(o=='zuzhimingcheng'){
							this.ruleForm.zuzhimingcheng = obj[o];
							this.ro.zuzhimingcheng = true;
							continue;
						}
						if(o=='zhiyuanzhezhanghao'){
							this.ruleForm.zhiyuanzhezhanghao = obj[o];
							this.ro.zhiyuanzhezhanghao = true;
							continue;
						}
						if(o=='zhiyuanzhexingming'){
							this.ruleForm.zhiyuanzhexingming = obj[o];
							this.ro.zhiyuanzhexingming = true;
							continue;
						}
						if(o=='shenqingliyou'){
							this.ruleForm.shenqingliyou = obj[o];
							this.ro.shenqingliyou = true;
							continue;
						}
						if(o=='baomingshijian'){
							this.ruleForm.baomingshijian = obj[o];
							this.ro.baomingshijian = true;
							continue;
						}
				}
				








			}
			
			
			// 获取用户信息
			this.$http({
				url: `${this.$storage.get('sessionTable')}/session`,
				method: "get"
			}).then(({ data }) => {
				if (data && data.code === 0) {
					
					var json = data.data;
					if(((json.zhiyuanzhezhanghao!=''&&json.zhiyuanzhezhanghao) || json.zhiyuanzhezhanghao==0) && this.$storage.get("role")!="管理员"){
						this.ruleForm.zhiyuanzhezhanghao = json.zhiyuanzhezhanghao
						this.ro.zhiyuanzhezhanghao = true;
					}
					if(((json.zhiyuanzhexingming!=''&&json.zhiyuanzhexingming) || json.zhiyuanzhexingming==0) && this.$storage.get("role")!="管理员"){
						this.ruleForm.zhiyuanzhexingming = json.zhiyuanzhexingming
						this.ro.zhiyuanzhexingming = true;
					}
				} else {
					this.$message.error(data.msg);
				}
			});
			
			
		},
    // 多级联动参数

    info(id) {
      this.$http({
        url: `zuzhibaoming/info/${id}`,
        method: "get"
      }).then(({ data }) => {
        if (data && data.code === 0) {
        this.ruleForm = data.data;
        //解决前台上传图片后台不显示的问题
        let reg=new RegExp('../../../upload','g')//g代表全部
        this.ruleForm.shenqingliyou = this.ruleForm.shenqingliyou.replace(reg,'../../../springboot9fcw0/upload');
        } else {
          this.$message.error(data.msg);
        }
      });
    },


    // 提交
    onSubmit() {

















var objcross = this.$storage.getObj('crossObj');

      //更新跨表属性
       var crossuserid;
       var crossrefid;
       var crossoptnum;
       if(this.type=='cross'){
                var statusColumnName = this.$storage.get('statusColumnName');
                var statusColumnValue = this.$storage.get('statusColumnValue');
                if(statusColumnName!='') {
                        var obj = this.$storage.getObj('crossObj');
                       if(statusColumnName && !statusColumnName.startsWith("[")) {
                               for (var o in obj){
                                 if(o==statusColumnName){
                                   obj[o] = statusColumnValue;
                                 }
                               }
                               var table = this.$storage.get('crossTable');
                             this.$http({
                                 url: `${table}/update`,
                                 method: "post",
                                 data: obj
                               }).then(({ data }) => {});
                       } else {
                               crossuserid=this.$storage.get('userid');
                               crossrefid=obj['id'];
                               crossoptnum=this.$storage.get('statusColumnName');
                               crossoptnum=crossoptnum.replace(/\[/,"").replace(/\]/,"");
                        }
                }
        }
       this.$refs["ruleForm"].validate(valid => {
         if (valid) {
		 if(crossrefid && crossuserid) {
			 this.ruleForm.crossuserid = crossuserid;
			 this.ruleForm.crossrefid = crossrefid;
			let params = { 
				page: 1, 
				limit: 10, 
				crossuserid:this.ruleForm.crossuserid,
				crossrefid:this.ruleForm.crossrefid,
			} 
			this.$http({ 
				url: "zuzhibaoming/page", 
				method: "get", 
				params: params 
			}).then(({ 
				data 
			}) => { 
				if (data && data.code === 0) { 
				       if(data.data.total>=crossoptnum) {
					     this.$message.error(this.$storage.get('tips'));
					       return false;
				       } else {
					 this.$http({
					   url: `zuzhibaoming/${!this.ruleForm.id ? "save" : "update"}`,
					   method: "post",
					   data: this.ruleForm
					 }).then(({ data }) => {
					   if (data && data.code === 0) {
					     this.$message({
					       message: "操作成功",
					       type: "success",
					       duration: 1500,
					       onClose: () => {
						 this.parent.showFlag = true;
						 this.parent.addOrUpdateFlag = false;
						 this.parent.zuzhibaomingCrossAddOrUpdateFlag = false;
						 this.parent.search();
						 this.parent.contentStyleChange();
					       }
					     });
					   } else {
					     this.$message.error(data.msg);
					   }
					 });

				       }
				} else { 
				} 
			});
		 } else {
			 this.$http({
			   url: `zuzhibaoming/${!this.ruleForm.id ? "save" : "update"}`,
			   method: "post",
			   data: this.ruleForm
			 }).then(({ data }) => {
			   if (data && data.code === 0) {
			     this.$message({
			       message: "操作成功",
			       type: "success",
			       duration: 1500,
			       onClose: () => {
				 this.parent.showFlag = true;
				 this.parent.addOrUpdateFlag = false;
				 this.parent.zuzhibaomingCrossAddOrUpdateFlag = false;
				 this.parent.search();
				 this.parent.contentStyleChange();
			       }
			     });
			   } else {
			     this.$message.error(data.msg);
			   }
			 });
		 }
         }
       });
    },
    // 获取uuid
    getUUID () {
      return new Date().getTime();
    },
    // 返回
    back() {
      this.parent.showFlag = true;
      this.parent.addOrUpdateFlag = false;
      this.parent.zuzhibaomingCrossAddOrUpdateFlag = false;
      this.parent.contentStyleChange();
    },
  }
};
</script>
<style lang="scss" scoped>
	.amap-wrapper {
		width: 100%;
		height: 500px;
	}
	
	.search-box {
		position: absolute;
	}
	
	.el-date-editor.el-input {
		width: auto;
	}
	
	.add-update-preview .el-form-item /deep/ .el-form-item__label {
	  	  padding: 0 10px 0 0;
	  	  color: #59362f;
	  	  font-weight: 600;
	  	  width: 140px;
	  	  font-size: 14px;
	  	  line-height: 40px;
	  	  text-align: right;
	  	}
	
	.add-update-preview .el-form-item /deep/ .el-form-item__content {
	  margin-left: 140px;
	}
	
	.add-update-preview .el-input /deep/ .el-input__inner {
	  	  border: 0;
	  	  border-radius: 4px;
	  	  padding: 0 12px;
	  	  box-shadow: 0 0 6px #59362f;
	  	  outline: none;
	  	  color: #59362f;
	  	  width: 400px;
	  	  font-size: 14px;
	  	  height: 40px;
	  	}
	
	.add-update-preview .el-select /deep/ .el-input__inner {
	  	  border: 0;
	  	  border-radius: 4px;
	  	  padding: 0 10px;
	  	  box-shadow: 0 0 6px #59362f;
	  	  outline: none;
	  	  color: #59362f;
	  	  width: 200px;
	  	  font-size: 14px;
	  	  height: 40px;
	  	}
	
	.add-update-preview .el-date-editor /deep/ .el-input__inner {
	  	  border: 0;
	  	  border-radius: 4px;
	  	  padding: 0 10px 0 30px;
	  	  box-shadow: 0 0 6px #59362f;
	  	  outline: none;
	  	  color: #59362f;
	  	  width: 200px;
	  	  font-size: 14px;
	  	  height: 40px;
	  	}
	
	.add-update-preview /deep/ .el-upload--picture-card {
		background: transparent;
		border: 0;
		border-radius: 0;
		width: auto;
		height: auto;
		line-height: initial;
		vertical-align: middle;
	}
	
	.add-update-preview /deep/ .upload .upload-img {
	  	  border: 1px dashed #59362f;
	  	  cursor: pointer;
	  	  border-radius: 6px;
	  	  color: #59362f;
	  	  width: 200px;
	  	  font-size: 32px;
	  	  line-height: 200px;
	  	  text-align: center;
	  	  height: 200px;
	  	}
	
	.add-update-preview /deep/ .el-upload-list .el-upload-list__item {
	  	  border: 1px dashed #59362f;
	  	  cursor: pointer;
	  	  border-radius: 6px;
	  	  color: #59362f;
	  	  width: 200px;
	  	  font-size: 32px;
	  	  line-height: 200px;
	  	  text-align: center;
	  	  height: 200px;
	  	}
	
	.add-update-preview /deep/ .el-upload .el-icon-plus {
	  	  border: 1px dashed #59362f;
	  	  cursor: pointer;
	  	  border-radius: 6px;
	  	  color: #59362f;
	  	  width: 200px;
	  	  font-size: 32px;
	  	  line-height: 200px;
	  	  text-align: center;
	  	  height: 200px;
	  	}
	
	.add-update-preview .el-textarea /deep/ .el-textarea__inner {
	  	  border: 0;
	  	  border-radius: 4px;
	  	  padding: 12px;
	  	  box-shadow: 0 0 6px #59362f;
	  	  outline: none;
	  	  color: #59362f;
	  	  width: 400px;
	  	  font-size: 14px;
	  	  height: 120px;
	  	}
</style>
