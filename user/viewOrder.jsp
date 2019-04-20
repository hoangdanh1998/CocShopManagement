<%-- 
    Document   : viewOrder
    Created on : Dec 15, 2018, 5:20:03 PM
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
                <h1>Your order</h1>

            </div>
            <div class="content">

                <s:if test="%{list == null || list.isEmpty()}">
                    You have not order
                </s:if>
                <s:else>
                    <table class="ui large table">
                        <thead>
                            <tr>
                                <th>No.</th>
                                <th>Date</th>
                                <th>Ship Address</th>
                                <th>Receiver</th>
                                <th>Phone</th>
                                <th>Note</th>
                                <th>Status</th>
                                <th></th>
                                <th></th>
                            </tr>
                        </thead>
                        <tbody>
                            <s:iterator value="list" status="counter">
                                <tr>
                                    <td><s:property value="%{#counter.count}"/></td>
                                    <td><s:property value="orderDate"/></td>
                                    <td><s:property value="shippingAddress"/></td>
                                    <td><s:property value="receiver"/></td>
                                    <td><s:property value="phone"/></td>
                                    <td><s:property value="Note"/></td>
                                    <td><s:property value="status"/> </td>

                                    <td>
                                        <s:if test="%{status.trim().toUpperCase().equals('NEW')}">
                                            <s:set name="FinishStatus" value="Finish"/>
                                            <s:url action="CancelOrderAction" id="orerLink">
                                                <s:param name="orderId" value="%{orderID}"/>                                   
                                            </s:url>
                                            <s:a
                                                href="%{orerLink}"
                                                data-tooltip="Cancel" 
                                                cssClass="ShowOnHover circular ui icon button">
                                                <i class="close icon"></i>
                                            </s:a>
                                        </s:if>
                                    </td>
                                    <td>
                                        <s:url action="ShowDetailAction" id="showLink">
                                            <s:param name="orderID" value="%{orderID}"/>                                   
                                        </s:url>
                                        <s:a
                                            href="%{showLink}"
                                            data-tooltip="Show detail" 
                                            cssClass="ShowOnHover circular ui icon button">
                                            <i class="ellipsis vertical icon"></i>
                                        </s:a>
                                    </td>
                                </tr>
                            </s:iterator>

                        </tbody>
                    </table>
                    
                </s:else>
                       <s:url action="TransferAction" id="BackLink"></s:url>
                    <s:a href="%{BackLink}" cssClass="ui cancel button">Back</s:a>
            </div>
        </div>
    </body>
</html>
