<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <TITLE>编辑联系人</TITLE>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <LINK href="${pageContext.request.contextPath }/css/Style.css" type=text/css rel=stylesheet>
    <LINK href="${pageContext.request.contextPath }/css/Manage.css" type=text/css
          rel=stylesheet>


    <script type="text/javascript" src="/js/jquery-1.11.3.min.js"></script>
    <script type="text/javascript">
        $(function () {
            $("#lkm_name").attr("value", "${linkman.lkm_name}");
            $("#lkm_mobile").attr("value", "${linkman.lkm_mobile}");
            $("#lkm_email").attr("value", "${linkman.lkm_email}");
            $("#lkm_qq").attr("value", "${linkman.lkm_qq}");
            $("#lkm_memo").attr("value", "${linkman.lkm_memo}");
            $("#lkm_position").attr("value", "${linkman.lkm_position}");
            $("#lkm_phone").attr("value", "${linkman.lkm_phone}");

            <c:forEach items="${list}" var="customer">
                $("#customer").append("<option value='"+"${customer.custId}"+"'>"+"${customer.custName}"+"</option>");
            </c:forEach>
        });
        $(function () {
            $("#customer").find("option[value='${linkman.customer.custId}']").attr("selected", true);
            <%--$("input[value='${linkman.lkm_gender}']").attr('checked','true');--%>
            $(":radio[value='${linkman.lkm_gender}']").prop('checked','checked');
        });

    </script>

    <META content="MSHTML 6.00.2900.3492" name=GENERATOR>
</HEAD>
<BODY>
<FORM id=form1 name=form1
      action="/linkmanUpdate"
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
                        <TD class=manageHead>当前位置：联系人管理 &gt; 编辑联系人</TD>
                    </TR>
                    <TR>
                        <TD height=2></TD>
                    </TR>
                </TABLE>
                <TABLE cellSpacing=0 cellPadding=5 border=0>
                    <INPUT  type="hidden" id="lkm_id" value="${linkman.lkm_id}" name="lkm_id">
                    <tr>
                        <td>所属客户：</td>
                        <td colspan="3">
                            <select type="text" name="custId" style="WIDTH: 180px" id="customer">
                                <option>请选择</option>
                                <%--<c:forEach items="${list}" var="customer">--%>
                                <%--<option value="${customer.custId}">${customer.custName}</option>--%>
                                <%--</c:forEach>--%>
                            </select></td>
                    </tr>
                    <TR>
                        <td>联系人名称：</td>
                        <td>
                            <INPUT class=textbox id="lkm_name"
                                   style="WIDTH: 180px" maxLength=50 name="lkm_name">
                        </td>
                        <td>联系人性别：</td>
                        <td>
                            <input  id="gender_male"type="radio" value="1" name="lkm_gender">男
                            <input id="gender_female"type="radio" value="2" name="lkm_gender">女
                        </td>
                    </TR>
                    <TR>
                        <td>联系人办公电话 ：</td>
                        <td>
                            <INPUT class=textbox id="lkm_phone"
                                   style="WIDTH: 180px" maxLength=50 name="lkm_phone">
                        </td>
                        <td>联系人手机 ：</td>
                        <td>
                            <INPUT class=textbox id="lkm_mobile"
                                   style="WIDTH: 180px" maxLength=50 name="lkm_mobile">
                        </td>
                    </TR>
                    <TR>
                        <td>联系人邮箱：</td>
                        <td>
                            <INPUT class=textbox id="lkm_email"
                                   style="WIDTH: 180px" maxLength=50 name="lkm_email">
                        </td>
                        <td>联系人QQ ：</td>
                        <td>
                            <INPUT class=textbox id="lkm_qq"
                                   style="WIDTH: 180px" maxLength=50 name="lkm_qq">
                        </td>
                    </TR>
                    <TR>
                        <td>联系人职位 ：</td>
                        <td>
                            <INPUT class=textbox id="lkm_position"
                                   style="WIDTH: 180px" maxLength=50 name="lkm_position">
                        </td>
                        <td>联系人备注 ：</td>
                        <td>
                            <INPUT class=textbox id="lkm_memo"
                                   style="WIDTH: 180px" maxLength=50 name="lkm_memo">
                        </td>
                    </TR>

                    <tr>
                        <td rowspan=2>
                            <INPUT class=button id=sButton2 type=submit
                                   value="保存 " name=sButton2>
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