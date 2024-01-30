<template>
  <div>
    <el-form
	  :style='{"borderRadius":"6px","padding":"30px","boxShadow":"0 1px 6px #59362f"}'
      class="add-update-preview"
      ref="ruleForm"
      :model="ruleForm"
      label-width="140px"
    >  
     <el-row>
        <el-form-item :style='{"width":"45%","margin":"0 0 20px 0","display":"inline-block"}'   v-if="flag=='zhiyuanzhe'"  label="志愿者账号" prop="zhiyuanzhezhanghao">
          <el-input v-model="ruleForm.zhiyuanzhezhanghao" readonly              placeholder="志愿者账号" clearable></el-input>
        </el-form-item>
        <el-form-item :style='{"width":"45%","margin":"0 0 20px 0","display":"inline-block"}'   v-if="flag=='zhiyuanzhe'"  label="志愿者姓名" prop="zhiyuanzhexingming">
          <el-input v-model="ruleForm.zhiyuanzhexingming"               placeholder="志愿者姓名" clearable></el-input>
        </el-form-item>
        <el-form-item :style='{"width":"45%","margin":"0 0 20px 0","display":"inline-block"}' v-if="flag=='zhiyuanzhe'" label="照片" prop="zhaopian">
          <file-upload
          tip="点击上传照片"
          action="file/upload"
          :limit="3"
          :multiple="true"
          :fileUrls="ruleForm.zhaopian?ruleForm.zhaopian:''"
          @change="zhiyuanzhezhaopianUploadChange"
          ></file-upload>
        </el-form-item>
        <el-form-item :style='{"width":"45%","margin":"0 0 20px 0","display":"inline-block"}' v-if="flag=='zhiyuanzhe'"  label="性别" prop="xingbie">
          <el-select v-model="ruleForm.xingbie"  placeholder="请选择性别">
            <el-option
                v-for="(item,index) in zhiyuanzhexingbieOptions"
                v-bind:key="index"
                :label="item"
                :value="item">
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item :style='{"width":"45%","margin":"0 0 20px 0","display":"inline-block"}'   v-if="flag=='zhiyuanzhe'"  label="年龄" prop="nianling">
          <el-input v-model="ruleForm.nianling"               placeholder="年龄" clearable></el-input>
        </el-form-item>
        <el-form-item :style='{"width":"45%","margin":"0 0 20px 0","display":"inline-block"}'   v-if="flag=='zhiyuanzhe'"  label="手机号码" prop="shoujihaoma">
          <el-input v-model="ruleForm.shoujihaoma"               placeholder="手机号码" clearable></el-input>
        </el-form-item>
        <el-form-item :style='{"width":"45%","margin":"0 0 20px 0","display":"inline-block"}'   v-if="flag=='zhiyuanzuzhi'"  label="组织编号" prop="zuzhibianhao">
          <el-input v-model="ruleForm.zuzhibianhao" readonly              placeholder="组织编号" clearable></el-input>
        </el-form-item>
        <el-form-item :style='{"width":"45%","margin":"0 0 20px 0","display":"inline-block"}'   v-if="flag=='zhiyuanzuzhi'"  label="组织名称" prop="zuzhimingcheng">
          <el-input v-model="ruleForm.zuzhimingcheng"               placeholder="组织名称" clearable></el-input>
        </el-form-item>
        <el-form-item :style='{"width":"45%","margin":"0 0 20px 0","display":"inline-block"}' v-if="flag=='zhiyuanzuzhi'" label="组织logo" prop="tupian">
          <file-upload
          tip="点击上传组织logo"
          action="file/upload"
          :limit="3"
          :multiple="true"
          :fileUrls="ruleForm.tupian?ruleForm.tupian:''"
          @change="zhiyuanzuzhitupianUploadChange"
          ></file-upload>
        </el-form-item>
        <el-form-item :style='{"width":"45%","margin":"0 0 20px 0","display":"inline-block"}'  v-if="flag=='zhiyuanzuzhi'" label="成立时间" prop="chenglishijian">
            <el-date-picker
                format="yyyy 年 MM 月 dd 日"
                value-format="yyyy-MM-dd"
                v-model="ruleForm.chenglishijian" 
                type="date"
                placeholder="成立时间">
            </el-date-picker> 
        </el-form-item>
        <el-form-item :style='{"width":"45%","margin":"0 0 20px 0","display":"inline-block"}'   v-if="flag=='zhiyuanzuzhi'"  label="负责人" prop="fuzeren">
          <el-input v-model="ruleForm.fuzeren"               placeholder="负责人" clearable></el-input>
        </el-form-item>
        <el-form-item :style='{"width":"45%","margin":"0 0 20px 0","display":"inline-block"}'   v-if="flag=='zhiyuanzuzhi'"  label="联系电话" prop="lianxidianhua">
          <el-input v-model="ruleForm.lianxidianhua"               placeholder="联系电话" clearable></el-input>
        </el-form-item>
        <el-form-item :style='{"width":"45%","margin":"0 0 20px 0","display":"inline-block"}'   v-if="flag=='zhiyuanzuzhi'"  label="组织简介" prop="zuzhijianjie">
          <el-input v-model="ruleForm.zuzhijianjie"               placeholder="组织简介" clearable></el-input>
        </el-form-item>
		<el-form-item :style='{"width":"45%","margin":"0 0 20px 0","display":"inline-block"}' v-if="flag=='users'" label="用户名" prop="username">
			<el-input v-model="ruleForm.username" placeholder="用户名"></el-input>
		</el-form-item>
		<el-form-item :style='{"borderRadius":"0px 0px 30px 30px","padding":"0","margin":"0"}'>
			<el-button :style='{"border":"0","cursor":"pointer","padding":"0","margin":"0 20px 0 0","outline":"none","color":"rgba(255, 255, 255, 1)","borderRadius":"0px 0px 30px 30px","background":"rgba(154, 92, 85, 1)","width":"128px","lineHeight":"40px","fontSize":"14px","height":"40px"}' type="primary" @click="onUpdateHandler">修 改</el-button>
		</el-form-item>
      </el-row>
    </el-form>
  </div>
