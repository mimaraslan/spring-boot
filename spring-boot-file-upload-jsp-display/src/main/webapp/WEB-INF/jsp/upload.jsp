<%@include file="includes/header.jsp"%>

<div class="container">
		<div class="starter-template">
		
			<h1>Upload Page</h1>
	
			<c:set var="message" scope="page" value="${message}" />
			<c:if test="${not empty message}">
				<h2><c:out value="${message}" /></h2>
			</c:if>
	       		
		    <c:set var="imageName" scope="page" value="${imageName}" />
			<c:if test="${not empty imageName}">
			  <h2>${imageName}</h2>
			  <img src="${imageName}" alt="No image" style="max-width: 70%; height: auto;" /> 
			</c:if>
			
		</div>
		    
		<hr>
			<form method="POST" action="/upload" enctype="multipart/form-data">
			    <input type="file" name="fileName" /><br />
			    <input type="submit" value="Submit" />
			</form>
</div>
	
<%@include file="includes/footer.jsp" %>