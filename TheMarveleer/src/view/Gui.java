package view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

public class Gui extends JFrame{
	private static final long serialVersionUID=-5122499545468153449L;

	public BackgroundPanel head;
	
	public  JPanel content_card;
	public JPanel card_character;
	public JPanel card_comics;
	public JPanel card_series;
	public JPanel card_stories;
	
	public JLabel lbLeft_characters;
	public JLabel lbLeft_comics;
	public JLabel lbLeft_series;
	public JLabel lbLeft_stories;
	
	public JTextField tfSearch;
	public JButton btCenter_search;
	
	public JLabel lbCharacters_thubnail;
	public JLabel lbCharacter_title;
	public JLabel lbCharacter_description;
	public JLabel lbCharacter_urls;
	
	private JPanel contentPane;
	private JPanel tail;
	private JPanel left;
	private JLabel lbHead_head;
	private JLabel lbHead_title;
	private JLabel lbLeft_title;
	private JLabel lbTail_credits;
	public ScrollablePanel center_content;
	private JPanel content_search;
	private JScrollPane center;
	private JLabel lbSearch;
	private JProgressBar pbSearch;
	private JPanel search_action;
	public ScrollablePanel character_right;
	public JPanel character_header;
	private JLabel lbCharacter_other;

	/**
	 * Create the frame.
	 */
	public Gui(){
		Font arame,arameBold;
		BufferedImage head_bck;
		try{
			arame=Font.createFont(Font.TRUETYPE_FONT,Gui.class.getResourceAsStream("/resources/font/arame.otf"));
			arameBold=Font.createFont(Font.TRUETYPE_FONT,Gui.class.getResourceAsStream("/resources/font/arame-bold.otf"));
			GraphicsEnvironment.getLocalGraphicsEnvironment().registerFont(arame);
		}catch(FontFormatException|IOException ex){
			arame=new JLabel().getFont();
			arameBold=arame;
			System.out.println("Initializer: error loading fonts");
		}
		
		setTitle("THE MARVELEER");
		setMinimumSize(new Dimension(600, 400));
		setAlwaysOnTop(true);
		setBackground(Color.BLACK);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100,100,825,530);

		try{
			head_bck=ImageIO.read(Gui.class.getResourceAsStream("/resources/bck.jpg"));
		}catch(IOException e){
			head_bck=null;
			System.out.println("Initializer: failed loading images");
		}
		
		contentPane=new JPanel();
		contentPane.setOpaque(false);
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		head = new BackgroundPanel(head_bck,BackgroundPanel.ACTUAL,0.5f,0.75f); //0.1-0.9 0.25-0.75
		head.setPreferredSize(new Dimension(0, 120));
		head.setBorder(null);
		contentPane.add(head, BorderLayout.NORTH);
		head.setOpaque(false);
		GridBagLayout gbl_head = new GridBagLayout();
		gbl_head.columnWidths = new int[]{809, 0};
		gbl_head.rowHeights = new int[]{14, 14, 0};
		gbl_head.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_head.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		head.setLayout(gbl_head);
		
		lbHead_head = new JLabel("marvel api client demo");
		GridBagConstraints gbc_lbHead_head = new GridBagConstraints();
		gbc_lbHead_head.fill = GridBagConstraints.HORIZONTAL;
		gbc_lbHead_head.insets = new Insets(5, 0, 0, 0);
		gbc_lbHead_head.gridx = 0;
		gbc_lbHead_head.gridy = 0;
		head.add(lbHead_head, gbc_lbHead_head);
		lbHead_head.setForeground(new Color(51, 0, 0));
		lbHead_head.setFont(font(arameBold,15));
		lbHead_head.setHorizontalAlignment(SwingConstants.CENTER);
		
		lbHead_title = new JLabel("the marveleer");
		GridBagConstraints gbc_lbHead_title = new GridBagConstraints();
		gbc_lbHead_title.fill = GridBagConstraints.HORIZONTAL;
		gbc_lbHead_title.gridx = 0;
		gbc_lbHead_title.gridy = 1;
		head.add(lbHead_title, gbc_lbHead_title);
		lbHead_title.setHorizontalAlignment(SwingConstants.CENTER);
		lbHead_title.setForeground(new Color(51, 0, 0));
		lbHead_title.setFont(font(arameBold,100));
		
