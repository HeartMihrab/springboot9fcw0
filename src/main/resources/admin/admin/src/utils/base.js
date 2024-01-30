const base = {
    get() {
        return {
            url : "http://localhost:8080/springboot9fcw0/",
            name: "springboot9fcw0",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/springboot9fcw0/front/dist/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "大学生志愿者管理系统的设计与实现"
        } 
    }
}
export default base
