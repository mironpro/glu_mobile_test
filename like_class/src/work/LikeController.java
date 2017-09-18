package work;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import com.mongodb.BasicDBObject;

public class LikeController implements LikeService {

    private MongoCollection<Document> _collection;

    public LikeController (MongoCollection<Document> collection) {
        _collection = collection;
    }

    // Класс сильно завязан на работу с базой данных MongoDB я мог бы от этого избавиться если
    // нужно былобы работать с разными базами данных.
    public void like(String playerId) {
        BasicDBObject document = new BasicDBObject();
        // Имя параметра "likeTo = кому оправил " думаю нужно было бы заменить на структуру <кто отправил = кому отправил>
        // но для простоты реализации решил оставить пока так
        Document doc = new Document("likeTo", playerId);
        _collection.insertOne(doc);
    }
    public long getLikes(String playerId) {
        long likeCount = _collection.count (Filters.and(Filters.eq("likeTo",playerId)));
        return likeCount;
    }
}
