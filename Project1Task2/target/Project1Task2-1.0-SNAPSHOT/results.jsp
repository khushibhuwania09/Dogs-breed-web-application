<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  // Fetch the "pageType" attribute from the request. If it is not null, print it to the server console
  String pageType = (String) request.getAttribute("pageType");
  if (pageType != null) {
    System.out.print(pageType);  // Server-side logging for debugging
  }
%>
<%@ page import="java.util.Map" %>

<html>
<head>
  <title>Results</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <style>
    body {
      font-family: Arial, sans-serif;
      margin: 20px;
    }
    h1 {
      color: #333;
    }
    table {
      width: 50%;
      border-collapse: collapse;
    }
    th, td {
      padding: 10px;
      border: 1px solid #ccc;
      text-align: left;
    }
    th {
      background-color: #f2f2f2;
    }
    p {
      color: #555;
    }
  </style>
</head>
<body>
<h1>Distributed Systems Class Clicker</h1>
<p>The results from the survey are:</p>

<%
  // Retrieve the "votes" map attribute from the request, which contains survey results
  Map<String, Integer> votes = (Map<String, Integer>) request.getAttribute("v");

  // Check if the votes map is not null and contains data, then display the results in a table
  if (votes != null && !votes.isEmpty()) {
%>
<table>
  <tr>
    <th>Answer</th>
    <th>Votes</th>
  </tr>
  <%
    // Iterate through the entries in the votes map and display each key-value pair in a table row
    for (Map.Entry<String, Integer> entry : votes.entrySet()) {
  %>
  <tr>
    <td><%= entry.getKey() %></td> <!-- Display the answer option -->
    <td><%= entry.getValue() %></td> <!-- Display the number of votes for the answer -->
  </tr>
  <%
    }
  %>
</table>
<%
} else {
  // If there are no votes, display a message indicating that no results are available
%>
<p>There are currently no results available.</p>
<%
  }
%>

</body>
</html>
