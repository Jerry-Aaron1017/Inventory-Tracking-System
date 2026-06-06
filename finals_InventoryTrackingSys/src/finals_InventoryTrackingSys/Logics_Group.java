package finals_InventoryTrackingSys;

import java.io.*;
import java.nio.file.*;
import java.text.*;
import java.util.*;

public class Logics_Group {
	static final File filePathGrp = new File ("C:\\Users\\Jerry Aaron\\git\\Inventory-Tracking-System\\finals_InventoryTrackingSys\\src\\InventoryGroups");
	
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
	Path fPathGrp = Paths.get(filePathGrp.getAbsolutePath());
	FileWriter writer;
	FileReader fReader;

    
    
    public static void chooseGroupOption() {
    	//MEHODS
    	Logics_Group mths = new Logics_Group();
    	PrintWriter print = new PrintWriter(System.out);
    	Logics_AllDecisions logics_AllDecisions = new Logics_AllDecisions();
    	
		// VARIABLE
    	int numDBF = 57;
    	final String dashBFormat = " ".repeat(numDBF);
    	
		try {
			print.println("\n");
			print.println("\t " + b_Texts + "—".repeat(172) + c_Reset);
	    	final String group = tabLine + dashBFormat + " " + """
	    			 ████████╗█████████╗  █████████╗ ███╗   ███╗█████████╗  """ + " ".repeat(58) + "| \n" +
	    			tabLine + dashBFormat + """
	    			███╔═════╝███╔═══███╗███╔════███╗███║   ███║███    ███╗ """ + " ".repeat(57) + "| \n" +
	    			tabLine + dashBFormat + """
	    			███║ ████╗█████████╔╝███║    ███║███║   ███║█████████╔╝ """ + " ".repeat(57) + "| \n" +
	    			tabLine + dashBFormat + """ 
	    			███║  ███║███╔═══███╗███║    ███║███║   ███║███╔═════╝  """ + " ".repeat(58) + "| \n" +
	    			tabLine + dashBFormat + """
	    			╚████████║███║   ███║╚█████████╔╝ ████████╔╝███║        """ + " ".repeat(64) + "| \n" +
	    			tabLine + dashBFormat + " " + """
	    			 ╚═══════╝╚══╝   ╚══╝ ╚════════╝  ╚═══════╝ ╚══╝        """ + " ".repeat(64) + "|" + """
	    			""";
    		print.println(group);
    		print.println(tabSpace + "—".repeat(172));
        	print.println(tabSpace + "█".repeat(172));
    		print.flush();
		    		
			print.println("\n");
			print.println(tabSpace + " " + "—".repeat(170));
        	print.flush();
        	
    		System.out.println(tabSpace);
        	System.out.println(centerRepeat +  b_Texts + "========================================" + c_Reset);

	    	System.out.println(tabSpace + centerRepeat + " ".repeat(3) + b_Texts + "Access Group to".toUpperCase() + c_Reset);
            System.out.println(tabSpace + minorCR43 + b_Texts +  "—".repeat(86) + "" + c_Reset);

	    	System.out.print(subCR53 + b_verticalLine + "  [" + b_Texts + "1" + c_Reset + "]" + b_Texts + " Show Group List" + c_Reset);
	        System.out.println(" ".repeat(19) + b_verticalLine + " ".repeat(14) + "[" + b_Texts + "2" + c_Reset + "]" + b_Texts + " Add a Group  " + " ".repeat(10) + b_verticalLine + c_Reset);
	        System.out.println(tabSpace + minorCR43 + b_Texts + "" +  "—".repeat(86) + c_Reset);
	        
	        System.out.print(subCR53 + b_verticalLine + "  [" + b_Texts + "3" + c_Reset + "]" + b_Texts + " Remove a Group" + c_Reset);
	        System.out.println(" ".repeat(20) + b_verticalLine + " ".repeat(14) + "[" + b_Texts + "4" + c_Reset + "]" + b_Texts + " Exit and Go Back   " + " ".repeat(4) + b_verticalLine + c_Reset);
	        System.out.println(tabSpace + minorCR43 + b_Texts + "" +  "—".repeat(86) + "" + c_Reset);
	        
	        System.out.print(subCR53 + b_Texts + " —> " + c_Reset);
	        String setGroupDecision = mths.scan.nextLine().trim();
	        logics_AllDecisions.setFourthDecision(setGroupDecision);
	       
    	}
    	
    	catch(Exception e){
    		System.out.println("\t | SOMETHING WENT WRONG IN GROUP OPTION: " + e.getMessage());
    	}
	}
    	
    
	public static void chooseGroupOptionDuplicate() {
    	//METHODS
		PrintWriter print = new PrintWriter(System.out);
    	
    	// VARIABLE
    	int numDBF = 57;
    	final String dashBFormat = " ".repeat(numDBF);
    	
    	while(true) {
    		try {
    			print.println("\n");
    			print.println("\t " + b_Texts + "—".repeat(172) + c_Reset);
    	    	final String group = tabLine + dashBFormat + " " + """
    	    			 ████████╗█████████╗  █████████╗ ███╗   ███╗█████████╗  """ + " ".repeat(58) + "| \n" +
    	    			tabLine + dashBFormat + """
    	    			███╔═════╝███╔═══███╗███╔════███╗███║   ███║███    ███╗ """ + " ".repeat(57) + "| \n" +
    	    			tabLine + dashBFormat + """
    	    			███║ ████╗█████████╔╝███║    ███║███║   ███║█████████╔╝ """ + " ".repeat(57) + "| \n" +
    	    			tabLine + dashBFormat + """ 
    	    			███║  ███║███╔═══███╗███║    ███║███║   ███║███╔═════╝  """ + " ".repeat(58) + "| \n" +
    	    			tabLine + dashBFormat + """
    	    			╚████████║███║   ███║╚█████████╔╝ ████████╔╝███║        """ + " ".repeat(64) + "| \n" +
    	    			tabLine + dashBFormat + " " + """
    	    			 ╚═══════╝╚══╝   ╚══╝ ╚════════╝  ╚═══════╝ ╚══╝        """ + " ".repeat(64) + "|" + """
    	    			""";
        		print.println(group);
        		print.println(tabSpace + "—".repeat(172));
            	print.println(tabSpace + "█".repeat(172));
        		print.flush();
    		    		
    			print.println("\n");
    			print.println(tabSpace + " " + "—".repeat(170));
            	print.flush();
    			}
	    		catch(Exception e) {
					e.printStackTrace();
	    		}
	    		
	    		finally {
	    			repeatingChooseAgainGroup();
	    		}
		break;
    	}
	}

