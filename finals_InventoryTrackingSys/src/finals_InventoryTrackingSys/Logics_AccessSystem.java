package finals_InventoryTrackingSys;

import java.io.*;
import java.text.*;
import java.util.*;

public class Logics_AccessSystem {
	
	// VARIABLES FOR COLOR/UI OUTPUT
	static String c_Red = "\u001B[31m";
    static String c_Green = "\u001B[32m";
    static String b_Texts = "\u001B[1m";
    static String c_Reset = "\u001B[0m";
    
    // VARS FOR UI FORMAT
	final static String centerRepeat = " ".repeat(75);
	final static String subCR54 = " ".repeat(54);
	final static String minorCR48 = " ".repeat(48);      // MINOR CENTER REPEAT
	final static String newLines = ("\n\n\n\n\n");
	
	final static String tab = "\t";
	final static String tabSpace = "\t ";
	final static String tabLine = "\t │ ";
	
	final static String b_verticalLine = b_Texts + "│" + c_Reset;
	final static String b_verticalSpacesLine = b_Texts + " │ " + c_Reset;

    // METHODS
	Scanner scan = new Scanner(System.in);
	NumberFormat currency = NumberFormat.getCurrencyInstance();
	
	
	public static void firstDecision() {
    	// Method
    	PrintWriter print = new PrintWriter(System.out);
    	
    	// Logic_Inventory METHOD
    	Logics_AllDecisions logics_AllDecisions = new Logics_AllDecisions();
    	Logics_Inventory mths = new Logics_Inventory();
		
		while(true) {
			try {
				int countFormatIns = 18;
				int countFAfter = 18;
				System.out.println(newLines);
	        	print.println("\t " + "┌" + "─".repeat(170) + "┐");
	        	String accessSystem = 
	        			"\t │ " + " ".repeat(countFormatIns + 1) + """
	        			 █████████╗  ████████╗ ████████╗█████████╗█████████╗█████████╗       █████████╗███╗  ███╗█████████╗█████████╗█████████╗████╗    ████╗       """ + " ".repeat(countFAfter) + "│ \n"  
	        	        + "\t │ " + " ".repeat(countFormatIns) + """
	        			███╔════███╗███╔═════╝███╔═════╝███╔═════╝███╔═════╝███╔═════╝       ███╔═════╝███╚══███║███╔═════╝   ███╔══╝███╔═════╝█████╗  █████║       """ + " ".repeat(countFAfter) + "│ \n" 
	        			+ "\t │ " + " ".repeat(countFormatIns) + """
	        	        ███████████║███║      ███║      ███████╗  █████████╗█████████╗       █████████╗ ███████╔╝█████████╗   ███║   ███████╗  ███╔█████╔███║       """ + " ".repeat(countFAfter) + "│ \n" 
	        	        + "\t │ " +  " ".repeat(countFormatIns) + """
	        	        ███╔════███║███║      ███║      ███╔═══╝  ╚═════███║╚═════███║       ╚═════███║   ███╔═╝ ╚═════███║   ███║   ███╔═══╝  ███║╚███╔╝███║       """ + " ".repeat(countFAfter) + "│ \n" 
	        	        + "\t │ " +  " ".repeat(countFormatIns) + """
	        	        ███║    ███║╚████████╗╚████████╗█████████╗█████████║█████████║       █████████║   ███║   █████████║   ███║   █████████╗███║ ╚══╝ ███║       """ + " ".repeat(countFAfter) + "│ \n" 
	        	        + "\t │ " +  " ".repeat(countFormatIns) + """
	        	        ╚══╝    ╚══╝ ╚═══════╝ ╚═══════╝╚════════╝╚════════╝╚════════╝       ╚════════╝   ╚══╝   ╚════════╝   ╚══╝   ╚════════╝╚══╝      ╚══╝       """ + " ".repeat(countFAfter) + "│" +
	        	        """
	        	        """;
        		
	        	print.println(accessSystem);
	        	print.println("\t " + "└" + "─".repeat(170) + "┘");
	        	print.println("\t " + "█".repeat(172));
	        	print.flush();
				
				
				// WHAT TO ACCESS, ASKED TO THE USER
	        	System.out.println("\n");
	        	System.out.println(tabSpace + "_".repeat(172));
	        	System.out.println(tabSpace);
	        	System.out.println(centerRepeat +  b_Texts + "========================================" + c_Reset);
	            System.out.println(tabSpace + centerRepeat + " ".repeat(3) + b_Texts + "CHOOSE TO ACCESS" + "   " + c_Reset);
	            
	            String line11Option = (tabSpace + subCR54 + b_verticalLine + "  [" + c_Green + b_Texts + "1" + c_Reset +  "] " + c_Green + b_Texts + "Inventory " + c_Reset);
	            String line12Option = ( tabSpace + " ".repeat(12) + b_verticalLine + " ".repeat(2) + "[" + c_Green + b_Texts + "2" + c_Reset +  "] " + c_Green + b_Texts + "Item" + c_Reset + " ".repeat(19) + b_verticalLine);
	            
	            String line131Option = (tab + subCR54 + b_Texts +  " ┌" + "─".repeat(30) + "┬" + "─".repeat(29) + "┐" + c_Reset);
	            String line132Option = (tab + subCR54 + b_Texts +  " ├" + "─".repeat(30) + "┼" + "─".repeat(29) + "┤" + c_Reset);
	            String line133Option = (tab + subCR54 + b_Texts +  " └" + "─".repeat(30) + "┴" + "─".repeat(29) + "┘" + c_Reset);
	            
	            
	            String line14Option = (tabSpace + subCR54 + b_verticalLine + "  [" + c_Green + b_Texts + "3" + c_Reset +  "] " + c_Green + b_Texts + "Group or Category " + c_Reset);
	            String line15Option = (tabSpace + " ".repeat(4) + b_verticalLine  + " ".repeat(2) + "[" + c_Green + b_Texts + "4" + c_Reset +  "] " + c_Green + b_Texts + "Manage Account " + " ".repeat(8) + c_Reset + b_verticalLine);
	            
	            String line16Option = (tabSpace + subCR54 + b_verticalLine + "  [" + c_Green + b_Texts + "5" + c_Reset +  "] " + c_Green + b_Texts + "Exit to Profile " + c_Reset);
	            String line17Option = (tabSpace + " ".repeat(6) + b_verticalLine  + " ".repeat(2) + "[" + c_Green + b_Texts + "6" + c_Reset +  "] " + c_Green + b_Texts + "Exit the System " + " ".repeat(7) + c_Reset + b_verticalLine);
		        
	            String line18Option = (tabSpace + subCR54 + c_Green + b_Texts +  " —> " + c_Reset);
	            
	            print.println(line131Option);
	            print.print(line11Option);
	            print.println(line12Option);
	            
	            print.println(line132Option);
	            print.print(line14Option);	
	            print.println(line15Option);
	            
	            print.println(line132Option);
	            print.print(line16Option);
	            print.println(line17Option);
	            
	            print.println(line133Option);
	            print.print(line18Option);
	            print.flush();
	            
	            String switch_Control = mths.scan.nextLine().trim();
	            logics_AllDecisions.setFirstDecisions(switch_Control);
	            break;
			}
			catch(Exception e) {
				System.out.println("firstDecision SOMETHING WENT WRONG" + e.getMessage());
			}
			
			finally {
				System.out.println(newLines);
			}
		}
	}
    
    
    public static void firstDecisionDuplicate() {
    	// Method
    	PrintWriter print = new PrintWriter(System.out);
    	
    	// Logic_Inventory METHOD
    	Logics_Inventory mths = new Logics_Inventory();
    	
		while(true) {
			try {
				int countFormatIns = 18;
				int countFAfter = 18;
				System.out.println(newLines);
	        	print.println("\t " + "┌" + "─".repeat(170) + "┐");
	        	String accessSystem = 
	        			"\t │ " + " ".repeat(countFormatIns + 1) + """
	        			 █████████╗  ████████╗ ████████╗█████████╗█████████╗█████████╗       █████████╗███╗  ███╗█████████╗█████████╗█████████╗████╗    ████╗       """ + " ".repeat(countFAfter) + "│ \n"  
	        	        + "\t │ " + " ".repeat(countFormatIns) + """
	        			███╔════███╗███╔═════╝███╔═════╝███╔═════╝███╔═════╝███╔═════╝       ███╔═════╝███╚══███║███╔═════╝   ███╔══╝███╔═════╝█████╗  █████║       """ + " ".repeat(countFAfter) + "│ \n" 
	        			+ "\t │ " + " ".repeat(countFormatIns) + """
	        	        ███████████║███║      ███║      ███████╗  █████████╗█████████╗       █████████╗ ███████╔╝█████████╗   ███║   ███████╗  ███╔█████╔███║       """ + " ".repeat(countFAfter) + "│ \n" 
	        	        + "\t │ " +  " ".repeat(countFormatIns) + """
	        	        ███╔════███║███║      ███║      ███╔═══╝  ╚═════███║╚═════███║       ╚═════███║   ███╔═╝ ╚═════███║   ███║   ███╔═══╝  ███║╚███╔╝███║       """ + " ".repeat(countFAfter) + "│ \n" 
	        	        + "\t │ " +  " ".repeat(countFormatIns) + """
	        	        ███║    ███║╚████████╗╚████████╗█████████╗█████████║█████████║       █████████║   ███║   █████████║   ███║   █████████╗███║ ╚══╝ ███║       """ + " ".repeat(countFAfter) + "│ \n" 
	        	        + "\t │ " +  " ".repeat(countFormatIns) + """
	        	        ╚══╝    ╚══╝ ╚═══════╝ ╚═══════╝╚════════╝╚════════╝╚════════╝       ╚════════╝   ╚══╝   ╚════════╝   ╚══╝   ╚════════╝╚══╝      ╚══╝       """ + " ".repeat(countFAfter) + "│" +
	        	        """
	        	        """;
        		
	        	print.println(accessSystem);
	        	print.println("\t " + "└" + "─".repeat(170) + "┘");
	        	print.println("\t " + "█".repeat(172));
	        	print.flush();
				
				// WHAT TO ACCESS, ASKED TO THE USER
	        	System.out.println("\n");
	        	System.out.println(tabSpace + "_".repeat(172));
	        	System.out.println(tabSpace);
	        	System.out.println(centerRepeat +  b_Texts + "========================================" + c_Reset);
	            System.out.println(tabSpace + centerRepeat + " ".repeat(3) + b_Texts + "CHOOSE TO ACCESS" + "   " + c_Reset);
	            
	            String line11Option = (tabSpace + subCR54 + b_verticalLine + "  [" + c_Green + b_Texts + "1" + c_Reset +  "] " + c_Green + b_Texts + "Inventory " + c_Reset);
	            String line12Option = ( tabSpace + " ".repeat(12) + b_verticalLine + " ".repeat(2) + "[" + c_Green + b_Texts + "2" + c_Reset +  "] " + c_Green + b_Texts + "Item" + c_Reset + " ".repeat(19) + b_verticalLine);
	            
	            String line131Option = (tab + subCR54 + b_Texts +  " ┌" + "─".repeat(30) + "┬" + "─".repeat(29) + "┐" + c_Reset);
	            String line132Option = (tab + subCR54 + b_Texts +  " ├" + "─".repeat(30) + "┼" + "─".repeat(29) + "┤" + c_Reset);
	            String line133Option = (tab + subCR54 + b_Texts +  " └" + "─".repeat(30) + "┴" + "─".repeat(29) + "┘" + c_Reset);
	            
	            
	            String line14Option = (tabSpace + subCR54 + b_verticalLine + "  [" + c_Green + b_Texts + "3" + c_Reset +  "] " + c_Green + b_Texts + "Group or Category " + c_Reset);
	            String line15Option = (tabSpace + " ".repeat(4) + b_verticalLine  + " ".repeat(2) + "[" + c_Green + b_Texts + "4" + c_Reset +  "] " + c_Green + b_Texts + "Manage Account " + " ".repeat(8) + c_Reset + b_verticalLine);
	            
	            String line16Option = (tabSpace + subCR54 + b_verticalLine + "  [" + c_Green + b_Texts + "5" + c_Reset +  "] " + c_Green + b_Texts + "Exit to Profile " + c_Reset);
	            String line17Option = (tabSpace + " ".repeat(6) + b_verticalLine  + " ".repeat(2) + "[" + c_Green + b_Texts + "6" + c_Reset +  "] " + c_Green + b_Texts + "Exit the System " + " ".repeat(7) + c_Reset + b_verticalLine);
		        
	            String line18Option = (tabSpace + subCR54 + c_Green + b_Texts +  " —> " + c_Reset);
	            
	            print.println(line131Option);
	            print.print(line11Option);
	            print.println(line12Option);
	            
	            print.println(line132Option);
	            print.print(line14Option);	
	            print.println(line15Option);
	            
	            print.println(line132Option);
	            print.print(line16Option);
	            print.println(line17Option);
	            
	            print.println(line133Option);
	            print.print(line18Option);
	            print.flush();
	            String numOrStr = mths.scan.nextLine().trim();
				
				System.out.println(newLines);
				if (numOrStr.equalsIgnoreCase("Inventory") || numOrStr.equals("1")) {
					Logics_Inventory.chooseInventoryOptionDuplicate();
					break;
				}
				else if (numOrStr.equalsIgnoreCase("Item") || numOrStr.equals("2")) {
					Logics_Item.chooseItemOptionDuplicate();
					break;
				}
				else if (numOrStr.equalsIgnoreCase("Group or Category") || numOrStr.equals("3")) {
					Logics_Group.chooseGroupOptionDuplicate(); //dapat duplicate din to run looping
					break;
				}
				
				else if (numOrStr.equalsIgnoreCase("Manage Account") || numOrStr.equals("4")) {
					Logics_ManageAccount.chooseManageAccountOption();
					break;
				}
				
				else if (numOrStr.equalsIgnoreCase("Exit to Profile") || numOrStr.equals("5")) {
					Logics_ProfileUser.profileUserDuplicate();
					break;
				}
				else if (numOrStr.equalsIgnoreCase("Exit the System") || numOrStr.equals("6")){
					System.out.println(tabLine + b_Texts + "Exited and Went Back..." + c_Reset);
					break;
				}
				else {
					System.out.println(tabSpace + minorCR48 + "Try Another: ");
					Logics_AccessSystem.repeatingChooseFirstDecisionAgain();
					continue;
				}
			}
			catch(Exception e) {
				System.out.println("firstDecisionDuplicate SOMETHING WENT WRONG" + e.getMessage());
			}
			
			finally {
				System.out.println(newLines);
			}
		}
	}
   
