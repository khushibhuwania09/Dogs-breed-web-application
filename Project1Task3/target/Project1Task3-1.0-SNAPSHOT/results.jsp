<%@ page import="java.net.URLEncoder" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Dog Image Result</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
<div class="content">
    <h1>Dog Image Result</h1>

    <!-- Display the breed of the dog passed from the servlet -->
    <p>Breed: <%= request.getAttribute("breed") %></p>

    <!-- Display the dog image from the API -->
    <h2>Dog Image</h2>
    <img src="<%= request.getAttribute("image_url") %>" alt="Dog Image"/>

    <!-- Attribution to the API providing the images -->
    <p>Credit: <a href="https://dog.ceo/dog-api/">https://dog.ceo/dog-api/</a></p>

    <p><%= request.getAttribute("total_images") %> images returned, using #<%= request.getAttribute("image_number") %></p>

</div>
</body>
</html>
