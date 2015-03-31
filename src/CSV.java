import java.util.ArrayList;
import java.io.FileWriter; 
import java.io.IOException; 
import java.util.List; 


public class CSV {
	private static final String COMMA_DELIMITER = ",";  
	private static final String NEW_LINE_SEPARATOR = "\n"; 
	
	ArrayList<Card> card = CardCreator.setCards(jsonObject);   
	
	private static final String FILE_HEADER = "name,desc,id,listid"; 
	
	public void createCSVFile(String destinationFileName) {
		
			  	                
		FileWriter fileWriter = null; 
		
		try { 
			fileWriter = new FileWriter(destinationFileName); 
			fileWriter.append(FILE_HEADER.toString()); 
			fileWriter.append(NEW_LINE_SEPARATOR); 
	
		for (Card card: card) { 
			  fileWriter.append(String.valueOf(card.getName()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(card.getDesc());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(card.getId());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(card.getIdlist());
                fileWriter.append(NEW_LINE_SEPARATOR);
			}
			
		}
		
		
		
	}

	}
 
}

