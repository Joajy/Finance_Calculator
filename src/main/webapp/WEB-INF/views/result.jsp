<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <title>Calculation Result</title>
</head>
<body>
<h1>Calculation Result</h1>
<p>Final Amount: <span th:text="${result}"></span></p>
<a href="/calculateDeposit">Back</a>
</body>
</html>
