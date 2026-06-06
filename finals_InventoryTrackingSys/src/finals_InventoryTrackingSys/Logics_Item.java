package finals_InventoryTrackingSys;

import java.io.*;
import java.nio.file.*;
import java.text.*;
import java.time.*;
import java.time.format.*;
import java.util.*;
import java.util.regex.*;


public class Logics_Item {
	static final File filePath = new File ("C:\\Users\\Jerry Aaron\\git\\Inventory-Tracking-System\\finals_InventoryTrackingSys\\src\\InventoryData");
	static final File filePathGrp = new File ("C:\\Users\\Jerry Aaron\\git\\Inventory-Tracking-System\\finals_InventoryTrackingSys\\src\\InventoryGroups");

	// VARIABLES FOR COLOR/UI OUTPUT
	static String c_Red = "\u001B[31m";
    static String c_Green = "\u001B[32m";
    static String b_Texts = "\u001B[1m";
    static String u_Texts = "\u001B[4m";
    static String c_Reset = "\u001B[0m";
    
    // VARS FOR UI FORMAT
	final static String centerRepeat = " ".repeat(75);
	final static String subCR55 = " ".repeat(55);
	final static String minorCR48 = " ".repeat(48);      // MINOR CENTER REPEAT
	
	final static String newLines = ("\n\n\n\n\n");
	
	final static String tabSpace = "\t ";
	final static String tabLine = "\t │ ";
	
	final static String b_verticalLine = b_Texts + "│" + c_Reset;
	final static String b_verticalSpacesLine = b_Texts + " │ " + c_Reset;
    
    // METHODS
	Scanner scan = new Scanner(System.in);
	NumberFormat currency = NumberFormat.getCurrencyInstance();
	
	// FILE DECLARATIONS
	Path fPath = Paths.get(filePath.getAbsolutePath());
	Path fPathGrp = Paths.get(filePathGrp.getAbsolutePath());
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


    public static void chooseItemOptionDuplicate(){
    	//MEHODS
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
	    		repeatingChooseAgainItem();
	    	}
    	break;
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
				print.println(tabSpace + centerRepeat + " ".repeat(4) + c_Green + b_Texts + "ITEM LIST" + c_Reset); 
				print.println(tabSpace + b_Texts + "—".repeat(172) + c_Reset);
				
				String [] label = {"Items", "Quantity", "Price", "Total Amount", "Group or Category", "Expiration (" + c_Green + "MM" + c_Reset + "/" + c_Green + "DD" + c_Reset + "/" + c_Green + "YYYY" + c_Reset + ")"};
				String blockForCategories = tabLine + " ".repeat(21 - (label[0].length())) + b_Texts
						+ label[0] + " ".repeat(21 - (label[0].length())) + b_verticalLine + " ".repeat(8) // ITEMS
						+ label[1] + " ".repeat(14 - (label[1].length())) + b_verticalLine + " ".repeat(8) // QUANTITY
						+ label[2] + " ".repeat(14 - (label[2].length())) + b_verticalLine + " ".repeat(5) // PRICE
						+ label[3] + " ".repeat(17 - (label[3].length())) + b_verticalLine + " ".repeat(8) // PRICE
						+ label[4] + " ".repeat(24 - (label[4].length())) + b_verticalLine + " ".repeat(3) // GROUP OR CATEGORY
						+ label[5] + " ".repeat(53 - (label[5].length())) + b_verticalLine + // EXPIRATION DATE
						c_Reset;
				print.println(blockForCategories);
				print.println(tabSpace + b_Texts + "—".repeat(172) + c_Reset);
				print.flush();
				
				FileReader fR = new FileReader(mths.fPath.toString());
				BufferedReader brIL = new BufferedReader(fR);
				BufferedReader brIL1 = new BufferedReader(new FileReader(mths.fPath.toString()));
				String LINE;
				String LINE1;
				
