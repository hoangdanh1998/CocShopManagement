<%-- 
    Document   : managerProduct
    Created on : Dec 13, 2018, 7:55:48 PM
    Author     : Hoang Danh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <s:head/>
        <script type="text/javascript">

        </script>
        <link href="src/css/app.css" rel="stylesheet" type="text/css"/>
        <link href="src/Semantic-UI/semantic.css" rel="stylesheet" type="text/css"/>
        <link href="src/Semantic-UI/semantic.min.css" rel="stylesheet" type="text/css"/>
    </head>
    <body class="ui container">
        <div class="ui active fullscreen modal">
            <div class="header">
                <h1>Product Manager Page</h1>
            </div>
            <div class="content">
                <s:form action="SearchAction" cssClass="ui big right action fluid input" theme="simple">
                    <s:textfield name="searchValue" label="Product Name" required="true" />
                    <s:hidden name="typeInput" value="Product"/>
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
                                    <th>ID</th>
                                    <th>Name</th>
                                    <th>Description</th>
                                    <th>Quantity</th>
                                    <th>Price</th>
                                    <th>Type</th>
                                    <th></th>
                                    <th></th>
                                </tr>
                            </thead>
                            <tbody>
                                <s:iterator status="counter" value="list">
                                    <tr>
                                        <td><s:property value="%{#counter.count}" /> </td>                            
                                        <td><s:property value="id"/></td>
                                        <td><s:property value="name"/></td>
                                        <td><s:property value="description"/></td>
                                        <td><s:property value="quantity"/></td>
                                        <td><s:property value="price"/></td>
                                        <td><s:property value="type"/></td>
                                        <td>
                                            <s:form action="EditAction">
                                                <s:hidden name="pk" value="%{id}"/>
                                                <s:hidden name="typeInput" value="Product"/>
                                                <button  data-tooltip="Edit"  class="circular ui icon button ShowOnHover" type="submit">
                                                    <i class="icon edit"></i>
                                                </button>
                                            </s:form>
                                        </td> 
                                        <td>
                                            <s:url action="DeleteAction" id="DelLink">
                                                <s:param name="pk" value="%{id}"/>
                                                <s:param name="typeInput" value="'Product'"/>
                                            </s:url>
                                            <s:a href="%{DelLink}" cssClass="circular ui icon button ShowOnHover" data-tooltip="Delete" >
                                                <i class="trash alternate icon"></i>
                                            </s:a>
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

        <s:url action="TransferAction" id="AddLink">
            <s:param name="typeInput" value="'InsertProduct'"></s:param>
        </s:url>

        <div style="position:fixed; right: 20px; bottom: 20px; z-index: 11;">
            <s:a 
                href="%{AddLink}"
                cssClass="circular massive ui icon orange button" 
                data-tooltip="Add new food" 
                data-position="top right"
                >
                <i class="icon plus"></i>
            </s:a>
        </div>
    </body>
</html>
