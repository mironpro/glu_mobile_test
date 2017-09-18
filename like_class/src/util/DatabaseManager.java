//Впомогательный класс, его основная задача предоставить место куда писать лайки

package util;

    import com.mongodb.MongoClient;
    import com.mongodb.client.MongoCollection;
    import com.mongodb.client.MongoDatabase;
    import com.mongodb.MongoCredential;
    import com.mongodb.ServerAddress;
    import org.bson.Document;
    import java.util.Arrays;

public class DatabaseManager {
    private static String username  = "myTester";
    private static String password  = "xyz123";
    private static String database  = "test";
    private static String colname   = "likes_table";
    private static MongoDatabase db;

    //  Возвращает коллекцию для записи пользовательских лайков
    public static  MongoCollection<Document> getLikesCollection() {
        MongoCredential credential = MongoCredential.createCredential(username, database, password.toCharArray());
        MongoClient mongoClient = new MongoClient(new ServerAddress("localhost", 27017), Arrays.asList(credential));

        MongoDatabase db = mongoClient.getDatabase(database);
        MongoCollection<Document> collection = db.getCollection(colname);

        return collection;
    }

}
