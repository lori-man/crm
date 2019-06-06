<%@ page import="com.lori.domain.Customer" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<TITLE>修改客户</TITLE>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<LINK href="${pageContext.request.contextPath }/css/Style.css" type=text/css rel=stylesheet>
	<LINK href="${pageContext.request.contextPath }/css/Manage.css" type=text/css
		  rel=stylesheet>

	<script type="text/javascript" src="/js/jquery-1.11.3.min.js"></script>
	<script type="text/javascript">
		<%
			Customer cust=(Customer)request.getAttribute("customer");
		%>

       <%--$(function () {--%>
            <%--&lt;%&ndash;var cust_id = document.getElementById("cust_name");&ndash;%&gt;--%>
           <%--&lt;%&ndash;cust_id.value=<%= cust.getCustName()%>;&ndash;%&gt;--%>
            <%--var cust_mobile = document.getElementById("cust_mobile");--%>
           <%--cust_mobile.value=<%= cust.getCustMobile()%>;--%>
            <%--var phone = document.getElementById("cust_phone");--%>
           <%--phone.value=<%= cust.getCustPhone()%>;--%>
        <%--});--%>

        $(function () {
            //页面加载函数就会执行
            //页面加载，异步查询字典数据
            //加载客户资源
            $.post("/findbytypecode",{"dict_type_code":"002"},function(data){
                var str="";
                for (var i=0;i<data.length;i++){
                    if (data[i].dictId==<%= cust.getBaseDicrSource().getDictId()%>)
					{
                        str += "<option value='" + data[i].dictId + "' selected=true>" + data[i].dictItemName + "</option>";
					}else {
                        str += "<option value='" + data[i].dictId + "'>" + data[i].dictItemName + "</option>";
                    }
                }
                $("#cust_source").append(str);
                //下次改页面  补充重启项目  现在是热部署  如果改的多的话  重启一下
                //还有 后台list传到前台  for循环  点的是集合中对象entity的属性  不是你接收参数的属性
            },"json")
        })

        $(function () {
            //加载客户等级
            $.post("/findbytypecode",{"dict_type_code":"006"},function(data){
                var str="";
                for (var i=0;i<data.length;i++){
                    if (data[i].dictId==<%= cust.getBaseDictLevel().getDictId()%>)
                    {
                        str += "<option value='" + data[i].dictId + "' selected=true>" + data[i].dictItemName + "</option>";
                    }else {
                        str += "<option value='" + data[i].dictId + "'>" + data[i].dictItemName + "</option>";
                    }
                }
                $("#cust_level").append(str);
            },"json")
        })

        $(function () {
            //加载客户行业
            $.post("/findbytypecode",{"dict_type_code":"001"},function(data){
                var str="";
                for (var i=0;i<data.length;i++){
                    if (data[i].dictId==<%= cust.getBaseDicrIndustry().getDictId()%>)
                    {
                        str += "<option value='" + data[i].dictId + "' selected=true>" + data[i].dictItemName + "</option>";
                    }else {
                        str += "<option value='" + data[i].dictId + "'>" + data[i].dictItemName + "</option>";
                    }
                }
                $("#cust_industry").append(str);
            },"json")
        })



	</script>

	<META content="MSHTML 6.00.2900.3492" name=GENERATOR>
