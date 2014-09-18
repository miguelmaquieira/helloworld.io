<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<script type="text/javascript">
	$(document).ready(function() {
	    $('#signinUser').bootstrapValidator();
	});
</script>
<div class="container">
    <div class="row">
        <div class="col-md-4 col-md-offset-4">
            <div class="login-panel panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title"><spring:message code="signin.title"/></h3>
                </div>
                <div class="panel-body">
                	<sf:form modelAttribute="signinUser" role="form" action="${flowExecutionUrl}&_eventId=doSignin" method="post"
                		            data-bv-feedbackicons-valid="glyphicon glyphicon-ok"
                					data-bv-feedbackicons-invalid="glyphicon glyphicon-remove"
                					data-bv-feedbackicons-validating="glyphicon glyphicon-refresh">
                        <fieldset>
                            <div class="form-group">
                            	<spring:message code="common.form.field.email" var="emailPlaceholder"/>
                            	<spring:message code="common.form.field.empty.error" arguments="${emailPlaceholder}" var="emailEmptyError"/>
                            	<spring:message code="common.form.field.valid.error" arguments="${emailPlaceholder}" var="emailValidError"/>
                            	<spring:bind path="email">
                            		<input name="email" class="form-control" type="text" placeholder="${emailPlaceholder}" autofocus="autofocus" value="${signinUser.email}"
                            				data-bv-notempty="true"
                            				data-bv-notempty-message="${emailEmptyError}"
                            				data-bv-emailaddress="true"
                            				data-bv-emailaddress-message="${emailValidError}"/>
                            	</spring:bind>
                            </div>
                            <div class="form-group">
                            	<c:set value="6" var="passwordMinLength"></c:set>
                            	<c:set value="12" var="passwordMaxLength"></c:set>
                            	<spring:message code="signin.pass" var="passPlaceholder"/>
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
                            				data-bv-different-message="${passEmailError}"/>
                                </spring:bind>
                            </div>
                            <spring:hasBindErrors name="signinUser">
						        <div id="messages "class="has-error">
						            <c:forEach var="error" items="${errors.allErrors}">
						                <small class="help-block" style="display: block; padding-left:5px"> · ${error.defaultMessage}</small>
						            </c:forEach>
						        </div>
	    					</spring:hasBindErrors>
                            <div class="checkbox">
                                <label>
                                    <sf:checkbox path="remember"/><spring:message code="signin.remember"/>
                                </label>
                            </div>
                            <spring:message code="signin.action" var="signinButtonText"/>
                            <input type=submit class="btn btn-lg btn-success btn-block" value="${signinButtonText}">
                            <br>
                            <p><a href="${flowExecutionUrl}&_eventId=forgot"><spring:message code="signin.forgotPass"/></a></p>
                			<a href="${flowExecutionUrl}&_eventId=signup" class="text-center"><spring:message code="signin.signupAction"/></a>
                        </fieldset>
                    </sf:form>
                </div>
            </div>
        </div>
    </div>
</div>
