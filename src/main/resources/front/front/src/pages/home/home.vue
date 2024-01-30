<template>
<div class="home-preview" :style='{"width":"100%","margin":"10px auto","flexWrap":"wrap","background":"none","justifyContent":"space-between","display":"flex"}'>


	<!-- 关于我们 -->
	<div :style='{"padding":"0px ","boxShadow":"0 0px 0px rgba(255, 255, 255, .3)","margin":"40px 0 10px 7%","background":"none","width":"32%","height":"auto","order":"2"}'>
	  <div :style='{"color":"#fff","textAlign":"center","background":"url(http://codegen.caihongy.cn/20230117/2d9ffa6075c2441fae813ffa27437b7b.png) no-repeat right top,#7e5ffb","width":"50%","lineHeight":"50px","fontSize":"18px","float":"left"}'>{{aboutUsDetail.title}}</div>
	  <div :style='{"margin":"0 auto 0px","color":"#666","textAlign":"center","background":"#f6f6f6","width":"50%","lineHeight":"50px","fontSize":"14px","float":"right"}'>{{aboutUsDetail.subtitle}}</div>
	  <div :style='{"width":"100%","padding":"10px 0 0","flexWrap":"wrap","display":"flex","height":"auto"}'>
	    <img :style='{"width":"100%","margin":"0 10px","objectFit":"cover","display":"block","height":"240px"}' :src="baseUrl + aboutUsDetail.picture1">
	    <img :style='{"margin":"0 10px","objectFit":"cover","flex":1,"display":"none","height":"120px"}' :src="baseUrl + aboutUsDetail.picture2">
	    <img :style='{"margin":"0 10px","objectFit":"cover","flex":1,"display":"none","height":"120px"}' :src="baseUrl + aboutUsDetail.picture3">
	  </div>
	  <div :style='{"border":"1px solid #eee","padding":"10px","margin":"20px 0px 0px 0","overflow":"hidden","color":"#333","background":"linear-gradient(120deg, rgba(246,246,246,.9) 0%, rgba(246,246,246,.9) 50%, rgba(238,238,238,.9) 50%, rgba(238,238,238,.9) 100%)","width":"100%","lineHeight":"24px","fontSize":"14px","textIndent":"2em","height":"240px"}' v-html="aboutUsDetail.content"></div>
	  <div :style='{"width":"285px","background":"url(\"http://codegen.caihongy.cn/20201114/7856ba26477849ea828f481fa2773a95.jpg\") 0% 0% / cover no-repeat","display":"none","height":"100px"}' />
	  <div :style='{"width":"285px","background":"url(\"http://codegen.caihongy.cn/20201114/7856ba26477849ea828f481fa2773a95.jpg\") 0% 0% / cover no-repeat","display":"none","height":"100px"}' />
	  <div :style='{"width":"285px","background":"url(\"http://codegen.caihongy.cn/20201114/7856ba26477849ea828f481fa2773a95.jpg\") 0% 0% / cover no-repeat","display":"none","height":"100px"}' />
	  <div :style='{"width":"285px","background":"url(\"http://codegen.caihongy.cn/20201114/7856ba26477849ea828f481fa2773a95.jpg\") 0% 0% / cover no-repeat","display":"none","height":"100px"}' />
	</div>

