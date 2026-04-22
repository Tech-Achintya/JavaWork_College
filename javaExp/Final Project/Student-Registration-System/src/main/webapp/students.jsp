<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Student Management System</title>
    <style>
        body { font-family: Arial, sans-serif; padding: 40px; background-color: #f0f2f5; }
        .container { background: white; padding: 30px; border-radius: 8px; box-shadow: 0 4px 12px rgba(0,0,0,0.1); }
        h1 { margin-bottom: 20px; }
        .add-link { color: #1877f2; text-decoration: none; font-weight: bold; display: inline-block; margin-bottom: 20px; }
        table { border-collapse: collapse; width: 100%; }
        th, td { border: 1px solid #ddd; padding: 12px; text-align: left; }
        th { background-color: #1877f2; color: white; }
        tr:nth-child(even) { background-color: #f9f9f9; }
        .delete-btn { background-color: #f44336; color: white; padding: 6px 12px; border: none; border-radius: 4px; font-size: 14px; cursor: pointer; transition: 0.3s; }
        .delete-btn:hover { background-color: #da190b; }
        .msg-success { color: #4CAF50; font-weight: bold; margin-bottom: 15px; }
        .msg-error { color: #f44336; font-weight: bold; margin-bottom: 15px; }
    </style>
</head>
<body>
    <div class="container">
        <h1>Student Management System - Student List</h1>
        <a href="index.html" class="add-link">+ Register New Student</a>
        <c:if test="${not empty successMessage}">
            <p class="msg-success">${successMessage}</p>
        </c:if>
        <c:if test="${not empty errorMessage}">
            <p class="msg-error">${errorMessage}</p>
        </c:if>
        <table>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Email</th>
                <th>Course</th>
                <th>Registered Date</th>
                <th>Actions</th>
            </tr>
            <c:forEach var="student" items="${studentList}">
                <tr>
                    <td>${student.id}</td>
                    <td>${student.name}</td>
                    <td>${student.email}</td>
                    <td>${student.course}</td>
                    <td>${student.createdAt}</td>
                    <td>
                        <form action="students" method="post" style="margin: 0; padding: 0;" onsubmit="return confirm('Are you sure you want to delete this student?');">
                            <input type="hidden" name="action" value="delete">
                            <input type="hidden" name="id" value="${student.id}">
                            <button type="submit" class="delete-btn">Delete</button>
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</body>
</html>
