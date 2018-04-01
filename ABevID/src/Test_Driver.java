import java.io.IOException;
import java.util.Map;
import org.json.simple.parser.ParseException;

public class Test_Driver {

		public static void main(String[] args) throws IOException, ParseException {
			
			//Enter the test UPC here
			String iUPC="087000002715";
			//Enter your API key here
			String appKey="";
			//Enter you API ID here
			String appID="";
			
			UPCLookup test = new UPCLookup(iUPC,appID,appKey);
		
			//Test output
			System.out.println(test+"\n++++++++++++++++++++++++++\n");
			
			Map testMap= test.getMap();
			System.out.println(testMap.get(1));
		}


}
