<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"  %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<spring:eval var="sendProperty" expression="@applicationConfigurer.getProperty('app.dashboard.profile.basicInfo.send')" />
<c:url value="/profile/update/picture/upload" var="formAjaxUpdateUploadPicture"></c:url>
<script type="text/javascript">
	
	$(document).ready(function() {
		
// 		var croppicContainerEyecandyOptions = {
// 				uploadUrl:'${formAjaxUpdateUploadPicture}',
// 				cropUrl:'${formAjaxUpdateCropPicture}',
// 				imgEyecandy:false,
// 				loaderHtml:'<div class="loader bubblingG"><span id="bubblingG_1"></span><span id="bubblingG_2"></span><span id="bubblingG_3"></span></div> '
// 		};
// 		var cropContainerEyecandy = new Croppic('myPicture', croppicContainerEyecandyOptions);
		
		
		$("#userData").submit(function() {
		    var form = $(this);
		    var urlAction = form.attr('action');
		    var method = form.attr('method');
		    var dataSer = $(form).serialize();
// 		    var arrayData = $(form).serializeArray();
		    $.ajax({
		        // url can be obtained via the form action attribute passed to the JSP.
		        url: urlAction,
		        data: dataSer,
		        type: method,
		        statusCode: {
		            404: function() {
		                alert("Employee not found");
		            },
		            500: function() {
		                alert("Failed to update Employee skills");
		            }
		        },
		    });
		    return false;
		});
		var sendParam = '${sendProperty}';
		var defaults = {
			mode: 'inline', 
			send: sendParam
		};
		
		$('input[name="showBirthdate"]').bootstrapSwitch('state', true, true);
		$.extend($.fn.editable.defaults, defaults);
		$('#shortDescription').editable({
			escape: true
		});
		$('#longDescription').editable({
			escape: true,
			rows: 10
		});
		$('#looking').editable({
			escape: true,
			rows: 10
		});
		$('#name').editable({});
		$('#birthdate').editable({
			 format: 'MM/DD/YYYY',
			 viewformat: 'MM.DD.YYYY',
			 template: 'MM / DD / YYYY',
			 combodate: {
			 	minYear: 1900,
			 	maxYear: 2025,
			 	minuteStep: 1
			 }
		});
		// good to test: example http://plnkr.co/edit/1JdyIqqiZ7GxVQ2tCCgo?p=preview
		$('#gender').editable({
			select2: {
				multiple: false,
				width: '200px',
				dataType: 'json',
				cache: true,
				ajax: {
					type: 'POST',
					results: function (data) {
						var dataResults = [];
						$.each(data, function(index, item){
							dataResults.push({
								id: item.id,
								text: item.value
							});
						});
						return {
							results: dataResults
						};
					}
				}
			}
		});
		$('#timezone').editable({
			select2: {
				multiple: false,
				width: '250px',
				dataType: 'json',
				quietMilles: 100,
				ajax: {
					type: 'GET',
					cache: true,
					results: function (data) {
						var dataResults = [];
						$.each(data, function(index, item) {
							dataResults.push({
								text: item.group
							});
							$.each(item.zones, function(index, zone) {
								dataResults.push({
									id: zone.value, 
									text: zone.name
								}); 
							});
						});
						return {
							results: dataResults
						};
					}
				},
				formatResult: formatTimezoneNode
			}
		});
		var service = new google.maps.places.AutocompleteService();
		var geocoder = new google.maps.Geocoder();
		$('#fromLocation').editable({
			typeahead: {
				source: function(query, process) {
			        service.getPlacePredictions({
			          input: query
			        }, function(predictions, status) {
			          if (status == google.maps.places.PlacesServiceStatus.OK) {
			            process($.map(predictions, function(prediction) {
			              return prediction.description;
			            }));
			          }
			        });
			      },
			      updater: function(item) {
			        geocoder.geocode({
			          address: item
			        }, function(results, status) {
			          if (status != google.maps.GeocoderStatus.OK) {
			            return;
			          }
			          map.setCenter(results[0].geometry.location);
			          map.setZoom(12);
			        });
			        return item;
			      }
			}
		});
		$('#livingLocation').editable({
			typeahead: {
				source: function(query, process) {
			        service.getPlacePredictions({
			          input: query
			        }, function(predictions, status) {
			          if (status == google.maps.places.PlacesServiceStatus.OK) {
			            process($.map(predictions, function(prediction) {
			              return prediction.description;
			            }));
			          }
			        });
			      },
			      updater: function(item) {
			        geocoder.geocode({
			          address: item
			        }, function(results, status) {
			          if (status != google.maps.GeocoderStatus.OK) {
			            return;
			          }
			          map.setCenter(results[0].geometry.location);
			          map.setZoom(12);
			        });
			        return item;
			      }
			}
		});
// 		$('#pictureURL').fileinput({
// 			maxFileSize: 16,
// 			maxFileCount: 1
// 		});
		$('#fileupload').fileupload({
        	dataType: 'json',
        	done: function (e, data) {
            	alert('sdasd');
        	},
        	progressall: function (e, data) {
            	var progress = parseInt(data.loaded / data.total * 100, 10);
            	$('#progress .bar').css('width',
                	progress + '%'
            	);
        	},
 
        	dropZone: $('#dropzone')
    	});
		
		function formatTimezoneNode(node) {
			if (!node.id) {
				return "<b>" + node.text + "</b>";
			} else {
				return "<span>&nbsp;&nbsp;" + node.text + "</span>";
			}
		}
	});
	
