package org.study.todo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.study.login.LoginService;
import org.study.todo.TodoService;

@WebServlet(urlPatterns = "/add-todo.do")
public class AddTodoServlet extends HttpServlet{

	private TodoService todoService = new TodoService();
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String newTodo = new String(request.getParameter("todo").getBytes("8859_1"), "UTF-8");
		String category = new String(request.getParameter("category").getBytes("8859_1"), "UTF-8");
		todoService.addTodo(new Todo(newTodo, category));
		
		response.sendRedirect("/list-todo.do");
//		request.setAttribute("todos", todoService.retrieveTodos());
//		request.getRequestDispatcher("/WEB-INF/views/todo.jsp").forward(request, response);
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/add-todo.jsp").forward(request, response);
	}
}
