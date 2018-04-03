<%@ page isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="/WEB-INF/views/_partial/_header.jsp" />

<div class="container">
	<!-- Example row of columns -->
	<div class="row">
	
	<h1 align="center">Report With Table Design Template</h1>
       <a class="btn btn-primary btn-lg" href="/JasperReportintgWithSpringMvcExtend/" role="button">Home</a>
       
       <a target="blank"  class="btn btn-success btn-lg" href="${pageContext.request.contextPath}/reportWithTemplate/view" role="button">View  Report</a>
       <a class="btn btn-success btn-lg" href="${pageContext.request.contextPath}/reportWithTemplate/download" role="button">Download  Report</a>
       <a class="btn btn-success btn-lg" href="${pageContext.request.contextPath}/reportWithTemplate/save" role="button">Save to Desktop</a>
       
       


	</div>
	<jsp:include page="/WEB-INF/views/_partial/_footerMenu.jsp" />
</div>
<!-- /container -->
<jsp:include page="/WEB-INF/views/_partial/_footer.jsp" />