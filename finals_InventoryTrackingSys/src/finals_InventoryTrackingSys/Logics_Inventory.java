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
	final static String minorCR47 = " ".repeat(47);      // MINOR CENTER REPEAT

	final static String tab = "\t";
	final static String tabSpace = "\t ";
	final static String tabLine = "\t | ";
	
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
    		System.out.println(tabSpace);
	    	System.out.println(tabSpace + centerRepeat + "  " + b_Texts + "Acces Inventory to " + c_Reset);
	    	System.out.print(subCR50 + tabSpace + " [" + b_Texts + "1" + c_Reset + "]" + b_Texts + " Show Inventory List" + c_Reset);
	        System.out.println(" ".repeat(28) + "[" + b_Texts + "2" + c_Reset + "]" + b_Texts + " Show Inventory Dashboard" + c_Reset + "\n");
	        System.out.print(subCR50 + tabSpace + " [" + b_Texts + "3" + c_Reset + "]" + b_Texts + " Add an Item" + c_Reset);
	        System.out.println(" ".repeat(36) + "[" + b_Texts + "4" + c_Reset + "]" + b_Texts + " Add a Group or Category" + c_Reset + "\n");
	        System.out.print(subCR50 + tabSpace + b_Texts + " —> " + c_Reset);
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
				
				else if (secondChoice.equalsIgnoreCase("Add a Group or Category") || secondChoice.equals("3")) {
					Logics_Inventory.setGroupInventory();
					break;
	    		}
				
				else {
					System.out.println("\t | Try Another: ");
					System.out.println("\t | ");
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
    	//VARIABLES
		final String rep5 = " ".repeat(5);
		final String rep8 = " ".repeat(8);
    	final String rep7 = " ".repeat(7);
    	final String rep20 = " ".repeat(20);
    	final String rep35 = " ".repeat(35);
    	final String rep40 = " ".repeat(40);
    	final String inventoryFormat = " ".repeat(38);
    	final String spacerFormat = " ".repeat(3);
    	
    	while(true) {
	    	try {
    			FileReader fR = new FileReader(mths.fPath.toString());
    			BufferedReader br1 = new BufferedReader(fR);
    			String LINE;
    			int spaces = 10;
    			
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
	    		print.println("\t " + "—".repeat(172));
	        	print.println("\t " + "█".repeat(172));

    			print.println("\n");
				print.println(tabSpace + centerRepeat + " ".repeat(4) + b_Texts + "INVENTORY LIST" + c_Reset); 
				print.println("\t " + "—".repeat(172));
				String [] label = {"Items", "Quantity", "Price", "Total Amount", "Group or Category"};
				
				String blockForCategories = tabLine + rep40 + label[0] + " ".repeat(13 - (label[0].length())) + label[1] + " ".repeat(20 - (label[1].length()))
						+ label[2] + " ".repeat(18 - (label[2].length())) + label[3] + " ".repeat(20 - (label[3].length())) + label[4];
				
				print.println(blockForCategories);
				print.flush();
    			while((LINE = br1.readLine()) != null) {
    				String DATA [] = LINE.split(";");
    				
    				
	    			for (int numHolder = 0; numHolder < 1; numHolder++) {
	    				System.out.print(tabSpace + " ".repeat(40) + DATA [1] + " ".repeat(spaces - DATA[1].length()) + " | ");
	    			}
	    			for (int numHolder = 0; numHolder < 1; numHolder++) {
	    				System.out.print(DATA [2] + " ".repeat(spaces - DATA[2].length()) + " | ");
	    			}
	    			
	    			for (int numHolder = 0; numHolder < 1; numHolder++) {
	    				System.out.print(DATA [3] + " ".repeat(20 - DATA[3].length()) + " | ");
	    			}
	    			
	    			for (int numHolder = 0; numHolder < 1; numHolder++) {
	    				System.out.print(DATA [4] + " ".repeat(20 - DATA[4].length()) + " | ");
	    			}
	    			
	    			for (int numHolder = 0; numHolder < 1; numHolder++) {
	    				System.out.println(DATA [5] + " ".repeat(50 - DATA[5].length()) + " | ");
	    			}
    			}
    			print.println(tab + b_Texts + rep40 + "—".repeat(105) + c_Reset);
    			print.flush();
    		}

	    	catch(IOException e) {
	    		System.out.println("\t | SOMETHING WENT WRONG: "+ e.getLocalizedMessage());
	    	}
    	
	    	finally {
	    		System.out.println(tabSpace);
				System.out.println(tabSpace + minorCR47 + " ENTRY ENDED");
				System.out.println(tabSpace);
				// Internal Decision to repeat or to choose other Action
				System.out.println(tabSpace + minorCR47 + "CHOOSE NEXT DECISION: ");
				System.out.println(tabSpace + minorCR47 + "[1] Show Again");
				System.out.println(tabSpace + minorCR47 + "[2] Update");
				System.out.println(tabSpace + minorCR47 + "[3] Exit and go back");
				System.out.print(minorCR47 + " —> ");
				String num = mths.scan.nextLine();
				
				if (num.equalsIgnoreCase("show") || num.equals("1")) {
					continue;
				}
				else if (num.equalsIgnoreCase("update") || num.equals("2")) {
					Logics_Inventory.setItemInventory();
					break;
				}
				else if (num.equalsIgnoreCase("exit") || num.equals("3")) {
					//Main.main(null); Call dire
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
		final String rep5 = " ".repeat(5);
		final String rep8 = " ".repeat(8);
    	final String rep7 = " ".repeat(7);
    	final String rep20 = " ".repeat(20);
    	final String rep35 = " ".repeat(35);
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
	    		print.println("\t " + "—".repeat(172));
	        	print.println("\t " + "█".repeat(172));
	    		print.flush();
	    		
	    		
	    		// DashBoard Control
	    		
	    		String lines = "";
	    		print.println("\n");
	    		print.println(tabSpace + centerRepeat + " ".repeat(11) + b_Texts + "ITEM QUANTITY" + c_Reset); 
	    		print.println(tabSpace + " ".repeat(41) + "—".repeat(104));
	    		while((lines = br.readLine()) != null) {
		    			String[] val = lines.split(";");
		    			
		    			print.print(tabSpace + " ".repeat(40 - val[1].length()) + val[1] + " | ");
		    			
		    			String newQUantity = val [2];
		            	int doubleVar =((int)(Double.parseDouble(newQUantity)));
		            	
		    			if((doubleVar == 1)) {
		    				print.print("█".repeat(doubleVar));
		    				print.print(" ".repeat(100 - doubleVar) + " |");
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
		    					print.print(" ".repeat(100 - (doubleVar)) + " |");
		    				}
		    			}
		    			
		    			else {
		    				break;
		    			}
		    			//print.print(" ".repeat(100 - doubleVar) + " |");
		    			print.println();
		    		}
	    		br.close();
	    		print.println(tabSpace + rep40  + " " + "_".repeat(104));
	    		print.println(tabSpace + rep40 + "  0" + rep8 + "10" +rep8 + "20" + rep8 + "30" + rep8 + "40" + rep8 + "50" + rep8  + "60" + rep8  + "70" + rep8  + "80" + rep8  + "90" + rep8  + "100");
	    		print.flush();
	    	}
	    	
	    	catch(Exception e) {
	    		System.out.println(e.getMessage());
	    	}
			
	    	finally {
	    		System.out.println(tabSpace);
		    	System.out.println(tabSpace + centerRepeat + "  " + b_Texts + "Acces Inventory to " + c_Reset);
		    	System.out.print(subCR50 + tabSpace + " [" + b_Texts + "1" + c_Reset + "]" + b_Texts + " Show Inventory List" + c_Reset);
		        System.out.println(" ".repeat(28) + "[" + b_Texts + "2" + c_Reset + "]" + b_Texts + " Show Inventory Dashboard" + c_Reset + "\n");
		        System.out.print(subCR50 + tabSpace + " [" + b_Texts + "3" + c_Reset + "]" + b_Texts + " Add an Item" + c_Reset);
		        System.out.println(" ".repeat(36) + "[" + b_Texts + "4" + c_Reset + "]" + b_Texts + " Add a Group or Category" + c_Reset + "\n");
		        System.out.print(subCR50 + tabSpace + b_Texts + " —> " + c_Reset);
				String numOrStr = mths.scan.nextLine();
				
				if (numOrStr.equalsIgnoreCase("Show Inventory Dashboard") || numOrStr.equals("2")) {
					continue;
				}
				else if (numOrStr.equalsIgnoreCase("Show Inventory List") || numOrStr.equals("1")) {
					Logics_Inventory.getWrittenInventory();
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
					System.out.println("\t | ENNNNNNNNNNNNNGKDD");
					break;
				}
	    	}
	}
	
	// ACCES UPDATE/WRITES for Adding an Item 
    public static void setItemInventory() {
    	Logics_Inventory mths = new Logics_Inventory();
    	
    	while(true) {
			try {
			mths.writer = new FileWriter(mths.fPath.toString(), true);
			
			// FORMATTING CURRENCY
			
			
				while(true) {
					Date now = new Date();
					mths.writer.write(now + " ;");
					
					System.out.println("\t | ");
					System.out.print("\t | Item: ");
					String item = mths.scan.nextLine();
					mths.writer.write(item + ";");
					
					System.out.print("\t | Quantity: ");
					double quant =  mths.scan.nextDouble();
					mths.writer.write(quant + ";");
					
					System.out.print("\t | Price: ");
					double price =  mths.scan.nextDouble();
					mths.writer.write(mths.currency.format(price) + ";");
					mths.writer.write(price + ";");
					
					mths.scan.nextLine();
					System.out.print("\t | Group: ");
					String group =  mths.scan.nextLine();
					mths.writer.write(group + ";");
					
					
					mths.writer.write("\n");
					mths.writer.flush();
					break;
				}
				mths.writer.close();
			}
			
			catch (Exception e) {
				System.out.println("\t | ");
				System.out.println("\t | SOMETHING WENT WRONG: " + e.getMessage());
				mths.scan.nextLine();
			}
			
			finally {
				System.out.println("\t | ");
				System.out.println("\t | ENTRY ENDED");
				System.out.println("\t | ");
				
				// Internal Decision to repeat or to choose other Action
				System.out.println("\t | CHOOSE NEXT DECISION: ");
				System.out.println("\t | [1] Show");
				System.out.println("\t | [2] Update Again");
				System.out.println("\t | [3] Exit and go back");
				System.out.print("\t | -> ");
				String num = mths.scan.nextLine();
				
				if (num.equalsIgnoreCase("update") || num.equals("2")) {
					continue;
				}
				else if (num.equalsIgnoreCase("show") || num.equals("1")) {
					Logics_Inventory.getWrittenInventory();
					break;
				}
				else if (num.equalsIgnoreCase("exit") || num.equals("3")) {
					//Main.main(null); Call dire
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
