package com.srs.util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Random;

import javax.crypto.*;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;

/**
 * Encryption and Decryption of String data; PBE(Password Based Encryption and
 * Decryption)
 * 
 * @author SHEKAR BANDARI
 */
public class CryptoUtil {

	 static Cipher ecipher;
	 static Cipher dcipher;
	// 8-byte Salt
	static byte[] salt = { (byte) 0xA9, (byte) 0x9B, (byte) 0xC8, (byte) 0x32,
			(byte) 0x56, (byte) 0x35, (byte) 0xE3, (byte) 0x03 };
	// Iteration count
	static int iterationCount = 19;
	private static final Random RANDOM = new SecureRandom();

	public CryptoUtil() {
	}

	/**
	 * 
	 * @param secretKey
	 *            Key used to encrypt data
	 * @param plainText
	 *            Text input to be encrypted
	 * @return Returns encrypted text
	 * 
	 */
	public static String encrypt(String secretKey, String plainText)
			throws NoSuchAlgorithmException, InvalidKeySpecException,
			NoSuchPaddingException, InvalidKeyException,
			InvalidAlgorithmParameterException, UnsupportedEncodingException,
			IllegalBlockSizeException, BadPaddingException {
		// Key generation for enc and desc
		KeySpec keySpec = new PBEKeySpec(secretKey.toCharArray(), salt,
				iterationCount);
		SecretKey key = SecretKeyFactory.getInstance("PBEWithMD5AndDES")
				.generateSecret(keySpec);
		// Prepare the parameter to the ciphers
		AlgorithmParameterSpec paramSpec = new PBEParameterSpec(salt,
				iterationCount);

		// Enc process
		ecipher = Cipher.getInstance(key.getAlgorithm());
		ecipher.init(Cipher.ENCRYPT_MODE, key, paramSpec);
		String charSet = "UTF-8";
		byte[] in = plainText.getBytes(charSet);
		byte[] out = ecipher.doFinal(in);
		String encStr = new sun.misc.BASE64Encoder().encode(out);
		return encStr;
	}

	/**
	 * @param secretKey
	 *            Key used to decrypt data
	 * @param encryptedText
	 *            encrypted text input to decrypt
	 * @return Returns plain text after decryption
	 */
	public  static String decrypt(String secretKey, String encryptedText)
			throws NoSuchAlgorithmException, InvalidKeySpecException,
			NoSuchPaddingException, InvalidKeyException,
			InvalidAlgorithmParameterException, UnsupportedEncodingException,
			IllegalBlockSizeException, BadPaddingException, IOException {
		// Key generation for enc and desc
		KeySpec keySpec = new PBEKeySpec(secretKey.toCharArray(), salt,
				iterationCount);
		SecretKey key = SecretKeyFactory.getInstance("PBEWithMD5AndDES")
				.generateSecret(keySpec);
		// Prepare the parameter to the ciphers
		AlgorithmParameterSpec paramSpec = new PBEParameterSpec(salt,
				iterationCount);
		// Decryption process; same key will be used for decr
		dcipher = Cipher.getInstance(key.getAlgorithm());
		dcipher.init(Cipher.DECRYPT_MODE, key, paramSpec);
		byte[] enc = new sun.misc.BASE64Decoder().decodeBuffer(encryptedText);
		byte[] utf8 = dcipher.doFinal(enc);
		String charSet = "UTF-8";
		String plainStr = new String(utf8, charSet);
		return plainStr;
	}

	public static String generateRandomPassword(int length) {
		StringBuilder sb = new StringBuilder(length);
		for (int i = 0; i < length; i++) {
			int c = RANDOM.nextInt(62);
			if (c <= 9) {
				sb.append(String.valueOf(c));
			} else if (c < 36) {
				sb.append((char) ('a' + c - 10));
			} else {
				sb.append((char) ('A' + c - 36));
			}
		}

		return sb.toString();
	}

	public static void main(String[] args) throws Exception {
		CryptoUtil cryptoUtil = new CryptoUtil();
		
		/**************** DECRYPT THE PASSWORD *********************************************************************/
		/*String SALT = "your salt key";// SALT column
		String GUID = "your guid key";// GUID mean encrypt column
		String ENCRYPT = "your encrypt ky";// ENCRYPT mean userPasword column
											// value
*/
			String SALT="zeJGu7EZPHZL790NGIX5vuZwF0SB62i4Z42UBvIC";
		String GUID="EDPog81DOXOWGPvJFmf7pNDm2rWLtOKWQ6MkFLRO";
		String ENCRYPT="+kO05vwcQw0=";

		String saltGuid = SALT + GUID;
		String plainAfte1r = cryptoUtil.decrypt(saltGuid, ENCRYPT);
		System.out.println("Original text after decryption: " + plainAfte1r);
		
		
		/*********************************ENCRYPT THE PASSWORD****************************************************************/
		
		 /*String SALT = CryptoUtil.generateRandomPassword(40);
	        String GUID = CryptoUtil.generateRandomPassword(40);
	        String PASSWORD = cryptoUtil.encrypt(SALT + GUID, "shekar");
	        System.out.println("salt:::::::"+SALT);
	        System.out.println("guid::::::::"+GUID);
	        System.out.println("ENCRYPTION:::::"+PASSWORD);
*/
	
	
	}

}