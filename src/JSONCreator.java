import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JSONCreator {
	static String outpath = "thejsonfile.json";

	@SuppressWarnings("resource")
	public void getJSONAsFile(String userURL) throws IOException {
		String jsonURL = userURL + ".json";
		URL website = new URL(jsonURL);
		ReadableByteChannel rbc = Channels.newChannel(website.openStream());
		FileOutputStream fos = new FileOutputStream(outpath);
		fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
	}

	public JSONObject getJSONObjectFromFile() throws FileNotFoundException, IOException, ParseException {
		JSONParser parser = new JSONParser();
		Object obj = parser.parse(new FileReader(outpath));
		JSONObject jsonObject = (JSONObject) obj;
		return jsonObject;
	}
}
