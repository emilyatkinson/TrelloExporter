import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Card {

	public Card(String id, String desc, String idlist, String name) {
		super();
		this.name = name;
		this.idlist = idlist;
		this.id = id;
		this.desc = desc;
	}

	public Card() {
	}

	static String outpath = "thejsonfile.json";
	private String name;
	private String idlist;
	private String id;
	private String desc;

	public void setCard() throws FileNotFoundException, IOException,
			ParseException {
		HashMap<String, Object> deck = new HashMap<String, Object>();
		JSONParser parser = new JSONParser();
		Object obj = parser.parse(new FileReader(outpath));
		JSONObject jsonObject = (JSONObject) obj;
		JSONArray listofcards = (JSONArray) jsonObject.get("cards");
		for (int i = 0; i < listofcards.size(); i++) {
			JSONObject card = (JSONObject) listofcards.get(i);
			name = (String) card.get("name");
			idlist = (String) card.get("idList");
			id = (String) card.get("id");
			desc = (String) card.get("desc");
			new Card(id, desc, idlist,name);
			deck.put(id, card);

			// Playing with eclipse auto-generation while tired. What we're
			// going to use for this iteration should probably just strip out
			// all the extraneous variables.(Delete constructor, delete
			// unnecessary new Card(parameters), let eclipse fix the rest)

			// On the bright side, there is a hashmap "deck" of all our cards;
			// access it using "id" as the key, we can clean out all this crap
			// later

			// Going to stay away from "real" code tomorrow, but I might do more
			// test cases for what we want to do. CSV shouldn't be bad, but I
			// want to test ideas.
		}
	}
}