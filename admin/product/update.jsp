<%-- 
    Document   : update
    Created on : Dec 14, 2018, 1:50:53 PM
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
        <div class="ui fullscreen active modal">

            <div class="header ui breadcrumb">
                <h1>Update product</h1>
            </div>
            <div class="content">
                <s:form action="UpdateAction" theme="simple" cssClass="ui form" >
                    <div class="fields">
                        <div class="four wide field">
                            <label>Food id</label>
                            <s:textfield name="id" label="Product Id" value="%{dto.getId()}" readonly="true"/>
                        </div>
                        <div class="twelve wide field">
                            <label>Name</label>
                            <s:textfield name="name" label="Product Name" value="%{dto.getName()}"/>
                        </div>
                    </div>

                    <div class="field">
                        <label>Description</label>
                        <s:textarea rows="3" name="description" value="%{dto.getName()}"/>
                    </div>
                    <div class="three fields">
                        <div class="field">
                            <label>Quantity</label>
                            <s:textfield name="quantity" type="number" label="Quantity" value="%{dto.getQuantity()}"/>
                        </div>
                        <div class="field">
                            <label>Price</label>
                            <s:textfield name="price" type="number" label="Price" value="%{dto.getPrice()}"/>

                        </div>
                        <div class="field">
                            <label>Type</label>
                            <s:textfield name="type"  label="Type" value="%{dto.getType()}"/>
                        </div>
                    </div>

                    <s:submit cssClass="ui positive button" value="Update"/>
                </s:form>
            </div>
        </div>
    </body>
</html>
