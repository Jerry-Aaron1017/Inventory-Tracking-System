package finals_InventoryTrackingSys;

import java.io.*;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.file.*;
import java.nio.file.Paths;
import java.text.*;
import java.util.*;
import java.util.regex.*;
import java.util.regex.Pattern;

public class Logics_ProfileUser {
	static final File filePath = new File ("C:\\Users\\Jerry Aaron\\git\\Inventory-Tracking-System\\finals_InventoryTrackingSys\\src\\InventoryAccounts");
	
	// VARIABLES FOR COLOR/UI OUTPUT
	static String c_Red = "\u001B[31m";
    static String c_Green = "\u001B[32m";
    static String b_Texts = "\u001B[1m";
    static String u_Texts = "\u001B[4m";
    static String c_Reset = "\u001B[0m";
    
    // VARS FOR UI FORMAT
    final static String counterFormat = " ".repeat(53);
    final static String halfCF = " ".repeat(27);
    final static String repetition54 = " ".repeat(54);
	final static String repetition56 = " ".repeat(56);
	final static String centerRepeat = " ".repeat(75);
	final static String centerRepeat72 = " ".repeat(72);
	final static String centerRepeat73 = " ".repeat(73);
	final static String subCR65 = " ".repeat(65);
	final static String subCR57 = " ".repeat(57);
	final static String subCR55 = " ".repeat(55);
	final static String subCR54 = " ".repeat(54);
	final static String subCR52 = " ".repeat(52);
	final static String subCR53 = " ".repeat(53);
	final static String subCR50 = " ".repeat(50);
	final static String minorCR48 = " ".repeat(48);      // MINOR CENTER REPEAT
	final static String minorCR47 = " ".repeat(47);
	final static String minorCR45 = " ".repeat(45);
	final static String minorCR44 = " ".repeat(44);
	final static String minorCR43 = " ".repeat(43);
	
	final static String newLines5 = ("\n\n\n\n\n");
	
	final static String tab = "\t";
	final static String tabSpace = "\t ";
	final static String tabLine = "\t │ ";
	
	final static String b_verticalLine = b_Texts + "│" + c_Reset;
	final static String b_verticalSpacesLine = b_Texts + " │ " + c_Reset;
	
	// VARIABLE FOR DECISIONS
	String firstChoice;
	static String secondChoice;
    static String thirdChoice;
    static String fourthChoice;
    
    // VARIABLES FOR DATA HOLDER IN ACCOUNT
    static String userName;
    static String userPassword;
    static boolean passwordHolder;
    static boolean userNameHolder;
    static boolean flagName;
	static boolean flagPassword;
    static int retryCount = 0;
    
    static boolean continueAccessSystem = true;
    
    // ENUM CLASS
    static Enums_Constants enumShow = null;
    
    // METHODS
	Scanner scan = new Scanner(System.in);
	NumberFormat currency = NumberFormat.getCurrencyInstance();
	
	// FILE DECLARATIONS
	Path fPath = Paths.get(filePath.getAbsolutePath());
	FileWriter writer;
	FileReader fReader;
	
