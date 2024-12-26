<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP: Hash Calculator</title>
</head>
<body>
<h1>Enter a string of text data and make a choice of two hash functions</h1>

<!-- Form to accept text input and select hash function -->
<form action="computeHashes" method="post">
    <label for="text">Text:</label>
    <input type="text" id="text" name="text" required><br/><br/>

    <input type="radio" id="md5" name="hashFunction" value="MD5" checked>
    <label for="md5">MD5</label><br/>

    <input type="radio" id="sha256" name="hashFunction" value="SHA-256">
    <label for="sha256">SHA-256</label><br/><br/>

    <input type="submit" value="Compute Hash"><br/><br/>
</form>
</body>
</html>