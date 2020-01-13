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
@javax.servlet.annotation.WebServlet(name = "SubServletHello",urlPatterns = {"/api/hello/helloworld"})
public class SubServletHello extends AbsSubServlet{
	private static final long serialVersionUID = 1L;
	private static final java.util.logging.Logger log = java.util.logging.Logger.getLogger(SubServletHello.class.getName());
	public void doGet(String path, HttpServletRequest req, HttpServletResponse resp) throws Exception{
		switch(path){
			case "/api/hello/helloworld":{
				controllers_ManagerHello_helloworld(req, resp);
				break;
			}
			default: send404(resp);break;
		}
	}
	static void controllers_ManagerHello_helloworld(HttpServletRequest req, HttpServletResponse resp)throws Exception{
		String $salida = jcrystal.JSONUtils.jsonQuote(controllers.ManagerHello.helloworld());
		resp.getWriter().print("{\"success\":1,\"r\":"+$salida+"}");
	}
}
