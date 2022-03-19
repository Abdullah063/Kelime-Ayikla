package odev1;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import java.awt.Font;
import javax.swing.SwingConstants;


public class txtPane
{

	private JFrame frame;
	private DefaultListModel<String> lis;
	private String  words[] ;
	private JList <String>wordList ;
	private JScrollPane scList;
	
	public void ayikla(String str) 
	{
	
		words = str.trim().split(" "); 
		for (int i = 0; i < words.length; i++) 
		{
			int result = (int)words[i].charAt(0);
			if (result>=65&&result<=90)
			{
				lis.addElement(words[i]);
			}
		}
	}
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					txtPane window = new txtPane();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public txtPane() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame("Harf Ayýkla");
		frame.setResizable(false);
		frame.setBounds(100, 100, 500, 304);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		lis = new DefaultListModel<String>();
		wordList = new JList<String>(lis);
		wordList.setBounds(10, 10, 135, 158);
		frame.getContentPane().add(wordList);
		
		JButton btnClear = new JButton("Sil");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lis.clear();
			}
		});
		btnClear.setBounds(385, 192, 64, 27);
		frame.getContentPane().add(btnClear);
		
		JLabel lblNewLabel = new JLabel("Metin Kutusu\r\n\r\n");
		lblNewLabel.setBounds(23, 10, 82, 31);
		frame.getContentPane().add(lblNewLabel);
	
		JTextPane textPane = new JTextPane();
		textPane.setBounds(33, 34, 229, 158);
		frame.getContentPane().add(textPane);
		
		JButton btn = new JButton("Ay\u0131kla");
		btn.setHorizontalAlignment(SwingConstants.RIGHT);
		btn.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ayikla(textPane.getText());
			}
		});
		btn.setBounds(311, 192, 64, 27);
		frame.getContentPane().add(btn);
		
		JButton btnNewButton = new JButton("Sil");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textPane.setText("");;
			}
		});
		btnNewButton.setBounds(92, 195, 85, 21);
		frame.getContentPane().add(btnNewButton);
		
	   
		scList = new JScrollPane(wordList);
		scList.setBounds(311, 34, 138, 152);
		frame.getContentPane().add(scList);
	
		
	}
}