	public static void profileUser() {
		while(true) {
			try {
	        	// Method
	        	PrintWriter print = new PrintWriter(System.out);
	        	
	        	//Logic_Inventory METHOD
	        	Logics_ProfileUser mths = new Logics_ProfileUser();
	        	mths.writer = new FileWriter(mths.fPath.toString(), true);
	        	
	        	// UI Format: 
	        	int countFormat1 = 46;
	        	int countFormat2 = 22;
	        	String CF1 = " ".repeat(49);
	        	String CF2 = " ".repeat(51);
	        	String CF12 = " ".repeat(24);
	        	int CF22 = 23;
	        	
	        	print.println(newLines5);
	        	print.println("\t " + "┌" + "─".repeat(170) + "┐");
	        	String welcome = 
	        			"\t │ " + " ".repeat(countFormat1) + """
	        			███╗     ███╗████████╗███╗      ███████╗ ████████╗ ████╗    ████╗████████╗""" + CF1 + "│ \n"  
	        	        + "\t │ " + " ".repeat(countFormat1) + """
	        			███║     ███║███╔════╝███║     ███╔════╝███╔═══███╗█████╗  █████║███╔════╝""" + CF1 + "│ \n" 
	        			+ "\t │ " + " ".repeat(countFormat1) + """
	        	        ███║ ██╗ ███║██████╗  ███║     ███║     ███║   ███║███╔█████╔███║██████╗""" + CF2 + "│ \n" 
	        	        + "\t │ " +  " ".repeat(countFormat1) + """
	        	        ███║████╗███║███╔══╝  ███║     ███║     ███║   ███║███║╚███╔╝███║███╔══╝""" + CF2 + "│ \n" 
	        	        + "\t │ " +  " ".repeat(countFormat1) + """
	        	        ╚█████╔████╔╝████████╗████████╗╚███████╗╚████████╔╝███║ ╚══╝ ███║████████╗""" + CF1 + "│ \n" 
	        	        + "\t │ " +  " ".repeat(countFormat1 + 1) + """
	        	         ╚════╝╚═══╝ ╚═══════╝╚═══════╝ ╚══════╝ ╚═══════╝ ╚══╝      ╚══╝╚═══════╝""" + CF1 + "│" +
	        	        """
	        	        """;
        		
	        	print.println(welcome);
	        	print.println("\t " + "└" + "─".repeat(170) + "┘");
	        	print.println("\t " + "█".repeat(172));
	        	
	        	print.print("\n\n");
	        	//print.println("\t " + " ".repeat(52) + b_Texts + " Dynamic Inventory Tracking Logging System for Complex Accounting " + c_Reset);
	        	print.print("\t " + " ".repeat(52) + b_Texts);
	        	print.flush();
	        	
    	    	char chars [] = {'D','y','n','a','m','i','c',' ',
	    			'I','n','v','e','n','t','o','r','y',' ',
	    			'T','r','a','c','k','i','n','g',' ',
	    			'L','o','g','g','i','n','g',' ',
	    			'S','y','s','t','e','m',' ','f','o','r',' ',
	    			'C','o','m','p','l','e','x',' ',
	    			'A','c','c','o','u','n','t','i','n','g'};
    	    	
            	for (int num = 0; num < chars.length; num++) {
            	    try {
            	    	int numbering = 1;

            	    	
            	    	String str = new String (chars, num, numbering);
            	    	System.out.print(str);
            	    	
            	    	numbering++;
            	        Thread.sleep(25);
            	    } catch (InterruptedException e) {
            	        Thread.currentThread().interrupt();
            	    }
            	}
            	System.out.print(c_Reset);
    	        Thread.sleep(1000);

            	print.println(newLines5 + newLines5);
            	print.print("\t " + " ".repeat(62) + b_Texts + " Press 'Enter' to continue ");
            	print.flush();
            	            	
    	        Thread.sleep(1000);
            	for (int num = 0; num < 3; num++) {
            	    try {
            	    	System.out.print(". ");
            	        Thread.sleep(150);
            	    } catch (InterruptedException e) {
            	        Thread.currentThread().interrupt();
            	    }
            	}
            	String scanPrint = "";
            	while(true) { 	
	        	   
	            	try {
		            	System.out.print(scanPrint);
		            	String enteringSyst = mths.scan.nextLine();
		            	
		            	if(enteringSyst.isEmpty())
		            		enteringSyst = "0";
		            	else
		            		enteringSyst = "1";
		            	
		            	if(enteringSyst == "0")
		            		break;
		            	else if(enteringSyst == "1")
		            		scanPrint = ("\t " + " ".repeat(85));
		            		continue;
	            	}
	            	catch(Exception e) {
	            		e.getMessage();
	            	}
            	}	
	        	
            	for (int num = 0; num < 46; num++) {
            	    try {
            	    	System.out.print("\n");
            	        Thread.sleep(10);
            	    } catch (InterruptedException e) {
            	        Thread.currentThread().interrupt();
            	    }
            	}
            	
	        	print.println("\t " + "┌" + "─".repeat(170) + "┐");
	        	String profileUser = 
	        			"\t │ " + " ".repeat(countFormat2) + """
	        			█████████╗ █████████╗  █████████╗ █████████╗█████████╗███╗      ████████╗          ███╗   ███╗█████████╗████████╗█████████╗   """ + CF12 + "│ \n"  
	        	        + "\t │ " + " ".repeat(countFormat2) + """
	        			███    ███╗███╔═══███╗███╔════███║███╔═════╝   ███╔══╝███║      ███╔════╝          ███║   ███║███╔═════╝███╔════╝███╔═══███╗ """ + " ".repeat(CF22) + "│ \n" 
	        			+ "\t │ " + " ".repeat(countFormat2) + """
	        	        █████████╔╝█████████╔╝███║    ███║███████╗     ███║   ███║      ██████╗            ███║   ███║█████████╗██████╗  █████████╔╝ """ + " ".repeat(CF22) + "│ \n" 
	        	        + "\t │ " +  " ".repeat(countFormat2) + """
	        	        ███╔═════╝ ███╔═══███╗███║    ███║███╔═══╝     ███║   ███║      ███╔══╝            ███║   ███║╚═════███║███╔══╝  ███╔═══███╗ """ + " ".repeat(CF22) + "│ \n" 
	        	        + "\t │ " +  " ".repeat(countFormat2) + """
	        	        ███║       ███║   ███║╚█████████╔╝███║      █████████╗█████████╗████████╗          ╚████████╔╝█████████║████████╗███║   ███║ """ + " ".repeat(CF22) + "│ \n" 
	        	        + "\t │ " +  " ".repeat(countFormat2) + """
	        	        ╚══╝       ╚══╝   ╚══╝ ╚════════╝ ╚══╝      ╚════════╝╚════════╝╚═══════╝           ╚═══════╝ ╚════════╝╚═══════╝╚══╝   ╚══╝ """ + " ".repeat(CF22) + "│" +
	        	        """
	        	        """;
        		
	        	print.println(profileUser);
	        	print.println("\t " + "└" + "─".repeat(170) + "┘");
	        	print.println("\t " + "█".repeat(172));
	        	print.flush();
	        	
    	        Thread.sleep(50);
	        	
	        	System.out.println("\n");
	        	System.out.println(tabSpace + " " + "_".repeat(170));
	        	System.out.println("\n\n");
	        	System.out.println(tabSpace);
	        	
	        	System.out.println(centerRepeat +  b_Texts + "========================================" + c_Reset);
	            System.out.println(tabSpace + centerRepeat + " ".repeat(2) +  b_Texts + "ENTER YOUR PROFILE" + "   " + c_Reset);
	            
	            String firstLineOption = (tabSpace + minorCR44 + b_verticalLine + " ".repeat(36) + b_Texts + "USERNAME" + c_Reset + " ".repeat(38) + b_verticalLine);
	            String secondtLineOption = (tabSpace + minorCR44 + b_verticalLine + " ".repeat(36) + b_Texts + "PASSWORD" + c_Reset + " ".repeat(38) + b_verticalLine);
	            String usernameDescription1 = (tabSpace + minorCR44 + b_verticalLine + " ".repeat(23) + "Username must only contain " + b_Texts + c_Green + "letters" 
	            		   						+ c_Reset + " ".repeat(25) + b_verticalLine);
	            String passwordDescription1 = (tabSpace + minorCR44 + b_verticalLine + " ".repeat(17) + "Password must contain " + b_Texts + c_Green + "8 or more characters of" 
	            		                       + c_Reset + " ".repeat(20) + b_verticalLine);
	            String passwordDescription2 = (tabSpace + minorCR44 + b_verticalLine + " ".repeat(11) + b_Texts + c_Green +  "letters" + c_Reset + ", " + b_Texts  
	            		   + c_Green + "numbers" + c_Reset + "(" + b_Texts  + c_Green + "0-9" + c_Reset + "),"  + " and " + b_Texts + c_Green + "symbols" + c_Reset + "("
						   + b_Texts  + c_Green + "@" + c_Reset + ", " + b_Texts  + c_Green + "$" + c_Reset + ", " + b_Texts  + c_Green +"!" + c_Reset + ", " 
						   + b_Texts  + c_Green + "%" + c_Reset + ", " + b_Texts  + c_Green + "*" + c_Reset + ", " + b_Texts  + c_Green + "?" + c_Reset + ", or " 
						   + b_Texts  + c_Green + "&" + c_Reset + ")" + " ".repeat(13) + b_verticalLine);

	            String setterLine = (tabSpace + minorCR45 + c_Green + b_Texts +  " —> " + c_Reset);
	            String fillerLine = (tab + minorCR45 + b_Texts + "─".repeat(84) + c_Reset); 
	            String fillerLine1 = (tab + minorCR45 + b_Texts + "┌" + "─".repeat(82) + "┐" + c_Reset); 
	            String fillerLine2 = (tab + minorCR45 + b_Texts + "└" + "─".repeat(82) + "┘" + c_Reset); 
	            
	            System.out.println(fillerLine1);
				System.out.println(firstLineOption);
				System.out.println(usernameDescription1);
				System.out.println(fillerLine2);
				System.out.print(setterLine);
	            userName = mths.scan.nextLine().trim();
				System.out.print(fillerLine);
	            Logics_ProfileUser.usernameVerification();
	            
				System.out.println("\n\n\n");
	            if(userNameHolder){
		            System.out.println(fillerLine1);
		            System.out.println(secondtLineOption);
		            System.out.println(passwordDescription1);
		            System.out.println(passwordDescription2);
		            System.out.println(fillerLine2);
		            System.out.print(setterLine);
		            userPassword = mths.scan.nextLine().trim();
		            
		            print.println(fillerLine);
		            print.flush();
		            Logics_ProfileUser.passwordVerification();
	            }
	            // WRITE THE UserNAME and UserPass in the Texfile with a different logic and input
	            
	            Logics_ManageAccount.accountChecker();
	            Logics_ManageAccount.setContinueAccessSystem(true);
	            break;
			}
		
			catch(Exception e) {
				System.out.println("profileUser SOMETHING WENT WRONG" + e.getMessage());
			}
		}
	}
	
