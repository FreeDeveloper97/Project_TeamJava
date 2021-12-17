<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>Hello world!</h1>
 
    <table>
        <thead>
            <tr>
                <th>id</th>
                <th>name</th>                
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${memberList}" var="member">
                <tr>
                    <td>${member.no}</td>                    
                    <td>${member.spotName}</td>
                    <td>${member.dustDegree}</td>
                    <td>${member.time}</td>
                    <td>${member.isIndoor}</td>
                    
                </tr>
            </c:forEach>
        </tbody>
    </table>

</body>
</html>
