<%-- 
    Document   : signUp
    Created on : Dec 16, 2018, 11:43:58 AM
    Author     : Hoang Danh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="src/Semantic-UI/semantic.css" rel="stylesheet" type="text/css"/>
        <link href="src/Semantic-UI/semantic.min.css" rel="stylesheet" type="text/css"/>
        <link href="src/css/app.css" rel="stylesheet" type="text/css"/>

    </head>
    <body class="ui container" style="width: 50%">
        <div class="ui fullscreen active modal">
            <div class="header ui breadcrumb">
                <h1>Sign Up</h1>
            </div>
            <div class="content">

                <s:form action="RegisterAction" cssClass="ui form" theme="simple">
                    <s:if test="%{exception.message.indexOf('duplicate') > -1}">
                        <font color="red">
                        <s:property value="username"/> is existed
                        </font>
                    </s:if>
                    <div class="field">
                        <label>Username</label>
                        <s:textfield name="username" label="Username" maxLength="20" required="true"/>
                    </div>
                    <div class="field">
                        <label>Password</label>
                        <s:password name="password"  label="Password" required="true" />
                    </div>
                    <div class="field">
                        <label>Confirm</label>
                        <s:password name="confirm" label="Confirm Password" required="true" />
                    </div>
                    <div class="field">
                        <label>Fullname</label>
                        <s:textfield name="fullname" label="Full Name" required="true"/>
                    </div>
                    <div class="field">
                        <label>Address</label>
                        <s:textarea rows="3" name="address" label="Address" required="true"/>
                    </div>
                    <div class="field">
                        <label>Phone number</label>
                        <s:textfield name="phone"  type="number" required="true" maxLength="10"/>
                    </div>

                    <s:a href="login.jsp" cssClass="ui cancel button">Have account</s:a>
                    <s:submit value="Sign up" cssClass="ui positive button" cssStyle="float:right"/>
                </s:form>
            </div>
        </div>
    </body>
</html>
