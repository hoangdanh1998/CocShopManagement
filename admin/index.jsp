<%-- 
    Document   : index.jsp
    Created on : Dec 13, 2018, 11:36:22 AM
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
                <h1>COC SHOP MANAGER</h1>    
            </div>
            <div class="content">

                Hello, 
                <font color="blue">
                <s:property  value="%{#session.USER.fullname}" />
                </font><br/>
                <s:url action="LogOutAction" id="logout"></s:url>
                <s:a cssClass="ui button"  href="%{logout}"  >Log out</s:a>
                    <div style="width: 50%; margin-left: 25%;     height: 300px;
                         margin-top: 80px;">
                    <s:form action="TransferAction" >
                        <s:hidden name="typeInput" value="Product"/>
                        <input class="ui fluid large teal submit button"  type="submit" value="Product manager">
                    </s:form>
                    <br>
                    <s:form action="TransferAction" >
                        <s:hidden name="typeInput" value="Order"/>
                        <input class="ui fluid large teal submit button"  type="submit" value="Order manager">
                    </s:form>
                    <br>
                    <s:form action="TransferAction" >
                        <s:hidden name="typeInput" value="User"/>
                        <input class="ui fluid large teal submit button"  type="submit" value="User manager">
                    </s:form>
                </div>

            </div>
        </div>

    </body>
</html>
