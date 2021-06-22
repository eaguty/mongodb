import java.net.UnknownHostException;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;


public class MongoDBApp {

	public static void main(String[] args) throws UnknownHostException {
		

		MongoClient mongoClient = new MongoClient();
		
		MongoDatabase db = mongoClient.getDatabase("mediastream");
		
		
		mongoClient.close();
		
	}

}
 