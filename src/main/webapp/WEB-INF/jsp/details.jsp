<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
 <title>AMS</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
<c:choose>
 <c:when test="${mode == 'MANAGER'}">
<div class="container ">   
<div class="col-sm-6">                             
  <div class="dropdown" style="margin:50px auto; padding:20px; float:left">
    <button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown">Months
    <span class="caret"></span></button>
     <ul class="dropdown-menu">
   		<c:forEach var="m" items="${months}">
      <li><a href="/month/${m}">${m}</a></li>
      </c:forEach>
    </ul>
  </div>
  </div>
</div>
<div class="container">
<div class="col-sm-6">                                           
  <div class="dropdown"  style="margin:50px auto; padding:20px;float:left">
    <button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown">Managers
    <span class="caret"></span></button>
    <ul class="dropdown-menu">
      <c:forEach var="manager" items="${managerList}">
      <li><a href="/name/${manager.name}/${currentMonth}">${manager.name}</a></li>
      </c:forEach>
    </ul>
  </div>
  </div> 
  <div style="clear:both"></div>
  </div>
  </c:when>
 

  <c:when test="${mode == 'EMP_VIEW'}">
  <div class="container">
 <table class="table table-striped">
    <thead>
      <tr>
        <th>ID</th>
        <th>Employee Name</th>
        <th>Action</th>
      </tr>
    </thead>
    <tbody>
      <c:forEach var="emp" items="${emplist}">
      	<tr>
      		<td>${emp.empcode}</td>
      		<td>${emp.empname}</td>
      		<td><h5>
    <a href="<c:url value="/process">
        <c:param name="currname" value="${emp.empname}"/>
         <c:param name="currmonth" value="${selmonth}"/>
       </c:url>">Get Attendance Details</a>
    </h5>
</td>

      	</tr>
      </c:forEach>
    </tbody>
  </table>
  </div>
  </c:when>  
 </c:choose>
</div>

</body>
</html>
