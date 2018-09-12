<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../include/taglib.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
    <div id="login">
        아이디   : <input type='text' v-model="username" id="username" />
        패스워드 : <input type='password' v-model="password" id="password" />
        <button v-on:click="fnLogin">로그인</button>
        <div>{{result}}</div>
    </div>
</body>


<c:import url="../include/script.jsp" />
<script>
    Vue.prototype.$http = axios;
    var login = new Vue({
        el:"#login",
        data:{
            username:'konan',
            password:'konan1',
            result:''
        },
        methods:{

            fnLogin:function(){
                console.log(login.data);
                const baseURI = 'http://localhost:8080';
                this.$http.post('${baseURI}/login', {username:this.username,password:this.password})
                    .then(result => {
                        console.log(result.status);
                        this.result = result.data;
                })
            }
        }
    })
</script>
</html>