import java.io.File;
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

		String filePath = "/Users/Atkinson/Documents/trallo.csv"; 
        File downloadFile = new File(filePath);
        FileInputStream inStream = new FileInputStream(downloadFile);
	
        ServletContext context = getServletContext();
        response.setContentType("text/csv");
        
        response.setContentLength((int) downloadFile.length());
        String headerKey = "Content-Disposition";
        String headerValue = String.format("attachment; filename=\"%s\"", downloadFile.getName());
        response.setHeader(headerKey, headerValue); 
        OutputStream outStream = response.getOutputStream(); 
        byte[] buffer = new byte[4096];
        int bytesRead = -1;
         
        while ((bytesRead = inStream.read(buffer)) != -1) {
            outStream.write(buffer, 0, bytesRead);
        }
         
        inStream.close();
        outStream.close(); 


//		String path = getServletContext().getRealPath("trallo.csv");
//		"/Users/Atkinson/Documents/trallo.csv"
//		response.setContentType("text/csv");
//		response.setHeader("Content-Disposition",
//				"attachment; filename=trallo.csv");
//	
//		FileInputStream in = new FileInputStream(path); 
//		PrintWriter out = response.getWriter(); 
//		
//		int i = in.read(); 
//		while( i != -1) { 
//			out.write(i);
//			i = in.read(); 
//			System.out.println(i);
//		}
//		in.close(); 
//		out.close(); 
		

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
