<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<%
	
	String path = request.getContextPath();
	
%>
<style type="text/css">
	table, table tr ,table tr td{
		border : 1px solid;
	}
</style>
</head>
<body>
	path:<%=path %>
	<form action="<%=path %>/role/add">
		角色名称：<input name="name" >
		备注：<input name="remarks">
		日期：<input name="registerTime" >
		<button type="button" id="btn-save">保存</button>
		<button type="button" id="btn-query">查询</button>
	</form>
	<div>已经保存的数据：</div>
	<div>
		<table id="role-table">
			<thead>
				<tr>
					<td><input type="checkbox"></td>
					<td>id</td>
					<td>角色名称</td>
					<td>备注</td>
					<td>操作</td>
				</tr>
			</thead>
			<tbody>
			
			</tbody>
		</table>
		
	
	
	</div>
	
	
	
	
	<script type="text/javascript" src="<%=path %>/static/jquery/jquery-1.10.2.min.js"></script>
	<script type="text/javascript" src="<%=path %>/static/My97DatePicker/WdatePicker.js"></script>
	<script type="text/javascript">
		/*选择器： #id , .class  html元素 */
		$("#btn-save").on("click",function(){
			$.ajax({
				url:"<%=path%>/role/add",
				data:{
					name:$("[name='name']").val(),
					remarks:$("[name='remarks']").val()
				},
				success:function(data){
					if(data.resultCode == "200"){
						alert("新增成功！");
						$("[name='name']").val("");
						$("[name='remarks']").val("");
						query();
					}else{
						alert("新增失败");
					}
					
				}
			});
		})
		
		/* 查询功能事件处理 */
		$("#btn-query").on("click",function(){
			query();
		})
		
		
		
		function query(){
			/* 发送ajax请求获取role的数据 */
			$.ajax({
					url:"<%=path%>/role/query",
					data:{
						name:$("[name='name']").val(),
						remarks:$("[name='remarks']").val()
					},
					success:function(data){
						var roleDatas = data.result;
						var html = "";
						$(roleDatas).each(function(){
							html+= "<tr>";
							html+= "<td><input type='checkbox' value='"+ this.id +"'/></td>";
							html+= "<td>"+ this.id +"</td>";
							html+= "<td>"+ this.name +"</td>";
							html+= "<td>"+ this.remarks +"</td>";
							html+= "<td><button class='btn-del' value='"+ this.id +"'>删除</button></td>";
							html+= "</tr>"
						})
						$("#role-table tbody").html(html);
					}
				});
		}
		
		query();
		
		/* 动态绑定事件 */
		$("#role-table").on("click",".btn-del",function(){
			debugger;
			var that = $(this).parents("tr");
			$.ajax({
				url:"<%=path%>/role/delete",
				type:"post",
				data:{
					id:$(this).val()
				},
				success:function(data){
					if(data.result =="success"){
						that.remove();
						alert("删除成功！");
					}else{
						alert("删除失败！");
					}
				}
			})
		})
		
		$("[name='registerTime']").on("click",function(){
			WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'});
		})
	
	</script>
	
	
	
	
	
	
	
</body>
</html>