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

import jdk.internal.math.FormattedFloatingDecimal;

import java.awt.Toolkit;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.TimeUnit;
import java.awt.event.ActionEvent;

public class ResultsPage extends JFrame {

	private JPanel contentPane;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ResultsPage frame = new ResultsPage();
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
	public ResultsPage() {
		setResizable(false);
		setTitle("Results");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 366, 406);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(50, 205, 50));
		contentPane.setBorder(new MatteBorder(5, 5, 5, 5, (Color) new Color(255, 165, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Arithmetic Helper Results");
		lblNewLabel.setForeground(new Color(255, 204, 51));
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 23));
		lblNewLabel.setBounds(26, -14, 300, 99);
		contentPane.add(lblNewLabel);
		
		JLabel lblPlayerName = new JLabel("Player Name:");
		lblPlayerName.setForeground(new Color(255, 255, 102));
		lblPlayerName.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		lblPlayerName.setBounds(36, 49, 120, 43);
		contentPane.add(lblPlayerName);
		
		JLabel playerNameTextField = new JLabel(User.getName());
		playerNameTextField.setForeground(new Color(255, 255, 102));
		playerNameTextField.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		playerNameTextField.setBounds(142, 49, 120, 43);
		contentPane.add(playerNameTextField);
		
		JLabel lblNumberOfProblems = new JLabel("Number of Problems:");
		lblNumberOfProblems.setForeground(new Color(255, 255, 102));
		lblNumberOfProblems.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		lblNumberOfProblems.setBounds(36, 85, 161, 43);
		contentPane.add(lblNumberOfProblems);
		
		JLabel numberOfProblemsTextField = new JLabel(Integer.toString(User.getNumOfProblems()));
		numberOfProblemsTextField.setForeground(new Color(255, 255, 102));
		numberOfProblemsTextField.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		numberOfProblemsTextField.setBounds(200, 85, 130, 43);
		contentPane.add(numberOfProblemsTextField);
		
		JLabel lblProblemsCorrect = new JLabel("Problems Correct:");
		lblProblemsCorrect.setForeground(new Color(255, 255, 102));
		lblProblemsCorrect.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		lblProblemsCorrect.setBounds(36, 121, 142, 43);
		contentPane.add(lblProblemsCorrect);
		
		JLabel label = new JLabel(Integer.toString(User.getCorrectCounter()));
		label.setForeground(new Color(255, 255, 102));
		label.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		label.setBounds(180, 121, 130, 43);
		contentPane.add(label);
		
		JLabel lblTimeTaken = new JLabel("Time Taken:");
		lblTimeTaken.setForeground(new Color(255, 255, 102));
		lblTimeTaken.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		lblTimeTaken.setBounds(36, 157, 99, 43);
		contentPane.add(lblTimeTaken);
		
		JLabel lblAverageTimeTaken = new JLabel("Average Time per Problem:");
		lblAverageTimeTaken.setForeground(new Color(255, 255, 102));
		lblAverageTimeTaken.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		lblAverageTimeTaken.setBounds(36, 193, 207, 43);
		contentPane.add(lblAverageTimeTaken);
		
		JLabel lblAverageScore = new JLabel("Average Score:");
		lblAverageScore.setForeground(new Color(255, 255, 102));
		lblAverageScore.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		lblAverageScore.setBounds(36, 229, 120, 43);
		contentPane.add(lblAverageScore);
		
		JLabel lblScoreAchieved = new JLabel("Score Achieved:");
		lblScoreAchieved.setForeground(new Color(255, 255, 102));
		lblScoreAchieved.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		lblScoreAchieved.setBounds(36, 265, 130, 43);
		contentPane.add(lblScoreAchieved);
		
		JButton btnNewButton = new JButton("Finish");
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
				System.exit(0);
				
				
				
				
			}
		});
		btnNewButton.setBounds(26, 327, 99, 29);
		contentPane.add(btnNewButton);
		
		JButton btnRankList = new JButton("History");
		btnRankList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				HistoryPage hp = new HistoryPage();
				hp.setVisible(true);
				setVisible(false);
			}
		});
		btnRankList.setBounds(227, 327, 99, 29);
		contentPane.add(btnRankList);
		
		double average = ((double) User.getCorrectCounter() / (double) User.getNumOfProblems()) * 100;
		
		String formattedAverage = String.format("%.2f", average);
		JLabel label_1 = new JLabel(formattedAverage + "%");
		label_1.setForeground(new Color(255, 255, 102));
		label_1.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		label_1.setBounds(156, 229, 130, 43);
		contentPane.add(label_1);
		
		
		JLabel timeTakenTextField = new JLabel(User.getTime() / 60 + " Minutes " + User.getTime() % 60+ " Seconds");
		timeTakenTextField.setForeground(new Color(255, 255, 102));
		timeTakenTextField.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		timeTakenTextField.setBounds(130, 157, 261, 43);
		contentPane.add(timeTakenTextField);
		
		double avgTime = ((double)User.getTime() / (double)User.getNumOfProblems()) / 60;
		String formattedAvgTime = String.format("%.3f", avgTime);
		JLabel avgTimeTaken = new JLabel(formattedAvgTime + " mins");
		avgTimeTaken.setForeground(new Color(255, 255, 102));
		avgTimeTaken.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		avgTimeTaken.setBounds(245, 193, 107, 43);
		contentPane.add(avgTimeTaken);
		
		String formattedScore = String.format("%.2f", User.scoreAchieved());
		
		JLabel label_2 = new JLabel(formattedScore);
		label_2.setForeground(new Color(255, 255, 102));
		label_2.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		label_2.setBounds(165, 265, 130, 43);
		contentPane.add(label_2);
	}
}
