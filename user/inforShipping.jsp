<%-- 
    Document   : inforShipping
    Created on : Dec 15, 2018, 3:14:06 PM
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
    </head>
    <body class="ui container">
        <div class="ui fullscreen active modal">

            <div class="header ui breadcrumb">
                <h1>Information Receiver</h1>
            </div>

            <div class="content">
                <s:form action="ConfirmInforAction" theme="simple" cssClass="ui form">
                    <div class="fields">
                        <div class="eight wide field">
                            <label>Sender</label>
                            <s:textfield  value="%{#session.USER.getFullname()}" label="Sender" readonly="true" />    

                        </div>
                        <div class="eight wide field">
                            <label>Receiver</label>
                            <s:textfield name="receiver" value="%{#session.USER.getFullname()}" label="Receiver"/>    
                        </div>
                    </div>
                    <div class="field">
                        <label>Note</label>
                        <s:textfield name="note" value="" label="Note"/>    
                    </div>                        
                    <div class="field">
                        <label>Address</label>
                        <s:textfield name="address" value="%{#session.USER.getAddress()}" label="Address"/>    

                    </div>
                    <div class="field">
                        <label>Phone number</label>
                        <s:textfield name="phone" value="%{#session.USER.getPhone()}" label="Phone" type="tel"/>    
                    </div>
                    
                    <s:a action="ViewCartAction" cssClass="ui cancel button" >Back</s:a>
                    <s:submit method="execute" value="Order" cssClass="ui positive button" cssStyle="float:right"/>
                </s:form>
            </div>
        </div>
    </body>
</html>
