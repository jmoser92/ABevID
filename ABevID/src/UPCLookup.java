import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * Retrieves nutritional information from Nutritionix based on scanned UPC label
 * @author John Moser
 * @note CIS111B-ONLN Final project ABevID
 *
 */
public class UPCLookup extends scanner{

	private URLConnection uNutritionix = null;
	private String appID,appKey;
	protected Map<Integer, Object> values = new HashMap<Integer,Object>();
	
	// Default constructor
	public UPCLookup(){
		
	}
	
	
	public UPCLookup(String iUPC, String sKey, String sID) throws IOException, ParseException {
		appID=sKey;
		appKey=sID;
        setMap(iUPC);
		
	}
	
	/**
	 * Sets the Map of nutritional values received from the Nutritionix API
	 * 
	 * @param input UPC barcode value received from a scanning application
	 * @throws IOException Thrown exception from Inputstream
	 * @throws ParseException Thrown exception from parsing the Inputstream
	 */
	private void setMap(String input) throws IOException, ParseException {
		
		try {
		uNutritionix = new URL("https://api.nutritionix.com/v1_1/item?upc="+input+"&fields=item_name,upc,brand_name,item_id,nf_calories&appId="+appID+"&appKey="+appKey).openConnection();
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
	}
	
	/**
	 * Used to nutritional retrieve values stored within a Map
	 * @return Return Map of nutritional values
	 */
	public Map getMap() {
		
		return values;
	}
	
	public String toString() {
		return values.get(1)+" "+values.get(2)+"\nCalories: "+values.get(3)+"\nServing Size: "+values.get(4)+
				values.get(5)+"\nServing Size in grams: "+values.get(6);
	}
	
	
	
}
