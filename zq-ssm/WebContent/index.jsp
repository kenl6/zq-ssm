<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
 <script src="./static/echars/echarts.js"></script>
</head>
<body>
	welcome
	
	 <div id="main" style="width: 600px;height:400px;"></div>
	  <script type="text/javascript">
        // 基于准备好的dom，初始化echarts实例
        var myChart = echarts.init(document.getElementById('main'));

        // 指定图表的配置项和数据
        var option = {
        		 xAxis: {
        		        type: 'category',
        		        data: ['Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun']
        		    },
        		    yAxis: {
        		        type: 'value'
        		    },
        		    series: [{
        		        data: [820, 932, 901, 934, 1290, 1330, 1320],
        		        type: 'line'
        		    }]
        };

        // 使用刚指定的配置项和数据显示图表。
        myChart.setOption(option);
    </script>
</body>
</html>