				while((LINE = brIL.readLine()) != null) {
					String DATA [] = LINE.split(";");
					String date [] = LINE.split(Pattern.quote("\\"));
					
					if (DATA [3].equals ("none") == false){
		    			for (int numHolder = 0; numHolder < 1; numHolder++) { // ITEM NAME
		    				System.out.print(tabSpace + b_verticalLine + " ".repeat(7) + " ".repeat(30 - DATA[3].length()) + DATA [3] + b_verticalSpacesLine);
		    			}
		    			for (int numHolder = 0; numHolder < 1; numHolder++) { // ITEM QUANTITY
		    				System.out.print(DATA [4] + " ".repeat(20 - DATA[4].length()) + b_verticalSpacesLine);
		    			}
		    			
		    			for (int numHolder = 0; numHolder < 1; numHolder++) { // ITEM PRICE
		    				double data4 = (double) Double.parseDouble(DATA [5]);
		    				String STR5 = mths.currency.format(data4);
		    				System.out.print(STR5 + " ".repeat(20 - STR5.length()) + b_verticalSpacesLine);
		    			}
		    			
		    			for (int numHolder = 0; numHolder < 1; numHolder++) { // ITEM TOTAL AMOUNT
		    				double data42 = (double) Double.parseDouble(DATA[4]);
		    				double data52 = (double) Double.parseDouble(DATA[5]);
		    				double dataHolderTA = data42 * data52;
		    				String STRTA = mths.currency.format(dataHolderTA);
		    				System.out.print(STRTA + " ".repeat(20 - STRTA.length()) + b_verticalSpacesLine);
		    			}
		    			
		    			for (int numHolder = 0; numHolder < 1; numHolder++) { // ITEM GROUP
		    				System.out.print(DATA [6] + " ".repeat(30 - DATA[6].length()) + b_verticalSpacesLine);
		    			}
		    			
		    			for (int numHolder = 0; numHolder < 1; numHolder++) { // ITEM EXPIRATION DATE
		    				if (date[1].equals("0") && date[2].equals("0") && date[3].equals("0")) {
		    					System.out.println("NO DATE" + " ".repeat(27 - "NO DATE".length()) + c_Reset + b_verticalSpacesLine);
		    				}
		    				
		    				else {
			    				String dateStatement = (date[1] + "/" + date[2] + "/" + date[3]);
			    				
			    				System.out.println(dateStatement + " ".repeat(27 - dateStatement.length()) + c_Reset + b_verticalSpacesLine);
		    				}
		    			}
					}
				}
				System.out.println(tabSpace + b_Texts + "—".repeat(172) + c_Reset);
				
				print.println("\n");
				print.println(tabSpace + " " + "—".repeat(170));
				print.println(tabSpace + centerRepeat + c_Red + b_Texts + " EXPIRATION LIST" + c_Reset); 
				print.println(tabSpace + b_Texts + " ".repeat(40) + "—".repeat(92) + c_Reset);
				print.flush();
				