</HEAD>
<BODY>
<FORM id=form1 name=form1
	  action="/customer_update"
	  method=post enctype="multipart/form-data">



	<TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
		<TBODY>
		<TR>
			<TD width=15><IMG src="${pageContext.request.contextPath }/images/new_019.jpg"
							  border=0></TD>
			<TD width="100%" background="${pageContext.request.contextPath }/images/new_020.jpg"
				height=20></TD>
			<TD width=15><IMG src="${pageContext.request.contextPath }/images/new_021.jpg"
							  border=0></TD>
		</TR>
		</TBODY>
	</TABLE>
	<TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
		<TBODY>
		<TR>
			<TD width=15 background=${pageContext.request.contextPath }/images/new_022.jpg><IMG
					src="${pageContext.request.contextPath }/images/new_022.jpg" border=0></TD>
			<TD vAlign=top width="100%" bgColor=#ffffff>
				<TABLE cellSpacing=0 cellPadding=5 width="100%" border=0>
					<TR>
						<TD class=manageHead>当前位置：客户管理 &gt; 添加客户</TD>
					</TR>
					<TR>
						<TD height=2></TD>
					</TR>
				</TABLE>

				<TABLE cellSpacing=0 cellPadding=5  border=0>
                    <INPUT  type="hidden" id="custId"
                            value="${customer.custId}" name="custId">

					<TR>
						<td>客户名称：</td>
						<td>
							<INPUT class=textbox id="cust_name" value="${customer.custName}"
								   style="WIDTH: 180px" maxLength=50 name="custName">
						</td>
						<td>客户级别 ：</td>
						<td>
							<select id="cust_level" name="baseDictLevel.dictId">
								<option value="">-请选择-</option>
							</select>

						</td>
					</TR>

					<TR>
						<td>信息来源 ：</td>
						<td>
							<select id="cust_source" name="baseDicrSource.dictId">
								<option value="">-请选择-</option>
							</select>
						</td>
						<td>所属行业：</td>
						<td>
							<select id="cust_industry" name="baseDicrIndustry.dictId">
								<option value="">-请选择-</option>
							</select>
						</td>
					</TR>

					<TR>
						<td>固定电话 ：</td>
						<td>
							<INPUT class=textbox id=cust_mobile value="${customer.custPhone}"
								   style="WIDTH: 180px" maxLength=50 name="custPhone">
						</td>
						<td>移动电话 ：</td>
						<td>
							<INPUT class=textbox id=cust_phone value="${customer.custMobile}"
								   style="WIDTH: 180px" maxLength=50 name="custMobile">
						</td>
					</TR>
                    <INPUT  type="hidden" id="custImage"
                            value="${customer.custImage}" name="custImage">
					<tr>
						<td rowspan=3>
							<INPUT  type=file id="file"
									value="浏览" name="upload">
						</td>
					</tr>

					<%--<TR>
                        <td>联系地址 ：</td>
                        <td>
                        <INPUT class=textbox id=sChannel7
                                                style="WIDTH: 180px" maxLength=50 name="custAddress">
                        </td>
                        <td>邮政编码 ：</td>
                        <td>
                        <INPUT class=textbox id=sChannel8
                                                style="WIDTH: 180px" maxLength=50 name="custZip">
                        </td>
                    </TR>
                    <TR>
                        <td>客户传真 ：</td>
                        <td>
                        <INPUT class=textbox id=sChannel9
                                                style="WIDTH: 180px" maxLength=50 name="custFax">
                        </td>
                        <td>客户网址 ：</td>
                        <td>
                        <INPUT class=textbox id=sChanne20
                                                style="WIDTH: 180px" maxLength=50 name="custWebsite">
                        </td>
                    </TR>--%>
					<tr>
						<td rowspan=2>
							<INPUT class=button id=sButton2 type=submit
								   value=" 保存 " name=sButton2>
						</td>
					</tr>

				</TABLE>


			</TD>
			<TD width=15 background="${pageContext.request.contextPath }/images/new_023.jpg">
				<IMG src="${pageContext.request.contextPath }/images/new_023.jpg" border=0></TD>
		</TR>
		</TBODY>
	</TABLE>
	<TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
		<TBODY>
		<TR>
			<TD width=15><IMG src="${pageContext.request.contextPath }/images/new_024.jpg"
							  border=0></TD>
			<TD align=middle width="100%"
				background="${pageContext.request.contextPath }/images/new_025.jpg" height=15></TD>
			<TD width=15><IMG src="${pageContext.request.contextPath }/images/new_026.jpg"
							  border=0></TD>
		</TR>
		</TBODY>
	</TABLE>
</FORM>
</BODY>
</HTML>
