<%-- 
    Document   : page1
    Created on : May 16, 2016, 5:57:07 PM
    Author     : Haftom Alemayehu
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<t:mainLayout pageTitle="Create Snippet">
    <jsp:body>
        <div class="container">
            <div class="row">
                <div class="col-xs-12">
                    <div class="add-edit-snippet paper">
                        <div class="heading">
                            <h2>New Snippet</h2>
                        </div>
                        <div class="body">
                            <form:form class="form-horizontal" modelAttribute="newSnippet">
                                <form:errors path="*" cssClass="alert alert-danger" element="div"/>
                                <form:select path="language" id="language-list" class="form-control">
                                    <form:option value="">Select Language</form:option>
                                    <c:forEach var="lang" items="${languages}">
                                        <form:option value="${lang.languageName}">${lang.languageName}</form:option>
                                    </c:forEach>
                                </form:select>
                                <form:input path="snippetTitle" type="text" class="form-control" placeholder="Title" />
                                <form:textarea path="content" placeholder="//Your Code Here"  id="codeEditor" cols="30" rows="10" class="form-control"/>
                                <form:textarea path="snippetDescription" id="description" cols="30" rows="5" class="form-control" placeholder="What does it do?" />
                                <div class="visiblity-control">
                                    <div> Visiblity </div>
                                    <label class="radio-inline"><form:radiobutton path="visiblity" value="private" />Private</label>
                                    <label class="radio-inline"><form:radiobutton path="visiblity" value="public" />Public</label>
                                </div>
                                <form:select multiple="true" path="tags" id="tag-list" class="form-control">
                                    <c:forEach var="tag" items="${allTags}">
                                        <form:option value="${tag.tagTitle}">${tag.tagTitle}</form:option>
                                    </c:forEach>
                                </form:select>
                                <a href="#" class="create-tag" data-toggle="modal" data-target="#addTag">
                                    Or add your own tag
                                </a>
                                <form:hidden path="owner" value="${loggedInUser.slug}"></form:hidden>
                                <input type="submit" class="login btn" value="Save" />
                            </form:form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </jsp:body>
</t:mainLayout>