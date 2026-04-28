package com.student.management.servlet;

import com.student.management.model.Student;
import com.student.management.util.DBConnection;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/students")
public class StudentServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Student> studentList = new ArrayList<>();

        HttpSession session = req.getSession();
        String successMessage = (String) session.getAttribute("successMessage");
        String errorMessage = (String) session.getAttribute("errorMessage");

        if (successMessage != null) {
            req.setAttribute("successMessage", successMessage);
            session.removeAttribute("successMessage");
        }
        if (errorMessage != null) {
            req.setAttribute("errorMessage", errorMessage);
            session.removeAttribute("errorMessage");
        }
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "SELECT * FROM students ORDER BY created_at DESC";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Student student = new Student(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("course"),
                        rs.getTimestamp("created_at")
                );
                studentList.add(student);
            }
        } catch (SQLException e) {
            req.setAttribute("errorMessage", "Database error: " + e.getMessage());
        }

        req.setAttribute("studentList", studentList);

        req.getRequestDispatcher("/students.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        HttpSession session = req.getSession();

        if ("delete".equals(action)) {
            String idParam = req.getParameter("id");
            if (idParam != null && !idParam.trim().isEmpty()) {
                try (Connection conn = DBConnection.getConnection()) {
                    String deleteSql = "DELETE FROM students WHERE id = ?";
                    PreparedStatement dps = conn.prepareStatement(deleteSql);
                    dps.setInt(1, Integer.parseInt(idParam));
                    dps.executeUpdate();
                    session.setAttribute("successMessage", "Student record deleted successfully!");
                } catch (Exception e) {
                    session.setAttribute("errorMessage", "Error deleting student: " + e.getMessage());
                }
            } else {
                session.setAttribute("errorMessage", "Invalid ID provided for deletion.");
            }
        } else {

            String name = req.getParameter("name");
            String email = req.getParameter("email");
            String course = req.getParameter("course");

            if (name == null || name.trim().isEmpty() ||
                email == null || email.trim().isEmpty() ||
                course == null || course.trim().isEmpty()) {
                session.setAttribute("errorMessage", "All fields are required. Please fill them out correctly.");
            } else {
                try (Connection conn = DBConnection.getConnection()) {
                    String sql = "INSERT INTO students (name, email, course) VALUES (?, ?, ?)";
                    PreparedStatement ps = conn.prepareStatement(sql);
                    ps.setString(1, name.trim());
                    ps.setString(2, email.trim());
                    ps.setString(3, course.trim());
                    ps.executeUpdate();
                    session.setAttribute("successMessage", "Student registered successfully!");
                } catch (SQLException e) {
                    session.setAttribute("errorMessage", "Error saving student: " + e.getMessage());
                }
            }
        }
        resp.sendRedirect("students");
    }
}
