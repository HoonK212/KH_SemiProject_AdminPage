<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%request.setCharacterEncoding("UTF-8");%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/WEB-INF/views/web_layout/header2.jsp" />
<c:import url="/WEB-INF/views/web_layout/body_nav.jsp" />

<div class="tbcontainer">
<form action="/m/report/measure" method="post">

	<table class="table table-bordered" border="1">
<!-- 	<tr><th>뭔데</th></tr> -->
<c:forEach var="item" items="${reportkey}" varStatus="status">
	<input type="hidden" value="${reportvalue[status.index].rptNo }" name="rptNo" />

	<tr><th width="20%">신고자</th><td width="60%"><c:out value="${item.userId}" /></td></tr>
	<tr><th width="20%">신고ID</th><td width="60%"><c:out value="${item.targetId}" /></td></tr>
	<tr><th width="20%">이유</th><td width="60%">
	<c:choose>
			         <c:when test="${reportvalue[status.index].rptRsn eq 1 }">
			            <%="비속어 사용" %>
			         </c:when>
			         <c:when test="${reportvalue[status.index].rptRsn eq 2 }">
			            <%="허위사실 유포" %>
			         </c:when>
			         <c:when test="${reportvalue[status.index].rptRsn eq 3 }">
			            <%="불충분한 정보" %>
			         </c:when>
			         <c:otherwise>
			            <%="기타" %>
			         </c:otherwise>
     		 	</c:choose>
	</td></tr>
	
	
	<tr><th width="20%">내용</th><td width="60%"><c:out value="${reportvalue[status.index].rptDetail}" /></td></tr>
		

		<tr><td></td></tr>

<tr><th>조치</th>
<th>답변</th></tr>

	<tr>
		<td><select name="rptManage">
			<option value="1">계정 1일 정지</option>
			<option value="2">계정 3일 정지</option>
			<option value="3">계정 7일 정지</option>
			<option value="4">계정 30일 정지</option>
		</select></td>
		<td><textarea name="rptNote" cols="80" rows="5"></textarea></td>
	</tr>

</c:forEach>
</table>
	<input type="submit" style="margin-left: 1000px;" class="btn btn-primary btn-lg" value="처리" />
	<button type="button" class="btn btn-primary btn-lg" onclick="javascript:history.go(-1)">취소</button>
</form>
</div>
<c:import url="/WEB-INF/views/web_layout/footer.jsp" />