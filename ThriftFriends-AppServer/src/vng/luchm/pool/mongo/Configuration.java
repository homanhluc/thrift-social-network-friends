/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vng.luchm.pool.mongo;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoDatabase;

/**
 *
 * @author luchm
 */
public class Configuration {

    private MongoClient mongoClient = null;
    public  MongoDatabase mongoDatabase = null;
    private String DATABASE = "socialnetworkfriends";

    private void init() {
        MongoClientOptions.Builder clientOptions = new MongoClientOptions.Builder();
        clientOptions.minConnectionsPerHost(10);//min
        clientOptions.connectionsPerHost(100);//max
        mongoClient = new MongoClient(new ServerAddress("localhost", 27017), clientOptions.build());
        mongoDatabase = mongoClient.getDatabase(DATABASE);
    }
    private static Configuration configuration = new Configuration();

    public static Configuration getInstance() {
        return configuration;
    }

    public Configuration() {
        init();
    }
}