	// Duplicate BReAAAAAAAAAADCRUMBS
	public static void profileUserDuplicate() {
		while(true) {
			try {
	        	// Method
	        	PrintWriter print = new PrintWriter(System.out);
	        	
	        	//Logic_Inventory METHOD
	        	Logics_Inventory mths = new Logics_Inventory();
	        	mths.writer = new FileWriter(mths.fPath.toString(), true);
	        	
	        	// UI Format: 
	        	int countFormat2 = 22;
	        	String CF12 = " ".repeat(24);
	        	int CF22 = 23;
	        	print.println("\n");
	        	print.println("\t " + "┌" + "─".repeat(170) + "┐");
	        	String profileUser = 
	        			"\t │ " + " ".repeat(countFormat2) + """
	        			█████████╗ █████████╗  █████████╗ █████████╗█████████╗███╗      ████████╗          ███╗   ███╗█████████╗████████╗█████████╗   """ + CF12 + "│ \n"  
	        	        + "\t │ " + " ".repeat(countFormat2) + """
	        			███    ███╗███╔═══███╗███╔════███║███╔═════╝   ███╔══╝███║      ███╔════╝          ███║   ███║███╔═════╝███╔════╝███╔═══███╗ """ + " ".repeat(CF22) + "│ \n" 
	        			+ "\t │ " + " ".repeat(countFormat2) + """
	        	        █████████╔╝█████████╔╝███║    ███║███████╗     ███║   ███║      ██████╗            ███║   ███║█████████╗██████╗  █████████╔╝ """ + " ".repeat(CF22) + "│ \n" 
	        	        + "\t │ " +  " ".repeat(countFormat2) + """
	        	        ███╔═════╝ ███╔═══███╗███║    ███║███╔═══╝     ███║   ███║      ███╔══╝            ███║   ███║╚═════███║███╔══╝  ███╔═══███╗ """ + " ".repeat(CF22) + "│ \n" 
	        	        + "\t │ " +  " ".repeat(countFormat2) + """
	        	        ███║       ███║   ███║╚█████████╔╝███║      █████████╗█████████╗████████╗          ╚████████╔╝█████████║████████╗███║   ███║ """ + " ".repeat(CF22) + "│ \n" 
	        	        + "\t │ " +  " ".repeat(countFormat2) + """
	        	        ╚══╝       ╚══╝   ╚══╝ ╚════════╝ ╚══╝      ╚════════╝╚════════╝╚═══════╝           ╚═══════╝ ╚════════╝╚═══════╝╚══╝   ╚══╝ """ + " ".repeat(CF22) + "│" +
	        	        """
	        	        """;
        		
	        	print.println(profileUser);
	        	print.println("\t " + "└" + "─".repeat(170) + "┘");
	        	print.println("\t " + "█".repeat(172));
	        	print.flush();
	        	
	        	System.out.println("\n");
	        	System.out.println(tabSpace + " " + "_".repeat(170));
	        	System.out.println(tabSpace);
	        	
	        	System.out.println(centerRepeat +  b_Texts + "========================================" + c_Reset);
	            System.out.println(tabSpace + centerRepeat + " ".repeat(2) +  b_Texts + "ENTER YOUR PROFILE" + "   " + c_Reset);
	            
	            String firstLineOption = (tabSpace + minorCR44 + b_verticalLine + " ".repeat(36) + b_Texts + "USERNAME" + c_Reset + " ".repeat(38) + b_verticalLine);
	            String secondtLineOption = (tabSpace + minorCR44 + b_verticalLine + " ".repeat(36) + b_Texts + "PASSWORD" + c_Reset + " ".repeat(38) + b_verticalLine);
	            String usernameDescription1 = (tabSpace + minorCR44 + b_verticalLine + " ".repeat(23) + "Username must only contain " + b_Texts + c_Green + "letters" 
	            		   						+ c_Reset + " ".repeat(25) + b_verticalLine);
	            String passwordDescription1 = (tabSpace + minorCR44 + b_verticalLine + " ".repeat(17) + "Password must contain " + b_Texts + c_Green + "8 or more characters of" 
	            		                       + c_Reset + " ".repeat(20) + b_verticalLine);
	            String passwordDescription2 = (tabSpace + minorCR44 + b_verticalLine + " ".repeat(11) + b_Texts + c_Green +  "letters" + c_Reset + ", " + b_Texts  
	            		   + c_Green + "numbers" + c_Reset + "(" + b_Texts  + c_Green + "0-9" + c_Reset + "),"  + " and " + b_Texts + c_Green + "symbols" + c_Reset + "("
						   + b_Texts  + c_Green + "@" + c_Reset + ", " + b_Texts  + c_Green + "$" + c_Reset + ", " + b_Texts  + c_Green +"!" + c_Reset + ", " 
						   + b_Texts  + c_Green + "%" + c_Reset + ", " + b_Texts  + c_Green + "*" + c_Reset + ", " + b_Texts  + c_Green + "?" + c_Reset + ", or " 
						   + b_Texts  + c_Green + "&" + c_Reset + ")" + " ".repeat(13) + b_verticalLine);

	            String setterLine = (tabSpace + minorCR45 + c_Green + b_Texts +  " —> " + c_Reset);
	            String fillerLine = (tab + minorCR45 + b_Texts + "─".repeat(84) + c_Reset); 
	            String fillerLine1 = (tab + minorCR45 + b_Texts + "┌" + "─".repeat(82) + "┐" + c_Reset); 
	            String fillerLine2 = (tab + minorCR45 + b_Texts + "└" + "─".repeat(82) + "┘" + c_Reset); 
	            
	            System.out.println(fillerLine1);
				System.out.println(firstLineOption);
				System.out.println(usernameDescription1);
				System.out.println(fillerLine2);
				System.out.print(setterLine);
	            userName = mths.scan.nextLine().trim();
				System.out.print(fillerLine);
	            Logics_ProfileUser.usernameVerification();
	            
				System.out.println("\n\n\n");
	            if(userNameHolder){
		            System.out.println(fillerLine1);
		            System.out.println(secondtLineOption);
		            System.out.println(passwordDescription1);
		            System.out.println(passwordDescription2);
		            System.out.println(fillerLine2);
		            System.out.print(setterLine);
		            userPassword = mths.scan.nextLine().trim();
		            
		            print.println(fillerLine);
		            print.flush();
		            Logics_ProfileUser.passwordVerification();
	            }
	            
	            Logics_ManageAccount.accountChecker();
	            if (Logics_ManageAccount.getContinueAccessSystem()) {
	            	Logics_AccessSystem.firstDecisionDuplicate();
	            }
	            break;
			}
		
			catch(Exception e) {
				System.out.println("profileUser SOMETHING WENT WRONG" + e.getMessage());
			}
		}
	}
	
