package finals_InventoryTrackingSys;


import java.io.*;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.NumberFormat;
import java.util.*;
import static java.nio.file.AccessMode.*;

public class Logics_Inventory implements InventoryVars{
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
	final static String subCR65 = " ".repeat(65);
	final static String subCR55 = " ".repeat(55);
	final static String subCR50 = " ".repeat(50);
	final static String subCR52 = " ".repeat(52);
	final static String subCR57 = " ".repeat(57);
	final static String minorCR48 = " ".repeat(48);      // MINOR CENTER REPEAT
	final static String minorCR47 = " ".repeat(47);
	final static String minorCR45 = " ".repeat(45);
	final static String minorCR43 = " ".repeat(43);
	
	final static String tab = "\t";
	final static String tabSpace = "\t ";
	final static String tabLine = "\t | ";
	
	final static String b_verticalLine = b_Texts + "|" + c_Reset;
	final static String b_verticalSpacesLine = b_Texts + " | " + c_Reset;
	
	// VARIABLE FOR DECISIONS
	String firstChoice;
	static String secondChoice;
    static String thirdChoice;
    
    // ENUM CLASS
    static Enums_Constants enumShow = null;
    
    // METHODS
	Scanner scan = new Scanner(System.in);
	NumberFormat currency = NumberFormat.getCurrencyInstance();
	
	// FILE DECLARATIONS
	Path fPath = Paths.get(filePath.getAbsolutePath());
	FileWriter writer;
	FileReader fReader;
	
	
	
	// First Decision == First Level ==
    public void setFirstDecisions(String firstChoice) {
        this.firstChoice = firstChoice;
        try {
	        // VALIDATION OF INVENTORY
	        if (this.firstChoice.equalsIgnoreCase("inventory")|| (this.firstChoice.equals("1"))) {
	        	//System.out.println("\t | inventory");
	        	enumShow = Logics_Inventory.fromString("inventory");
	        }
	        
	        // VALIDATION OF ITEM
	        else if (this.firstChoice.equalsIgnoreCase("item") || (this.firstChoice.equals("2"))) {
	        	if (this.firstChoice.equalsIgnoreCase("item"))
	        		enumShow = Logics_Inventory.fromString("item");
	        	
	        	else if (this.firstChoice.equalsIgnoreCase("2"))
	        		enumShow = Logics_Inventory.fromInt(2);
	        }
	        
	        // VALIDATION OF GROUP or CATEGORY
	        else if ((this.firstChoice.equalsIgnoreCase("group")) || (this.firstChoice.equalsIgnoreCase("category")) || (this.firstChoice.equals("3"))) {
	        	if (this.firstChoice.equalsIgnoreCase("group"))
	        		enumShow = Logics_Inventory.fromString("group");
	        	
	        	else if (this.firstChoice.equalsIgnoreCase("category"))
	        		enumShow = Logics_Inventory.fromString("category");
	        	
	        	else if (this.firstChoice.equals("3"))
	        		enumShow = Logics_Inventory.fromInt(3);
	        }
	        
	        // VALIDATE THE INPUT FOR EXIT DECISION
	        else if ((this.firstChoice.equalsIgnoreCase("exit")) || (this.firstChoice.equals("4"))) {
	        	if (this.firstChoice.equalsIgnoreCase("exit"))
	        		enumShow = Logics_Inventory.fromString("exit");
	        	
	        	else if (this.firstChoice.equals("4"))
	        		enumShow = Logics_Inventory.fromInt(4);
	        }
	        
	        // VALIDATE THE INPUT FOR DEFAULT
	        else {
	        	if(this.firstChoice.equals(firstChoice))
	        		enumShow = Logics_Inventory.fromInt(5);
	        	else if(this.firstChoice.equals(firstChoice))
	        		enumShow = Logics_Inventory.fromString("exit");
	        }
        }
        catch(Exception e) {
        	System.out.println("\t | SOMETHING WENT SOUTH: " + e.getMessage());
        }
    }
    
