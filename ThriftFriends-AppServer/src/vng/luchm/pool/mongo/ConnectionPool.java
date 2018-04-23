/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vng.luchm.pool.mongo;

import com.mongodb.client.MongoCollection;
import org.bson.Document;

/**
 *
 * @author luchm
 */
public class ConnectionPool {

    private static Configuration config = null;

    public ConnectionPool() {
        config = Configuration.getInstance();
    }

    public static MongoCollection<Document> getConnection() {
        return config.mongoDatabase.getCollection("user");
    }
}
