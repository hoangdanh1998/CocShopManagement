<%-- 
    Document   : editProfile
    Created on : Dec 15, 2018, 11:44:58 PM
    Author     : Hoang Danh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="../src/Semantic-UI/semantic.css" rel="stylesheet" type="text/css"/>
        <link href="../src/Semantic-UI/semantic.min.css" rel="stylesheet" type="text/css"/>
        <link href="../src/css/app.css" rel="stylesheet" type="text/css"/>
    </head>
    <body class="ui container">
        <div class="ui fullscreen active modal">
            <div class="header ui breadcrumb">
                <h1>Your profile</h1>
            </div>
            <s:set name="dto" value="%{#session.USER}"/>
            <div class="content">

                <s:form action="EditProfileAction" cssClass="ui form" theme="simple">
                    <div class="fields">
                        <div class="four wide field" id="FieldBookId">
                            <label>Username</label>
                            <s:textfield name="username" readonly="true" label="Username" value="%{#dto.getUsername()}" />
                        </div>
                        <div class="twelve wide field">
                            <label>Full name</label>
                            <s:textfield name="fullname" label="Fullname" value="%{#dto.getFullname()}" required="true" />

                        </div>
                    </div>
                    <div class="field">
                        <label>Address</label>
                        <s:textarea rows="3" name="address" label="Address" value="%{#dto.getAddress()}" required="true"/>
                    </div>
                    <div class="two fields">
                        <div class="field">
                            <label>Phone number</label>
                            <s:textfield type="number" name="phone" label="Phone" value="%{#dto.getPhone()}" maxLength="10" required="true"/>

                        </div>
                        <div class="field">
                            <label>Role</label>
                            <s:textfield name="role" label="Role" readonly="true" value="%{#dto.getRole()}"  />

                        </div>

                    </div>
                    <s:url action="../TransferAction" id="BackLink"></s:url>
                    <s:a href="%{BackLink}" cssClass="ui cancel button">Back</s:a>
                    <s:submit value="Save" cssClass="ui positive button" cssStyle="float:right"/>


                </s:form>
            </div>
        </div>
    </body>
</html>
