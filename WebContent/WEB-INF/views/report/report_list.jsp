<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/WEB-INF/views/web_layout/header2.jsp" />
<c:import url="/WEB-INF/views/web_layout/body_nav.jsp" />

<div class="tbcontainer">
	<table class="table table-bordered" style="text-align: center">
	<tr>
		<th style="width: 10%;">신고번호</th>
		<th style="width: 10%;">신고자</th>
		<th style="width: 20%;">신고이유</th>
		<th style="width: 10%;">대상자</th>
		<th style="width: 20%;">조치내용</th>
		<th style="width: 10%;">조치여부</th>
		<th style="width: 10%;">비고</th>
	</tr>


		<c:forEach var="item" items="${reportkey}" varStatus="status">
			<tr>
				<td width="10%"><c:out value="${reportvalue[status.index].rptNo}" /></td>
				<td width="20%"><c:out value="${item.userId}" /></td>
				
				<td width="10%"><a href="/m/report/measure?rptNo=${reportvalue[status.index].rptNo}">
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
				</a></td>
				
				<td width="10%"><c:out value="${item.targetId}" /></td>
				
				<td width="20%">
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
				
				<td width="10%"><c:out value="${reportvalue[status.index].rptYn}" /></td>
				<td width="10%"><c:out value="${reportvalue[status.index].rptNote}" /></td>
			</tr>
		</c:forEach>
	</table>
</div>

<c:import url="/WEB-INF/views/report/paging_report.jsp" />
<c:import url="/WEB-INF/views/web_layout/footer.jsp" />