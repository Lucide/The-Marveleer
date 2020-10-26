package model;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class GPA extends Runner{
	int mode;

	public GPA(FromThread fromThread,int mode){
		super(fromThread,false);
		this.mode=mode;
		launch();
	}
	
	private void sleep(int milliseconds){
		try{
			TimeUnit.MILLISECONDS.sleep(milliseconds);
		}catch(InterruptedException e){
			System.out.println("GPA: failed waiting");
		}
	}

	@Override
	public void run(){
		boolean enable=true;
		
		switch(mode){
		case 0:
			int i=1;
			float x,y,a;
			
			while(enable){
				a=0.001f+ThreadLocalRandom.current().nextFloat()*(0.007f-0.001f);
				
				i=-i;	
//				i=ThreadLocalRandom.current().nextBoolean()?1:-1;
				
				x=ThreadLocalRandom.current().nextInt(1,10)/10f;
				y=ThreadLocalRandom.current().nextInt(25,76)/100f;
				
				if(ThreadLocalRandom.current().nextBoolean()){
					//horizontally 1-9/10
					while(x>=0.1&&x<=0.9){
						fromThread.threadReceived(0,null,null,new float[]{x,y},null);
						x+=a*i;
						sleep(70);
					}
				}
				else{
					//vertically  25-75/100
					while(y>=0.25&&y<=0.75){
						fromThread.threadReceived(0,null,null,new float[]{x,y},null);
						y+=a*i;
						sleep(70);
					}
				}
			}
//			System.out.println("amount="+a+", direction="+i+", position="+x+";"+y);
			break;
		}
	}
	
}