    public static void getGroup() {
    	//METHODS
    	Logics_Group mths = new Logics_Group();
    	PrintWriter print = new PrintWriter(System.out);
    	
    	// VARIABLE
    	final String rep20 = " ".repeat(20);
    	int numRepItem = 32;
    	final String dashBFormat = " ".repeat(numRepItem);
    	
    	while(true) {
    		try {
    		FileReader fR = new FileReader(mths.fPathGrp.toString());
			BufferedReader brIL2 = new BufferedReader(fR);
    				String LINE2;

        			print.println("\n");
        			print.println("\t " + b_Texts + "—".repeat(172) + c_Reset);
        	    	final String groupList = tabLine + dashBFormat + " " + """
        	    			 ████████╗█████████╗  █████████╗ ███╗   ███╗█████████╗        ███╗      █████████╗█████████╗███████████╗ """ + " ".repeat(33) + "| \n" +
        	    			tabLine + dashBFormat + """
        	    			███╔═════╝███╔═══███╗███╔════███╗███║   ███║███    ███╗       ███║         ███╔══╝███╔═════╝    ███╔═══╝ """ + " ".repeat(33) + "| \n" +
        	    			tabLine + dashBFormat + """
        	    			███║ ████╗█████████╔╝███║    ███║███║   ███║█████████╔╝       ███║         ███║   █████████╗    ███║     """ + " ".repeat(37) + "| \n" +
        	    			tabLine + dashBFormat + """ 
        	    			███║  ███║███╔═══███╗███║    ███║███║   ███║███╔═════╝        ███║         ███║   ╚═════███║    ███║     """ + " ".repeat(37) + "| \n" +
        	    			tabLine + dashBFormat + """
        	    			╚████████║███║   ███║╚█████████╔╝ ████████╔╝███║              █████████╗█████████╗█████████║    ███║     """ + " ".repeat(37) + "| \n" +
        	    			tabLine + dashBFormat + " " + """
        	    			 ╚═══════╝╚══╝   ╚══╝ ╚════════╝  ╚═══════╝ ╚══╝              ╚════════╝╚════════╝╚════════╝    ╚══╝     """ + " ".repeat(37) + "|" + """
        	    			""";
            		print.println(groupList);
            		print.println(tabSpace + "—".repeat(172));
                	print.println(tabSpace + "█".repeat(172));
            		print.flush();
    				
    				System.out.println(" ".repeat(76) +  b_Texts + "========================================" + c_Reset);
    				System.out.println(tabSpace + " ".repeat(74) + b_Texts + "GET GROUPS AND THEIR ITEMS".toUpperCase() + c_Reset);
    	    		String askItem = "Enter Name of Group: ";
    	    		System.out.println(tabSpace + " ".repeat(58) + b_Texts +  "—".repeat(58) + c_Reset);
    		        System.out.println(" ".repeat(67) + b_verticalLine + " ".repeat(18) + b_Texts + askItem + " ".repeat(17) + b_verticalLine +  c_Reset);
    		        System.out.println(tabSpace + " ".repeat(58) + b_Texts +  "—".repeat(58) + c_Reset);
    	    		System.out.print(" ".repeat(68) + b_Texts + " —> " + c_Reset);
    	    		String itemHolder = mths.scan.nextLine();
    	    		
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
        				if ((DATA [3].equals ("none") == false) && DATA [7].equalsIgnoreCase(itemHolder)){
        					
    		    			for (int numHolder = 0; numHolder < 1; numHolder++) {
    		    				System.out.print(tabSpace + b_verticalLine + " ".repeat(7) + " ".repeat(40 - DATA[3].length()) + DATA [3] + b_verticalSpacesLine);
    		    			}
    		    			for (int numHolder = 0; numHolder < 1; numHolder++) {
    		    				System.out.print(DATA [4] + " ".repeat(20 - DATA[4].length()) + b_verticalSpacesLine);
    		    			}
    		    			
    		    			for (int numHolder = 0; numHolder < 1; numHolder++) {
    		    				System.out.print(DATA [5] + " ".repeat(20 - DATA[5].length()) + b_verticalSpacesLine);
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
        			System.out.println("\n\n");
        			brIL2.close();
        		}
    		
    		catch(Exception e) {
				e.printStackTrace();
    		}
    		
    		finally {
    			repeatingChooseAgainGroup();
    		}
		break;
    	}
    }
    
    public static void setNewGroup() {
    	//METHODS
    	Logics_Group mths = new Logics_Group();
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
    			repeatingChooseAgainGroup();
    		}
		break;
		}
    }

