<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script type="text/javascript">
	window.onload = function(){
		 new Morris.Line({
	            element: 'morrisChart',
	              data: [
	                      { year: '2008', value: 30 },
	                      { year: '2009', value: 10 },
	                      { year: '2010', value: 5 },
	                      { year: '2011', value: 5 },
	                      { year: '2012', value: 20 }
	                  ],
	            xkey: 'year',
	            ykeys: ['value'],
	            labels: ['value']
	        
	        });
	        
	        new Morris.Donut({
	            element: 'morrisDonut',
	            data: [        
	                    {label: "Download Sales", value: 12},
	                    {label: "In-Store Sales", value: 30},
	                    {label: "Mail-Order Sales", value: 20}
	                  ]
	        });
		
	};                 
          
        
    </script>



</head>
<body>
      <div id="morrisChart" ></div>        
      <div id="morrisDonut" ></div>        
    
    

</body>
</html>