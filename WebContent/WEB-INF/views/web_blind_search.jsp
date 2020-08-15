<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class= "modaldiv">
  <table class="admin_modal table">
  	<tr>
  		<td class="admin_modal_title">메뉴이름</td>
  		<td> ${mukey.get(0).menuName }</td>
  	</tr>
  	<tr>
  		<td class="admin_modal_title">신청이유</td>
  		<td>${blval.get(0).blindRsn }</td>
  	</tr>
  	<tr>
  		<td class="admin_modal_title">블라인드 요청일자</td>
  		<td>${blval.get(0).blindDate }</td>
  	</tr>
  	<tr>
  		<td class="admin_modal_title">블라인드 희망일자</td>
  		<td>${blval.get(0).blindStart }</td>
  	</tr>
  	<tr>
  		<td class="admin_modal_title">비고</td>
  		<td>${blval.get(0).blindNote }</td>
  	</tr>
  	</table>
  	<p><img src = "/upload/${bimglist.get(0).imgServer }"></p>
  
 <button type="button" class="btn btn-success" onclick="location.href='/m/web/main/blind/update?menuno=${menuno }' ">승인</button>
<button type="button" class="btn btn-danger" data-dismiss="modal">취소</button>
</div>

