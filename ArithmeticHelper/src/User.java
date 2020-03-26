/*University of Central Florida
 COP 3330 Spring 2019
 Final Project
 Author: Jayden Sipe*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.Scanner;

public class User {
	
	public User(String name, double score)
	{
		
	}
	
	public static String getName()
	{
		return ConfirmationPage.name;
	}
	
	public static int getNumOfProblems()
	{
		return ConfirmationPage.numberOfProblems;
	}
	
	public static int getCorrectCounter()
	{
		return ProblemSolving.correctCounter;
	}
	
	public static long getTime()
	{
		return ProblemSolving.endTime - ProblemSolving.startTime;
	}

	public static double scoreAchieved()
	{
		return (((double)User.getTime() / (double)User.getNumOfProblems()) / 60.00 * getCorrectCounter() * 1000);
	}
	
	public static void printToFile() throws IOException
	{
		PrintWriter rankListOfUsers = new PrintWriter(new FileWriter("rankedList.txt", true));
		rankListOfUsers.println(getName());
		rankListOfUsers.println(scoreAchieved());
		rankListOfUsers.close();
		
	}
	

}