	public static void enterUsername(String userName) {
		Logics_ProfileUser.userName = userName;
	}
	
	public static void enterPassword(String userPassword) {
		Logics_ProfileUser.userPassword = userPassword;
	}
	
	public static String getEnteredUsername() {
		return userName;
	}
	
	public static String getEnteredPassword() {
		return userPassword;
	}
	
	
	// FOLLOW UP FOR RETRYING INPUT PASSWORD
	public static void retryUsername() {
	//Logic_Inventory METHOD
	Logics_Inventory mths = new Logics_Inventory();	
	
		while(true) {
			try {
				System.out.println(newLines5);
				System.out.println(centerRepeat +  b_Texts + "========================================" + c_Reset);
	            System.out.println(tabSpace + centerRepeat + " ".repeat(2) +  b_Texts + "RETRY YOUR PROFILE" + "   " + c_Reset);
	            
	            String firstLineOption = (tabSpace + minorCR44 + b_verticalLine + " ".repeat(36) + b_Texts + "USERNAME" + c_Reset + " ".repeat(38) + b_verticalLine);
	            
	            String usernameDescription1 = (tabSpace + minorCR44 + b_verticalLine + " ".repeat(23) + "Username must only contain " + b_Texts + c_Green + "letters" 
   											   + c_Reset + " ".repeat(25) + b_verticalLine);
	            
	            String setterLine = (tabSpace + minorCR45 + c_Green + b_Texts +  " —> " + c_Reset);
	            String fillerLine = (tab + minorCR45 + b_Texts +  "—".repeat(84) + c_Reset); 
	            String fillerLine1 = (tab + minorCR45 + b_Texts + "┌" + "─".repeat(82) + "┐" + c_Reset); 
	            String fillerLine2 = (tab + minorCR45 + b_Texts + "└" + "─".repeat(82) + "┘" + c_Reset); 
	            
	            System.out.println(fillerLine1);

				System.out.println(firstLineOption);
				System.out.println(usernameDescription1);
				System.out.println(fillerLine2);
				System.out.print(setterLine);
				userName = mths.scan.nextLine().trim();
	            System.out.println(fillerLine);
				Logics_ProfileUser.usernameVerification();
	            break;
			}
				
			catch (Exception e) {
				System.out.println("SOMETHING WENT WRONG IN retryUsername: " + e.getMessage());
			}
		}
	}
	
