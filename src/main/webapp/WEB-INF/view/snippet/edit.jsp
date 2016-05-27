<%-- 
    Document   : page1
    Created on : May 16, 2016, 5:57:07 PM
    Author     : Haftom Alemayehu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<t:mainLayout pageTitle="Edit Snippet">
    <jsp:body>
              <div class="container">
        <div class="row">
          <div class="col-xs-12">
            <div class="add-edit-snippet paper">
              <div class="heading">
                <h2>Edit Snippet</h2>
              </div>
              <div class="body">
                <form:form  modelAttribute="editSnippet" class="form-horizontal">
                                   
                  <form:select path="snippetLanguage"  id="language-list" class="form-control">
                      <form:options items="${languages}" />
                   </form:select> 
                  <form:input type="text" path="snippetTitle" class="form-control" placeholder="Title" />
                  <form:textarea placeholder="//Your Code Here" path="content" id="codeEditor" cols="30" rows="10" class="form-control" />
                  <form:textarea placeholder="What does it do?" path="snippetDescription" id="description" cols="30" rows="5" class="form-control"  />
                  
                  <div class="visiblity-control">
                    <div>
                      Visiblity
                    </div>
                      
                    <label class="radio-inline">  <form:radiobutton path="visiblity" value="private"/>Private</label>
                    <label class="radio-inline">  <form:radiobutton path="visiblity" value="public" />Public</label>
                  </div>
                   
                   <form:select path="tags"  id="tag-list" class="form-control">
                      <form:options items="${allTags}" />
                   </form:select> 
                  
                  <input type="submit" class="login btn" value="Update" />
                  
                </form:form>
              </div>
            </div>
          </div>
        </div>
      </div>
    </jsp:body>
</t:mainLayout>