		left = new JPanel();
		contentPane.add(left, BorderLayout.WEST);
		left.setBorder(null);
		left.setBackground(Color.DARK_GRAY);
		left.setLayout(new GridLayout(5, 1, 0, 0));
		
		lbLeft_title = new JLabel("menu");
		lbLeft_title.setHorizontalAlignment(SwingConstants.CENTER);
		lbLeft_title.setForeground(Color.WHITE);
		lbLeft_title.setFont(font(arame,25));
		left.add(lbLeft_title);
		
		lbLeft_characters = new JLabel("characters");
		lbLeft_characters.setOpaque(true);
		lbLeft_characters.setBorder(new EmptyBorder(0, 10, 0, 10));
		lbLeft_characters.setBackground(Color.DARK_GRAY);
		lbLeft_characters.setHorizontalAlignment(SwingConstants.CENTER);
		lbLeft_characters.setForeground(Color.WHITE);
		lbLeft_characters.setFont(font(arame,15));
		left.add(lbLeft_characters);
		
		lbLeft_comics = new JLabel("comics");
		lbLeft_comics.setOpaque(true);
		lbLeft_comics.setBorder(new EmptyBorder(0, 10, 0, 10));
		lbLeft_comics.setBackground(Color.DARK_GRAY);
		lbLeft_comics.setHorizontalAlignment(SwingConstants.CENTER);
		lbLeft_comics.setForeground(Color.WHITE);
		lbLeft_comics.setFont(font(arame,15));
		left.add(lbLeft_comics);
		
		lbLeft_series = new JLabel("series");
		lbLeft_series.setOpaque(true);
		lbLeft_series.setBorder(new EmptyBorder(0, 10, 0, 10));
		lbLeft_series.setBackground(Color.DARK_GRAY);
		lbLeft_series.setHorizontalAlignment(SwingConstants.CENTER);
		lbLeft_series.setForeground(Color.WHITE);
		lbLeft_series.setFont(font(arame,15));
		left.add(lbLeft_series);
		
		lbLeft_stories = new JLabel("stories");
		lbLeft_stories.setOpaque(true);
		lbLeft_stories.setBorder(new EmptyBorder(0, 10, 0, 10));
		lbLeft_stories.setBackground(Color.DARK_GRAY);
		lbLeft_stories.setHorizontalAlignment(SwingConstants.CENTER);
		lbLeft_stories.setForeground(Color.WHITE);
		lbLeft_stories.setFont(font(arame,15));
		left.add(lbLeft_stories);
		
		try{
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			center = new JScrollPane();
			UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
		}catch(ClassNotFoundException|InstantiationException|IllegalAccessException|UnsupportedLookAndFeelException ex){
			ex.printStackTrace();
		}
		center.setBorder(null);
		center.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		center.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		center.setOpaque(false);
		center.getViewport().setOpaque(false);
		contentPane.add(center, BorderLayout.CENTER);
		
		center_content = new ScrollablePanel();
		center_content.setScrollableWidth(ScrollablePanel.ScrollableSizeHint.FIT);
		center_content.setBorder(null);
		center_content.setOpaque(false);
		center.setViewportView(center_content);
				
		btCenter_search = new JButton("confirm");
		btCenter_search.setPreferredSize(new Dimension(0, 0));
		btCenter_search.setContentAreaFilled(false);
		btCenter_search.setFocusPainted(false);
		btCenter_search.setBorderPainted(false);
		btCenter_search.setBorder(null);
		btCenter_search.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btCenter_search.setForeground(Color.WHITE);
		btCenter_search.setFont(font(arame,20));
		
		UIManager.put("ProgressBar.selectionForeground", Color.WHITE);
		UIManager.put("ProgressBar.selectionBackground", Color.WHITE);
		pbSearch = new JProgressBar();
		pbSearch.setPreferredSize(new Dimension(0, 0));
		pbSearch.setBorderPainted(false);
		pbSearch.setBorder(null);
		pbSearch.setStringPainted(true);
		pbSearch.setString("loading");
		pbSearch.setFont(font(arame,20));
		pbSearch.setForeground(Color.GRAY);
		pbSearch.setBackground(Color.DARK_GRAY);
		pbSearch.setIndeterminate(true);
		center_content.setLayout(new BoxLayout(center_content, BoxLayout.PAGE_AXIS));
		
