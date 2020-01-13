package com.jcrystal.servlets.servlets;
import jcrystal.utils.InternalException;
import jcrystal.utils.ValidationException;
import javax.servlet.http.*;
import java.io.IOException;
import static jcrystal.utils.ServletUtils.*;
@javax.servlet.annotation.WebServlet(name = "ServletPush",urlPatterns = {"jcrystal/async"})
public class ServletJCrystal extends HttpServlet{
	private static final long serialVersionUID = 7192602632684861723L;
	private static final java.util.logging.Logger log = java.util.logging.Logger.getLogger(ServletJCrystal.class.getName());
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		final String path = req.getPathInfo();
		resp.setContentType("application/json");
		resp.setCharacterEncoding("UTF-8");
		try{
			switch(path){
				case "jcrystal/async" : {
					jcrystal.queue.Async.dequeue(req);
					resp.getWriter().print("{\"success\":1}");
				}
				default: send404(resp);break;
			}
		}
		catch(NumberFormatException ex){resp.getWriter().print("{\"success\":2, \"mensaje\":\"Invalid request\"}");}
		catch(org.json.JSONException ex){resp.getWriter().print("{\"success\":2,\"code\": 500, \"mensaje\":\"Invalid JSON object\"}");}
		catch(ValidationException ex){resp.getWriter().print("{\"success\":2, \"mensaje\":\"" + ex.getMessage() + "\"}");}
		catch(InternalException ex){resp.getWriter().print("{\"success\":2,\"code\":" + ex.code + ", \"mensaje\":\"" + ex.getMessage() + "\"}");}
		catch(Throwable ex){
			resp.setStatus(500);
			log.log(java.util.logging.Level.SEVERE,"error", ex);
		}
	}
}
