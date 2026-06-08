package finals_InventoryTrackingSys;


import java.io.*;
import java.nio.file.*;
import java.text.*;
import java.time.LocalDate;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Logics_Inventory{	
	// VARIABLES FOR COLOR/UI OUTPUT
	static String c_Red = "\u001B[31m";
    static String c_Green = "\u001B[32m";
    static String b_Texts = "\u001B[1m";
    static String c_Reset = "\u001B[0m";
    
    // VARS FOR UI FORMAT
	final static String centerRepeat = " ".repeat(75);
	final static String centerRepeat73 = " ".repeat(73);
	final static String subCR52 = " ".repeat(52);
	final static String subCR53 = " ".repeat(53);
	final static String minorCR48 = " ".repeat(48);      // MINOR CENTER REPEAT
	final static String minorCR43 = " ".repeat(43);
	
	final static String newLines = ("\n\n\n\n\n");
	final static String tabSpace = "\t ";
	final static String tabLine = "\t │ ";
	
	final static String b_verticalLine = b_Texts + "│" + c_Reset;
	final static String b_verticalSpacesLine = b_Texts + " │ " + c_Reset;
        
    // METHODS
	Scanner scan = new Scanner(System.in);
	NumberFormat currency = NumberFormat.getCurrencyInstance();
	
	// FILE DECLARATIONS
	private final Path fPath = Path.of("src", "InventoryData");
	private final Path fPathGrp = Path.of("src", "InventoryGroups");
	FileWriter writer;
	FileReader fReader;

    
    // ASKS THE USER TO INPUT A DECISION TO ACCESS
    public static void chooseInventoryOption(){
    	//METHODS
    	Logics_Inventory mths = new Logics_Inventory();
    	Logics_AllDecisions logics_AllDecisions = new Logics_AllDecisions();
    	PrintWriter print = new PrintWriter(System.out);
    	
    	//VARIABLES
    	final String inventoryFormat = " ".repeat(38);
    	final String spacerFormat = " ".repeat(3);
    	
    	try {
    		print.println("\n");
        	print.println("\t " + "┌" + "─".repeat(170) + "┐");
			String inventory = tabLine + inventoryFormat + """
	    			█████████╗█████╗  ███╗███╗   ███╗█████████╗█████╗  ███╗█████████╗ █████████╗ █████████╗ ███╗  ███╗  """ + " ".repeat(33) + "│ \n" +
	    			tabLine + inventoryFormat + spacerFormat + """
	    			   ███╔══╝██████╗ ███║███║   ███║███╔═════╝██████╗ ███║   ███╔══╝███╔════███║███╔═══███╗███╚══███║  """ + " ".repeat(33) + "│ \n" +
	    			tabLine + inventoryFormat + spacerFormat + """
	    			   ███║   ███╔███╗███║ ███╗ ███╔╝███████╗  ███╔███╗███║   ███║   ███║    ███║█████████╔╝ ███████╔╝  """ + " ".repeat(33) + "│ \n" +
	    			tabLine + inventoryFormat + spacerFormat + """    
	    			   ███║   ███║╚██████║ ███║ ███║ ███╔═══╝  ███║╚██████║   ███║   ███║    ███║███╔═══███╗   ███╔═╝   """ + " ".repeat(34) + "│ \n" +
	    			tabLine + inventoryFormat + """
	    			█████████╗███║ ╚═████║  ██████╔╝ █████████╗███║ ╚═████║   ███║   ╚█████████╔╝███║   ███║   ███║     """ + " ".repeat(36) + "│ \n" +
	    			tabLine + inventoryFormat + """
	    			╚════════╝╚══╝   ╚═══╝  ╚═════╝  ╚════════╝╚══╝   ╚═══╝   ╚══╝    ╚════════╝ ╚══╝   ╚══╝   ╚══╝     """ + " ".repeat(36) + "│" + """
	    			""";
			print.println(inventory);
        	print.println("\t " + "└" + "─".repeat(170) + "┘");
        	print.println(tabSpace + "█".repeat(172));
        	print.println("\n");
        	print.println(tabSpace + " " + "—".repeat(170));
        	print.flush();
        	
    		System.out.println(tabSpace);
        	System.out.println(centerRepeat +  b_Texts + "========================================" + c_Reset);

	    	System.out.println(tabSpace + centerRepeat + " " + b_Texts + "Access Inventory to".toUpperCase() + c_Reset);
            System.out.println(tabSpace + minorCR43 + b_Texts + " ┌" + "─".repeat(40) + "┬" + "─".repeat(41) + "┐" + c_Reset);

	    	System.out.print(subCR53 + b_verticalLine + "  [" + c_Green + b_Texts + "1" + c_Reset + "]" + c_Green + b_Texts + " Show Inventory List" + c_Reset);
	        System.out.println(" ".repeat(15) + b_verticalLine + " ".repeat(2) + "[" + c_Green + b_Texts + "2" + c_Reset + "]" + c_Green + b_Texts + " Show Inventory Dashboard " + " ".repeat(10) + c_Reset + b_verticalLine);
	        
	        System.out.println(tabSpace + minorCR43 + b_Texts + "" +  " ├" + "─".repeat(40) + "┼" + "─".repeat(41) + "┤" + c_Reset);
	        
	        System.out.print(subCR53 + b_verticalLine + "  [" + c_Green + b_Texts + "3" + c_Reset + "]" + c_Green + b_Texts + " Add an Item" + c_Reset);
	        System.out.println(" ".repeat(23) + b_verticalLine + " ".repeat(2) + "[" + c_Green + b_Texts + "4" + c_Reset + "]" + c_Green + b_Texts + " Add a Group or Category " + " ".repeat(11) + c_Reset + b_verticalLine );
	        System.out.println(tabSpace + minorCR43 + b_Texts + "" +  " ├" + "─".repeat(40) + "┴" + "─".repeat(41) + "┤" + c_Reset);
	        
	        System.out.println(" ".repeat(53) + b_verticalLine + " ".repeat(31) + "[" + c_Green + b_Texts + "5" + c_Reset + "]" + c_Green + b_Texts + " Exit and Go Back" + c_Reset + " ".repeat(31) + b_verticalLine);
	        System.out.println(tabSpace + minorCR43 + b_Texts +  " └" + "─".repeat(82) + "┘" + c_Reset);
	        System.out.print(subCR53 + b_Texts + " —> " + c_Reset);
	        String setFDecision = mths.scan.nextLine().trim();
			logics_AllDecisions.setSecondDecision(setFDecision);
    	}
    	
    	catch(Exception e){
    		System.out.println("\t | SOMETHING WENT WRONG IN INVENTORY OPTION: " + e.getMessage());
    	}
    	
    	finally {
    		System.out.println(newLines);
    	}
    }
    
    public static void chooseInventoryOptionDuplicate(){
    	//METHODS
    	// Logics_Inventory mths = new Logics_Inventory();
    	PrintWriter print = new PrintWriter(System.out);
    	
    	//VARIABLES
    	final String inventoryFormat = " ".repeat(38);
    	final String spacerFormat = " ".repeat(3);
    	while(true) {
	    	try {
	    		print.println("\n");
	        	print.println("\t " + "┌" + "─".repeat(170) + "┐");
				String inventory = tabLine + inventoryFormat + """
		    			█████████╗█████╗  ███╗███╗   ███╗█████████╗█████╗  ███╗█████████╗ █████████╗ █████████╗ ███╗  ███╗  """ + " ".repeat(33) + "│ \n" +
		    			tabLine + inventoryFormat + spacerFormat + """
		    			   ███╔══╝██████╗ ███║███║   ███║███╔═════╝██████╗ ███║   ███╔══╝███╔════███║███╔═══███╗███╚══███║  """ + " ".repeat(33) + "│ \n" +
		    			tabLine + inventoryFormat + spacerFormat + """
		    			   ███║   ███╔███╗███║ ███╗ ███╔╝███████╗  ███╔███╗███║   ███║   ███║    ███║█████████╔╝ ███████╔╝  """ + " ".repeat(33) + "│ \n" +
		    			tabLine + inventoryFormat + spacerFormat + """    
		    			   ███║   ███║╚██████║ ███║ ███║ ███╔═══╝  ███║╚██████║   ███║   ███║    ███║███╔═══███╗   ███╔═╝   """ + " ".repeat(34) + "│ \n" +
		    			tabLine + inventoryFormat + """
		    			█████████╗███║ ╚═████║  ██████╔╝ █████████╗███║ ╚═████║   ███║   ╚█████████╔╝███║   ███║   ███║     """ + " ".repeat(36) + "│ \n" +
		    			tabLine + inventoryFormat + """
		    			╚════════╝╚══╝   ╚═══╝  ╚═════╝  ╚════════╝╚══╝   ╚═══╝   ╚══╝    ╚════════╝ ╚══╝   ╚══╝   ╚══╝     """ + " ".repeat(36) + "│" + """
		    			""";
				print.println(inventory);
	        	print.println("\t " + "└" + "─".repeat(170) + "┘");
	        	print.println(tabSpace + "█".repeat(172));
	        	print.flush();
	    	}
	    	
	    	catch(Exception e){
	    		System.out.println("\t | SOMETHING WENT WRONG IN INVENTORY OPTION: " + e.getMessage());
	    	}
    	
			finally {   
				repeatingChooseAgainInventory();
				System.out.println(newLines);
			}
		break;
    	}
    }
    
	// ACCESS CHECK/SHOW THE Inventory List
	public static void getWrittenInventory() {
    	//METHODS
    	Logics_Inventory mths = new Logics_Inventory();
    	PrintWriter print = new PrintWriter(System.out);
    	
    	//VARIABLES
    	final String inventoryFormat = " ".repeat(10);
    	final String spacerFormat = " ".repeat(3);
    	
    	
    	while(true) {
	    	try {
    			print.println("\n");
	        	print.println("\t " + "┌" + "─".repeat(170) + "┐");
    			String inventoryList = tabLine + inventoryFormat + """
		    			█████████╗█████╗  ███╗███╗   ███╗█████████╗█████╗  ███╗█████████╗ █████████╗ █████████╗ ███╗  ███╗       ███╗      █████████╗█████████╗███████████╗     """ + " ".repeat(12) + "│ \n" +
		    			tabLine + inventoryFormat + spacerFormat + """
		    			   ███╔══╝██████╗ ███║███║   ███║███╔═════╝██████╗ ███║   ███╔══╝███╔════███║███╔═══███╗███╚══███║       ███║         ███╔══╝███╔═════╝    ███╔═══╝     """ + " ".repeat(12) + "│ \n" +
		    			tabLine + inventoryFormat + spacerFormat + """
		    			   ███║   ███╔███╗███║ ███╗ ███╔╝███████╗  ███╔███╗███║   ███║   ███║    ███║█████████╔╝ ███████╔╝       ███║         ███║   █████████╗    ███║         """ + " ".repeat(16) + "│ \n" +
		    			tabLine + inventoryFormat + spacerFormat + """    
		    			   ███║   ███║╚██████║ ███║ ███║ ███╔═══╝  ███║╚██████║   ███║   ███║    ███║███╔═══███╗   ███╔═╝        ███║         ███║   ╚═════███║    ███║         """ + " ".repeat(16) + "│ \n" +
		    			tabLine + inventoryFormat + """
		    			█████████╗███║ ╚═████║  ██████╔╝ █████████╗███║ ╚═████║   ███║   ╚█████████╔╝███║   ███║   ███║          █████████╗█████████╗█████████║    ███║         """ + " ".repeat(16) + "│ \n" +
		    			tabLine + inventoryFormat + """
		    			╚════════╝╚══╝   ╚═══╝  ╚═════╝  ╚════════╝╚══╝   ╚═══╝   ╚══╝    ╚════════╝ ╚══╝   ╚══╝   ╚══╝          ╚════════╝╚════════╝╚════════╝    ╚══╝         """ + " ".repeat(16) + "│" + """
		    			""";
    			print.println(inventoryList);
	        	print.println("\t " + "└" + "─".repeat(170) + "┘");
	        	print.println(tabSpace + "█".repeat(172));

    			print.println("\n");
    			print.println(tabSpace + " " + "—".repeat(170));
    			
				print.println(tabSpace + centerRepeat + " ".repeat(4) + b_Texts + "INVENTORY LIST" + c_Reset); 
				print.println(tabSpace + b_Texts + "┌" + "─".repeat(38) + "┬" + "─".repeat(22) + "┬" + "─".repeat(22) + "┬" + "─".repeat(22) + "┬" + "─".repeat(32) + "┬" + "─".repeat(29) + "┐" + c_Reset);
				
				String [] label = {"Items and #ID", "Quantity", "Price", "Total Amount", "Group or Category", "Expiration (" + c_Green + "MM" + c_Reset + "/" + c_Green + "DD" + c_Reset + "/" + c_Green + "YYYY" + c_Reset + ")"};
				String blockForCategories = tabLine + " ".repeat(25 - (label[0].length())) + b_Texts
						+ label[0] + " ".repeat(25 - (label[0].length())) + b_verticalLine + " ".repeat(8) // ITEMS
						+ label[1] + " ".repeat(14 - (label[1].length())) + b_verticalLine + " ".repeat(8) // QUANTITY
						+ label[2] + " ".repeat(14 - (label[2].length())) + b_verticalLine + " ".repeat(5) // PRICE
						+ label[3] + " ".repeat(17 - (label[3].length())) + b_verticalLine + " ".repeat(8) // PRICE
						+ label[4] + " ".repeat(24 - (label[4].length())) + b_verticalLine + " ".repeat(3) // GROUP OR CATEGORY
						+ label[5] + " ".repeat(53 - (label[5].length())) + b_verticalLine + // EXPIRATION DATE
						c_Reset;
				print.println(blockForCategories);
				print.println(tabSpace + b_Texts + "├" + "─".repeat(38) + "┼" + "─".repeat(22) + "┼" + "─".repeat(22) + "┼" + "─".repeat(22) + "┼" + "─".repeat(32) + "┼" + "─".repeat(29) + "┤" + c_Reset);
				print.flush();
				
    			BufferedReader brIL = Files.newBufferedReader(mths.fPath);
				BufferedReader brIL1 = new BufferedReader(new FileReader(mths.fPath.toString()));
    			String LINE = "";
    			String LINE1;
				
    			while((LINE = brIL.readLine()) != null) {
					String DATA [] = LINE.split(";");
					String date [] = LINE.split(Pattern.quote("\\"));
					String ID [] = LINE.split("_");
					
					if (DATA [3].equals ("none") == false){
		    			for (int numHolder = 0; numHolder < 1; numHolder++) { // ITEM NAME
		    				System.out.print(tabSpace + b_verticalLine + " ".repeat(28 - DATA[3].length()) + DATA [3] + " ".repeat(2) + "#" + ID[1] + " ".repeat(5)  + b_verticalSpacesLine);
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
				System.out.println(tabSpace + b_Texts + "└" + "─".repeat(38) + "┴" + "─".repeat(22) + "┴" + "─".repeat(22) + "┴" + "─".repeat(22) + "┴" + "─".repeat(32) + "┴" + "─".repeat(29) + "┘"  + c_Reset);
				
				print.println("\n");
				print.println(tabSpace + " " + "—".repeat(170));
				print.println(tabSpace + centerRepeat + c_Red + b_Texts + "   EXPIRATION LIST" + c_Reset); 
				print.println(tabSpace + b_Texts + " ".repeat(40) + "┌" + "─".repeat(29) + "┬" + "─".repeat(29) + "┬" + "─".repeat(30) + "┐" + c_Reset);
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
				System.out.println(tabSpace + b_Texts + " ".repeat(40) + "└" + "─".repeat(29) + "┴" + "─".repeat(29) + "┴" + "─".repeat(30) + "┘" + c_Reset);
				brIL.close();
				brIL1.close();
			}

	    	catch(IOException e) {
	    		System.out.println("\t | SOMETHING WENT WRONG: "+ e.getLocalizedMessage());
	    	}
    	
			finally {        		
				System.out.println(newLines + newLines);
				repeatingChooseAgainInventory();
			}
		break;
    	}
	}
    
    
    // ACCESS CHECK/SHOW The Inventory Dashboard
	public static void getDashboardInventory() {
    	//METHODS
    	Logics_Inventory mths = new Logics_Inventory();
    	PrintWriter print = new PrintWriter(System.out);
				
    	//VARIABLES
		final String rep8 = " ".repeat(8);
		final String rep7 = " ".repeat(7);
		final String rep6 = " ".repeat(6);
    	final String rep40 = " ".repeat(40);
    	final String dashBFormat = " ".repeat(31);
    	
    	while(true) {
			try {
				//Path file = mths.fPath.resolve("InventoryData"); 
				//METHODS Files.newBufferedReader(file)
				BufferedReader br1 = new BufferedReader(new FileReader(mths.fPath.toString()));
				BufferedReader br2 = new BufferedReader(new FileReader(mths.fPath.toString()));
				BufferedReader br3 = new BufferedReader(new FileReader(mths.fPath.toString()));
         
				BufferedReader brAI100 = new BufferedReader(new FileReader(mths.fPath.toString()));
				BufferedReader brAI1000 = new BufferedReader(new FileReader(mths.fPath.toString()));
				BufferedReader brAI10000 = new BufferedReader(new FileReader(mths.fPath.toString()));
				
		        String LINE100;
		        String LINE1000;
		        String LINE10000;
		        
	    		// DASHBOARD CONTROL
	    		boolean labelHolder100 = false;
	    		boolean labelHolder1000 = false;
	    		boolean labelHolder10000 = false;

	    		String lines1 = "";
	    		String lines2 = "";
	    		String lines3 = "";
	    		
				print.println("\n");
	        	print.println("\t " + b_Texts + "┌" + "─".repeat(170) + "┐" + c_Reset);
		    	final String dashboard = tabLine + dashBFormat + """
		    			█████████╗   █████████╗ █████████╗███╗    ███╗██████████╗  █████████╗  █████████╗ █████████╗ ██████████╗   """ + " ".repeat(34) + "│ \n" +
		    			tabLine + dashBFormat + """
		    			███╔════███╗███╔════███╗███╔═════╝███║    ███║███╔════███╗███╔════███║███╔════███╗███╔═══███╗███╔════███╗  """ + " ".repeat(33) + "│ \n" +
		    			tabLine + dashBFormat + """
		    			███║    ███║███████████║█████████╗███████████║██████████╔╝███║    ███║███████████║█████████╔╝███║    ███║  """ + " ".repeat(33) + "│ \n" +
		    			tabLine + dashBFormat + """ 
		    			███║    ███║███╔════███║╚═════███║███╔════███║███╔════███╗███║    ███║███╔════███║███╔═══███╗███║    ███║  """ + " ".repeat(33) + "│ \n" +
		    			tabLine + dashBFormat + """
		    			█████████╔╝ ███║    ███║█████████║███║    ███║██████████╔╝╚█████████╔╝███║    ███║███║   ███║██████████╔╝  """ + " ".repeat(33) + "│ \n" +
		    			tabLine + dashBFormat + """
		    			╚═══════╝   ╚══╝    ╚══╝╚════════╝╚══╝    ╚══╝╚═════════╝  ╚════════╝ ╚══╝    ╚══╝╚══╝   ╚══╝╚═════════╝   """ + " ".repeat(34) + "│" + """
		    			""";
	    		print.println(dashboard);
	    		print.println(tabSpace + "└" + "─".repeat(170) + "┘");
	        	print.println(tabSpace + "█".repeat(172));
	    		print.flush();

	    		print.println("\n");
	    		print.println(tabSpace + " " + "—".repeat(170));
	    		
	    		print.println(tabSpace + centerRepeat + " ".repeat(4) + b_Texts + "ITEM QUANTITY" + c_Reset); 
	    		String valueHoldChanger = (tabSpace + centerRepeat + " ".repeat(8) + b_Texts + "0–100" + c_Reset);
	    		print.println(valueHoldChanger);
	    		print.println(tabSpace + " ".repeat(41) + b_Texts + "┌" + "─".repeat(102) + "┐" + c_Reset);	
	    		

		        while ((LINE100 = brAI100.readLine()) != null) {
		            String[] DATA = LINE100.split(";");
		            int conversionList = (int) Double.parseDouble(DATA[4]);
		            String groupData100 = conversionList <= 100 ? DATA[4]:"0";
		            
		            if ("0" != (groupData100)) {
		            	labelHolder100 = true;
		            	continue;
		            }
		        }
		        
		        while ((LINE1000 = brAI1000.readLine()) != null) {
		            String[] DATA = LINE1000.split(";");
		            int conversionList = (int) Double.parseDouble(DATA[4]);
		            String groupData1000 = (100 < (conversionList) && (conversionList) <= 1000) ? DATA[4]:"0";

		            	
		            if ("0" != (groupData1000)) {
		            	labelHolder1000 = true;
		            	continue;
		            }
		        }
		        
		        while ((LINE10000 = brAI10000.readLine()) != null) {
		            String[] DATA = LINE10000.split(";");
		            int conversionList = (int) Double.parseDouble(DATA[4]);
		            String groupData10000 = (1000 < (conversionList) && (conversionList) <= 10000) ? DATA[4]:"0";

		            	
		            if ("0" != (groupData10000)) {
		            	labelHolder10000 = true;
		            	continue;
		            }
		        }

	    		while((lines1 = br1.readLine()) != null) {
	    			String [] val = lines1.split(";");

	    			String newQuantity = val [4];
	            	int doubleVar =((int)(Double.parseDouble(newQuantity)));
	            	
	            	if (doubleVar <= 100 && (val[3].equals("none") == false) && (newQuantity.isEmpty() == false))
	            		valueHoldChanger = tabSpace + centerRepeat + " ".repeat(8) + b_Texts + "0–100" + c_Reset;
            		if((doubleVar <= 100) && ((val[3] == ("0")) == false) && (newQuantity.isEmpty() == false)) {
            			if ((val[3].equals("none")) == false){
            				print.print(tabSpace + " ".repeat(40 - (val[3].length())) + val[3] + b_verticalSpacesLine);	
            			}
            		}
	            	
	            	if (doubleVar <= 100 && ((doubleVar == (0)) == false) && (newQuantity.isEmpty() == false)) {
		    			if((doubleVar == 1)) {
		    				print.print("█".repeat(doubleVar));
		    				print.print(" ".repeat(100 - doubleVar) + b_verticalSpacesLine);
		    			}
		    			
		    			else if ((doubleVar % 2 == 0)) {
		    				for(int numRepeat = 0; numRepeat < (doubleVar / 2); numRepeat++) {
		    					print.print("██");
		    				}
		    				print.print(" ".repeat(100 - (doubleVar)) + " |");
		    			}
		    			
		    			else if((doubleVar % 2 != 0)) {
		    				for(int numRepeat = 0; numRepeat < (doubleVar / 2); numRepeat++) {
		    					print.print("██");
		    				}
		    				if (doubleVar % 2 == 1) {
		    					print.print("█");
		    					print.print(" ".repeat(100 - (doubleVar)) + b_verticalSpacesLine);
		    				}
		    			}   
		    			print.println();    
	            	}
    			}
	    		
	    		if(labelHolder100) {
	        		print.println(tabSpace + rep40  + " " + b_Texts + "└" + "─".repeat(102) + "┘" + c_Reset);
	        		print.println(tabSpace + rep40 + "  0" + rep8 + "10" +rep8 + "20" + rep8 + "30" + rep8 + "40" + rep8 + "50" + rep8  + "60" + rep8  + "70" + rep8  + "80" + rep8  + "90" + rep8  + "100");
	        		print.flush();
	    		}
	    		
	    		if(labelHolder1000) {
	        		print.println(newLines);
	        		print.println(valueHoldChanger = tabSpace + centerRepeat + " ".repeat(8) + b_Texts + "0–1000" + c_Reset);
	        		print.println(tabSpace + " ".repeat(41) + b_Texts + "┌" + "─".repeat(102) + "┐" + c_Reset);	
	    		}
	    		while((lines2 = br2.readLine()) != null) {
	    			String[] val = lines2.split(";");
	    			String newQuantity = val [4];
	            	int doubleVar =((int)(Double.parseDouble(newQuantity)));
	    		
	            	if((100 < (doubleVar) && (doubleVar) <= 1000) && (val[3].equals("none") == false)) 
	            		valueHoldChanger = tabSpace + centerRepeat + " ".repeat(8) + b_Texts + "0–1000" + c_Reset;    	
	            	if((100 < (doubleVar) && (doubleVar) <= 1000) && (val[3].equals("none") == false)) 
	            		print.print(tabSpace + " ".repeat(40 - (val[3].length())) + val[3] + b_verticalSpacesLine);	
	            	
	            	if ((100 < (doubleVar) && (doubleVar) <= 1000) && ((doubleVar == (0)) == false)) {	            		
	            		if((doubleVar == 1)) {
	    				print.print("█".repeat(doubleVar));
	    				print.print(" ".repeat((1000 - doubleVar) / 10) + b_verticalSpacesLine);
		    			}
		    			
		    			else if ((doubleVar % 2 == 0)) {
		    				for(int numRepeat = 0; numRepeat < (doubleVar / 10); numRepeat++) {
		    					print.print("█");
		    					
		    				}print.print(" ".repeat((1000 - doubleVar) / 10) + " |");
		    			}
		    			
		    			else if((doubleVar % 2 != 0)) {
		    				for(int numRepeat = 0; numRepeat < (doubleVar / 10); numRepeat++) {
		    					print.print("█");
		    					
		    				}
		    				if (doubleVar % 2 == 1) {
		    					print.print("█");
		    					print.print(" ".repeat((1000 - doubleVar) / 10) + b_verticalSpacesLine);
		    				}
		    			}
	            		print.println();
	            	}	      
	            	
	            }
	    		
	    		if (labelHolder1000) {
	    			print.println(tabSpace + rep40  + " " + b_Texts + "└" + "─".repeat(102) + "┘" + c_Reset);
					print.println(tabSpace + rep40 + "  0" + rep7 + "100" + rep7 + "200" + rep7 + "300" + rep7 + "400" + rep7 + "500" + rep7  + "600" + rep7  + "700" + rep7  + "800" + rep7  + "900" + rep7  + "1000");
					print.flush();
	    		}

	    		if (labelHolder10000) {
	    			print.println(newLines);
	    			print.println(valueHoldChanger = tabSpace + centerRepeat + " ".repeat(7) + b_Texts + "0–10000" + c_Reset);
	    			print.println(tabSpace + " ".repeat(41) + b_Texts + "┌" + "─".repeat(102) + "┐" + c_Reset);	
	    		}

	    		while((lines3 = br3.readLine()) != null) {
	    			String[] val = lines3.split(";");
	    			String newQuantity = val [4];
	            	int doubleVar =((int)(Double.parseDouble(newQuantity)));

	            	if((1000 < (doubleVar) && (doubleVar) <= 10000) && (val[3].equals("none") == false)) 
	            		valueHoldChanger = tabSpace + centerRepeat + " ".repeat(8) + b_Texts + "0–1000" + c_Reset;    	
	            	if((1000 < (doubleVar) && (doubleVar) <= 10000) && (val[3].equals("none") == false)) 
	            		print.print(tabSpace + " ".repeat(40 - (val[3].length())) + val[3] + b_verticalSpacesLine);	
	            	
	            	if ((1000 < (doubleVar) && (doubleVar) <= 10000) && ((doubleVar == (0)) == false)) {	            		
	            		if((doubleVar == 1)) {
	            			print.print("█".repeat(doubleVar));
	    					print.print(" ".repeat((10000 - doubleVar) / 100) + b_verticalSpacesLine);
		    			}
		    			
		    			else if ((doubleVar % 2 == 0)) {
		    				for(int numRepeat = 0; numRepeat < (doubleVar / 100); numRepeat++) {
		    					print.print("█");
		    					
		    				}print.print(" ".repeat((10000 - doubleVar) / 100) + " |");
		    			}
		    			
		    			else if((doubleVar % 2 != 0)) {
		    				for(int numRepeat = 0; numRepeat < (doubleVar / 100); numRepeat++) {
		    					print.print("█");
		    					
		    				}
		    				if (doubleVar % 2 == 1) {
		    					print.print("█");
		    					print.print(" ".repeat((10000 - doubleVar) / 100) + b_verticalSpacesLine);
		    				}
		    			}
	            		print.println();
	            	}	
	            }
	    		
	    		if (labelHolder10000) {
	    			print.println(tabSpace + rep40  + " " + b_Texts + "└" + "─".repeat(102) + "┘" + c_Reset);
					print.println(tabSpace + rep40 + "  0" + rep6 + "1000" + rep6 + "2000" + rep6 + "3000" + rep6 + "4000" + rep6 + "5000" + rep6 + "6000" + rep6  + "7000" + rep6  + "8000" + rep6  + "9000" + rep6  + "10000");
					print.flush();
	    		}
					
				// END OF ITEM QUANTITY
	    		if ((lines1 = br1.readLine())!= null || (lines2 = br2.readLine()) != null || (lines3 = br3.readLine()) != null){
    				System.out.println(tabSpace + rep40 + b_Texts + " The Text File is Currently Empty..." + c_Reset);
    				break;
    			}		            	
	    		br1.close();
	    		br2.close();
	    		br3.close();
	    		brAI100.close();
	    		brAI1000.close();
	    		brAI10000.close();
	    	}
	    	
	    	catch(Exception e) {
	    		System.out.println(tabSpace + rep40 + b_Texts + "Something Went Wrong in DashboardInventory: " + c_Reset + c_Red + e.getMessage() + c_Reset);
	    	}
			
			finally {        		
				System.out.println(newLines + newLines);
				repeatingChooseAgainInventory();
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
	private static int itemID;
	boolean continueProcess;
	
	public void setContinueProcess(boolean setContinueProcess) {
		this.continueProcess = setContinueProcess;
	}
	
	public boolean getContinueProcess() {
		return continueProcess;
	}
	
	// ACCES UPDATE/WRITES for Adding an Item 
    public static void setItemInventory() {
    	//MEHODS
    	Logics_Inventory mths = new Logics_Inventory();
    	PrintWriter print = new PrintWriter(System.out);
    	
    	// VARIABLES
    	final int repFirst = 85;
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
			print.println("\t " + b_Texts + "┌" + "─".repeat(170) + "┐" + c_Reset);
	    	final String addItem = tabLine + dashBFormat + " " + """
	    			 █████████╗ ██████████╗ ██████████╗        █████████╗███████████╗█████████╗████╗    ████╗""" + " ".repeat(42) + "│ \n" +
	    			tabLine + dashBFormat + """
	    			███╔════███╗███╔════███╗███╔════███╗          ███╔══╝    ███╔═══╝███╔═════╝█████╗  █████║""" + " ".repeat(42) + "│ \n" +
	    			tabLine + dashBFormat + """
	    			███████████║███║    ███║███║    ███║          ███║       ███║    ██████╗   ███╔█████╔███║""" + " ".repeat(42) + "│ \n" +
	    			tabLine + dashBFormat + """ 
	    			███╔════███║███║    ███║███║    ███║          ███║       ███║    ███╔══╝   ███║╚███╔╝███║""" + " ".repeat(42) + "│ \n" +
	    			tabLine + dashBFormat + """
	    			███║    ███║██████████╔╝██████████╔╝       █████████╗    ███║    █████████╗███║ ╚══╝ ███║""" + " ".repeat(42) + "│ \n" +
	    			tabLine + dashBFormat + """
	    			╚══╝    ╚══╝╚═══════╝   ╚═══════╝          ╚════════╝    ╚══╝    ╚════════╝╚══╝      ╚══╝""" + " ".repeat(42) + "│" + """
	    			""";
    		print.println(addItem);
    		print.println(tabSpace + "└" + "─".repeat(170) + "┘");
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
				System.out.println(" ".repeat(60) + b_Texts + "│" + c_Reset + " Enter: │" + c_Green + " ".repeat(11) + " Item Name" + c_Reset + 
								   ";" + " ".repeat(10) + b_Texts + "│" + c_Reset +
								   " ".repeat(4) + " or '" + c_Green + "." + c_Reset + "' to Exit " +  b_Texts + " ".repeat(4) + "│" + c_Reset);
				System.out.println(b_Texts + " ".repeat(60) + "└" + "─".repeat(8) + "┴" + "─".repeat(32) + "┴" + "─".repeat(24) + "┘" + c_Reset);
				
		        System.out.print(" ".repeat(68) + c_Green + b_Texts + " —> " + c_Reset);						
		        String nameOption = mths.scan.nextLine().trim();
				
				if (nameOption != ".") {
					item = nameOption;
					mths.setContinueProcess(true);
				}
				
				if (nameOption.equalsIgnoreCase(".")) {
					mths.setContinueProcess(false);
					break;
				}
									
				if (mths.getContinueProcess()) {
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
				
				if (mths.getContinueProcess()) {
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
				
				System.out.println(b_Texts + " ".repeat(65) + "─".repeat(60) + c_Reset);
				print.println("\n");
				break;
			}
			if (mths.getContinueProcess() == false) {
				System.out.println(b_Texts + " ".repeat(65) + "─".repeat(60) + c_Reset);
			}
			
			String groupPrintingHolder = "";
        	int numRepHolder = 0;
        	int numRep2Holder = 0;
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
		                    		numRepHolder = numRep;
		                    		numRep2Holder = numRep2;
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
		                    
		                    if (total % 2 == 0) {
		                    	System.out.println();
		                    }
		                    groupPrintingHolder = groupPrinting;
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
	            	if (dupli.size() % 2 == 0) {
	            		if (dupli.size() == 2) {
	                    	print.println(b_Texts + " ".repeat(59) + "└" + "─".repeat(37) + "┴" + "─".repeat(32) + "┘" + c_Reset);
                    		print.flush();
	            		}
	            		
	            		else if (dupli.size() > 2) {
	                    	print.println(b_Texts + " ".repeat(59) + "└" + "─".repeat(37) + "┴" + "─".repeat(32) + "┘" + c_Reset);
                    		print.flush();
	            		}
	            	}
	            	
	            	if (dupli.size() % 2 != 0) {
	            		if (dupli.size() <= 3) {
	                    	System.out.print(" ".repeat(29 - (groupPrintingHolder.length() + numRep2Holder)) + b_verticalLine + "    [" + c_Green + b_Texts + "N" + c_Reset + "] " + c_Green + b_Texts + "GRP NAME" + c_Reset + " ".repeat(24 - ("GRP NAME".length() + numRepHolder)) + b_verticalLine);
	                    	System.out.println();
		            		print.println(b_Texts + " ".repeat(59) + "└" + "─".repeat(37) + "┴" + "─".repeat(32) + "┘" + c_Reset);
	                		print.flush();
	            		}
	            		
	            		else if (dupli.size() > 3) {
	                    	System.out.print(b_verticalLine + "    [" + c_Green + b_Texts + "N" + c_Reset + "] " + c_Green + b_Texts + "GRP NAME" + c_Reset + " ".repeat(24 - ("GRP NAME".length() + numRepHolder)) + b_verticalLine);
	                    	System.out.println();
		            		print.println(b_Texts + " ".repeat(59) + "└" + "─".repeat(37) + "┴" + "─".repeat(32) + "┘" + c_Reset);
	                		print.flush();
	            		}

	            	}
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
	                    System.out.println(" ".repeat(62) + "│" + " ".repeat(15) + "Or Enter '" + c_Green + "." + c_Reset + "'" + b_Texts + " (" + c_Green + "Period" + c_Reset + ") to Create New" + " ".repeat(14) + "│");
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
				                    System.out.println(" ".repeat(62) + "│" + " ".repeat(18) + "Or Enter '" + c_Green + "." + c_Reset + "'" + b_Texts + " (" + c_Green + "Period" + c_Reset + ") to Create New" + " ".repeat(11) + "│");
									System.out.println(b_Texts + " ".repeat(62) + "└" + "─".repeat(64) + "┘" + c_Reset);
				                    System.out.print(" ".repeat(68) + c_Green + b_Texts + " —> " + c_Reset);
				                    groupOption = mths.scan.nextLine().trim();
				                    continue;
			                    }
	                    		
	                    	}
	                    	group = groups.get(choice - 1);
							mths.setContinueProcess(true);	
							System.out.println(" ".repeat(85) + "Selected: [" + c_Green + b_Texts + choice + c_Reset + "] " + c_Green + b_Texts + group + c_Reset);
							System.out.println(b_Texts + " ".repeat(65) + "─".repeat(60) + c_Reset);
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
                    	mths.setContinueProcess(true);	
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
						System.out.println(b_Texts + " ".repeat(60) + "┌" + "─".repeat(70) + "┐" + c_Reset);
						System.out.println( " ".repeat(60) + b_verticalLine + " ".repeat(20) + b_Texts + "Is the Item " + c_Green +  "Perishable" + c_Reset +  " or " + c_Green + "Not?" + c_Reset + " ".repeat(20) + b_verticalLine);
						System.out.println(b_Texts + " ".repeat(60) + "└" + "─".repeat(70) + "┘" + c_Reset);
						
						System.out.println(b_Texts + " ".repeat(70) + "┌" + "─".repeat(24) + "┬" + "─".repeat(24) + "┐" + c_Reset);
						System.out.print(" ".repeat(70) + b_verticalLine + " ".repeat(9) + "[" + c_Green + b_Texts + "1" + c_Reset + "]" + c_Green + " Yes" + c_Reset + " ".repeat(8) + b_verticalLine + c_Reset);						
						System.out.println(" ".repeat(9) + "[" + c_Green + b_Texts + "2" + c_Reset + "]" + c_Green +  " No" + c_Reset + " ".repeat(9) + b_verticalLine + c_Reset);
						System.out.println(b_Texts + " ".repeat(70) + "├" + "─".repeat(24) + "┴" + "─".repeat(24) + "┤" + c_Reset);
						System.out.println(" ".repeat(70) + b_verticalLine + " ".repeat(15) + "[" + c_Green + b_Texts + "3" + c_Reset + "]" + c_Green + " Exit Adding Item" + " ".repeat(14) + c_Reset + b_verticalLine);						
						System.out.println(b_Texts + " ".repeat(70) + "└" + "─".repeat(49) + "┘" + c_Reset);
						System.out.print(" ".repeat(70) + c_Green + b_Texts + " —> " + c_Reset);
						String perishableHolderDecision = mths.scan.nextLine().trim();
						
						if (perishableHolderDecision.equalsIgnoreCase("Yes") || perishableHolderDecision.equals("1")) {
							System.out.println(b_Texts + " ".repeat(65) + "─".repeat(60) + c_Reset);
							System.out.println(" ".repeat(70) + " Foramt: '" + c_Green + b_Texts + "MM" + c_Reset + "\\" + c_Green + b_Texts + "DD" + c_Reset + "\\" + c_Green + b_Texts + "YYYY" + c_Reset + "'");
							System.out.print(" ".repeat(70) + c_Green + b_Texts + " —> " + c_Reset);
							perishableDecision =  mths.scan.nextLine().trim();
							System.out.print(" ".repeat(repFirst - "Expiration:".length()) + strSpace + " ".repeat(repSecond - "Expiration:".length()) + " Expiration: " + c_Green + perishableDecision + c_Reset);
							mths.setContinueProcess(true);
							break;
						}
						
						else if(perishableHolderDecision.equalsIgnoreCase("No") || perishableHolderDecision.equals("2")) {
							System.out.println(" ".repeat(repFirst - "Expiration:".length()) + strSpace + " ".repeat(repSecond - "Expiration:".length()) + " Expiration: " + c_Green + "No Expiration Date" + c_Reset);
							perishableDecision = "0\\0\\0";
							System.out.println(b_Texts + " ".repeat(65) + "─".repeat(60) + c_Reset);
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
		            	FileReader fR = new FileReader(mths.fPath.toString());
		            	BufferedReader brID = new BufferedReader(fR);
				        String LINE;
				        
				        while ((LINE = brID.readLine()) != null) {
				        	String[] DATA = LINE.split("_");
				        	
				        	int convertedID = (int) Integer.parseInt(DATA[1]);
				        	itemID = convertedID + 1;
				        	System.out.println(itemID);
				        }
				        brID.close();
					}
					
					catch (Exception e) {
						System.out.println(e.getLocalizedMessage());
					}
					
					try {
						System.out.println("\n\n\n\n\n");

						System.out.println(tabSpace + " " + "—".repeat(170));
						System.out.println(tabSpace + centerRepeat + b_Texts + "CHECK ENTERED DETAILS" + c_Reset); 
						System.out.println(b_Texts + " ".repeat(50) + "┌" + "─".repeat(29) + "┬" + "─".repeat(29) + "┬" + "─".repeat(30) + "┐" + c_Reset);
						System.out.println(" ".repeat(50) + b_verticalLine + " Item Name: " + c_Green + item + c_Reset + " ".repeat(17 - item.length()) + b_verticalLine + " Quantity: " + c_Green + quant + c_Reset + " ".repeat(18 - quant.length()) + b_verticalLine + " Price: " + c_Green + price + c_Reset + " ".repeat(22 - price.length()) + b_verticalLine);
						System.out.println(b_Texts + " ".repeat(50) + "├" + "─".repeat(29) + "┴" + "─".repeat(14) + "┬" + "─".repeat(14) + "┴" + "─".repeat(30) + "┤" + c_Reset);
						
						if (perishableDecision.equalsIgnoreCase("\\0\\0\\0\\"))
							System.out.println(" ".repeat(50) + b_verticalLine + "     Group: " + c_Green + group + c_Reset + " ".repeat(32 - group.length()) + b_verticalLine + " ".repeat(4) + " Expiration Date: " + c_Green + "No Date" + c_Reset +" ".repeat(23 - "No Date".length()) + b_verticalLine);
						
						if (perishableDecision != "\\0\\0\\0\\")
							System.out.println(" ".repeat(50) + b_verticalLine + "     Group: " + c_Green + group + c_Reset +" ".repeat(32 - group.length()) + b_verticalLine + " ".repeat(4) + " Expiration Date: " + c_Green + perishableDecision + c_Reset + " ".repeat(23 - perishableDecision.length()) + b_verticalLine);
						
						System.out.println(b_Texts + " ".repeat(50) + "└" + "─".repeat(44) + "┴" + "─".repeat(45) + "┘" + c_Reset);
						
						System.out.println("\n");
						System.out.println(b_Texts + " ".repeat(60) + "┌" + "─".repeat(70) + "┐" + c_Reset);
						System.out.println(" ".repeat(60) + b_verticalLine + " ".repeat(16) + "Do you " + c_Green + "Confirm" + c_Reset + " or do you want to " + c_Green + "Re-enter" + c_Reset + "?" + " ".repeat(12) + b_verticalLine);
						System.out.println(b_Texts + " ".repeat(60) + "└" + "─".repeat(70) + "┘" + c_Reset);
						
						System.out.println(b_Texts + " ".repeat(60) + "┌" + "─".repeat(35) + "┬" + "─".repeat(34) + "┐" + c_Reset);
						System.out.print(" ".repeat(60) + b_verticalLine + " ".repeat(10) + "[" + c_Green + "1" + c_Reset + "]" + " Yes, Confirm" + " ".repeat(9) + b_verticalLine + " ".repeat(10));
						
						System.out.println("[" + c_Green + "2" + c_Reset + "]" + " No, Re-entry" + " ".repeat(8) + b_verticalLine);						
						System.out.println(" ".repeat(60) + "└" + "─".repeat(35) + "┴" + "─".repeat(34) + "┘" + c_Reset);
						System.out.print(" ".repeat(69) + c_Green + b_Texts + " —> " + c_Reset);
						String numOrStr = mths.scan.nextLine().trim();
						if(numOrStr.equals("1") || numOrStr.equalsIgnoreCase("Yes") || numOrStr.equalsIgnoreCase("Confirm") || numOrStr.equalsIgnoreCase("Yes, Confirm") || numOrStr.equalsIgnoreCase("Yes Confirm")) {
							mths.writer.write(now + " ;");
							
							mths.writer.write(Logics_ProfileUser.getEnteredUsername() + ";");
							mths.writer.write(Logics_ProfileUser.getEnteredPassword() + ";");
							mths.writer.write(item + ";");
							mths.writer.write(quant + ";");
							mths.writer.write(price + ";");
			            	mths.writer.write(group + ";");
							mths.writer.write("\\" + perishableDecision + "\\" + ";");
							
							mths.writer.write("ID_" + itemID + "_;");
							
							Logics_Group mths1= new Logics_Group();
							mths1.writer = new FileWriter(mths.fPathGrp.toString(), true);
							mths1.writer.write(now + " ;");
							mths1.writer.write(Logics_ProfileUser.getEnteredUsername() + ";");     // USERNAME
							mths1.writer.write(Logics_ProfileUser.getEnteredPassword() + ";"); // PASSWORD
							mths1.writer.write("none;");            // ITEMNAME "none" so it can be ignored in DASHBOARD and INVENTORY LIST
							mths1.writer.write("0;");                // QUANTITY
							mths1.writer.write("0;");                // PRICE
							mths1.writer.write(group + ";");
							mths1.writer.write("no date;"); 
							mths1.writer.write("no ID;"); 
							
							mths1.writer.write("\n");
							mths1.writer.flush();
							mths1.writer.close();
							
							mths.writer.write("\n");
							mths.writer.flush();
							mths.writer.close();
						}
						
						else if (numOrStr.equals("2") || numOrStr.equalsIgnoreCase("No") || numOrStr.equalsIgnoreCase("Re-entry") || numOrStr.equalsIgnoreCase("No, Confirm") || numOrStr.equalsIgnoreCase("No Re-entry") || numOrStr.equalsIgnoreCase("No Reentry")) {
							setItemInventory();
							break;
						}
					}
					catch(Exception e) {
						e.fillInStackTrace();
					}
				}
			repeatingChooseAgainInventory();
			}
			break;
		}
	}
    
	
   public static void setNewGroupInventory() {
    	//METHODS
	   	Logics_Inventory mths = new Logics_Inventory();
    	PrintWriter print = new PrintWriter(System.out);
    	
    	// VARIABLES
    	final String dashBFormat = " ".repeat(38);
    	
    	while(true) {
			try {
			mths.writer = new FileWriter(mths.fPathGrp.toString(), true);

			print.println("\n");
			print.println("\t " + b_Texts + "┌" + "─".repeat(170) + "┐" + c_Reset);
	    	final String addItem = tabLine + dashBFormat + " " + """
	    			 █████████╗ ██████████╗ ██████████╗         ████████╗█████████╗  █████████╗ ███╗   ███╗█████████╗  """ + " ".repeat(34) + "│ \n" +
	    			tabLine + dashBFormat + """
	    			███╔════███╗███╔════███╗███╔════███╗       ███╔═════╝███╔═══███╗███╔════███╗███║   ███║███    ███╗ """ + " ".repeat(33) + "│ \n" +
	    			tabLine + dashBFormat + """
	    			███████████║███║    ███║███║    ███║       ███║ ████╗█████████╔╝███║    ███║███║   ███║█████████╔╝ """ + " ".repeat(33) + "│ \n" +
	    			tabLine + dashBFormat + """ 
	    			███╔════███║███║    ███║███║    ███║       ███║  ███║███╔═══███╗███║    ███║███║   ███║███╔═════╝  """ + " ".repeat(34) + "│ \n" +
	    			tabLine + dashBFormat + """
	    			███║    ███║██████████╔╝██████████╔╝       ╚████████║███║   ███║╚█████████╔╝ ████████╔╝███║        """ + " ".repeat(40) + "│ \n" +
	    			tabLine + dashBFormat + """
	    			╚══╝    ╚══╝╚═══════╝   ╚═══════╝           ╚═══════╝╚══╝   ╚══╝ ╚════════╝  ╚═══════╝ ╚══╝        """ + " ".repeat(40) + "│" + """
	    			""";
	    	
    		print.println(addItem);
    		print.println(tabSpace + b_Texts + "└" + "─".repeat(170) + "┘");
        	print.println(tabSpace + "█".repeat(172));
    		print.flush();
		    		
			print.println("\n");
			print.println(tabSpace + " " + "—".repeat(170));
			print.println(tabSpace + centerRepeat + " ".repeat(5) + b_Texts + "ADDING A GROUP" + c_Reset); 
			print.println(b_Texts + " ".repeat(49) + "┌" + "─".repeat(45) + "┬" + "─".repeat(44) + "┐" + c_Reset);
			print.println( " ".repeat(49) + b_verticalLine + " ".repeat(12) + c_Green + b_Texts + "ENTER THE NEW GROUP" + c_Reset + ";" + " ".repeat(13) + 
						  b_verticalLine + " ".repeat(12) + "or Enter '" + c_Green + "." + c_Reset + "' to Exit"+ " ".repeat(12) + b_verticalLine + c_Reset); 
			print.println(b_Texts + " ".repeat(49) + "└" + "─".repeat(45) + "┴" + "─".repeat(44) + "┘"  + c_Reset);
			print.flush();

	        
			print.flush();
				while(true) {				
					System.out.print(subCR53 + c_Green + b_Texts + " —> " + c_Reset);    
					String groupHolder =  mths.scan.nextLine().trim();            
					
					if (groupHolder != ".") {
						group = groupHolder;
						mths.setContinueProcess(true);
					}
					
					if (group.equals(".")) {
						mths.setContinueProcess(false);
						break;
					}
					
					System.out.println(b_Texts + " ".repeat(65) + "—".repeat(60) + c_Reset);
					System.out.println();
					break;
				}
			}
			
			catch (InputMismatchException e) {
				if ((e.getMessage() == null)) {
					System.out.println(e + "INVALID INPUT: Entered String to a supposed Integer/Number");
				}
				mths.scan.nextLine();
			}
			
			catch(IOException e) {
				if ((e.getMessage() == null)) {
					System.out.println("FILE INPUT ERROR: Something went wrong with the File...");
				}
				mths.scan.nextLine();
			}
			
			finally {      
				if(mths.getContinueProcess()) { 	
					try {
						Date now = new Date();	
						mths.writer.write(now + " ;");   // DATE ENTERED
						mths.writer.write(Logics_ProfileUser.getEnteredUsername() + ";");     // USERNAME
						mths.writer.write(Logics_ProfileUser.getEnteredPassword() + ";"); // PASSWORD
						mths.writer.write("none;");            	// ITEMNAME "none" so it can be ignored in DASHBOARD and INVENTORY LIST
						mths.writer.write("0;");                // QUANTITY
						mths.writer.write("0;");    			// PRICE
						mths.writer.write(group + ";"); // HIGHLIGHT
						mths.writer.write("no date;");           // EXPIRATION DATE	
						mths.writer.write("\n");
						mths.writer.flush();
						mths.writer.close();
					}
					
					catch (Exception e) {
						System.out.println(e + "EXCEPTION IN LINventory_Group");
					}
				}
				System.out.println(newLines + newLines);
				repeatingChooseAgainInventory();
			}
			break;
		}
    }
   	   
	
	public static void repeatingChooseAgainInventory() {
		// METHODS
		Logics_Inventory mths = new Logics_Inventory();
		while(true) {
			try {
				// Internal Decision to repeat or to choose other Action
				System.out.println("\n");
	        	System.out.println(tabSpace + " " + "—".repeat(170));
				System.out.println(tabSpace);
	        	System.out.println(centerRepeat +  b_Texts + "============================================" + c_Reset);
		    	System.out.println(tabSpace + " ".repeat(72) + b_Texts + "CHOOSE AGAIN OR EXIT THE PROGRAM" + c_Reset);
	            System.out.println(tabSpace + minorCR43 + b_Texts + " ┌" + "─".repeat(40) + "┬" + "─".repeat(41) + "┐" + c_Reset);

		    	System.out.print(subCR53 + b_verticalLine + "  [" + c_Green + b_Texts + "1" + c_Reset + "]" + c_Green + b_Texts + " Show Inventory List" + c_Reset);
		        System.out.println(" ".repeat(15) + b_verticalLine + " ".repeat(2) + "[" + c_Green + b_Texts + "2" + c_Reset + "]" + c_Green + b_Texts + " Show Inventory Dashboard " + " ".repeat(10) + c_Reset + b_verticalLine);
		        
		        System.out.println(tabSpace + minorCR43 + b_Texts + "" +  " ├" + "─".repeat(40) + "┼" + "─".repeat(41) + "┤" + c_Reset);
		        
		        System.out.print(subCR53 + b_verticalLine + "  [" + c_Green + b_Texts + "3" + c_Reset + "]" + c_Green + b_Texts + " Add an Item" + c_Reset);
		        System.out.println(" ".repeat(23) + b_verticalLine + " ".repeat(2) + "[" + c_Green + b_Texts + "4" + c_Reset + "]" + c_Green + b_Texts + " Add a Group or Category " + " ".repeat(11) + c_Reset + b_verticalLine );
		        System.out.println(tabSpace + minorCR43 + b_Texts + "" +  " ├" + "─".repeat(40) + "┴" + "─".repeat(41) + "┤" + c_Reset);
		        
		        System.out.println(" ".repeat(53) + b_verticalLine + " ".repeat(31) + "[" + c_Green + b_Texts + "5" + c_Reset + "]" + c_Green + b_Texts + " Exit and Go Back" + c_Reset + " ".repeat(31) + b_verticalLine);
		        System.out.println(tabSpace + minorCR43 + b_Texts +  " └" + "─".repeat(82) + "┘" + c_Reset);
		        System.out.print(subCR53 + b_Texts + " —> " + c_Reset);
				String numOrStr = mths.scan.nextLine().trim();
				
				System.out.println(newLines);
				
				if (numOrStr.equalsIgnoreCase("Show Inventory List") || numOrStr.equalsIgnoreCase("Show List") || numOrStr.equalsIgnoreCase("Show List") || numOrStr.equals("1")) {
					Logics_Inventory.getWrittenInventory();
					break;
				}
				
				else if (numOrStr.equalsIgnoreCase("Show Inventory Dashboard") || numOrStr.equalsIgnoreCase("Show Dashboard") || numOrStr.equalsIgnoreCase("Dashboard") || numOrStr.equals("2")) {
					Logics_Inventory.getDashboardInventory();
					break;
				}
				
				else if (numOrStr.equalsIgnoreCase("Add an Item") || numOrStr.equalsIgnoreCase("Add") || numOrStr.equals("3")) {
					Logics_Inventory.setItemInventory();
					break;
				}
				
				else if (numOrStr.equalsIgnoreCase("Add a Group or Category") || numOrStr.equals("4")) {
					Logics_Inventory.setNewGroupInventory();
					break;
				}
				
				else if (numOrStr.equalsIgnoreCase("Exit and Go Back") || numOrStr.equals("5")){
					System.out.println(tabLine + b_Texts + "Exited and Went Back..." + c_Reset);
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