    // Returns a Enum Constant -> Access for Switch
    public static Enums_Constants returnCons() {
		return enumShow;
    }
    
    // VALIDATION OF ACCESS CONTROL — First Decisions _ for String
    public static Enums_Constants fromString(String value) {
    	for (Enums_Constants sType : Enums_Constants.values()) {
            if (sType.getOptTypeS().equalsIgnoreCase(value)) {
                return sType;
            }
        }
		return null;
    }
    
    // VALIDATION OF ACCESS CONTROL — First Decisions _ for int
    public static Enums_Constants fromInt(int num) {
    	for (Enums_Constants iType : Enums_Constants.values()) {
            if (iType.getOptType() == num) {
                return iType;
            }
        }
		return null;
    }
    
    
    
    // Second Decision == Internal Inventory ==
    public void setSecondDecision(String secondChoice) {
    	this.secondChoice = secondChoice;
    }
    
    // ASKS THE USER TO INPUT A DECISION TO ACCESS
    public static void chooseInventoryOption(){
    	Logics_Inventory mths = new Logics_Inventory();
    	try {
    		System.out.println(tabSpace + " " + "—".repeat(169));
    		System.out.println(tabSpace);
        	System.out.println(centerRepeat +  b_Texts + "========================================" + c_Reset);

	    	System.out.println(tabSpace + centerRepeat + "  " + b_Texts + "Acces Inventory to".toUpperCase() + c_Reset);
            System.out.println(tabSpace + minorCR43 + b_Texts +  "—".repeat(86) + "" + c_Reset);

	    	System.out.print(subCR52 + " |  [" + b_Texts + "1" + c_Reset + "]" + b_Texts + " Show Inventory List" + c_Reset);
	        System.out.println(" ".repeat(15) + "|" + " ".repeat(11) + "[" + b_Texts + "2" + c_Reset + "]" + b_Texts + " Show Inventory Dashboard  |" + c_Reset);
	        System.out.println(tabSpace + minorCR43 + b_Texts + "" +  "—".repeat(86) + "" + c_Reset);
	        System.out.print(subCR52 + " |  [" + b_Texts + "3" + c_Reset + "]" + b_Texts + " Add an Item" + c_Reset);
	        System.out.println(" ".repeat(23) + "|" + " ".repeat(11) + "[" + b_Texts + "4" + c_Reset + "]" + b_Texts + " Add a Group or Category   |" + c_Reset);
	        System.out.println(tabSpace + minorCR43 + b_Texts + "" +  "—".repeat(86) + "" + c_Reset);
	        System.out.print(subCR52 + b_Texts + " —> " + c_Reset);
	        Logics_Inventory.secondChoice = mths.scan.nextLine();
    	}
    	
    	catch(Exception e){
    		System.out.println("\t | SOMETHING WENT WRONG IN INVENTORY OPTION: " + e.getMessage());
    	}
    }
    
    // VALIDATION FOR THE NEXT DECISION THE SECOND DECISION WITHIN THE INVENTORY CASE
    public static void getSecondDecisions() {
    	try {
    		while (true) {
				if (secondChoice.equalsIgnoreCase("Show Inventory List") || secondChoice.equals("1")) {
					Logics_Inventory.getWrittenInventory();    	
					break;
				}
				
				else if (secondChoice.equalsIgnoreCase("Show Inventory Dashboard") || secondChoice.equals("2")) {
					Logics_Inventory.getDashboardInventory();    	
					break;
				}
				
				else if (secondChoice.equalsIgnoreCase("Add an Item") || secondChoice.equals("3")) {
					Logics_Inventory.setItemInventory();
					break;
	    		}
				
				else if (secondChoice.equalsIgnoreCase("Add a Group or Category") || secondChoice.equals("4")) {
					Logics_Inventory.setGroupInventory();
					break;
	    		}
				
				else {
					System.out.println(tabSpace + minorCR48 + "Try Another: ");
					Logics_Inventory.chooseInventoryOption();
					break;
				}
			}
		} 
    	catch (Exception e) {
			e.printStackTrace();
		}
    }


