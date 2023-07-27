<$@page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" url="http://java.sun.com/jsp/jstl/core" %>
<html>
  <title>View Profile</title>
</head>
<body>
  <table>
    <thead>
      <th>
        <th>Name</th>
        <th>Age</th>
        <th>Occupation</th>
      </th>
    </thead>
    <tbody>
      <c:forEach items="${profile}" var="profile">
        <tr>
          <td>${profile.name}</td>
          <td>${profile.age}</td>
          <td>${profile.occupation}</td>
        </tr>
      </c:forEach>
    </tbody>
  </table>
</body>
</html>