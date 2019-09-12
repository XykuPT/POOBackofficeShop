package db;

import com.mongodb.Block;
import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import model.Order;
import model.Product;
import model.Sale;
import org.bson.Document;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.ClassModel;
import org.bson.codecs.pojo.PojoCodecProvider;

import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

/**
 * Database connection and CRUD methods
 */
public class Dao {
    static MongoDatabase database;

    /**
     * Database connection
     */
    static {

        String mongoConnectionLink = "mongodb+srv://FrancSerra:Fserra01@projectoweb-nxojt.gcp.mongodb.net/test?retryWrites=true&w=majority";
        ConnectionString connectionString = new ConnectionString(mongoConnectionLink);
        MongoClient mongoClient = MongoClients.create(connectionString);

        ClassModel<Product> productModel = ClassModel.builder(Product.class).enableDiscriminator(true).build();
        ClassModel<Sale> saleModel = ClassModel.builder(Sale.class).enableDiscriminator(true).build();

        CodecRegistry pojoCodecRegistry = org.bson.codecs.configuration.CodecRegistries.fromRegistries(MongoClientSettings.getDefaultCodecRegistry(), org.bson.codecs.configuration.CodecRegistries.fromProviders(PojoCodecProvider.builder().register(productModel,saleModel).automatic(true).build()));
        database = mongoClient.getDatabase("products").withCodecRegistry(pojoCodecRegistry);//

    }

    /**
     * Get the product or sales entire list
     * @param type string to filter if it is going to get Products or Sales from data base
     * @return list of Products or Sales
     */
     public static List<?> getCollection(String type) {
//        CodecRegistry pojoCodecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(),
//                fromProviders(PojoCodecProvider.builder().automatic(true).build()));

        if(type == "products"){
            MongoCollection<Product> collection = database.getCollection("products", Product.class);//.withCodecRegistry(pojoCodecRegistry)
//            collection.find().forEach(new Block<Product>() {
//                @Override
//                public void apply(Product product) {
//                    output.addAll()
//                }
//            });
            List<Product> output = collection.find().into(new ArrayList<Product>());

            return output;
        }else if(type == "sales"){
            MongoCollection<Sale> collection = database.getCollection("sales", Sale.class);//.withCodecRegistry(pojoCodecRegistry)
            List<Sale> output = collection.find().into(new ArrayList<Sale>());
            return output;

        }else {
            return null;
        }
    }

    /**
     * Loads a single product or sale from database based on ID
     * @param id Product or Sale ID
     * @param type string to filter if it is going to get Products or Sales from data base
     * @return A single Product or Sale
     */
    public static Object getDocument(int id, String type) {


        if(type == "products"){
            CodecRegistry pojoCodecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(),
                    fromProviders(PojoCodecProvider.builder().automatic(true).build()));
            MongoCollection<Product> collection = database.getCollection("products", Product.class).withCodecRegistry(pojoCodecRegistry);
            Product output = collection.find(eq("prodId", id)).first();

            return output;
        }else if(type == "sales"){
            ClassModel<Sale> saleModel = ClassModel.builder(Sale.class).enableDiscriminator(true).build();
            CodecRegistry pojoCodecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(),
                    fromProviders(PojoCodecProvider.builder().register(saleModel).automatic(true).build()));
            MongoCollection<Sale> collection = database.getCollection("sales", Sale.class).withCodecRegistry(pojoCodecRegistry);
            Sale output = collection.find(eq("saleId", id)).first();
            return output;

        }else {
            return null;
        }
    }


    /**
     * Inserts a Product or a sale into data base
     * @param input Product or a Sale
     * @param type string to filter if it is going to get Products or Sales from data base
     *
     */
    public static void insertDocument(Object input, String type){


        if(type == "products") {
//            CodecRegistry pojoCodecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(),
//                    fromProviders(PojoCodecProvider.builder().automatic(true).build()));
            MongoCollection<Product> collection = database.getCollection("products", Product.class);//.withCodecRegistry(pojoCodecRegistry)
            collection.insertOne((Product) input);
        }else if(type == "sales"){


            MongoCollection<Sale> collection = database.getCollection("sales", Sale.class);
            collection.insertOne((Sale) input);
        }
    }

    /**
     * Inserts a new Sale into data base
     * @param sale new sale
     *
     */
    public static void insertSale(Sale sale) {
//        ClassModel<Sale> saleModel = ClassModel.builder(Sale.class).enableDiscriminator(true).build();
//        CodecRegistry pojoCodecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(),
//                fromProviders(PojoCodecProvider.builder().register(saleModel).automatic(true).build()));.withCodecRegistry(pojoCodecRegistry)
        MongoCollection<Sale> collection = database.getCollection("sales", Sale.class);
        collection.insertOne(sale);

    }

    /**
     * Inserts a new Order into data base
     * @param sale new order
     */
    public static void insertSale(Order sale) {

        MongoCollection<Order> collection = database.getCollection("order", Order.class);
        collection.insertOne(sale);

    }
//    public static void updateDocument(Object input, String type) {
//        if (type == "products") {
//            CodecRegistry pojoCodecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(),
//                    fromProviders(PojoCodecProvider.builder().automatic(true).build()));
//            MongoCollection<Product> collection = database.getCollection(type, Product.class).withCodecRegistry(pojoCodecRegistry);
//            collection.replaceOne(eq("prodId", input.getProdId()), input);
//        } else if (type == "sales") {
//            CodecRegistry pojoCodecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(),
//                    fromProviders(PojoCodecProvider.builder().automatic(true).build()));
//            MongoCollection<Sale> collection = database.getCollection(type, Sale.class).withCodecRegistry(pojoCodecRegistry);
//            collection.replaceOne(eq("saleId", input.getSaleId()), input);
//        }
//    }

    /**
     * Método de Atualização de um produto e substitui esse produto pelo novo na base de dados
     * @param product
     */
    public static void updateProduct(Product product) {
        CodecRegistry pojoCodecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(),
                fromProviders(PojoCodecProvider.builder().automatic(true).build()));
        MongoCollection<Product> collection = database.getCollection("products", Product.class).withCodecRegistry(pojoCodecRegistry);
        collection.replaceOne(eq("prodId", product.getProdId()), product);
    }

    /**
     * Método de Atualização de um venda e substitui esse produto pelo novo na base de dados
     * @param sale
     */
    public static void updateSale(Sale sale) {
        CodecRegistry pojoCodecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(),
                fromProviders(PojoCodecProvider.builder().automatic(true).build()));
        MongoCollection<Sale> collection = database.getCollection("sales", Sale.class).withCodecRegistry(pojoCodecRegistry);
        //collection.replaceOne(eq("saleId", Sale.getSaleId()), sale);
    }
}