	// ACCESS CHECK/SHOW THE Inventory List
    public static void getWrittenInventory() {
    	
    	//METHODS
    	Logics_Inventory mths = new Logics_Inventory();
    	PrintWriter print = new PrintWriter(System.out);
    	
    	//VARIABLES
    	final String rep20 = " ".repeat(20);
    	final String inventoryFormat = " ".repeat(38);
    	final String spacerFormat = " ".repeat(3);
    	
    	while(true) {
	    	try {
    			FileReader fR = new FileReader(mths.fPath.toString());
    			BufferedReader br1 = new BufferedReader(fR);
    			String LINE;
    			
    			print.println("\n");
	        	print.println("\t " + b_Texts + "—".repeat(172) + c_Reset);
    			String inventoryListHeader = tabLine + inventoryFormat + """
		    			█████████╗█████╗  ███╗███╗   ███╗█████████╗█████╗  ███╗█████████╗ █████████╗ █████████╗ ███╗  ███╗  """ + " ".repeat(33) + "| \n" +
		    			tabLine + inventoryFormat + spacerFormat + """
		    			   ███╔══╝██████╗ ███║███║   ███║███╔═════╝██████╗ ███║   ███╔══╝███╔════███║███╔═══███╗███╚══███║                  """ + " ".repeat(33) + "| \n" +
		    			tabLine + inventoryFormat + spacerFormat + """
		    			   ███║   ███╔███╗███║ ███╗ ███╔╝███████╗  ███╔███╗███║   ███║   ███║    ███║█████████╔╝ ███████╔╝     """ + " ".repeat(33) + "| \n" +
		    			tabLine + inventoryFormat + spacerFormat + """    
		    			   ███║   ███║╚██████║ ███║ ███║ ███╔═══╝  ███║╚██████║   ███║   ███║    ███║███╔═══███╗   ███╔═╝   """ + " ".repeat(34) + "| \n" +
		    			tabLine + inventoryFormat + """
		    			█████████╗███║ ╚═████║  ██████╔╝ █████████╗███║ ╚═████║   ███║   ╚█████████╔╝███║   ███║   ███║   """ + " ".repeat(36) + "| \n" +
		    			tabLine + inventoryFormat + """
		    			╚════════╝╚══╝   ╚═══╝  ╚═════╝  ╚════════╝╚══╝   ╚═══╝   ╚══╝    ╚════════╝ ╚══╝   ╚══╝   ╚══╝  """ + " ".repeat(36) + "|" + """
		    			""";
    			print.println(inventoryListHeader);
	    		print.println(tabSpace + "—".repeat(172));
	        	print.println(tabSpace + "█".repeat(172));

    			print.println("\n");
    			print.println(tabSpace + " " + "—".repeat(169));
				print.println(tabSpace + centerRepeat + " ".repeat(4) + b_Texts + "INVENTORY LIST" + c_Reset); 
				print.println(tabSpace + b_Texts + "—".repeat(173) + c_Reset);
				
				String [] label = {"Items", "Quantity", "Price", "Total Amount", "Group or Category"};
				String blockForCategories = tabLine + rep20 + label[0] + " ".repeat(33 - (label[0].length())) + label[1] + " ".repeat(28 - (label[1].length()))
						+ label[2] + " ".repeat(20 - (label[2].length())) + label[3] + " ".repeat(36 - (label[3].length())) + label[4] + " ".repeat(28 - (label[3].length())) + "|";
				print.println(blockForCategories);
				print.flush();
				
    			while((LINE = br1.readLine()) != null) {
    				String DATA [] = LINE.split(";");
    				
    				
	    			for (int numHolder = 0; numHolder < 1; numHolder++) {
	    				System.out.print(tabSpace + b_verticalLine + " ".repeat(8) + " ".repeat(40 - DATA[1].length()) + DATA [1] + b_verticalSpacesLine);
	    			}
	    			for (int numHolder = 0; numHolder < 1; numHolder++) {
	    				System.out.print(DATA [2] + " ".repeat(20 - DATA[2].length()) + b_verticalSpacesLine);
	    			}
	    			
	    			for (int numHolder = 0; numHolder < 1; numHolder++) {
	    				System.out.print(DATA [3] + " ".repeat(20 - DATA[3].length()) + b_verticalSpacesLine);
	    			}
	    			
	    			for (int numHolder = 0; numHolder < 1; numHolder++) {
	    				System.out.print(DATA [4] + " ".repeat(20 - DATA[4].length()) + b_verticalSpacesLine);
	    			}
	    			
	    			for (int numHolder = 0; numHolder < 1; numHolder++) {
	    				System.out.println(DATA [5] + " ".repeat(50 - DATA[5].length()) + b_verticalSpacesLine);
	    			}
    			}
    			print.println(tabSpace + b_Texts + "—".repeat(173) + c_Reset);
    			print.flush();
    		}

	    	catch(IOException e) {
	    		System.out.println("\t | SOMETHING WENT WRONG: "+ e.getLocalizedMessage());
	    	}
    	
	    	finally {
				// Internal Decision to repeat or to choose other Action
				System.out.println(tabSpace);
	        	System.out.println(centerRepeat +  b_Texts + "============================================" + c_Reset);

		    	System.out.println(tabSpace + " ".repeat(72) + b_Texts + "CHOOSE AGAIN OR EXIT THE PROGRAM" + c_Reset);
	            System.out.println(tabSpace + minorCR43 + b_Texts + "" +  "—".repeat(86) + "" + c_Reset);

		    	System.out.print(subCR52 + " |  [" + b_Texts + "1" + c_Reset + "]" + b_Texts + " Show Inventory List" + c_Reset);
		        System.out.println(" ".repeat(15) + "|" + " ".repeat(11) + "[" + b_Texts + "2" + c_Reset + "]" + b_Texts + " Show Inventory Dashboard  |" + c_Reset);
		        System.out.println(tabSpace + minorCR43 + b_Texts + "" +  "—".repeat(86) + "" + c_Reset);
		        System.out.print(subCR52 + " |  [" + b_Texts + "3" + c_Reset + "]" + b_Texts + " Add an Item" + c_Reset);
		        System.out.println(" ".repeat(23) + "|" + " ".repeat(11) + "[" + b_Texts + "4" + c_Reset + "]" + b_Texts + " Add a Group or Category   |" + c_Reset);
		        System.out.println(tabSpace + minorCR43 + b_Texts + "" +  "—".repeat(86) + "" + c_Reset);
		        System.out.print(subCR52 + b_Texts + " —> " + c_Reset);
				String numOrStr = mths.scan.nextLine();
				
				if (numOrStr.equalsIgnoreCase("Show Inventory List") || numOrStr.equals("1")) {
					continue;
				}
				else if (numOrStr.equalsIgnoreCase("Show Inventory Dashboard") || numOrStr.equals("2")) {
					Logics_Inventory.getDashboardInventory();
					break;
				}
				else if (numOrStr.equalsIgnoreCase("Add an Item") || numOrStr.equals("3")) {
					Logics_Inventory.setItemInventory();
					break;
				}
				else if (numOrStr.equalsIgnoreCase("Add a Group or Category") || numOrStr.equals("4")) {
					Logics_Inventory.setGroupInventory();
					break;
				}
				else if (numOrStr.equalsIgnoreCase("Exit and Go Back") || numOrStr.equals("5")){
					System.out.println(tabLine + b_Texts + "Exited and Went Back..." + c_Reset);
					break;
				}
	    	}
    	}
	}
    
