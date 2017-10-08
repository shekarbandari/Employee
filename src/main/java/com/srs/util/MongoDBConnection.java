package com.srs.util;

import java.net.UnknownHostException;
import java.util.List;
import java.util.Set;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import com.mongodb.MongoException;

public class MongoDBConnection {
	public static void main(String args[]) throws UnknownHostException,MongoException{
		MongoClient mongo=new MongoClient("localhost",27017);
		DB db=mongo.getDB("shekardb");
		DBCollection table=db.getCollection("movie");
		BasicDBObject document=new BasicDBObject();
		document.put("name","shekar bandari");
		document.put("location","banglore");
		table.insert(document);
		
		BasicDBObject search=new BasicDBObject();
		search.put("name","shekar bandari");
		 DBCursor cursor=table.find(search);
		 while(cursor.hasNext()){
			 System.out.println(cursor.next());
		 }
		 
		 BasicDBObject document1=new BasicDBObject();
		 document1.put("location","hyderabad");
		 
		 BasicDBObject document2=new BasicDBObject();
		 document2.put("$set", document1);
		  
		 table.update(document,document2);
		 
		 
		 BasicDBObject document3=new BasicDBObject().append("location","hyderabad");
		 DBCursor cursor1=table.find(document3);
		 while(cursor1.hasNext()){
			 System.out.println(""+cursor1.next());
		 }
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
	}
	
	

}