		content_search = new JPanel();
		content_search.setPreferredSize(new Dimension(0, 30));
		content_search.setBackground(Color.DARK_GRAY);
		content_search.setBorder(null);
		center_content.add(content_search);
		GridBagLayout gbl_content_search = new GridBagLayout();
		gbl_content_search.columnWidths = new int[] {0, 0, 0};
		gbl_content_search.rowHeights = new int[] {0};
		gbl_content_search.columnWeights = new double[]{0.0, 0.0, 0.0};
		gbl_content_search.rowWeights = new double[]{1.0};
		content_search.setLayout(gbl_content_search);
		
		lbSearch = new JLabel("Search:");
		lbSearch.setPreferredSize(new Dimension(0, 0));
		lbSearch.setForeground(Color.WHITE);
		lbSearch.setFont(font(arame,20));
		lbSearch.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_lbSearch = new GridBagConstraints();
		gbc_lbSearch.weightx = 0.2;
		gbc_lbSearch.fill = GridBagConstraints.BOTH;
		gbc_lbSearch.gridx = 0;
		gbc_lbSearch.gridy = 0;
		content_search.add(lbSearch, gbc_lbSearch);
		
		tfSearch = new JTextField();
		tfSearch.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		tfSearch.setPreferredSize(new Dimension(0, 0));
		tfSearch.setBackground(Color.GRAY);
		tfSearch.setBorder(null);
		tfSearch.setForeground(Color.WHITE);
		tfSearch.setFont(font(arame,20));
		GridBagConstraints gbc_tfSearch = new GridBagConstraints();
		gbc_tfSearch.weightx = 0.5;
		gbc_tfSearch.fill = GridBagConstraints.BOTH;
		gbc_tfSearch.gridx = 1;
		gbc_tfSearch.gridy = 0;
		content_search.add(tfSearch, gbc_tfSearch);
		
		search_action = new JPanel();
		search_action.setOpaque(false);
		search_action.setBorder(null);
		search_action.setPreferredSize(new Dimension(0, 0));
		GridBagConstraints gbc_search_action = new GridBagConstraints();
		gbc_search_action.weightx = 0.3;
		gbc_search_action.fill = GridBagConstraints.BOTH;
		gbc_search_action.gridx = 2;
		gbc_search_action.gridy = 0;
		content_search.add(search_action, gbc_search_action);
		search_action.setLayout(new BorderLayout(0, 0));
		
				content_card = new JPanel();
				center_content.add(content_card);
				content_card.setOpaque(false);
				content_card.setLayout(new CardLayout(0, 0));
				
				card_character = new JPanel();
				card_character.setBorder(null);
				card_character.setOpaque(false);
				content_card.add(card_character, "characters");
				card_character.setLayout(new BoxLayout(card_character, BoxLayout.PAGE_AXIS));
				
				character_header = new JPanel();
				character_header.setOpaque(false);
				character_header.setBorder(new CompoundBorder(new MatteBorder(0, 0, 1, 0, new Color(255, 255, 255)), new EmptyBorder(0, 0, 10, 0)));
				card_character.add(character_header);
				GridBagLayout gbl_character_header = new GridBagLayout();
				gbl_character_header.columnWidths = new int[] {80, 0};
				gbl_character_header.rowHeights = new int[] {300};
				gbl_character_header.columnWeights = new double[]{0.0, 0.0};
				gbl_character_header.rowWeights = new double[]{0.0};
				character_header.setLayout(gbl_character_header);
				
				lbCharacters_thubnail = new JLabel("thumbnail");
				lbCharacters_thubnail.setBorder(new MatteBorder(0, 0, 0, 1, Color.WHITE));
				lbCharacters_thubnail.setForeground(Color.WHITE);
				lbCharacters_thubnail.setFont(font(arame,20));
				lbCharacters_thubnail.setHorizontalAlignment(SwingConstants.CENTER);
				lbCharacters_thubnail.setBackground(Color.RED);
				GridBagConstraints gbc_lbCharacters_thubnail = new GridBagConstraints();
				gbc_lbCharacters_thubnail.weightx = 0.3;
				gbc_lbCharacters_thubnail.fill = GridBagConstraints.BOTH;
				gbc_lbCharacters_thubnail.gridx = 0;
				gbc_lbCharacters_thubnail.gridy = 0;
				character_header.add(lbCharacters_thubnail, gbc_lbCharacters_thubnail);
				
