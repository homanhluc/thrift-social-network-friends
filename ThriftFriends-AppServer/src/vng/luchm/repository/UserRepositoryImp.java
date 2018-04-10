package vng.luchm.repository;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.stream.JsonReader;
import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.List;
import vng.luchm.thrift.User;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;
import vng.luchm.thrift.FriendLists;
//public class UserRepositoryMongoImp implements IUserRepository {
//
////    private static final MongoClient mongoClient
////            = new MongoClient(SystemInfo.HOST, 2330);
////    private static final MongoDatabase db
////            = mongoClient.getDatabase(SystemInfo.DB);
////    private static final MongoCollection<Document> coll
////            = db.getCollection("user");
////    private static final MongoClientOptions.Builder clientOptions = new MongoClientOptions.Builder();
//// 
//    @Override
//    public boolean userRegister(User userInfo) {
////        try {
////            User user = new User();
////            Hashtable ht = new Hashtable();
////            ht.put(user, userInfo);
////            Gson gson = new Gson();
////            String json = gson.toJson(ht);
////            Document doc = gson.fromJson(json, Document.class);
////            coll.insertOne(doc);
////        } catch (Exception e) {
////            System.err.println(e.getClass().getName() + ": " + e.getMessage());
////            e.printStackTrace();
////        }
//        return true;
//    }

public class UserRepositoryImp implements IUserRepository {

    private static final MongoClient mongoClient
            = new MongoClient("localhost", 27017);
    private static final MongoDatabase db
            = mongoClient.getDatabase("socialnetworkfriends");
    private static final MongoCollection<Document> coll
            = db.getCollection("user");

    @Override
    public boolean registerUser(String un) {
        User user = new User();
        user.setUserName(un);

        Gson gson = new Gson();
        String json = gson.toJson(user);
        Document doc = gson.fromJson(json, Document.class);

        coll.insertOne(doc);
        return true;
    }

    @Override
    public boolean loginUser(String un) {
        Document query = new Document();
        query.put("UserName", un);
        FindIterable<Document> iterable = coll.find(query);
        if (iterable.first() != null) {
            return true;
        }
        return false;
    }

    @Override
    public User getUserById(String id) {
        User u = new User();
        Document query = new Document();
        query.put("_id", new ObjectId(id));
        FindIterable<Document> iterable = coll.find(query);
        List<FriendLists> l = new ArrayList<>();
        if (iterable.first() != null) {
            u.setId(iterable.first().getObjectId("_id").toString());
            u.setUserName(iterable.first().getString("UserName"));
            List<FriendLists> fl = new ArrayList<>();
            List<Document> list = (List<Document>) iterable.first().get("Friends");
            if (list != null) {
                for (Document bo : list) {
                    FriendLists f = new FriendLists();
                    f.setUserId(bo.getString("UserId"));
                    f.setStatus(bo.getInteger("Status"));
                    f.setActionUser(bo.getString("ActionUser"));
                    fl.add(f);
                }
            }
            u.setFriends(fl);
            l.clear();
            return u;
        }

        return null;
    }

    @Override
    public List<User> getAllUsers() {
        List<User> lu = new ArrayList<>();
        FindIterable<Document> iterable = coll.find();
        for (Document document : iterable) {
            User u = new User();
            u.setId(document.getObjectId("_id").toString());
            u.setUserName(document.getString("UserName"));
            List<FriendLists> fl = new ArrayList<>();
            List<Document> list = (List<Document>) document.get("Friends");
            if (list != null) {
                for (Document bo : list) {
                    FriendLists f = new FriendLists();
                    f.setUserId(bo.getString("UserId"));
                    f.setStatus(bo.getInteger("Status"));
                    f.setActionUser(bo.getString("ActionUser"));
                    fl.add(f);
                }
            }
            u.setFriends(fl);
            lu.add(u);
        }

        return lu;
    }

    @Override
    public boolean addFriend(String id_user_one, String id_user_two) {
        try {
            addFriendDetail(id_user_one, id_user_two);
            addFriendDetail(id_user_two, id_user_one);
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
        return true;
    }

    private static void addFriendDetail(String id_user_one, String id_user_two) {
        Bson filter = new Document("_id", new ObjectId(id_user_one));
        // create list friend
        FriendLists fl = new FriendLists(new ObjectId(id_user_two).toString(), 1, new ObjectId(id_user_one).toString());
        String json = new Gson().toJson(fl);
        Document doc = new Gson().fromJson(json, Document.class);

        Bson newValue = new Document("Friends", doc);
        Bson update = new Document("$addToSet", newValue);
        coll.updateOne(filter, update);
    }

    @Override
    public boolean unFriend(String id_user_one, String id_user_two) {
        try {
            unFriendDetail(id_user_one, id_user_two);
            unFriendDetail(id_user_two, id_user_one);
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
        return true;
    }

    private static void unFriendDetail(String id_user_one, String id_user_two) {

        Bson filter = new Document("_id", new ObjectId(id_user_one));
        Bson newValue = new Document("Friends", new Document("UserId", id_user_two));
        Bson update = new Document("$pull", newValue);
        coll.updateOne(filter, update);
    }

    @Override
    public boolean acceptFriend(String id_user_one, String id_user_two) {
        try {
            acceptFriendDetail(id_user_one, id_user_two);
            acceptFriendDetail(id_user_two, id_user_one);
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
        return true;
    }

    private static void acceptFriendDetail(String id_user_one, String id_user_two) {
        BasicDBObject query = new BasicDBObject();
        query.put("_id", new ObjectId(id_user_one));
        query.put("Friends.UserId", id_user_two);

        BasicDBObject data = new BasicDBObject();
        data.put("Friends.$.Status", 2);

        BasicDBObject command = new BasicDBObject();
        command.put("$set", data);

        coll.updateOne(query, command);
    }

    @Override
    public boolean declinFriend(String id_user_one, String id_user_two) {
        try {
            declinFriendDetail(id_user_one, id_user_two);
            declinFriendDetail(id_user_two, id_user_one);
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
        return true;
    }

    private static void declinFriendDetail(String id_user_one, String id_user_two) {
        BasicDBObject query = new BasicDBObject();
        query.put("_id", new ObjectId(id_user_one));
        query.put("Friends.UserId", id_user_two);

        BasicDBObject data = new BasicDBObject();
        data.put("Friends.$.Status", 3);

        BasicDBObject command = new BasicDBObject();
        command.put("$set", data);

        coll.updateOne(query, command);
    }

    @Override
    public void logQuery(String query) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
