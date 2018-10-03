<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

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
<%-- <div class="container">                                           
  <div class="dropdown">
    <button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown">Managers
    <span class="caret"></span></button>
    <ul class="dropdown-menu">
      <c:forEach var="manager" items="${managerList}">
      <li><a href="/name/${manager.name}/${currentMonth}">${manager.name}</a></li>
      </c:forEach>
    </ul>
  </div>
  </div>  --%>
<c:choose>
 <c:when test="${mode =='ATT_VIEW'}">   
<div class="container">
 <table class="table table-striped">
    <thead>
      <tr>
      	 <th>Id</th>
        <th>Duration</th>
        <th>In time</th>
        <th>Out time</th>
        <th>Date</th>
        <th>Status</th>
         <th>Comment</th>
         <th>Type a Comment</th>
      </tr>
    </thead>
    <tbody>
      <c:forEach var="att" items="${attlist}">
      	<tr>
      		<td>${att.addid}</td>
      		<td>${att.duration}</td>
      		<td>${att.in_time}</td>
      		<td>${att.out_time}</td>
      		<td>${att.date}</td>
      		<td>${att.status}</td>
      		<td>${att. comment}</td>
      		<td>
      		<form action="/save/${att.addid}">
        <input type="text" name="cn"/>
        <input type="submit" value="save">
       </form>
      
 <!--   <button type="submit">Save</button> -->
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
