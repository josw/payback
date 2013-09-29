<!DOCTYPE HTML>
<%@ page language="java" contentType="text/html; charset=UTF-8"  session="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="ko">
<head>
<meta http-equiv='Content-type' content='text/html; charset=utf-8'>
<meta http-equiv="cache-control" content="no-cache, must-revalidate">
<meta http-equiv="pragma" content="no-cache">
<title>떼인돈 받아드립니다.</title>
<style>

table {font: 85% "Lucida Grande", "Lucida Sans Unicode", "Trebuchet MS", sans-serif;padding: 0; margin: 0; border-collapse: collapse; color: #333; background: #F3F5F7;}
table a {color: #3A4856; text-decoration: none; border-bottom: 1px solid #C6C8CB;}
table a:visited {color: #777;}
table a:hover {color: #000;}
table caption {text-align: left; text-transform: uppercase;  padding-bottom: 10px; font: 200% "Lucida Grande", "Lucida Sans Unicode", "Trebuchet MS", sans-serif;}
table thead th {background: #3A4856; padding: 15px 10px; color: #fff; text-align: left; font-weight: normal;}
table tbody, table thead {border-left: 1px solid #EAECEE; border-right: 1px solid #EAECEE;}
table tbody {border-bottom: 1px solid #EAECEE;}
table tbody td, table tbody th {padding: 10px; text-align: left;}
table tbody tr {background: #F3F5F7;}
table tbody tr.odd {background: #F0F2F4;}
table tbody  tr:hover {background: #EAECEE; color: #111;}
table tfoot td, table tfoot th, table tfoot tr {text-align: left; font: 120%  "Lucida Grande", "Lucida Sans Unicode", "Trebuchet MS", sans-serif; text-transform: uppercase; background: #fff; padding: 10px;}


</style>
<script type="text/javascript">
	
</script>

</head>
<body>
<div id="content">
	<div id="title">
	<h2>떼인돈 받아들입니다!!</h2>
	</div>
	<div id="receivable">
	<table>
        <caption>받을 돈</caption>
        <thead>
            <tr>
                <th scope="col">빌려간 사람</th>
                <th scope="col">금액</th>
            </tr>
        </thead>
        <tbody>
        <c:forEach var="receivable" items="${receivableList}" varStatus="status">
            <c:if test="${receivable.amount > 0}">
            <tr >
                <td>${receivable.debtor }</td>
                <td>${receivable.amount }</td>
            </tr>
            </c:if>
        </c:forEach>
        </tbody>
	</table>
	</div>
     <p></p>
    <div id="debt">
        <table>
            <caption>값을 돈</caption>
            <thead>
            <tr>
                <th scope="col">빌려준 사람</th>
                <th scope="col">금액</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="debt" items="${debtList}" varStatus="status">
                <c:if test="${debt.amount > 0}">
                <tr >
                    <td>${debt.creditor }</td>
                    <td>${debt.amount }</td>
                </tr>
                </c:if>
            </c:forEach>
            </tbody>
        </table>
    </div>

    <p>

	<div id="footer">
	</div>
</div>
</body>
</html>