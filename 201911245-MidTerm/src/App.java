import java.io.*;
import java.util.Scanner;

import org.json.simple.*;
import org.json.simple.parser.*;

public class App {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		JSONParser jsonParser = new JSONParser();
		try {
			Object obj = jsonParser.parse(new FileReader("midterm.json"));
			
			JSONObject jsonObject = (JSONObject) obj;
			System.out.print("Enter the keyword you are looking for:");
			String keyword = sc.next();
			
			JSONArray array = (JSONArray) jsonObject.get("poem");
			
			for(int i=0;i<array.size();i++) {
				JSONObject result = (JSONObject) array.get(i);
				if(result.containsValue(keyword)) {
					System.out.println(result);
				}
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

}
