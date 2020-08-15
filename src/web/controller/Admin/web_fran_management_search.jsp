<%@page import="web.dto.Image"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 


<div>
${frkey.get(0).franName }<br>
${muval.get(0).menuName }<br>
${muval.get(0).menuCost }원<br>
${muval.get(0).menuInfo }<br>
이미지 : <img src="/upload/${imglist.get(0).imgServer}"/><br>
${muval.get(0).menuDate }<br>
<button onclick="location.href='/m/web/main/fran/update?menuno=${menuno }'">승인</button>
</div>