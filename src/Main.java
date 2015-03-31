import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;


public class Main {
	
	public static void main(String[] args) throws IOException, ParseException {
		JSONCreator jsc = new JSONCreator(); 
		TrelloList tl = new TrelloList(); 
		CardCreator cc = new CardCreator(); 
		Card card = new Card(); 
		CSV csv = new CSV(); 
		String userURL = "https://trello.com/b/qrdIFuVw/brainstorming"; 
		
		jsc.getJSONAsFile(userURL); 
		JSONObject jsonObject = jsc.getJSONObjectFromFile(); 
		
		HashMap<String, String> hashlist = tl.getListInfo(jsonObject); 
		
		ArrayList<Card> cards = cc.setCards(jsonObject);
		for(Card card1: cards) {
		System.out.println(card1.getName());
		System.out.println(card1.getDesc());
		System.out.println(card1.getId()); 
		System.out.println(card1.getIdlist());
		
		}
		 csv.createCSVFile("trello.csv", cards);
		
		
	}
	//JSONCreator 
		//getJSONAsFile(String userURL)
		//getJSONObjectFromFile()
	//TrelloList 
		//getListInfo(JSONObject )
			//return haslist of listinfo
	//CardCreator 
		//setCards(JSONObject   )
			//returns arraylist of card objects
	//
	
	

}