<div class="recommend" :style='{"width":"100%","margin":"40px 7% 10px","position":"relative","background":"none","flex":"1","order":"3"}'>
	<div v-if="false" class="idea recommendIdea" :style='{"padding":"20px","flexWrap":"wrap","background":"#efefef","justifyContent":"space-between","display":"flex"}'>
		<div class="box1" :style='{"width":"20%","background":"#fff","height":"80px"}'></div>
		<div class="box2" :style='{"width":"20%","background":"#fff","height":"80px"}'></div>
		<div class="box3" :style='{"width":"20%","background":"#fff","height":"80px"}'></div>
		<div class="box4" :style='{"width":"20%","background":"#fff","height":"80px"}'></div>
		<div class="box5" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box6" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box7" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box8" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box9" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box10" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
	</div>
	
    <div class="title" :style='{"width":"100%","padding":"0px 0","margin":"0px auto 0px","lineHeight":"54px","textAlign":"center","background":"url(http://codegen.caihongy.cn/20230117/2d9ffa6075c2441fae813ffa27437b7b.png) no-repeat right top,#7e5ffb"}'>
		<span :style='{"color":"#fff","fontSize":"18px"}'>志愿组织推荐</span>
	</div>
	
	
	
	
	
	
	
	
	
	
	<!-- 样式九 -->
	<div class="list list9 index-pv1" :style='{"width":"100%","padding":"10px 0 0","background":"#fff","height":"auto"}'>
		<div :style='{"width":"100%","margin":"0 0 20px","flexWrap":"wrap","justifyContent":"space-between","display":"flex","height":"240px"}' class="list-body">
			<div v-if="zhiyuanzuzhiRecommend.length>0" @click="toDetail('zhiyuanzuzhiDetail', zhiyuanzuzhiRecommend[0])" class="list-item animation-box" :style='{"width":"48%","margin":"0 0px","position":"relative","display":"inline-block","height":"100%"}'>
				<img :style='{"width":"100%","objectFit":"cover","float":"left","height":"100%"}' v-if="preHttp(zhiyuanzuzhiRecommend[0].tupian)" :src="zhiyuanzuzhiRecommend[0].tupian.split(',')[0]" alt="" />
				<img :style='{"width":"100%","objectFit":"cover","float":"left","height":"100%"}' v-else :src="baseUrl + (zhiyuanzuzhiRecommend[0].tupian?zhiyuanzuzhiRecommend[0].tupian.split(',')[0]:'')" alt="" />
				<div class="title line1" :style='{"overflow":"hidden","color":"#fff","left":"0","textAlign":"center","bottom":"0","background":"rgba(0,0,0,.3)","width":"100%","lineHeight":"44px","fontSize":"18px","position":"absolute","height":"44px"}'>
                    <div>组织名称:{{zhiyuanzuzhiRecommend[0].zuzhimingcheng}}</div>
                </div>
			</div>
			<div v-if="zhiyuanzuzhiRecommend.length>1" @click="toDetail('zhiyuanzuzhiDetail', zhiyuanzuzhiRecommend[1])" class="list-item animation-box" :style='{"width":"48%","margin":"0 0px","position":"relative","display":"inline-block","height":"100%"}'>
				<img :style='{"width":"100%","objectFit":"cover","float":"left","height":"100%"}' v-if="preHttp(zhiyuanzuzhiRecommend[1].tupian)" :src="zhiyuanzuzhiRecommend[1].tupian.split(',')[0]" alt="" />
				<img :style='{"width":"100%","objectFit":"cover","float":"left","height":"100%"}' v-else :src="baseUrl + (zhiyuanzuzhiRecommend[1].tupian?zhiyuanzuzhiRecommend[1].tupian.split(',')[0]:'')" alt="" />
				<div class="title line1" :style='{"overflow":"hidden","color":"#fff","left":"0","textAlign":"center","bottom":"0","background":"rgba(0,0,0,.3)","width":"100%","lineHeight":"44px","fontSize":"18px","position":"absolute","height":"44px"}'>
                    <div>组织名称:{{zhiyuanzuzhiRecommend[1].zuzhimingcheng}}</div>
                </div>
			</div>
		</div>
		<div :style='{"width":"100%","flexWrap":"wrap","justifyContent":"space-between","display":"flex","height":"240px"}' class="list-body">
			<div v-if="zhiyuanzuzhiRecommend.length>2" @click="toDetail('zhiyuanzuzhiDetail', zhiyuanzuzhiRecommend[2])" class="list-item animation-box" :style='{"width":"32%","margin":"0 0px","position":"relative","height":"100%"}'>
				<img :style='{"width":"100%","objectFit":"cover","float":"left","height":"100%"}' v-if="preHttp(zhiyuanzuzhiRecommend[2].tupian)" :src="zhiyuanzuzhiRecommend[2].tupian.split(',')[0]" alt="" />
				<img :style='{"width":"100%","objectFit":"cover","float":"left","height":"100%"}' v-else :src="baseUrl +  (zhiyuanzuzhiRecommend[2].tupian?zhiyuanzuzhiRecommend[2].tupian.split(',')[0]:'')" alt="" />
				<div class="title line1" :style='{"overflow":"hidden","color":"#fff","left":"0","textAlign":"center","bottom":"0","background":"rgba(0,0,0,.3)","width":"100%","lineHeight":"44px","fontSize":"18px","position":"absolute","height":"44px"}'>
                    <div>组织名称:{{zhiyuanzuzhiRecommend[2].zuzhimingcheng}}</div>
                </div>
			</div>
			<div v-if="zhiyuanzuzhiRecommend.length>3" @click="toDetail('zhiyuanzuzhiDetail', zhiyuanzuzhiRecommend[3])" class="list-item animation-box" :style='{"width":"32%","margin":"0","position":"relative","height":"100%"}'>
				<img :style='{"width":"100%","objectFit":"cover","float":"left","height":"100%"}' v-if="preHttp(zhiyuanzuzhiRecommend[3].tupian)" :src="zhiyuanzuzhiRecommend[3].tupian.split(',')[0]" alt="" />
				<img :style='{"width":"100%","objectFit":"cover","float":"left","height":"100%"}' v-else :src="baseUrl + (zhiyuanzuzhiRecommend[3].tupian?zhiyuanzuzhiRecommend[3].tupian.split(',')[0]:'')" alt="" />
				<div class="title line1" :style='{"overflow":"hidden","color":"#fff","left":"0","textAlign":"center","bottom":"0","background":"rgba(0,0,0,.3)","width":"100%","lineHeight":"44px","fontSize":"18px","position":"absolute","height":"44px"}'>
                    <div>组织名称:{{zhiyuanzuzhiRecommend[3].zuzhimingcheng}}</div>
                </div>
			</div>
			<div v-if="zhiyuanzuzhiRecommend.length>4" @click="toDetail('zhiyuanzuzhiDetail', zhiyuanzuzhiRecommend[4])" class="list-item animation-box" :style='{"width":"32%","margin":"0","position":"relative","height":"100%"}'>
				<img :style='{"width":"100%","objectFit":"cover","float":"left","height":"100%"}' v-if="preHttp(zhiyuanzuzhiRecommend[4].tupian)" :src="zhiyuanzuzhiRecommend[4].tupian.split(',')[0]" alt="" />
				<img :style='{"width":"100%","objectFit":"cover","float":"left","height":"100%"}' v-else :src="baseUrl + (zhiyuanzuzhiRecommend[4].tupian?zhiyuanzuzhiRecommend[4].tupian.split(',')[0]:'')" alt="" />
				<div class="title line1" :style='{"overflow":"hidden","color":"#fff","left":"0","textAlign":"center","bottom":"0","background":"rgba(0,0,0,.3)","width":"100%","lineHeight":"44px","fontSize":"18px","position":"absolute","height":"44px"}'>
                    <div>组织名称:{{zhiyuanzuzhiRecommend[4].zuzhimingcheng}}</div>
                </div>
			</div>
		</div>
	</div>
	
	<div @click="moreBtn('zhiyuanzuzhi')" :style='{"border":"0","margin":"10px auto","top":"0","textAlign":"center","background":"none","display":"block","width":"80px","lineHeight":"32px","position":"absolute","right":"calc(0% + 40px)"}'>
		<span :style='{"color":"#f5f5f5","fontSize":"14px"}'>查看更多</span>
		<i v-if="true" :style='{"color":"#f5f5f5","fontSize":"14px"}' class="el-icon-d-arrow-right"></i>
	</div>
	
