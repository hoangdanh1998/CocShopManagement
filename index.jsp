<%-- 
    Document   : index
    Created on : Dec 12, 2018, 8:43:48 PM
    Author     : Hoang Danh
--%>

<%@page import="java.util.Date"%>
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

        <s:head/>
    </head>
    <body class="ui container">
        <div class="ui active fullscreen modal">
            <div class="header">
                <h1>Welcome to CocShop</h1>
            </div>
            <div class="content">
                <s:if test="%{#session.USER  == null}" >
                    <a class="ui button" href="login.jsp">Sign in</a>
                    <a href="signUp.jsp" class="ui button">Sign up</a>
                </s:if>
                <s:else>
                    Hi. <s:property value="%{#session.USER.getFullname()}"/> <br/>
                    <s:a cssClass="ui button" href="user/editProfile.jsp">Edit profile</s:a>
                    <s:a cssClass="ui button" action="LogOutAction">Log out</s:a>
                    <s:a cssClass="ui button" action="ViewCartAction">View cart</s:a>
                    <s:a cssClass="ui button" action="ViewOrderAction">View my order</s:a>
                </s:else>
                <s:if test="%{list != null}">
                    <s:if test="%{list.isEmpty()}">
                        Sorry!!! So many connection
                    </s:if>
                    <s:else>
                        <table class="ui large table">
                            <thead>
                                <tr>
                                    <th>No</th>
                                    <th>Name</th>
                                    <th>Description</th>
                                    <th>Type</th>
                                    <th>Quantity</th>
                                    <th>Price</th>
                                        <s:if test="%{#session.USER.getRole().equals('user')}">
                                        <th>Add To Cart</th>
                                        </s:if>
                                </tr>
                            </thead>

                            <tbody>
                                <s:iterator value="list" status="counter">
                                    <tr>
                                        <td><s:property value="%{#counter.count}"/></td>
                                        <td><s:property value="name"/></td>
                                        <td style="white-space: pre-wrap"><s:property value="description"/></td>
                                        <td><s:property value="type"/></td>
                                        <td><s:property value="quantity"/></td>
                                        <td><s:property value="price"/></td>
                                        <s:if test="%{#session.USER.getRole().equals('user')}">
                                            <td>

                                                <s:form action="AddToCartAction">
                                                    <s:hidden value="%{id}" name="productID"/>
                                                    <div class="ui  action input">
                                                        <input  name="quantity" type="number" value="1"  type="number" min="1" max="%{quantity}">
                                                    <button type="submit" class="ui vertical animated button"  >
                                                        <div class="hidden content" type>Add</div>
                                                        <div class="visible content">
                                                            <i class="shop icon"></i>
                                                        </div>
                                                    </button>

                                                    </div>

                                                </s:form>
                                            </td>
                                        </s:if>
                                    </tr>
                                </s:iterator>                                                        
                            </tbody>
                        </table>
                    </s:else>    
                </s:if>
            </div>
        </div>

    </body>
</html>
