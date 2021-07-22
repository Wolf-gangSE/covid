package com.example.covid.covid.servlet.crud;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(
  name = "ReadServlet",
	urlPatterns = {"/crud/read"}
  )
//Apresenta todos os elementos da tabela
public class ReadServlet extends HttpServlet{
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String url = "jdbc:postgresql://localhost:5432/ppsw_covid_webapp";
    String user = "postgres";
    String password = "Post*2939";


    try {
      Connection conn = DriverManager.getConnection(url, user, password);
      Statement readStn = conn.createStatement();
      ResultSet rsElementos = readStn.executeQuery("SELECT * from input");

      while (rsElementos.next()) {
        int id = rsElementos.getInt("id");
        String country = rsElementos.getString("country");
        int cases = rsElementos.getInt("cases");
        int deaths = rsElementos.getInt("deaths");
        int recovered = rsElementos.getInt("recovered");
        resp.getOutputStream().println("[id: " + id + ", country: " + country + ", cases: " + cases + ", deaths: " + deaths + ", recovered:" + recovered + "]");
      }
       rsElementos.close();
       readStn.close();
       conn.close();
    } catch (SQLException e) {
      resp.getOutputStream().println("Não foi possível receber os dados do banco.");
    }

  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    doGet(req, resp);
  }
}
