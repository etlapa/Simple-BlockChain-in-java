package cobwebs;

import java.security.MessageDigest;

import javax.xml.bind.DatatypeConverter;

public class Algorithm {
	public static String getHash(byte[] inputBytes) {
		String hashValue="";
		try {
			MessageDigest messageDigest =  MessageDigest.getInstance("SHA-256");
			messageDigest.update(inputBytes);
			byte[] digestBytes = messageDigest.digest();
			hashValue=DatatypeConverter.printHexBinary(digestBytes).toLowerCase();
		}
		catch(Exception e) {
			
		}
			
		return hashValue;
		
	}

}
