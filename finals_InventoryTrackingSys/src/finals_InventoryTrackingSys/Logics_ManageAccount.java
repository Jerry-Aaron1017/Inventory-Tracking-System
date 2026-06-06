package finals_InventoryTrackingSys;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class Logics_ManageAccount {
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
	final static String minorCR43 = " ".repeat(43);
	
	final static String newLines5 = ("\n\n\n\n\n");
	
	final static String tab = "\t";
	final static String tabSpace = "\t ";
	final static String tabLine = "\t | ";
	
	final static String b_verticalLine = b_Texts + "|" + c_Reset;
	final static String b_verticalSpacesLine = b_Texts + " | " + c_Reset;
	
	// VARIABLE FOR DECISIONS
	String firstChoice;
	static String secondChoice;
    static String thirdChoice;
    static String fourthChoice;
    
    // VARIABLES FOR DATA HOLDER IN ACCOUNT
    static boolean passwordHolder;
    static boolean userNameHolder;
    static boolean flagName;
	static boolean flagPassword;
    static int retryCount = 0;
    static boolean setConfirmation;
    
    private static boolean continueAccessSystem;
    
    // METHODS
	Scanner scan = new Scanner(System.in);
	
	// FILE DECLARATIONS
	Path fPath = Paths.get(filePath.getAbsolutePath());
	FileWriter writer;
	FileReader fReader;
	
	
	public static void chooseManageAccountOption() {
		// Method
    	PrintWriter print = new PrintWriter(System.out);
    	Logics_ManageAccount mths = new Logics_ManageAccount();
    	Logics_AllDecisions logics_AllDecisions = new Logics_AllDecisions();
		
		try {			
        	// UI Format: 
        	int countFormat = 8;
        	int CF1 = 9;
        	int CF2 = 12;
        	print.println("\n");
        	print.println("\t " + b_Texts + "—".repeat(172) + c_Reset);
        	String manageAccount = 
        			"\t | " + " ".repeat(countFormat) + """
        			███╗    ████╗ █████████╗ █████╗  ███╗ █████████╗  ████████╗████████╗        █████████╗  ████████╗ ████████╗ ████████╗ ███╗   ███╗█████╗  ███╗█████████╗ """ + " ".repeat(CF1) + "| \n"  
        	        + "\t | " + " ".repeat(countFormat) + """
        			█████╗  █████║███╔════███╗██████╗ ███║███╔════███╗███╔═════╝███╔════╝       ███╔════███╗███╔═════╝███╔═════╝███╔═══███╗███║   ███║██████╗ ███║   ███╔══╝ """ + " ".repeat(CF1) + "| \n" 
        			+ "\t | " + " ".repeat(countFormat) + """
        	        ███╔█████╔███║███████████║███╔███╗███║███████████║███║ ████╗██████╗         ███████████║███║      ███║      ███║   ███║███║   ███║███╔███╗███║   ███║    """ + " ".repeat(CF2) + "| \n" 
        	        + "\t | " +  " ".repeat(countFormat) + """
        	        ███║╚███╔╝███║███╔════███║███║╚██████║███╔════███║███║  ███║███╔══╝         ███╔════███║███║      ███║      ███║   ███║███║   ███║███║╚██████║   ███║    """ + " ".repeat(CF2) + "| \n" 
        	        + "\t | " +  " ".repeat(countFormat) + """
        	        ███║ ╚══╝ ███║███║    ███║███║ ╚═████║███║    ███║╚████████║████████╗       ███║    ███║╚████████╗╚████████╗╚████████╔╝ ████████╔╝███║ ╚═████║   ███║    """ + " ".repeat(CF2) + "| \n" 
        	        + "\t | " +  " ".repeat(countFormat) + """
        	        ╚══╝      ╚══╝╚══╝    ╚══╝╚══╝   ╚═══╝╚══╝    ╚══╝ ╚═══════╝╚═══════╝       ╚══╝    ╚══╝ ╚═══════╝ ╚═══════╝ ╚═══════╝  ╚═══════╝ ╚══╝   ╚═══╝   ╚══╝    """ + " ".repeat(CF2) + "|" +
        	        """
        	        """;
    		
        	print.println(manageAccount);
        				
			
        	print.println("\t " + "—".repeat(172));
        	print.println("\t " + "█".repeat(172));
        	Thread.sleep(1000);
        	print.flush();
			
			// WHAT TO ACCESS, ASKED TO THE USER
        	Thread.sleep(750);
        	System.out.println("\n");
        	System.out.println(tabSpace + " " + "_".repeat(170));
        	System.out.println(tabSpace);
        	System.out.println(centerRepeat +  b_Texts + "========================================" + c_Reset);
            System.out.println(tabSpace + centerRepeat + " ".repeat(3) + b_Texts + "CHOOSE TO ACCESS" + "   " + c_Reset);
			
			String fillerLine = (tabSpace + minorCR43 + b_Texts +  "—".repeat(86) + "" + c_Reset);
			String line10Option = (tabSpace + " ".repeat(44) + b_verticalLine + "  [" + c_Green + b_Texts + "1" + c_Reset + "]" + b_Texts + " Change Password" + c_Reset + " ".repeat(19));   // ENTERS USERNAME THEN VERIFIES, ASKS WHAT CHANGE PASS WILL BE
			String line11Option = (b_verticalLine + " ".repeat(10) + "  [" + c_Green + b_Texts + "2" + c_Reset + "]" + b_Texts + " Create New Account" + c_Reset + " ".repeat(7) + b_verticalLine); // createAccount();
			String line12Option = (tabSpace + " ".repeat(44) + b_verticalLine + "  [" + c_Green + b_Texts + "3" + c_Reset + "]" + b_Texts + " Delete an Account" + c_Reset + " ".repeat(17));
			String line13Option = (b_verticalLine + " ".repeat(10) + "  [" + c_Green + b_Texts + "4" + c_Reset + "]" + b_Texts + " Retry Entering Account" + c_Reset + " ".repeat(3) + b_verticalLine); //PAPUNTANG ACCSYST	
			String line14Option = (" ".repeat(53) + b_verticalLine + " ".repeat(28) + "  [" + c_Green + b_Texts + "5" + c_Reset + "]" + b_Texts + " Exit and Go Back" + c_Reset + " ".repeat(32) + b_verticalLine);
			String setterLine = (subCR53 + b_Texts + " —> " + c_Reset);
			
			print.println(fillerLine);
			print.print(line10Option);
			print.println(line11Option);
			print.println(fillerLine);

			print.print(line12Option);
			print.println(line13Option);
			print.println(fillerLine);

			print.println(line14Option);
			print.println(fillerLine);
			print.print(setterLine);
			
			print.flush();
			String setManageAccountDecision =  mths.scan.nextLine().trim();
			logics_AllDecisions.setFifthDecision(setManageAccountDecision);
		}
		
		catch(Exception e) {
			e.getMessage();
		}
	}
	
	public static void chooseManageAccountOptionDuplicate() {
		// Method
    	PrintWriter print = new PrintWriter(System.out);

		while(true) {
			try {			
	        	// UI Format: 
	        	int countFormat = 8;
	        	int CF1 = 9;
	        	int CF2 = 12;
	        	print.println("\n");
	        	print.println("\t " + b_Texts + "—".repeat(172) + c_Reset);
	        	String manageAccount = 
	        			"\t | " + " ".repeat(countFormat) + """
	        			████╗    ████╗ █████████╗ █████╗  ███╗ █████████╗  ████████╗████████╗        █████████╗  ████████╗ ████████╗ ████████╗ ███╗   ███╗█████╗  ███╗█████████╗ """ + " ".repeat(CF1) + "| \n"  
	        	        + "\t | " + " ".repeat(countFormat) + """
	        			█████╗  █████║███╔════███╗██████╗ ███║███╔════███╗███╔═════╝███╔════╝       ███╔════███╗███╔═════╝███╔═════╝███╔═══███╗███║   ███║██████╗ ███║   ███╔══╝ """ + " ".repeat(CF1) + "| \n" 
	        			+ "\t | " + " ".repeat(countFormat) + """
	        	        ███╔█████╔███║███████████║███╔███╗███║███████████║███║ ████╗██████╗         ███████████║███║      ███║      ███║   ███║███║   ███║███╔███╗███║   ███║    """ + " ".repeat(CF2) + "| \n" 
	        	        + "\t | " +  " ".repeat(countFormat) + """
	        	        ███║╚███╔╝███║███╔════███║███║╚██████║███╔════███║███║  ███║███╔══╝         ███╔════███║███║      ███║      ███║   ███║███║   ███║███║╚██████║   ███║    """ + " ".repeat(CF2) + "| \n" 
	        	        + "\t | " +  " ".repeat(countFormat) + """
	        	        ███║ ╚══╝ ███║███║    ███║███║ ╚═████║███║    ███║╚████████║████████╗       ███║    ███║╚████████╗╚████████╗╚████████╔╝ ████████╔╝███║ ╚═████║   ███║    """ + " ".repeat(CF2) + "| \n" 
	        	        + "\t | " +  " ".repeat(countFormat) + """
	        	        ╚══╝      ╚══╝╚══╝    ╚══╝╚══╝   ╚═══╝╚══╝    ╚══╝ ╚═══════╝╚═══════╝       ╚══╝    ╚══╝ ╚═══════╝ ╚═══════╝ ╚═══════╝  ╚═══════╝ ╚══╝   ╚═══╝   ╚══╝    """ + " ".repeat(CF2) + "|" +
	        	        """
	        	        """;
	    		
	        	print.println(manageAccount);
	        	print.println("\t " + "—".repeat(172));
	        	print.println("\t " + "█".repeat(172));
	        	Thread.sleep(1000);
				print.flush();
				Thread.sleep(750);
				
				print.flush();
			}
			
			catch(Exception e) {
				e.getMessage();
			}
			
			finally {
				repeatingChooseManageAccount();
			}
		break;
		}
	}
	
	// 
	public static void forgottenPassword() {
		while(true) {
			try {
				
			}
			
			catch (Exception e){
				e.getMessage();
			}
			
			finally {
				repeatingChooseManageAccount();
			}
			break;
		}
	}
	
	// OPTION IN ACCESS SYSTEM and WHEN RETRYING MORE THAN 3
	public static void createAccount() {
		// Method
    	PrintWriter print = new PrintWriter(System.out);
		    	
		//Logic_Inventory METHOD
    	Logics_ManageAccount mths = new Logics_ManageAccount();
    	
		while(true) {
			try {
				mths.writer = new FileWriter(mths.fPath.toString(), true);
				
				System.out.println(newLines5);
				System.out.println(centerRepeat +  b_Texts + "========================================" + c_Reset);
	            System.out.println(tabSpace + centerRepeat + " ".repeat(1) +  b_Texts + "CREATE YOUR PROFILE" + "   " + c_Reset);
	            
	            String firstLineOption = (tabSpace + minorCR45 + b_verticalLine + " ".repeat(36) + b_Texts + "USERNAME" + c_Reset + " ".repeat(36) + b_verticalLine);
	            String secondtLineOption = (tabSpace + minorCR45 + b_verticalLine + " ".repeat(36) + b_Texts + "PASSWORD" + c_Reset + " ".repeat(36) + b_verticalLine);
	            
	            String usernameDescription1 = (tabSpace + minorCR45 + b_verticalLine + " ".repeat(23) + "Username must only contain " + b_Texts + c_Green + "letters" 
	            							+ c_Reset + " ".repeat(23) + b_verticalLine);
	            
	            String passwordDescription1 = (tabSpace + minorCR45 + b_verticalLine + " ".repeat(17) + "Password must contain " + b_Texts + c_Green + "8 or more characters of" 
	            		                    + c_Reset + " ".repeat(18) + b_verticalLine);
	            String passwordDescription2 = (tabSpace + minorCR45 + b_verticalLine + " ".repeat(11) + b_Texts + c_Green +  "letters" + c_Reset + ", " + b_Texts  
	            		   + c_Green + "numbers" + c_Reset + "(" + b_Texts  + c_Green + "0-9" + c_Reset + "),"  + " and " + b_Texts + c_Green + "symbols" + c_Reset + "("
						   + b_Texts  + c_Green + "@" + c_Reset + ", " + b_Texts  + c_Green + "$" + c_Reset + ", " + b_Texts  + c_Green +"!" + c_Reset + ", " 
						   + b_Texts  + c_Green + "%" + c_Reset + ", " + b_Texts  + c_Green + "*" + c_Reset + ", " + b_Texts  + c_Green + "?" + c_Reset + ", or " 
						   + b_Texts  + c_Green + "&" + c_Reset + ")" + " ".repeat(11) + b_verticalLine);
	            
	            String setterLine = (tabSpace + minorCR45 + c_Green + b_Texts +  " —> " + c_Reset);
	            String fillerLine = (tab + minorCR45 + b_Texts +  "—".repeat(84) + c_Reset); 
	            
	            System.out.println(fillerLine);

				System.out.println(firstLineOption);
				System.out.println(usernameDescription1);
				System.out.println(fillerLine);
				System.out.print(setterLine);
				String userName = mths.scan.nextLine();
				Logics_ProfileUser.enterUsername(userName);
				Logics_ProfileUser.usernameVerification();
				String passWord = "";
				
				System.out.println("\n\n");
	            if(Logics_ProfileUser.userNameHolder) {
		            System.out.println(fillerLine);
		            System.out.println(secondtLineOption);
		            System.out.println(passwordDescription1);
		            System.out.println(passwordDescription2);
		            System.out.println(fillerLine);
		            System.out.print(setterLine);
		            passWord = mths.scan.nextLine();
					Logics_ProfileUser.enterPassword(passWord);
		            
		            print.println(fillerLine);
		            print.flush();
		            Logics_ProfileUser.passwordVerification();
	            }
	            Logics_ManageAccount.confirmationByAdmin();
	            
	            if (Logics_ManageAccount.getConfirmation()) {
		            mths.writer.write("Account" + ";");
					mths.writer.write(userName + ";");
					mths.writer.write(passWord + ";none;0;0;0;no group;no date;");
					mths.writer.write("\n");
					mths.writer.flush();
					mths.writer.close();
					break;
	            }
	            
	            else if (Logics_ManageAccount.getConfirmation() == false) {
	            	
	            }
			}
			
			catch (Exception e) {
				System.out.println("SOMETHING WENT WRONG IN retryPassword: " + e.getMessage());
			}
		}
	}
	
	// 
	public static void confirmationByAdmin() {
		System.out.println("UNDER CONSTRUCTION -> Creation of Account Confirmation by Administrator");
		
		while(true) {
			try {
				
			}
			
			catch (Exception e){
				e.getMessage();
			}
		}
		
		// ADMIN THAT CONFIRMS THE ACCOUNT TO BE CREATED OR REMOVED MUST BE CONFIRMS AS "AccountAdministrator"
		// To create another AdministratorAccount, it must be confirmed by another Administrator, consenting on adding a Supervisor or Manager, a account of a high-level position
	}
	
	// 
	public static void accountCheckerByAdmin() {
		System.out.println("UNDER CONSTRUCTION -> Checks the Database for the \"AdministratorAccount\" same with accountChecker but with additional verification of an existing AdminAccount");
		
		while(true) {
			try {
				
			}
			
			catch (Exception e){
				e.getMessage();
			}
		}
		
		// ADMIN THAT CONFIRMS THE ACCOUNT TO BE CREATED OR REMOVED MUST BE CONFIRMS AS "AccountAdministrator"
		// To create another AdministratorAccount, it must be confirmed by another Administrator, consenting on adding a Supervisor or Manager, a account of a high-level position
	}
	
	public static void setConfirmation(boolean setConfirmation) {
		Logics_ManageAccount.setConfirmation = setConfirmation;
	}
	
	public static boolean getConfirmation() {
		return Logics_ManageAccount.setConfirmation;
	}
	
	public static void accountChecker() {
		//METHODS
		Logics_ManageAccount mths = new Logics_ManageAccount();

		while(true) {
	    	try {
    			FileReader fR = new FileReader(mths.fPath.toString());
    			BufferedReader br1 = new BufferedReader(fR);
    			String Lines = "";

    			while((Lines = br1.readLine()) != null) {
    				String [] DATA = Lines.split(";");
    				
    				// USERNAME VERIFICATION IF EXISTING ALREADY
    				if (DATA [1].equals(Logics_ProfileUser.getEnteredUsername()) && DATA [2].equals(Logics_ProfileUser.getEnteredPassword())) {
    					flagName = true;
    					flagPassword = true;
    					break;
    				}
    				
    				else if (DATA [1].equals(Logics_ProfileUser.getEnteredUsername()) && DATA [2] != (Logics_ProfileUser.getEnteredPassword())){
    					flagName = true;
    					flagPassword = false;
    				}
    				
    				else if (DATA [1] != (Logics_ProfileUser.getEnteredUsername()) && DATA [2].equals(Logics_ProfileUser.getEnteredPassword())){
    					flagName = false;
    					flagPassword = true;
    				}
    				
    				else {
    					flagName = false;
    					flagPassword = false;
    				}
    			}
    			br1.close();
    		}
	    	
	    	catch(Exception e) {
	    		System.out.println("SOMETHING WENT WRONG IN accountChecker: " + e.getMessage());
	    	}
	    	
	    	finally {
            	for (int num = 0; num < 51; num++) {
            	    try {
            	    	System.out.print("\n");
            	        Thread.sleep(5);
            	    } catch (InterruptedException e) {
            	        Thread.currentThread().interrupt();
            	    }
            	}

            	System.out.print(tabSpace + " ".repeat(25) + 
		            			""" 
		            			██┐   ██┐██████┐██████┐ ██████┐██████┐██    ██┐██████┐███┐  ██┐ ██████┐     """ + tabSpace + " ".repeat(35) + "\n" + tabSpace + " ".repeat(25) + """
		            			██│   ██│██────┘██┌──██┐  ██┌─┘██┌───┘ ██  ██┌┘  ██┌─┘████┐ ██│██┌────┘     """ + tabSpace + " ".repeat(35) + "\n" + tabSpace + " ".repeat(26) + """
		            			 ██┐ ██┌┘████┐  ██████┌┘  ██│  ████┐    ████┌┘   ██│  ██┌██┐██│██│ ███┐     """ + tabSpace + " ".repeat(35) + "\n" + tabSpace + " ".repeat(26) + """
		            			 ██│ ██│ ██──┘  ██┌──██┐  ██│  ██┌─┘     ██┌┘    ██│  ██│└████│██│  ██│     """ + tabSpace + " ".repeat(35) + "\n" + tabSpace + " ".repeat(27) + """
            				      ████┌┘ ██████┐██│  ██│██████┐██│       ██│   ██████┐██│ └███│└██████│     """ + tabSpace + " ".repeat(35) + "\n" + tabSpace + " ".repeat(27) + """
		            			  └───┘  └─────┘└─┘  └─┘└─────┘└─┘       └─┘   └─────┘└─┘  └──┘ └─────┘     """ + "  "
		            			  );
            	for (int num = 0; num < 5; num++) {
            		System.out.print(" ▀ ");
            	    try {
            	    	Thread.sleep(250);
            	    } 
            	    catch (InterruptedException e) {
	            	        Thread.currentThread().interrupt();
            	    }
            	}
            	
            	try {
		    		if (flagName && flagPassword) {
		            	System.out.println(c_Green + b_Texts + "\u001B[6m" + " !! ACCOUNT DOES EXIST !!" + c_Reset);
		            	System.out.println(newLines5 + newLines5);
		            	Thread.sleep(1500);
		            	System.out.println(newLines5 + newLines5);
		    			break;
		    		}
		    		
		    		else if (flagName == false || flagPassword == false) {
		    			Logics_ManageAccount.manageWrongAccount();
		    			break;
		    		}
	    		}
	    		
	    		catch(Exception e){
	    			e.getMessage();
	    		}
	    		
	    	}
		}
	}
	
	
	public static void removeAccount() {
    	//MEHODS
    	Logics_ManageAccount mths = new Logics_ManageAccount();
    	PrintWriter print = new PrintWriter(System.out);
    	    	
		// VARIABLE

    	final String dashBFormat = " ".repeat(38);
    	
    	while(true) {
	    	try {
	    		System.out.println(" REMOVE ACCOUNT : UNDER CONSTRUCTION");
	    		System.out.println("UNDER CONSTRUCTION -> Removing of an Account Confirmation by Administrator");
	    		
    			print.println("\n");
	        	print.println("\t " + b_Texts + "—".repeat(172) + c_Reset);
    			String removeItem = tabLine + dashBFormat + """
		    			█████████╗ █████████╗████╗    ████╗ █████████╗ ███╗   ███╗█████████╗        █████████╗  ████████╗ ████████╗ ████████╗ ███╗   ███╗█████╗  ███╗█████████╗ """ + " ".repeat(12) + "| \n" +
		    			tabLine + dashBFormat + """
		    			███╔═══███╗███╔═════╝█████╗  █████║███╔════███║███║   ███║███╔═════╝       ███╔════███╗███╔═════╝███╔═════╝███╔═══███╗███║   ███║██████╗ ███║   ███╔══╝ """ + " ".repeat(12) + "| \n" +
		    			tabLine + dashBFormat + """
		    			█████████╔╝███████╗  ███╔█████╔███║███║    ███║ ███╗ ███╔╝███████╗         ███████████║███║      ███║      ███║   ███║███║   ███║███╔███╗███║   ███║    """ + " ".repeat(16) + "| \n" +
		    			tabLine + dashBFormat + """    
		    			███╔═══███╗███╔═══╝  ███║╚███╔╝███║███║    ███║ ███║ ███║ ███╔═══╝         ███╔════███║███║      ███║      ███║   ███║███║   ███║███║╚██████║   ███║    """ + " ".repeat(16) + "| \n" +
		    			tabLine + dashBFormat + """
		    			███║   ███║█████████╗███║ ╚══╝ ███║╚█████████╔╝  ██████╔╝ █████████╗       ███║    ███║╚████████╗╚████████╗╚████████╔╝ ████████╔╝███║ ╚═████║   ███║    """ + " ".repeat(16) + "| \n" +
		    			tabLine + dashBFormat + """
		    			╚══╝   ╚══╝╚════════╝╚══╝      ╚══╝ ╚════════╝   ╚═════╝  ╚════════╝       ╚══╝    ╚══╝ ╚═══════╝ ╚═══════╝ ╚═══════╝  ╚═══════╝ ╚══╝   ╚═══╝   ╚══╝    """ + " ".repeat(16) + "|" + """
		    			""";
    			print.println(removeItem);
	    		print.println(tabSpace + "—".repeat(172));
	        	print.println(tabSpace + "█".repeat(172));
	        	print.flush();
	        	
	        	// SHOWS ALL ACCOUNTS
	        	
	        	String toDelete = mths.scan.nextLine();
	        	
	        	
	    	}
	    	
	    	catch(Exception e){
	    		System.out.println(tabLine + "SOMETHING WENT WRONG IN REMOVEITEM " + e.getMessage());
	    	}
	    	
	    	finally {
	    		repeatingChooseManageAccount();
	    	}
    	break;
    	}
	}
	
	// Duplicate BReAAAAAAAAAADCRUMBS
	public static void retryEnteringAcccount() {
		while(true) {
			try {
	        	// Method
	        	PrintWriter print = new PrintWriter(System.out);
	        	
	        	//Logic_Inventory METHOD
	        	Logics_Inventory mths = new Logics_Inventory();
	        	mths.writer = new FileWriter(mths.fPath.toString(), true);
	        	
	        	// UI Format: 
	        	int countFormat = 46;
	        	String CF1 = " ".repeat(49);
	        	String CF2 = " ".repeat(51);
	        	print.println("\n");
	        	print.println("\t " + b_Texts + "—".repeat(172) + c_Reset);
	        	System.out.println("RETRYAGAIN FOR MANAGE ACCOUNT");
	        	String retryAgain = 
	        			"\t | " + " ".repeat(countFormat) + """
	        			███╗     ███╗████████╗███╗      ███████╗ ████████╗ ████╗    ████╗████████╗""" + CF1 + "| \n"  
	        	        + "\t | " + " ".repeat(countFormat) + """
	        			███║     ███║███╔════╝███║     ███╔════╝███╔═══███╗█████╗  █████║███╔════╝""" + CF1 + "| \n" 
	        			+ "\t | " + " ".repeat(countFormat) + """
	        	        ███║ ██╗ ███║██████╗  ███║     ███║     ███║   ███║███╔█████╔███║██████╗""" + CF2 + "| \n" 
	        	        + "\t | " +  " ".repeat(countFormat) + """
	        	        ███║████╗███║███╔══╝  ███║     ███║     ███║   ███║███║╚███╔╝███║███╔══╝""" + CF2 + "| \n" 
	        	        + "\t | " +  " ".repeat(countFormat) + """
	        	        ╚█████╔████╔╝████████╗████████╗╚███████╗╚████████╔╝███║ ╚══╝ ███║████████╗""" + CF1 + "| \n" 
	        	        + "\t | " +  " ".repeat(countFormat + 1) + """
	        	         ╚════╝╚═══╝ ╚═══════╝╚═══════╝ ╚══════╝ ╚═══════╝ ╚══╝      ╚══╝╚═══════╝""" + CF1 + "|" +
	        	        """
	        	        """;
        		
	        	print.println(retryAgain);
	        	print.println("\t " + "—".repeat(172));
	        	print.println("\t " + "█".repeat(172));
	        	print.flush();
	        	
	        	System.out.println("\n");
	        	System.out.println(tabSpace + " " + "_".repeat(170));
	        	System.out.println(tabSpace);
	        	
	        	System.out.println(centerRepeat +  b_Texts + "========================================" + c_Reset);
	            System.out.println(tabSpace + centerRepeat + " ".repeat(2) +  b_Texts + "ENTER YOUR PROFILE" + "   " + c_Reset);
	            
	            String firstLineOption = (tabSpace + minorCR45 + b_verticalLine + " ".repeat(36) + b_Texts + "USERNAME" + c_Reset + " ".repeat(36) + b_verticalLine);
	            String secondtLineOption = (tabSpace + minorCR45 + b_verticalLine + " ".repeat(36) + b_Texts + "PASSWORD" + c_Reset + " ".repeat(36) + b_verticalLine);
	            String usernameDescription1 = (tabSpace + minorCR45 + b_verticalLine + " ".repeat(23) + "Username must only contain " + b_Texts + c_Green + "letters" 
	            		   						+ c_Reset + " ".repeat(23) + b_verticalLine);
	            String passwordDescription1 = (tabSpace + minorCR45 + b_verticalLine + " ".repeat(17) + "Password must contain " + b_Texts + c_Green + "8 or more characters of" 
	            		                       + c_Reset + " ".repeat(18) + b_verticalLine);
	            String passwordDescription2 = (tabSpace + minorCR45 + b_verticalLine + " ".repeat(11) + b_Texts + c_Green +  "letters" + c_Reset + ", " + b_Texts  
	            		   + c_Green + "numbers" + c_Reset + "(" + b_Texts  + c_Green + "0-9" + c_Reset + "),"  + " and " + b_Texts + c_Green + "symbols" + c_Reset + "("
						   + b_Texts  + c_Green + "@" + c_Reset + ", " + b_Texts  + c_Green + "$" + c_Reset + ", " + b_Texts  + c_Green +"!" + c_Reset + ", " 
						   + b_Texts  + c_Green + "%" + c_Reset + ", " + b_Texts  + c_Green + "*" + c_Reset + ", " + b_Texts  + c_Green + "?" + c_Reset + ", or " 
						   + b_Texts  + c_Green + "&" + c_Reset + ")" + " ".repeat(11) + b_verticalLine);

	            String setterLine = (tabSpace + minorCR45 + c_Green + b_Texts +  " —> " + c_Reset);
	            String fillerLine = (tab + minorCR45 + b_Texts +  "—".repeat(84) + c_Reset); 
	            
	            System.out.println(fillerLine);
				System.out.println(firstLineOption);
				System.out.println(usernameDescription1);
				System.out.println(fillerLine);
				System.out.print(setterLine);
				String retryUsername = mths.scan.nextLine().trim();
				Logics_ProfileUser.enterUsername(retryUsername);
				
				System.out.print(fillerLine);
	            Logics_ProfileUser.usernameVerification();
	            
				System.out.println("\n\n");
	            if(userNameHolder){
		            System.out.println(fillerLine);
		            System.out.println(secondtLineOption);
		            System.out.println(passwordDescription1);
		            System.out.println(passwordDescription2);
		            System.out.println(fillerLine);
		            System.out.print(setterLine);
					String retryPassword = mths.scan.nextLine().trim();
					Logics_ProfileUser.enterPassword(retryPassword);
		            
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
	
	// OPTION IN ACCESS SYSTEM and WHEN RETRYING MORE THAN 3
	public static void manageWrongAccount() {
		while(true) {
			try {
				//edit an account or create account
				// Method
	        	PrintWriter print = new PrintWriter(System.out);
	        	
	        	//Logic_Inventory METHOD
	        	Logics_ManageAccount mths = new Logics_ManageAccount();
	        	mths.writer = new FileWriter(mths.fPath.toString(), true);
	        	
	        	// UI Format: 
	        	int countFormat = 14;
	        	int CF1 = 14;
	        	int CF2 = 17;
	        	print.println("\n");
	        	print.println("\t " + b_Texts + "—".repeat(172) + c_Reset);
	        	String manageAccount = 
	        			"\t | " + " ".repeat(countFormat) + """
	        			███╗     ███╗█████████╗  █████████╗ █████╗  ███╗ ████████╗        █████████╗  ████████╗ ████████╗ ████████╗ ███╗   ███╗█████╗  ███╗█████████╗ """ + " ".repeat(CF1) + "| \n"  
	        	        + "\t | " + " ".repeat(countFormat) + """
	        			███║     ███║███╔═══███╗███╔════███║██████╗ ███║███╔═════╝       ███╔════███╗███╔═════╝███╔═════╝███╔═══███╗███║   ███║██████╗ ███║   ███╔══╝""" + " ".repeat(CF1) + "| \n" 
	        			+ "\t | " + " ".repeat(countFormat) + """
	        	        ███║ ██╗ ███║█████████╔╝███║    ███║███╔███╗███║███║ ████╗       ███████████║███║      ███║      ███║   ███║███║   ███║███╔███╗███║   ███║    """ + " ".repeat(CF2) + "| \n" 
	        	        + "\t | " +  " ".repeat(countFormat) + """
	        	        ███║████╗███║███╔═══███╗███║    ███║███║╚██████║███║  ███║       ███╔════███║███║      ███║      ███║   ███║███║   ███║███║╚██████║   ███║    """ + " ".repeat(CF2) + "| \n" 
	        	        + "\t | " +  " ".repeat(countFormat) + """
	        	        ╚█████╔████╔╝███║   ███║╚█████████╔╝███║ ╚═████║╚████████║       ███║    ███║╚████████╗╚████████╗╚████████╔╝ ████████╔╝███║ ╚═████║   ███║    """ + " ".repeat(CF2) + "| \n" 
	        	        + "\t | " +  " ".repeat(countFormat + 1) + """
	        	         ╚════╝╚═══╝ ╚══╝   ╚══╝ ╚════════╝ ╚══╝   ╚═══╝ ╚═══════╝       ╚══╝    ╚══╝ ╚═══════╝ ╚═══════╝ ╚═══════╝  ╚═══════╝ ╚══╝   ╚═══╝   ╚══╝   """ + " ".repeat(CF2) + "|" +
	        	        """
	        	        """;
	    		
	        	print.println(manageAccount);
	        	print.println("\t " + "—".repeat(172));
	        	print.println("\t " + "█".repeat(172));

	            String emp = c_Red + b_Texts + "!!" + c_Reset;
	            String noteWrongName = (tabSpace + minorCR47 + " ".repeat(21) + emp + b_Texts + " Recheck the " + c_Reset + c_Red + b_Texts + "Username" + c_Reset + b_Texts + " you entered. " + emp  + c_Reset);
	            String noteWrongPassword = (tabSpace + minorCR47 + " ".repeat(21) + emp + b_Texts + " Recheck the " + c_Reset + c_Red + b_Texts + "Password" + c_Reset + b_Texts + " you entered. " + emp  + c_Reset);            
	            String noteAccountNotFound = (tabSpace + minorCR47 + " ".repeat(13) + emp + b_Texts + " Recheck the " + c_Reset + c_Red + b_Texts + "Username " + c_Reset + b_Texts + "and" + c_Red + " Password" 
	            							  + c_Reset + b_Texts + " you entered. " + emp + c_Reset);
	            
	            String firstLineOption = (tabSpace + minorCR45 + b_verticalLine + " ".repeat(36) + b_Texts + "USERNAME" + c_Reset + " ".repeat(36) + b_verticalLine);
	            String secondtLineOption = (tabSpace + minorCR45 + b_verticalLine + " ".repeat(36) + b_Texts + "PASSWORD" + c_Reset + " ".repeat(36) + b_verticalLine);
	            String usernameDescription1 = (tabSpace + minorCR45 + b_verticalLine + " ".repeat(23) + "Username must only contain " + b_Texts + c_Green + "letters" 
	            					  		  + c_Reset + " ".repeat(23) + b_verticalLine);
	            String passwordDescription1 = (tabSpace + minorCR45 + b_verticalLine + " ".repeat(17) + "Password must contain " + b_Texts + c_Green + "8 or more characters of" 
	            		                       + c_Reset + " ".repeat(18) + b_verticalLine);
	            String passwordDescription2 = (tabSpace + minorCR45 + b_verticalLine + " ".repeat(11) + b_Texts + c_Green +  "letters" + c_Reset + ", " + b_Texts  
	            		   + c_Green + "numbers" + c_Reset + "(" + b_Texts  + c_Green + "0-9" + c_Reset + "),"  + " and " + b_Texts + c_Green + "symbols" + c_Reset + "("
						   + b_Texts  + c_Green + "@" + c_Reset + ", " + b_Texts  + c_Green + "$" + c_Reset + ", " + b_Texts  + c_Green +"!" + c_Reset + ", " 
						   + b_Texts  + c_Green + "%" + c_Reset + ", " + b_Texts  + c_Green + "*" + c_Reset + ", " + b_Texts  + c_Green + "?" + c_Reset + ", or " 
						   + b_Texts  + c_Green + "&" + c_Reset + ")" + " ".repeat(11) + b_verticalLine);
	
	            String setterLine = (tabSpace + minorCR45 + c_Green + b_Texts +  " —> " + c_Reset);
	            String fillerLine = (tab + minorCR45 + b_Texts +  "—".repeat(84) + c_Reset); 
	            
	            if((flagPassword == false) && (flagName == false)){
	            	System.out.println(c_Red + b_Texts + " !! ACCOUNT DOES NOT EXIST !!" + c_Reset);
	            	Thread.sleep(2500);
	            	System.out.println(newLines5 + newLines5 + newLines5 + newLines5);
	            	
	            	Thread.sleep(1500);
	            	System.out.println(newLines5);

	            	print.flush();
	            	
		        	print.println("\n");
		        	print.println(tabSpace + " " + "_".repeat(170));
		        	print.println(tabSpace);	   
		        	
		        	print.println(centerRepeat +  b_Texts + "========================================" + c_Reset);
		        	print.println(tabSpace + centerRepeat + " ".repeat(2) +  b_Texts + "MANAGE YOUR ACCOUNT" + c_Reset);
	            	Thread.sleep(500);
	            	print.flush();
	            	
	            	System.out.println(fillerLine);
            		System.out.print(tabSpace + " ".repeat(45) + b_verticalLine + " ".repeat(4)
            				+ " [" + b_Texts + "1" + c_Reset +  "] " + b_Texts + "Retry Entering Account " + c_Reset);
	            	
            		System.out.println(" ".repeat(8) + b_verticalLine 
	            			+ " ".repeat(8) + "[" + b_Texts + "2" + c_Reset +  "] " + b_Texts + "Create Another Account " + c_Reset + " ".repeat(4) + b_verticalLine);
	            	System.out.println(fillerLine);
            		System.out.println(tabSpace + " ".repeat(45) + b_verticalLine 
	            			+ " ".repeat(31) + "[" + b_Texts + "3" + c_Reset +  "] " + b_Texts + "Exit the System " + c_Reset + " ".repeat(29) + b_verticalLine);
            		System.out.println(fillerLine);
	            	System.out.print(setterLine);
	            	String decisionRetry = mths.scan.nextLine();
	            	
	            	if(decisionRetry.equals("1") || decisionRetry.equalsIgnoreCase("Retry") || decisionRetry.equalsIgnoreCase("Retry Entering")) {
						System.out.println(newLines5);
						print.println(noteAccountNotFound);
						
						print.println(fillerLine);
						print.println(firstLineOption);
						print.println(usernameDescription1);
						
						print.println(fillerLine);
						print.println(tabSpace + minorCR47 + " ".repeat(2) + b_Texts + "Entry earlier: " + c_Red + Logics_ProfileUser.getEnteredUsername() + c_Reset);
						print.println(fillerLine);
						print.print(setterLine);
						print.flush();
						String userName = mths.scan.nextLine();
						Logics_ProfileUser.enterUsername(userName);
						System.out.println("\n\n");

						print.println(fillerLine);
						print.println(secondtLineOption);
						print.println(passwordDescription1);
						print.println(passwordDescription2);
			            
						print.println(fillerLine);
						print.println(tabSpace + minorCR47 + " ".repeat(2) + b_Texts + "Entry earlier: " + c_Red + Logics_ProfileUser.getEnteredPassword() + c_Reset);
						print.println(fillerLine);
						print.print(setterLine);
						print.flush();
						String passWord = mths.scan.nextLine();
						Logics_ProfileUser.enterPassword(passWord);
						
			            Logics_ManageAccount.accountChecker();
			            Logics_ManageAccount.setContinueAccessSystem(true);
						break;
	            	}
	            	else if(decisionRetry.equals("2") || decisionRetry.equalsIgnoreCase("Create")  || decisionRetry.equalsIgnoreCase("Create Account")) {
	            		Logics_ManageAccount.createAccount();
	            		Logics_ManageAccount.setContinueAccessSystem(true);
	            		break;
	            	}
	            	
	            	else if(decisionRetry.equals("3") || decisionRetry.equalsIgnoreCase("Exit")  || decisionRetry.equalsIgnoreCase("Exit and The Syystem")) {
	            		Logics_ManageAccount.setContinueAccessSystem(false);
	            		break;
	            	}
				}
	            
	            else if (flagName == false) {	
	            	System.out.println(c_Red + b_Texts + " !! USERNAME DOES NOT EXIST !!" + c_Reset);
	            	Thread.sleep(2500);
	            	System.out.println(newLines5 + newLines5 + newLines5 + newLines5);

	            	Thread.sleep(1500);
	            	System.out.println(newLines5);
	            	print.flush();
	            	
		        	print.println("\n");
		        	print.println(tabSpace + " " + "_".repeat(170));
		        	print.println(tabSpace);	   
		        	
		        	print.println(centerRepeat +  b_Texts + "========================================" + c_Reset);
		        	print.println(tabSpace + centerRepeat + " ".repeat(2) +  b_Texts + "MANAGE YOUR ACCOUNT" + c_Reset);
	            	Thread.sleep(500);
	            	print.flush();
	            	
					print.println(noteWrongName);
					print.flush();
					Thread.sleep(1500);
					
					print.println(fillerLine);
					print.println(firstLineOption);
					print.println(usernameDescription1);
					
					print.println(fillerLine);
					print.println(tabSpace + minorCR47 + " ".repeat(2) + b_Texts + "You entered: " + c_Red + Logics_ProfileUser.getEnteredUsername() + c_Reset);
					print.println(fillerLine);
					print.print(setterLine);
					print.flush();
					String userName = mths.scan.nextLine();
					Logics_ProfileUser.enterUsername(userName);
					
					Logics_ManageAccount.accountChecker();
					break;
				}
				
				else if (flagPassword == false) {
	            	System.out.println(c_Red + b_Texts + "     !! WRONG PASSWORD !!" + c_Reset);
	            	Thread.sleep(2500);
	            	System.out.println(newLines5 + newLines5 + newLines5 + newLines5);

	            	Thread.sleep(1500);
	            	System.out.println(newLines5);
	            	print.flush();
	            	
		        	print.println("\n");
		        	print.println(tabSpace + " " + "_".repeat(170));
		        	print.println(tabSpace);	   
		        	
		        	print.println(centerRepeat +  b_Texts + "========================================" + c_Reset);
		        	print.println(tabSpace + centerRepeat + " ".repeat(2) +  b_Texts + "MANAGE YOUR ACCOUNT" + c_Reset);
		        	
	            	Thread.sleep(500);
	            	print.flush();
	            	
					print.println(noteWrongPassword);
					print.flush();
					Thread.sleep(1500);
					
					print.println(fillerLine);
					print.println(secondtLineOption);
					print.println(passwordDescription1);
					print.println(passwordDescription2);
		            
					print.println(fillerLine);
					print.println(tabSpace + minorCR47 + " ".repeat(2) + b_Texts + " You entered: " + c_Red + Logics_ProfileUser.getEnteredPassword() + c_Reset);
					print.println(fillerLine);
					print.print(setterLine);
					print.flush();
					String passWord = mths.scan.nextLine();
					Logics_ProfileUser.enterPassword(passWord);
					
					Logics_ManageAccount.accountChecker();
					break;
				}
			}
			
			catch (Exception e) {
				System.out.println("SOMETHING WENT WRONG IN retryPassword: " + e.getMessage());
			}
			
			finally {
				System.out.println(newLines5);
			}
		}
	}
	
	public static void setContinueAccessSystem(boolean setContinue) {
		Logics_ManageAccount.continueAccessSystem = setContinue;
	}
	
	public static boolean getContinueAccessSystem() {
		return continueAccessSystem;
	}
	
	
	public static void repeatingChooseManageAccount() {
		// Method
    	PrintWriter print = new PrintWriter(System.out);
    	Logics_ManageAccount mths = new Logics_ManageAccount();

    	while(true) {
			try {			
				print.println(tabSpace);	
	        	print.println(centerRepeat +  b_Texts + "========================================" + c_Reset);
	        	print.println(tabSpace  + " ".repeat(72) + b_Texts + "CHOOSE AGAIN OR EXIT THE PROGRAM" + c_Reset);

				
				String fillerLine = (tabSpace + minorCR43 + b_Texts +  "—".repeat(86) + "" + c_Reset);
				String line10Option = (tabSpace + " ".repeat(44) + b_verticalLine + "  [" + c_Green + b_Texts + "1" + c_Reset + "]" + b_Texts + " Change Password" + c_Reset + " ".repeat(19));   // ENTERS USERNAME THEN VERIFIES, ASKS WHAT CHANGE PASS WILL BE
				String line11Option = (b_verticalLine + " ".repeat(10) + "  [" + c_Green + b_Texts + "2" + c_Reset + "]" + b_Texts + " Create New Account" + c_Reset + " ".repeat(7) + b_verticalLine); // createAccount();
				String line12Option = (tabSpace + " ".repeat(44) + b_verticalLine + "  [" + c_Green + b_Texts + "3" + c_Reset + "]" + b_Texts + " Delete an Account" + c_Reset + " ".repeat(17));
				String line13Option = (b_verticalLine + " ".repeat(10) + "  [" + c_Green + b_Texts + "4" + c_Reset + "]" + b_Texts + " Retry Entering Account" + c_Reset + " ".repeat(3) + b_verticalLine); //PAPUNTANG ACCSYST	
				String line14Option = (" ".repeat(53) + b_verticalLine + " ".repeat(28) + "  [" + c_Green + b_Texts + "5" + c_Reset + "]" + b_Texts + " Exit and Go Back" + c_Reset + " ".repeat(32) + b_verticalLine);
				String setterLine = (subCR53 + b_Texts + " —> " + c_Reset);
				
				print.println(fillerLine);
				print.print(line10Option);
				print.println(line11Option);
				print.println(fillerLine);
	
				print.print(line12Option);
				print.println(line13Option);
				print.println(fillerLine);
	
				print.println(line14Option);
				print.println(fillerLine);
				print.print(setterLine);
				
				print.flush();
				String numOrStr =  mths.scan.nextLine().trim();
				
				
				if (numOrStr.equals("1")  || numOrStr.equalsIgnoreCase("Change") || numOrStr.equalsIgnoreCase("Forgot") || numOrStr.equalsIgnoreCase("Password") || numOrStr.equalsIgnoreCase("Forgot Password")) {
					Logics_ManageAccount.forgottenPassword();
					//>>verification >>checks accountForDuplication >> if passes>> write.acc
					break;
				}
				else if (numOrStr.equals("2") || numOrStr.equalsIgnoreCase("Create") || numOrStr.equalsIgnoreCase("Create New Account") || numOrStr.equalsIgnoreCase("New Account")) {
					Logics_ManageAccount.createAccount(); 
					// >>verification >>checks accountForDuplication(similar with accountChecker) >> if passes>> write.acc
					break;
				} 
				
				else if (numOrStr.equals("3") || numOrStr.equalsIgnoreCase("Delete") || numOrStr.equalsIgnoreCase("Delete an Account")) {
					Logics_ManageAccount.removeAccount(); 
					//>>verification >> >> if passes>> write.acc
					break;
				}
				
				else if (numOrStr.equals("4") || numOrStr.equalsIgnoreCase("Use Other") || numOrStr.equalsIgnoreCase("Use Other Account") || numOrStr.equalsIgnoreCase("Retry")) {
					Logics_ManageAccount.retryEnteringAcccount(); 
					//>>verification >> >> if passes>> continue to system
					break;
				}
				
				else if (numOrStr.equals("5") || numOrStr.equalsIgnoreCase("Exit") || numOrStr.equalsIgnoreCase("Exit and Go Back") || numOrStr.equalsIgnoreCase("Go Back")) {
					Logics_AccessSystem.firstDecisionDuplicate();
					break;
				}
				
				else {
					System.out.println(tabSpace + minorCR48 + "Try Another: ");
					continue;
				}
			}
			
			catch(Exception e) {
				e.getMessage();
			}
		}
	}
	
}
