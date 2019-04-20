<%-- 
    Document   : viewDetail
    Created on : Dec 15, 2018, 6:18:43 PM
    Author     : Hoang Danh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="src/css/app.css" rel="stylesheet" type="text/css"/>
        <link href="src/Semantic-UI/semantic.css" rel="stylesheet" type="text/css"/>
        <link href="src/Semantic-UI/semantic.min.css" rel="stylesheet" type="text/css"/>
    </head>
    <body class="ui container">
        <div class="ui active fullscreen modal">
            <div class="header">
                <h1>Detail order</h1>
            </div>
            <div class="content">

                <s:if test="%{list == null || list.isEmpty()}">
                    Not have not order
                </s:if>
                <s:else>
                     <table class="ui large table">
                        <thead>
                            <tr>
                                <th>No.</th>
                                <th>Product Name</th>
                                <th>Quantity</th>
                                <th>Type</th>
                                <th>Price</th>
                            </tr>
                        </thead>
                        <tbody>
                            <s:iterator value="list" status="counter">
                                <tr>
                                    <td><s:property value="%{#counter.count}"/></td>
                                    <td><s:property value="name"/> </td>
                                    <td><s:property value="quantity"/></td>
                                    <td><s:property value="type"/></td>
                                    <td><s:property value="price"/></td>
                                </tr>
                            </s:iterator>

                        </tbody>
                    </table>

                </s:else>
                    <s:a action="ViewOrderAction" cssClass="ui cancel button">Back</s:a>
            </div>
        </div>
    </body>
</html>
