<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<script type="text/javascript">
$(document).ready(function() {
	
	$(".nav4 input[type='text']").keyup(function() {
		//보여지고 있는 테이브의 내용물을 백업테이블의 모든 내용으로 바꿈
		$(".tbcontainer tbody").html( $("#backup tbody").children().clone() );
		
		//입력한 값 얻어내기
		var keyword = $(".nav4 input[type='text']").val();

		//유저아이디를 모두 반복하며 검사
		$(".tbcontainer tbody tr td:nth-child(2)").each(function() {
			
			//입력한 값을 유저아이디(td)에 포함하고 있지 않으면
			if( !$(this).text().includes(keyword) ) {
				
				// 부모태그인 tr 태그 제거
				$(this).parent().remove();
			}
			
		});
	})


})
</script>

<section class="wrapper">

	<h2 class="onlyh2">회원조회</h2>
	<div class="nav4">
		<div class="row">
			<div class="col-lg-6">
				<div class="input-group">
					<input type="text" class="form-control" placeholder="Search for...">
					<span class="input-group-btn">
						<button class="btn btn-default" type="button">
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
		<thead>
			<tr>
				<th style="width: 20%;">유저번호</th>
				<th style="width: 20%;">유저아이디</th>
				<th style="width: 20%;">한줄평 작성수</th>
				<th style="width: 20%;">별점 작성수</th>
				<th style="width: 20%;">등급</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${list }" var="list">
		<tr>
	<td>${list.userNo }</td>
	<td>${list.userId }</td>
	<td>${list.reviewcnt }</td>
	<td>${list.startcnt }</td>

	<td>
		<c:choose>
			<c:when test="${list.userGrade eq 1 }">
				<%="일반회원" %>
			</c:when>
			<c:when test="${list.userGrade eq 2 }">
				<%="우수회원" %>
			</c:when>
			<c:when test="${list.userGrade eq 3 }">
				<%="VIP" %>
			</c:when>
			<c:otherwise>
				<%="VVIP" %>
			</c:otherwise>
		</c:choose>
	</td>
	
</tr>
		</c:forEach>
</tbody>


		</table>








	</div>
	
<table id="backup" style="display: none;">
<tbody>
<c:forEach items="${list }" var="list">
<tr>
	<td>${list.userNo }</td>
	<td>${list.userId }</td>
	<td>${list.reviewcnt }</td>
	<td>${list.startcnt }</td>

	<td>
		<c:choose>
			<c:when test="${list.userGrade eq 1 }">
				<%="일반회원" %>
			</c:when>
			<c:when test="${list.userGrade eq 2 }">
				<%="우수회원" %>
			</c:when>
			<c:when test="${list.userGrade eq 3 }">
				<%="VIP" %>
			</c:when>
			<c:otherwise>
				<%="VVIP" %>
			</c:otherwise>
		</c:choose>
	</td>
	
</tr>
</c:forEach>
</tbody>
</table>

</section>