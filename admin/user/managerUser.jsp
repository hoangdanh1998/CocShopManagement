<%-- 
    Document   : managerUser
    Created on : Dec 13, 2018, 8:23:07 PM
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
                <h1>User Manager Page</h1>
            </div>
            <div class="content">
                <s:form action="SearchAction" cssClass="ui big right action fluid input" theme="simple">
                    <s:textfield name="searchValue" label="Full Name"/>
                    <s:hidden name="typeInput" value="User"/>
                    <button type="submit" class="ui icon primary big button">
                        <i class="search icon"></i>
                    </button>
                </s:form>

                <s:if test="%{list != null}" >
                    <s:if  test="%{list.isEmpty()}">
                        Not product found
                    </s:if>
                    <s:else>
                        <table class="ui medium table">
                            <thead>
                                <tr>
                                    <th>No.</th>
                                    <th>Username</th>
                                    <th>Full Name</th>
                                    <th>Address</th>
                                    <th>Phone</th>
                                    <th>Role</th>
                                    <th>Delete</th>
                                    <th>Edit</th>
                                </tr>
                            </thead>
                            <tbody>
                                <s:iterator status="counter" value="list">
                                    <tr>
                                        <td><s:property value="%{#counter.count}" /> </td>                            
                                        <td><s:property value="username"/></td>
                                        <td><s:property value="fullname"/></td>
                                        <td><s:property value="address"/></td>
                                        <td><s:property value="phone"/></td>
                                        <td><s:property value="role"/></td>
                                        <td>
                                            <s:url action="DeleteAction" id="DelLink">
                                                <s:param name="pk" value="%{username}"/>
                                                <s:param name="typeInput" value="'User'"/>
                                            </s:url>
                                            <s:a href="%{DelLink}" cssClass="circular ui icon button ShowOnHover" data-tooltip="Delete" >
                                                <i class="trash alternate icon"></i>
                                            </s:a>
                                        </td>
                                        <td>
                                            <s:form action="EditAction">
                                                <s:hidden name="pk" value="%{username}"/>
                                                <s:hidden name="typeInput" value="User"/>
                                                <button  data-tooltip="Edit"  class="circular ui icon button ShowOnHover" type="submit">
                                                    <i class="icon edit"></i>
                                                </button>
                                            </s:form>

                                        </td>
                                    </tr>
                                </s:iterator>
                            </tbody>
                        </table>
                    </s:else>   

                </s:if>
                          <s:a action="GetHomepageAction" cssClass="ui cancel button">Back</s:a>
            </div>
        </div>
    </body>
</html>
