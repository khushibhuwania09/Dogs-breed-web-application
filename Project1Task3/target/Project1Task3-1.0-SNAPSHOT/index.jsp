<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome to Dog Breeds</title>
</head>
<body>
<h1>Dogs!</h1>
<p>Created by Khushi</p>

<h2>Dog Breeds</h2>

<!-- Form to go to First Page -->
<form action="DogBreedsServlet" method="get">

    <label for="breed">Choose a dog breed:</label>
    <select id="breed" name="breed">
        <option value="borzoi">Borzoi</option>
        <option value="boxer">Boxer</option>
        <option value="chihuahua">Chihuahua</option>
        <option value="collie">Collie</option>
        <option value="dachshund">Dachshund</option>
        <option value="dalmatian">Dalmatian</option>
        <option value="maltese">Maltese</option>
        <option value="otterhound">Otterhound</option>
        <option value="poodle">Poodle</option>
        <option value="rottweiler">Rottweiler</option>
        <option value="saluki">Saluki</option>
        <option value="whippet">Whippet</option>
    </select>

    <!-- Hidden input to determine which page to route to -->
    <input type="hidden" name="pageType" value="page1" />
    <br><br>
    <button type="submit">Go to First Page</button>
</form>

<br>

<!-- Form to go to Second Page -->
<form action="DogBreedsServlet" method="get">

    <label for="breed">Choose a dog breed:</label>
    <select id="breed" name="breed">
        <option value="borzoi">Borzoi</option>
        <option value="boxer">Boxer</option>
        <option value="chihuahua">Chihuahua</option>
        <option value="collie">Collie</option>
        <option value="dachshund">Dachshund</option>
        <option value="dalmatian">Dalmatian</option>
        <option value="maltese">Maltese</option>
        <option value="otterhound">Otterhound</option>
        <option value="poodle">Poodle</option>
        <option value="rottweiler">Rottweiler</option>
        <option value="saluki">Saluki</option>
        <option value="whippet">Whippet</option>
    </select>

    <!-- Hidden input to determine which page to route to -->
    <input type="hidden" name="pageType" value="page2" />
    <br><br>
    <button type="submit">Go to Second Page</button>
</form>

</body>
</html>