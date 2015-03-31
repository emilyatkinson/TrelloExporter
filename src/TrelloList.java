import java.util.HashMap;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


public class TrelloList {
	
	public HashMap<String, String> getListInfo(JSONObject jsonObject) { 
		
		HashMap<String, String> hashList = new HashMap<String, String>();
		
		JSONArray listArray = (JSONArray) jsonObject.get("lists");
		
		for (int i = 0; i < listArray.size(); i++) {
			JSONObject listObject=(JSONObject) listArray.get(i);
			String listId=(String) listObject.get("id");
			String listName = (String) listObject.get("name");
			hashList.put(listId, listName); 
		}
		return hashList;
		
	}
	
}
