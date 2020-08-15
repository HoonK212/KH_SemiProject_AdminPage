<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <div class= "modaldiv">
  
  	<table class="admin_modal table">
  	<tr>
  		<td class="admin_modal_title">프렌차이즈 이름</td>
  		<td>${frkey.get(0).franName }</td>
  	</tr>
  	<tr>
  		<td class="admin_modal_title">메뉴이름</td>
  		<td>${muval.get(0).menuName }</td>
  	</tr>
  	<tr>
  		<td class="admin_modal_title">가격</td>
  		<td>${muval.get(0).menuCost }</td>
  	</tr>
  	<tr>
  		<td class="admin_modal_title">설명</td>
  		<td>${muval.get(0).menuInfo }</td>
  	</tr>
  	<tr>
  		<td class="admin_modal_title">신청날짜</td>
  		<td>${muval.get(0).menuDate }</td>
  	</tr>
  	</table>
  	
  	<p><img src = "/upload/${imglist.get(0).imgServer }"></p>
    
  
  <button type="button" class= "btn btn-success" onclick="location.href='/m/web/main/fran/update?menuno=${menuno }' ">승인</button>
    <button type="button" class="btn btn-danger" data-dismiss="modal">취소</button>
    </div>