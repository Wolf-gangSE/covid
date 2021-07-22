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
  name = "UpdateServlet",
	urlPatterns = {"/crud/update"}
  )
public class UpdateServlet extends HttpServlet{
  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String url = "jdbc:postgresql://localhost:5432/ppsw_covid_webapp";
    String user = "postgres";
    String password = "Post*2939";

    String country = req.getParameter("country");
    String newCases = req.getParameter("cases");
    String newDeaths = req.getParameter("deaths");
    String newRecovered = req.getParameter("recovered");

    try {
      Connection conn = DriverManager.getConnection(url, user, password);
      Statement updateStn = conn.createStatement();
      int rowsUpdated = 0;
      if (newCases == null && newDeaths == null && newRecovered == null){
      } else if (newCases != null && newDeaths == null && newRecovered == null) {
        rowsUpdated = updateStn.executeUpdate("UPDATE input SET cases = " + newCases +  "WHERE country = '" + country + "'");
      } else if (newCases != null && newDeaths != null && newRecovered == null) {
        rowsUpdated = updateStn.executeUpdate("UPDATE input SET cases = " + newCases + ", deaths = " + newDeaths + " WHERE country = '" + country + "'");
      } else if (newCases != null && newDeaths == null && newRecovered != null) {
        rowsUpdated = updateStn.executeUpdate("UPDATE input SET cases = " + newCases + ", recovered = " + newRecovered + " WHERE country = '" + country + "'");
      } else if (newCases == null && newDeaths != null && newRecovered != null) {
        rowsUpdated = updateStn.executeUpdate("UPDATE input SET deaths = " + newDeaths + ", recovered = " + newRecovered + " WHERE country = '" + country + "'");
      } else {
        rowsUpdated = updateStn.executeUpdate("UPDATE input SET cases = " + newCases + " deaths = " + newDeaths + ", recovered = " + newRecovered + " WHERE country = '" + country + "'");
      }

      
      if (rowsUpdated > 0) {
        resp.getOutputStream().println("Os dados foram atualizados!");
      } else {
        resp.getOutputStream().println("Nenhum dado foi atualizado!!");
      }

      updateStn.close();
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

