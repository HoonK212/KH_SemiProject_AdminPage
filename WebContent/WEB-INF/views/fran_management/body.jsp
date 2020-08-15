<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<script type="text/javascript">
$(document).ready(function() {
	$(".btnSearch").click(function() {
	
			$.ajax({
				type: "POST"
				, url: "<%=request.getContextPath() %>/web/franman/search"
				, data: {
					franno: $(this).next("input[class='modalvalue1']").val(),
					menuno: $(this).nextAll("input[class='modalvalue2']").val()
				}
				, dataType: "html"
				, success: function(result) {
					
					$("#myModal1 .modal-body").html(result)
				}
				, error: function() {
					
				}
			});
		
		
	})

})


</script>
	
	
	
<section class="wrapper">
	<h2 class="onlyh2">신규등록 대기목록</h2>
	<div class="tbcontainer">
		<table class="table table-bordered">
			<tr>
				<th style="width: 20%;">프렌차이즈 번호</th>
				<th style="width: 20%;">프렌차이즈 이름</th>
				<th style="width: 20%;">신규메뉴</th>
				<th style="width: 20%;">자세히보기</th>
			</tr>
			<c:forEach var="list1" items="${frankey }" varStatus="status">
			<tr>
				<td>${list1.franNo }</td>
				<td>${list1.franName }</td>
				<td>${menuval[status.index].menuName}</td>
				<td><button class="btn btn-default btnSearch" type="button"
						data-toggle="modal" data-target="#myModal1">
							<span class="glyphicon glyphicon-search"></span>
						</button>
						<input type="hidden" class = "modalvalue1" value="${list1.franNo }">
						<input type="hidden" class = "modalvalue2" value="${menuval[status.index].menuNo }">
						</td>
			</tr>
			</c:forEach>
		</table>
		<div class="modal fade" id="myModal1" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title" id="myModalLabel">정보 자세히보기</h4>
					</div>
					
					<div class="modal-body">
					</div>
				</div>
			</div>
		</div>
		
		</div>




</section>

