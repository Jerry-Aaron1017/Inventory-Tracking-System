package finals_InventoryTrackingSys;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Logics_Item {
	static final File filePath = new File ("C:\\Users\\Jerry Aaron\\git\\Inventory-Tracking-System\\finals_InventoryTrackingSys\\src\\InventoryData");
	
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
	final static String minorCR43 = " ".repeat(43);
	
	final static String newLines = ("\n\n\n\n\n");
	
	final static String tab = "\t";
	final static String tabSpace = "\t ";
	final static String tabLine = "\t | ";
	
	final static String b_verticalLine = b_Texts + "|" + c_Reset;
	final static String b_verticalSpacesLine = b_Texts + " | " + c_Reset;
	
	
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
	

    
    // ASKS THE USER TO INPUT A DECISION TO ACCESS
    public static void chooseItemOption(){
    	//MEHODS
    	Logics_Item mths = new Logics_Item();
    	Logics_AllDecisions logics_AllDecisions = new Logics_AllDecisions();
    	PrintWriter print = new PrintWriter(System.out);
    	
		// VARIABLE
    	int numRepItem = 63;
    	
    	try {
    		print.println("\n");
        	print.println("\t " + b_Texts + "—".repeat(172) + c_Reset);
	    	final String addingItem = tabLine + " ".repeat(numRepItem) + """
	    			█████████╗███████████╗█████████╗████╗    ████╗""" + " ".repeat(60) + "| \n" +
	    			tabLine + " ".repeat(numRepItem + 3) + """
	    			   ███╔══╝    ███╔═══╝███╔═════╝█████╗  █████║""" + " ".repeat(60) + "| \n" +
	    			tabLine + " ".repeat(numRepItem + 3) + """
	    			   ███║       ███║    ██████╗   ███╔█████╔███║""" + " ".repeat(60) + "| \n" +
	    			tabLine + " ".repeat(numRepItem + 3) + """ 
	    			   ███║       ███║    ███╔══╝   ███║╚███╔╝███║""" + " ".repeat(60) + "| \n" +
	    			tabLine + " ".repeat(numRepItem) + """
	    			█████████╗    ███║    █████████╗███║ ╚══╝ ███║""" + " ".repeat(60) + "| \n" +
	    			tabLine + " ".repeat(numRepItem) + """
	    			╚════════╝    ╚══╝    ╚════════╝╚══╝      ╚══╝""" + " ".repeat(60) + "|" + """
	    			""";
    		print.println(addingItem);
    		print.println(tabSpace + "—".repeat(172));
        	print.println(tabSpace + "█".repeat(172));
        	print.println("\n");
			print.println(tabSpace + " " + "—".repeat(170));
    		print.flush();
    		
    		System.out.println(tabSpace);
        	System.out.println(" ".repeat(76) +  b_Texts + "========================================" + c_Reset);

	    	System.out.println(tabSpace + " ".repeat(80) + b_Texts + "Access Item to".toUpperCase() + c_Reset);
            System.out.println(tabSpace + " ".repeat(46) + b_Texts +  "—".repeat(80) + "" + c_Reset);

	    	System.out.print(subCR55 + " " + b_verticalLine + "  [" + b_Texts + "1" + c_Reset + "]" + b_Texts + " Show an Item" + c_Reset);
	        System.out.println(" ".repeat(20) + b_verticalLine + " ".repeat(15) + "[" + b_Texts + "2" + c_Reset + "]" + b_Texts + " Add an Item" + " ".repeat(7) + b_verticalLine + c_Reset);
	        System.out.println(tabSpace + " ".repeat(46) + b_Texts +  "—".repeat(80) + c_Reset);
	        System.out.print(subCR55 + " " + b_verticalLine + "  [" + b_Texts + "3" + c_Reset + "]" + b_Texts + " Remove an Item" + c_Reset);
	        System.out.println(" ".repeat(18) + b_verticalLine + " ".repeat(15) + "[" + b_Texts + "4" + c_Reset + "]" + b_Texts + " Exit and Go Back  " + b_verticalLine + c_Reset);
	        System.out.println(tabSpace + " ".repeat(46) + b_Texts + "" +  "—".repeat(80) + "" + c_Reset);
	        System.out.print(subCR55 + b_Texts + " —> " + c_Reset);
	        String setItemDecision = mths.scan.nextLine().trim();
	        logics_AllDecisions.setThirdDecision(setItemDecision);
    	}
    	
    	catch(Exception e){
    		System.out.println("\t | SOMETHING WENT WRONG IN INVENTORY OPTION: " + e.getMessage());
    	}
    }

    @SuppressWarnings("finally")
    public static void chooseItemOptionDuplicate(){
    	//MEHODS
    	Logics_Item mths = new Logics_Item();
    	PrintWriter print = new PrintWriter(System.out);
    	
		// VARIABLE
    	int numRepItem = 63;
    	
    	while(true) {
	    	try {
	    		print.println("\n");
	        	print.println("\t " + b_Texts + "—".repeat(172) + c_Reset);
		    	final String addingItem = tabLine + " ".repeat(numRepItem) + """
		    			█████████╗███████████╗█████████╗████╗    ████╗""" + " ".repeat(60) + "| \n" +
		    			tabLine + " ".repeat(numRepItem + 3) + """
		    			   ███╔══╝    ███╔═══╝███╔═════╝█████╗  █████║""" + " ".repeat(60) + "| \n" +
		    			tabLine + " ".repeat(numRepItem + 3) + """
		    			   ███║       ███║    ██████╗   ███╔█████╔███║""" + " ".repeat(60) + "| \n" +
		    			tabLine + " ".repeat(numRepItem + 3) + """ 
		    			   ███║       ███║    ███╔══╝   ███║╚███╔╝███║""" + " ".repeat(60) + "| \n" +
		    			tabLine + " ".repeat(numRepItem) + """
		    			█████████╗    ███║    █████████╗███║ ╚══╝ ███║""" + " ".repeat(60) + "| \n" +
		    			tabLine + " ".repeat(numRepItem) + """
		    			╚════════╝    ╚══╝    ╚════════╝╚══╝      ╚══╝""" + " ".repeat(60) + "|" + """
		    			""";
	    		print.println(addingItem);
	    		print.println(tabSpace + "—".repeat(172));
	        	print.println(tabSpace + "█".repeat(172));
	        	
    			print.println("\n");
    			print.println(tabSpace + " " + "—".repeat(170));
	    		print.flush();
	    	}
	    	
	    	catch(Exception e){
	    		System.out.println("\t | SOMETHING WENT WRONG IN INVENTORY OPTION: " + e.getMessage());
	    	}
	    	
	    	finally {
				// Internal Decision to repeat or to choose other Action
				System.out.println(tabSpace);
				System.out.println("\n");
				print.println(tabSpace + b_Texts + "—".repeat(170));
	        	System.out.println(centerRepeat +  b_Texts + "============================================" + c_Reset);
	
		    	System.out.println(tabSpace + " ".repeat(72) + b_Texts + "CHOOSE AGAIN OR EXIT THE PROGRAM" + c_Reset);
	            System.out.println(tabSpace + " ".repeat(46) + b_Texts + "" +  "—".repeat(80) + "" + c_Reset);
	
		    	System.out.print(subCR55 + " " + b_verticalLine + "  [" + b_Texts + "1" + c_Reset + "]" + b_Texts + " Show an Item" + c_Reset);
		        System.out.println(" ".repeat(20) + b_verticalLine + " ".repeat(15) + "[" + b_Texts + "2" + c_Reset + "]" + b_Texts + " Add an Item" + " ".repeat(7) + b_verticalLine + c_Reset);
		        System.out.println(tabSpace + " ".repeat(46) + b_Texts +  "—".repeat(80) + c_Reset);
		        System.out.print(subCR55 + " " + b_verticalLine + "  [" + b_Texts + "3" + c_Reset + "]" + b_Texts + " Remove an Item" + c_Reset);
		        System.out.println(" ".repeat(18) + b_verticalLine + " ".repeat(15) + "[" + b_Texts + "4" + c_Reset + "]" + b_Texts + " Exit and Go Back  " + b_verticalLine + c_Reset);
		        System.out.println(tabSpace + " ".repeat(46) + b_Texts + "" +  "—".repeat(80) + "" + c_Reset);
		        System.out.print(subCR55 + b_Texts + " —> " + c_Reset);
		        String numOrStr = mths.scan.nextLine().trim();
				
				System.out.println(newLines);
				if (numOrStr.equalsIgnoreCase("Show") || numOrStr.equalsIgnoreCase("Show an item") || numOrStr.equals("1")) {
					Logics_Item.getItemOrItems();   	
					break;
				}
				
				else if (numOrStr.equalsIgnoreCase("Add") || numOrStr.trim().equalsIgnoreCase("Add an Item") || numOrStr.equals("2")) {
					Logics_Item.setItem();    	                                    
					break;
				}
				
				else if (numOrStr.equalsIgnoreCase("Remove") || numOrStr.trim().equalsIgnoreCase("Remove an Item") || numOrStr.equals("3")) {
					Logics_Item.removeItem();
					break;
	    		}
				
				else if (numOrStr.equalsIgnoreCase("Exit") || numOrStr.trim().equalsIgnoreCase("Exit and Go Back") || numOrStr.equals("4")) {
					Logics_AccessSystem.firstDecisionDuplicate();
					break;
				}
				
				else {
					System.out.println("\t | Try Again:");
					Logics_Item.repeatingChooseAgainItem();
					break;
				}
    		}
    	}
    }

	public static void getItemOrItems() {
    	// METHODS // OBJECTS
		Logics_Item mths = new Logics_Item();
    	PrintWriter print = new PrintWriter(System.out);
    	
    	//VARIABLES // UI
    	String decisionHolder;
    	
    	while(true) {
	    	try {
    			print.println("\n");
    			print.println(tabSpace + " " + "—".repeat(170));
    			print.flush();
	    		System.out.println(tabSpace);
	        	System.out.println(" ".repeat(76) +  b_Texts + "========================================" + c_Reset);

		    	System.out.println(tabSpace + " ".repeat(74) + b_Texts + "Access the List or an Item".toUpperCase() + c_Reset);
	            System.out.println(tabSpace + " ".repeat(58) + b_Texts +  "—".repeat(58) + "" + c_Reset);

		    	System.out.print(" ".repeat(68) + b_verticalLine + "  [" + b_Texts + "1" + c_Reset + "]" + b_Texts + " Show List" + c_Reset);
		        System.out.println(" ".repeat(11) + b_verticalLine + " ".repeat(9) + "[" + b_Texts + "2" + c_Reset + "]" + b_Texts + " Show an Item" + "  " + b_verticalLine + c_Reset);
		        System.out.println(tabSpace + " ".repeat(58) + b_Texts +  "—".repeat(58) + c_Reset);
		        System.out.println(" ".repeat(68) + b_verticalLine + " ".repeat(17) + "[" + b_Texts + "3" + c_Reset + "]" + b_Texts + " Exit and Go Back" + " ".repeat(17) + b_verticalLine +  c_Reset);
		        System.out.println(tabSpace + " ".repeat(58) + b_Texts +  "—".repeat(58) + c_Reset);
		        System.out.print(" ".repeat(68) + b_Texts + " —> " + c_Reset);
		        decisionHolder = mths.scan.nextLine();
	    		
	    		if(decisionHolder.equalsIgnoreCase("Show List") || decisionHolder.equalsIgnoreCase("List") || decisionHolder.equals("1")) {
	    			Logics_Item.getItemList();
    				break;
	    		}
	    		
		    	else if (decisionHolder.equalsIgnoreCase("Show an Item") || decisionHolder.equalsIgnoreCase("Item") ||  decisionHolder.equals("2")) {
		    		Logics_Item.getSingleItem();
		    		break;
	    		}
	    		
		    	else if (decisionHolder.equalsIgnoreCase("Exit") || decisionHolder.equalsIgnoreCase("Exit and Go Back") ||  decisionHolder.equals("3")){
		    		chooseItemOptionDuplicate();
		    		break;
		    	}
	    		
		    	else {
		    		System.out.println(tabLine + "TRY AGAIN");
		    		continue;
		    	}
	    	}
	    	
	    	catch(Exception e){
	    		System.out.println(e.getMessage());
	    	}
    	}
    }
    
    @SuppressWarnings("finally")
    public static void getItemList(){
    	// METHODS // OBJECTS
    	Logics_Item mths = new Logics_Item();
    	PrintWriter print = new PrintWriter(System.out);
    	
    	//VARIABLES // UI
    	final String rep20 = " ".repeat(20);
    	final String itemFormat = " ".repeat(33);
    	final String spacerFormat = " ".repeat(3);
		
		while(true){
			try {		
				print.println("\n");
		    	print.println("\t " + b_Texts + "—".repeat(172) + c_Reset);
				String itemList = tabLine + itemFormat + """
		    			█████████╗███████████╗█████████╗████╗    ████╗       ███╗      █████████╗█████████╗███████████╗     """ + " ".repeat(41) + "| \n" +
		    			tabLine + itemFormat + spacerFormat + """
		    			   ███╔══╝    ███╔═══╝███╔═════╝█████╗  █████║       ███║         ███╔══╝███╔═════╝    ███╔═══╝     """ + " ".repeat(41) + "| \n" +
		    			tabLine + itemFormat + spacerFormat + """
		    			   ███║       ███║    ██████╗   ███╔█████╔███║       ███║         ███║   █████████╗    ███║         """ + " ".repeat(45) + "| \n" +
		    			tabLine + itemFormat + spacerFormat + """    
		    			   ███║       ███║    ███╔══╝   ███║╚███╔╝███║       ███║         ███║   ╚═════███║    ███║         """ + " ".repeat(45) + "| \n" +
		    			tabLine + itemFormat + """
		    			█████████╗    ███║    █████████╗███║ ╚══╝ ███║       █████████╗█████████╗█████████║    ███║         """ + " ".repeat(45) + "| \n" +
		    			tabLine + itemFormat + """
		    			╚════════╝    ╚══╝    ╚════════╝╚══╝      ╚══╝       ╚════════╝╚════════╝╚════════╝    ╚══╝         """ + " ".repeat(45) + "|" + """
		    			""";
				print.println(itemList);
				print.println(tabSpace + "—".repeat(172));
		    	print.println(tabSpace + "█".repeat(172));
		
				print.println("\n");
				print.println(tabSpace + " " + "—".repeat(170));
				print.println(tabSpace + centerRepeat + " ".repeat(4) + b_Texts + "ITEM LIST" + c_Reset); 
				print.println(tabSpace + b_Texts + "—".repeat(172) + c_Reset);
				
				String [] label = {"Items", "Quantity", "Price", "Total Amount", "Group or Category", "Date of Expiration"};
				String blockForCategories = tabLine + rep20 + b_Texts
						+ label[0] + " ".repeat(27 - (label[0].length())) + b_verticalLine + " ".repeat(8) // ITEMS
						+ label[1] + " ".repeat(14 - (label[1].length())) + b_verticalLine + " ".repeat(8) // QUANTITY
						+ label[2] + " ".repeat(14 - (label[2].length())) + b_verticalLine + " ".repeat(5) // PRICE
						+ label[3] + " ".repeat(17 - (label[3].length())) + b_verticalLine + " ".repeat(18) // PRICE
						+ label[4] + " ".repeat(29 - (label[3].length())) + b_verticalLine + // GROUP OR CATEGORY
						c_Reset;
				print.println(blockForCategories);
				print.println(tabSpace + b_Texts + "—".repeat(172) + c_Reset);
				print.flush();
				
				FileReader fR = new FileReader(mths.fPath.toString());
				BufferedReader brIL = new BufferedReader(fR);
				String LINE;
				
				while((LINE = brIL.readLine()) != null) {
					String DATA [] = LINE.split(";");
					if (DATA [3].equals ("none") == false){
		    			for (int numHolder = 0; numHolder < 1; numHolder++) {
		    				System.out.print(tabSpace + b_verticalLine + " ".repeat(7) + " ".repeat(40 - DATA[3].length()) + DATA [3] + b_verticalSpacesLine);
		    			}
		    			for (int numHolder = 0; numHolder < 1; numHolder++) {
		    				System.out.print(DATA [4] + " ".repeat(20 - DATA[4].length()) + b_verticalSpacesLine);
		    			}
		    			
		    			for (int numHolder = 0; numHolder < 1; numHolder++) {
		    				double data4 = (double) Double.parseDouble(DATA [5]);
		    				String STR5 = mths.currency.format(data4);
		    				System.out.print(STR5 + " ".repeat(20 - STR5.length()) + b_verticalSpacesLine);
		    			}
		    			
		    			for (int numHolder = 0; numHolder < 1; numHolder++) {
		    				System.out.print(DATA [6] + " ".repeat(20 - DATA[6].length()) + b_verticalSpacesLine);
		    			}
		    			
		    			for (int numHolder = 0; numHolder < 1; numHolder++) {
		    				System.out.println(DATA [7] + " ".repeat(50 - DATA[7].length()) + b_verticalSpacesLine);
		    			}
					}
				}
				System.out.println(tabSpace + b_Texts + "—".repeat(172) + c_Reset);
				brIL.close();
			}
			
    		
	    	catch(Exception e){
	    		System.out.println(e.getMessage());
	    	}
    		
    		finally {
    			System.out.println(newLines);
	    		System.out.println(tabSpace + " " + "—".repeat(170));
	    		System.out.println(tabSpace);
	        	System.out.println(" ".repeat(76) +  b_Texts + "========================================" + c_Reset);

		    	System.out.println(tabSpace + " ".repeat(74) + b_Texts + "Access the List or an Item".toUpperCase() + c_Reset);
	            System.out.println(tabSpace + " ".repeat(58) + b_Texts +  "—".repeat(58) + "" + c_Reset);

		    	System.out.print(" ".repeat(68) + b_verticalLine + "  [" + b_Texts + "1" + c_Reset + "]" + b_Texts + " Show List" + c_Reset);
		        System.out.println(" ".repeat(11) + b_verticalLine + " ".repeat(9) + "[" + b_Texts + "2" + c_Reset + "]" + b_Texts + " Show an Item" + "  " + b_verticalLine + c_Reset);
		        System.out.println(tabSpace + " ".repeat(58) + b_Texts +  "—".repeat(58) + c_Reset);
		        System.out.println(" ".repeat(68) + b_verticalLine + " ".repeat(17) + "[" + b_Texts + "3" + c_Reset + "]" + b_Texts + " Exit and Go Back" + " ".repeat(17) + b_verticalLine +  c_Reset);
		        System.out.println(tabSpace + " ".repeat(58) + b_Texts +  "—".repeat(58) + c_Reset);
		        System.out.print(subCR55 + b_Texts + " —> " + c_Reset);
		        String numOrStr = mths.scan.nextLine();
		        
		        if (numOrStr.equalsIgnoreCase("Show List") || numOrStr.equalsIgnoreCase("List") || numOrStr.equals("1")){
		        	Logics_Item.getItemList();
		        	break;
		        }
		        
		    	else if (numOrStr.equalsIgnoreCase("Show an Item") || numOrStr.equalsIgnoreCase("Item") ||  numOrStr.equals("2")) {
		    		Logics_Item.getSingleItem();
		    		break;
	    		}
		        
		        else if (numOrStr.equalsIgnoreCase("Exit") || numOrStr.equalsIgnoreCase("Exit and Go Back") ||  numOrStr.equals("3")){
		    		chooseItemOptionDuplicate();
		    		break;
		    	}
		        
		    	else {
		    		System.out.println(tabLine + "TRY AGAIN");
		    		continue;
		    	}
    		}
		}
    }
    
    @SuppressWarnings("finally")
    private static void getSingleItem() {
    	// METHODS // OBJECTS
    	Logics_Item mths = new Logics_Item();
    	PrintWriter print = new PrintWriter(System.out);
    	
    	//VARIABLES // UI
    	final String rep20 = " ".repeat(20);
    	int numRepItem = 27;
    	
    	while(true) {
    		try {
				FileReader fR = new FileReader(mths.fPath.toString());
				BufferedReader brIL2 = new BufferedReader(fR);
				String LINE2;

	    		print.println("\n");
	        	print.println("\t " + b_Texts + "—".repeat(172) + c_Reset);
		    	final String addingItem = tabLine + " ".repeat(numRepItem) + """
		    			█████████╗█████████╗█████╗  ███╗ ████████╗███╗      █████████╗       █████████╗███████████╗█████████╗████╗    ████╗""" + " ".repeat(27) + "| \n" +
		    			tabLine + " ".repeat(numRepItem) + """
		    			███╔═════╝   ███╔══╝██████╗ ███║███╔═════╝███║      ███╔═════╝          ███╔══╝    ███╔═══╝███╔═════╝█████╗  █████║""" + " ".repeat(27) + "| \n" +
		    			tabLine + " ".repeat(numRepItem) + """
		    			█████████╗   ███║   ███╔███╗███║███║ ████╗███║      ██████╗             ███║       ███║    ██████╗   ███╔█████╔███║""" + " ".repeat(27) + "| \n" +
		    			tabLine + " ".repeat(numRepItem) + """ 
		    			╚═════███║   ███║   ███║╚██████║███║  ███║███║      ███╔══╝             ███║       ███║    ███╔══╝   ███║╚███╔╝███║""" + " ".repeat(27) + "| \n" +
		    			tabLine + " ".repeat(numRepItem) + """
		    			█████████║█████████╗███║ ╚═████║╚████████║█████████╗█████████╗       █████████╗    ███║    █████████╗███║ ╚══╝ ███║""" + " ".repeat(27) + "| \n" +
		    			tabLine + " ".repeat(numRepItem) + """
		    			╚════════╝╚════════╝╚══╝   ╚═══╝ ╚═══════╝╚════════╝╚════════╝       ╚════════╝    ╚══╝    ╚════════╝╚══╝      ╚══╝""" + " ".repeat(27) + "|" + """
		    			""";
	    		print.println(addingItem);
	    		print.println(tabSpace + "—".repeat(172));
	        	print.println(tabSpace + "█".repeat(172));
	        	
    			print.println("\n");
    			print.println(tabSpace + " " + "—".repeat(170));
	    		print.flush();
				
				System.out.println(" ".repeat(76) +  b_Texts + "========================================" + c_Reset);
				System.out.println(tabSpace + " ".repeat(81) + b_Texts + "Single Item".toUpperCase() + c_Reset);
	    		String askItem = "Enter Name of Item: ";
	    		System.out.println(tabSpace + " ".repeat(58) + b_Texts +  "—".repeat(58) + c_Reset);
		        System.out.println(" ".repeat(67) + b_verticalLine + " ".repeat(18) + b_Texts + askItem + " ".repeat(18) + b_verticalLine +  c_Reset);
		        System.out.println(tabSpace + " ".repeat(58) + b_Texts +  "—".repeat(58) + c_Reset);
	    		System.out.print(" ".repeat(68) + b_Texts + " —> " + c_Reset);
	    		String itemHolder = mths.scan.nextLine().trim();
	    		
	    		print.println("\n\n");
	    		print.println(tabSpace + b_Texts + "—".repeat(172) + c_Reset);
	    		
	    		String [] label = {"Items", "Quantity", "Price", "Total Amount", "Group or Category", "Date of Expiration"};
				String blockForCategories = tabLine + rep20 + b_Texts
							+ label[0] + " ".repeat(27 - (label[0].length())) + b_verticalLine + " ".repeat(8) // ITEMS
							+ label[1] + " ".repeat(14 - (label[1].length())) + b_verticalLine + " ".repeat(8) // QUANTITY
							+ label[2] + " ".repeat(14 - (label[2].length())) + b_verticalLine + " ".repeat(5) // PRICE
							+ label[3] + " ".repeat(17 - (label[3].length())) + b_verticalLine + " ".repeat(18) // PRICE
							+ label[4] + " ".repeat(29 - (label[3].length())) + b_verticalLine + // GROUP OR CATEGORY
							c_Reset;
				print.println(blockForCategories);
				print.println(tabSpace + b_Texts + "—".repeat(172) + c_Reset);
				print.flush();
						
    			while((LINE2 = brIL2.readLine()) != null) {
    				String DATA [] = LINE2.split(";");
    				if ((DATA [3].equals ("none") == false) && DATA [3].equalsIgnoreCase(itemHolder)){
    					
		    			for (int numHolder = 0; numHolder < 1; numHolder++) {
		    				System.out.print(tabSpace + b_verticalLine + " ".repeat(7) + " ".repeat(40 - DATA[3].length()) + DATA [3] + b_verticalSpacesLine);
		    			}
		    			for (int numHolder = 0; numHolder < 1; numHolder++) {
		    				System.out.print(DATA[4] + " ".repeat(20 - DATA[4].length()) + b_verticalSpacesLine);
		    			}
		    			
		    			for (int numHolder = 0; numHolder < 1; numHolder++) {
		    				double data4 = (double) Double.parseDouble(DATA [5]);
		    				String STR5 = mths.currency.format(data4);
		    				System.out.print(STR5 + " ".repeat(20 - STR5.length()) + b_verticalSpacesLine);
		    			}
		    			
		    			for (int numHolder = 0; numHolder < 1; numHolder++) {
		    				System.out.print(DATA [6] + " ".repeat(20 - DATA[6].length()) + b_verticalSpacesLine);
		    			}
		    			
		    			for (int numHolder = 0; numHolder < 1; numHolder++) {
		    				System.out.println(DATA [7] + " ".repeat(50 - DATA[7].length()) + b_verticalSpacesLine);
		    			}
    				}
    			}
    			System.out.println(tabSpace + b_Texts + "—".repeat(172) + c_Reset);
    			brIL2.close();
    		}
    		
	    	catch(Exception e){
	    		System.out.println(e.getMessage());
	    	}
    		
    		finally {
    			System.out.println("\n\n");
	    		System.out.println(tabSpace + " " + "—".repeat(170));
	    		System.out.println(tabSpace);
	        	System.out.println(" ".repeat(76) +  b_Texts + "========================================" + c_Reset);

		    	System.out.println(tabSpace + " ".repeat(74) + b_Texts + "Access the List or an Item".toUpperCase() + c_Reset);
	            System.out.println(tabSpace + " ".repeat(58) + b_Texts +  "—".repeat(58) + "" + c_Reset);

		    	System.out.print(" ".repeat(68) + b_verticalLine + "  [" + b_Texts + "1" + c_Reset + "]" + b_Texts + " Show List" + c_Reset);
		        System.out.println(" ".repeat(11) + b_verticalLine + " ".repeat(9) + "[" + b_Texts + "2" + c_Reset + "]" + b_Texts + " Show an Item" + "  " + b_verticalLine + c_Reset);
		        System.out.println(tabSpace + " ".repeat(58) + b_Texts +  "—".repeat(58) + c_Reset);
		        System.out.println(" ".repeat(68) + b_verticalLine + " ".repeat(17) + "[" + b_Texts + "3" + c_Reset + "]" + b_Texts + " Exit and Go Back" + " ".repeat(17) + b_verticalLine +  c_Reset);
		        System.out.println(tabSpace + " ".repeat(58) + b_Texts +  "—".repeat(58) + c_Reset);
		        System.out.print(" ".repeat(68) + b_Texts + " —> " + c_Reset);
		        String numOrStr = mths.scan.nextLine();
		        
		        if (numOrStr.equalsIgnoreCase("Show List") || numOrStr.equalsIgnoreCase("List") || numOrStr.equals("1")){
		        	Logics_Item.getItemList();
		        	break;
		        }
		        
		    	else if (numOrStr.equalsIgnoreCase("Show an Item") || numOrStr.equalsIgnoreCase("Item") ||  numOrStr.equals("2")) {
		    		Logics_Item.getSingleItem();
		    		break;
	    		}
		        
		        else if (numOrStr.equalsIgnoreCase("Exit") || numOrStr.equalsIgnoreCase("Exit and Go Back") ||  numOrStr.equals("3")){
		    		chooseItemOptionDuplicate();
		    		break;
		    	}
		        
		    	else {
		    		System.out.println(tabLine + "TRY AGAIN");
		    		continue;
		    	}
    		}
    	}
	}
    
    @SuppressWarnings("finally")
    public static void setItem() {
    	//MEHODS
    	Logics_Item mths = new Logics_Item();
    	PrintWriter print = new PrintWriter(System.out);
    	
    	// VARIABLES
    	final int repFirst = 70;
    	final String strSpace = " ";
    	final int repSecond = 15;
    	final int repThird = 80;
    	
		// VARIABLE
    	final String dashBFormat = " ".repeat(38);
    	String perishable;
    	Set <String> dupli = new HashSet<>();
    	List <String> groups = new ArrayList<>();
        Set <String> duppli2 = new HashSet<>();
    	
    	while(true) {
			try {
			mths.writer = new FileWriter(mths.fPath.toString(), true);

			print.println("\n");
			print.println("\t " + b_Texts + "—".repeat(172) + c_Reset);
	    	final String addItem = tabLine + dashBFormat + " " + """
	    			 █████████╗ ██████████╗ ██████████╗        █████████╗███████████╗█████████╗████╗    ████╗""" + " ".repeat(42) + "| \n" +
	    			tabLine + dashBFormat + """
	    			███╔════███╗███╔════███╗███╔════███╗          ███╔══╝    ███╔═══╝███╔═════╝█████╗  █████║""" + " ".repeat(42) + "| \n" +
	    			tabLine + dashBFormat + """
	    			███████████║███║    ███║███║    ███║          ███║       ███║    ██████╗   ███╔█████╔███║""" + " ".repeat(42) + "| \n" +
	    			tabLine + dashBFormat + """ 
	    			███╔════███║███║    ███║███║    ███║          ███║       ███║    ███╔══╝   ███║╚███╔╝███║""" + " ".repeat(42) + "| \n" +
	    			tabLine + dashBFormat + """
	    			███║    ███║██████████╔╝██████████╔╝       █████████╗    ███║    █████████╗███║ ╚══╝ ███║""" + " ".repeat(42) + "| \n" +
	    			tabLine + dashBFormat + """
	    			╚══╝    ╚══╝╚═══════╝   ╚═══════╝          ╚════════╝    ╚══╝    ╚════════╝╚══╝      ╚══╝""" + " ".repeat(42) + "|" + """
	    			""";
    		print.println(addItem);
    		print.println(tabSpace + "—".repeat(172));
        	print.println(tabSpace + "█".repeat(172));
    		print.flush();
		    		
			print.println("\n");
			print.println(tabSpace + " " + "—".repeat(170));
			print.println(tabSpace + centerRepeat + " ".repeat(5) + b_Texts + "ADDING AN ITEM" + c_Reset); 
			print.println(b_Texts + " ".repeat(49) + "—".repeat(92) + c_Reset);
			print.println( " ".repeat(49) + b_verticalLine + " ".repeat(32) + b_Texts + "ENTER THE DETAILS NEEDED" + c_Reset + " ".repeat(34) + b_verticalLine); 
			print.println(b_Texts + " ".repeat(49) + "—".repeat(92) + c_Reset);
			
			print.flush();
				while(true) {
					Date now = new Date();
					mths.writer.write(now + " ;");
										
					mths.writer.write(Logics_ProfileUser.getEnteredUsername() + ";");
					mths.writer.write(Logics_ProfileUser.getEnteredPassword() + ";");
					
					System.out.println();
					System.out.println(b_Texts + " ".repeat(65) + "—".repeat(60) + c_Reset);
					System.out.print(" ".repeat(repFirst - "Item:".length()) + b_verticalLine +  " ".repeat(repSecond - "Item:".length()) + c_Green + " Item: " + c_Reset);
					String item = mths.scan.nextLine().trim();
					mths.writer.write(item + ";");
					
					System.out.print(" ".repeat(74 - "Quantity:".length()) + b_verticalLine + " ".repeat((repSecond) - "Quantity:".length()) + c_Green + " Quantity: " + c_Reset);
					double quant =  mths.scan.nextDouble();
					mths.writer.write(quant + ";");
					
					System.out.print(" ".repeat(repThird - "Price per Unit:".length()) + b_verticalLine + " ".repeat(repSecond - "Price per Unit:".length()) + c_Green + " Price per Unit: " + c_Reset);
					double price =  mths.scan.nextDouble();
					mths.writer.write(price + ";");
					mths.writer.write(price*quant + ";");
					
					mths.scan.nextLine();
					
					System.out.println(b_Texts + " ".repeat(65) + "—".repeat(60) + c_Reset);
					print.println("\n");
					break;
				}
    		}
			catch (InputMismatchException e) {
				System.out.println("\t | ");
				if ((e.getMessage() == null)) {
		    		System.out.println(tabSpace + " ".repeat(50 - ("Something Went Wrong in setItemInventory").length()) + tabLine + " ".repeat(10)
		    				+ b_Texts + "Something Went Wrong in setItemInventory" + c_Reset + c_Red + e.getMessage() + c_Reset);
					System.out.println(tabSpace + " ".repeat(50 - ("INVALID INPUT: Entered String to a supposed Integer/Number").length()) + tabLine + "INVALID INPUT: Entered String to a supposed Integer/Number");
				}
				mths.scan.nextLine();
			}
			catch(IOException e) {
				if ((e.getMessage() == null)) {
					System.out.println(tabSpace + " ".repeat(50 - ("Something Went Wrong in setItemInventory").length()) + tabLine + " ".repeat(10)
		    				+ b_Texts + "Something Went Wrong in setItemInventory" + c_Reset + c_Red + e.getMessage() + c_Reset);
					System.out.println(tabSpace + " ".repeat(50 - ("FILE INPUT ERROR: Something went wrong with the File...").length()) + tabLine + "FILE INPUT ERROR: Something went wrong with the File...");
				}
				mths.scan.nextLine();
			}
        	
        	// FOR PRINTING THE GROUPS
            try {
				FileReader fR = new FileReader(mths.fPath.toString());
				BufferedReader brAI = new BufferedReader(fR);
				String LINE;
				int numRep = 0;
				int numRep2 = 0;
		        int total = 0;
		        
		        print.println(b_Texts + " ".repeat(59) + "—".repeat(72) + c_Reset);
		        print.flush();
                while ((LINE = brAI.readLine()) != null) {
                	String[] DATA = LINE.split(";", -1);                
                	String group = DATA.length > 7 ? DATA[7].trim() : "";
                	
                    if (group.isEmpty() || "no group".equalsIgnoreCase(group)) continue;
                    
	                if (dupli.add(group)) {
	                    total++;
                    	if(total >= 10) {
	                    	numRep++;
	                    	if (total >= 100) {
	                    		numRep++;
	                    		numRep2++;
	                    	}
	                    }
                    	
	                    if (total % 2 != 0) {
	                    	System.out.print(" ".repeat(59) + b_verticalLine + "    [" + c_Green + b_Texts + total + c_Reset + "] " + c_Green + b_Texts + group + c_Reset);
	                    }
	                    
	                    if (total % 2 == 0) {
	                    	System.out.print(b_verticalLine + "    [" + c_Green + b_Texts + total + c_Reset + "] " + c_Green + b_Texts + group + c_Reset + " ".repeat(24 - (group.length() + numRep)) + b_verticalLine);
	                    }
	                    
	                    if (brAI.ready()) 
	                    	System.out.print(" ".repeat(29 - (group.length() + numRep2)));
	                    
	                    if (total % 2 == 0) 
	                    	System.out.println();
		                }
                    } 
                	brAI.close();
                	System.out.print("");
                }
    	
            
            catch (IOException e) {
                e.printStackTrace();
                return;
            }
            
            finally {
            	print.println(b_Texts + " ".repeat(59) + "—".repeat(72) + c_Reset);
            	print.flush();
            }
            
            // FOR RETRIEVING THE GROUPS
            try {
            	FileReader fR = new FileReader(mths.fPath.toString());
            	BufferedReader brAI = new BufferedReader(fR);
		        String LINE;
		        
		        while ((LINE = brAI.readLine()) != null) {
		            String[] DATA = LINE.split(";", -1);
		            String groupData = DATA.length > 7 ? DATA[7].trim() : "";
		            
		            if (groupData.isEmpty() || "no group".equalsIgnoreCase(groupData)) 
		            	continue;
		            
		            if (duppli2.add(groupData))
		            	groups.add(groupData);
		        }
		        brAI.close();
            }
            
            catch(Exception e) {
				e.getMessage();
				mths.scan.nextLine();
			}
            
            
            int choice = -1;
            try {
                while (true) {
                    System.out.print("Enter Only The" + b_Texts + c_Green + " NUMBER " + c_Reset + "of the group to select (1-" + groups.size() + "): ");
                    String input = mths.scan.nextLine().trim();
                    
                    try {
                        choice = Integer.parseInt(input);
                        if (choice >= 1 && choice <= groups.size()) 
                        	break;
                    }
                    
                    catch (NumberFormatException ignored) {}
                    System.out.println("Invalid input. Please enter an integer between 1 and " + groups.size() + ".");
                }
	            String selectedGroup = groups.get(choice - 1);
	            mths.writer.write(selectedGroup + ";");
	            System.out.println("Selected: [" + c_Green + b_Texts + choice + c_Reset + "] " + b_Texts + selectedGroup + c_Reset);
            }
            
			catch(Exception e) {
				e.getMessage();
				mths.scan.nextLine();
			}
            
			try {
				while(true) {
					System.out.println(b_Texts + " ".repeat(59) + "—".repeat(72) + c_Reset);
					System.out.println( " ".repeat(59) + b_verticalLine + " ".repeat(20) + b_Texts + "Is the Item Perishable or Not?" + c_Reset + " ".repeat(20) + b_verticalLine);
					
					System.out.println(b_Texts + " ".repeat(59) + "—".repeat(72) + c_Reset);
					System.out.println(b_Texts + " ".repeat(69) + "—".repeat(52) + c_Reset);

					System.out.print(" ".repeat(69) + b_verticalLine + b_Texts + " ".repeat(9) + "[" + c_Reset + "1" + b_Texts + "]" + " Yes" + " ".repeat(9) + b_verticalLine + c_Reset);						
					System.out.println(" ".repeat(9) + b_Texts + "[" + c_Reset + "2" + b_Texts + "]" + " No" + " ".repeat(9) + b_verticalLine + c_Reset);
					
					System.out.println(b_Texts + " ".repeat(69) + "—".repeat(52) + c_Reset);
					System.out.print(" ".repeat(69) + c_Green + b_Texts + " —> " + c_Reset);
					String perishableHolderDecision = mths.scan.nextLine();
					
					if(perishableHolderDecision.equalsIgnoreCase("Yes") || perishableHolderDecision.equals("1")) {
						System.out.print(" ".repeat(69) + c_Green + b_Texts + " —> " + c_Reset);
						perishable =  mths.scan.nextLine().trim();
						System.out.print(" ".repeat(repFirst - "Expiration:".length()) + strSpace + " ".repeat(repSecond - "Expiration:".length()) + " Expiration: " + perishable);
						mths.writer.write(perishable + ";");
						break;
					}
					
					else if(perishableHolderDecision.equalsIgnoreCase("No") || perishableHolderDecision.equals("2")) {
						System.out.print(" ".repeat(repFirst - "Expiration:".length()) + strSpace + " ".repeat(repSecond - "Expiration:".length()) + " Expiration: No Expiration Date");
						perishable = "no date";
						mths.writer.write(perishable + ";");
						break;
					}
					else {
						continue;
					}
				}
				mths.writer.write("\n");
				mths.writer.flush();
				mths.writer.close();
				break;	
			}
			
			// CHECKS FOR DUPLICATION OF THE ITEM AND ASKS IF THE USER IS SURE TO SUCCEED
			
			// ADDS ID NUMBER, READS THE PREVIOUS NUMBER, THEN ADDS ONE AS THE ADD ITEM SUCCEEDS
			
			
			catch (InputMismatchException e) {
				System.out.println("\t | ");
				if ((e.getMessage() == null)) {
		    		System.out.println(tabSpace + " ".repeat(50 - ("Something Went Wrong in setItemInventory").length()) + tabLine + " ".repeat(10)
		    				+ b_Texts + "Something Went Wrong in setItemInventory" + c_Reset + c_Red + e.getMessage() + c_Reset);
					System.out.println(tabSpace + " ".repeat(50 - ("INVALID INPUT: Entered String to a supposed Integer/Number").length()) + tabLine + "INVALID INPUT: Entered String to a supposed Integer/Number");
				}
				mths.scan.nextLine();
			}
			catch(IOException e) {
				if ((e.getMessage() == null)) {
					System.out.println(tabSpace + " ".repeat(50 - ("Something Went Wrong in setItemInventory").length()) + tabLine + " ".repeat(10)
		    				+ b_Texts + "Something Went Wrong in setItemInventory" + c_Reset + c_Red + e.getMessage() + c_Reset);
					System.out.println(tabSpace + " ".repeat(50 - ("FILE INPUT ERROR: Something went wrong with the File...").length()) + tabLine + "FILE INPUT ERROR: Something went wrong with the File...");
				}
				mths.scan.nextLine();
			}
			
			finally {
				// Internal Decision to repeat or to choose other Action
				System.out.println(tabSpace);
				System.out.println("\n");
				print.println(tabSpace + b_Texts + "—".repeat(170));
	        	System.out.println(centerRepeat +  b_Texts + "============================================" + c_Reset);
	
		    	System.out.println(tabSpace + " ".repeat(72) + b_Texts + "CHOOSE AGAIN OR EXIT THE PROGRAM" + c_Reset);
	            System.out.println(tabSpace + " ".repeat(46) + b_Texts + "" +  "—".repeat(80) + "" + c_Reset);
	
		    	System.out.print(subCR55 + " " + b_verticalLine + "  [" + b_Texts + "1" + c_Reset + "]" + b_Texts + " Show an Item" + c_Reset);
		        System.out.println(" ".repeat(20) + b_verticalLine + " ".repeat(15) + "[" + b_Texts + "2" + c_Reset + "]" + b_Texts + " Add an Item, again" + " ".repeat(7) + b_verticalLine + c_Reset);
		        System.out.println(tabSpace + " ".repeat(46) + b_Texts +  "—".repeat(80) + c_Reset);
		        System.out.print(subCR55 + " " + b_verticalLine + "  [" + b_Texts + "3" + c_Reset + "]" + b_Texts + " Remove an Item" + c_Reset);
		        System.out.println(" ".repeat(18) + b_verticalLine + " ".repeat(15) + "[" + b_Texts + "4" + c_Reset + "]" + b_Texts + " Exit and Go Back  " + b_verticalLine + c_Reset);
		        System.out.println(tabSpace + " ".repeat(46) + b_Texts + "" +  "—".repeat(80) + "" + c_Reset);
		        System.out.print(subCR55 + b_Texts + " —> " + c_Reset);
		        String numOrStr = mths.scan.nextLine().trim();
		        
		        if (numOrStr.equalsIgnoreCase("Show an Item, again") || numOrStr.equalsIgnoreCase("Show") || numOrStr.equals("1")) {
		        	Logics_Item.getItemOrItems();   	
					break;
				}
				else if (numOrStr.equalsIgnoreCase("Add an Item") || numOrStr.equalsIgnoreCase("Add") || numOrStr.equals("2")) {
					Logics_Item.setItem(); 
					break;
				}
				else if (numOrStr.equalsIgnoreCase("Remove an Item") || numOrStr.equalsIgnoreCase("Remove") || numOrStr.equals("3")) {
					Logics_Item.removeItem();
					break;
				}
				else if (numOrStr.equalsIgnoreCase("Exit and Go Back") || numOrStr.equals("5")){
					Logics_AccessSystem.firstDecisionDuplicate();
					break;
				}
				else {
					System.out.println("\t | Try Again:");
					Logics_Item.repeatingChooseAgainItem();
					break;
				}
			}
		}
    }
    
    public static void checkForDuplicationItem() {
    	while(true) {
    		try {
    			// CHECKS THE EXPIRATION DATES
    			// COMPARES if Over Due or Approaching Expiration Date
    			// 
    		}
    		
    		catch(Exception e) {
        		System.out.println(e.getMessage());
        	}
        	
        	finally {
        		
        	}	
    	}
    }
    
    public static void removeItem() {
    	//MEHODS
    	Logics_Item mths = new Logics_Item();
    	PrintWriter print = new PrintWriter(System.out);
    	    	
		// VARIABLE

    	final String dashBFormat = " ".repeat(38);
    	
    	while(true) {
	    	try {
	    		System.out.println(" REMOVE ITEMMMM");
	    		
    			print.println("\n");
	        	print.println("\t " + b_Texts + "—".repeat(172) + c_Reset);
    			String removeItem = tabLine + dashBFormat + """
		    			█████████╗ █████████╗████╗    ████╗ █████████╗ ███╗   ███╗█████████╗       █████████╗███████████╗█████████╗████╗    ████╗       """ + " ".repeat(12) + "| \n" +
		    			tabLine + dashBFormat + """
		    			███╔═══███╗███╔═════╝█████╗  █████║███╔════███║███║   ███║███╔═════╝          ███╔══╝    ███╔═══╝███╔═════╝█████╗  █████║     """ + " ".repeat(12) + "| \n" +
		    			tabLine + dashBFormat + """
		    			█████████╔╝███████╗  ███╔█████╔███║███║    ███║ ███╗ ███╔╝███████╗            ███║       ███║    ██████╗   ███╔█████╔███║     """ + " ".repeat(16) + "| \n" +
		    			tabLine + dashBFormat + """    
		    			███╔═══███╗███╔═══╝  ███║╚███╔╝███║███║    ███║ ███║ ███║ ███╔═══╝            ███║       ███║    ███╔══╝   ███║╚███╔╝███║""" + " ".repeat(16) + "| \n" +
		    			tabLine + dashBFormat + """
		    			███║   ███║█████████╗███║ ╚══╝ ███║╚█████████╔╝  ██████╔╝ █████████╗       █████████╗    ███║    █████████╗███║ ╚══╝ ███║     """ + " ".repeat(16) + "| \n" +
		    			tabLine + dashBFormat + """
		    			╚══╝   ╚══╝╚════════╝╚══╝      ╚══╝ ╚════════╝   ╚═════╝  ╚════════╝       ╚════════╝    ╚══╝    ╚════════╝╚══╝      ╚══╝     """ + " ".repeat(16) + "|" + """
		    			""";
    			print.println(removeItem);
	    		print.println(tabSpace + "—".repeat(172));
	        	print.println(tabSpace + "█".repeat(172));
	        	print.flush();
	    	}
	    	
	    	catch(Exception e){
	    		System.out.println(tabLine + "SOMETHING WENT WRONG IN REMOVEITEM " + e.getMessage());
	    	}
	    	
	    	finally {
				// Internal Decision to repeat or to choose other Action
				System.out.println(tabSpace);
				System.out.println("\n");
				System.out.println(tabSpace + b_Texts + "—".repeat(170));
	        	System.out.println(centerRepeat +  b_Texts + "============================================" + c_Reset);
	
		    	System.out.println(tabSpace + " ".repeat(72) + b_Texts + "CHOOSE AGAIN OR EXIT THE PROGRAM" + c_Reset);
	            System.out.println(tabSpace + " ".repeat(46) + b_Texts + "" +  "—".repeat(80) + "" + c_Reset);
	
		    	System.out.print(subCR55 + " " + b_verticalLine + "  [" + b_Texts + "1" + c_Reset + "]" + b_Texts + " Show an Item" + c_Reset);
		        System.out.println(" ".repeat(20) + b_verticalLine + " ".repeat(15) + "[" + b_Texts + "2" + c_Reset + "]" + b_Texts + " Add an Item" + " ".repeat(7) + b_verticalLine + c_Reset);
		        System.out.println(tabSpace + " ".repeat(46) + b_Texts +  "—".repeat(80) + c_Reset);
		        System.out.print(subCR55 + " " + b_verticalLine + "  [" + b_Texts + "3" + c_Reset + "]" + b_Texts + " Remove an Item" + c_Reset);
		        System.out.println(" ".repeat(18) + b_verticalLine + " ".repeat(15) + "[" + b_Texts + "4" + c_Reset + "]" + b_Texts + " Exit and Go Back  " + b_verticalLine + c_Reset);
		        System.out.println(tabSpace + " ".repeat(46) + b_Texts + "" +  "—".repeat(80) + "" + c_Reset);
		        System.out.print(subCR55 + b_Texts + " —> " + c_Reset);
		        String numOrStr = mths.scan.nextLine().trim();
		        
		        if (numOrStr.equalsIgnoreCase("Show an Item, Again") || numOrStr.equalsIgnoreCase("Show") || numOrStr.equals("1")) {
		        	Logics_Item.getItemOrItems();   	
					break;
				}
				else if (numOrStr.equalsIgnoreCase("Add an Item") || numOrStr.equalsIgnoreCase("Add") || numOrStr.equals("2")) {
					Logics_Item.setItem(); 
					break;
				}
				else if (numOrStr.equalsIgnoreCase("Remove an Item") || numOrStr.equals("3")) {
					Logics_Item.removeItem();
					break;
				}
				else if (numOrStr.equalsIgnoreCase("Exit and Go Back") || numOrStr.equals("4")){
					Logics_AccessSystem.firstDecisionDuplicate();
					break;
				}
				else if (true){
					System.out.println("\t | Try Again:");
					Logics_Item.repeatingChooseAgainItem();
					break;
				}
	    	}
    	}
    }
    
    public static void checkExpirationDate() {
    	while(true) {
    		try {
    			// CHECKS THE EXPIRATION DATES
    			// COMPARES if Over Due or Approaching Expiration Date
    			// 
    		}
    		
    		catch(Exception e) {
        		System.out.println(e.getMessage());
        	}
        	
        	finally {
        		
        	}	
    	}
    }

    
	public static void repeatingChooseAgainItem() {
		// METHODS
		Logics_Inventory mths = new Logics_Inventory();
		PrintWriter print = new PrintWriter(System.out);
		
		while(true) {
			try {
				// Internal Decision to repeat or to choose other Action
				System.out.println(tabSpace);
				System.out.println("\n");
				print.println(tabSpace + b_Texts + "—".repeat(170));
	        	System.out.println(centerRepeat +  b_Texts + "============================================" + c_Reset);
	
		    	System.out.println(tabSpace + " ".repeat(72) + b_Texts + "CHOOSE AGAIN OR EXIT THE PROGRAM" + c_Reset);
	            System.out.println(tabSpace + " ".repeat(46) + b_Texts + "" +  "—".repeat(80) + "" + c_Reset);
	
		    	System.out.print(subCR55 + " " + b_verticalLine + "  [" + b_Texts + "1" + c_Reset + "]" + b_Texts + " Show an Item" + c_Reset);
		        System.out.println(" ".repeat(20) + b_verticalLine + " ".repeat(15) + "[" + b_Texts + "2" + c_Reset + "]" + b_Texts + " Add an Item, again" + " ".repeat(7) + b_verticalLine + c_Reset);
		        System.out.println(tabSpace + " ".repeat(46) + b_Texts +  "—".repeat(80) + c_Reset);
		        System.out.print(subCR55 + " " + b_verticalLine + "  [" + b_Texts + "3" + c_Reset + "]" + b_Texts + " Remove an Item" + c_Reset);
		        System.out.println(" ".repeat(18) + b_verticalLine + " ".repeat(15) + "[" + b_Texts + "4" + c_Reset + "]" + b_Texts + " Exit and Go Back  " + b_verticalLine + c_Reset);
		        System.out.println(tabSpace + " ".repeat(46) + b_Texts + "" +  "—".repeat(80) + "" + c_Reset);
		        System.out.print(subCR55 + b_Texts + " —> " + c_Reset);
		        String numOrStr = mths.scan.nextLine().trim();
		        
		        if (numOrStr.equalsIgnoreCase("Show an Item, again") || numOrStr.equalsIgnoreCase("Show") || numOrStr.equals("1")) {
		        	Logics_Item.getItemOrItems();   	
					break;
				}
				else if (numOrStr.equalsIgnoreCase("Add an Item") || numOrStr.equalsIgnoreCase("Add") || numOrStr.equals("2")) {
					Logics_Item.setItem(); 
					break;
				}
				else if (numOrStr.equalsIgnoreCase("Remove an Item") || numOrStr.equalsIgnoreCase("Remove") || numOrStr.equals("3")) {
					Logics_Item.removeItem();
					break;
				}
				else if (numOrStr.equalsIgnoreCase("Exit and Go Back") || numOrStr.equals("5")){
					Logics_AccessSystem.firstDecisionDuplicate();
					break;
				}
				else {
					System.out.println(tabSpace + minorCR48 + "Try Another: ");
					continue;
				}
			}
		
			catch(Exception e) {
				System.out.println(tabSpace + " ".repeat(50) + "SOMETHING WENT WRONG IN repeatChooseAgainInventory");
			}
		}
	}
    
    
}
