<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<script type="text/javascript">
	$(document).ready(function() {
	    $('#signupUser').bootstrapValidator();
	});
</script>
<div class="container">
    <div class="row">
        <div class="col-md-4 col-md-offset-4">
            <div class="login-panel panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title"><spring:message code="signup.title"/></h3>
                </div>
                <div class="panel-body">
                	<sf:form modelAttribute="signupUser" role="form" action="${flowExecutionUrl}&_eventId=doSignup" method="post"
                		            data-bv-feedbackicons-valid="glyphicon glyphicon-ok"
                					data-bv-feedbackicons-invalid="glyphicon glyphicon-remove"
                					data-bv-feedbackicons-validating="glyphicon glyphicon-refresh">
                        <fieldset>
                        	<div class="form-group">
                            	<spring:message code="common.form.field.name" var="namePlaceholder"/>
                            	<spring:message code="common.form.field.empty.error" arguments="${namePlaceholder}" var="nameEmptyError"/>
                            	<spring:bind path="name">
                            		<input name="name" class="form-control" type="text" placeholder="${namePlaceholder}" autofocus="autofocus"
                            				data-bv-notempty="true"
                            				data-bv-notempty-message="${nameEmptyError}"/>
                            	</spring:bind>
                            </div>
                            <div class="form-group">
                            	<spring:message code="common.form.field.email" var="emailPlaceholder"/>
                            	<spring:message code="common.form.field.empty.error" arguments="${emailPlaceholder}" var="emailEmptyError"/>
                            	<spring:message code="common.form.field.valid.error" arguments="${emailPlaceholder}" var="emailValidError"/>
                            	<spring:bind path="email">
                            		<input name="email" class="form-control" type="text" placeholder="${emailPlaceholder}"
                            				data-bv-notempty="true"
                            				data-bv-notempty-message="${emailEmptyError}"
                            				data-bv-emailaddress="true"
                            				data-bv-emailaddress-message="${emailValidError}"/>
                            	</spring:bind>
                            </div>
                            <div class="form-group">
                            	<c:set value="6" var="passwordMinLength"></c:set>
                            	<c:set value="12" var="passwordMaxLength"></c:set>
                            	<spring:message code="signup.pass" var="passPlaceholder"/>
                            	<spring:message code="common.form.field.empty.error" arguments="${passPlaceholder}" var="passEmptyError"/>
                            	<spring:message code="common.form.field.length.error" arguments="${passPlaceholder};${passwordMaxLength};${passwordMinLength}" argumentSeparator=";" htmlEscape="false" var="passLengthError"/>
                            	<spring:message code="common.form.field.equal.error" arguments="${emailPlaceholder};${passPlaceholder}" argumentSeparator=";" var="passEmailError"/>
                            	<spring:bind path="password">
                                	<input name="password" class="form-control" placeholder="${passPlaceholder}" type="password"
                                			data-bv-notempty="true"
                            				data-bv-notempty-message="${passEmptyError}"
                            				data-bv-stringlength="true"
                            				data-bv-stringlength-min="${passwordMinLength}"
                            				data-bv-stringlength-max="${passwordMaxLength}"
                            				data-bv-stringlength-message="${passLengthError}"
                            				data-bv-different="true"
                            				data-bv-different-field="email"
                            				data-bv-different-field="name"
                            				data-bv-different-message="${passEmailError}"/>
                                </spring:bind>
                            </div>
                            <spring:hasBindErrors name="signupUser">
						        <div id="messages "class="has-error" style="margin-bottom: 10px;">
						            <c:forEach var="error" items="${errors.allErrors}">
						                <small class="help-block" style="display: block; padding-left:5px"> · ${error.defaultMessage}</small>
						            </c:forEach>
						        </div>
	    					</spring:hasBindErrors>
							<div style="font-size: 12px; margin-bottom: 6px;">
                            	<span><spring:message code="signup.terms"/></span> <a target="_blank" href="legalTerms.html"><spring:message code="signup.termsLink"/></a>
                            </div>
                            <spring:message code="signup.action" var="signupButtonText"/>
                            <input type=submit class="btn btn-lg btn-success btn-block" value="${signupButtonText}">
                            <br>
                			<a href="${flowExecutionUrl}&_eventId=signin" class="text-center"><spring:message code="signup.signinAction"/></a>
                        </fieldset>
                    </sf:form>
                </div>
            </div>
        </div>
    </div>
</div>
