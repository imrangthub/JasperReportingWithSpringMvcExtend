<%@ page isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="/WEB-INF/views/_partial/_header.jsp" />
<div class="container">
	<!-- Example row of columns -->
	<div class="row">
	
	<h1 align="center">========= Jasper  Report =========</h1>
       <a class="btn btn-primary btn-lg" href="/JasperReportintgWithSpringMvcExtend/static/" role="button">Static Report</a>
       <a class="btn btn-primary btn-lg" href="/JasperReportintgWithSpringMvcExtend/staticReportWithParams/" role="button">Report With Params</a>
       <a class="btn btn-primary btn-lg" href="/JasperReportintgWithSpringMvcExtend/staticReportWithDataSource/" role="button">Report With Data Source</a>
       <a class="btn btn-primary btn-lg" href="/JasperReportintgWithSpringMvcExtend/reportWithTableView/" role="button">Report With Table View</a>
       <a class="btn btn-primary btn-lg" href="/JasperReportintgWithSpringMvcExtend/reportWithTemplate/" role="button">Report With Design Template</a>


	</div>
	<jsp:include page="/WEB-INF/views/_partial/_footerMenu.jsp" />
</div>
<!-- /container -->
<jsp:include page="/WEB-INF/views/_partial/_footer.jsp" />