<%-- 
    Document   : page1
    Created on : May 16, 2016, 5:57:07 PM
    Author     : tekeste
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<t:mainLayout pageTitle="Tags | SnippetHub">
    <jsp:body>
        <div class="snippets-container">
            <div class="container">
                <div class="row">
                    <c:forEach var="tag" items="${tags}">                  
                        <div class="col-xs-6 col-sm-4">
                            <div class="tag-container">
                                <div class="tag-info">
                                    <a href='<c:url value="/snippets/tag/${tag.tagTitle}"></c:url>'>
                                        <h1>${tag.tagTitle}<span class="count">${tag.count}</span></h1>
                                    </a>
                                    <p>${tag.tagDescription}</p>                                       
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </div>
        </div>
        <!-- End Snippets Container -->
    </jsp:body>
</t:mainLayout>