</script>
<c:url value="/profile/update/form" var="formAjaxUpdateForUrl"></c:url>
<div class="panel-body">
	<sf:form modelAttribute="userData" class="form-horizontal" role="form" action="${formAjaxUpdateForUrl}">
		<fieldset>
			<c:url value="/profile/update" var="formAjaxUpdateUrl"></c:url>
			<c:url value="/profile/data" var="formAjaxDataUrl"></c:url>
			<div class="form-group">
				<label for="name" class="control-label col-lg-3"><spring:message code="dashboard.profile.info.username" /></label>
				<spring:bind path="name">
					<div class="col-lg-9">
						<a href="#" id="name" name="name" data-type="text" data-url="${formAjaxUpdateUrl}">${userData.name}</a>
					</div>
				</spring:bind>
			</div>
			<div class="form-group">
				<label for="pictureURL" class="control-label col-lg-3">&nbsp;<spring:message code="dashboard.profile.info.photo" /></label>
				<spring:bind path="pictureURL">
					<div class="col-lg-9">
<%-- 						<input id="pictureURL" name="pictureURL" type="file" class="file" value="${userData.pictureURL}"> --%>
						<input id="fileupload" type="file" name="files[]" data-url="${formAjaxUpdateUploadPicture}" multiple>
						<div id="dropzone">Drop files here</div>
						<div id="progress">
        					<div style="width: 0%;"></div>
        				</div>
					</div>
				</spring:bind>
			</div>
<!-- 			<div class="form-group"> -->
<%-- 				<label for="myPicture" class="control-label col-lg-3">&nbsp;<spring:message code="dashboard.profile.info.photo" /></label> --%>
<%-- 				<spring:bind path="myPicture"> --%>
<!-- 					<div class="col-lg-9"> -->
<!-- 						<div id="myPicture" style="width:200px; height:200px; position:relative;"></div> -->
<!-- 					</div> -->
<%-- 				</spring:bind> --%>
<!-- 			</div> -->
			<div class="form-group">
				<label for="gender" class="control-label col-lg-3"><spring:message code="dashboard.profile.info.gender" /></label>
				<div class="col-lg-9">
					<a href="#" id="gender" data-type="select2"
						data-url="${formAjaxUpdateUrl}"
						data-source="${formAjaxDataUrl}/gender">${userData.gender}</a>
				</div>
			</div>
			<div class="form-group">
				<label for="birthdate" class="control-label col-lg-3"><spring:message code="dashboard.profile.info.age" /></label>
				<div class="col-lg-9">
					<a href="#" id="birthdate" data-type="combodate" data-url="${formAjaxUpdateUrl}" data-value="${userData.birthdate}"></a>
				</div>
<!-- 				<div class="col-lg-2"> -->
<!-- 					<label for="showBirthdate" class="control-label pull-right col-lg-6">Public</label> -->
<!-- 				</div> -->
<!-- 				<div class="col-lg-1">	 -->
<!-- 					<div class="pull-right"> -->
<!-- 						<input type="checkbox" id="showBirthdate" name="showBirthdate" data-size="small" checked="checked"> -->
<!-- 					</div> -->
<!-- 				</div> -->
			</div>
			<div class="form-group">
				<label for="fromLocation" class="control-label col-lg-3"><spring:message code="dashboard.profile.info.from" /></label>
				<div class="col-lg-9">
					<a href="#" id="fromLocation" data-type="typeaheadjs" data-url="${formAjaxUpdateUrl}">${userData.fromLocation}</a>
				</div>
			</div>
			<div class="form-group">
				<label for="livingLocation" class="control-label col-lg-3"><spring:message code="dashboard.profile.info.living" /></label>
				<div class="col-lg-9">
					<a href="#" id="livingLocation" data-type="typeaheadjs" data-url="${formAjaxUpdateUrl}">${userData.livingLocation}</a>
				</div>
			</div>
			<div class="form-group">
				<label for="shortDescription" class="control-label col-lg-3"><spring:message code="dashboard.profile.info.short" /></label>
				<div class="col-lg-9">
					<a href="#" id="shortDescription" data-type="textarea" data-rows="5" data-url="${formAjaxUpdateUrl}">${userData.shortDescription}</a>
				</div>
			</div>
			<div class="form-group">
				<label for="longDescription" class="control-label col-lg-3"><spring:message code="dashboard.profile.info.long" /></label>
				<div class="col-lg-9">
					<a href="#" id="longDescription" data-type="textarea" data-url="${formAjaxUpdateUrl}">${userData.longDescription}</a>
				</div>
			</div>
			<div class="form-group">
				<label for="looking" class="control-label col-lg-3"><spring:message code="dashboard.profile.info.looking" /></label>
				<div class="col-lg-9">
					<a href="#" id="looking" data-type="textarea" data-url="${formAjaxUpdateUrl}">${userData.looking}</a>
				</div>
			</div>
			<div class="form-group">
				<label for="timezone" class="control-label col-lg-3"><spring:message code="dashboard.profile.info.timezone" /></label>
				<div class="col-lg-9">
					<c:set var="timezoneValue">
						<spring:message code="dashboard.profile.info.timezone" />
					</c:set>
					<c:if test="${not empty userData.timezone}">
						<c:set value="${userData.timezone}" var="timezoneValue"></c:set>
					</c:if>
					<c:url value="static/json/timezones.json" var="timezonesUrl"></c:url>
					<a href="#" id="timezone" data-type="select2" data-url="${formAjaxUpdateUrl}" data-source="${timezonesUrl}">${timezoneValue}</a>
				</div>
			</div>
			<c:if test="${sendProperty != 'always'}">
				<div class="form-group">
					<div class="col-lg-2 col-lg-offset-10">
						<spring:message code="dashboard.profile.info.sendBasic" var="sendBasinInfo" />
						<input type="submit" class="btn btn-lg btn-primary btn-outline btn-block pull-right" value="${sendBasinInfo}">
					</div>
				</div>
			</c:if>
		</fieldset>
	</sf:form>
</div>