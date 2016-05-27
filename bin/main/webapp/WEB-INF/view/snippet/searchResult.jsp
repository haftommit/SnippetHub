<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
                    <c:forEach var="snippet" items="${matchingSnippets}">
                        <div class="col-xs-12 col-sm-6">
                            <div class="snippet-box">
                                <a href='<c:url value="/snippets/${snippet.slug}"></c:url>'>
                                        <div class="snippet-code">
                                        <pre>
<code class="language-${snippet.language}">${snippet.content}</code>
                                        </pre>
                                    </div>
                                </a>
                                <div class="snippet-details">
                                    <a href='<c:url value="/snippets/${snippet.slug}"></c:url>'>
                                            <div class="snippet-title">
                                            ${snippet.snippetTitle}
                                        </div>
                                        <div class="description">
                                            ${snippet.snippetDescription}
                                        </div>
                                    </a>
                                    <ul class="list-inline tags">
                                        <c:forEach var="tag" items="${snippet.tags}">
                                            <li><a href="" class="tag">${tag.tagTitle}</a></li>
                                        </c:forEach>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </c:forEach>