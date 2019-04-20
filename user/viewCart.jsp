<%-- 
    Document   : viewCart
    Created on : Dec 15, 2018, 11:24:46 AM
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
                <h1>Your cart</h1>

            </div>
            <div class="content">
                <s:if test="%{list == null || list.isEmpty()}" >
                    You not choose anything yet
                </s:if>
                <s:else>
                    <table class="ui large table">

                        <thead>
                            <tr>
                                <th>No</th>
                                <th>Product Name</th>
                                <th>Quantity</th>
                                <th>Price</th>
                                <th>Type</th>
                                <th></th>
                            </tr>
                        </thead>
                        <tbody>
                            <s:set var="total" value="%{0}" scope="pageScope"/>
                            <s:iterator value="list" status="counter">
                                <tr>
                                    <td><s:property value="%{#counter.count}"/></td>
                                    <td><s:property value="name" /></td>
                                    <td>
                                        <s:form action="ChangeQuantityAction">
                                            <div class="ui action small input">                                                
                                                <input type="number" name="quantity" min="1" 
                                                       max="%{maxQuantity}"
                                                       value="<s:property value="quantity" />">
                                                <button  class="ui button">Update</button>
                                            </div>
                                            <s:hidden name="productID" value="%{id}"/>
                                            <s:if test="%{quantity > maxQuantity}">
                                                Not enough quantity for you
                                            </s:if>
                                        </s:form>
                                    </td>
                                    <td><s:property value="price"/></td>
                                    <td><s:property value="type"/></td>
                                    <td>
                                        <s:url action="DeleteCartAction" id="delLink">
                                            <s:param name="productID" value="id"/>                                    
                                        </s:url>
                                        <s:a
                                            href="%{delLink}"
                                            data-tooltip="Delete" 
                                            cssClass="ShowOnHover">
                                            <i class="trash alternate icon"></i>
                                        </s:a>
                                    </td>
                                </tr>

                                <s:set var="total" value="%{#total+price*quantity}" scope="pageScope"/>
                            </s:iterator>
                        </tbody>
                    </table>
                    <s:textfield label="Total" value="%{#total}" disabled="true"   />
                    <s:form action="ConfirmOrderAction">
                        <s:submit value="Order"/>
                    </s:form>
                </s:else>
                <br><s:a  cssClass="ui button"  href="TransferAction">Continue shopping</s:a>
            </div>
        </div>
    </body>
</html>