    public static void repeatingChooseFirstDecisionAgain(){
    	// Method
    	PrintWriter print = new PrintWriter(System.out);
    	
    	// Logic_Inventory METHOD
    	Logics_Inventory mths = new Logics_Inventory();
		
    	while(true) {
    		try {
	        	System.out.println("\n");
	        	System.out.println(tabSpace + "_".repeat(172));
	        	System.out.println(tabSpace);
	        	System.out.println(centerRepeat +  b_Texts + "========================================" + c_Reset);
	            System.out.println(tabSpace + centerRepeat + " ".repeat(3) + b_Texts + "CHOOSE TO ACCESS" + "   " + c_Reset);
	            
	            String line11Option = (tabSpace + subCR54 + b_verticalLine + "  [" + c_Green + b_Texts + "1" + c_Reset +  "] " + c_Green + b_Texts + "Inventory " + c_Reset);
	            String line12Option = ( tabSpace + " ".repeat(12) + b_verticalLine + " ".repeat(2) + "[" + c_Green + b_Texts + "2" + c_Reset +  "] " + c_Green + b_Texts + "Item" + c_Reset + " ".repeat(19) + b_verticalLine);
	            
	            String line131Option = (tab + subCR54 + b_Texts +  " ┌" + "─".repeat(30) + "┬" + "─".repeat(29) + "┐" + c_Reset);
	            String line132Option = (tab + subCR54 + b_Texts +  " ├" + "─".repeat(30) + "┼" + "─".repeat(29) + "┤" + c_Reset);
	            String line133Option = (tab + subCR54 + b_Texts +  " └" + "─".repeat(30) + "┴" + "─".repeat(29) + "┘" + c_Reset);
	            
	            
	            String line14Option = (tabSpace + subCR54 + b_verticalLine + "  [" + c_Green + b_Texts + "3" + c_Reset +  "] " + c_Green + b_Texts + "Group or Category " + c_Reset);
	            String line15Option = (tabSpace + " ".repeat(4) + b_verticalLine  + " ".repeat(2) + "[" + c_Green + b_Texts + "4" + c_Reset +  "] " + c_Green + b_Texts + "Manage Account " + " ".repeat(8) + c_Reset + b_verticalLine);
	            
	            String line16Option = (tabSpace + subCR54 + b_verticalLine + "  [" + c_Green + b_Texts + "5" + c_Reset +  "] " + c_Green + b_Texts + "Exit to Profile " + c_Reset);
	            String line17Option = (tabSpace + " ".repeat(6) + b_verticalLine  + " ".repeat(2) + "[" + c_Green + b_Texts + "6" + c_Reset +  "] " + c_Green + b_Texts + "Exit the System " + " ".repeat(7) + c_Reset + b_verticalLine);
		        
	            String line18Option = (tabSpace + subCR54 + c_Green + b_Texts +  " —> " + c_Reset);
	            
	            print.println(line131Option);
	            print.print(line11Option);
	            print.println(line12Option);
	            
	            print.println(line132Option);
	            print.print(line14Option);	
	            print.println(line15Option);
	            
	            print.println(line132Option);
	            print.print(line16Option);
	            print.println(line17Option);
	            
	            print.println(line133Option);
	            print.print(line18Option);
	            print.flush();
	            String numOrStr = mths.scan.nextLine().trim();
				
				System.out.println(newLines);
				if (numOrStr.equalsIgnoreCase("Inventory") || numOrStr.equals("1")) {
					Logics_Inventory.chooseInventoryOptionDuplicate();
					break;
				}
				else if (numOrStr.equalsIgnoreCase("Item") || numOrStr.equals("2")) {
					Logics_Item.chooseItemOptionDuplicate();
					break;
				}
				else if (numOrStr.equalsIgnoreCase("Group or Category") || numOrStr.equals("3")) {
					Logics_Group.chooseGroupOptionDuplicate(); //dapat duplicate din to run looping
					break;
				}
				
				else if (numOrStr.equalsIgnoreCase("Manage Account") || numOrStr.equals("4")) {
					Logics_ManageAccount.chooseManageAccountOption();
					break;
				}
				
				else if (numOrStr.equalsIgnoreCase("Exit to Profile") || numOrStr.equals("5")) {
					Logics_ProfileUser.profileUserDuplicate();
					break;
				}
				else if (numOrStr.equalsIgnoreCase("Exit the System") || numOrStr.equals("6")){
					System.out.println(tabLine + b_Texts + "Exited and Went Back..." + c_Reset);
					break;
				}
				else {
					System.out.println(tabSpace + minorCR48 + "Try Another: ");
					Logics_AccessSystem.repeatingChooseFirstDecisionAgain();
					continue;
				}
    		}
    		
    		catch(Exception e) {
    			System.out.println("repeatingChooseFirstDecisionAgain SOMETHING WENT WRONG" + e.getMessage());
    		}
    	}
    }
    
}
