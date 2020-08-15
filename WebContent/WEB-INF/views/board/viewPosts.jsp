<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<c:import url="/WEB-INF/views/web_layout/header2.jsp" />
<c:import url="/WEB-INF/views/web_layout/body_nav.jsp" />

<script type="text/javascript">
</script>

<section class="wrapper">
<div class="board">

	
	<!-- 자유게시판 Title -->
	<div class="board_top" style="float: right;">
	</div>
	
	<!-- 자유게시판 목록 -->
	<table class="table table-bordered" style="text-align: center">
		<tr>
			<th>글번호</th>
			<th>제목</th>
			<th>아이디</th>
			<th>조회수</th>
			<th>작성일자</th>
			<th>답변여부</th>
		</tr>
		
		<c:forEach var="item" items="${boardList}">
			<tr>
				<td width="10%"><c:out value="${item.key.bdNo}" /></td>
				<td width="50%"><a href="/m/detail/posts?bdNo=${item.key.bdNo }"><c:out value="${item.key.bdTitle}" /></a></td>
				<td width="10%"><c:out value="${item.value}" /></td>
				<td width="8%"><c:out value="${item.key.bdCnt}" /></td>
				<td width="14%"><c:out value="${item.key.bdDate}" /></td>
				<td width="8%"><c:out value="${item.key.bdYn}" /></td>
			</tr>
		</c:forEach>
	</table>
</div>
</section>
<c:import url="/WEB-INF/views/board/paging_posts.jsp" />
<c:import url="/WEB-INF/views/web_layout/footer.jsp" />