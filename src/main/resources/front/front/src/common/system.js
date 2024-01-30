export function isAuth(tableName, key) {
  let role = localStorage.getItem("UserTableName");
  let menus = [{"backMenu":[{"child":[{"appFrontIcon":"cuIcon-phone","buttons":["查看","修改","删除"],"menu":"志愿者","menuJump":"列表","tableName":"zhiyuanzhe"}],"menu":"志愿者管理"},{"child":[{"appFrontIcon":"cuIcon-goods","buttons":["查看","修改","删除"],"menu":"志愿组织","menuJump":"列表","tableName":"zhiyuanzuzhi"}],"menu":"志愿组织管理"},{"child":[{"appFrontIcon":"cuIcon-qrcode","buttons":["查看","修改","删除"],"menu":"组织风采","menuJump":"列表","tableName":"zuzhifengcai"}],"menu":"组织风采管理"},{"child":[{"appFrontIcon":"cuIcon-similar","buttons":["新增","查看","修改","删除"],"menu":"活动类型","menuJump":"列表","tableName":"huodongleixing"}],"menu":"活动类型管理"},{"child":[{"appFrontIcon":"cuIcon-qrcode","buttons":["查看","修改","删除"],"menu":"志愿活动","menuJump":"列表","tableName":"zhiyuanhuodong"}],"menu":"志愿活动管理"},{"child":[{"appFrontIcon":"cuIcon-vip","buttons":["查看","修改","删除"],"menu":"组织报名","menuJump":"列表","tableName":"zuzhibaoming"}],"menu":"组织报名管理"},{"child":[{"appFrontIcon":"cuIcon-newshot","buttons":["查看","修改","删除"],"menu":"活动报名","menuJump":"列表","tableName":"huodongbaoming"}],"menu":"活动报名管理"},{"child":[{"appFrontIcon":"cuIcon-form","buttons":["查看","修改","回复","删除"],"menu":"留言板管理","tableName":"messages"}],"menu":"留言板管理"},{"child":[{"appFrontIcon":"cuIcon-explore","buttons":["查看","修改"],"menu":"轮播图管理","tableName":"config"},{"appFrontIcon":"cuIcon-news","buttons":["新增","查看","修改","删除"],"menu":"公告信息","tableName":"news"},{"appFrontIcon":"cuIcon-shop","buttons":["查看","修改"],"menu":"关于我们","tableName":"aboutus"}],"menu":"系统管理"}],"frontMenu":[{"child":[{"appFrontIcon":"cuIcon-vip","buttons":["查看","报名"],"menu":"志愿组织列表","menuJump":"列表","tableName":"zhiyuanzuzhi"}],"menu":"志愿组织模块"},{"child":[{"appFrontIcon":"cuIcon-flashlightopen","buttons":["查看"],"menu":"组织风采列表","menuJump":"列表","tableName":"zuzhifengcai"}],"menu":"组织风采模块"},{"child":[{"appFrontIcon":"cuIcon-vip","buttons":["查看","报名"],"menu":"志愿活动列表","menuJump":"列表","tableName":"zhiyuanhuodong"}],"menu":"志愿活动模块"}],"hasBackLogin":"是","hasBackRegister":"否","hasFrontLogin":"否","hasFrontRegister":"否","roleName":"管理员","tableName":"users"},{"backMenu":[{"child":[{"appFrontIcon":"cuIcon-vip","buttons":["查看"],"menu":"组织报名","menuJump":"列表","tableName":"zuzhibaoming"}],"menu":"组织报名管理"},{"child":[{"appFrontIcon":"cuIcon-newshot","buttons":["查看"],"menu":"活动报名","menuJump":"列表","tableName":"huodongbaoming"}],"menu":"活动报名管理"}],"frontMenu":[{"child":[{"appFrontIcon":"cuIcon-vip","buttons":["查看","报名"],"menu":"志愿组织列表","menuJump":"列表","tableName":"zhiyuanzuzhi"}],"menu":"志愿组织模块"},{"child":[{"appFrontIcon":"cuIcon-flashlightopen","buttons":["查看"],"menu":"组织风采列表","menuJump":"列表","tableName":"zuzhifengcai"}],"menu":"组织风采模块"},{"child":[{"appFrontIcon":"cuIcon-vip","buttons":["查看","报名"],"menu":"志愿活动列表","menuJump":"列表","tableName":"zhiyuanhuodong"}],"menu":"志愿活动模块"}],"hasBackLogin":"是","hasBackRegister":"否","hasFrontLogin":"是","hasFrontRegister":"是","roleName":"志愿者","tableName":"zhiyuanzhe"},{"backMenu":[{"child":[{"appFrontIcon":"cuIcon-qrcode","buttons":["新增","查看","修改","删除"],"menu":"组织风采","menuJump":"列表","tableName":"zuzhifengcai"}],"menu":"组织风采管理"},{"child":[{"appFrontIcon":"cuIcon-qrcode","buttons":["新增","查看","修改","删除"],"menu":"志愿活动","menuJump":"列表","tableName":"zhiyuanhuodong"}],"menu":"志愿活动管理"},{"child":[{"appFrontIcon":"cuIcon-vip","buttons":["查看","删除","审核"],"menu":"组织报名","menuJump":"列表","tableName":"zuzhibaoming"}],"menu":"组织报名管理"},{"child":[{"appFrontIcon":"cuIcon-newshot","buttons":["查看","删除","审核"],"menu":"活动报名","menuJump":"列表","tableName":"huodongbaoming"}],"menu":"活动报名管理"}],"frontMenu":[{"child":[{"appFrontIcon":"cuIcon-vip","buttons":["查看","报名"],"menu":"志愿组织列表","menuJump":"列表","tableName":"zhiyuanzuzhi"}],"menu":"志愿组织模块"},{"child":[{"appFrontIcon":"cuIcon-flashlightopen","buttons":["查看"],"menu":"组织风采列表","menuJump":"列表","tableName":"zuzhifengcai"}],"menu":"组织风采模块"},{"child":[{"appFrontIcon":"cuIcon-vip","buttons":["查看","报名"],"menu":"志愿活动列表","menuJump":"列表","tableName":"zhiyuanhuodong"}],"menu":"志愿活动模块"}],"hasBackLogin":"是","hasBackRegister":"是","hasFrontLogin":"是","hasFrontRegister":"否","roleName":"志愿组织","tableName":"zhiyuanzuzhi"}];
  for(let i=0;i<menus.length;i++){
    if(menus[i].tableName==role){
      for(let j=0;j<menus[i].frontMenu.length;j++){
          for(let k=0;k<menus[i].frontMenu[j].child.length;k++){
            if(tableName==menus[i].frontMenu[j].child[k].tableName){
              let buttons = menus[i].frontMenu[j].child[k].buttons.join(',');
              return buttons.indexOf(key) !== -1 || false
            }
          }
      }
    }
  }
  return false;
}

/**
 *  * 获取当前时间（yyyy-MM-dd hh:mm:ss）
 *   */
export function getCurDateTime() {
    let currentTime = new Date(),
    year = currentTime.getFullYear(),
    month = currentTime.getMonth() + 1 < 10 ? '0' + (currentTime.getMonth() + 1) : currentTime.getMonth() + 1,
    day = currentTime.getDate() < 10 ? '0' + currentTime.getDate() : currentTime.getDate(),
    hour = currentTime.getHours(),
    minute = currentTime.getMinutes(),
    second = currentTime.getSeconds();
    return year + "-" + month + "-" + day + " " +hour +":" +minute+":"+second;
}

/**
 *  * 获取当前日期（yyyy-MM-dd）
 *   */
export function getCurDate() {
    let currentTime = new Date(),
    year = currentTime.getFullYear(),
    month = currentTime.getMonth() + 1 < 10 ? '0' + (currentTime.getMonth() + 1) : currentTime.getMonth() + 1,
    day = currentTime.getDate() < 10 ? '0' + currentTime.getDate() : currentTime.getDate();
    return year + "-" + month + "-" + day;
}
