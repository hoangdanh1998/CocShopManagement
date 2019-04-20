<%-- 
    Document   : newjsp
    Created on : Dec 14, 2018, 10:51:43 AM
    Author     : Hoang Danh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="src/Semantic-UI/semantic.css" rel="stylesheet" type="text/css"/>
        <link href="src/Semantic-UI/semantic.min.css" rel="stylesheet" type="text/css"/>
        <link href="src/css/app.css" rel="stylesheet" type="text/css"/>
    </head>
    <body class="ui container">
        <div class="ui fullscreen active modal" style="height: 90%">

            <div class="header ui breadcrumb">
                <h1>Insert Product</h1>
            </div>
            <div style="width: 50%; margin-left: 25%; margin-top: 2% ">
                <div class="content" >
                    <s:form action="InsertAction"  theme="simple" cssClass="ui form">
                        <div class="fields">
                            <div class="four wide field" >
                                <label>Food ID</label>
                                <s:textfield name="id" />
                            </div>
                            <s:if test="%{exception.message.indexOf('duplicate') > -1}">
                                <font color="red">
                                <s:property value="id"/> is existed
                                </font>
                            </s:if>
                            <div class="twelve wide field">
                                <label>Food name</label>
                                <s:textfield name="name" />
                            </div>
                        </div>
                        <div class="field">
                            <label>Description</label>
                            <s:textarea rows="2" name="description" />
                        </div>
                        <div class="field">
                            <label>Quantity</label>
                            <s:textfield name="quantity" />

                        </div>
                        <div class="field">
                            <label>Price</label>
                            <s:textfield name="price" />

                        </div>
                        <div class="field">
                            <label>Type</label>
                            <s:textfield name="type" label="Type"/>
                        </div>
                        <s:submit  value="Insert" cssClass="ui positive button" cssStyle="float:right"/>
                    </s:form>
                    <s:url action="TransferAction" id="BackLink">
                        <s:param name="typeInput" value="'Product'"></s:param>
                    </s:url>
                    <s:a href="%{BackLink}" cssClass="ui cancel button">Back</s:a>

                </div>
            </div>
        </div>
    </body>
</html>
