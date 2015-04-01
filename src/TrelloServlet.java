import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.nio.charset.Charset;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.parser.ParseException;

@SuppressWarnings("serial")
@WebServlet("/trelloURL")
public class TrelloServlet extends HttpServlet { 
	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String inUrl = request.getParameter("userUrl"); 
		try {
			Main.writeCSVFileFromURL(inUrl);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	
	


		String path = getServletContext().getRealPath("/WebContent/trello.csv");
	
		response.setContentType("text/csv");
		response.setHeader("Content-Disposition",
				"attachment; filename=trello.csv");
	
		FileInputStream in = new FileInputStream(path); 
		PrintWriter out = response.getWriter(); 
		
		int i = in.read(); 
		while( i != -1) { 
			out.write(i);
			i = in.read(); 
			System.out.println(i);
		}
		in.close(); 
		out.close(); 

	}

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@SuppressWarnings("unused")
	private void errorOuput(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String message = (String) request.getAttribute("message");
		if (message == null) {
			message = "Please fill in the URL.";
		}
		request.setAttribute("message", message);
		getServletContext().getRequestDispatcher("/index.jsp").forward(request,
				response);
	}
}
