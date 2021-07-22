package com.example.covid.covid.servlet.filtro;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.stereotype.Component;


@Component
public class ConnectionFilter implements Filter{

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
      throws IOException, ServletException {
        try {
          Class.forName("org.postgresql.Driver");
          chain.doFilter(request, response);
        } catch (ClassNotFoundException e) {
          response.getOutputStream().print("Ocorreu um erro ao carregar o driver do banco de dados.");
        }
        
  }
  
}