				character_right = new ScrollablePanel();
				character_right.setOpaque(false);
				character_right.setBorder(null);
				character_right.setLayout(new BoxLayout(character_right, BoxLayout.PAGE_AXIS));
				
				lbCharacter_title = new JLabel("title");
				lbCharacter_title.setAlignmentX(0.5f);
				character_right.add(lbCharacter_title);
				lbCharacter_title.setBorder(new CompoundBorder(new MatteBorder(0, 0, 1, 0, new Color(255, 255, 255)), new EmptyBorder(5, 0, 10, 0)));
				lbCharacter_title.setForeground(Color.WHITE);
				lbCharacter_title.setFont(font(arame,30));
				lbCharacter_title.setBackground(Color.WHITE);
				lbCharacter_title.setHorizontalAlignment(SwingConstants.CENTER);
				
				lbCharacter_description = new JLabel("description");
				lbCharacter_description.setAlignmentX(Component.CENTER_ALIGNMENT);
				character_right.add(lbCharacter_description);
				lbCharacter_description.setBorder(new CompoundBorder(new MatteBorder(0, 0, 1, 0, new Color(255, 255, 255)), new EmptyBorder(5, 0, 10, 0)));
				lbCharacter_description.setFont(font(arame,20));
				lbCharacter_description.setForeground(Color.WHITE);
				lbCharacter_description.setHorizontalAlignment(SwingConstants.CENTER);
				
				lbCharacter_urls = new JLabel("urls");
				lbCharacter_urls.setAlignmentX(Component.CENTER_ALIGNMENT);
				character_right.add(lbCharacter_urls);
				lbCharacter_urls.setBorder(new CompoundBorder(new MatteBorder(0, 0, 1, 0, new Color(255, 255, 255)), new EmptyBorder(5, 0, 10, 0)));
				lbCharacter_urls.setForeground(Color.WHITE);
				lbCharacter_urls.setHorizontalAlignment(SwingConstants.CENTER);
				lbCharacter_urls.setFont(font(arame,20));
				lbCharacter_urls.setBackground(Color.WHITE);
				GridBagConstraints gbc_character_right = new GridBagConstraints();
				gbc_character_right.weighty = 1.0;
				gbc_character_right.weightx = 0.7;
				gbc_character_right.fill = GridBagConstraints.BOTH;
				gbc_character_right.gridx = 1;
				gbc_character_right.gridy = 0;
				character_header.add(character_right, gbc_character_right);
				
				lbCharacter_other = new JLabel("things");
				lbCharacter_other.setBorder(new EmptyBorder(5, 0, 0, 0));
				lbCharacter_other.setHorizontalAlignment(SwingConstants.CENTER);
				lbCharacter_other.setForeground(Color.WHITE);
				lbCharacter_other.setFont(font(arame,20));
				card_character.add(lbCharacter_other);
				
				card_comics = new JPanel();
				card_comics.setBorder(null);
				card_comics.setOpaque(false);
				content_card.add(card_comics, "comics");
				
				card_series = new JPanel();
				card_series.setBorder(null);
				card_series.setOpaque(false);
				content_card.add(card_series, "series");
				
				card_stories = new JPanel();
				card_stories.setBorder(null);
				card_stories.setOpaque(false);
				content_card.add(card_stories, "stories");
		
		tail = new JPanel();
		tail.setBorder(null);
		tail.setBackground(Color.DARK_GRAY);
		contentPane.add(tail, BorderLayout.SOUTH);
		tail.setLayout(new GridLayout(1, 5, 5, 5));
		
		lbTail_credits = new JLabel("Riccardo Cavasin 2018");
		lbTail_credits.setFont(font(arame,10));
		lbTail_credits.setHorizontalAlignment(SwingConstants.CENTER);
		lbTail_credits.setForeground(Color.GRAY);
		tail.add(lbTail_credits);
	}

	private Font font(Font f,float size){
		return f.deriveFont(size);
	}
	
	public void loading(boolean isLoading){
		if(isLoading){
			search_action.remove(btCenter_search);
			search_action.add(pbSearch,BorderLayout.CENTER);
		}
		else{
			search_action.remove(pbSearch);
			search_action.add(btCenter_search,BorderLayout.CENTER);
		}
		search_action.validate();
		search_action.repaint();
	}
}
