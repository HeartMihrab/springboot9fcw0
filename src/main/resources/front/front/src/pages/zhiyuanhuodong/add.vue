<template>
<div :style='{"width":"85%","padding":"20px","margin":"10px auto","position":"relative","background":"rgba(255,255,255,0.8)"}'>
    <el-form
      class="add-update-preview"
      ref="ruleForm"
      :model="ruleForm"
      :rules="rules"
      label-width="120px"
    >
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"none"}' label="活动主题" prop="huodongzhuti">
            <el-input v-model="ruleForm.huodongzhuti" 
                placeholder="活动主题" clearable ></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"none"}'  label="活动类型" prop="huodongleixing">
            <el-select v-model="ruleForm.huodongleixing" placeholder="请选择活动类型"  >
              <el-option
                  v-for="(item,index) in huodongleixingOptions"
                  :key="index"
                  :label="item"
                  :value="item">
              </el-option>
            </el-select>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"none"}' label="活动图片" v-if="type!='cross' || (type=='cross' && !ro.huodongtupian)" prop="huodongtupian">
            <file-upload
            tip="点击上传活动图片"
            action="file/upload"
            :limit="3"
            :multiple="true"
            :fileUrls="ruleForm.huodongtupian?ruleForm.huodongtupian:''"
            @change="huodongtupianUploadChange"
            ></file-upload>
          </el-form-item>
            <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"none"}' class="upload" v-else label="活动图片" prop="huodongtupian">
                <img v-if="ruleForm.huodongtupian.substring(0,4)=='http'" class="upload-img" style="margin-right:20px;" v-bind:key="index" :src="ruleForm.huodongtupian.split(',')[0]" width="100" height="100">
                <img v-else class="upload-img" style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in ruleForm.huodongtupian.split(',')" :src="baseUrl+item" width="100" height="100">
            </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"none"}' label="活动地点" prop="huodongdidian">
            <el-input v-model="ruleForm.huodongdidian" 
                placeholder="活动地点" clearable ></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"none"}' label="开始时间" prop="kaishishijian" >
              <el-date-picker
                  value-format="yyyy-MM-dd HH:mm:ss"
                  v-model="ruleForm.kaishishijian" 
                  type="datetime"
                  placeholder="开始时间">
              </el-date-picker>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"none"}' label="结束时间" prop="jieshushijian" >
              <el-date-picker
                  value-format="yyyy-MM-dd HH:mm:ss"
                  v-model="ruleForm.jieshushijian" 
                  type="datetime"
                  placeholder="结束时间">
              </el-date-picker>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"none"}' label="组织编号" prop="zuzhibianhao">
            <el-input v-model="ruleForm.zuzhibianhao" 
                placeholder="组织编号" clearable ></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"none"}' label="组织名称" prop="zuzhimingcheng">
            <el-input v-model="ruleForm.zuzhimingcheng" 
                placeholder="组织名称" clearable ></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"none"}' label="发布时间" prop="fabushijian" >
              <el-date-picker
                  format="yyyy 年 MM 月 dd 日"
                  value-format="yyyy-MM-dd"
                  v-model="ruleForm.fabushijian" 
                  type="date"
                  placeholder="发布时间">
              </el-date-picker> 
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"none"}' label="活动详情" prop="huodongxiangqing">
            <editor 
                :style='{"minHeight":"300px","padding":"0","boxShadow":"0 0 1px #ccc","margin":"0","borderColor":"#ccc","backgroundColor":"#fff","borderRadius":"0","borderWidth":"0","width":"100%","borderStyle":"solid","height":"auto"}'
                v-model="ruleForm.huodongxiangqing" 
                class="editor" 
                action="file/upload">
            </editor>
          </el-form-item>

      <el-form-item :style='{"padding":"0","textAlign":"center","margin":"0"}'>
        <el-button :style='{"border":"1px solid #9179f2","cursor":"pointer","padding":"0","boxShadow":"inset 0px 0px 56px 0px #7e5ffb","margin":"0 20px 0 0","color":"#111","outline":"none","borderRadius":"4px","background":"#fff","width":"128px","lineHeight":"40px","fontSize":"14px","height":"40px"}'  type="primary" @click="onSubmit">提交</el-button>
        <el-button :style='{"border":"1px solid #dfd130","cursor":"pointer","padding":"0","boxShadow":"inset 0px 0px 36px 0px #f2e013","margin":"0","color":"#111","outline":"none","borderRadius":"4px","background":"#fff","width":"128px","lineHeight":"40px","fontSize":"14px","height":"40px"}' @click="back()">返回</el-button>
      </el-form-item>
    </el-form>
