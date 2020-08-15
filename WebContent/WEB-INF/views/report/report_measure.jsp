<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%request.setCharacterEncoding("UTF-8");%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/WEB-INF/views/web_layout/header2.jsp" />
<c:import url="/WEB-INF/views/web_layout/body_nav.jsp" />

<script type="text/javascript">
window.onload = function(){
	
	
	
	
	
}
</script>

<div class="tbcontainer">
<form action="/m/report/measure" method="post">

<c:forEach var="item" items="${reportkey}" varStatus="status">
	<table class="table table-bordered">
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
<c:if test="${reportvalue[status.index].rptYn == 'N' }" >
	<tr>
		<td><select name="rptManage">
			<option value="1">계정 1일 정지</option>
			<option value="2">계정 3일 정지</option>
			<option value="3">계정 7일 정지</option>
			<option value="4">계정 30일 정지</option>
		</select></td>
		<td><textarea name="rptNote" cols="80" rows="5"></textarea></td>
	</tr>
</c:if>

<c:if test="${reportvalue[status.index].rptYn == 'Y' }">
	<tr>
		<td>
		<c:choose>
         <c:when test="${reportvalue[status.index].rptManage eq 1 }">
            <%="계정 1일 정지" %>
         </c:when>
         <c:when test="${reportvalue[status.index].rptManage eq 2 }">
            <%="계정 3일 정지" %>
         </c:when>
         <c:when test="${reportvalue[status.index].rptManage eq 3 }">
            <%="계정 7일 정지" %>
         </c:when>
         <c:otherwise>
            <%="계정 30일 정지" %>
         </c:otherwise>
     	</c:choose>
		</td>
		<td><textarea name="rptNote" cols="80" rows="5" disabled="disabled"><c:out value="${reportvalue[status.index].rptNote}"></c:out></textarea></td>
	</tr>
</c:if>
</table>
	<input type="submit" style="margin-left: 1000px;" class="btn btn-primary btn-lg" value="처리" />
	<c:if test="${reportvalue[status.index].rptYn == 'Y' }">
		<button type="button" class="btn btn-primary btn-lg" onclick="location.href='/m/measure/update?rptNo=${reportvalue[status.index].rptNo}'">수정</button>
	</c:if>
	<button type="button" class="btn btn-primary btn-lg" onclick="javascript:history.go(-1)">취소</button>
</c:forEach>
</form>
</div>
<c:import url="/WEB-INF/views/web_layout/footer.jsp" />