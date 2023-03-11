package edu.eci.cvds.servlet;
	import java.io.IOException;
	import java.io.Writer;
	import java.util.Optional;
	import javax.servlet.ServletException;
	import javax.servlet.annotation.WebServlet;
	import javax.servlet.http.HttpServlet;
	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;
	
	@WebServlet(
		urlPatterns = "/accessToServlet"
	)
	
	public class LabServlet extends HttpServlet{
		static final long serialVersionUID = 35L;
		
		
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			Writer responseWriter = resp.getWriter();
			Optional<String> optId = Optional.ofNullable(req.getParameter("id"));
			try{
				int id = optId.isPresent() && !optId.get().isEmpty() ? Integer.parseInt(optId.get()) : 0;
				Todo todo = Service.getTodo(id);
				resp.setStatus(HttpServletResponse.SC_OK);
				responseWriter.write(todosToHTMLTable(todo));
			}catch (MalformedURLException e){
				resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			}finally{
				resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			}
		}
}