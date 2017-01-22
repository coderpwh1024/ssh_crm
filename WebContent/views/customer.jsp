<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/js/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/js/themes/icon.css" />
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/jquery-1.7.2.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/jquery.easyui.1.2.6.min.js"></script>
<script type="text/javascript">
	$(function() {

		var columns = [ [ {
			field : 'custName',
			title : '客户名称',
			width : 200
		}, {
			field : 'custLevel',
			title : '客户级别',
			width : 150
		}, {
			field : 'custSource',
			title : '客户来源',
			width : 150
		}, {
			field : 'custLinkman',
			title : '联系人',
			width : 150
		}, {
			field : 'custPhone',
			title : '客户电话',
			width : 150
		}, {
			field : 'custMobile',
			title : '客户手机',
			width : 150
		}, ] ];
		//加载datagrid
		$('#dataid')
				.datagrid(
						{
							url : '${pageContext.request.contextPath }/customer_getFindAllpageJson.action',
							columns : columns,
							pagination : true,
							singleSelect : true,
						  toolbar: [{
							iconCls: 'icon-add',
							text:'增加',
						     handler: add   
						}] 

						});
	});
	//保存客户
	function save() {
		//添加客户提交
		  addsubmit(); 
	}
	//新增客户
	function add() {
		$('#customerForm').form('clear');
		  $('#customerWindow').window({
			modal : true
		});  
		$('#customerWindow').window('open');

	}
	//新增客户提交
	function addsubmit() {
		//写ajax代码，easyui封装的方法form方法
		$('#customerForm')
				.form(
						'submit',
						{
							//提交添加的action路径
							url : '${pageContext.request.contextPath }/customer_addCustomerJson.action',
							onSubmit : function() {
								// do some check    
								// return false to prevent submit;    
							},
							success : function(data) {
								// 将json串转为js对象
								// {"success",true}
								var data = eval('(' + data + ')');

								if (data.success) {
									//把弹出窗口关闭
									$('#customerWindow').window('close');
									//重新加载datagrid
									$('#dataid').datagrid('reload');
								}
							}
						});
	}
</script>
</head>
<body>
	<table id="dataid"></table>
	<div id="customerWindow" class="easyui-window" title="客户信息"
		style="width: 550px; height: 300px" data-options="closed:true">
		<form id="customerForm" method="post">
			<table cellpadding="5">
				<tr>
					<td>客户名称:</td>
					<td><input type="text" name="custName"></input></td>

					<td>客户级别:</td>
					<td><input name="custLevel" /></td>

					<td>客户来源:</td>
					<td><input type="text" name="custSource"></input></td>
				</tr>
				<tr>
					<td>客户电话:</td>
					<td><input name="custPhone" /></td>

					<td>客户手机:</td>
					<td><input name="custMobile" /></td>
				</tr>
				<tr>
					<td colspan="4">
						<button id="customerBtn" type="button" onclick="save()">保存</button>
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>