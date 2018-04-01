import java.io.IOException;

import org.json.simple.parser.ParseException;

public class Android_Input {

	public static void main(String[] args) throws IOException, ParseException {
		// TODO Auto-generated method stub
		String iUPC="087000002715";
		UPCLookup json;
		
		UPCLookup test = new UPCLookup(iUPC);
		System.out.println(test);
	}

}
