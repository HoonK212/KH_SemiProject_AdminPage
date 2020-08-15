<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/views/web_layout/header2.jsp" />
<c:import url="/WEB-INF/views/web_layout/body_nav.jsp" />

<script type="text/javascript">
$(document).ready(function() {
	//검색 버틀 클릭
	$("#btnSearch").click(function() {
		location.href="/m/view/fran?search="+$("#search").val();
	});
	
});
</script>
    
    	<div class="nav4">
		<div class="row">
			<div class="col-lg-6">
				<div class="input-group">
					<input id="search" type="text" class="form-control" placeholder="Search for...">
					<span class="input-group-btn">
						<button  id="btnSearch" class="btn btn-default" type="button">
							<span class="glyphicon glyphicon-search"></span>
						</button>
					</span>
				</div>
				<!-- /input-group -->
			</div>
			<!-- /.col-lg-6 -->
		</div>
		<!-- /.row -->
	</div>
	<!-- nav4 -->
	
<div class="tbcontainer">
	<table class="table table-bordered">
	<tr>
		<th style="width: 20%;">프랜차이즈 번호</th>
		<th style="width: 40%;">프랜차이즈 이름</th>
		<th style="width: 40%;">종류</th>
	</tr>

		<c:forEach var="item" items="${franList}">
			<tr>
				<td width="20%"><c:out value="${item.key.franNo}" /></td>
				<td width="40%"><c:out value="${item.key.franName}" /></td>
				<td width="140%"><c:out value="${item.value}" /></td>
			</tr>
		</c:forEach>
	</table>
</div>
	
	
<c:import url="/WEB-INF/views/fran/paging_fran.jsp" />
<c:import url="/WEB-INF/views/web_layout/footer.jsp" />