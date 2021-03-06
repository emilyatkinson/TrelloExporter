import java.util.ArrayList;
import java.io.File;
import java.io.FileWriter; 
import java.io.IOException; 
import java.util.List; 


public class CSV {
	private static final String COMMA_DELIMITER = ",";  
	private static final String NEW_LINE_SEPARATOR = "\n";  
	private static final String FILE_HEADER = "nam,desc,id,listid"; 
	
	
	public void createCSVFile(String destinationFileName, ArrayList<Card> card) {
	
			  	                
		FileWriter fileWriter = null; 
		File file = new File("/Users/Atkinson/Documents/trallo.csv");
		try { 
			fileWriter = new FileWriter(file); 
			fileWriter.append(FILE_HEADER.toString()); 
			fileWriter.append(NEW_LINE_SEPARATOR); 
	
		for (Card card1: card) { 
			  fileWriter.append(addDoubleQuotesAround(card1.getName()));
                fileWriter.append(COMMA_DELIMITER); 
                fileWriter.append(addDoubleQuotesAround(card1.getDesc())); 
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(addDoubleQuotesAround(card1.getId()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(addDoubleQuotesAround(card1.getIdlist()));
                fileWriter.append(NEW_LINE_SEPARATOR);
		}
		 } catch (Exception e) {
			             System.out.println("Error in CsvFileWriter !!!");
			 	            e.printStackTrace();
			 	        } finally {
			 	             
			 	            try {
			 	                fileWriter.flush();
			 	                fileWriter.close();
			 	            } catch (IOException e) {
			 	                System.out.println("Error while flushing/closing fileWriter !!!");
			 	                e.printStackTrace();
			 	            }
			 	             
			 	        }
			 	    }
	
	public static String addDoubleQuotesAround(String str) {
	    return "\"" + str + "\"";
	}
 
}

