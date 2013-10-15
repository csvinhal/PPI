<%-- 
    Document   : Logar
    Created on : 12/06/2013, 02:03:46
    Author     : Crouch
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    Connection conexao = null;
    Statement statement;
    ResultSet resultset;
      try
      {
           Class.forName("com.mysql.jdbc.Driver");
           conexao = DriverManager.getConnection("jdbc:mysql://localhost/ppi2", "root", "connect");
           
           statement = conexao.createStatement();
           String sql = "select * from usuario where email = '"+request.getParameter("email")+
                   "' and senha = '"+request.getParameter("senha")+"'";
           resultset = statement.executeQuery(sql);
           if (resultset.next())
              out.print("1");
           else
              out.print("0");
          
            }
            catch(Exception erro)
            {
               out.print(erro+"0");
            }

%>