package com.srs.util;

import java.net.InetAddress;
import java.sql.Date;

import org.apache.log4j.Logger;

public class CommonUtil {
	
	private static final Logger logger=Logger.getLogger(CommonUtil.class);
	
	static Date sqlDate = null;
	
	
	
	
	public static String getIpAddress(){
		String hostAddress = null;
		String localAddress = null;
	 try{
		  InetAddress ownIP=InetAddress.getLocalHost();
		  localAddress = ownIP.toString(); // to be commented
		  hostAddress = ownIP.getHostName();
		  logger.debug("IP of my system is := " + hostAddress);
		 
		  
		 
		  }catch (Exception e){
		  logger.error("Exception caught ="+e.getMessage());
		  }
	 //return hostAddress; // to be uncommented
	 return localAddress; // to be commented
	}
	
	
	public static Date getCurrentDate(){
		 return sqlDate = new Date(new java.util.Date().getTime());
		 
	}


}