</div>

	
<div class="news" :style='{"width":"100%","margin":"40px 0 0px","position":"relative","background":"url(http://codegen.caihongy.cn/20230217/97bcc0240b264b0c8044d768bc1036c0.jpg) no-repeat center top / 100% 100%","order":"4"}'>
	<div v-if="false" class="idea newsIdea" :style='{"padding":"20px","flexWrap":"wrap","background":"#efefef","justifyContent":"space-between","display":"flex"}'>
		<div class="box1" :style='{"width":"20%","background":"#fff","height":"80px"}'></div>
		<div class="box2" :style='{"width":"20%","background":"#fff","height":"80px"}'></div>
		<div class="box3" :style='{"width":"20%","background":"#fff","height":"80px"}'></div>
		<div class="box4" :style='{"width":"20%","background":"#fff","height":"80px"}'></div>
		<div class="box5" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box6" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box7" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box8" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box9" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box10" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
	</div>
	
	<div class="title" :style='{"width":"86%","margin":"40px auto 20px","lineHeight":"54px","textAlign":"center","background":"url(http://codegen.caihongy.cn/20230117/2d9ffa6075c2441fae813ffa27437b7b.png) no-repeat right top,#7e5ffb"}'>
		<span :style='{"color":"#fff","fontSize":"18px"}'>公告信息</span>
	</div>
	
	
	
	
	
	<!-- 样式四 -->
	<div v-if="newsList.length" class="list list4 index-pv1" :style='{"border":"4px solid #eee","padding":"20px","margin":"40px 7% 80px","flexWrap":"wrap","background":"#fff","display":"flex","width":"86%","justifyContent":"center","height":"auto"}'>
	    <div @click="toDetail('newsDetail', newsList[0])" v-if="newsList.length>0" class="new-list-item animation-box" :style='{"border":"1px solid #fff","width":"50%","padding":"10px","background":"linear-gradient(240deg, rgba(246,246,246,.9) 0%, rgba(246,246,246,.9) 50%, rgba(238,238,238,.9) 50%, rgba(238,238,238,.9) 100%)","height":"300px","order":"1"}'>
			<div :style='{"margin":"0 0 10px","fontSize":"18px","color":"#333","textAlign":"left"}' class="new-list-item-title line1">{{newsList[0].title}}</div>
			<div :style='{"margin":"0 0 10px","fontSize":"14px","lineHeight":"20px","overflow":"hidden","color":"#666","height":"200px"}' class="descript  line3">{{newsList[0].introduction}}</div>
			<div :style='{"color":"#999","textAlign":"right","fontSize":"12px"}' class="time">{{newsList[0].addtime}}</div>
	    </div>
	    <div @click="toDetail('newsDetail', newsList[0])" v-if="newsList.length>0" class="new-list-item animation-box" :style='{"border":"1px solid #fff","width":"50%","background":"#f5f5f5","height":"300px","order":"2"}'>
			<img :style='{"objectFit":"cover","width":"100%","height":"100%"}' :src="baseUrl + newsList[0].picture" alt="">
	    </div>
	    <div @click="toDetail('newsDetail', newsList[1])" v-if="newsList.length>1" class="new-list-item animation-box" :style='{"border":"1px solid #fff","width":"50%","padding":"10px","background":"linear-gradient(120deg, rgba(246,246,246,.9) 0%, rgba(246,246,246,.9) 50%, rgba(238,238,238,.9) 50%, rgba(238,238,238,.9) 100%)","height":"300px","order":"4"}'>
			<div :style='{"margin":"0 0 10px","fontSize":"18px","color":"#333","textAlign":"left"}' class="new-list-item-title line1">{{newsList[1].title}}</div>
			<div :style='{"margin":"0 0 10px","fontSize":"14px","lineHeight":"20px","overflow":"hidden","color":"#666","height":"200px"}' class="descript  line3">{{newsList[1].introduction}}</div>
			<div :style='{"color":"#999","textAlign":"right","fontSize":"12px"}' class="time">{{newsList[1].addtime}}</div>
	    </div>
	    <div @click="toDetail('newsDetail', newsList[1])" v-if="newsList.length>1" class="new-list-item animation-box" :style='{"border":"1px solid #fff","width":"50%","background":"#f5f5f5","height":"300px","order":"3"}'>
			<img :style='{"objectFit":"cover","width":"100%","height":"100%"}' :src="baseUrl + newsList[1].picture" alt="">
	    </div>
	    <div @click="toDetail('newsDetail', newsList[2])" v-if="newsList.length>2" class="new-list-item animation-box" :style='{"border":"1px solid #fff","width":"50%","padding":"10px","background":"linear-gradient(240deg, rgba(246,246,246,.9) 0%, rgba(246,246,246,.9) 50%, rgba(238,238,238,.9) 50%, rgba(238,238,238,.9) 100%)","height":"300px","order":"5"}'>
			<div :style='{"margin":"0 0 10px","fontSize":"18px","color":"#333","textAlign":"left"}' class="new-list-item-title  line1">{{newsList[2].title}}</div>
			<div :style='{"margin":"0 0 10px","fontSize":"14px","lineHeight":"20px","overflow":"hidden","color":"#666","height":"200px"}' class="descript  line3">{{newsList[2].introduction}}</div>
			<div :style='{"color":"#999","textAlign":"right","fontSize":"12px"}' class="time">{{newsList[2].addtime}}</div>
	    </div>
	    <div @click="toDetail('newsDetail', newsList[2])" v-if="newsList.length>2" class="new-list-item animation-box" :style='{"border":"1px solid #fff","width":"50%","background":"#f5f5f5","height":"300px","order":"6"}'>
			<img :style='{"objectFit":"cover","width":"100%","height":"100%"}' :src="baseUrl + newsList[2].picture" alt="">
	    </div>
	</div>
	
	
	
	
	
	
	
	<div @click="moreBtn('news')" :style='{"border":"0","margin":"10px auto","top":"40px","textAlign":"center","background":"none","display":"block","width":"80px","lineHeight":"32px","position":"absolute","right":"calc(7% + 20px)"}'>
		<span :style='{"color":"#f5f5f5","fontSize":"14px"}'>查看更多</span>
		<i v-if="true" :style='{"color":"#f5f5f5","fontSize":"14px"}' class="el-icon-d-arrow-right"></i>
	</div>
	
