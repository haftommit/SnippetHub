<%-- 
    Document   : header
    Created on : May 16, 2016, 8:30:10 PM
    Author     : tekeste
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@tag description="Navigation" pageEncoding="UTF-8"%>
      <div class="header">
        <div class="brand">
            <a href='<c:url value="/"/>'>
                <h1>
                    {S} SnippetHub
                </h1>
            </a>
        </div>
        <nav class="main-nav">
          <ul class="list-inline">
              <li><a href='<c:url value="/"/>'>Home</a></li>
              <li><a href='<c:url value="/snippets"/>'>Snippets</a></li>
              <li><a href='<c:url value="/tags"/>'>Tags</a></li>
              <li><a href='<c:url value="/users"/>'>People</a></li>
          </ul>
        </nav>
        <div class="account">
         
         <c:choose>
             <c:when test="${loggedInUser.firstName == null}">
                 <ul class="list-inline">
                     <li><a href='<c:url value="/login"/>'>Login</a></li>
                     <li><a class="register" href='<c:url value="/register"/>'>Register</a></li>
                 </ul>
             </c:when>
             <c:when test="${loggedInUser.firstName != null}">
                 <ul class="list-inline">
                     <li><a class="" href='<c:url value="/snippets/create"/>'>New Snippet</a></li>
                     <li><a class="" href='<c:url value="/users/${loggedInUser.slug}"/>'>${loggedInUser.firstName}</a></li>
                     <li><a href='<c:url value="/logout"/>'>Logout</a></li>
                 </ul>
             </c:when>
         </c:choose>
        </div>
      </div>
      <!-- End Header -->