import java.io.IOException;
import java.util.Map;

import org.json.simple.parser.ParseException;

public class Android_Input {

	public static void main(String[] args) throws IOException, ParseException {
		// TODO Auto-generated method stub
		String iUPC="087000002715";
		String appKey="89e7a52a56731cf95b5a0fab0d31b89a";
		String appID="247a5a79";
		UPCLookup test = new UPCLookup(iUPC,appID,appKey);
	
		System.out.println(test+"\n++++++++++++++++++++++++++\n");
		
		Map testMap= test.getMap();
		System.out.println(testMap.get(1));
	}

}
