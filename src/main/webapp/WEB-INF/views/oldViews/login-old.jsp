<!doctype html>
<html>
<head>
<title>Login Page</title>
</head>
<body>
    <p><font color="red">${errorMessage}</font></p>
    <form action="/login" method="POST">
        Name : <input name="user" type="text" autocomplete="off" autofocus/> 
        Password : <input name="password" type="password" autocomplete="off"/> 
        <input type="submit" />
    </form>
</body>
</html>