</div>


<div class="lists" :style='{"width":"100%","padding":"40px 7% 40px","margin":"0px auto 0px","position":"relative","background":"url(http://codegen.caihongy.cn/20230210/06a0756a19f142bf97683f032fcc5afb.gif)","order":"1"}'>
	<div v-if="false" class="idea" :style='{"padding":"20px","flexWrap":"wrap","background":"#efefef","justifyContent":"space-between","display":"flex"}'>
		<div class="box1" :style='{"width":"20%","background":"#fff","height":"80px"}'></div>
		<div class="box2" :style='{"width":"20%","background":"#fff","height":"80px"}'></div>
		<div class="box3" :style='{"width":"20%","background":"#fff","height":"80px"}'></div>
		<div class="box4" :style='{"width":"20%","background":"#fff","height":"80px"}'></div>
		<div class="box5" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box6" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box7" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box8" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box9" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box10" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
	</div>
	
	<div class="title" :style='{"width":"100%","margin":"0px auto 20px","lineHeight":"50px","textAlign":"center","background":"url(http://codegen.caihongy.cn/20230117/2d9ffa6075c2441fae813ffa27437b7b.png) no-repeat right top,#7e5ffb"}'>
	  <span :style='{"color":"#fff","fontSize":"18px"}'>志愿组织展示</span>
	</div>
	
	
	
	
	
	
	
	
	<!-- 样式七 -->
	<div class="list list7 index-pv1" :style='{"padding":"20px 0","flexWrap":"wrap","background":"none","display":"flex","width":"100%","justifyContent":"space-between","height":"auto"}'>
		<div v-if="zhiyuanzuzhiList.length>0" class="list-4-item animation-box item-1" @click="toDetail('zhiyuanzuzhiDetail', zhiyuanzuzhiList[0])" :style='{"width":"24%","margin":"0 0px","position":"relative","height":"570px"}'>
			<img :style='{"width":"100%","objectFit":"cover","float":"left","height":"100%"}' v-if="preHttp(zhiyuanzuzhiList[0].tupian)" :src="zhiyuanzuzhiList[0].tupian.split(',')[0]" alt="" />
			<img :style='{"width":"100%","objectFit":"cover","float":"left","height":"100%"}' v-else :src="baseUrl + (zhiyuanzuzhiList[0].tupian?zhiyuanzuzhiList[0].tupian.split(',')[0]:'')" alt="" />
			<div class="list-4-item-title line1" :style='{"overflow":"hidden","color":"#fff","left":"0","textAlign":"center","bottom":"0","background":"rgba(0,0,0,.3)","width":"100%","lineHeight":"44px","fontSize":"18px","position":"absolute","height":"44px"}'>
                <div>组织名称:{{zhiyuanzuzhiList[0].zuzhimingcheng}}</div>
            </div>
		</div>
		<div :style='{"width":"24%","margin":"0 0px","height":"275px"}' class="list-4-body">
			<div v-if="zhiyuanzuzhiList.length>1" @click="toDetail('zhiyuanzuzhiDetail', zhiyuanzuzhiList[1])" class="list-4-item animation-box item-2" :style='{"width":"100%","margin":"0 0 20px","position":"relative","height":"100%"}'>
				<img :style='{"width":"100%","objectFit":"cover","float":"left","height":"100%"}' v-if="preHttp(zhiyuanzuzhiList[1].tupian)" :src="zhiyuanzuzhiList[1].tupian.split(',')[0]" alt="" />
				<img :style='{"width":"100%","objectFit":"cover","float":"left","height":"100%"}' v-else :src="baseUrl + (zhiyuanzuzhiList[1].tupian?zhiyuanzuzhiList[1].tupian.split(',')[0]:'')" alt="" />
				<div class="list-4-item-title line1" :style='{"overflow":"hidden","color":"#fff","left":"0","textAlign":"center","bottom":"0","background":"rgba(0,0,0,.3)","width":"100%","lineHeight":"44px","fontSize":"18px","position":"absolute","height":"44px"}'>
                    <div>组织名称:{{zhiyuanzuzhiList[1].zuzhimingcheng}}</div>
                </div>
			</div>
			<div v-if="zhiyuanzuzhiList.length>2" @click="toDetail('zhiyuanzuzhiDetail', zhiyuanzuzhiList[2])" class="list-4-item animation-box item-3" :style='{"width":"100%","margin":"20px 0 0","position":"relative","height":"100%"}'>
				<img :style='{"width":"100%","objectFit":"cover","float":"left","height":"100%"}' v-if="preHttp(zhiyuanzuzhiList[2].tupian)" :src="zhiyuanzuzhiList[2].tupian.split(',')[0]" alt="" />
				<img :style='{"width":"100%","objectFit":"cover","float":"left","height":"100%"}' v-else :src="baseUrl + (zhiyuanzuzhiList[2].tupian?zhiyuanzuzhiList[2].tupian.split(',')[0]:'')" alt="" />
				<div class="list-4-item-title line1" :style='{"overflow":"hidden","color":"#fff","left":"0","textAlign":"center","bottom":"0","background":"rgba(0,0,0,.3)","width":"100%","lineHeight":"44px","fontSize":"18px","position":"absolute","height":"44px"}'>
                    <div>组织名称:{{zhiyuanzuzhiList[2].zuzhimingcheng}}</div>
                </div>
			</div>
		</div>
		<div v-if="zhiyuanzuzhiList.length>3" class="list-4-item animation-box item-1" @click="toDetail('zhiyuanzuzhiDetail', zhiyuanzuzhiList[3])" :style='{"width":"24%","margin":"0 0px","position":"relative","height":"570px"}'>
			<img :style='{"width":"100%","objectFit":"cover","float":"left","height":"100%"}' v-if="preHttp(zhiyuanzuzhiList[3].tupian)" :src="zhiyuanzuzhiList[3].tupian.split(',')[0]" alt="" />
			<img :style='{"width":"100%","objectFit":"cover","float":"left","height":"100%"}' v-else :src="baseUrl + (zhiyuanzuzhiList[3].tupian?zhiyuanzuzhiList[3].tupian.split(',')[0]:'')" alt="" />
			<div class="list-4-item-title line1" :style='{"overflow":"hidden","color":"#fff","left":"0","textAlign":"center","bottom":"0","background":"rgba(0,0,0,.3)","width":"100%","lineHeight":"44px","fontSize":"18px","position":"absolute","height":"44px"}'>
                <div>组织名称:{{zhiyuanzuzhiList[3].zuzhimingcheng}}</div>
            </div>
		</div>
		<div :style='{"width":"24%","margin":"0 0px","height":"275px"}' class="list-4-body">
			<div v-if="zhiyuanzuzhiList.length>4" @click="toDetail('zhiyuanzuzhiDetail', zhiyuanzuzhiList[4])" class="list-4-item animation-box item-4" :style='{"width":"100%","margin":"0 0 20px","position":"relative","height":"100%"}'>
				<img :style='{"width":"100%","objectFit":"cover","float":"left","height":"100%"}' v-if="preHttp(zhiyuanzuzhiList[4].tupian)" :src="zhiyuanzuzhiList[4].tupian.split(',')[0]" alt="" />
				<img :style='{"width":"100%","objectFit":"cover","float":"left","height":"100%"}' v-else :src="baseUrl + (zhiyuanzuzhiList[4].tupian?zhiyuanzuzhiList[4].tupian.split(',')[0]:'')" alt="" />
				<div class="list-4-item-title line1" :style='{"overflow":"hidden","color":"#fff","left":"0","textAlign":"center","bottom":"0","background":"rgba(0,0,0,.3)","width":"100%","lineHeight":"44px","fontSize":"18px","position":"absolute","height":"44px"}'>
                    <div>组织名称:{{zhiyuanzuzhiList[4].zuzhimingcheng}}</div>
                </div>
			</div>
			<div v-if="zhiyuanzuzhiList.length>5" @click="toDetail('zhiyuanzuzhiDetail', zhiyuanzuzhiList[5])" class="list-4-item animation-box item-5" :style='{"width":"100%","margin":"20px 0 0","position":"relative","height":"100%"}'>
				<img :style='{"width":"100%","objectFit":"cover","float":"left","height":"100%"}' v-if="preHttp(zhiyuanzuzhiList[5].tupian)" :src="zhiyuanzuzhiList[5].tupian.split(',')[0]" alt="" />
				<img :style='{"width":"100%","objectFit":"cover","float":"left","height":"100%"}' v-else :src="baseUrl + (zhiyuanzuzhiList[5].tupian?zhiyuanzuzhiList[5].tupian.split(',')[0]:'')" alt="" />
				<div class="list-4-item-title line1" :style='{"overflow":"hidden","color":"#fff","left":"0","textAlign":"center","bottom":"0","background":"rgba(0,0,0,.3)","width":"100%","lineHeight":"44px","fontSize":"18px","position":"absolute","height":"44px"}'>
                    <div>组织名称:{{zhiyuanzuzhiList[5].zuzhimingcheng}}</div>
                </div>
			</div>
		</div>
	</div>
	
	
	
	<div @click="moreBtn('zhiyuanzuzhi')" :style='{"border":"0","margin":"10px auto","top":"40px","textAlign":"center","background":"none","display":"block","width":"80px","lineHeight":"32px","position":"absolute","right":"calc(7% + 40px)"}'>
		<span :style='{"color":"#f5f5f5","fontSize":"14px"}'>查看更多</span>
		<i v-if="true" :style='{"color":"#f5f5f5","fontSize":"14px"}' class="el-icon-d-arrow-right"></i>
	</div>
	

