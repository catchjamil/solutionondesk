<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Spring MVC Multiple File Upload</title>
</head>
<body>
    <h1>Spring Multiple File Upload example</h1>
    <p>Following files are uploaded successfully.</p>
    <ol>
    <%try{ %>
        <c:forEach items="${files}" var="file">
            <li>${file}</li>
        </c:forEach>
     <%}catch(Exception e){
    	 e.printStackTrace();
     } %>   
    </ol>
</body>
</html>