<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<%

      String driver = "org.gjt.mm.mysql.Driver";

	  String url = "jdbc:mysql://localhost:8080/ppi";
	  String usuario = "root";
	  String senha   = "connect";
	  
      Connection conexao;
      Statement statement;
      ResultSet resultset;
      
      try
      {
           Class.forName(driver);
           conexao = DriverManager.getConnection(url, usuario, senha);
           
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