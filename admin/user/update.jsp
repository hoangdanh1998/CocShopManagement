<%-- 
    Document   : newjsp
    Created on : Dec 14, 2018, 10:52:07 AM
    Author     : Hoang Danh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
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
                <h1>Update Role User</h1>
            </div>
            <div class="content">
                <s:form action="UpdateUserAction" theme="simple" cssClass="ui form">
                    <div class="fields">
                        <div class="four wide field" id="FieldBookId">
                            <label>Username</label>
                            <s:textfield name="username" label="Username" value="%{dto.getUsername()}" readonly="true" />

                        </div>
                        <div class="twelve wide field">
                            <div class="field">
                                <label>Full Name</label>
                                <s:textfield  name="fullname"  value="%{dto.getFullname()}" readonly="true" />
                            </div>   
                        </div>
                    </div>
                    <div class="field">
                        <label>Address</label>
                        <s:textarea rows="3" name="address" label="Address" value="%{dto.getAddress()}" readonly="true" />
                    </div>   
                    <div class="two fields">
                        <div class="field">
                            <label>Phone</label>
                            <s:textfield name="phone"  value="%{dto.getPhone()}"  />
                        </div>
                        <div class="field">
                            <label>Role</label>
                            <s:textfield name="role" label="Role" value="%{dto.getRole()}"  />

                        </div>
                    </div>   
                            <s:a action="GetHomepageAction" cssClass="ui cancel button">Back</s:a>
                            <s:submit cssClass="ui positive button" value="Update" cssStyle="float:right" />
                </s:form>
            </div>
        </div>
    </body>
</html>