</div>
</template>

<script>
  export default {
    data() {
      return {
        id: '',
        baseUrl: '',
        ro:{
            huodongzhuti : false,
            huodongleixing : false,
            huodongtupian : false,
            huodongdidian : false,
            kaishishijian : false,
            jieshushijian : false,
            huodongxiangqing : false,
            zuzhibianhao : false,
            zuzhimingcheng : false,
            fabushijian : false,
        },
        type: '',
        userTableName: localStorage.getItem('UserTableName'),
        ruleForm: {
          huodongzhuti: '',
          huodongleixing: '',
          huodongtupian: '',
          huodongdidian: '',
          kaishishijian: '',
          jieshushijian: '',
          huodongxiangqing: '',
          zuzhibianhao: '',
          zuzhimingcheng: '',
          fabushijian: '',
        },
        huodongleixingOptions: [],
        rules: {
          huodongzhuti: [
          ],
          huodongleixing: [
          ],
          huodongtupian: [
          ],
          huodongdidian: [
          ],
          kaishishijian: [
          ],
          jieshushijian: [
          ],
          huodongxiangqing: [
          ],
          zuzhibianhao: [
          ],
          zuzhimingcheng: [
          ],
          fabushijian: [
          ],
        },
      };
    },
    computed: {



    },
    created() {
	  //this.bg();
      let type = this.$route.query.type ? this.$route.query.type : '';
      this.init(type);
      this.baseUrl = this.$config.baseUrl;
      this.ruleForm.fabushijian = this.getCurDate()
    },
    methods: {
      getMakeZero(s) {
          return s < 10 ? '0' + s : s;
      },
      // 下载
      download(file){
        window.open(`${file}`)
      },
      // 初始化
      init(type) {
        this.type = type;
        if(type=='cross'){
          var obj = JSON.parse(localStorage.getItem('crossObj'));
          for (var o in obj){
            if(o=='huodongzhuti'){
              this.ruleForm.huodongzhuti = obj[o];
              this.ro.huodongzhuti = true;
              continue;
            }
            if(o=='huodongleixing'){
              this.ruleForm.huodongleixing = obj[o];
              this.ro.huodongleixing = true;
              continue;
            }
            if(o=='huodongtupian'){
              this.ruleForm.huodongtupian = obj[o].split(",")[0];
              this.ro.huodongtupian = true;
              continue;
            }
            if(o=='huodongdidian'){
              this.ruleForm.huodongdidian = obj[o];
              this.ro.huodongdidian = true;
              continue;
            }
            if(o=='kaishishijian'){
              this.ruleForm.kaishishijian = obj[o];
              this.ro.kaishishijian = true;
              continue;
            }
            if(o=='jieshushijian'){
              this.ruleForm.jieshushijian = obj[o];
              this.ro.jieshushijian = true;
              continue;
            }
            if(o=='huodongxiangqing'){
              this.ruleForm.huodongxiangqing = obj[o];
              this.ro.huodongxiangqing = true;
              continue;
            }
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
            if(o=='fabushijian'){
              this.ruleForm.fabushijian = obj[o];
              this.ro.fabushijian = true;
              continue;
            }
          }
        }
        // 获取用户信息
        this.$http.get(this.userTableName + '/session', {emulateJSON: true}).then(res => {
          if (res.data.code == 0) {
            var json = res.data.data;
            if((json.zuzhibianhao!=''&&json.zuzhibianhao) || json.zuzhibianhao==0){
                this.ruleForm.zuzhibianhao = json.zuzhibianhao
            }
            if((json.zuzhimingcheng!=''&&json.zuzhimingcheng) || json.zuzhimingcheng==0){
                this.ruleForm.zuzhimingcheng = json.zuzhimingcheng
            }
          }
        });
        this.$http.get('option/huodongleixing/huodongleixing', {emulateJSON: true}).then(res => {
          if (res.data.code == 0) {
            this.huodongleixingOptions = res.data.data;
          }
        });
      },

    // 多级联动参数
      // 多级联动参数
      info(id) {
        this.$http.get('zhiyuanhuodong/detail/${id}', {emulateJSON: true}).then(res => {
          if (res.data.code == 0) {
            this.ruleForm = res.data.data;
          }
        });
      },
      // 提交
      onSubmit() {

        //更新跨表属性
        var crossuserid;
        var crossrefid;
        var crossoptnum;
        this.$refs["ruleForm"].validate(valid => {
          if(valid) {
            if(this.type=='cross'){
                 var statusColumnName = localStorage.getItem('statusColumnName');
                 var statusColumnValue = localStorage.getItem('statusColumnValue');
                 if(statusColumnName && statusColumnName!='') {
                     var obj = JSON.parse(localStorage.getItem('crossObj'));
                     if(!statusColumnName.startsWith("[")) {
                         for (var o in obj){
                             if(o==statusColumnName){
                                 obj[o] = statusColumnValue;
                             }
                         }
                         var table = localStorage.getItem('crossTable');
                         this.$http.post(table+'/update', obj).then(res => {});
                     } else {
                            crossuserid=Number(localStorage.getItem('userid'));
                            crossrefid=obj['id'];
                            crossoptnum=localStorage.getItem('statusColumnName');
                            crossoptnum=crossoptnum.replace(/\[/,"").replace(/\]/,"");
                     }
                 }
            }
            if(crossrefid && crossuserid) {
                 this.ruleForm.crossuserid=crossuserid;
                 this.ruleForm.crossrefid=crossrefid;
                 var params = {
                     page: 1,
                     limit: 10,
                     crossuserid:crossuserid,
                     crossrefid:crossrefid,
                 }
                 this.$http.get('zhiyuanhuodong/list', {
                  params: params
                 }).then(res => {
                     if(res.data.data.total>=crossoptnum) {
                         this.$message({
                          message: localStorage.getItem('tips'),
                          type: 'success',
                          duration: 1500,
                         });
                          return false;
                     } else {
                         // 跨表计算


                          this.$http.post('zhiyuanhuodong/add', this.ruleForm).then(res => {
                              if (res.data.code == 0) {
                                  this.$message({
                                      message: '操作成功',
                                      type: 'success',
                                      duration: 1500,
                                      onClose: () => {
                                          this.$router.go(-1);
                                      }
                                  });
                              } else {
                                  this.$message({
                                      message: res.data.msg,
                                      type: 'error',
                                      duration: 1500
                                  });
                              }
                          });
                     }
                 });
             } else {


                  this.$http.post('zhiyuanhuodong/add', this.ruleForm).then(res => {
                     if (res.data.code == 0) {
                          this.$message({
                              message: '操作成功',
                              type: 'success',
                              duration: 1500,
                              onClose: () => {
                                  this.$router.go(-1);
                              }
                          });
                      } else {
                          this.$message({
                              message: res.data.msg,
                              type: 'error',
                              duration: 1500
                          });
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
        this.$router.go(-1);
      },
      huodongtupianUploadChange(fileUrls) {
          this.ruleForm.huodongtupian = fileUrls.replace(new RegExp(this.$config.baseUrl,"g"),"");;
      },
    }
  };
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
	.el-date-editor.el-input {
		width: auto;
	}
	
	.add-update-preview .el-form-item /deep/ .el-form-item__label {
	  padding: 0 10px 0 0;
	  color: #7e5ffb;
	  font-weight: 500;
	  width: 120px;
	  font-size: 14px;
	  line-height: 40px;
	  text-align: right;
	}
	
	.add-update-preview .el-form-item /deep/ .el-form-item__content {
	  margin-left: 120px;
	}
	
	.add-update-preview .el-input /deep/ .el-input__inner {
	  border: 0;
	  border-radius: 4px;
	  padding: 0 12px;
	  outline: none;
	  color: #333;
	  background: linear-gradient(240deg, rgba(246,246,246,1) 0%, rgba(246,246,246,1) 50%, rgba(238,238,238,1) 50%, rgba(238,238,238,1) 100%);
	  width: auto;
	  font-size: 14px;
	  min-width: 400px;
	  height: 40px;
	}
	
	.add-update-preview .el-select /deep/ .el-input__inner {
	  border: 0;
	  border-radius: 4px;
	  padding: 0 10px;
	  outline: none;
	  color: #333;
	  background: linear-gradient(240deg, rgba(246,246,246,1) 0%, rgba(246,246,246,1) 50%, rgba(238,238,238,1) 50%, rgba(238,238,238,1) 100%);
	  width: auto;
	  font-size: 14px;
	  min-width: 200px;
	  height: 40px;
	}
	
	.add-update-preview .el-date-editor /deep/ .el-input__inner {
	  border: 0;
	  border-radius: 4px;
	  padding: 0 10px 0 30px;
	  outline: none;
	  color: #333;
	  background: linear-gradient(240deg, rgba(246,246,246,1) 0%, rgba(246,246,246,1) 50%, rgba(238,238,238,1) 50%, rgba(238,238,238,1) 100%);
	  width: auto;
	  font-size: 14px;
	  min-width: 300px;
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
	  border: 1px dashed #ddd;
	  cursor: pointer;
	  border-radius: 6px;
	  color: #999;
	  background: linear-gradient(240deg, rgba(246,246,246,1) 0%, rgba(246,246,246,1) 50%, rgba(238,238,238,1) 50%, rgba(238,238,238,1) 100%);
	  width: 100px;
	  font-size: 32px;
	  line-height: 100px;
	  text-align: center;
	  height: 100px;
	}
	
	.add-update-preview /deep/ .el-upload-list .el-upload-list__item {
	  border: 1px dashed #ddd;
	  cursor: pointer;
	  border-radius: 6px;
	  color: #999;
	  background: linear-gradient(240deg, rgba(246,246,246,1) 0%, rgba(246,246,246,1) 50%, rgba(238,238,238,1) 50%, rgba(238,238,238,1) 100%);
	  width: 100px;
	  font-size: 32px;
	  line-height: 100px;
	  text-align: center;
	  height: 100px;
	}
	
	.add-update-preview /deep/ .el-upload .el-icon-plus {
	  border: 1px dashed #ddd;
	  cursor: pointer;
	  border-radius: 6px;
	  color: #999;
	  background: linear-gradient(240deg, rgba(246,246,246,1) 0%, rgba(246,246,246,1) 50%, rgba(238,238,238,1) 50%, rgba(238,238,238,1) 100%);
	  width: 100px;
	  font-size: 32px;
	  line-height: 100px;
	  text-align: center;
	  height: 100px;
	}
	
	.add-update-preview .el-textarea /deep/ .el-textarea__inner {
	  border: 0;
	  border-radius: 4px;
	  padding: 12px;
	  outline: none;
	  color: #333;
	  background: linear-gradient(240deg, rgba(246,246,246,1) 0%, rgba(246,246,246,1) 50%, rgba(238,238,238,1) 50%, rgba(238,238,238,1) 100%);
	  width: auto;
	  font-size: 14px;
	  min-width: 400px;
	  height: 120px;
	}
</style>
