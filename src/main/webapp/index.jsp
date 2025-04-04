<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="sr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Meal Planning</title>
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background-color: #f9f9f9;
            color: #333;
            text-align: center;
            padding: 50px 0;
        }

        .container {
            max-width: 600px;
            margin: 0 auto;
            background-color: #fff;
            padding: 40px;
            border-radius: 12px;
            box-shadow: 0 0 15px rgba(0,0,0,0.1);
        }

        h1 {
            color: #5a5a5a;
            font-size: 2.5em;
            margin-bottom: 20px;
        }

        .btn {
            display: inline-block;
            padding: 15px 30px;
            font-size: 1.2em;
            background-color: #f8cddd;
            border: none;
            border-radius: 8px;
            color: white;
            cursor: pointer;
            text-decoration: none;
            transition: background-color 0.3s ease;
        }

        .btn:hover {
            background-color: #f8dcee;
        }

        .btn:focus {
            outline: none;
        }
    </style>
</head>
<body>

<div class="container">
    <h1>Dobrodošli u Meal Planning!</h1>
    <a href="hello-servlet" class="btn">Odaberi jela za ovu nedelju</a>
</div>

</body>
</html>
