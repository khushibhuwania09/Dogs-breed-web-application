<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Traits</title>
    <!-- Meta tag for mobile responsiveness -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
<div class="content">
    <h1>Traits</h1>

    <p>Breed: <%= request.getAttribute("breed") %></p>

    <!-- Display additional dog traits -->
    <div>
        <h3> <%= request.getAttribute("Origin") %></h3>
        <h3><%= request.getAttribute("Lifespan") %></h3>
        <h3><%= request.getAttribute("Training") %></h3>
        <h3> <%= request.getAttribute("Health") %></h3>
        <p>Credit: <a href="https://dogtime.com/dog-breeds/">https://dogtime.com/dog-breeds/</a></p>
    </div>

    <!-- Display another image -->
    <h2>Another Dog Image</h2>
    <img src="<%= request.getAttribute("another_dog_image") %>" alt="Another Dog Image"/>
    <p>Credit: <a href="https://www.akc.org/dog-breeds/">https://www.akc.org/dog-breeds/</a></p>

</div>
</body>
</html>
