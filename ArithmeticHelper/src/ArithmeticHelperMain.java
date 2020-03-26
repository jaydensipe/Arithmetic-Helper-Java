/*University of Central Florida
 COP 3330 Spring 2019
 Final Project
 Author: Jayden Sipe*/

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.border.MatteBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Window.Type;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.security.SecureRandom;
import java.awt.event.ActionEvent;

public class ArithmeticHelperMain extends JFrame {

	
	private JPanel mainFrame;
	private JTextField nameEnterTextField;
	private JTextField numOfProblemsTextField;
	private JTextField numOfDigitsTextField;
	private JLabel typeOfOpLabel;
	static ArithmeticHelperMain frame = new ArithmeticHelperMain();

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
	public ArithmeticHelperMain() {
		setTitle("Arithmetic Helper");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 402, 381);
		mainFrame = new JPanel();
		mainFrame.setBackground(new Color(0, 250, 154));
		mainFrame.setBorder(new MatteBorder(5, 5, 5, 5, (Color) new Color(0, 128, 0)));
		setContentPane(mainFrame);
		mainFrame.setLayout(null);
		
		nameEnterTextField = new JTextField();
		nameEnterTextField.setBounds(165, 113, 176, 20);
		mainFrame.add(nameEnterTextField);
		nameEnterTextField.setColumns(10);
		
		JLabel nameEnterLabel = new JLabel("Enter your Name: ");
		nameEnterLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		nameEnterLabel.setBounds(44, 113, 131, 17);
		mainFrame.add(nameEnterLabel);
		
		JLabel numOfProblemsLabel = new JLabel("Enter Number of Problems: ");
		numOfProblemsLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		numOfProblemsLabel.setBounds(44, 144, 204, 35);
		mainFrame.add(numOfProblemsLabel);
		
		numOfProblemsTextField = new JTextField();
		numOfProblemsTextField.setBounds(229, 153, 112, 20);
		mainFrame.add(numOfProblemsTextField);
		numOfProblemsTextField.setColumns(10);
		
		JLabel numOfDigitsLabel = new JLabel("Enter Number of Digits:");
		numOfDigitsLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		numOfDigitsLabel.setBounds(44, 185, 173, 33);
		mainFrame.add(numOfDigitsLabel);
		
		numOfDigitsTextField = new JTextField();
		numOfDigitsTextField.setBounds(209, 193, 132, 20);
		mainFrame.add(numOfDigitsTextField);
		numOfDigitsTextField.setColumns(10);
		
		typeOfOpLabel = new JLabel("Choose the Type of Operation: ");
		typeOfOpLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		typeOfOpLabel.setBounds(44, 225, 216, 33);
		mainFrame.add(typeOfOpLabel);
		
		JComboBox selectComboBox = new JComboBox();
		selectComboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
				String comboBSelection = null;
				
				if (selectComboBox.getSelectedIndex() == 1)
				{
					comboBSelection = "Addition";
					ConfirmationPage page = new ConfirmationPage(nameEnterTextField.getText(), Integer.parseInt(numOfProblemsTextField.getText()), Integer.parseInt(numOfDigitsTextField.getText()), comboBSelection);
					page.setVisible(true);
					frame.setVisible(false);
				} else if (selectComboBox.getSelectedIndex() == 2)
				{
					comboBSelection = "Subtraction";
					ConfirmationPage page = new ConfirmationPage(nameEnterTextField.getText(), Integer.parseInt(numOfProblemsTextField.getText()), Integer.parseInt(numOfDigitsTextField.getText()), comboBSelection);
					page.setVisible(true);
					frame.setVisible(false);
				} else if (selectComboBox.getSelectedIndex() == 3)
				{
					comboBSelection = "Multiplication";
					ConfirmationPage page = new ConfirmationPage(nameEnterTextField.getText(), Integer.parseInt(numOfProblemsTextField.getText()), Integer.parseInt(numOfDigitsTextField.getText()), comboBSelection);
					page.setVisible(true);
					frame.setVisible(false);
				} else if (selectComboBox.getSelectedIndex() == 4)
				{
					comboBSelection = "Division";
					ConfirmationPage page = new ConfirmationPage(nameEnterTextField.getText(), Integer.parseInt(numOfProblemsTextField.getText()), Integer.parseInt(numOfDigitsTextField.getText()), comboBSelection);
					page.setVisible(true);
					frame.setVisible(false);
				} else if (selectComboBox.getSelectedIndex() == 5)
				{
					String [] rArr = {"Addition", "Subtraction", "Multiplication", "Division"};
					
					SecureRandom rand = new SecureRandom();
					int selectRandom = rand.nextInt(rArr.length);
					String randSelection = rArr[selectRandom];
					comboBSelection = randSelection;
					
					ConfirmationPage page = new ConfirmationPage(nameEnterTextField.getText(), Integer.parseInt(numOfProblemsTextField.getText()), Integer.parseInt(numOfDigitsTextField.getText()), comboBSelection);
					page.setVisible(true);
					setVisible(false);
					
				}
			}
				

				catch(NumberFormatException exception)
				{
					System.out.println("Error occured!");
					
					if (numOfDigitsTextField.getText().equals("") || numOfProblemsTextField.getText().equals(""))
					{
						JOptionPane.showMessageDialog(null, "Please enter values in the provided spaces!", "Error", 2);
						selectComboBox.setSelectedIndex(0);
					} else
						
					{
						JOptionPane.showMessageDialog(null, "Please enter only numerical values in the provided spaces!", "Error", 2);
						selectComboBox.setSelectedIndex(0);
					}
					
					
				}
				
				
				
			}
		});
		selectComboBox.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		selectComboBox.setModel(new DefaultComboBoxModel(new String[] {"-Select-", "+", "-", "*", "/", "Random"}));
		selectComboBox.setBounds(247, 233, 94, 20);
		mainFrame.add(selectComboBox);
		
		JButton closeButton = new JButton("Close");
		closeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(mainFrame, "Thank you for using Arithmetic Helper!", "Thank you! :)", 1);
				System.exit(0);
			}
		});
		closeButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		closeButton.setBounds(29, 269, 100, 50);
		mainFrame.add(closeButton);
		
		JLabel titleLabel = new JLabel("ARITHMETIC HELPER");
		titleLabel.setForeground(Color.BLUE);
		titleLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 33));
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setBounds(10, 23, 376, 67);
		mainFrame.add(titleLabel);
		
		JButton clearButton = new JButton("Clear");
		clearButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nameEnterTextField.setText("");
				numOfDigitsTextField.setText("");
				numOfProblemsTextField.setText("");
				selectComboBox.setSelectedIndex(0);
			}
		});
		clearButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		clearButton.setBounds(148, 269, 100, 50);
		mainFrame.add(clearButton);
		
		JButton authorButton = new JButton("Author");
		authorButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JOptionPane.showMessageDialog(mainFrame, "Made by Jayden Sipe :)", "Author", 1);
			}
		});
		authorButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		authorButton.setBounds(268, 269, 100, 50);
		mainFrame.add(authorButton);
	}
}
