package dare;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class DARE{

	private DARE(){
	}

	public static final String generate(String what,String search){
		final String publicKey="6a61738ee8c67219f8dcad3138dff4c3";
		final String privateKey="SECRET";
		
		StringBuffer sb=new StringBuffer();
		byte digest[]=null;
		String ts=""+System.currentTimeMillis();

		System.out.print("URLRequest from DARE{\r\tmd5=\"");

		try{
			digest=MessageDigest.getInstance("MD5").digest((ts+privateKey+publicKey).getBytes());
		}catch(NoSuchAlgorithmException ex){
			System.out.println("DARE: error selecting algorithm");
		}
		for(byte t:digest){
			sb.append(String.format("%02x",t&0xff));
		}
		
		String s="http://gateway.marvel.com/v1/public/"+what+"?nameStartsWith="+search+"&limit=1&ts="+ts+"&apikey="+publicKey+"&hash="+sb.toString();
		System.out.println(sb.toString()+"\"\r\tURL=\""+s+"\"\r}");

		return s;
	}
	
	
}