</div>


</div>
</template>

<script>
  export default {
    //数据集合
    data() {
      return {
        baseUrl: '',
        aboutUsDetail: {},
        newsList: [],
        zhiyuanzuzhiRecommend: [],

        zhiyuanzuzhiList: [],
      }
    },
    created() {
      this.baseUrl = this.$config.baseUrl;
      this.getNewsList();
      this.getAboutUs();
      this.getList();
    },
    //方法集合
    methods: {
      preHttp(str) {
          return str && str.substr(0,4)=='http';
      },
      getAboutUs() {
          this.$http.get('aboutus/detail/1', {}).then(res => {
            if(res.data.code == 0) {
              this.aboutUsDetail = res.data.data;
            }
          })
      },
		getNewsList() {
			this.$http.get('news/list', {params: {
				page: 1,
				limit: 6,
			order: 'desc'}}).then(res => {
				if (res.data.code == 0) {
					this.newsList = res.data.data.list;
					
					
				}
			});
		},
		getList() {
          let autoSortUrl = "";
          autoSortUrl = "zhiyuanzuzhi/autoSort";
			this.$http.get(autoSortUrl, {params: {
				page: 1,
				limit: 5,
			}}).then(res => {
				if (res.data.code == 0) {
					this.zhiyuanzuzhiRecommend = res.data.data.list;
					
					
					// 商品列表样式五
					
				}
			});
			
			this.$http.get('zhiyuanzuzhi/list', {params: {
				page: 1,
				limit: 6,
			}}).then(res => {
				if (res.data.code == 0) {
					this.zhiyuanzuzhiList = res.data.data.list;
					
					// 商品列表样式五
					
				}
			});
		},
		toDetail(path, item) {
			this.$router.push({path: '/index/' + path, query: {detailObj: JSON.stringify(item)}});
		},
		moreBtn(path) {
			this.$router.push({path: '/index/' + path});
		}
    }
  }
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
	.home-preview {
	
		.recommend {
			.list3 .swiper-button-prev {
				left: 10px;
				right: auto;
			}
			
			.list3 .swiper-button-prev::after {
				color: rgb(64, 158, 255);
			}
			
			.list3 .swiper-button-next {
				left: auto;
				right: 10px;
			}
			
			.list3 .swiper-button-next::after {
				color: rgb(64, 158, 255);
			}
			
			.list5 .swiper-button-prev {
				left: 10px;
				right: auto;
			}
			
			.list5 .swiper-button-prev::after {
				color: rgb(64, 158, 255);
        }
        
        .list5 .swiper-button-next {
				left: auto;
				right: 10px;
			}
			
			.list5 .swiper-button-next::after {
				color: rgb(64, 158, 255);
			}
			
			.list5 {
				.swiper-slide-prev {
					position: relative;
					z-index: 3;
				}
		
				.swiper-slide-next {
					position: relative;
					z-index: 3;
				}
		
				.swiper-slide-active {
					position: relative;
					z-index: 5;
				}
			}
			
			.index-pv1 .animation-box {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
				z-index: initial;
			}
			
			.index-pv1 .animation-box:hover {
				transform: scale(1.03) ;
				-webkit-perspective: 1000px;
				perspective: 1000px;
				transition: 0.3s;
				z-index: 1;
			}
			
			.index-pv1 .animation-box img {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
			}
			
			.index-pv1 .animation-box img:hover {
				-webkit-perspective: 1000px;
				perspective: 1000px;
				transition: 0.3s;
			}
		}
		
		.news {
			.list3 .swiper-button-prev {
				left: 10px;
				right: auto;
			}
			
			.list3 .swiper-button-prev::after {
				color: rgb(64, 158, 255);
			}
			
			.list3 .swiper-button-next {
				left: auto;
				right: 10px;
			}
			
			.list3 .swiper-button-next::after {
				color: rgb(64, 158, 255);
			}
			
			.list6 .swiper-button-prev {
				left: 10px;
				right: auto;
			}
			
			.list6 .swiper-button-prev::after {
				color: rgb(64, 158, 255);
			}
			
			.list6 .swiper-button-next {
				left: auto;
				right: 10px;
			}
			
			.list6 .swiper-button-next::after {
				color: rgb(64, 158, 255);
			}
			
			.index-pv1 .animation-box {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
				z-index: initial;
			}
			
			.index-pv1 .animation-box:hover {
				transform: scale(0.96) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
				-webkit-perspective: 1000px;
				perspective: 1000px;
				transition: 0.3s;
				z-index: 1;
			}
			
			.index-pv1 .animation-box img {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
			}
			
			.index-pv1 .animation-box img:hover {
				-webkit-perspective: 1000px;
				perspective: 1000px;
				transition: 0.3s;
			}
		}
	
		.lists {
			.list3 .swiper-button-prev {
				left: 10px;
				right: auto;
			}
			
			.list3 .swiper-button-prev::after {
				color: rgb(64, 158, 255);
			}
			
			.list3 .swiper-button-next {
				left: auto;
				right: 10px;
        }
        
        .list3 .swiper-button-next::after {
				color: rgb(64, 158, 255);
			}
			
			.list5 .swiper-button-prev {
				left: 10px;
				right: auto;
			}
			
			.list5 .swiper-button-prev::after {
				color: rgb(64, 158, 255);
			}
			
			.list5 .swiper-button-next {
            left: auto;
            right: 10px;
			}
			
			.list5 .swiper-button-next::after {
				color: rgb(64, 158, 255);
			}
			
			.list5 {
				.swiper-slide-prev {
					position: relative;
					z-index: 3;
				}
		
				.swiper-slide-next {
					position: relative;
					z-index: 3;
				}
		
				.swiper-slide-active {
					position: relative;
					z-index: 5;
				}
			}
			
			.index-pv1 .animation-box {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
				z-index: initial;
			}
			
			.index-pv1 .animation-box:hover {
				-webkit-perspective: 1000px;
				perspective: 1000px;
				transition: 0.3s;
				z-index: 1;
			}
			
			.index-pv1 .animation-box img {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
			}
			
			.index-pv1 .animation-box img:hover {
				-webkit-perspective: 1000px;
				perspective: 1000px;
				transition: 0.3s;
			}
		}
	}
</style>
