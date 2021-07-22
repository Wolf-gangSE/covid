package com.example.covid.covid.servlet.crud;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
  name = "CreateServlet",
	urlPatterns = {"/crud/create"}
  )
//Cria um campo na tabela
public class CreateServlet extends HttpServlet{
  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String url = "jdbc:postgresql://localhost:5432/ppsw_covid_webapp";
    String user = "postgres";
    String password = "Post*2939";

    String country = req.getParameter("country");
    String cases = req.getParameter("cases");
    String deaths = req.getParameter("deaths");
    String recovered = req.getParameter("recovered");

    try {
      Connection conn = DriverManager.getConnection(url, user, password);
      Statement createStn = conn.createStatement();
      int rowsAdded = createStn.executeUpdate("INSERT INTO input(id, country, cases, deaths, recovered) VALUES (default, '" + country + "', " + cases + ", "+ deaths + ", " + recovered + ")");
      if (rowsAdded > 0) {
        resp.getOutputStream().println("Os dados foram adicionados!");
      } else {
        resp.getOutputStream().println("Nenhum dado foi adicionado!");
      }

      createStn.close();
      conn.close();

    } catch (SQLException e) {
      resp.getOutputStream().println("Não foi possível acessar o banco de dados.");
    }
    
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    doPost(req, resp);
  }
  
}
