/*University of Central Florida
 COP 3330 Spring 2019
 Final Project
 Author: Jayden Sipe*/

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.Color;
import javax.swing.border.MatteBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Toolkit;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ConfirmationPage extends JFrame {

	private JPanel contentPane;
	public static String name;
	public static String selection;
	public static int numberOfProblems;
	public static int numberOfDigits;
	static ConfirmationPage frame = new ConfirmationPage(name, numberOfProblems, numberOfDigits, selection);
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
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
	
	
	public ConfirmationPage(String name, int numberOfProblems, int numberOfDigits, String selection) {
		setResizable(false);
		
		ConfirmationPage.name = name;
		ConfirmationPage.numberOfProblems = numberOfProblems;
		ConfirmationPage.numberOfDigits = numberOfDigits;
		ConfirmationPage.selection = selection;
		
		setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		if (selection == "Addition")
		{
			setTitle("Addition Helper");
		} else if (selection == "Subtraction")
		{
			setTitle("Subtraction Helper");
		} else if (selection == "Multiplication")
		{
			setTitle("Multiplication Helper");
		} else if (selection == "Division")
		{
			setTitle("Division Helper");
		}
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 524, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 165, 0));
		contentPane.setBorder(new MatteBorder(5, 5, 5, 5, (Color) new Color(220, 20, 60)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblWelcomeToBlank = new JLabel();
		if (selection == "Addition")
		{
			lblWelcomeToBlank.setText("WELCOME TO ADDITION HELPER!");
		} else if (selection == "Subtraction")
		{
			lblWelcomeToBlank.setText("WELCOME TO SUBTRACTION HELPER!");
		} else if (selection == "Multiplication")
		{
			lblWelcomeToBlank.setText("WELCOME TO MULTIPLICATION HELPER!");
		} else if (selection == "Division")
		{
			lblWelcomeToBlank.setText("WELCOME TO DIVISION HELPER!");
		}
		
		lblWelcomeToBlank.setForeground(new Color(255, 0, 0));
		lblWelcomeToBlank.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcomeToBlank.setFont(new Font("Comic Sans MS", Font.BOLD, 21));
		lblWelcomeToBlank.setBounds(35, 11, 453, 68);
		contentPane.add(lblWelcomeToBlank);
		
		JLabel lblYourName = new JLabel("Your Name: ");
		lblYourName.setForeground(new Color(178, 34, 34));
		lblYourName.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		lblYourName.setBounds(133, 72, 129, 41);
		contentPane.add(lblYourName);
		
		JLabel labelSetName = new JLabel(name);
		labelSetName.setForeground(new Color(255, 0, 0));
		labelSetName.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		labelSetName.setBounds(251, 72, 255, 41);
		contentPane.add(labelSetName);
		
		JLabel lblNumberOfProblems = new JLabel("Number of Problems:");
		lblNumberOfProblems.setForeground(new Color(178, 34, 34));
		lblNumberOfProblems.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		lblNumberOfProblems.setBounds(133, 113, 206, 41);
		contentPane.add(lblNumberOfProblems);
		
		JLabel lblNumberOfDigits = new JLabel("Number of Digits:");
		lblNumberOfDigits.setForeground(new Color(178, 34, 34));
		lblNumberOfDigits.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		lblNumberOfDigits.setBounds(133, 154, 206, 41);
		contentPane.add(lblNumberOfDigits);
		
		JLabel lblNumOfProblemsField = new JLabel("");
		lblNumOfProblemsField.setText(Integer.toString(numberOfProblems));
		lblNumOfProblemsField.setForeground(new Color(255, 0, 0));
		lblNumOfProblemsField.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		lblNumOfProblemsField.setBounds(339, 113, 58, 41);
		contentPane.add(lblNumOfProblemsField);
		
		JLabel lblNumOfDigitsField = new JLabel("");
		lblNumOfDigitsField.setText(Integer.toString(numberOfDigits));
		lblNumOfDigitsField.setForeground(new Color(255, 0, 0));
		lblNumOfDigitsField.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		lblNumOfDigitsField.setBounds(312, 154, 58, 41);
		contentPane.add(lblNumOfDigitsField);
		
		JLabel lblPressstartTo = new JLabel("Press \"Start\" to begin the quiz!");
		lblPressstartTo.setForeground(new Color(178, 34, 34));
		lblPressstartTo.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		lblPressstartTo.setBounds(48, 206, 313, 41);
		contentPane.add(lblPressstartTo);
		
		JButton btnNewButton = new JButton("Start");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ProblemSolving ps = new ProblemSolving();
				ps.setVisible(true);
				setVisible(false);
				}
		});
		btnNewButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		btnNewButton.setBounds(366, 206, 89, 41);
		contentPane.add(btnNewButton);
	}
}
