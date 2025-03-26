const base = {
    get() {
        return {
            url : "http://localhost:8080/yinhangkehu/",
            name: "yinhangkehu",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/yinhangkehu/front/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "银行客户管理系统"
        } 
    }
}
export default base
