package model;

import java.awt.Image;

public class Character{
	public String name,description,urls[][];
	public ShrinkIcon thumbnail;
	
	public Character(){
		this.name="no";
		this.description="no";
		this.urls=new String[][]{{"no"}};
		this.thumbnail=null;
	}

	public void setThumbnail(Image thumbnail){
		this.thumbnail=new ShrinkIcon(thumbnail,"thumbnail",true);
	}
}
