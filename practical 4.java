//prac 4a
//index.jsp
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html><head><title> JSP Page</title></head>
    <body>
        <h1>Use of Intrinsic Objects in JSP</h1>
        <h1>Request Object </h1>
        Query String <%=request.getQueryString()%><br>
        Context Path <%=request.getContextPath()%><br>
        Remote Host <%=request.getRemoteHost()%><br>
        <h1>Response Object </h1>
        Character Encoding Type <%=response.getCharacterEncoding()%><br>
        Content Type
        <%=response.getContentType()%><br>
        Locale <%=response.getLocale()%><br>
        <h1>Session Object </h1>
        ID <%=session.getId()%><br>
        Creation Time <%=new java.util.Date(session.getCreationTime())%><br>
        Last Access Time<%=new java.util.Date(session.getLastAccessedTime())%><br>
    </body>
</html>


  //prac 4b
  //index.jsp
  <!DOCTYPE html>
<html>
    <head>
        <meta https-equiv="Content-Type" content="text/html;charset=UTF-8">
        <title>JSP Registration</title>
    </head>
    <body>
        <h1>Registration Form</h1>
        <form action="val.jsp" method="post">
            <table style="width:50%">
                <tr>
                    <td>Full Name</td>
                    <td><input type="text" name="fullname"/></td>
                </tr><tr>
                    <td>Age</td>
                    <td><input type="text" name="age"/></td>
                </tr><tr>
                    <td>E-Mail</td>
                    <td><input type="text" name="email" size="20"/></td>
                </tr><tr>

                    <td>Gender</td>
                    <td><input type="radio" name="gender" value="Male">Male
                        <input type="radio" name="gender" value="Female"/>Female
                    </td>
                </tr><tr>
                    <td>Hobbies</td>
                    <td><input type="checkbox" name="hb" value="Acting"/>Acting
                        <input type="checkbox" name="hb" value="Dancing"/>Dancing
                        <input type="checkbox" name="hb" value="Singing"/>Singing
                        <input type="checkbox" name="hb" value="Drawing"/>Drawing
                    </td>
                </tr>
            </table>
            <input type="submit" value="Register"/>
        </form>
    </body>
</html>

  //val.jsp
  <%@page language="java" contentType="text/html" pageEncoding="UTF-8" %>
<%!
    int ageInNumbers;
    private static final String EMAIL_REGEX = "^[\\w-\\+]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-z]{2,})$";
%>
<%
    String name = request.getParameter("fullname");
    String age = request.getParameter("age");
    String email = request.getParameter("email");
    String gender = request.getParameter("gender");
    String hb[] = request.getParameterValues("hb");
    if (name == null || name.isEmpty() || age == null || age.isEmpty() || email == null || email.isEmpty() || gender
            == null || gender.isEmpty()) {
        out.println("<font color=red>Please fill all the fields</font><br>");
    }
    if (!email.matches(EMAIL_REGEX)) {
        out.println("<font color=red>Correct Your Email Address</font><br>");
    }
    try {
        ageInNumbers = Integer.parseInt(age.trim());
    } catch (NumberFormatException e) {
        out.println("<font color=red>Age must be numbers</font><br>");
    }
    if (ageInNumbers < 18 || ageInNumbers > 60) {
        out.println("<font color=red>Age must be between 18 and 60</font><br>");
    }
%>
Your Extended Information is as follows:<br><br>
Full Name<b>:<%=name%></b><br>
Age<b>:<%=age%></b><br>
EMail<b>:<%=email%></b><br>
Gender<b>:<%=gender%></b><br>

Hobbies<b>:
    <%
        if (hb != null && hb.length != 0) {
            for (int i = 0; i < hb.length; i++) {
                out.println(hb[i]);
            }
        }
    %>

//web.xml:
<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns="http://xmlns.jcp.org/xml/ns/javaee"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"

         xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee http://xmlns.jcp.org/xml/ns/javaee/web-
app_3_1.xsd"

         version="3.1">
    <welcome-file-list>
        <welcome-file>index.jsp</welcome-file>
    </welcome-file-list>
</web-app>
    
    //prac 4c
    //Index.html:
<html>
    <head>
        <title>Practical 1 C</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <form action="prac1c" method="post">
            <table cellpadding="1">
                <thead>
                    <tr>
                        <th><b>REGISTRATION FORM</b></th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td><b>First Name : </b></td>
                        <td><input type="text" name="fname" value=""></td>
                    </tr>
                    <tr>
                        <td><b>Last Name : </b></td>
                        <td><input type="text" name="sname" value=""></td>
                    </tr>
                    <tr>
                        <td><b>Zip Code : </b></td>
                        <td><input type="text" name="zip" value=""></td>
                    </tr>
                    <tr>
                        <td><b>User Name : </b></td>
                        <td><input type="text" name="uid" value=""></td>
                    </tr>
                    <tr>
                        <td><b>Password : </b></td>
                        <td><input type="password" name="pwd" value=""></td>
                    </tr>
                    <tr>
                        <td><b>Confirm Password : </b></td>
                        <td><input type="password" name="pwd1" value=""></td>
                    </tr>
                    <tr>
                        <td><b>Town : </b></td>
                        <td><input type="text" name="town" value=""></td>
                    </tr>
                    <tr>
                        <td><b>Country : </b></td>
                        <td><input type="text" name="country" value=""></td>
                    </tr>
                    <tr>
                        <td><input type="submit" value="Submit"></td>
                    </tr>
                </tbody>
            </table>
        </form>
    </body>
</html>
//Servlet code
    import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
@WebServlet(urlPatterns = {"/prac1c"})
public class prac1c extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String connectionURL = "jdbc:mysql://localhost:3306/db";
            Connection connection = null;
            ResultSet rs;
            response.setContentType("text/html;charset=UTF-8");
            String uid = request.getParameter("uid");
            String fname = request.getParameter("fname");
            String sname = request.getParameter("sname");
            String pwd = request.getParameter("pwd");
            String pwd1 = request.getParameter("pwd1");
            String town = request.getParameter("town");
            String country = request.getParameter("country");
            String zip = request.getParameter("zip");
            try {
                Class.forName("org.gjt.mm.mysql.Driver");
                connection = DriverManager.getConnection(connectionURL, "root", "root");
                String sql = "insert into user_register values(?,?,?,?,?,?,?,?)";
                PreparedStatement pst = connection.prepareStatement(sql);
                pst.setString(1, uid);
                pst.setString(2, fname);
                pst.setString(3, sname);
                pst.setString(4, pwd);
                pst.setString(5, pwd1);
                pst.setString(6, town);
                pst.setString(7, country);
                pst.setString(8, zip);
                int numRowsChanged = pst.executeUpdate();
                out.println("Welcome : ");
                out.println("'" + fname + "'");
                pst.close();
            } catch (ClassNotFoundException e) {
                out.println("Couldnt Load database driver : " + e.getMessage());
            } catch (SQLException e) {
                out.println("SQL Exception caught : " + e.getMessage());
            } catch (Exception e) {
                out.println(e);
            } finally {
                try {
                    if (connection != null) {
                        connection.close();
                    }
                } catch (SQLException ignored) {
                    out.println(ignored);
                } }}}}

//Mysql code:
CREATE DATABASE db;
USE db;
CREATE TABLE user_register (
uid CHAR(40),
fname CHAR(40),
sname CHAR(40),
pwd CHAR(40),
pwd1 CHAR(40),
town CHAR(40),
country CHAR(40),
zipcode CHAR(40)
);

