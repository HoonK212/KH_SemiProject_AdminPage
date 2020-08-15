<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<link rel="stylesheet" type="text/css"  href="/m/resources/css/login.css" >

<script type="text/javascript" src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
</head>
<body>

    <div class="container">

      <form class="form-signin" method="post">
      	<img src = "/m/resources/image/brand.gif">
        <label for="inputEmail" class="sr-only">아이디 입력</label>
        <input type="text" name = "adminid" class="form-control" placeholder="ID 입력해주세요" required autofocus>
        <label for="inputPassword" class="sr-only">비밀번호 입력</label>
        <input type="password" name = "adminpw" class="form-control" placeholder="Pw 입력해주세요" required>
        <div class="checkbox">
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="submit">로그인</button>
      </form>

    </div> <!-- /container -->
 

</body>
</html>