    public static void removeGroup() {
    	//METHODS
    	Logics_Group mths = new Logics_Group();
    	PrintWriter print = new PrintWriter(System.out);
    	
    	// VARIABLES
    	final String dashBFormat = " ".repeat(38);
    	
    	while(true) {
    		try {
    			mths.writer = new FileWriter(mths.fPathGrp.toString(), true);
    			FileReader fR = new FileReader(mths.fPathGrp.toString());
    			BufferedReader br = new BufferedReader(fR);
    			
    			
    			print.println("\n");
    			print.println("\t " + b_Texts + "—".repeat(172) + c_Reset);
    	    	final String removeGroup = tabLine + dashBFormat + " " + """
    	    			█████████╗ █████████╗████╗    ████╗ █████████╗ ███╗   ███╗█████████╗        ████████╗█████████╗  █████████╗ ███╗   ███╗█████████╗  """ + " ".repeat(34) + "| \n" +
    	    			tabLine + dashBFormat + """
    	    			███╔═══███╗███╔═════╝█████╗  █████║███╔════███╗███║   ███║███╔═════╝       ███╔═════╝███╔═══███╗███╔════███╗███║   ███║███    ███╗ """ + " ".repeat(33) + "| \n" +
    	    			tabLine + dashBFormat + """
    	    			█████████╔╝███████╗  ███╔█████╔███║███║    ███║ ███╗ ███╔╝███████╗         ███║ ████╗█████████╔╝███║    ███║███║   ███║█████████╔╝ """ + " ".repeat(33) + "| \n" +
    	    			tabLine + dashBFormat + """ 
    	    			███╔═══███╗███╔═══╝  ███║╚███╔╝███║███║    ███║ ███║ ███║ ███╔═══╝         ███║  ███║███╔═══███╗███║    ███║███║   ███║███╔═════╝  """ + " ".repeat(34) + "| \n" +
    	    			tabLine + dashBFormat + """
    	    			███║   ███║█████████╗███║ ╚══╝ ███║╚█████████╔╝  ██████╔╝ █████████╗       ╚████████║███║   ███║╚█████████╔╝ ████████╔╝███║        """ + " ".repeat(40) + "| \n" +
    	    			tabLine + dashBFormat + " " + """
    	    			╚══╝   ╚══╝╚════════╝╚══╝      ╚══╝ ╚════════╝   ╚═════╝  ╚════════╝        ╚═══════╝╚══╝   ╚══╝ ╚════════╝  ╚═══════╝ ╚══╝        """ + " ".repeat(39) + "|" + """
    	    			""";
        		print.println(removeGroup);
        		print.println(tabSpace + "—".repeat(172));
            	print.println(tabSpace + "█".repeat(172));
        		print.flush();
    		    		
    			print.println("\n");
    			print.println(tabSpace + " " + "—".repeat(170));
    			print.println(tabSpace + centerRepeat + " ".repeat(5) + b_Texts + "ROMOVE A GROUP" + c_Reset); 
    			print.println(b_Texts + " ".repeat(49) + "—".repeat(92) + c_Reset);
    			print.println( " ".repeat(49) + b_verticalLine + " ".repeat(24) + c_Green + b_Texts + "ENTER THE GROUP TO REMOVE" + c_Reset + " ".repeat(35) + b_verticalLine + c_Reset); 
    			print.println(b_Texts + " ".repeat(49) + "—".repeat(92) + c_Reset);
    			print.flush();
    			
    			
    			
    			
    			br.close();
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
    			repeatingChooseAgainGroup();
    		}
		break;
    	}
    }
    
