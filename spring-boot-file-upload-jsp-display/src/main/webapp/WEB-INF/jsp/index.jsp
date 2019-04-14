<%@include file="includes/header.jsp"%>

<div class="container">
	<div class="starter-template">
		<h1>Index Page</h1>
		<h2>${message}</h2>

		<form method="POST" action="/upload" enctype="multipart/form-data">
			<input type="file" name="fileName" /><br /> 
			<input type="submit" value="Submit" />
		</form>
	</div>
</div>

<%@include file="includes/footer.jsp"%>
