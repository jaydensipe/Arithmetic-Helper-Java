/*University of Central Florida
 COP 3330 Spring 2019
 Final Project
 Author: Jayden Sipe*/

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.awt.Color;
import javax.swing.border.MatteBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class HistoryPage extends JFrame {

	private JPanel contentPane;
	

	private ArrayList<String> integer1Strings;
	private ArrayList<String> integer2Strings;
	private ArrayList<String> correctAnswers;
	private ArrayList<String> yourAnswer;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HistoryPage frame = new HistoryPage();
					frame.setVisible(true);
				
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public HistoryPage() {
		setTitle("History of Last Quiz");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 568, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 153, 204));
		contentPane.setBorder(new MatteBorder(5, 5, 5, 5, (Color) new Color(204, 51, 204)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblHistoryOfLast = new JLabel("History of Last Quiz");
		lblHistoryOfLast.setForeground(new Color(255, 51, 102));
		lblHistoryOfLast.setFont(new Font("Comic Sans MS", Font.BOLD, 34));
		lblHistoryOfLast.setBounds(28, 0, 353, 109);
		contentPane.add(lblHistoryOfLast);
		
		JLabel lblNumber = new JLabel("Number 1:");
		lblNumber.setForeground(new Color(255, 51, 102));
		lblNumber.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		lblNumber.setBounds(28, 83, 553, 59);
		contentPane.add(lblNumber);
		
		JLabel lblNumber_1 = new JLabel("Number 2:");
		lblNumber_1.setForeground(new Color(255, 51, 102));
		lblNumber_1.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		lblNumber_1.setBounds(144, 83, 437, 59);
		contentPane.add(lblNumber_1);
		
		JLabel lblCorrectAnswer = new JLabel("Correct Ans:");
		lblCorrectAnswer.setForeground(new Color(255, 51, 102));
		lblCorrectAnswer.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		lblCorrectAnswer.setBounds(260, 83, 321, 59);
		contentPane.add(lblCorrectAnswer);
		
		JLabel lblYourAnswer = new JLabel("Your Answer:");
		lblYourAnswer.setForeground(new Color(255, 51, 102));
		lblYourAnswer.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		lblYourAnswer.setBounds(395, 83, 186, 59);
		contentPane.add(lblYourAnswer);
		
		JLabel label_1 = new JLabel("");
		label_1.setForeground(new Color(255, 51, 102));
		label_1.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		label_1.setBounds(144, 132, 104, 59);
		contentPane.add(label_1);
		
		JButton btnNewButton =  new JButton("Rank List");
		btnNewButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				try {
					User.printToFile();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				RankedList rl = null;
				try {
					rl = new RankedList();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				rl.setVisible(true);
				setVisible(false);
				
			}
		});
		btnNewButton.setBounds(423, 24, 98, 26);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Finish");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					User.printToFile();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				System.exit(0);
				
			}
		});
		btnNewButton_1.setBounds(423, 62, 98, 26);
		contentPane.add(btnNewButton_1);
		
		
		
		integer1Strings = new ArrayList<String>();
		
		for (int i = 0; i < User.getNumOfProblems(); i++)
		{
			integer1Strings.add(Integer.toString(ProblemSolving.integer1ArrayList.get(i)));
			JLabel label = new JLabel(integer1Strings.get(i));
			label.setForeground(new Color(255, 51, 102));
			label.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
			label.setBounds(28, 132 + (35 * i), 104, 59);
			contentPane.add(label);
		}
		
		integer2Strings = new ArrayList<String>();
		
		for (int i = 0; i < User.getNumOfProblems(); i++)
		{
			integer2Strings.add(Integer.toString(ProblemSolving.integer2ArrayList.get(i)));
			JLabel label = new JLabel(integer2Strings.get(i));
			label.setForeground(new Color(255, 51, 102));
			label.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
			label.setBounds(144, 132 + (35 * i), 104, 59);
			contentPane.add(label);
		}
		
		correctAnswers = new ArrayList<String>();
		
		for (int i = 0; i < User.getNumOfProblems(); i++)
		{
			correctAnswers.add(Integer.toString(ProblemSolving.correctAnswerArrayList.get(i)));
			JLabel label = new JLabel(correctAnswers.get(i));
			label.setForeground(new Color(255, 51, 102));
			label.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
			label.setBounds(260, 132 + (35 * i), 104, 59);
			contentPane.add(label);
		}
		
		yourAnswer = new ArrayList<String>();
		
		for (int i = 0; i < User.getNumOfProblems(); i++)
		{
			yourAnswer.add(Integer.toString(ProblemSolving.yourAnswerArrayList.get(i)));
			JLabel label = new JLabel(yourAnswer.get(i));
			label.setForeground(new Color(255, 51, 102));
			label.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
			label.setBounds(395, 132 + (35 * i), 104, 59);
			contentPane.add(label);
		}
		
		
		
	}
}