    public static void checkForDuplicationGroup() {
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
    
    public static void repeatingChooseAgainGroup() {
    	// METHODS
    	Logics_Group mths = new Logics_Group();
    	
    	while(true) {
    		try {
    			System.out.println(tabSpace);
            	System.out.println(centerRepeat +  b_Texts + "========================================" + c_Reset);

    	    	System.out.println(tabSpace + " ".repeat(72) + b_Texts + "CHOOSE AGAIN OR EXIT THE PROGRAM" + c_Reset);
                System.out.println(tabSpace + minorCR43 + b_Texts +  "—".repeat(86) + "" + c_Reset);

    	    	System.out.print(subCR53 + b_verticalLine + "  [" + b_Texts + "1" + c_Reset + "]" + b_Texts + " Show Group List, again" + c_Reset);
    	        System.out.println(" ".repeat(12) + b_verticalLine + " ".repeat(14) + "[" + b_Texts + "2" + c_Reset + "]" + b_Texts + " Add a Group  " + " ".repeat(10) + b_verticalLine + c_Reset);
    	        System.out.println(tabSpace + minorCR43 + b_Texts + "" +  "—".repeat(86) + c_Reset);
    	        
    	        System.out.print(subCR53 + b_verticalLine + "  [" + b_Texts + "3" + c_Reset + "]" + b_Texts + " Remove a Group" + c_Reset);
    	        System.out.println(" ".repeat(20) + b_verticalLine + " ".repeat(14) + "[" + b_Texts + "4" + c_Reset + "]" + b_Texts + " Exit and Go Back   " + " ".repeat(4) + b_verticalLine + c_Reset);
    	        System.out.println(tabSpace + minorCR43 + b_Texts + "" +  "—".repeat(86) + "" + c_Reset);
    	        
    	        System.out.print(subCR53 + b_Texts + " —> " + c_Reset);    		  
		        String numOrStr = mths.scan.nextLine().trim();
		        System.out.println(newLines);

				if (numOrStr.equalsIgnoreCase("Show") || numOrStr.equalsIgnoreCase("Show Group") || numOrStr.equalsIgnoreCase("Show Group List") || numOrStr.equals("1")) {
					Logics_Group.getGroup();   	
					break;
				}
				
				else if (numOrStr.equalsIgnoreCase("Add")|| numOrStr.trim().equalsIgnoreCase("Add Group") || numOrStr.trim().equalsIgnoreCase("Add a Group") || numOrStr.equals("2")) {
					Logics_Group.setNewGroup();    	                                    
					break;
				}
				
				else if (numOrStr.equalsIgnoreCase("Remove") || numOrStr.trim().equalsIgnoreCase("Remove Group") || numOrStr.trim().equalsIgnoreCase("Remove a Group") || numOrStr.equals("3")) {
					Logics_Group.removeGroup();
					break;
	    		}
				
				else if (numOrStr.equalsIgnoreCase("Exit") || numOrStr.trim().equalsIgnoreCase("Exit and Go Back") || numOrStr.trim().equalsIgnoreCase("Go Back") || numOrStr.equals("4")) {
					Logics_AccessSystem.firstDecisionDuplicate();
					break;
				}
    			
    			else {
					System.out.println(tabSpace + minorCR48 + "Try Another: ");
    				continue;
    			}
    		}
    		
    		catch(Exception e) {
    			
    		}
    	}
    }
}
