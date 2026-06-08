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
    static String u_Texts = "\u001B[4m";
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
            System.out.println(tabSpace + minorCR43 + b_Texts +  "—".repeat(86) + "" + c_Reset);

	    	System.out.print(subCR53 + b_verticalLine + "  [" + b_Texts + "1" + c_Reset + "]" + b_Texts + " Show Inventory List" + c_Reset);
	        System.out.println(" ".repeat(15) + b_verticalLine + " ".repeat(11) + "[" + b_Texts + "2" + c_Reset + "]" + b_Texts + " Show Inventory Dashboard  " + b_verticalLine + c_Reset);
	        System.out.println(tabSpace + minorCR43 + b_Texts + "" +  "—".repeat(86) + c_Reset);
	        
	        System.out.print(subCR53 + b_verticalLine + "  [" + b_Texts + "3" + c_Reset + "]" + b_Texts + " Add an Item" + c_Reset);
	        System.out.println(" ".repeat(23) + b_verticalLine + " ".repeat(11) + "[" + b_Texts + "4" + c_Reset + "]" + b_Texts + " Add a Group or Category   " + b_verticalLine + c_Reset);
	        System.out.println(tabSpace + minorCR43 + b_Texts + "" +  "—".repeat(86) + "" + c_Reset);
	        
	        System.out.println(" ".repeat(53) + b_verticalLine + " ".repeat(31) + "[" + b_Texts + "5" + c_Reset + "]" + b_Texts + " Exit and Go Back" + c_Reset + " ".repeat(31) + b_verticalLine);
	        System.out.println(tabSpace + minorCR43 + b_Texts +  "—".repeat(86) + "" + c_Reset);
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
				
    			BufferedReader brIL = Files.newBufferedReader(mths.fPath);
				BufferedReader brIL1 = new BufferedReader(new FileReader(mths.fPath.toString()));
    			String LINE = "";
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
	        	print.println("\t " + b_Texts + "—".repeat(172) + c_Reset);
		    	final String dashboard = tabLine + dashBFormat + """
		    			█████████╗   █████████╗ █████████╗███╗    ███╗██████████╗  █████████╗  █████████╗ █████████╗ ██████████╗   """ + " ".repeat(34) + "| \n" +
		    			tabLine + dashBFormat + """
		    			███╔════███╗███╔════███╗███╔═════╝███║    ███║███╔════███╗███╔════███║███╔════███╗███╔═══███╗███╔════███╗  """ + " ".repeat(33) + "| \n" +
		    			tabLine + dashBFormat + """
		    			███║    ███║███████████║█████████╗███████████║██████████╔╝███║    ███║███████████║█████████╔╝███║    ███║  """ + " ".repeat(33) + "| \n" +
		    			tabLine + dashBFormat + """ 
		    			███║    ███║███╔════███║╚═════███║███╔════███║███╔════███╗███║    ███║███╔════███║███╔═══███╗███║    ███║  """ + " ".repeat(33) + "| \n" +
		    			tabLine + dashBFormat + """
		    			█████████╔╝ ███║    ███║█████████║███║    ███║██████████╔╝╚█████████╔╝███║    ███║███║   ███║██████████╔╝  """ + " ".repeat(33) + "| \n" +
		    			tabLine + dashBFormat + """
		    			╚═══════╝   ╚══╝    ╚══╝╚════════╝╚══╝    ╚══╝╚═════════╝  ╚════════╝ ╚══╝    ╚══╝╚══╝   ╚══╝╚═════════╝   """ + " ".repeat(34) + "|" + """
		    			""";
	    		print.println(dashboard);
	    		print.println(tabSpace + "—".repeat(172));
	        	print.println(tabSpace + "█".repeat(172));
	    		print.flush();

	    		print.println("\n");
	    		print.println(tabSpace + " " + "—".repeat(170));
	    		
	    		print.println(tabSpace + centerRepeat + " ".repeat(4) + b_Texts + "ITEM QUANTITY" + c_Reset); 
	    		String valueHoldChanger = (tabSpace + centerRepeat + " ".repeat(8) + b_Texts + "0–100" + c_Reset);
	    		print.println(valueHoldChanger);
	    		print.println(tabSpace + " ".repeat(41) + b_Texts + "—".repeat(104) + c_Reset);	
	    		

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
	        		print.println(tabSpace + rep40  + " " + b_Texts + "_".repeat(104) + c_Reset);
	        		print.println(tabSpace + rep40 + "  0" + rep8 + "10" +rep8 + "20" + rep8 + "30" + rep8 + "40" + rep8 + "50" + rep8  + "60" + rep8  + "70" + rep8  + "80" + rep8  + "90" + rep8  + "100");
	        		print.flush();
	    		}

        		print.println(newLines);
        		print.println(valueHoldChanger = tabSpace + centerRepeat + " ".repeat(8) + b_Texts + "0–1000" + c_Reset);
        		print.println(tabSpace + " ".repeat(41) + b_Texts + "—".repeat(104) + c_Reset);	

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
	    			print.println(tabSpace + rep40  + " " + b_Texts + "_".repeat(104) + c_Reset);
					print.println(tabSpace + rep40 + "  0" + rep7 + "100" + rep7 + "200" + rep7 + "300" + rep7 + "400" + rep7 + "500" + rep7  + "600" + rep7  + "700" + rep7  + "800" + rep7  + "900" + rep7  + "1000");
					print.flush();
	    		}

			
    			print.println(newLines);
    			print.println(valueHoldChanger = tabSpace + centerRepeat + " ".repeat(7) + b_Texts + "0–10000" + c_Reset);
    			print.println(tabSpace + " ".repeat(41) + b_Texts + "—".repeat(104) + c_Reset);	

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
	    			print.println(tabSpace + rep40  + " " + b_Texts + "_".repeat(104) + c_Reset);
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
	

	// ACCES UPDATE/WRITES for Adding an Item 
    public static void setItemInventory() {
    	//METHODS
    	Logics_Inventory mths = new Logics_Inventory();
    	PrintWriter print = new PrintWriter(System.out);
    	
    	while(true) {
    		// VARIABLE
        	final String dashBFormat = " ".repeat(38);
        	String perishable;
        	final int repFirst = 70;
        	final String strSpace = " ";
        	final int repSecond = 15;
        	final int repThird = 80;
        	Set <String> dupli = new HashSet<>();
        	List <String> groups = new ArrayList<>();
            Set <String> duppli2 = new HashSet<>();
            
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
    					mths.writer.write(mths.currency.format(price) + ";");
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
	                    	System.out.print(" ".repeat(59) + "    [" + c_Green + b_Texts + total + c_Reset + "] " + c_Green + b_Texts + group + c_Reset);
	                    }
	                    
	                    if (total % 2 == 0) {
	                    	System.out.print( "    [" + c_Green + b_Texts + total + c_Reset + "] " + c_Green + b_Texts + group + c_Reset + " ".repeat(24 - (group.length() + numRep)));
	                    }
	                    
	                    if (brAI.ready()) 
	                    	System.out.print(" ".repeat(29 - (group.length() + numRep2)));
	                    
	                    if (total % 2 == 0) 
	                    	System.out.println();
	                }
                } 
            	brAI.close();
            }
    	
            catch (IOException e) {
                e.printStackTrace();
                return;
            }
            
            finally {
            	System.out.print("");
            	print.println(b_Texts + " ".repeat(59) + "—".repeat(72) + c_Reset);
            	print.flush();
            }
            
            while (true) {
	            try {
	            	System.out.println("[" + "1" + "]" + "Choose Corresponding Number");
	            	System.out.println("[" + "2" + "]" + "Choose to Create New Group ");
	            	
	            	String numOrStr = mths.scan.nextLine();
	            	
	            	if (numOrStr.equals("1") || numOrStr.equalsIgnoreCase("Number") || numOrStr.equalsIgnoreCase("Choose Number") || numOrStr.equalsIgnoreCase("Corresponding") || numOrStr.equalsIgnoreCase("Choose Corresponding")) {
	            		try {
		            	FileReader fR = new FileReader(mths.fPath.toString());
		            	BufferedReader brAI = new BufferedReader(fR);
				        String LINE;
				        
				        while ((LINE = brAI.readLine()) != null) {
				            String[] DATA = LINE.split(";", -1);
				            String groupData = DATA.length > 7 ?DATA[7].trim():"";
				            
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
			            break;
	            	}
		            
		            else if (numOrStr.equals("2") || numOrStr.equalsIgnoreCase("Create") || numOrStr.equalsIgnoreCase("Choose Create") || numOrStr.equalsIgnoreCase("New Group") || numOrStr.equalsIgnoreCase("Choose to Create New Group")) {
		            	System.out.print("Enter Only The" + b_Texts + c_Green + " NUMBER " + c_Reset + "of the group to select (1-" + groups.size() + "): ");
	                    String newGroup = mths.scan.nextLine().trim();
	                    mths.writer.write(newGroup + ";");
	                    break;
		            }
	            	
		            else if (numOrStr.isEmpty() || numOrStr.equals("") || numOrStr.equals(" ")){
						System.out.println(tabSpace + minorCR48 + "Try Another: ");
						Logics_Inventory.repeatingChooseAgainInventory();
						break;
					}
	            	
	            }
            
	            catch(Exception e) {
		    		System.out.println(tabSpace + " ".repeat(50 - ("Something Went Wrong in setItemInventory").length()) + tabLine + " ".repeat(10));
				}
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
				System.out.println(newLines + newLines);
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
			print.println("\t " + b_Texts + "—".repeat(172) + c_Reset);
	    	final String addItem = tabLine + dashBFormat + " " + """
	    			 █████████╗ ██████████╗ ██████████╗         ████████╗█████████╗  █████████╗ ███╗   ███╗█████████╗  """ + " ".repeat(34) + "| \n" +
	    			tabLine + dashBFormat + """
	    			███╔════███╗███╔════███╗███╔════███╗       ███╔═════╝███╔═══███╗███╔════███╗███║   ███║███    ███╗ """ + " ".repeat(33) + "| \n" +
	    			tabLine + dashBFormat + """
	    			███████████║███║    ███║███║    ███║       ███║ ████╗█████████╔╝███║    ███║███║   ███║█████████╔╝ """ + " ".repeat(33) + "| \n" +
	    			tabLine + dashBFormat + """ 
	    			███╔════███║███║    ███║███║    ███║       ███║  ███║███╔═══███╗███║    ███║███║   ███║███╔═════╝  """ + " ".repeat(34) + "| \n" +
	    			tabLine + dashBFormat + """
	    			███║    ███║██████████╔╝██████████╔╝       ╚████████║███║   ███║╚█████████╔╝ ████████╔╝███║        """ + " ".repeat(40) + "| \n" +
	    			tabLine + dashBFormat + """
	    			╚══╝    ╚══╝╚═══════╝   ╚═══════╝           ╚═══════╝╚══╝   ╚══╝ ╚════════╝  ╚═══════╝ ╚══╝        """ + " ".repeat(39) + "|" + """
	    			""";
    		print.println(addItem);
    		print.println(tabSpace + "—".repeat(172));
        	print.println(tabSpace + "█".repeat(172));
    		print.flush();
		    		
			print.println("\n");
			print.println(tabSpace + " " + "—".repeat(170));
			print.println(tabSpace + centerRepeat + " ".repeat(5) + b_Texts + "ADDING A GROUP" + c_Reset); 
			print.println(b_Texts + " ".repeat(49) + "—".repeat(92) + c_Reset);
			print.println( " ".repeat(49) + b_verticalLine + " ".repeat(34) + c_Green + b_Texts + "ENTER THE NAME NEEDED" + c_Reset + " ".repeat(35) + b_verticalLine + c_Reset); 
			print.println(b_Texts + " ".repeat(49) + "—".repeat(92) + c_Reset);
			print.flush();

	        
			print.flush();
				while(true) {
					Date now = new Date();
					mths.writer.write(now + " ;");   // DATE ENTERED
					
					mths.writer.write(Logics_ProfileUser.getEnteredUsername() + ";");     // USERNAME
					mths.writer.write(Logics_ProfileUser.getEnteredPassword() + ";"); // PASSWORD
					mths.writer.write("none;");            // ITEMNAME "none" so it can be ignored in DASHBOARD and INVENTORY LIST
					mths.writer.write("0;");                // QUANTITY
					mths.writer.write("0;");                // PRICE
					
//					System.out.print(" ".repeat(1 + repFirst - "Group:".length()) + b_verticalLine + " ".repeat((repSecond) - "Group:".length()) + c_Green + " Group: " + c_Reset);
					System.out.print(subCR53 + c_Green + b_Texts + " —> " + c_Reset);    
					String group =  mths.scan.nextLine().trim();            
					mths.writer.write(group + ";");
					
					mths.writer.write("no date;");           // EXPIRATION DATE
					
					System.out.println(b_Texts + " ".repeat(65) + "—".repeat(60) + c_Reset);
					System.out.println();
					
					mths.writer.write("\n");
					mths.writer.flush();
					break;
				}
				mths.writer.close();
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
	            System.out.println(tabSpace + minorCR43 + b_Texts + "" +  "—".repeat(86) + "" + c_Reset);
	            
	            System.out.print(subCR52 + " |  [" + b_Texts + "1" + c_Reset + "]" + b_Texts + " Show Inventory List" + c_Reset);
		        System.out.println(" ".repeat(15) + b_verticalLine + " ".repeat(11) + "[" + b_Texts + "2" + c_Reset + "]" + b_Texts + " Show Inventory Dashboard  " + b_verticalLine + c_Reset);
		        System.out.println(tabSpace + minorCR43 + b_Texts + "" +  "—".repeat(86) + c_Reset);
		        System.out.print(subCR52 + " |  [" + b_Texts + "3" + c_Reset + "]" + b_Texts + " Add an Item" + c_Reset);
		        System.out.println(" ".repeat(23) + b_verticalLine + " ".repeat(11) + "[" + b_Texts + "4" + c_Reset + "]" + b_Texts + " Add a Group or Category   " + b_verticalLine + c_Reset);
		        System.out.println(tabSpace + minorCR43 + b_Texts + "" +  "—".repeat(86) + "" + c_Reset);
		        System.out.println(" ".repeat(53) + b_verticalLine + " ".repeat(31) + "[" + b_Texts + "5" + c_Reset + "]" + b_Texts + " Exit and Go Back" + c_Reset + " ".repeat(31) + "|");
		        System.out.println(tabSpace + minorCR43 + b_Texts + "" +  "—".repeat(86) + "" + c_Reset);
		        System.out.print(subCR52 + b_Texts + " —> " + c_Reset);
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
					Logics_Group.setNewGroup();
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

    /* FOR ITEM DUPLICATION, THE SYSTEM CHECKS IF THE USER REALLY WANTS TO ADD ANOTHER ITEM THAT SEEMS A SIMILAR WITH AN ENTERED ONE, 
     * THEN THE SYSTEM PROCEEDS TO GET THE OTHER DETAILS IF THE USER CONTINUES.
	*/

}