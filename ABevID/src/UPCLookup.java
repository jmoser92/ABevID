import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
public class UPCLookup extends scanner{

	private URLConnection uNutritionix = null;
	protected Map<Integer, Object> values = new HashMap<Integer,Object>();
	// Default constructor
	public UPCLookup(){
		
	}
	
	public UPCLookup(String iUPC) throws IOException, ParseException {
		// TODO Auto-generated constructor stub// verify connection works before exectuting
		try {
		uNutritionix = new URL("https://api.nutritionix.com/v1_1/item?upc="+iUPC+"&fields=item_name,upc,brand_name,item_id,nf_calories&appId=247a5a79&appKey=89e7a52a56731cf95b5a0fab0d31b89a").openConnection();
		}	
		
		// catch IOException errors
		catch (IOException	e)	{
		e.printStackTrace();
		}
		
		// Parse input data stream
		InputStream	inputStream = uNutritionix.getInputStream();
		JSONParser jsonParser = new JSONParser();
		JSONObject jsonObject = (JSONObject)jsonParser.parse(new InputStreamReader(inputStream, "UTF-8"));
		 
        // retrieve values from stream
		values.put(1, jsonObject.get("brand_name"));
		values.put(2, jsonObject.get("item_name"));
		values.put(3, jsonObject.get("nf_calories"));
		values.put(4, jsonObject.get("nf_serving_size_qty"));
		values.put(5, jsonObject.get("nf_serving_size_unit"));
		values.put(6, jsonObject.get("nf_serving_weight_grams"));
        
        //temporary println to verify returning data  ---  to be removed
        System.out.println(values.get(1)+" "+values.get(2));
        System.out.println(values.get(3)+" calories");
        System.out.println(values.get(4)+" "+values.get(5));
        System.out.println(values.get(6)+" grams per serving");        
        
	}
	
	public String toString() {
		return "";
	}
	
	
	
}
