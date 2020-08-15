<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<c:import url="/WEB-INF/views/web_layout/header2.jsp" />
<c:import url="/WEB-INF/views/web_layout/body_nav.jsp" />
<section class="wrapper">
<div class="board">

<table class="table table-bordered" style="text-align: center">

<tr><th width="20%">제목</th><td width="80%"><c:out value="${board.bdTitle}" /></td></tr>
<tr><th colspan="2">공지 내용</th></tr>
<tr><td colspan="2"><textarea cols="98" rows="10" disabled="disabled"><c:out value="${board.bdQuestion}" /></textarea></td></tr>
</table>
<div style="float: right;">
	<button class="btn btn-primary btn-lg" onclick="location.href='/m/view/notice'">목록</button>
	<button class="btn btn-primary btn-lg" onclick="location.href='/m/notice/update?bdNo=${board.bdNo}'">수정</button>
</div>
</div>
</section>
<c:import url="/WEB-INF/views/web_layout/footer.jsp" />