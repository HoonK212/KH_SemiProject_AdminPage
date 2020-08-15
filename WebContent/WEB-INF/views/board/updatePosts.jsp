<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<c:import url="/WEB-INF/views/web_layout/header2.jsp" />
<c:import url="/WEB-INF/views/web_layout/body_nav.jsp" />
<section class="wrapper">
<div class="board">

<form action="/m/posts/update" method="post">
<table class="table table-bordered" style="text-align: center">

<tr><th width="20%">아이디</th><td width="80%"><c:out value="${user.userId}" /></td></tr>
<tr><th width="20%">닉네임</th><td width="80%"><c:out value="${user.userNick}" /></td></tr>
<tr><th width="20%">제목</th><td width="80%"><c:out value="${board.bdTitle}" /></td></tr>
<tr><td></td></tr>
<tr><th colspan="2">질문 내용</th></tr>
<tr><td colspan="2"><textarea cols="98" rows="10" disabled="disabled"><c:out value="${board.bdQuestion}" /></textarea></td></tr>
	<tr><th colspan="2">답변 내용</th></tr>
	<tr><td colspan="2"><textarea id="answer" name="answer" cols="98" rows="10"></textarea></td></tr>
</table>

<input type="hidden" name="bdno" value="${board.bdNo }">

<div style="float: right;">
		<button class="btn btn-primary btn-lg" type="submit">처리</button>
		<button type="button" class="btn btn-primary btn-lg" onclick="javascript:history.go(-1)">취소</button>
	
</div>
</form>


</div>
</section>
<c:import url="/WEB-INF/views/web_layout/footer.jsp" />