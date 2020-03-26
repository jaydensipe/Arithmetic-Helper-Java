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
import java.security.SecureRandom;
import java.util.ArrayList;
import java.awt.Font;
import java.awt.Color;
import javax.swing.border.MatteBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ProblemSolving extends JFrame {

	private JPanel contentPane;
	private JTextField resultBox;
	private int integer1, integer1Calc, integer2, integer2Calc;
	public static int correctCounter;
	public static int incorrectCounter;
	public static int startTime, endTime;
	private int correctAnswer = 0;
	private int counter = 0;
	JLabel lblProblem = new JLabel();
	JLabel firstNumberText = new JLabel();
	JLabel secondNumberText = new JLabel();
	static ProblemSolving frame = new ProblemSolving();
	
	public static ArrayList<Integer> integer1ArrayList;
	public static ArrayList<Integer> integer2ArrayList;
	public static ArrayList<Integer> correctAnswerArrayList;
	public static ArrayList<Integer> yourAnswerArrayList;
	
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
	
	public ProblemSolving() {
		setResizable(false);
		setTitle("Arithmetic Helper");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 354, 318);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(245, 245, 220));
		contentPane.setBorder(new MatteBorder(5, 5, 5, 5, (Color) new Color(205, 133, 63)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblHelper = new JLabel();
		lblHelper.setHorizontalAlignment(SwingConstants.CENTER);
		lblHelper.setForeground(new Color(210, 105, 30));
		lblHelper.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		if (ConfirmationPage.selection == "Addition")
		{
			lblHelper.setText("-ADDITION HELPER!-");
		} else if (ConfirmationPage.selection  == "Subtraction")
		{
			lblHelper.setText("-SUBTRACTION HELPER!-");
		} else if (ConfirmationPage.selection  == "Multiplication")
		{
			lblHelper.setText("-MULTIPLICATION HELPER!-");
		} else if (ConfirmationPage.selection  == "Division")
		{
			lblHelper.setText("-DIVSION HELPER!-");
		}
		lblHelper.setBounds(17, 22, 304, 43);
		contentPane.add(lblHelper);

		lblProblem.setHorizontalAlignment(SwingConstants.CENTER);
		lblProblem.setForeground(new Color(210, 105, 30));
		lblProblem.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		lblProblem.setBounds(17, 52, 304, 43);
		contentPane.add(lblProblem);
		
		JLabel lblFirstNumber = new JLabel();
		lblFirstNumber.setText("First Number:");
		lblFirstNumber.setHorizontalAlignment(SwingConstants.LEFT);
		lblFirstNumber.setForeground(new Color(210, 105, 30));
		lblFirstNumber.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		lblFirstNumber.setBounds(17, 94, 116, 43);
		contentPane.add(lblFirstNumber);
		
		JLabel lblOperation = new JLabel();
		lblOperation.setText("Operation:");
		lblOperation.setHorizontalAlignment(SwingConstants.LEFT);
		lblOperation.setForeground(new Color(210, 105, 30));
		lblOperation.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		lblOperation.setBounds(17, 125, 86, 43);
		contentPane.add(lblOperation);
		
		JLabel lblSecondNumber = new JLabel();
		lblSecondNumber.setText("Second Number:");
		lblSecondNumber.setHorizontalAlignment(SwingConstants.LEFT);
		lblSecondNumber.setForeground(new Color(210, 105, 30));
		lblSecondNumber.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		lblSecondNumber.setBounds(17, 156, 129, 43);
		contentPane.add(lblSecondNumber);
		
		JLabel lblSecondNuentmber = new JLabel();
		lblSecondNuentmber.setText("Enter Result:");
		lblSecondNuentmber.setHorizontalAlignment(SwingConstants.LEFT);
		lblSecondNuentmber.setForeground(new Color(210, 105, 30));
		lblSecondNuentmber.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		lblSecondNuentmber.setBounds(64, 194, 129, 43);
		contentPane.add(lblSecondNuentmber);
		
		resultBox = new JTextField();
		resultBox.setBounds(166, 208, 95, 20);
		contentPane.add(resultBox);
		resultBox.setColumns(10);
		
		
		JLabel operationText = new JLabel();
		if (ConfirmationPage.selection == "Addition")
		{
			operationText.setText("Addition (+)");
		} else if (ConfirmationPage.selection  == "Subtraction")
		{
			operationText.setText("Subtraction (-)");
		} else if (ConfirmationPage.selection  == "Multiplication")
		{
			operationText.setText("Multiplication (*)");
		} else if (ConfirmationPage.selection  == "Division")
		{
			operationText.setText("Division (/)");
		}
		operationText.setHorizontalAlignment(SwingConstants.LEFT);
		operationText.setForeground(new Color(244, 164, 96));
		operationText.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		operationText.setBounds(99, 125, 151, 43);
		contentPane.add(operationText);
		
		firstNumberText.setHorizontalAlignment(SwingConstants.LEFT);
		firstNumberText.setForeground(new Color(244, 164, 96));
		firstNumberText.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		firstNumberText.setBounds(126, 94, 135, 43);
		contentPane.add(firstNumberText);
		
		secondNumberText.setHorizontalAlignment(SwingConstants.LEFT);
		secondNumberText.setForeground(new Color(244, 164, 96));
		secondNumberText.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		secondNumberText.setBounds(141, 156, 121, 43);
		contentPane.add(secondNumberText);
		
		//Generate First Numbers
		
		startTime = (int)System.currentTimeMillis() / 1000;
		counter++;
		
		lblProblem.setText("Problem " + counter + " of " + ConfirmationPage.numberOfProblems);
		SecureRandom rand = new SecureRandom();
		integer1Calc = (int) Math.pow(10, ConfirmationPage.numberOfDigits - 1);
		integer1 = integer1Calc + rand.nextInt(9 * integer1Calc);
		integer1ArrayList = new ArrayList<Integer>();
		integer1ArrayList.add(integer1);
		
		
		integer2Calc = (int) Math.pow(10, ConfirmationPage.numberOfDigits - 1);
		integer2 = integer2Calc + rand.nextInt(9 * integer2Calc);
		integer2ArrayList = new ArrayList<Integer>();
		integer2ArrayList.add(integer2);
		
		firstNumberText.setText(Integer.toString(integer1));
		secondNumberText.setText(Integer.toString(integer2));
		correctAnswerArrayList = new ArrayList<Integer>();
		yourAnswerArrayList = new ArrayList<Integer>();
	
		
		JButton btnNextProblem = new JButton("Next Problem");
		btnNextProblem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			try {
				
				if (ConfirmationPage.selection == "Addition")
				{
					correctAnswer = integer1 + integer2;
				} else if (ConfirmationPage.selection  == "Subtraction")
				{
					correctAnswer = integer1 - integer2;
				} else if (ConfirmationPage.selection  == "Multiplication")
				{
					correctAnswer = integer1 * integer2;
				} else if (ConfirmationPage.selection  == "Division")
				{
					correctAnswer = integer1 / integer2;
				}

				
					
					if(Integer.parseInt(resultBox.getText()) == correctAnswer)
					{
						correctCounter++;
						correctAnswerArrayList.add(correctAnswer);
						yourAnswerArrayList.add(Integer.parseInt(resultBox.getText()));
						resultBox.setText("");
					} else
					{
						incorrectCounter++;
						correctAnswerArrayList.add(correctAnswer);
						yourAnswerArrayList.add(Integer.parseInt(resultBox.getText()));
						resultBox.setText("");
					}
					
					if(ConfirmationPage.numberOfProblems == 1)
					{
						endTime = (int)System.currentTimeMillis() / 1000;
						ResultsPage result = new ResultsPage();
						result.setVisible(true);
						setVisible(false);
					}
					
					counter++;
					
					if (counter != 1)
					{
						lblProblem.setText("Problem " + counter + " of " + ConfirmationPage.numberOfProblems);
						SecureRandom rand = new SecureRandom();
						integer1Calc = (int) Math.pow(10, ConfirmationPage.numberOfDigits - 1);
						integer1 = integer1Calc + rand.nextInt(9 * integer1Calc);
						integer1ArrayList.add(integer1);
						
						integer2Calc = (int) Math.pow(10, ConfirmationPage.numberOfDigits - 1);
						integer2 = integer2Calc + rand.nextInt(9 * integer2Calc);
						integer2ArrayList.add(integer2);
						firstNumberText.setText(Integer.toString(integer1));
						secondNumberText.setText(Integer.toString(integer2));
						}
						

					
					if (ConfirmationPage.selection == "Addition")
					{
						correctAnswer = integer1 + integer2;
					} else if (ConfirmationPage.selection  == "Subtraction")
					{
						correctAnswer = integer1 - integer2;
					} else if (ConfirmationPage.selection  == "Multiplication")
					{
						correctAnswer = integer1 * integer2;
					} else if (ConfirmationPage.selection  == "Division")
					{
						correctAnswer = integer1 / integer2;
					}

				}
				
				catch(Exception NumberFormatException)
				{
					System.out.println("Error occured!");
					JOptionPane.showMessageDialog(null, "Please enter a numerical value in the result space!", "Error", 2);
					
				}
				
				if(counter - 1 == ConfirmationPage.numberOfProblems)
				{
					endTime = (int)System.currentTimeMillis() / 1000;
					ResultsPage result = new ResultsPage();
					result.setVisible(true);
					setVisible(false);
				}
				
				
				}
			
				
		});
		
		btnNextProblem.setBounds(111, 239, 116, 26);
		contentPane.add(btnNextProblem);
		
		
	}
}
