package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import view.ScrollablePanel.ScrollableSizeHint;

public class Gui extends JFrame{

	private JPanel contentPane;
	private JScrollPane scrollPane;
	private ScrollablePanel panel;
	private JLabel lbThumbnail;
	private ScrollablePanel descriptions;
	private JPanel header;
	private JLabel lb1;
	private JLabel lb2;
	private JLabel lb3;
	private JLabel lb4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args){
		EventQueue.invokeLater(new Runnable(){
			@Override
			public void run(){
				try{
					Gui frame=new Gui();
					frame.setVisible(true);
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Gui(){
		setAlwaysOnTop(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100,100,564,365);
		contentPane=new JPanel();
		contentPane.setBorder(new EmptyBorder(5,5,5,5));
		contentPane.setLayout(new BorderLayout(0,0));
		setContentPane(contentPane);

		scrollPane=new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		contentPane.add(scrollPane,BorderLayout.CENTER);

		ScrollablePanel panel=new ScrollablePanel();
		panel.setScrollableWidth(ScrollableSizeHint.FIT);
		panel.setBackground(Color.RED);
		panel.setBorder(null);
		scrollPane.setViewportView(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));

		header=new JPanel();
		header.setBackground(Color.GREEN);
		header.setBorder(null);
		panel.add(header);
		header.setLayout(new GridLayout(0, 2, 0, 0));

		lbThumbnail=new JLabel("thumbnail");
		lbThumbnail.setBorder(new LineBorder(Color.GRAY,3));
		lbThumbnail.setHorizontalAlignment(SwingConstants.CENTER);
		lbThumbnail.setBackground(Color.RED);
		header.add(lbThumbnail);

		descriptions=new ScrollablePanel();
		descriptions.setBackground(Color.ORANGE);
		descriptions.setBorder(null);
		header.add(descriptions);
		descriptions.setLayout(new BoxLayout(descriptions, BoxLayout.PAGE_AXIS));

		lb1=new JLabel("<html>\r\n\u2588  \u2588\u2588  \u2588  \u2588\u2588\u2588  \u2588\u2588  \u2588  \u2588\u2588\u2588  \u2588\u2588  \u2588\u2588  \u2588\u2588\u2588  \u2588  \u2588\u2588\u2588  \u2588\u2588  \u2588  \u2588\u2588\u2588  \u2588\u2588  \u2588  \u2588\u2588  \u2588  \u2588\u2588\u2588  \u2588\u2588  \u2588  \u2588\u2588\u2588  \u2588\u2588  \u2588\u2588  \u2588\u2588\u2588  \u2588  \u2588\u2588\u2588  \u2588\u2588  \u2588  \u2588\u2588\u2588  \u2588\u2588  \u2588  \u2588\u2588  \u2588  \u2588\u2588\u2588  \u2588\u2588  \u2588  \u2588\u2588\u2588  \u2588\u2588  \u2588\u2588  \u2588\u2588\u2588  \u2588  \u2588\u2588\u2588  \u2588\u2588  \u2588  \u2588\u2588\u2588  \u2588\u2588  \r\n</html>");
		lb1.setBorder(new CompoundBorder(new LineBorder(new Color(128, 128, 128), 3), new EmptyBorder(5, 5, 5, 5)));
		lb1.setHorizontalAlignment(SwingConstants.CENTER);
		lb1.setAlignmentY(Component.TOP_ALIGNMENT);
		lb1.setAlignmentX(Component.CENTER_ALIGNMENT);
		descriptions.add(lb1);

		lb2=new JLabel(
				"<html>\r\n\u2588\u2588  \u2588\u2588  \u2588\u2588\u2588  \u2588  \u2588\u2588  \u2588  \u2588\u2588\u2588  \u2588\u2588  \u2588  \u2588\u2588\u2588  \u2588\u2588  \u2588\u2588  \u2588\u2588\u2588  \u2588  \u2588\u2588\u2588  \u2588\u2588  \u2588  \u2588\u2588\u2588  \u2588\u2588  \u2588  \u2588\u2588  \u2588  \u2588\u2588\u2588  \u2588\u2588  \u2588  \u2588\u2588\u2588  \u2588\u2588  \u2588\u2588  \u2588\u2588\u2588  \u2588  \u2588\u2588\u2588  \u2588\u2588  \u2588  \u2588\u2588\u2588  \u2588\u2588  \u2588  \u2588\u2588  \u2588  \u2588\u2588\u2588  \u2588\u2588  \u2588  \u2588\u2588\u2588  \u2588\u2588  \u2588\u2588  \u2588\u2588\u2588  \u2588  \u2588\u2588\u2588  \u2588\u2588  \u2588  \u2588\u2588\u2588  \u2588\u2588  \r\n</html>");
		lb2.setBorder(new CompoundBorder(new LineBorder(new Color(128, 128, 128), 3), new EmptyBorder(5, 5, 5, 5)));
		lb2.setHorizontalAlignment(SwingConstants.CENTER);
		lb2.setAlignmentY(Component.TOP_ALIGNMENT);
		lb2.setAlignmentX(Component.CENTER_ALIGNMENT);
		descriptions.add(lb2);

		lb3=new JLabel(
				"<html>\r\n\u2588  \u2588\u2588  \u2588  \u2588\u2588\u2588  \u2588\u2588  \u2588  \u2588\u2588\u2588  \u2588\u2588  \u2588\u2588  \u2588\u2588\u2588  \u2588  \u2588\u2588\u2588  \u2588\u2588  \u2588  \u2588\u2588\u2588  \u2588\u2588  \u2588  \u2588\u2588  \u2588  \u2588\u2588\u2588  \u2588\u2588  \u2588\u2588\u2588  \u2588\u2588  \u2588  \u2588\u2588\u2588  \u2588\u2588  \u2588  \u2588\u2588  \u2588  \u2588\u2588\u2588  \u2588\u2588  \u2588  \u2588\u2588\u2588  \u2588\u2588  \u2588\u2588  \u2588\u2588\u2588  \u2588  \u2588\u2588\u2588  \u2588\u2588  \u2588  \u2588\u2588\u2588  \u2588\u2588  \r\n</html>");
		lb3.setBorder(new CompoundBorder(new LineBorder(new Color(128, 128, 128), 3), new EmptyBorder(5, 5, 5, 5)));
		lb3.setHorizontalAlignment(SwingConstants.CENTER);
		lb3.setAlignmentY(Component.TOP_ALIGNMENT);
		lb3.setAlignmentX(Component.CENTER_ALIGNMENT);
		descriptions.add(lb3);

		lb4=new JLabel(
				"<html>\r\n\u2588  \u2588\u2588  \u2588  \u2588\u2588\u2588  \u2588\u2588  \u2588  \u2588\u2588\u2588  \u2588\u2588  \u2588\u2588  \u2588\u2588\u2588  \u2588  \u2588\u2588\u2588  \u2588\u2588  \u2588  \u2588\u2588\u2588  \u2588\u2588  \u2588  \u2588\u2588  \u2588  \u2588\u2588\u2588  \u2588\u2588  \u2588\u2588\u2588  \u2588\u2588  \u2588  \u2588\u2588\u2588  \u2588\u2588  \u2588  \u2588\u2588  \u2588  \u2588\u2588\u2588  \u2588\u2588  \u2588  \u2588\u2588\u2588  \u2588\u2588  \u2588\u2588  \u2588\u2588\u2588  \u2588  \u2588\u2588\u2588  \u2588\u2588  \u2588  \u2588\u2588\u2588  \u2588\u2588  \r\n</html>");
		lb4.setAlignmentX(0.5f);
		lb4.setBorder(new CompoundBorder(new LineBorder(new Color(128, 128, 128), 3), new EmptyBorder(5, 5, 5, 5)));
		lb4.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lb4);
	}

}
