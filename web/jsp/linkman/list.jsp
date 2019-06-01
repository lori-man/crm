<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<TITLE>联系人列表</TITLE> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<LINK href="${pageContext.request.contextPath }/css/Style.css" type=text/css rel=stylesheet>
<LINK href="${pageContext.request.contextPath }/css/Manage.css" type=text/css
	rel=stylesheet>
<script type="text/javascript" src="js/jquery-1.11.3.min.js"></script>
<SCRIPT language=javascript>
	function to_page(page){
		if(page){
			$("#page").val(page);
		}
		document.customerForm.submit();
		
	}

	$(function () {
        <%--alert("${pagebean.pageSize}");--%>
        <%--var three = document.getElementById("three");--%>
        <%--var five = document.getElementById("five");--%>
        <%--var ten = document.getElementById("ten");--%>
        <%--if (3=="${pagebean.pageSize}") {--%>
            <%--three.selected = true;--%>
        <%--}else if (5 =="${pagebean.pageSize}") {--%>
            <%--five.select = true;--%>
        <%--}else if (10 =="${pagebean.pageSize}") {--%>
            <%--ten.select = true;--%>
        <%--}--%>
        $("#pageSize").find("option[value='"+"${pagebean.pageSize}"+"']").attr("selected",true);
    })
</SCRIPT>

<META content="MSHTML 6.00.2900.3492" name=GENERATOR>
</HEAD>
<BODY>
	<FORM id="customerForm" name="customerForm"
		action="/linkmanfindAll"
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
					<TD width=15 background="${pageContext.request.contextPath }/images/new_022.jpg"><IMG
						src="${pageContext.request.contextPath }/images/new_022.jpg" border=0></TD>
					<TD vAlign=top width="100%" bgColor=#ffffff>
						<TABLE cellSpacing=0 cellPadding=5 width="100%" border=0>
							<TR>
								<TD class=manageHead>当前位置：联系人管理 &gt; 联系人列表</TD>
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
													<TD>联系人名称：</TD>
													<TD><INPUT class=textbox id=sChannel2
														style="WIDTH: 80px" maxLength=50 name="lkmName"></TD>
													
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
													<TD>联系人名称</TD>
													<TD>性别</TD>
													<TD>办公电话</TD>
													<TD>手机</TD>
													<TD>邮箱</TD>
													<TD>QQ</TD>
													<TD>职位</TD>
													<TD>所属客户</TD>
													<TD>操作</TD>
												</TR>
												<c:forEach items="${pagebean.list }" var="linkman">
												<TR
													style="FONT-WEIGHT: normal; FONT-STYLE: normal; BACKGROUND-COLOR: white; TEXT-DECORATION: none">
													<TD>${linkman.lkm_name }</TD>
													<TD>
														<c:if test="${linkman.lkm_gender=='1'}">
															男
														</c:if>
														<c:if test="${linkman.lkm_gender=='2'}">
															女
														</c:if>
													</TD>
													<TD>${linkman.lkm_phone }</TD>
													<TD>${linkman.lkm_mobile }</TD>
													<TD>${linkman.lkm_email }</TD>
													<TD>${linkman.lkm_qq }</TD>
													<TD>${linkman.lkm_position }</TD>
													<TD>${linkman.customer.custName }</TD>

													<TD>
													<a href="/linkmanedit?lkm_id=${linkman.lkm_id}">修改</a>
													&nbsp;&nbsp;
													<a href="${pageContext.request.contextPath }/linkmanServlet?method=delete&lkmId=${linkman.lkm_id}">删除</a>
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
												共[<B>${pagebean.totalCount}</B>]条记录,[<B>${pagebean.totalPage}</B>]页
												,每页显示
												<select id="pageSize" name="pageSize" onchange="to_page()">
													<option id="three" value="3" >3</option>
													<option id="five" value="5" >5</option>
													<option id="ten" value="10">10</option>
												</select>
												条
												[<A href="/linkmanfindAll?currPage=${pagebean.currPage-1}&pageSize=${pagebean.pageSize}" <c:if test="${pagebean.currPage<=1}"> onclick="javascript:return false;" </c:if>>前一页</A>]
												<B>${pagebean.currPage}</B>
												[<A href="/linkmanfindAll?currPage=${pagebean.currPage+1}&pageSize=${pagebean.pageSize}" <c:if test="${pagebean.currPage>=pagebean.totalPage}"> onclick="javascript:return false;" </c:if>>后一页</A>]
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
