<%-- 
    Document   : page1
    Created on : May 16, 2016, 5:57:07 PM
    Author     : tekeste
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<t:mainLayout pageTitle="${snippet.snippetTitle} |SnippetHub">
    <jsp:body>
        <div class="container">
            <div class="row">
                <div class="col-xs-12">
                    <div class="single-snippet paper">
                        <div class="heading">
                            <h2>${snippet.snippetTitle}</h2>
                            <div class="actions">
                                <c:if test="${snippet.owner.equals(loggedInUser.slug)}">
                                    <a href='<c:url value="/snippets/edit/${snippet.slug}" />'><span class="glyphicon glyphicon-pencil"></span></a>
                                    <form class="trash" action='<c:url value="/snippets/delete/${snippet.slug}"></c:url>' method="post">
                                        <button type="submit" class="trash">
                                            <span class="glyphicon glyphicon-trash"></span>
                                        </button>
                                    </form>
                                </c:if>
                            </div>
                        </div>
                        <div class="body">
                            <div class="code-snippet">
                                <pre>
                                      <code class="language-javascript">
                                        ${snippet.content}
                                      </code>
                                </pre>
                            </div>
                            <div class="snippet-details">
                                <div class="snippet-title">
                                    ${snippet.snippetTitle}
                                </div>
                                <div class="description">
                                    ${snippet.snippetDescription}
                                </div>
                                <ul class="list-inline tags">
                                    <c:forEach var="tag" items="${snippet.tags}">
                                        <li><a href='<c:url value="/snippets/tag/${tag.slug}"></c:url>' class="tag">${tag.tagTitle}</a></li>
                                        </c:forEach>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </jsp:body>
</t:mainLayout>