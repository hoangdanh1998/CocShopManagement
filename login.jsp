<%-- 
    Document   : login
    Created on : Dec 12, 2018, 10:57:51 PM
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
    <body class="ui container"  >
        <div class="container"style="width: 45%; margin-left: 27%; margin-top: 10%">

            <div class="ui middle aligned center aligned grid ">
                <div class="column">
                    <h2 class="ui teal image header">
                        <div class="content">
                            Log-in to your account
                        </div>
                    </h2>
                    <s:if test="%{#request.ERROR != null}">
                        <div class="ui error message">
                            <s:property value="%{#request.ERROR}"/>
                        </div>
                    </s:if>

                    <form class="ui large form" action="LoginAction" method="POST">
                        <div class="ui stacked segment">
                            <div class="field">
                                <div class="ui left icon input">
                                    <i class="user icon"></i>
                                    <input type="text" label="Username" name="username">
                                </div>
                            </div>
                            <div class="field">
                                <div class="ui left icon input">
                                    <i class="lock icon"></i>
                                    <input type="password" name="password" placeholder="Password">
                                </div>
                            </div>
                            <input class="ui fluid large teal submit button"  type="submit" value="Login">
                            </input>
                        </div>


                    </form>

                    <div class="ui message">
                        New to us? <a href="signUp.jsp">Sign Up</a>
                    </div>
                </div>
            </div>
        </div>




    </body>
</html>
