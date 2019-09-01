package db;

import com.mongodb.Block;
import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import model.Product;
import model.Sale;
import org.bson.Document;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import java.util.ArrayList;
import java.util.List;

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

     public static List<?> getCollection(String type) {
        CodecRegistry pojoCodecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(),
                fromProviders(PojoCodecProvider.builder().automatic(true).build()));

        if(type == "products"){
            MongoCollection<Product> collection = database.getCollection("products", Product.class).withCodecRegistry(pojoCodecRegistry);
//            collection.find().forEach(new Block<Product>() {
//                @Override
//                public void apply(Product product) {
//                    output.addAll()
//                }
//            });
            List<Product> output = collection.find().into(new ArrayList<Product>());

            return output;
        }else if(type == "sales"){
            MongoCollection<Sale> collection = database.getCollection("sales", Sale.class).withCodecRegistry(pojoCodecRegistry);
            List<Sale> output = collection.find().into(new ArrayList<Sale>());
            return output;

        }else {
            return null;
        }
    }
    
    
    public void insertDocument(Object input){
        CodecRegistry pojoCodecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(),
                fromProviders(PojoCodecProvider.builder().automatic(true).build()));
        MongoCollection<Product> collection = database.getCollection("products", Product.class).withCodecRegistry(pojoCodecRegistry);
        collection.insertOne((Product) input);
    }

    public void updateDocument(Product product){
        CodecRegistry pojoCodecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(),
                fromProviders(PojoCodecProvider.builder().automatic(true).build()));
        MongoCollection<Product> collection = database.getCollection("products", Product.class).withCodecRegistry(pojoCodecRegistry);
        collection.replaceOne(eq("prodId", product.getProdId()),product);
    }
}