    // ACCESS CHECK/SHOW The Inventory Dashboard
	public static void getDashboardInventory() {
    	//METHODS
    	Logics_Inventory mths = new Logics_Inventory();
    	PrintWriter print = new PrintWriter(System.out);
				
    	//VARIABLES
		final String rep8 = " ".repeat(8);
    	final String rep40 = " ".repeat(40);
    	final String dashBFormat = " ".repeat(41);
    	
    	while(true)
			try {
				//METHODS
				BufferedReader br = new BufferedReader(new FileReader(mths.fPath.toString()));

		    	print.println("\n");
	        	print.println("\t " + b_Texts + "—".repeat(172) + c_Reset);
		    	final String dashboardHeader = tabLine + dashBFormat + """
		    			████████╗  ███████╗ ████████╗██╗    ██╗████████╗  ███████╗  ███████╗ ███████╗ ████████╗   """ + " ".repeat(41) + "| \n" +
		    			tabLine + dashBFormat + """
		    			██╔════██╗██╔════██╗██╔═════╝██║    ██║██╔════██╗██╔════██║██╔════██╗██╔═══██╗██╔════██╗  """ + " ".repeat(40) + "| \n" +
		    			tabLine + dashBFormat + """
		    			██║    ██║█████████║████████╗█████████║████████╔╝██║    ██║█████████║███████╔╝██║    ██║  """ + " ".repeat(40) + "| \n" +
		    			tabLine + dashBFormat + """ 
		    			██║    ██║██╔════██║╚═════██║██╔════██║██╔════██╗██║    ██║██╔════██║██╔═══██╗██║    ██║  """ + " ".repeat(40) + "| \n" +
		    			tabLine + dashBFormat + """
		    			████████╔╝██║    ██║████████║██║    ██║████████╔╝╚███████╔╝██║    ██║██║   ██║████████╔╝  """ + " ".repeat(40) + "| \n" +
		    			tabLine + dashBFormat + """
		    			╚═══════╝ ╚═╝    ╚═╝╚═══════╝╚═╝    ╚═╝╚═══════╝  ╚══════╝ ╚═╝    ╚═╝╚═╝   ╚═╝╚══════╝    """ + " ".repeat(42) + "|" + """
		    			""";
	    		print.println(dashboardHeader);
	    		print.println(tabSpace + "—".repeat(172));
	        	print.println(tabSpace + "█".repeat(172));
	    		print.flush();
	    		
	    		// DASHBOARD CONTROL
	    		String lines = "";
	    		print.println("\n");
	    		print.println(tabSpace + " " + "—".repeat(169));
	    		print.println(tabSpace + centerRepeat + " ".repeat(5) + b_Texts + "ITEM QUANTITY" + c_Reset); 
	    		print.println(tabSpace + " ".repeat(41) + "—".repeat(104));
	    		while((lines = br.readLine()) != null) {
		    			String[] val = lines.split(";");
		    			
		    			print.print(tabSpace + " ".repeat(40 - val[1].length()) + val[1] + b_verticalSpacesLine);
		    			
		    			String newQUantity = val [2];
		            	int doubleVar =((int)(Double.parseDouble(newQUantity)));
		            	
		    			if((doubleVar == 1)) {
		    				print.print("█".repeat(doubleVar));
		    				print.print(" ".repeat(100 - doubleVar) + b_verticalSpacesLine);
		    			}
		    			
		    			else if ((doubleVar % 2 == 0)) {
		    				for(int numRepeat = 0; numRepeat < (doubleVar / 2); numRepeat++) {
		    					print.print("██");
		    					
		    				}print.print(" ".repeat(100 - (doubleVar)) + " |");
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
		    			else {
		    				break;
		    			}
		    			//print.print(" ".repeat(100 - doubleVar) + " |");
		    			print.println();
		    		}
	    		br.close();
	    		print.println(tabSpace + rep40  + " " + b_Texts + "_".repeat(104) + c_Reset);
	    		print.println(tabSpace + rep40 + "  0" + rep8 + "10" +rep8 + "20" + rep8 + "30" + rep8 + "40" + rep8 + "50" + rep8  + "60" + rep8  + "70" + rep8  + "80" + rep8  + "90" + rep8  + "100");
	    		print.flush();
	    	}
	    	
	    	catch(Exception e) {
	    		System.out.println(e.getMessage());
	    	}
			
	    	finally {
	    		// Internal Decision to repeat or to choose other Action
	    		System.out.println(tabSpace);
	    		System.out.println("\n");
	    		System.out.println(tabSpace + " " + "—".repeat(169));
	        	System.out.println(centerRepeat +  b_Texts + "============================================" + c_Reset);
		    	System.out.println(tabSpace + " ".repeat(72) + b_Texts + "CHOOSE AGAIN OR EXIT THE PROGRAM" + c_Reset);
	            System.out.println(tabSpace + minorCR43 + b_Texts + "" +  "—".repeat(86) + "" + c_Reset);

		    	System.out.print(subCR52 + " |  [" + b_Texts + "1" + c_Reset + "]" + b_Texts + " Show Inventory List" + c_Reset);
		        System.out.println(" ".repeat(15) + "|" + " ".repeat(11) + "[" + b_Texts + "2" + c_Reset + "]" + b_Texts + " Show Inventory Dashboard  |" + c_Reset);
		        System.out.println(tabSpace + minorCR43 + b_Texts + "" +  "—".repeat(86) + "" + c_Reset);
		        System.out.print(subCR52 + " |  [" + b_Texts + "3" + c_Reset + "]" + b_Texts + " Add an Item" + c_Reset);
		        System.out.println(" ".repeat(23) + "|" + " ".repeat(11) + "[" + b_Texts + "4" + c_Reset + "]" + b_Texts + " Add a Group or Category   |" + c_Reset);
		        System.out.println(tabSpace + minorCR43 + b_Texts + "" +  "—".repeat(86) + "" + c_Reset);
		        System.out.print(subCR52 + b_Texts + " —> " + c_Reset);
				String numOrStr = mths.scan.nextLine();
				
				if (numOrStr.equalsIgnoreCase("Show Inventory List") || numOrStr.equals("1")) {
					Logics_Inventory.getWrittenInventory();
					break;
				}
				else if (numOrStr.equalsIgnoreCase("Show Inventory Dashboard") || numOrStr.equals("2")) {
					continue;
				}
				else if (numOrStr.equalsIgnoreCase("Add an Item") || numOrStr.equals("3")) {
					Logics_Inventory.setItemInventory();
					break;
				}
				else if (numOrStr.equalsIgnoreCase("Add a Group or Category") || numOrStr.equals("4")) {
					Logics_Inventory.setGroupInventory();
					break;
				}
				else if (numOrStr.equalsIgnoreCase("Exit and Go Back") || numOrStr.equals("5")){
					System.out.println("\t | ENNNNNNNNNNNNNGKDD");
					break;
				}
	    	}
		}
	
	// ACCES UPDATE/WRITES for Adding an Item 
    public static void setItemInventory() {
    	//MEHODS
    	Logics_Inventory mths = new Logics_Inventory();
    	PrintWriter print = new PrintWriter(System.out);
    	
    	// VARIABLES
    	
    	while(true) {
			try {
			mths.writer = new FileWriter(mths.fPath.toString(), true);
			
			print.println("\n");
			print.println(tabSpace + " " + "—".repeat(169));
			print.println(tabSpace + centerRepeat + " ".repeat(4) + b_Texts + "ADDING AN ITEM" + c_Reset); 
			print.println(tabSpace + b_Texts + "—".repeat(173) + c_Reset);
			
			
			print.flush();
				while(true) {
					Date now = new Date();
					mths.writer.write(now + " ;");
					
					System.out.println(" ".repeat(49) + "|" + " ".repeat(31));
					System.out.print(" ".repeat(50 - "Item:".length()) + tabLine + " ".repeat(10 - "Item:".length()) + "Item: ");
					String item = mths.scan.nextLine();
					mths.writer.write(item + ";");
					
					System.out.print(" ".repeat(50 - "Quantity:".length()) + tabLine + " ".repeat(10 - "Quantity:".length()) + "Quantity: ");
					double quant =  mths.scan.nextDouble();
					mths.writer.write(quant + ";");
					
					System.out.print(" ".repeat(50 - "Price:".length()) + tabLine + " ".repeat(10 - "Price:".length()) + "Price: ");
					double price =  mths.scan.nextDouble();
					mths.writer.write(mths.currency.format(price) + ";");
					mths.writer.write(price + ";");
					
					mths.scan.nextLine();
					System.out.print(" ".repeat(50 - "Group:".length()) + tabLine + " ".repeat(10 - "Group:".length()) + "Group: ");
					String group =  mths.scan.nextLine();
					mths.writer.write(group + ";");
					
					
					mths.writer.write("\n");
					mths.writer.flush();
					break;
				}
				mths.writer.close();
			}
			
			catch (InputMismatchException e) {
				System.out.println("\t | ");
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
				// Internal Decision to repeat or to choose other Action
				System.out.println(tabSpace);
	        	System.out.println(centerRepeat +  b_Texts + "============================================" + c_Reset);

		    	System.out.println(tabSpace + " ".repeat(72) + b_Texts + "CHOOSE AGAIN OR EXIT THE PROGRAM" + c_Reset);
	            System.out.println(tabSpace + minorCR43 + b_Texts + "" +  "—".repeat(86) + "" + c_Reset);
	            
	            System.out.print(subCR52 + " |  [" + b_Texts + "1" + c_Reset + "]" + b_Texts + " Show Inventory List" + c_Reset);
		        System.out.println(" ".repeat(15) + "|" + " ".repeat(11) + "[" + b_Texts + "2" + c_Reset + "]" + b_Texts + " Show Inventory Dashboard  |" + c_Reset);
		        System.out.println(tabSpace + minorCR43 + b_Texts + "" +  "—".repeat(86) + "" + c_Reset);
		        System.out.print(subCR52 + " |  [" + b_Texts + "3" + c_Reset + "]" + b_Texts + " Add an Item" + c_Reset);
		        System.out.println(" ".repeat(23) + "|" + " ".repeat(11) + "[" + b_Texts + "4" + c_Reset + "]" + b_Texts + " Add a Group or Category   |" + c_Reset);
		        System.out.println(tabSpace + minorCR43 + b_Texts + "" +  "—".repeat(86) + "" + c_Reset);
		        System.out.print(subCR52 + b_Texts + " —> " + c_Reset);
				String numOrStr = mths.scan.nextLine();
				
				if (numOrStr.equalsIgnoreCase("Show Inventory List") || numOrStr.equals("1")) {
					Logics_Inventory.getWrittenInventory();
					break;
				}
				else if (numOrStr.equalsIgnoreCase("Show Inventory Dashboard") || numOrStr.equals("2")) {
					Logics_Inventory.getDashboardInventory();
					break;
				}
				else if (numOrStr.equalsIgnoreCase("Add an Item") || numOrStr.equals("3")) {
					continue;
				}
				else if (numOrStr.equalsIgnoreCase("Add a Group or Category") || numOrStr.equals("4")) {
					Logics_Inventory.setGroupInventory();
					break;
				}
				else if (numOrStr.equalsIgnoreCase("Exit and Go Back") || numOrStr.equals("5")){
					System.out.println("\t | ENNNNNNNNNNNNNGKDD");
					break;
				}
			}
		}
    }
    
    // ACCES UPDATE/WRITES for Adding a Group 
    public static void setGroupInventory() {
    	//METHODS
    	
    	//VARIABLES
    	
    	try {
    		
    	}
    	
    	catch(Exception e) {
    		System.out.println(e.getMessage());
    	}
    	
    	finally {
    		
    	}
		
	}
    
    
    
    // Third Decision == Internal Item == 
    public void setThirdDecision(String thirdChoice) {
        this.thirdChoice = thirdChoice;
    }
}