	// FOLLOW UP FOR RETRYING INPUT PASSWORD
	public static void retryPassword() {
		// Method
    	PrintWriter print = new PrintWriter(System.out);
		    	
		//Logic_Inventory METHOD
    	Logics_Inventory mths = new Logics_Inventory();
		while(true) {
			try {
				System.out.println(newLines5);
				System.out.println(centerRepeat +  b_Texts + "========================================" + c_Reset);
	            System.out.println(tabSpace + centerRepeat + " ".repeat(2) +  b_Texts + "RETRY YOUR PROFILE" + "   " + c_Reset);
	            
	            String firstLineOption = (tabSpace + minorCR44 + b_verticalLine + " ".repeat(36) + b_Texts + "USERNAME" + c_Reset + " ".repeat(38) + b_verticalLine);
	            String secondtLineOption = (tabSpace + minorCR44 + b_verticalLine + " ".repeat(36) + b_Texts + "PASSWORD" + c_Reset + " ".repeat(38) + b_verticalLine);
	            
	            String usernameDescription1 = (tabSpace + minorCR44 + b_verticalLine + " ".repeat(23) + "Username must only contain " + b_Texts + c_Green + "letters" 
	            							+ c_Reset + " ".repeat(25) + b_verticalLine);
	            
	            String passwordDescription1 = (tabSpace + minorCR44 + b_verticalLine + " ".repeat(17) + "Password must contain " + b_Texts + c_Green + "8 or more characters of" 
	            		                    + c_Reset + " ".repeat(20) + b_verticalLine);
	            
	            String passwordDescription2 = (tabSpace + minorCR44 + b_verticalLine + " ".repeat(11) + b_Texts + c_Green +  "letters" + c_Reset + ", " + b_Texts  
	            		   + c_Green + "numbers" + c_Reset + "(" + b_Texts  + c_Green + "0-9" + c_Reset + "),"  + " and " + b_Texts + c_Green + "symbols" + c_Reset + "("
						   + b_Texts  + c_Green + "@" + c_Reset + ", " + b_Texts  + c_Green + "$" + c_Reset + ", " + b_Texts  + c_Green +"!" + c_Reset + ", " 
						   + b_Texts  + c_Green + "%" + c_Reset + ", " + b_Texts  + c_Green + "*" + c_Reset + ", " + b_Texts  + c_Green + "?" + c_Reset + ", or " 
						   + b_Texts  + c_Green + "&" + c_Reset + ")" + " ".repeat(13) + b_verticalLine);
	            
	            String setterLine = (tabSpace + minorCR45 + c_Green + b_Texts +  " —> " + c_Reset);
	            String fillerLine = (tab + minorCR45 + b_Texts +  "—".repeat(84) + c_Reset); 
	            String fillerLine1 = (tab + minorCR45 + b_Texts + "┌" + "─".repeat(82) + "┐" + c_Reset); 
	            String fillerLine2 = (tab + minorCR45 + b_Texts + "└" + "─".repeat(82) + "┘" + c_Reset); 
	            
	            System.out.println(fillerLine1);

				System.out.println(firstLineOption);
				System.out.println(usernameDescription1);
				System.out.println(fillerLine2);
				System.out.print(setterLine);
	            System.out.println(userName);
	            
	            System.out.println(fillerLine);
	            
	            System.out.println(fillerLine1);
	            System.out.println(secondtLineOption);
	            System.out.println(passwordDescription1);
	            System.out.println(passwordDescription2);
	            
	            System.out.println(fillerLine2);
	            System.out.print(setterLine);
	            userPassword = mths.scan.nextLine();
	            
	            print.println(fillerLine);
	            print.flush();
	            Logics_ProfileUser.passwordVerification();
	            break;
			}
				
			catch (Exception e) {
				System.out.println("SOMETHING WENT WRONG IN retryPassword: " + e.getMessage());
			}
		}
	}
	
