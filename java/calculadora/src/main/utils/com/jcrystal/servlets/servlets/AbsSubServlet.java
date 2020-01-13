package com.jcrystal.servlets.servlets;
import org.json.JSONObject;
import org.json.JSONTokener;
import jcrystal.utils.InternalException;
import jcrystal.utils.ValidationException;
import jcrystal.datetime.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import static jcrystal.utils.ServletUtils.*;
@SuppressWarnings("unused")
public class AbsSubServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private static final java.util.logging.Logger log = java.util.logging.Logger.getLogger(AbsSubServlet.class.getName());
	public final void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		final String path = req.getServletPath();
		resp.setCharacterEncoding("UTF-8");
		try{
			resp.setContentType("application/json");
			doGet(path, req, resp);
		}
		catch(jcrystal.http.responses.HttpResponseException ex){
			resp.setContentType("text/plain");
			resp.setStatus(ex.getCode());
			if(ex.getContent() != null){
				resp.getWriter().print(ex.getContent());
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
	public final void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		final String path = req.getServletPath();
		resp.setCharacterEncoding("UTF-8");
		try{
			resp.setContentType("application/json");
			doPost(path, req, resp);
		}
		catch(jcrystal.http.responses.HttpResponseException ex){
			resp.setContentType("text/plain");
			resp.setStatus(ex.getCode());
			if(ex.getContent() != null){
				resp.getWriter().print(ex.getContent());
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
	public void doGet(String path, HttpServletRequest req, HttpServletResponse resp)throws Exception{
	}
	public void doPost(String path, HttpServletRequest req, HttpServletResponse resp)throws Exception{
	}
}
