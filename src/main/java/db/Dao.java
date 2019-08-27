package db;

import com.mongodb.Block;
import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import model.Product;
import org.bson.Document;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import static com.mongodb.client.model.Filters.eq;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

public class Dao {
    static MongoDatabase database;
    static {
        String mongoConnectionLink = "mongodb+srv://FrancSerra:Fserra01@projectoweb-nxojt.gcp.mongodb.net/test?retryWrites=true&w=majority";
        ConnectionString connectionString = new ConnectionString(mongoConnectionLink);
        MongoClient mongoClient = MongoClients.create(connectionString);
        database = mongoClient.getDatabase("products");
    }

    static public void  getCollection() {
        CodecRegistry pojoCodecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(),
                fromProviders(PojoCodecProvider.builder().automatic(true).build()));
        MongoCollection<Product> collection = database.getCollection("products", Product.class).withCodecRegistry(pojoCodecRegistry);
        collection.find().forEach(new Block<Product>() {
            @Override
            public void apply(Product product) {
                System.out.println( product );
            }
        });
        System.out.println( collection.countDocuments() );
    }
    static public void insertDocument(Product product){
        CodecRegistry pojoCodecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(),
                fromProviders(PojoCodecProvider.builder().automatic(true).build()));
        MongoCollection<Product> collection = database.getCollection("products", Product.class).withCodecRegistry(pojoCodecRegistry);
        collection.insertOne(product);
    }

    static public void updateDocument(Product product){
        CodecRegistry pojoCodecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(),
                fromProviders(PojoCodecProvider.builder().automatic(true).build()));
        MongoCollection<Product> collection = database.getCollection("products", Product.class).withCodecRegistry(pojoCodecRegistry);
        collection.replaceOne(eq("prodId", product.getProdId()),product);
    }
}