	public static void usernameVerification(){
		// METHOD
		PrintWriter print = new PrintWriter (System.out);
		
		while(true) {
			try {
				String fillerLine = (tab + minorCR45 + b_Texts +  "—".repeat(84) + c_Reset);
				print.println(fillerLine);
				Pattern p1 = Pattern.compile("[a-zA-Z ]+");
				Matcher mPass1 = p1.matcher(userName);

				if(mPass1.matches()) userNameHolder = true;
				
				else {
					userNameHolder = false;
					print.println(tabSpace + subCR55 + b_Texts + "Username must only contain " + c_Red + "letters..." + c_Reset);
				}
			}
			
			catch(Exception e){
				System.out.println("SOMETHING WENT WRONG IN usernameVerification: " + e.getMessage());
			}
			
			finally {
				retryCount += 1;
				
				if(userNameHolder) retryCount = 0;
				
				if (Logics_ProfileUser.getUsernameVerification() == false) {
					if (retryCount == 3) {
						Logics_ProfileUser.retryCountNoticeUsername();
						break;
					}
				}
				
				if (Logics_ProfileUser.getUsernameVerification()) {
					break;
				}
				
				else if (Logics_ProfileUser.getUsernameVerification() == false){
					Logics_ProfileUser.retryUsername();
					break;
				}
			}
		}
	}
	
