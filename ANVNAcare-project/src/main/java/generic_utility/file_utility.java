package generic_utility;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class file_utility {
	public String getdatafromjsonfile(String key) throws IOException, ParseException {
		FileReader fr=new FileReader("./src/test/resources/commondata.json");
		JSONParser parser=new JSONParser();
		Object obj=parser.parse(fr);
		JSONObject jobj=(JSONObject) obj;
		String value=jobj.get(key).toString();
		return value;
	}

}
