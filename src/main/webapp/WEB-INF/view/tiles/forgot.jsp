<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<script type="text/javascript">
	$(document).ready(function() {
	    $('#forgotUser').bootstrapValidator();
	});
</script>
<div class="container">
    <div class="row">
        <div class="col-md-6 col-md-offset-3">
            <div class="login-panel panel panel-default">
                <div class="panel-heading">
                    <h1 class="panel-title"><spring:message code="forgot.title"/></h1>
                </div>
                <div class="panel-body">
                	<p class="text-primary" style="font-size:12px;"><spring:message code="forgot.infoMessage"/></p>
                	<sf:form modelAttribute="forgotUser" role="form" action="${flowExecutionUrl}&_eventId=doRecover" method="post"
                		            data-bv-feedbackicons-valid="glyphicon glyphicon-ok"
                					data-bv-feedbackicons-invalid="glyphicon glyphicon-remove"
                					data-bv-feedbackicons-validating="glyphicon glyphicon-refresh">
                        <fieldset>
                            <div class="form-group">
                            	<spring:message code="common.form.field.email" var="emailPlaceholder"/>
                            	<spring:message code="common.form.field.empty.error" arguments="${emailPlaceholder}" var="emailEmptyError"/>
                            	<spring:message code="common.form.field.valid.error" arguments="${emailPlaceholder}" var="emailValidError"/>
                            	<label><spring:message code="forgot.email.title"/></label>
                            	<spring:bind path="email">
                            		<input name="email" class="form-control" type="text" placeholder="${emailPlaceholder}" autofocus="autofocus"
                            				data-bv-notempty="true"
                            				data-bv-notempty-message="${emailEmptyError}"
                            				data-bv-emailaddress="true"
                            				data-bv-emailaddress-message="${emailValidError}"/>
                            	</spring:bind>
                            </div>
                            <spring:hasBindErrors name="email">
			        <div id="messages "class="has-error">
			            <c:forEach var="error" items="${errors.allErrors}">
			                <small class="help-block" style="display: block; padding-left:5px"> · ${error.defaultMessage}</small>
			            </c:forEach>
			        </div>
	    		</spring:hasBindErrors>
                            <spring:message code="forgot.action" var="forgotButtonText"/>
                            <input type=submit class="btn btn-lg btn-success btn-block" value="${forgotButtonText}">
                        </fieldset>
                    </sf:form>
                </div>
            </div>
        </div>
    </div>
</div>
