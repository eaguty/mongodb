import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
 
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
 
import static java.util.Arrays.asList;
import java.util.logging.Level;
import java.util.logging.Logger;
 
/**
 * Class tests for inserting data into MongoDB with <b> insertOne </ b> and <b> insertMany </ b>.
 * Clase de pruebas para la inserción de datos en MongoDB con <b>insertOne</b> y <b>insertMany</b>
 * @author xules
 */
public class JavaMongodbInsertData {
    private MongoClient mongoClient;    // Java MongoDB client (Cliente Java MongoDB)
    private MongoDatabase mongodb;      // Database object (Objeto base de datos)
    /**
     * We establish the connection with the database <b>test</b>.
     * Establecemos la conexión con la base de datos <b>test</b>.
     */
    public void connectDatabase(){
        setMongoClient(new MongoClient());             
        setMongodb(getMongoClient().getDatabase("mediastream"));
    }
    /**
     * We use the method <b>insertOne</b> to add a document to the database example.
     * Usamos el método <b>insertOne</b> para añadir un documento a la base de datos de ejemplo.
     */
    public void insertOneDataTest(){
        try {            
            DateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.ENGLISH);
            // We add a document to the database directly (Añadimos un documento a la base de datos directamente).
            getMongodb().getCollection("assets").insertOne(
                    new Document("address", asList(
                            new Document()
                                    .append("street", "Avenida Castrelos 25 Bajo")
                                    .append("zipcode", "36210")
                                    .append("building", "180")
                                    .append("coord", asList(-73.9557413, 40.7720266)),
                            new Document()
                                    .append("street", "Urzáiz 77 Bajo")
                                    .append("zipcode", "36004")
                                    .append("building", "40")
                                    .append("coord", asList(-73.9557413, 40.7720266))))
                            .append("borough", "Vigo")
                            .append("cuisine", "Galician")
                            .append("grades", asList(
                                    new Document()
                                            .append("date", format.parse("2015-10-11T00:00:00Z"))
                                            .append("grade", "A")
                                            .append("score", 12),
                                    new Document()
                                            .append("date", format.parse("2015-12-11T00:00:00Z"))
                                            .append("grade", "B")
                                            .append("score", 18)))
                            .append("name", "Xules"));
        } catch (ParseException ex) {
            Logger.getLogger(JavaMongodbInsertData.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
    public MongoClient getMongoClient() {
        return mongoClient;
    }
 
    public void setMongoClient(MongoClient mongoClient) {
        this.mongoClient = mongoClient;
    }
 
    public MongoDatabase getMongodb() {
        return mongodb;
    }
 
    public void setMongodb(MongoDatabase mongodb) {
        this.mongodb = mongodb;
    } 
     
    /**
     * Adding data to the test database MongoDB Java: insertOne and insertMany example.
     * Añadiendo datos a la base test de MongoDB con Java: ejemplos insertOne e insertMany .
     * @param args 
     */
    public static void main(String args[]){
        JavaMongodbInsertData javaMongodbInsertData = new JavaMongodbInsertData();
        javaMongodbInsertData.connectDatabase();
        javaMongodbInsertData.insertOneDataTest();        
    }
}