</template>
<script>
// 数字，邮件，手机，url，身份证校验
import { isNumber,isIntNumer,isEmail,isMobile,isPhone,isURL,checkIdCard } from "@/utils/validate";

export default {
  data() {
    return {
      ruleForm: {},
      flag: '',
      usersFlag: false,
      zhiyuanzhexingbieOptions: [],
    };
  },
  mounted() {
    var table = this.$storage.get("sessionTable");
    this.flag = table;
    this.$http({
      url: `${this.$storage.get("sessionTable")}/session`,
      method: "get"
    }).then(({ data }) => {
      if (data && data.code === 0) {
        this.ruleForm = data.data;
      } else {
        this.$message.error(data.msg);
      }
    });
    this.zhiyuanzhexingbieOptions = "男,女".split(',')
  },
  methods: {
    zhiyuanzhezhaopianUploadChange(fileUrls) {
        this.ruleForm.zhaopian = fileUrls;
    },
    zhiyuanzuzhitupianUploadChange(fileUrls) {
        this.ruleForm.tupian = fileUrls;
    },
    onUpdateHandler() {
      if((!this.ruleForm.zhiyuanzhezhanghao)&& 'zhiyuanzhe'==this.flag){
        this.$message.error('志愿者账号不能为空');
        return
      }
      if((!this.ruleForm.mima)&& 'zhiyuanzhe'==this.flag){
        this.$message.error('密码不能为空');
        return
      }
      if((!this.ruleForm.zhiyuanzhexingming)&& 'zhiyuanzhe'==this.flag){
        this.$message.error('志愿者姓名不能为空');
        return
      }
        if(this.ruleForm.zhaopian!=null) {
                this.ruleForm.zhaopian = this.ruleForm.zhaopian.replace(new RegExp(this.$base.url,"g"),"");
        }
      if( 'zhiyuanzhe' ==this.flag && this.ruleForm.nianling&&(!isIntNumer(this.ruleForm.nianling))){
       this.$message.error(`年龄应输入整数`);
        return
      }
      if( 'zhiyuanzhe' ==this.flag && this.ruleForm.shoujihaoma&&(!isMobile(this.ruleForm.shoujihaoma))){
        this.$message.error(`手机号码应输入手机格式`);
        return
      }
      if((!this.ruleForm.zuzhibianhao)&& 'zhiyuanzuzhi'==this.flag){
        this.$message.error('组织编号不能为空');
        return
      }
      if((!this.ruleForm.mima)&& 'zhiyuanzuzhi'==this.flag){
        this.$message.error('密码不能为空');
        return
      }
      if((!this.ruleForm.zuzhimingcheng)&& 'zhiyuanzuzhi'==this.flag){
        this.$message.error('组织名称不能为空');
        return
      }
        if(this.ruleForm.tupian!=null) {
                this.ruleForm.tupian = this.ruleForm.tupian.replace(new RegExp(this.$base.url,"g"),"");
        }
      if( 'zhiyuanzuzhi' ==this.flag && this.ruleForm.lianxidianhua&&(!isMobile(this.ruleForm.lianxidianhua))){
        this.$message.error(`联系电话应输入手机格式`);
        return
      }
      if('users'==this.flag && this.ruleForm.username.trim().length<1) {
	this.$message.error(`用户名不能为空`);
        return	
      }
      this.$http({
        url: `${this.$storage.get("sessionTable")}/update`,
        method: "post",
        data: this.ruleForm
      }).then(({ data }) => {
        if (data && data.code === 0) {
          this.$message({
            message: "修改信息成功",
            type: "success",
            duration: 1500,
            onClose: () => {
            }
          });
        } else {
          this.$message.error(data.msg);
        }
      });
    }
  }
};
</script>
<style lang="scss" scoped>
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