	// NOTICE FOR FAILIND FOR THE 3rd TIME
	public static void retryCountNoticeUsername() {
		try {
			System.out.println(tabSpace + subCR55 + b_Texts + "NOTICE OF OVERREACHING" + c_Reset);
		}
		
		catch (Exception e) {
			System.out.println("SOMETHING WENT WRONG IN retryCountNotice: " + e.getMessage());
		}
		
		finally {
			retryCount = 0;
			Logics_ProfileUser.retryUsername();
		}
	}
	
	// RETURNS THE BOOLEAN VALUE OF THE PASSWORD VERIFICATION
	public static boolean getUsernameVerification() {
		return userNameHolder;
	}
	
	public static void passwordVerification() {
		while(true) {
			try {
				Pattern p1 = Pattern.compile("[a-zA-Z]+");
				Pattern p2 = Pattern.compile("[0-9]+");
				Pattern p3 = Pattern.compile("^(?=.*[@$!%*?&])");
				Pattern p4 = Pattern.compile("[a-zA-Z0-9@$!%*?&]{8,}");
				
				Matcher mPass1 = p1.matcher(userPassword);
				Matcher mPass2 = p2.matcher(userPassword);
				Matcher mPass3 = p3.matcher (userPassword);
				Matcher mPass4 = p4.matcher (userPassword);
				
				if(mPass1.find()) {
					if(mPass2.find()) {
						if(mPass3.find()) {
							if(mPass4.matches()) {
								passwordHolder = mPass4.matches();
							}
							else {
								passwordHolder = false;
								System.out.println(tabSpace + subCR55 + b_Texts + "Password must contain " + c_Red + "8 (Eight) characters..." + c_Reset);
							}
						}
						else {
							passwordHolder = false;
							System.out.println(tabSpace + subCR55 + b_Texts + "Password must contain "+ c_Red + "symbols..." + c_Reset);
						}
					}
					else {
						passwordHolder = false;
						System.out.println(tabSpace + subCR55 + b_Texts + "Password must contain " + c_Red + "numbers..." + c_Reset);
					}
				}
				else {
					passwordHolder = false;
					System.out.println(tabSpace + subCR55 + b_Texts + "Password must contain " + c_Red + "letters..." + c_Reset);
				}
			}
			
			catch (Exception e) {
				System.out.println("SOMETHING WENT WRONG IN passwordVerification: " + e.getMessage());
			}
			
			finally {
				retryCount += 1;
				
				if(passwordHolder) retryCount = 0;
				
				if (Logics_ProfileUser.getPasswordVerification() == false) {
					if (retryCount == 3) {
						Logics_ProfileUser.retryCountNoticePassword();
						break;
					}
				}
				
				if (Logics_ProfileUser.getPasswordVerification()) {
					break;
				}
				
				else if (Logics_ProfileUser.getPasswordVerification() == false){
					Logics_ProfileUser.retryPassword();
					break;
				}
			}
		}
	}
	
	// NOTICE FOR FAILIND FOR THE 3rd TIME
	public static void retryCountNoticePassword() {
		try {
			System.out.println(tabSpace + subCR55 + b_Texts + "NOTICE OF OVERREACHING password" + c_Reset);
		}
		
		catch (Exception e) {
			System.out.println("SOMETHING WENT WRONG IN retryCountNotice: " + e.getMessage());
		}
		
		finally {
			retryCount = 0;
			Logics_ProfileUser.retryPassword();
		}
	}
	
	// RETURNS THE BOOLEAN VALUE OF THE PASSWORD VERIFICATION
	public static boolean getPasswordVerification() {
		return passwordHolder;
	}
}
