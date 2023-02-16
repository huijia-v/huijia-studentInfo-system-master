<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<html>
<head>
	<meta charset="utf-8">
	<title>登陆页面</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/stylelogin.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/iconfont.css">
	 <script language="JavaScript">
        window.onload=init;
        function init() {
            var pop = "${requestScope.msg}";
            if(pop != ""){
                alert(pop);
            }
        }
    </script>
</head>
<body>
	<div id="maxbox">
		<h3>学生成绩管理系统</h3>
		<form action="${pageContext.request.contextPath}/autho/login" ,method="post">
		<div class="inputbox">
			<div class="inputText">
				<span class="iconfont icon-mine"></span> <input name="idNumber" type="text"
					placeholder="学号/工号" autocomplete="off">
			</div>
			<div class="inputText">
				<span class="iconfont icon-lock"></span> <input name="password" type="password"
					placeholder="密码">
			</div>
			<div>
				<input type="radio" id="authoAdmin" name="authority" value="0" />
				<label for="authoAdmin" style="color: #efefef">管理员</label>

				<input type="radio" id="authoTeacher" name="authority" value="1" />
				<label for="authoTeacher" style="color: #efefef">教师</label>

				<input type="radio" id="authoStudent" name="authority" value="2" />
				<label for="authoStudent" style="color: #efefef">学生</label>
			</div>
			<input class="inputButton" type="submit" value="LOGIN">
		</div>
		</form>
	</div>
</body>
</html>