<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="home.css">
    <title>Registration Page</title>
</head>
<body>
    <div class="background-image"></div>
    <div class="registration-container">
        <h2>Registration</h2>
        <form action="register" method="get">
            <label for="username">Username:</label>
            <input type="text" id="username" name="username" required>
            <label for="email">Email:</label>
            <input type="email" id="email" name="email" required>
            <label for="password">Password:</label>
            <input type="password" id="password" name="password" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}"
  				title="Enter an Password 8Chartor" required>
            <button type="submit">Register</button>
            <p class="signup-link">Don't have an account? <a href="login.jsp">Sign in here</a></p>
        </form>
    </div>
</body>
</html>
