package br.com.treinaweb.agenda.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = -5949515652475867398L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("	<head>");
		out.println("		<title>Óla a partir do servlet</title>");
		out.println("	</head>");
		out.println("	<body>");
		out.println("		<p>Óla mundo! Vim do servlet!</p>");
		out.println("	</body>");
		out.println("</html>");
	}

}
