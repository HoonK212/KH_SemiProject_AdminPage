<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
       <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.TreeMap"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Date"%>
<%List<Date>graphKey =(List)request.getAttribute("graphKey"); %> 
<%List<Integer>graphVal =(List)request.getAttribute("graphVal"); %> 

<c:import url="/WEB-INF/views/web_layout/header2.jsp" />

<script> 
var key=[];
var val=[];
<% int cnt=0; %>
	 <% for(int i=0;i<graphKey.size();i++){ 			
		String year= String.valueOf(graphKey.get(i).getYear()+1900);
		String month=String.valueOf(graphKey.get(i).getMonth()+1);
		String date = String.valueOf(graphKey.get(i).getDate());
		int total=graphVal.get(i);	  %>
		
 	key.push(<%=year%>+ "-" +<%=month%>+ "-" +<%=date %>); 
	val.push(<%=total%>);		
<%  } %> 

	window.onload = function(){
		 new Morris.Line({
	            element: 'morrisChart',
	              data: [
	                      { period: key[0] , value: val[0] },
	                      { period: key[1] , value: val[1] },
	                      { period: key[2] , value: val[2] },
	                      { period: key[3] , value: val[3] },
	                      { period: key[4] , value: val[4] },
	                      { period: key[5] , value: val[5] },
	                      { period: key[6] , value: val[6] },
	                      { period: key[7] , value: val[7] },
	                      { period: key[8] , value: val[8] },
	                      { period: key[9] , value: val[9] },
	                      { period: key[10] , value: val[10] },
	                      { period: key[11] , value: val[11] }
	                      
	                      
	                  ],
	                  
	            xkey: 'period',
	            ykeys: ['value'],
	            labels: ['value'],  
	            xLabels: 'day'
	        
	        });
	        
		
	};                 
          
        
    </script>



</head>
<body>
<c:import url="/WEB-INF/views/web_layout/body_nav.jsp" />
      <div id="morrisChart" ></div>        
  	<div id ="div1"></div>
  	<c:import url="/WEB-INF/views/web_layout/footer.jsp" />

</body>
</html>