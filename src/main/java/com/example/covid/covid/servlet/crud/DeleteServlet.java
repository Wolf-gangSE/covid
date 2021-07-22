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
  name = "DeleteServlet",
	urlPatterns = {"/crud/delete"}
  )

//Deleta os dados pelo nome do país
public class DeleteServlet extends HttpServlet{
  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String url = "jdbc:postgresql://localhost:5432/ppsw_covid_webapp";
    String user = "postgres";
    String password = "Post*2939";

    String country = req.getParameter("country");

    try {
      Connection conn = DriverManager.getConnection(url, user, password);
      Statement createStn = conn.createStatement();
      int rowsRemoved = createStn.executeUpdate("DELETE FROM input WHERE country = '" + country + "'");
      if (rowsRemoved > 0) {
        resp.getOutputStream().println("Os dados foram deletados!");
      } else {
        resp.getOutputStream().println("Nenhum dado foi removido!");
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
