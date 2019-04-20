<%-- 
    Document   : managerOrder
    Created on : Dec 13, 2018, 8:23:16 PM
    Author     : Hoang Danh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <!--<link href="src/css/app.css" rel="stylesheet" type="text/css"/>-->
        <link href="src/Semantic-UI/semantic.css" rel="stylesheet" type="text/css"/>
        <link href="src/Semantic-UI/semantic.min.css" rel="stylesheet" type="text/css"/>
    </head>
    <body class="ui container">
        <div class="ui active fullscreen modal">
            <div class="header">
                <h1>Shop's Order Manager!</h1>
            </div>
            <div class="content">
                <s:if test="%{list == null || list.isEmpty()}">
                    Shop have not order
                </s:if>
                <s:else>
                    <table class="ui large table">
                        <thead>
                            <tr>
                                <th rowspan="2">No</th>
                                <th rowspan="2">Customer Name</th>
                                <th colspan="3">Products</th>
                                <th rowspan="2">Status</th>
                                <th rowspan="2">Finish</th>

                            </tr>
                            <tr>
                                <th>Name</th>
                                <th>Price</th>                                            
                                <th>Quantity</th>
                            </tr>
                        </thead>
                        <tbody>
                            <s:iterator value="list" status="counter" var="orderObject" >

                                <tr>
                                    <td rowspan="<s:property value="listProduct.size()"/>">
                                        <s:property value="%{#counter.count}"/>
                                    </td>
                                    <td rowspan="<s:property value="listProduct.size()"/>">
                                        <s:property value="fullname" />
                                    </td>
                                    <td><s:property value="%{listProduct.get(0).getName()}"/></td>
                                    <td><s:property value="%{listProduct.get(0).getPrice()}"/></td>
                                    <td><s:property value="%{listProduct.get(0).getQuantity()}"/></td>

                                    <td rowspan="<s:property value="listProduct.size()"/>"><s:property value="status"/></td>
                                    <td rowspan="<s:property value="listProduct.size()"/>">
                                        <s:form action="FinishAction">
                                            <s:hidden name="orderId" value="%{orderID}"  />
                                            <s:if test="%{!status.trim().toUpperCase().equals('CANCEL')}">
                                                <button  data-tooltip="Finish"  class="circular ui icon button green" type="submit">

                                                    <i class="icon check"></i>
                                                </button>
                                            </s:if>
                                            <s:else>
                                                <button  data-tooltip="Finish"  class="circular ui icon button green disabled " type="submit">

                                                    <i class="icon check"></i>
                                                </button>
                                            </s:else>
                                        </s:form>
                                    </td>

                                </tr>
                                <s:iterator value="%{listProduct}" begin="1" var="product">
                                    <tr>
                                        <td ><s:property value="%{#product.getName()}"/></td>
                                        <td><s:property value="%{#product.getPrice()}"/></td>
                                        <td><s:property value="%{#product.getQuantity()}"/></td>
                                    </tr>
                                </s:iterator>

                            </s:iterator>

                        </tbody>
                    </table>

                </s:else>
                <s:a action="GetHomepageAction" cssClass="ui cancel button">Back</s:a>

            </div>

        </div>
    </body>
</html>
