package com.example.covid.covid.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
		name = "Index",
		urlPatterns = {"/db"}
		)

public class IndexServlet extends HttpServlet{
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    try {
      Class.forName("org.postgresql.Driver");
      String url = "jdbc:postgresql://localhost:5432/ppsw_covid_webapp";
      String user = "postgres";
      String password = "Post*2939";
      Connection conn = DriverManager.getConnection(url, user, password);
      Statement listarElementosStn = conn.createStatement();
      ResultSet rsElementos = listarElementosStn.executeQuery("SELECT * from teste");

      while (rsElementos.next()) {
        String name = rsElementos.getString("name");
        resp.getOutputStream().println("[name: " + name + "]");
      }

      rsElementos.close();
      listarElementosStn.close();
      conn.close();
    } catch (Exception e) {
      resp.getOutputStream().print("Ocorreu um erro ao carregar o driver do banco de dados.");
    }
    
  }
}
