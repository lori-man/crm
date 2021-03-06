﻿<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<TITLE>客户列表</TITLE> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<LINK href="${pageContext.request.contextPath }/css/Style.css" type=text/css rel=stylesheet>
<LINK href="${pageContext.request.contextPath }/css/Manage.css" type=text/css
	rel=stylesheet>
<script type="text/javascript" src="/js/jquery-1.11.3.min.js"></script>
<SCRIPT language=javascript>
	function to_page(page){
		if(page){
			$("#page").val(page);
		}
		document.customerForm.submit();
	}
    $(function () {
        //页面加载函数就会执行
        //页面加载，异步查询字典数据
        //加载客户资源
        $.post("/findbytypecode",{"dict_type_code":"002"},function(data){
            var str="";
            for (var i=0;i<data.length;i++){
                if (data[i].dictId=="${customer.baseDicrSource.dictId}")
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
                if (data[i].dictId=="${customer.baseDictLevel.dictId}")
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
                if (data[i].dictId=="${customer.baseDicrIndustry.dictId}")
                {
                    str += "<option value='" + data[i].dictId + "' selected=true>" + data[i].dictItemName + "</option>";
                }else {
                    str += "<option value='" + data[i].dictId + "'>" + data[i].dictItemName + "</option>";
                }
            }
            $("#cust_industry").append(str);
        },"json")
    })

    $(function () {
        $("#pageSize").find("option[value='"+"${pageBean.pageSize}"+"']").attr("selected",true);
    });
</SCRIPT>

<META content="MSHTML 6.00.2900.3492" name=GENERATOR>
</HEAD>
<BODY>
	<FORM id="customerForm" name="customerForm"
		action="/findAll"
		method=post>
		
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
								<TD class=manageHead>当前位置：客户管理 &gt; 客户列表</TD>
							</TR>
							<TR>
								<TD height=2></TD>
							</TR>
						</TABLE>
						<TABLE borderColor=#cccccc cellSpacing=0 cellPadding=0
							width="100%" align=center border=0>
							<TBODY>
								<TR>
									<TD height=25>
										<TABLE cellSpacing=0 cellPadding=2 border=0>
											<TBODY>
												<TR>
													<TD>客户名称：</TD>
													<TD><INPUT class=textbox id="custName"
														style="WIDTH: 80px" maxLength=50 name="custName"></TD>

													<TD>信息来源：</TD>
													<TD><select id="cust_source" name="baseDicrSource.dictId">
														<option value="">-请选择-</option>
													</select></TD>

													<TD>所属行业：</TD>
													<TD><select id="cust_industry" name="baseDicrIndustry.dictId">
														<option value="">-请选择-</option>
													</select></TD>

													<TD>客户级别：</TD>
													<TD><select id="cust_level" name="baseDictLevel.dictId">
														<option value="">-请选择-</option>
													</select></TD>
													
													<TD><INPUT class=button id=sButton2 type=submit
														value=" 筛选 " name=sButton2></TD>
												</TR>
											</TBODY>
										</TABLE>
									</TD>
								</TR>
							    
								<TR>
									<TD>
										<TABLE id=grid
											style="BORDER-TOP-WIDTH: 0px; FONT-WEIGHT: normal; BORDER-LEFT-WIDTH: 0px; BORDER-LEFT-COLOR: #cccccc; BORDER-BOTTOM-WIDTH: 0px; BORDER-BOTTOM-COLOR: #cccccc; WIDTH: 100%; BORDER-TOP-COLOR: #cccccc; FONT-STYLE: normal; BACKGROUND-COLOR: #cccccc; BORDER-RIGHT-WIDTH: 0px; TEXT-DECORATION: none; BORDER-RIGHT-COLOR: #cccccc"
											cellSpacing=1 cellPadding=2 rules=all border=0>
											<TBODY>
												<TR
													style="FONT-WEIGHT: bold; FONT-STYLE: normal; BACKGROUND-COLOR: #eeeeee; TEXT-DECORATION: none">
													<TD>客户名称</TD>
													<TD>客户级别</TD>
													<TD>客户来源</TD>
													<TD>客户行业</TD>
													<TD>电话</TD>
													<TD>手机</TD>
													<TD>操作</TD>
												</TR>
												<c:forEach items="${pageBean.list }" var="customer">
												<TR
													style="FONT-WEIGHT: normal; FONT-STYLE: normal; BACKGROUND-COLOR: white; TEXT-DECORATION: none">
													<TD>${customer.custName }</TD>
													<TD>${customer.baseDictLevel.dictItemName }</TD>
													<TD>${customer.baseDicrSource.dictItemName }</TD>
													<TD>${customer.baseDicrIndustry.dictItemName }</TD>
													<TD>${customer.custPhone }</TD>
													<TD>${customer.custMobile }</TD>
													<TD>
													<a href="${pageContext.request.contextPath }/edit?custId=${customer.custId}">修改</a>
													&nbsp;&nbsp;
													<a href="${pageContext.request.contextPath }/delete?custId=${customer.custId}">删除</a>
													</TD>
												</TR>
												
												</c:forEach>

											</TBODY>
										</TABLE>
									</TD>
								</TR>
								
								<TR>
									<TD><SPAN id=pagelink>
											<DIV
												style="LINE-HEIGHT: 20px; HEIGHT: 20px; TEXT-ALIGN: right">
												共[<B>${pageBean.totalCount}</B>]条记录,[<B>${pageBean.totalPage}</B>]页
												,每页显示
												<select id="pageSize" name="pageSize" onchange="to_page()">
													<option value="3" >3</option>
													<option value="5" >5</option>
													<option value="10" >10</option>
												</select>
												条
												<A href="/findAll?currPage=${pageBean.currPage-1}&pageSize=${pageBean.pageSize}" <c:if test="${pageBean.currPage<=1}"> onclick="javascript:return false;" </c:if> >前一页</A>
												<B>${pageBean.currPage}</B>
												<A href="/findAll?currPage=${pageBean.currPage+1}&pageSize=${pageBean.pageSize}" <c:if test="${pageBean.currPage>=pageBean.totalPage}"> onclick="javascript:return false;" </c:if> >后一页</A>
												到
												<input type="text" size="3" id="page" name="currPage" />
												页
												
												<input type="button" value="Go" onclick="to_page()"/>
											</DIV>
									</SPAN></TD>
								</TR>
							</TBODY>
						</TABLE>
					</TD>
					<TD width=15 background="${pageContext.request.contextPath }/images/new_023.jpg"><IMG
						src="${pageContext.request.contextPath }/images/new_023.jpg" border=0></TD>
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
