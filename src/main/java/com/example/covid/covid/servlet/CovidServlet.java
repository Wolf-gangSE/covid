package com.example.covid.covid.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

@WebServlet(
		name = "CovidServlet",
		urlPatterns = {"/covid"}
		)

public class CovidServlet extends HttpServlet {
  
  @Autowired
  RestTemplate restTemplate;

  @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    
  }
  
}
