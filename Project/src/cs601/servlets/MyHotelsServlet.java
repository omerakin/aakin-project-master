package cs601.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;

@SuppressWarnings("serial")
public class MyHotelsServlet extends BaseServlet{

	// DatabaseHandler interacts with the MySQL database
	private static final DatabaseHandler dbhandler = DatabaseHandler.getInstance();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/*
		checkUserSession(req, resp);
		prepareResponse("My Hotels", resp);
		displayLogOut(resp);		
		dbhandler.listMySavedHotelsInfo(req, resp);
		endingResponse(resp);
		*/
		
		checkUserSession(req, resp);
		prepareResponseHtml(resp);
		VelocityContext context = getContext("My Hotels");
		Template template = getTemplate(req, "MySavedHotelsInfo.html");
		dbhandler.listMySavedHotelsInfoTemplateEngine(req, context);
		mergeAndPrintResponse(resp, template, context);		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/*
		checkUserSession(req, resp);
		prepareResponse("Reviews", resp);
		displayLogOut(resp);
		String clicked_button = req.getParameter("button").trim();
		if (clicked_button.equals("Save")) {			
			dbhandler.insertHotel(req, resp);
			dbhandler.listMySavedHotelsInfo(req, resp);
		} else if (clicked_button.equals("Unsave")) {			
			dbhandler.deleteHotel(req, resp);
			dbhandler.listMySavedHotelsInfo(req, resp);
		} else if (clicked_button.equals("Delete")) {			
			dbhandler.deleteHotel(req, resp);
			dbhandler.listMySavedHotelsInfo(req, resp);
		}
		endingResponse(resp);
		*/
		
		checkUserSession(req, resp);
		prepareResponseHtml(resp);
		VelocityContext context = getContext("My Hotels");
		Template template = getTemplate(req, "MySavedHotelsInfo.html");
		String clicked_button = req.getParameter("button").trim();
		if (clicked_button.equals("Save")) {			
			dbhandler.insertHotel(req, resp);
			dbhandler.listMySavedHotelsInfoTemplateEngine(req, context);
		} else if (clicked_button.equals("Unsave")) {			
			dbhandler.deleteHotel(req, resp);
			dbhandler.listMySavedHotelsInfoTemplateEngine(req, context);
		} else if (clicked_button.equals("Delete")) {			
			dbhandler.deleteHotel(req, resp);
			dbhandler.listMySavedHotelsInfoTemplateEngine(req, context);
		}
		mergeAndPrintResponse(resp, template, context);	
	}		

}
