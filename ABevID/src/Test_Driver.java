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
			
			//Local_Test_Lookup test = new Local_Test_Lookup(iUPC,appID,appKey);
			UPCLookup test = new UPCLookup(iUPC,appID,appKey);
			Map testMap= test.getMap();
			
			String output=testMap.get("brand_name")+" "+testMap.get("item_name")+
					"\nCalories: "+testMap.get("nf_calories")+
					"\nServing Size: "+testMap.get("nf_serving_size_qty")+" " +testMap.get("nf_serving_size_unit");
			System.out.println(output);
		}


}
