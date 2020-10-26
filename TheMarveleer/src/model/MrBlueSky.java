package model;

import java.awt.Image;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import javax.imageio.ImageIO;

import dare.DARE;

public class MrBlueSky extends Runner{
	private int mode;
	private String a,b;

	public MrBlueSky(FromThread fromThread){
		super(fromThread,false);
	}
	
	public void request(String what,String search){
		a=what;
		b=search;

		mode=0;
		launch();
	}
	
	public void requestImage(String path,String extension){
		a=path;
		b=extension;

		mode=2;
		launch();
	}

	@Override
	public void run(){
		URL url=null;
		
		switch(mode){
			case 0:
				String what=a,search=b;
				int code=403;
				String r="";
				HttpURLConnection connection;
				
				try{
					url=new URL(DARE.generate(what,search));
					connection=(HttpURLConnection)url.openConnection();
					connection.setRequestMethod("GET");
					connection.connect();
					code=connection.getResponseCode();
				}catch(IOException ex){
					r="!unable to connect to the server";
					fromThread.threadReceived(1,new String[]{r},null,null,null);
					System.out.println("MrBlueSky: error contacting server");
					return;
				}
				if(code!=200){
					r+="!http error code "+code;
					fromThread.threadReceived(1,new String[]{r},null,null,null);
					System.out.println("MrBlueSky: error code "+code);
					return;
				}
				Scanner sc=null;
				try{
					sc=new Scanner(url.openStream());
					while(sc.hasNext()){
						r+=sc.nextLine();
					}
					sc.close();
				}catch(IOException ex){
					r="!an error occurred while downloading data";
					fromThread.threadReceived(1,new String[]{r},null,null,null);
					System.out.println("MrBlueSky: error downloading stream");
					return;
				}
				fromThread.threadReceived(1,new String[]{r},null,null,null);
				break;
			case 2:
				String path=a,extension=b;
				Image image=null;
				
				path+="/portrait_incredible."+extension;

				System.out.println("ImageRequest generator{\r\turl=\""+path+"\"");
				
				try{
					url=new URL(path);
					image=ImageIO.read(url);
					System.out.println("\tdone");
				}catch(IOException ex){
					System.out.println("\terror downloading image");
				}
				System.out.println("}");
				fromThread.threadReceived(2,null,null,null,image);
				break;
		}
		
	}
}
