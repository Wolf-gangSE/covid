package com.example.covid.covid.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.covid.covid.CovidData;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@WebServlet(
		name = "CovidServlet",
		urlPatterns = {"/covid"}
		)

public class CovidServlet extends HttpServlet {
  
  @Autowired
  private RestTemplate restTemplate;

  @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String id = req.getParameter("uf");
    String url = "https://covid19-brazil-api.vercel.app/api/report/v1/brazil/uf/" + id;
    ResponseEntity<CovidData> data = restTemplate.getForEntity(url, CovidData.class);
    resp.addHeader("content-type", "text/html;charset=UTF-8");
    resp.getWriter().write("<h1>" + data.getBody().getState() + " </h1>");
    resp.getWriter().write("<p>Número de casos: " + data.getBody().getCases() +" </p>");
    resp.getWriter().write("<p>Número de mortes: " + data.getBody().getDeaths() +" </p>");
    resp.getWriter().write("<p>Número de suspeitos: " + data.getBody().getSuspects() +" </p>");
    resp.getWriter().write("<p>Número de descartados: " + data.getBody().getRefuses() +" </p>");
    resp.getWriter().write("<p>Última atualização dos dados: " + data.getBody().getDatetime() +" </p>");
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    doGet(req, resp);
  }

}
