package control;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;

import org.json.JSONArray;
import org.json.JSONObject;

import model.Character;
import model.Co;
import model.FromThread;
import model.GPA;
import model.MrBlueSky;
import view.BackgroundPanel;
import view.Gui;

public class Controller implements ActionListener,MouseListener,FromThread{
	private Gui gui;
	private GPA gpa;
	private MrBlueSky mbs;
	
	private Character character;
	
	private String selected;

	public Controller(){
		gui=new Gui();
		gpa=new GPA(this,0);
		mbs=new MrBlueSky(this);
		
		gui.btCenter_search.addActionListener(this);
		
//		gui.lbLeft_characters.addMouseListener(this);
		gui.lbLeft_comics.addMouseListener(this);
		gui.lbLeft_series.addMouseListener(this);
		gui.lbLeft_stories.addMouseListener(this);
		
		selected=Co.CHARACTERS;
		selected(Co.CHARACTERS);
		gui.loading(false);
		
		gui.setVisible(true);
	}
	
	private void parser(String mode,String json){
		JSONArray results;
		JSONObject r;
		
		if(json.charAt(0)=='!'){
			gui.tfSearch.setText(json.substring(1));
		}
		else{
			System.out.println("Controller: parsing "+json);
			results=new JSONObject(json).getJSONObject("data").getJSONArray("results");
			if(results.length()>0){
				r=results.getJSONObject(0);
				switch(mode){
				case Co.CHARACTERS:
					Character character=new Character();
					JSONObject object;
					JSONArray array;

					object=r.getJSONObject("thumbnail");
					mbs.requestImage(object.getString("path"),object.getString("extension"));
					
					character.name=r.getString("name");
					character.description=r.getString("description");
					
					array=r.getJSONArray("urls");
					character.urls=new String[array.length()][];
					for(int i=0;i<array.length();i++){
						character.urls[i]=new String[]{((JSONObject)array.get(i)).getString("type"),((JSONObject)array.get(i)).getString("url")};
					}
					
					displayer(Co.CHARACTERS,character);
					break;
				}
			}
		}
		gui.loading(false);
	}
	
	private void displayer(String mode,Object input){
		switch(mode){
		case Co.CHARACTERS:
			character=(Character)input;
			
			gui.lbCharacter_title.setText(character.name);
			if(character.thumbnail!=null){
				gui.lbCharacters_thubnail.setText("");
				gui.lbCharacters_thubnail.setIcon(character.thumbnail);
			}
			else{
				gui.lbCharacters_thubnail.setText("thumbnail");
				gui.lbCharacters_thubnail.setIcon(null);
			}
			if(character.description.length()==0){
				gui.lbCharacter_description.setText("<html><font face=\"Arame\" size=\"5\" color=\"white\"><center>"+"no description avaliable"+"</center></font></html>");
			}
			else{
				gui.lbCharacter_description.setText("<html><font face=\"Arame\" size=\"5\" color=\"white\"><center>"+character.description+"</center></font></html>");
			}
			if(character.urls.length==0){
				gui.lbCharacter_urls.setText("no urls provided");
			}
			else{
				String t="<html><font face=\"Arame\" size=\"5\" color=\"white\"><center>";
				for(String url[]:character.urls){
					t+="<a href=\""+url[1]+"\">"+url[0]+"</a><br/>";
				}
				t+="</center></font></html>";
				System.out.println(t);
				gui.lbCharacter_urls.setText(t);
			}
//			gui.character_right.setPreferredSize(gui.character_right.getPreferredSize());
//			gui.character_header.setPreferredSize(gui.character_header.getPreferredSize());
//			gui.card_character.setPreferredSize(gui.card_character.getPreferredSize());
//			gui.center_content.setPreferredSize(gui.center_content.getPreferredSize());
			gui.center_content.validate();
			break;
		}
	}
	
	private void selected(String selection){
		JLabel t=null;
		
		switch(selected){
		case Co.CHARACTERS:
			t=gui.lbLeft_characters;
			break;
		case Co.COMICS:
			t=gui.lbLeft_comics;
			break;
		case Co.SERIES:
			t=gui.lbLeft_series;
			break;
		case Co.STORIES:
			t=gui.lbLeft_stories;
			break;
		}
		t.addMouseListener(this);
		t.setBackground(Color.DARK_GRAY);
		
		selected=selection;
		
		switch(selected){
		case Co.CHARACTERS:
			t=gui.lbLeft_characters;
			((CardLayout)gui.content_card.getLayout()).show(gui.content_card,"characters");
			break;
		case Co.COMICS:
			t=gui.lbLeft_comics;
			((CardLayout)gui.content_card.getLayout()).show(gui.content_card,"comics");
			break;
		case Co.SERIES:
			t=gui.lbLeft_series;
			((CardLayout)gui.content_card.getLayout()).show(gui.content_card,"series");
			break;
		case Co.STORIES:
			t=gui.lbLeft_stories;
			((CardLayout)gui.content_card.getLayout()).show(gui.content_card,"stories");
			break;
		}
		t.removeMouseListener(this);
		t.setBackground(Color.GRAY);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e){
		Object source=e.getSource();
		
		if(source==gui.btCenter_search){
			String s;
			
			gui.loading(true);
			s=gui.tfSearch.getText().trim().replaceAll(" +"," ").toLowerCase();
			gui.tfSearch.setText(s);
			mbs.request(selected,s.replace(" ","+"));
		}
	}
	
	@Override
	public void mousePressed(MouseEvent e){
		Object source=e.getSource();
		
		if(source==gui.lbLeft_characters){
			selected(Co.CHARACTERS);
		}else if(source==gui.lbLeft_comics){
			selected(Co.COMICS);
		}else if(source==gui.lbLeft_series){
			selected(Co.SERIES);
		}else if(source==gui.lbLeft_stories){
			selected(Co.STORIES);
		}
	}

	@Override
	public void mouseEntered(MouseEvent e){
		JLabel source=(JLabel)e.getSource();
		
		source.setBackground(Color.GRAY);
	}

	@Override
	public void mouseExited(MouseEvent e){
		JLabel source=(JLabel)e.getSource();
		
		source.setBackground(Color.DARK_GRAY);
	}
	
	@Override
	public void threadReceived(int id,String[] s,int[] v,float f[],Image i){
		BackgroundPanel head=gui.head;
		
		switch(id){
		case 0:
			head.setImageAlignmentX(f[0]);
			head.setImageAlignmentY(f[1]);
		break;
		case 1:
			parser(selected,s[0]);
		break;
		case 2:
			character.setThumbnail(i);
			displayer(Co.CHARACTERS,character);
			break;
		}
	}
	
	@Override
	public void mouseClicked(MouseEvent e){		
	}
	@Override
	public void mouseReleased(MouseEvent e){
	}
}
