<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  // Fetches the "pageType" attribute from the request
  // If it's not null, prints the value to the server console
  String pageType = (String) request.getAttribute("pageType");
  if (pageType != null) {
    System.out.print(pageType);  // Server-side logging
  }
%>

<!DOCTYPE html>
<html>
<head>
  <title>Class Quiz</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
<h1>Clicker System for Distributed Systems</h1>

<%
  // Fetches the "notification" attribute from the request
  // If "notification" exists, it displays a notification message to the user
  String notification = (String) request.getAttribute("notification");
%>
<% if (notification != null) { %>
<p><%= notification %></p> <!-- Displays the notification message if it's not null -->
<% } %>

<p>Answer the following question:</p>

<!-- Form for submitting a quiz answer -->
<form action="submit" method="post">
  <input type="radio" id="answerA" name="response" value="A">
  <label for="answerA">Option A</label><br>

  <input type="radio" id="answerB" name="response" value="B">
  <label for="answerB">Option B</label><br>

  <input type="radio" id="answerC" name="response" value="C">
  <label for="answerC">Option C</label><br>

  <input type="radio" id="answerD" name="response" value="D">
  <label for="answerD">Option D</label><br>

  <input type="submit" value="Submit Answer">
</form>

</body>
</html>
