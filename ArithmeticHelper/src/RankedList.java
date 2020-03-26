/*University of Central Florida
 COP 3330 Spring 2019
 Final Project
 Author: Jayden Sipe*/

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.MatteBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import javax.swing.JButton;

public class RankedList extends JFrame {

	private JPanel contentPane;
	private JTextField txt1;
	private JTextField txt2;
	private JTextField txt4;
	private JTextField txt3;
	private JTextField txt6;
	private JTextField txt5;
	private JTextField txt8;
	private JTextField txt7;
	private JTextField txt10;
	private JTextField txt9;
	
	private ArrayList<String> nameArray;
	private ArrayList<Double> scoreArray;
	private Scanner sc;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RankedList frame = new RankedList();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws FileNotFoundException 
	 */
	public RankedList() throws FileNotFoundException {
		setResizable(false);
		
		
		setTitle("Rank List");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 364, 411);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 153, 204));
		contentPane.setBorder(new MatteBorder(5, 5, 5, 5, (Color) new Color(255, 153, 255)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txt1 = new JTextField();
		txt1.setToolTipText("");
		txt1.setEditable(false);
		txt1.setBackground(new Color(153, 102, 204));
		
		txt1.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		txt1.setBounds(10, 62, 231, 27);
		contentPane.add(txt1);
		txt1.setColumns(10);
		
		txt2 = new JTextField();
		txt2.setText("2.");
		txt2.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		txt2.setEditable(false);
		txt2.setColumns(10);
		txt2.setBackground(new Color(153, 102, 204));
		txt2.setBounds(10, 93, 231, 27);
		contentPane.add(txt2);
		
		txt4 = new JTextField();
		txt4.setText("4.");
		txt4.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		txt4.setEditable(false);
		txt4.setColumns(10);
		txt4.setBackground(new Color(153, 102, 204));
		txt4.setBounds(10, 155, 231, 27);
		contentPane.add(txt4);
		
		txt3 = new JTextField();
		txt3.setText("3.");
		txt3.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		txt3.setEditable(false);
		txt3.setColumns(10);
		txt3.setBackground(new Color(153, 102, 204));
		txt3.setBounds(10, 124, 231, 27);
		contentPane.add(txt3);
		
		txt6 = new JTextField();
		txt6.setText("6.");
		txt6.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		txt6.setEditable(false);
		txt6.setColumns(10);
		txt6.setBackground(new Color(153, 102, 204));
		txt6.setBounds(10, 217, 231, 27);
		contentPane.add(txt6);
		
		txt5 = new JTextField();
		txt5.setText("5.");
		txt5.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		txt5.setEditable(false);
		txt5.setColumns(10);
		txt5.setBackground(new Color(153, 102, 204));
		txt5.setBounds(10, 186, 231, 27);
		contentPane.add(txt5);
		
		txt8 = new JTextField();
		txt8.setText("8.");
		txt8.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		txt8.setEditable(false);
		txt8.setColumns(10);
		txt8.setBackground(new Color(153, 102, 204));
		txt8.setBounds(10, 279, 231, 27);
		contentPane.add(txt8);
		
		txt7 = new JTextField();
		txt7.setText("7.");
		txt7.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		txt7.setEditable(false);
		txt7.setColumns(10);
		txt7.setBackground(new Color(153, 102, 204));
		txt7.setBounds(10, 248, 231, 27);
		contentPane.add(txt7);
		
		txt10 = new JTextField();
		txt10.setText("10.");
		txt10.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		txt10.setEditable(false);
		txt10.setColumns(10);
		txt10.setBackground(new Color(153, 102, 204));
		txt10.setBounds(10, 341, 231, 30);
		contentPane.add(txt10);
		
		txt9 = new JTextField();
		txt9.setText("9.");
		txt9.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		txt9.setEditable(false);
		txt9.setColumns(10);
		txt9.setBackground(new Color(153, 102, 204));
		txt9.setBounds(10, 310, 231, 27);
		contentPane.add(txt9);
		
		JLabel lblTop = new JLabel("TOP 10");
		lblTop.setForeground(new Color(204, 51, 204));
		lblTop.setFont(new Font("Comic Sans MS", Font.BOLD, 34));
		lblTop.setBounds(50, 11, 171, 42);
		contentPane.add(lblTop);
		
		nameArray = new ArrayList<String>(); 
		scoreArray = new ArrayList<Double>(); 
		sc = new Scanner(new File("rankedList.txt"));
		ArrayList<User> users = new ArrayList<>();
		
		
		while(sc.hasNext()) 
		{
			users.add(new User(sc.next(), Double.parseDouble(sc.next())));
			nameArray.add(sc.next());
			scoreArray.add(Double.parseDouble(sc.next()));
		
		}
		sc.close();
		
		nameArray.sort(Collections.reverseOrder());
		scoreArray.sort(Collections.reverseOrder());
		try {
			txt1.setText("1. " + nameArray.get(0) + " " + Double.toString(scoreArray.get(0)));
			txt2.setText("2. " + nameArray.get(1) + " " + Double.toString(scoreArray.get(1)));
			txt3.setText("3. " + nameArray.get(2) + " " + Double.toString(scoreArray.get(2)));
			txt4.setText("4. " + nameArray.get(3) + " " + Double.toString(scoreArray.get(3)));
			txt5.setText("5. " + nameArray.get(4) + " " + Double.toString(scoreArray.get(4)));
			txt6.setText("6. " + nameArray.get(5) + " " + Double.toString(scoreArray.get(5)));
			txt7.setText("7. " + nameArray.get(6) + " " + Double.toString(scoreArray.get(6)));
			txt8.setText("8. " + nameArray.get(7) + " " + Double.toString(scoreArray.get(7)));
			txt9.setText("9. " + nameArray.get(8) + " " + Double.toString(scoreArray.get(8)));
			txt10.setText("10. " + nameArray.get(9) + " " + Double.toString(scoreArray.get(9)));
			
			JButton btnNewButton = new JButton("Finish");
			btnNewButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
			btnNewButton.setBounds(249, 11, 97, 42);
			contentPane.add(btnNewButton);
		}
		
		catch (Exception IndexOutOfBoundsException)
		{
			System.out.println("Need more numbers!");
		}
		
		
		
	}
}