				while((LINE1 = brIL1.readLine()) != null) {
					String DATA [] = LINE1.split(";");
					String expDate [] = LINE1.split(Pattern.quote("\\"));
					LocalDate expirationDate;

					Pattern p1 = Pattern.compile("[0-9][0-9]");
					Pattern p2 = Pattern.compile("[0-9][0-9]");
					Pattern p3 = Pattern.compile("[0-9][0-9][0-9][0-9]");
					
					Matcher m1 = p1.matcher(expDate[1]);
					Matcher m2 = p2.matcher(expDate[2]);
					Matcher m3 = p3.matcher (expDate[3]);
					
					if (m1.matches() || m2.matches() || m3.matches()) {
						int conversionMM = (int) Double.parseDouble(expDate[1]);
						int conversionDD = (int) Double.parseDouble(expDate[2]);
						int conversionYY = (int) Double.parseDouble(expDate[3]);
						
						expirationDate = LocalDate.of(conversionYY, conversionMM, conversionDD);
						
						LocalDate today = LocalDate.now();
						if (DATA [3].equals ("none") == false){
			    			for (int numHolder = 0; numHolder < 1; numHolder++) { // ITEM EXPIRATION DATE
			    				System.out.print(" ".repeat(45) + tabLine + DATA [3] + " ".repeat(27 - DATA[3].length()) + b_verticalSpacesLine);
			    				String dateStatement = (expDate[1] + "/" + expDate[2] + "/" + expDate[3]);
			    				System.out.print(dateStatement + " ".repeat(27 - dateStatement.length()) + c_Reset + b_verticalSpacesLine);
			    			}
			    			
							if (expirationDate.isBefore(today)) {
							    System.out.println(c_Red + b_Texts + " Expired " + " ".repeat(28 -  " Expired ".length()) + c_Reset + b_verticalSpacesLine);
							} 
							
							else if (expirationDate.isEqual(today)) {
							    System.out.println(c_Red + " Expires today " + " ".repeat(28 - " Expired today ".length()) + c_Reset + b_verticalSpacesLine);
							} 
							
							else { // expiry.isAfter(today)
							    System.out.println(c_Green + " Valid (Not Expired) " + " ".repeat(28 -  " Valid (Not Expired) ".length()) + c_Reset + b_verticalSpacesLine);
							}
							
						}
					}
				}
				System.out.println(tabSpace + b_Texts + " ".repeat(40) + "—".repeat(92) + c_Reset);
				brIL.close();
				brIL1.close();
			}
			
    		
	    	catch(Exception e){
	    		System.out.println(e.getLocalizedMessage());
	    	}
    		
    		finally {
    			System.out.println(newLines + newLines);
	    		repeatingChooseAgainItem();
	    	}
    	break;
		}
    }
    

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
	    		repeatingChooseAgainItem();
	    	}
    	break;
    	}
	}
    
	// Variable Holders before confirmation
    private static Date now = new Date();
	private static String item;
	private static String quant;
	private static String price;
	private static String group;
	private static String perishableDecision;
	boolean continueProcess;
	
	public void setContinueProcess(boolean setContinueProcess) {
		this.continueProcess = setContinueProcess;
	}
	
	public boolean getContinueProcess() {
		return continueProcess;
	}
	
	
    public static void setItem() {
    	//MEHODS
    	Logics_Item mths = new Logics_Item();
    	PrintWriter print = new PrintWriter(System.out);
    	
    	// VARIABLES
    	final int repFirst = 70;
    	final String strSpace = " ";
    	final int repSecond = 15;
   
		// VARIABLE
    	final String dashBFormat = " ".repeat(38);
    	
    	// Group:
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
			print.println(b_Texts + " ".repeat(49) + "┌" + "─".repeat(90) + "┐" + c_Reset);
			print.println( " ".repeat(49) + b_verticalLine + " ".repeat(25) + b_Texts + "ENTER THE DETAILS NEEDED / EXIT TO CANCEL" + c_Reset + " ".repeat(24) + b_verticalLine); 
			print.println(b_Texts + " ".repeat(49) + "└" + "─".repeat(90) + "┘" + c_Reset);
			
			print.flush();
			while(true) {
				System.out.println();
				System.out.println(b_Texts + " ".repeat(60) + "┌" + "─".repeat(8) + "┬" + "─".repeat(32) + "┬" + "─".repeat(24) + "┐" + c_Reset);
				System.out.println(" ".repeat(60) + b_Texts + "│" + c_Reset + " Enter: │" + c_Green + " ".repeat(5) + " Quantity " + c_Reset + 
								   "(" + c_Green + "Number Only" + c_Reset + ")" + ";" + " ".repeat(3) + b_Texts + "│" + c_Reset +
								   " ".repeat(4) + " or '" + c_Green + "." + c_Reset + "' to Exit " +  b_Texts + " ".repeat(4) + "│" + c_Reset);
				System.out.println(b_Texts + " ".repeat(60) + "└" + "─".repeat(8) + "┴" + "─".repeat(32) + "┴" + "─".repeat(24) + "┘" + c_Reset);
				
		        System.out.print(" ".repeat(68) + c_Green + b_Texts + " —> " + c_Reset);						
		        String quantityOption = mths.scan.nextLine().trim();
				
				if (quantityOption != ".") {
					quant = quantityOption;
					mths.setContinueProcess(true);
				}
				
				if (quantityOption.equalsIgnoreCase(".")) {
					mths.setContinueProcess(false);
					break;
				}
									
				if (mths.getContinueProcess()) {
					setItemQuantity();
				}
				
				if (mths.getContinueProcess()) {
					setItemPrice();
				}
				
				System.out.println(b_Texts + " ".repeat(65) + "─".repeat(60) + c_Reset);
				print.println("\n");
				break;
			}
			if (mths.getContinueProcess() == false) {
				System.out.println(b_Texts + " ".repeat(65) + "─".repeat(60) + c_Reset);
			}
        	
        	// FOR PRINTING THE GROUPS
			if (mths.getContinueProcess()) {
	            try {
					FileReader fR = new FileReader(mths.fPathGrp.toString());
					BufferedReader brAI = new BufferedReader(fR);
					String LINE;
					int numRep = 0;
					int numRep2 = 0;
			        int total = 0;
			        
			        print.println(b_Texts + " ".repeat(59) + "┌" + "─".repeat(37) + "┬" + "─".repeat(32) + "┐" + c_Reset);
			        print.flush();
	                while ((LINE = brAI.readLine()) != null) {
	                	String[] DATA = LINE.split(";", -1);                
	                	String groupPrinting = DATA.length > 6 ? DATA[6].trim() : "";
	                	
	                    if (groupPrinting.isEmpty() || "no group".equalsIgnoreCase(groupPrinting)) continue;
	                    
		                if (dupli.add(groupPrinting)) {
		                    total++;
	                    	if(total >= 10) {
		                    	numRep++;
		                    	if (total >= 100) {
		                    		numRep++;
		                    		numRep2++;
		                    	}
		                    }
	                    	
		                    if (total % 2 != 0) {
		                    	System.out.print(" ".repeat(59) + b_verticalLine + "    [" + c_Green + b_Texts + total + c_Reset + "] " + c_Green + b_Texts + groupPrinting + c_Reset);
		                    }
		                    
		                    if (total % 2 == 0) {
		                    	System.out.print(b_verticalLine + "    [" + c_Green + b_Texts + total + c_Reset + "] " + c_Green + b_Texts + groupPrinting + c_Reset + " ".repeat(24 - (groupPrinting.length() + numRep)) + b_verticalLine);
		                    }
		                    
		                    if (brAI.ready()) 
		                    	System.out.print(" ".repeat(29 - (groupPrinting.length() + numRep2)));
		                    
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
			        print.println(b_Texts + " ".repeat(59) + "└" + "─".repeat(37) + "┴" + "─".repeat(32) + "┘" + c_Reset);
	            	print.flush();
	            }
			}
			
	            
            // FOR RETRIEVING THE GROUPS
			if (mths.getContinueProcess()) {
	            try {
	            	FileReader fR = new FileReader(mths.fPathGrp.toString());
	            	BufferedReader brAI = new BufferedReader(fR);
			        String LINE;
			        
			        while ((LINE = brAI.readLine()) != null) {
			            String[] DATA = LINE.split(";", -1);
			            String groupData = DATA.length > 6 ? DATA[6].trim() : "";
			            
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
					System.out.println(b_Texts + " ".repeat(62) + "┌" + "─".repeat(64) + "┐" + c_Reset);
                    System.out.println(" ".repeat(62) + "│" + " ".repeat(8) + "Enter only the" + b_Texts + c_Green + " NUMBER " + c_Reset + "of the group to select (" + c_Green + "1-" + groups.size() + c_Reset + ")." +  " ".repeat(5) + "│");
                    System.out.println(" ".repeat(62) + "│" + " ".repeat(18) + "Or Enter '" + c_Green + "." + c_Reset + "'" + b_Texts + " (" + c_Green + "Period" + c_Reset + ") to Create New" + " ".repeat(17) + "│");
					System.out.println(b_Texts + " ".repeat(62) + "└" + "─".repeat(64) + "┘" + c_Reset);
                    System.out.print(" ".repeat(68) + c_Green + b_Texts + " —> " + c_Reset);
                    String groupOption = mths.scan.nextLine().trim();
                    
                    if (groupOption.equalsIgnoreCase(".")) {
						mths.setContinueProcess(false);
                    	break;
                    }
                    
                    else {
                    	while(true) {
		                    try {                    	
		                    	Pattern p1 = Pattern.compile("[1-9]?");
		                    	Matcher m1 = p1.matcher(groupOption);
		                    	if (m1.matches()) {
		                    		choice = Integer.parseInt(groupOption);
		                    		if (choice >= 1 && choice <= groups.size()) {
		                    			break;
		                    		}
		                    	}
		                    }
		                    catch (NumberFormatException e) {
		                    	System.out.println("Invalid input. Please enter an integer between 1 and " + groups.size() + "." + "\n");						
		                    	System.out.println(b_Texts + " ".repeat(62) + "┌" + "─".repeat(64) + "┐" + c_Reset);
			                    System.out.println(" ".repeat(62) + "│" + " ".repeat(8) + "Enter only the" + b_Texts + c_Green + " NUMBER " + c_Reset + "of the group to select (" + c_Green + "1-" + groups.size() + c_Reset + ")." +  " ".repeat(5) + "│");
			                    System.out.println(" ".repeat(62) + "│" + " ".repeat(18) + "Or Enter '" + c_Green + "." + c_Reset + "'" + b_Texts + " (" + c_Green + "Period" + c_Reset + ") to Create New" + " ".repeat(17) + "│");
								System.out.println(b_Texts + " ".repeat(62) + "└" + "─".repeat(64) + "┘" + c_Reset);
			                    System.out.print(" ".repeat(68) + c_Green + b_Texts + " —> " + c_Reset);
			                    groupOption = mths.scan.nextLine().trim();
			                    continue;
		                    }
                    		
                    	}
                    	group = groups.get(choice - 1);
						mths.setContinueProcess(true);	
						System.out.println("Selected: [" + c_Green + b_Texts + choice + c_Reset + "] " + b_Texts + group + c_Reset);
						break;
                	}
                }
                
					if (mths.getContinueProcess() == false) {
						System.out.println(b_Texts + " ".repeat(62) + "┌" + "─".repeat(64) + "┐" + c_Reset);
	                    System.out.println(" ".repeat(62) + "│" + " ".repeat(8) + "Enter only the" + b_Texts + c_Green + " Group Name " + c_Reset + "that you want to set." +  " ".repeat(5) + "│");
						System.out.println(b_Texts + " ".repeat(62) + "└" + "─".repeat(64) + "┘" + c_Reset);
	                    System.out.print(" ".repeat(68) + c_Green + b_Texts + " —> " + c_Reset);
	                    String groupOption = mths.scan.nextLine().trim();
                    
                    	group = groupOption;
					}
            	}
            
				catch(Exception e) {
					e.getMessage();
					mths.scan.nextLine();
				}
			}

			
			
            
			if (mths.getContinueProcess()) {
				try {
					while(true) {
						System.out.println("\n");
						System.out.println(b_Texts + " ".repeat(59) + "─".repeat(72) + c_Reset);
						System.out.println( " ".repeat(59) + b_verticalLine + " ".repeat(20) + b_Texts + "Is the Item Perishable or Not?" + c_Reset + " ".repeat(20) + b_verticalLine);
						
						System.out.println(b_Texts + " ".repeat(59) + "─".repeat(72) + c_Reset);
						System.out.println(b_Texts + " ".repeat(69) + "─".repeat(52) + c_Reset);
	
						System.out.print(" ".repeat(69) + b_verticalLine + b_Texts + " ".repeat(9) + "[" + c_Reset + "1" + b_Texts + "]" + " Yes" + " ".repeat(9) + b_verticalLine + c_Reset);						
						System.out.println(" ".repeat(9) + b_Texts + "[" + c_Reset + "2" + b_Texts + "]" + " No" + " ".repeat(9) + b_verticalLine + c_Reset);
						System.out.print(" ".repeat(69) + b_verticalLine + b_Texts + " ".repeat(11) + "[" + c_Reset + "3" + b_Texts + "]" + " Exit and Go back" + " ".repeat(11) + b_verticalLine + c_Reset);						

						System.out.println(b_Texts + " ".repeat(69) + "—".repeat(52) + c_Reset);
						System.out.print(" ".repeat(69) + c_Green + b_Texts + " —> " + c_Reset);
						String perishableHolderDecision = mths.scan.nextLine().trim();
						
						if (perishableHolderDecision.equalsIgnoreCase("Yes") || perishableHolderDecision.equals("1")) {
							System.out.print(" ".repeat(69) + c_Green + b_Texts + " —> " + c_Reset);
							perishableDecision =  mths.scan.nextLine().trim();
							System.out.print(" ".repeat(repFirst - "Expiration:".length()) + strSpace + " ".repeat(repSecond - "Expiration:".length()) + " Expiration: " + perishableDecision);
							mths.setContinueProcess(true);
							break;
						}
						
						else if(perishableHolderDecision.equalsIgnoreCase("No") || perishableHolderDecision.equals("2")) {
							System.out.print(" ".repeat(repFirst - "Expiration:".length()) + strSpace + " ".repeat(repSecond - "Expiration:".length()) + " Expiration: No Expiration Date");
							perishableDecision = "no date";
							mths.setContinueProcess(true);
							break;
						}
						
						else if(perishableHolderDecision.equalsIgnoreCase("3") || perishableHolderDecision.equalsIgnoreCase("Exit") || perishableHolderDecision.equalsIgnoreCase("Go back") || perishableHolderDecision.equalsIgnoreCase("Exit and Go Back")) {
							mths.setContinueProcess(false);
							break;
						}
						
						else {
							continue;
						}
					}
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
				
			finally {
				if (mths.getContinueProcess()) {
					try {
						mths.writer.write(now + " ;");
						
						mths.writer.write(Logics_ProfileUser.getEnteredUsername() + ";");
						mths.writer.write(Logics_ProfileUser.getEnteredPassword() + ";");
						mths.writer.write(item + ";");
						mths.writer.write(quant + ";");
						mths.writer.write(price + ";");
		            	mths.writer.write(group + ";");
						mths.writer.write(perishableDecision + ";");
						
						mths.writer.write("\n");
						mths.writer.flush();
						mths.writer.close();
					}
					catch(Exception e) {
						
					}
				}
			repeatingChooseAgainItem();
			}break;
		}
	}
    
    public static void setItemQuantity() {
    	Logics_Item mths = new Logics_Item();
    	while(true) {
    		try {
				System.out.println();
				System.out.println(b_Texts + " ".repeat(60) + "┌" + "─".repeat(8) + "┬" + "─".repeat(32) + "┬" + "─".repeat(24) + "┐" + c_Reset);
				System.out.println(" ".repeat(60) + b_Texts + "│" + c_Reset + " Enter: │" + c_Green + " ".repeat(5) + " Quantity " + c_Reset + 
								   "(" + c_Green + "Number Only" + c_Reset + ")" + ";" + " ".repeat(3) + b_Texts + "│" + c_Reset +
								   " ".repeat(4) + " or '" + c_Green + "." + c_Reset + "' to Exit " +  b_Texts + " ".repeat(4) + "│" + c_Reset);
				System.out.println(b_Texts + " ".repeat(60) + "└" + "─".repeat(8) + "┴" + "─".repeat(32) + "┴" + "─".repeat(24) + "┘" + c_Reset);
				
		        System.out.print(" ".repeat(68) + c_Green + b_Texts + " —> " + c_Reset);						
		        String quantityOption = mths.scan.nextLine().trim();
				
				if (quantityOption != ".") {
					quant = quantityOption;
					mths.setContinueProcess(true);
				}
				
				if (quantityOption.equalsIgnoreCase(".")) {
					mths.setContinueProcess(false);
					break;
				}
    		}
    		
    		catch(Exception e) {
    			System.out.println(e.getMessage());
    		}
    		
    	}
    }
    
    public static void setItemPrice() {
    	Logics_Item mths = new Logics_Item();
    	while(true) {
    		try {
				System.out.println();
				System.out.println(b_Texts + " ".repeat(60) + "┌" + "─".repeat(8) + "┬" + "─".repeat(32) + "┬" + "─".repeat(24) + "┐" + c_Reset);
				System.out.println(" ".repeat(60) + b_Texts + "│" + c_Reset + " Enter: │" + c_Green + " ".repeat(6) + " Price " + c_Reset 
								   + "(" + c_Green + "Number Only" + c_Reset + ");" + " ".repeat(5) + b_Texts + "│" + c_Reset +
								   " ".repeat(4) + " or '" + c_Green + "." + c_Reset + "' to Exit " +  b_Texts + " ".repeat(4) + "│" + c_Reset);
				System.out.println(b_Texts + " ".repeat(60) + "└" + "─".repeat(8) + "┴" + "─".repeat(32) + "┴" + "─".repeat(24)  + "┘" + c_Reset);
				
		        System.out.print(" ".repeat(68) + c_Green + b_Texts + " —> " + c_Reset);
		        String priceOption = mths.scan.nextLine().trim();
				
				if (priceOption != ".") {
					price = priceOption;
					mths.setContinueProcess(true);
				}
				
				if (priceOption.equalsIgnoreCase(".")) {
					mths.setContinueProcess(false);
					break;
				}
    		}
    		
    		catch(Exception e) {
    			System.out.println(e.getMessage());
    		}
    		
    	}
    }
    
    public static void setItemGroup() {
    	Logics_Item mths = new Logics_Item();
    	while(true) {
    		try {
    			
    		}
    		
    		catch(Exception e) {
    			System.out.println(e.getMessage());
    		}
    		
    	}
    }
    
    public static void setItemExpiration() {
    	Logics_Item mths = new Logics_Item();
    	while(true) {
    		try {
    			
    		}
    		
    		catch(Exception e) {
    			System.out.println(e.getMessage());
    		}
    		
    	}
    }
    
    
    
    public static void removeItem() {
    	//MEHODS
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
	    		repeatingChooseAgainItem();
	    	}
    	break;
    	}
    }
    
    public static void checkForDuplicationItem() {
    	while(true) {
    		try {
    			// CHECKS THE FILE IF THERE IS A SIMILAR PRODUCT
    			// ASKS THE USER TO AGREE AND CREATE THE GROUP OR NO AND EXIT
    			// 
    		}
    		
    		catch(Exception e) {
        		System.out.println(e.getMessage());
        	}
        	
        	finally {
        		
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
		Logics_Item mths = new Logics_Item();
		PrintWriter print = new PrintWriter(System.out);
		
		while(true) {
			try {
				// Internal Decision to repeat or to choose other Action
				System.out.println("\n\n");
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
		        
		        if (numOrStr.equalsIgnoreCase("Show an Item") || numOrStr.equalsIgnoreCase("Show") || numOrStr.equals("1")) {
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
				System.out.println(tabSpace + " ".repeat(50) + "SOMETHING WENT WRONG IN repeatChooseAgainItem");
			}
		}
	}
    
    
}
