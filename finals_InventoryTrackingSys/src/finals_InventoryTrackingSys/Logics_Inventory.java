package finals_InventoryTrackingSys;


import java.io.*;

import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.NumberFormat;
import java.util.*;
import java.util.regex.*;

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
	
	// VARIABLE FOR DECISIONS
	String firstChoice;
	static String secondChoice;
    static String thirdChoice;
    
    // VARIABLES FOR DATA HOLDER
    static String userName;
    static String userPassword;
    static boolean passwordHolder;
    static int retryCount = 0;
    
    // ENUM CLASS
    static Enums_Constants enumShow = null;
    
    // METHODS
	Scanner scan = new Scanner(System.in);
	NumberFormat currency = NumberFormat.getCurrencyInstance();
	
	// FILE DECLARATIONS
	Path fPath = Paths.get(filePath.getAbsolutePath());
	FileWriter writer;
	FileReader fReader;
	
	// FIRST BReAAAAAAAAAADCRUMBS
	public static void profileUser() {
		while(true) {
			try {
	        	// Method
	        	PrintWriter print = new PrintWriter(System.out);
	        	
	        	//Logic_Inventory METHOD
	        	Logics_Inventory mths = new Logics_Inventory();
	        	
	        	// UI Format: 
	        	int countFormat = 46;
	        	String CF1 = " ".repeat(49);
	        	String CF2 = " ".repeat(51);
	        	print.println("\n");
	        	print.println("\t " + b_Texts + "—".repeat(172) + c_Reset);
	        	String welcome = 
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
        		
	        	print.println(welcome);
	        	print.println("\t " + "—".repeat(172));
	        	print.println("\t " + "█".repeat(172));
	        	print.flush();
	        	
	        	System.out.println("\n");
	        	System.out.println(tabSpace + " " + "_".repeat(170));
	        	System.out.println(tabSpace);
	        	
	        	System.out.println(centerRepeat +  b_Texts + "========================================" + c_Reset);
	            System.out.println(tabSpace + centerRepeat + " ".repeat(2) +  b_Texts + "ENTER YOUR PROFILE" + "   " + c_Reset);
	            
	            String firstLineOption = (tabSpace + subCR55 + b_verticalLine + " ".repeat(26) + b_Texts + "USERNAME" + c_Reset + " ".repeat(26) + b_verticalLine);
	            String secondtLineOption = (tabSpace + subCR55 + b_verticalLine + " ".repeat(26) + b_Texts + "PASSWORD" + c_Reset + " ".repeat(26) + b_verticalLine);
	            String passworddescription1 = (tabSpace + subCR55 + b_verticalLine + " ".repeat(7) + "Password must contain " + b_Texts + c_Green + "letters" + c_Reset + ", "
						   + b_Texts  + c_Green + "numbers " + c_Reset + "(" + b_Texts  + c_Green + "0 - 9" + c_Reset + ")," + c_Reset + " ".repeat(6) + b_verticalLine);
	            String passworddescription2 = (tabSpace + subCR55 + b_verticalLine + " ".repeat(13) + "and " + b_Texts + c_Green + "symbols " + c_Reset + "("
						   + b_Texts  + c_Green + "@" + c_Reset + ", " + b_Texts  + c_Green + "$" + c_Reset + ", " + b_Texts  + c_Green +"!" + c_Reset + ", " 
						   + b_Texts  + c_Green + "%" + c_Reset + ", " + b_Texts  + c_Green + "*" + c_Reset + ", " + b_Texts  + c_Green + "?" + c_Reset + ", or " 
						   + b_Texts  + c_Green + "&" + c_Reset + ")" + " ".repeat(11) + b_verticalLine);

	            String setterLine = (tabSpace + subCR55 + c_Green + b_Texts +  " —> " + c_Reset);
	            String fillerLine = (tab + subCR55 + b_Texts +  "—".repeat(64) + c_Reset); 
	            
	            System.out.println(fillerLine);
				System.out.println(firstLineOption);
				System.out.println(fillerLine);
				System.out.print(setterLine);
	            userName = mths.scan.nextLine();
	            
	            System.out.println(fillerLine);
	            System.out.println(secondtLineOption);
	            System.out.println(passworddescription1);
	            System.out.println(passworddescription2);
	            System.out.println(fillerLine);
	            System.out.print(setterLine);
	            userPassword = mths.scan.nextLine();
	            
	            print.println(fillerLine);
	            print.flush();
	            Logics_Inventory.passwordVerification();
	            break;
			}
		
			catch(Exception e) {
				System.out.println("profileUser SOMETHING WENT WRONG" + e.getMessage());
			}
		}
	}
	
	// FOLLOW UP FOR RETRYING INPUT PASSWORD
	public static void retryPassword() {
		while(true) {
			try {
	        	// Method
	        	PrintWriter print = new PrintWriter(System.out);
	        	
				//Logic_Inventory METHOD
	        	Logics_Inventory mths = new Logics_Inventory();
	        	
				
				System.out.println(centerRepeat +  b_Texts + "========================================" + c_Reset);
	            System.out.println(tabSpace + centerRepeat + " ".repeat(2) +  b_Texts + "RETRY YOUR PROFILE" + "   " + c_Reset);
	            
	            String firstLineOption = (tabSpace + subCR55 + b_verticalLine + " ".repeat(26) + b_Texts + "USERNAME" + c_Reset + " ".repeat(26) + b_verticalLine);
	            String secondtLineOption = (tabSpace + subCR55 + b_verticalLine + " ".repeat(26) + b_Texts + "PASSWORD" + c_Reset + " ".repeat(26) + b_verticalLine);
	            String passworddescription1 = (tabSpace + subCR55 + b_verticalLine + " ".repeat(7) + "Password must contain " + b_Texts + c_Green + "letters" + c_Reset + ", "
						   + b_Texts  + c_Green + "numbers " + c_Reset + "(" + b_Texts  + c_Green + "0 - 9" + c_Reset + ")," + c_Reset + " ".repeat(6) + b_verticalLine);
	            String passworddescription2 = (tabSpace + subCR55 + b_verticalLine + " ".repeat(13) + "and " + b_Texts + c_Green + "symbols " + c_Reset + "("
						   + b_Texts  + c_Green + "@" + c_Reset + ", " + b_Texts  + c_Green + "$" + c_Reset + ", " + b_Texts  + c_Green +"!" + c_Reset + ", " 
						   + b_Texts  + c_Green + "%" + c_Reset + ", " + b_Texts  + c_Green + "*" + c_Reset + ", " + b_Texts  + c_Green + "?" + c_Reset + ", or " 
						   + b_Texts  + c_Green + "&" + c_Reset + ")" + " ".repeat(11) + b_verticalLine);
	            
	            String setterLine = (tabSpace + subCR55 + c_Green + b_Texts +  " —> " + c_Reset);
	            String fillerLine = (tab + subCR55 + b_Texts +  "—".repeat(64) + c_Reset); 
	            
	            System.out.println(fillerLine);

				System.out.println(firstLineOption);
				System.out.println(fillerLine);
				System.out.print(setterLine);
	            System.out.println(userName);
	            
	            System.out.println(fillerLine);
	            System.out.println(secondtLineOption);
	            System.out.println(passworddescription1);
	            System.out.println(passworddescription2);
	            
	            System.out.println(fillerLine);
	            System.out.print(setterLine);
	            userPassword = mths.scan.nextLine();
	            
	            print.println(fillerLine);
	            print.flush();
	            Logics_Inventory.passwordVerification();
	            break;
			}
				
			catch (Exception e) {
				System.out.println("SOMETHING WENT WRONG IN retryPassword: " + e.getMessage());
			}
		}
	}
	
	@SuppressWarnings("finally")
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
							else System.out.println(tabSpace + subCR55 + b_Texts + "Password must contain " + c_Red + "8 (Eight) characters..." + c_Reset);
						}
						else System.out.println(tabSpace + subCR55 + b_Texts + "Password must contain "+ c_Red + "symbols..." + c_Reset);
					}
					else System.out.println(tabSpace + subCR55 + b_Texts + "Password must contain " + c_Red + "numbers..." + c_Reset);
				}
				else System.out.println(tabSpace + subCR55 + b_Texts + "Password must contain " + c_Red + "letters..." + c_Reset);
			}
			
			catch (Exception e) {
				System.out.println("SOMETHING WENT WRONG IN retryPassword: " + e.getMessage());
			}
			
			finally {
				retryCount += 1;
				System.out.println(newLines);
				
				if(passwordHolder) retryCount = 0;
				
				if (Logics_Inventory.getPasswordVerification() == false) {
					if (retryCount == 3) {
						Logics_Inventory.retryCountNotice();
						break;
					}
				}
				
				if (Logics_Inventory.getPasswordVerification()) {
					break;
				}
				
				else if (Logics_Inventory.getPasswordVerification() == false){
					Logics_Inventory.retryPassword();
					break;
				}
			}
		}
	}
	
	// RETURNS THE BOOLEAN VALUE OF THE PASSWORD VERIFICATION
	public static boolean getPasswordVerification() {
		return passwordHolder;
	}
	
	// NOTICE FOR FAILIND FOR THE 3rd TIME
	public static void retryCountNotice() {
		try {
			System.out.println("NOTICE OF OVERREACHING");
		}
		
		catch (Exception e) {
			System.out.println("SOMETHING WENT WRONG IN retryPassword: " + e.getMessage());
		}
		
		finally {
			retryCount = 0;
			Logics_Inventory.retryPassword();
		}
	}
	
	// OPTION IN ACCESS SYSTEM and WHEN RETRYING MORE THAN 3
	public static void manageAccount() {
		try {
			
		}
		
		catch (Exception e) {
			System.out.println("SOMETHING WENT WRONG IN retryPassword: " + e.getMessage());
		}
	}
	
	// OPTION IN ACCESS SYSTEM and WHEN RETRYING MORE THAN 3
	public static void createAccount() {
		try {
			
		}
		
		catch (Exception e) {
			System.out.println("SOMETHING WENT WRONG IN retryPassword: " + e.getMessage());
		}
	}

	
	//
	public static void firstDecision() {
    	// Method
    	PrintWriter print = new PrintWriter(System.out);
    	
    	// Logic_Inventory METHOD
    	Logics_Inventory opts = new Logics_Inventory();
    	Logics_Inventory mths = new Logics_Inventory();
		
		while(true) {
			try {
				int countFormatIns = 18;
				int countFAfter = 18;
	        	print.println("\n");
	        	print.println("\t " + b_Texts + "—".repeat(172) + c_Reset);
	        	String accessSystem = 
	        			"\t | " + " ".repeat(countFormatIns + 1) + """
	        			 █████████╗  ████████╗ ████████╗█████████╗█████████╗█████████╗       █████████╗███╗  ███╗█████████╗█████████╗█████████╗████╗    ████╗       """ + " ".repeat(countFAfter) + "| \n"  
	        	        + "\t | " + " ".repeat(countFormatIns) + """
	        			███╔════███╗███╔═════╝███╔═════╝███╔═════╝███╔═════╝███╔═════╝       ███╔═════╝███╚══███║███╔═════╝   ███╔══╝███╔═════╝█████╗  █████║       """ + " ".repeat(countFAfter) + "| \n" 
	        			+ "\t | " + " ".repeat(countFormatIns) + """
	        	        ███████████║███║      ███║      ███████╗  █████████╗█████████╗       █████████╗╚███████╔╝█████████╗   ███║   ███████╗  ███╔█████╔███║       """ + " ".repeat(countFAfter) + "| \n" 
	        	        + "\t | " +  " ".repeat(countFormatIns) + """
	        	        ███╔════███║███║      ███║      ███╔═══╝  ╚═════███║╚═════███║       ╚═════███║   ███╔═╝ ╚═════███║   ███║   ███╔═══╝  ███║╚███╔╝███║       """ + " ".repeat(countFAfter) + "| \n" 
	        	        + "\t | " +  " ".repeat(countFormatIns) + """
	        	        ███║    ███║╚████████╗╚████████╗█████████╗█████████║█████████║       █████████║   ███║   █████████║   ███║   █████████╗███║ ╚══╝ ███║       """ + " ".repeat(countFAfter) + "| \n" 
	        	        + "\t | " +  " ".repeat(countFormatIns) + """
	        	        ╚══╝    ╚══╝ ╚═══════╝ ╚═══════╝╚════════╝╚════════╝╚════════╝       ╚════════╝   ╚══╝   ╚════════╝   ╚══╝   ╚════════╝╚══╝      ╚══╝       """ + " ".repeat(countFAfter) + "|" +
	        	        """
	        	        """;
        		
	        	print.println(accessSystem);
	        	print.println("\t " + "—".repeat(172));
	        	print.println("\t " + "█".repeat(172));
	        	print.flush();
				
				
				// WHAT TO ACCESS, ASKED TO THE USER
	        	System.out.println("\n");
	        	System.out.println(tabSpace + " " + "_".repeat(170));
	        	System.out.println(tabSpace);
	        	System.out.println(centerRepeat +  b_Texts + "========================================" + c_Reset);
	            System.out.println(tabSpace + centerRepeat + " ".repeat(3) + b_Texts + "CHOOSE TO ACCESS" + "   " + c_Reset);
	            
	            String line11Option = (tabSpace + subCR54 + b_verticalLine + " [" + b_Texts + "1" + c_Reset +  "] " + b_Texts + "Inventory " + c_Reset);
	            String line12Option = ( tabSpace + " ".repeat(13) + b_verticalLine + " ".repeat(8) + "[" + b_Texts + "2" + c_Reset +  "] " + b_Texts + "Item" + c_Reset + " ".repeat(13) + b_verticalLine);
	            String line13Option = (tab + subCR54 + b_Texts +  "—".repeat(64) + c_Reset);
	           
	            String line14Option = (tabSpace + subCR54 + b_verticalLine + " [" + b_Texts + "3" + c_Reset +  "] " + b_Texts + "Group or Category " + c_Reset);
	            String line15Option = (tabSpace + " ".repeat(5) + b_verticalLine  + " ".repeat(8) + "[" + b_Texts + "4" + c_Reset +  "] " + b_Texts + "Exit to Profile  " + c_Reset + b_verticalLine);
		        String line16Option = (tabSpace + " ".repeat(54) + b_verticalLine + " ".repeat(20) + "[" + b_Texts + "5" + c_Reset + "]" + b_Texts + " Exit the System " + c_Reset + " ".repeat(20) + b_verticalLine);
	            String line17Option = (tabSpace + subCR54 + b_Texts +  " —> " + c_Reset);
	            
	            print.println(line13Option);
	            print.print(line11Option);
	            print.println(line12Option);
	            print.println(line13Option);
	            
	            print.print(line14Option);	
	            print.println(line15Option);
	            print.println(line13Option);
	            print.println(line16Option);
	            print.println(line13Option);
	            print.print(line17Option);
	            print.flush();
	            
	            String switch_Control = mths.scan.nextLine().trim();
	            opts.setFirstDecisions(switch_Control);
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
	        
	        // VALIDATE THE INPUT FOR Exit to Profile
	        else if ((this.firstChoice.equalsIgnoreCase("exit to profile")) || (this.firstChoice.equalsIgnoreCase("to profile")) || (this.firstChoice.equals("4"))) {
	        	if (this.firstChoice.equalsIgnoreCase("exit"))
	        		enumShow = Logics_Inventory.fromString("exit");
	        	
	        	else if (this.firstChoice.equals("4"))
	        		enumShow = Logics_Inventory.fromInt(4);
	        }
	        
	        // VALIDATE THE INPUT FOR Exit the System
	        else if ((this.firstChoice.equalsIgnoreCase("exit")) || (this.firstChoice.equals("5"))) {
	        	if (this.firstChoice.equalsIgnoreCase("exit"))
	        		enumShow = Logics_Inventory.fromString(" ");
	        	
	        	else if (this.firstChoice.equals("5"))
	        		enumShow = Logics_Inventory.fromInt(5);
	        }
	        
	        // VALIDATE THE INPUT FOR DEFAULT
	        else {
	        	if(this.firstChoice.equals(firstChoice))
	        		enumShow = Logics_Inventory.fromInt(6);
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
    
    
    public static void firstDecisionDuplicate() {
    	// Method
    	PrintWriter print = new PrintWriter(System.out);
    	
    	// Logic_Inventory METHOD
    	Logics_Inventory opts = new Logics_Inventory();
    	Logics_Inventory mths = new Logics_Inventory();
		
		while(true) {
			try {
				int countFormatIns = 18;
				int countFAfter = 18;
	        	print.println("\n");
	        	print.println("\t " + b_Texts + "—".repeat(172) + c_Reset);
	        	String accessSystem = 
	        			"\t | " + " ".repeat(countFormatIns + 1) + """
	        			 █████████╗  ████████╗ ████████╗█████████╗█████████╗█████████╗       █████████╗███╗  ███╗█████████╗█████████╗█████████╗████╗    ████╗       """ + " ".repeat(countFAfter) + "| \n"  
	        	        + "\t | " + " ".repeat(countFormatIns) + """
	        			███╔════███╗███╔═════╝███╔═════╝███╔═════╝███╔═════╝███╔═════╝       ███╔═════╝███╚══███║███╔═════╝   ███╔══╝███╔═════╝█████╗  █████║       """ + " ".repeat(countFAfter) + "| \n" 
	        			+ "\t | " + " ".repeat(countFormatIns) + """
	        	        ███████████║███║      ███║      ███████╗  █████████╗█████████╗       █████████╗╚███████╔╝█████████╗   ███║   ███████╗  ███╔█████╔███║       """ + " ".repeat(countFAfter) + "| \n" 
	        	        + "\t | " +  " ".repeat(countFormatIns) + """
	        	        ███╔════███║███║      ███║      ███╔═══╝  ╚═════███║╚═════███║       ╚═════███║   ███╔═╝ ╚═════███║   ███║   ███╔═══╝  ███║╚███╔╝███║       """ + " ".repeat(countFAfter) + "| \n" 
	        	        + "\t | " +  " ".repeat(countFormatIns) + """
	        	        ███║    ███║╚████████╗╚████████╗█████████╗█████████║█████████║       █████████║   ███║   █████████║   ███║   █████████╗███║ ╚══╝ ███║       """ + " ".repeat(countFAfter) + "| \n" 
	        	        + "\t | " +  " ".repeat(countFormatIns) + """
	        	        ╚══╝    ╚══╝ ╚═══════╝ ╚═══════╝╚════════╝╚════════╝╚════════╝       ╚════════╝   ╚══╝   ╚════════╝   ╚══╝   ╚════════╝╚══╝      ╚══╝       """ + " ".repeat(countFAfter) + "|" +
	        	        """
	        	        """;
        		
	        	print.println(accessSystem);
	        	print.println("\t " + "—".repeat(172));
	        	print.println("\t " + "█".repeat(172));
	        	print.flush();
				
				// WHAT TO ACCESS, ASKED TO THE USER
	        	System.out.println("\n");
	        	System.out.println(tabSpace + " " + "_".repeat(170));
	        	System.out.println(tabSpace);
	        	System.out.println(centerRepeat +  b_Texts + "========================================" + c_Reset);
	            System.out.println(tabSpace + centerRepeat + " ".repeat(3) + b_Texts + "CHOOSE TO ACCESS" + "   " + c_Reset);
	            
	            String line11Option = (tabSpace + subCR54 + b_verticalLine + " [" + b_Texts + "1" + c_Reset +  "] " + b_Texts + "Inventory " + c_Reset);
	            String line12Option = ( tabSpace + " ".repeat(13) + b_verticalLine + " ".repeat(8) + "[" + b_Texts + "2" + c_Reset +  "] " + b_Texts + "Item" + c_Reset + " ".repeat(13) + b_verticalLine);
	            String line13Option = (tab + subCR54 + b_Texts +  "—".repeat(64) + c_Reset);
	           
	            String line14Option = (tabSpace + subCR54 + b_verticalLine + " [" + b_Texts + "3" + c_Reset +  "] " + b_Texts + "Group or Category " + c_Reset);
	            String line15Option = (tabSpace + " ".repeat(5) + b_verticalLine  + " ".repeat(8) + "[" + b_Texts + "4" + c_Reset +  "] " + b_Texts + "Exit to Profile  " + c_Reset + b_verticalLine);
		        String line16Option = (tabSpace + " ".repeat(54) + b_verticalLine + " ".repeat(20) + "[" + b_Texts + "5" + c_Reset + "]" + b_Texts + " Exit the System " + c_Reset + " ".repeat(20) + b_verticalLine);
	            String line17Option = (tabSpace + subCR54 + b_Texts +  " —> " + c_Reset);
	            
	            print.println(line13Option);
	            print.print(line11Option);
	            print.println(line12Option);
	            print.println(line13Option);
	            
	            print.print(line14Option);	
	            print.println(line15Option);
	            print.println(line13Option);
	            print.println(line16Option);
	            print.println(line13Option);
	            print.print(line17Option);
	            print.flush();
	            String numOrStr = mths.scan.nextLine().trim();
				
				System.out.println(newLines);
				if (numOrStr.equalsIgnoreCase("Inventory") || numOrStr.equals("1")) {
					Logics_Inventory.chooseInventoryOption();
					break;
				}
				else if (numOrStr.equalsIgnoreCase("Item") || numOrStr.equals("2")) {
					Logics_Inventory.chooseItemOption();
					break;
				}
				else if (numOrStr.equalsIgnoreCase("Group or Category") || numOrStr.equals("3")) {
					Logics_Inventory.setGroupInventory();
					break;
				}
				else if (numOrStr.equalsIgnoreCase("Exit to Profile") || numOrStr.equals("4")) {
					Logics_Inventory.profileUser();
					break;
				}
				else if (numOrStr.equalsIgnoreCase("Exit the System") || numOrStr.equals("5")){
					System.out.println(tabLine + b_Texts + "Exited and Went Back..." + c_Reset);
					break;
				}
				else {
					System.out.println(tabSpace + minorCR48 + "Try Another: ");
					continue;
				}
			}
			catch(Exception e) {
				System.out.println("firstDecision SOMETHING WENT WRONG" + e.getMessage());
			}
			
			finally {
				System.out.println(newLines);
			}
		}
	}
    
    
    // Second Decision == Internal Inventory ==
    public void setSecondDecision(String secondChoice) {
    	this.secondChoice = secondChoice;
    }
    
    // ASKS THE USER TO INPUT A DECISION TO ACCESS
    public static void chooseInventoryOption(){
    	//METHODS
    	Logics_Inventory mths = new Logics_Inventory();
    	PrintWriter print = new PrintWriter(System.out);
    	
    	//VARIABLES
    	final String rep20 = " ".repeat(20);
    	final String inventoryFormat = " ".repeat(38);
    	final String spacerFormat = " ".repeat(3);
    	
    	try {
    		print.println("\n");
        	print.println("\t " + b_Texts + "—".repeat(172) + c_Reset);
			String inventoryListHeader = tabLine + inventoryFormat + """
	    			█████████╗█████╗  ███╗███╗   ███╗█████████╗█████╗  ███╗█████████╗ █████████╗ █████████╗ ███╗  ███╗  """ + " ".repeat(33) + "| \n" +
	    			tabLine + inventoryFormat + spacerFormat + """
	    			   ███╔══╝██████╗ ███║███║   ███║███╔═════╝██████╗ ███║   ███╔══╝███╔════███║███╔═══███╗███╚══███║                  """ + " ".repeat(33) + "| \n" +
	    			tabLine + inventoryFormat + spacerFormat + """
	    			   ███║   ███╔███╗███║ ███╗ ███╔╝███████╗  ███╔███╗███║   ███║   ███║    ███║█████████╔╝╚███████╔╝     """ + " ".repeat(33) + "| \n" +
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
        	print.flush();
        	
    		System.out.println(tabSpace + " " + "—".repeat(170));
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
	        Logics_Inventory.secondChoice = mths.scan.nextLine().trim();
    	}
    	
    	catch(Exception e){
    		System.out.println("\t | SOMETHING WENT WRONG IN INVENTORY OPTION: " + e.getMessage());
    	}
    	
    	finally {
    		System.out.println(newLines);
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
				
				else if (secondChoice.equalsIgnoreCase("Exit and Go Back") || secondChoice.equals("5")){
					System.out.println(tabLine + b_Texts + "Exited and Went Back..." + c_Reset);
					Logics_Inventory.firstDecisionDuplicate();
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
    @SuppressWarnings("finally")
	public static void getWrittenInventory() {
    	//METHODS
    	Logics_Inventory mths = new Logics_Inventory();
    	PrintWriter print = new PrintWriter(System.out);
    	
    	//VARIABLES
    	final String rep20 = " ".repeat(20);
    	final String inventoryFormat = " ".repeat(10);
    	final String spacerFormat = " ".repeat(3);
    	
    	while(true) {
	    	try {
    			FileReader fR = new FileReader(mths.fPath.toString());
    			BufferedReader br1 = new BufferedReader(fR);
    			String LINE;
    			
    			print.println("\n");
	        	print.println("\t " + b_Texts + "—".repeat(172) + c_Reset);
    			String inventoryListHeader = tabLine + inventoryFormat + """
		    			█████████╗█████╗  ███╗███╗   ███╗█████████╗█████╗  ███╗█████████╗ █████████╗ █████████╗ ███╗  ███╗       ███╗      █████████╗█████████╗███████████╗     """ + " ".repeat(12) + "| \n" +
		    			tabLine + inventoryFormat + spacerFormat + """
		    			   ███╔══╝██████╗ ███║███║   ███║███╔═════╝██████╗ ███║   ███╔══╝███╔════███║███╔═══███╗███╚══███║       ███║         ███╔══╝███╔═════╝    ███╔═══╝     """ + " ".repeat(12) + "| \n" +
		    			tabLine + inventoryFormat + spacerFormat + """
		    			   ███║   ███╔███╗███║ ███╗ ███╔╝███████╗  ███╔███╗███║   ███║   ███║    ███║█████████╔╝╚███████╔╝       ███║         ███║   █████████╗    ███║         """ + " ".repeat(16) + "| \n" +
		    			tabLine + inventoryFormat + spacerFormat + """    
		    			   ███║   ███║╚██████║ ███║ ███║ ███╔═══╝  ███║╚██████║   ███║   ███║    ███║███╔═══███╗   ███╔═╝        ███║         ███║   ╚═════███║    ███║         """ + " ".repeat(16) + "| \n" +
		    			tabLine + inventoryFormat + """
		    			█████████╗███║ ╚═████║  ██████╔╝ █████████╗███║ ╚═████║   ███║   ╚█████████╔╝███║   ███║   ███║          █████████╗█████████╗█████████║    ███║         """ + " ".repeat(16) + "| \n" +
		    			tabLine + inventoryFormat + """
		    			╚════════╝╚══╝   ╚═══╝  ╚═════╝  ╚════════╝╚══╝   ╚═══╝   ╚══╝    ╚════════╝ ╚══╝   ╚══╝   ╚══╝          ╚════════╝╚════════╝╚════════╝    ╚══╝         """ + " ".repeat(16) + "|" + """
		    			""";
    			print.println(inventoryListHeader);
	    		print.println(tabSpace + "—".repeat(172));
	        	print.println(tabSpace + "█".repeat(172));

    			print.println("\n");
    			print.println(tabSpace + " " + "—".repeat(170));
				print.println(tabSpace + centerRepeat + " ".repeat(4) + b_Texts + "INVENTORY LIST" + c_Reset); 
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
				
    			while((LINE = br1.readLine()) != null) {
    				String DATA [] = LINE.split(";");
    				
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
    			print.println(tabSpace + b_Texts + "—".repeat(172) + c_Reset);
    			print.flush();
    			br1.close();
    		}

	    	catch(IOException e) {
	    		System.out.println("\t | SOMETHING WENT WRONG: "+ e.getLocalizedMessage());
	    	}
    	
	    	finally {
				// Internal Decision to repeat or to choose other Action
				System.out.println(tabSpace);
				System.out.println("\n");
				print.println(tabSpace + b_Texts + "—".repeat(170));
	        	System.out.println(centerRepeat +  b_Texts + "============================================" + c_Reset);

		    	System.out.println(tabSpace + " ".repeat(72) + b_Texts + "CHOOSE AGAIN OR EXIT THE PROGRAM" + c_Reset);
	            System.out.println(tabSpace + minorCR43 + b_Texts + "" +  "—".repeat(86) + "" + c_Reset);

		    	System.out.print(subCR52 + " |  [" + b_Texts + "1" + c_Reset + "]" + b_Texts + " Show Inventory List" + c_Reset);
		        System.out.println(" ".repeat(15) + "|" + " ".repeat(11) + "[" + b_Texts + "2" + c_Reset + "]" + b_Texts + " Show Inventory Dashboard  |" + c_Reset);
		        System.out.println(tabSpace + minorCR43 + b_Texts + "" +  "—".repeat(86) + c_Reset);
		        System.out.print(subCR52 + " |  [" + b_Texts + "3" + c_Reset + "]" + b_Texts + " Add an Item" + c_Reset);
		        System.out.println(" ".repeat(23) + "|" + " ".repeat(11) + "[" + b_Texts + "4" + c_Reset + "]" + b_Texts + " Add a Group or Category   |" + c_Reset);
		        System.out.println(tabSpace + minorCR43 + b_Texts + "" +  "—".repeat(86) + "" + c_Reset);
		        System.out.println(" ".repeat(52) + " |" + " ".repeat(31) + "[" + b_Texts + "5" + c_Reset + "]" + b_Texts + " Exit and Go Back" + c_Reset + " ".repeat(31) + "|");
		        System.out.println(tabSpace + minorCR43 + b_Texts + "" +  "—".repeat(86) + "" + c_Reset);
		        System.out.print(subCR53 + b_Texts + " —> " + c_Reset);
				String numOrStr = mths.scan.nextLine().trim();
				
				System.out.println(newLines);
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
					Logics_Inventory.firstDecisionDuplicate();
					break;
				}
				else {
					System.out.println(tabSpace + minorCR48 + "Try Again, and: ");
					Logics_Inventory.chooseInventoryOption();
					break;
				}
	    	}
    	}
	}
    
    // ACCESS CHECK/SHOW The Inventory Dashboard
	@SuppressWarnings("finally")
	public static void getDashboardInventory() {
    	//METHODS
    	Logics_Inventory mths = new Logics_Inventory();
    	PrintWriter print = new PrintWriter(System.out);
				
    	//VARIABLES
		final String rep8 = " ".repeat(8);
		final String rep7 = " ".repeat(7);
    	final String rep40 = " ".repeat(40);
    	final String dashBFormat = " ".repeat(31);
    	
    	while(true)
			try {
				//METHODS
				BufferedReader br = new BufferedReader(new FileReader(mths.fPath.toString()));

		    	print.println("\n");
	        	print.println("\t " + b_Texts + "—".repeat(172) + c_Reset);
		    	final String dashboardHeader = tabLine + dashBFormat + """
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
	    		print.println(dashboardHeader);
	    		print.println(tabSpace + "—".repeat(172));
	        	print.println(tabSpace + "█".repeat(172));
	    		print.flush();
	    		
	    		// DASHBOARD CONTROL
	    		String lines = "";
	    		String valueHoldChanger = " ";
	    		
            	print.println("\n");
	    		print.println(tabSpace + " " + "—".repeat(170));
	    		print.println(tabSpace + centerRepeat + " ".repeat(4) + b_Texts + "ITEM QUANTITY" + c_Reset); 
	    		print.println(valueHoldChanger);
	    		print.println(tabSpace + " ".repeat(41) + b_Texts + "—".repeat(104) + c_Reset);	
	    		
	    		while((lines = br.readLine()) != null) {
	    			String[] val = lines.split(";");

	    			String newQuantity = val [4];
	            	int doubleVar =((int)(Double.parseDouble(newQuantity)));
	            	
	            	if (doubleVar <= 100) valueHoldChanger = tabSpace + centerRepeat + " ".repeat(8) + b_Texts + "0–100" + c_Reset;
            		if(doubleVar > 100) valueHoldChanger = tabSpace + centerRepeat + " ".repeat(8) + b_Texts + "0–1000" + c_Reset;
            		
		            print.print(tabSpace + " ".repeat(40 - (val[3].length())) + val[3] + b_verticalSpacesLine);	
		            	
		            	if (doubleVar <= 100) {
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
			    			
		            	}
		            	
	            	
		            	else if (doubleVar > 100) {
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
		            	}
	            	
		            
		            else if(doubleVar == 0) {
	    				System.out.println(tabSpace + rep40 + b_Texts + " The Text File is Currently Empty..." + c_Reset);
	    				break;
	    			}
		        print.println();   	
            	if (doubleVar <= 100) {
	    			print.println(tabSpace + rep40  + " " + b_Texts + "_".repeat(104) + c_Reset);
	    			print.println(tabSpace + rep40 + "  0" + rep8 + "10" +rep8 + "20" + rep8 + "30" + rep8 + "40" + rep8 + "50" + rep8  + "60" + rep8  + "70" + rep8  + "80" + rep8  + "90" + rep8  + "100");
				}
				
				else if (doubleVar > 100) {
	    			print.println(tabSpace + rep40  + " " + b_Texts + "_".repeat(104) + c_Reset);
					print.println(tabSpace + rep40 + "  0" + rep7 + "100" + rep7 + "200" + rep7 + "300" + rep7 + "400" + rep7 + "500" + rep7  + "600" + rep7  + "700" + rep7  + "800" + rep7  + "900" + rep7  + "1000");
				}
	            	
	    		}			
				print.flush();
	    		br.close();
	
	    	}
	    	
	    	catch(Exception e) {
	    		System.out.println(tabSpace + rep40 + b_Texts + "Something Went Wrong in DashboardInventory" + c_Reset + c_Red + e.getMessage() + c_Reset);
	    	}
			
	    	finally {
	    		// Internal Decision to repeat or to choose other Action
	    		System.out.println(tabSpace);
	    		System.out.println("\n");
	    		System.out.println(tabSpace + " " + "—".repeat(170));
	        	System.out.println(centerRepeat73 +  b_Texts + "============================================" + c_Reset);
		    	System.out.println(tabSpace + " ".repeat(70) + b_Texts + "CHOOSE AGAIN OR EXIT THE PROGRAM" + c_Reset);
	            System.out.println(tabSpace + minorCR43 + b_Texts + "" +  "—".repeat(86) + "" + c_Reset);

		    	System.out.print(subCR52 + " |  [" + b_Texts + "1" + c_Reset + "]" + b_Texts + " Show Inventory List" + c_Reset);
		        System.out.println(" ".repeat(15) + "|" + " ".repeat(11) + "[" + b_Texts + "2" + c_Reset + "]" + b_Texts + " Show Inventory Dashboard  |" + c_Reset);
		        System.out.println(tabSpace + minorCR43 + b_Texts + "" +  "—".repeat(86) + c_Reset);
		        System.out.print(subCR52 + " |  [" + b_Texts + "3" + c_Reset + "]" + b_Texts + " Add an Item" + c_Reset);
		        System.out.println(" ".repeat(23) + "|" + " ".repeat(11) + "[" + b_Texts + "4" + c_Reset + "]" + b_Texts + " Add a Group or Category   |" + c_Reset);
		        System.out.println(tabSpace + minorCR43 + b_Texts + "" +  "—".repeat(86) + "" + c_Reset);
		        System.out.println(" ".repeat(52) + " |" + " ".repeat(31) + "[" + b_Texts + "5" + c_Reset + "]" + b_Texts + " Exit and Go Back" + c_Reset + " ".repeat(31) + "|");
		        System.out.println(tabSpace + minorCR43 + b_Texts + "" +  "—".repeat(86) + "" + c_Reset);
		        System.out.print(subCR53 + b_Texts + " —> " + c_Reset);
				String numOrStr = mths.scan.nextLine().trim();
				
				System.out.println(newLines);
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
					System.out.println(tabLine + b_Texts + "Exited and Went Back..." + c_Reset);
					Logics_Inventory.firstDecisionDuplicate();
					break;
				}
				else {
					System.out.println(tabSpace + minorCR48 + "Try Another: ");
					Logics_Inventory.chooseInventoryOption();
					break;
				}
	    	}
		}
	
	// ACCES UPDATE/WRITES for Adding an Item 
	@SuppressWarnings("finally")
    public static void setItemInventory() {
    	//METHODS
    	Logics_Inventory mths = new Logics_Inventory();
    	PrintWriter print = new PrintWriter(System.out);
    	
    	// VARIABLES
    	
    	while(true) {
    		// METHODS
    		
    		// VARIABLE
    		final String rep8 = " ".repeat(8);
    		final String rep7 = " ".repeat(7);
        	final String rep40 = " ".repeat(40);
        	final String dashBFormat = " ".repeat(38);
        	
			try {
			mths.writer = new FileWriter(mths.fPath.toString(), true);
			
			print.println("\n");
        	print.println("\t " + b_Texts + "—".repeat(172) + c_Reset);
	    	final String dashboardHeader = tabLine + dashBFormat + " " + """
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
    		print.println(dashboardHeader);
    		print.println(tabSpace + "—".repeat(172));
        	print.println(tabSpace + "█".repeat(172));
    		print.flush();
		    		
			print.println("\n");
			print.println(tabSpace + " " + "—".repeat(170));
			print.println(tabSpace + centerRepeat + " ".repeat(4) + b_Texts + "ADDING AN ITEM" + c_Reset); 
			print.println(b_Texts + " ".repeat(49) + "—".repeat(92) + c_Reset);
			print.println( " ".repeat(49) + b_verticalLine + " ".repeat(32) + b_Texts + "ENTER THE DETAILS NEEDED" + c_Reset + " ".repeat(34) + b_verticalLine); 
			
			print.flush();
				while(true) {
					
					Date now = new Date();
	        		mths.writer.write(now + " ;");
					
					mths.writer.write(userName + ";");
					mths.writer.write(userPassword + ";");
					
					System.out.println(" ".repeat(49) + b_verticalLine + " ".repeat(90) + b_verticalLine);
					System.out.print(" ".repeat(50 - "Item:".length()) + tabLine + " ".repeat(10 - "Item:".length()) + "Item: ");
					String item = mths.scan.nextLine().trim();
					mths.writer.write(item + ";");
					
					System.out.print(" ".repeat(50 - "Quantity:".length()) + tabLine + " ".repeat(10 - "Quantity:".length()) + "Quantity: ");
					double quant =  mths.scan.nextDouble();
					mths.writer.write(quant + ";");
					
					System.out.print(" ".repeat(50 - "Price:".length()) + tabLine + " ".repeat(10 - "Price:".length()) + "Price: ");
					double price =  mths.scan.nextDouble();
					mths.writer.write(mths.currency.format(price) + ";");
					mths.writer.write(price*quant + ";");
					
					mths.scan.nextLine();
					System.out.print(" ".repeat(50 - "Group:".length()) + tabLine + " ".repeat(10 - "Group:".length()) + "Group: ");
					String group =  mths.scan.nextLine().trim();
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
	        	System.out.println(centerRepeat +  b_Texts + "============================================" + c_Reset);

		    	System.out.println(tabSpace + " ".repeat(72) + b_Texts + "CHOOSE AGAIN OR EXIT THE PROGRAM" + c_Reset);
	            System.out.println(tabSpace + minorCR43 + b_Texts + "" +  "—".repeat(86) + "" + c_Reset);
	            
	            System.out.print(subCR52 + " |  [" + b_Texts + "1" + c_Reset + "]" + b_Texts + " Show Inventory List" + c_Reset);
		        System.out.println(" ".repeat(15) + "|" + " ".repeat(11) + "[" + b_Texts + "2" + c_Reset + "]" + b_Texts + " Show Inventory Dashboard  |" + c_Reset);
		        System.out.println(tabSpace + minorCR43 + b_Texts + "" +  "—".repeat(86) + c_Reset);
		        System.out.print(subCR52 + " |  [" + b_Texts + "3" + c_Reset + "]" + b_Texts + " Add an Item" + c_Reset);
		        System.out.println(" ".repeat(23) + "|" + " ".repeat(11) + "[" + b_Texts + "4" + c_Reset + "]" + b_Texts + " Add a Group or Category   |" + c_Reset);
		        System.out.println(tabSpace + minorCR43 + b_Texts + "" +  "—".repeat(86) + "" + c_Reset);
		        System.out.println(" ".repeat(52) + " |" + " ".repeat(31) + "[" + b_Texts + "5" + c_Reset + "]" + b_Texts + " Exit and Go Back" + c_Reset + " ".repeat(31) + "|");
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
					continue;
				}
				else if (numOrStr.equalsIgnoreCase("Add a Group or Category") || numOrStr.equals("4")) {
					Logics_Inventory.setGroupInventory();
					break;
				}
				else if (numOrStr.equalsIgnoreCase("Exit and Go Back") || numOrStr.equals("5")){
					System.out.println(tabLine + b_Texts + "Exited and Went Back..." + c_Reset);
					Logics_Inventory.firstDecisionDuplicate();
					break;
				}
				else {
					System.out.println(tabSpace + minorCR48 + "Try Another: ");
					Logics_Inventory.chooseInventoryOption();
					break;
				}
			}
		}
    }
    
	
    // Third Decision == Internal Item == 
    public void setThirdDecision(String thirdChoice) {
        this.thirdChoice = thirdChoice;
	}
    
    // ASKS THE USER TO INPUT A DECISION TO ACCESS
    public static void chooseItemOption(){
    	Logics_Inventory mths = new Logics_Inventory();
    	try {
    		System.out.println(tabSpace + " " + "—".repeat(170));
    		System.out.println(tabSpace);
        	System.out.println(" ".repeat(76) +  b_Texts + "========================================" + c_Reset);

	    	System.out.println(tabSpace + " ".repeat(80) + b_Texts + "Access Item to".toUpperCase() + c_Reset);
            System.out.println(tabSpace + " ".repeat(46) + b_Texts +  "—".repeat(80) + "" + c_Reset);

	    	System.out.print(subCR55 + " |  [" + b_Texts + "1" + c_Reset + "]" + b_Texts + " Show an Item" + c_Reset);
	        System.out.println(" ".repeat(20) + "|" + " ".repeat(15) + "[" + b_Texts + "2" + c_Reset + "]" + b_Texts + " Add an Item" + " ".repeat(7) + "|" + c_Reset);
	        System.out.println(tabSpace + " ".repeat(46) + b_Texts + "" +  "—".repeat(80) + c_Reset);
	        System.out.print(subCR55 + " |  [" + b_Texts + "3" + c_Reset + "]" + b_Texts + " Remove an Item" + c_Reset);
	        System.out.println(" ".repeat(18) + "|" + " ".repeat(15) + "[" + b_Texts + "4" + c_Reset + "]" + b_Texts + " Exit and Go Back  |" + c_Reset);
	        System.out.println(tabSpace + " ".repeat(46) + b_Texts + "" +  "—".repeat(80) + "" + c_Reset);
	        System.out.print(subCR55 + b_Texts + " —> " + c_Reset);
	        Logics_Inventory.thirdChoice = mths.scan.nextLine().trim();
    	}
    	
    	catch(Exception e){
    		System.out.println("\t | SOMETHING WENT WRONG IN INVENTORY OPTION: " + e.getMessage());
    	}
    }

    // VALIDATION FOR THE NEXT DECISION THE SECOND DECISION WITHIN THE INVENTORY CASE
    public static void getThirdDecision() {
    	try {
    		while (true) {
				if (thirdChoice.equalsIgnoreCase("Show") || thirdChoice.equals("1")) {
					Logics_Inventory.getItemOrItems();   	
					break;
				}
				
				else if (thirdChoice.equalsIgnoreCase("Add") || thirdChoice.trim().equalsIgnoreCase("Add an Item") || thirdChoice.equals("2")) {
					Logics_Inventory.setItem();    	                                    
					/* METHOD FROM INVENTORY BUT WE CAN MAKE ANOTHER AND AS WE UPDATE THE 
					   FEATURES OR WE WANT TO HAVE SPECIFICATIONS ON THE MODULE OF ITEM ALONE
					*/
					break;
				}
				
				else if (thirdChoice.equalsIgnoreCase("Remove") || thirdChoice.trim().equalsIgnoreCase("Remove an Item") || thirdChoice.equals("3")) {
					Logics_Inventory.removeItem();
					break;
	    		}
				
				else if (thirdChoice.equalsIgnoreCase("Exit") || thirdChoice.trim().equalsIgnoreCase("Exit and Go Back") || thirdChoice.equals("4")) {
					Logics_Inventory.firstDecisionDuplicate();
					break;
				}
				
				else {
					System.out.println(tabSpace + minorCR48 + "Try Another: ");
					Logics_Inventory.chooseItemOption();
					break;
				}
			}
		} 
    	catch (Exception e) {
			e.printStackTrace();
		}
    	
    	finally {
    		System.out.println(newLines);
    	}
    }
    
    public static void getItemOrItems() {
    	
    	// METHODS // OBJECTS
    	Logics_Inventory mths = new Logics_Inventory();
    	/*CREATE PATTERN REGEX FOR VERIFICATION OF IF USER 
    	 * INPUTS INCORRECT INPUT IN THE TRY AGAIN DECISION ????
    	*/
    	PrintWriter print = new PrintWriter(System.out);
    	
    	//VARIABLES // UI
    	String decisionHolder;
    	final String rep20 = " ".repeat(20);
    	final String itemFormat = " ".repeat(33);
    	final String spacerFormat = " ".repeat(3);
    	
    	while(true) {
	    	try {
	    		System.out.println(tabSpace + " " + "—".repeat(170));
	    		System.out.println(tabSpace);
	        	System.out.println(" ".repeat(76) +  b_Texts + "========================================" + c_Reset);

		    	System.out.println(tabSpace + " ".repeat(74) + b_Texts + "Access the List or an Item".toUpperCase() + c_Reset);
	            System.out.println(tabSpace + " ".repeat(58) + b_Texts +  "—".repeat(58) + "" + c_Reset);

		    	System.out.print(" ".repeat(67) + " |  [" + b_Texts + "1" + c_Reset + "]" + b_Texts + " Show List" + c_Reset);
		        System.out.println(" ".repeat(11) + "|" + " ".repeat(9) + "[" + b_Texts + "2" + c_Reset + "]" + b_Texts + " Show an Item" + "  |" + c_Reset);
		        System.out.println(tabSpace + " ".repeat(58) + b_Texts +  "—".repeat(58) + c_Reset);
		        System.out.print(subCR55 + b_Texts + " —> " + c_Reset);
		        decisionHolder = mths.scan.nextLine();
	    		
	    		
	    		if(decisionHolder.equalsIgnoreCase("Show List") || decisionHolder.equalsIgnoreCase("List") || decisionHolder.equals("1")) {
	    			FileReader fR = new FileReader(mths.fPath.toString());
	    			BufferedReader br1 = new BufferedReader(fR);
	    			String LINE;
	    			
	    			print.println("\n");
		        	print.println("\t " + b_Texts + "—".repeat(172) + c_Reset);
	    			String inventoryListHeader = tabLine + itemFormat + """
			    			█████████╗███████████╗█████████╗████╗    ████╗       ███╗      █████████╗█████████╗███████████╗     """ + " ".repeat(35) + "| \n" +
			    			tabLine + itemFormat + spacerFormat + """
			    			   ███╔══╝    ███╔═══╝███╔═════╝█████╗  █████║       ███║         ███╔══╝███╔═════╝    ███╔═══╝     """ + " ".repeat(35) + "| \n" +
			    			tabLine + itemFormat + spacerFormat + """
			    			   ███║       ███║    ██████╗   ███╔█████╔███║       ███║         ███║   █████████╗    ███║         """ + " ".repeat(35) + "| \n" +
			    			tabLine + itemFormat + spacerFormat + """    
			    			   ███║       ███║    ███╔══╝   ███║╚███╔╝███║       ███║         ███║   ╚═════███║    ███║         """ + " ".repeat(36) + "| \n" +
			    			tabLine + itemFormat + """
			    			█████████╗    ███║    █████████╗███║ ╚══╝ ███║       █████████╗█████████╗█████████║    ███║         """ + " ".repeat(38) + "| \n" +
			    			tabLine + itemFormat + """
			    			╚════════╝    ╚══╝    ╚════════╝╚══╝      ╚══╝       ╚════════╝╚════════╝╚════════╝    ╚══╝         """ + " ".repeat(38) + "|" + """
			    			""";
	    			print.println(inventoryListHeader);
		    		print.println(tabSpace + "—".repeat(172));
		        	print.println(tabSpace + "█".repeat(172));

	    			print.println("\n");
	    			print.println(tabSpace + " " + "—".repeat(170));
					print.println(tabSpace + centerRepeat + " ".repeat(4) + b_Texts + "INVENTORY LIST" + c_Reset); 
					print.println(tabSpace + b_Texts + "—".repeat(173) + c_Reset);
					
					String [] label = {"Items", "Quantity", "Price", "Total Amount", "Group or Category", "Date of Expiration"};
					String blockForCategories = tabLine + rep20 + label[0] + " ".repeat(33 - (label[0].length())) + label[1] + " ".repeat(28 - (label[1].length()))
							+ label[2] + " ".repeat(20 - (label[2].length())) + label[3] + " ".repeat(36 - (label[3].length())) + label[4] + " ".repeat(28 - (label[3].length())) + "|";
					print.println(blockForCategories);
					print.flush();
					
	    			while((LINE = br1.readLine()) != null) {
	    				String DATA [] = LINE.split(";");
	    				
	    				// ITEM NAME
		    			for (int numHolder = 0; numHolder < 1; numHolder++) {
		    				System.out.print(tabSpace + b_verticalLine + " ".repeat(8) + " ".repeat(40 - DATA[1].length()) + DATA [3] + b_verticalSpacesLine);
		    			}
		    			// QUANTITY
		    			for (int numHolder = 0; numHolder < 1; numHolder++) {
		    				System.out.print(DATA [4] + " ".repeat(20 - DATA[4].length()) + b_verticalSpacesLine);
		    			}
		    			// PRICE
		    			for (int numHolder = 0; numHolder < 1; numHolder++) {
		    				System.out.print(DATA [5] + " ".repeat(20 - DATA[5].length()) + b_verticalSpacesLine);
		    			}
		    			// TOTAL AMOUNT
	    				for (int numHolder = 0; numHolder < 1; numHolder++) {
	    					System.out.print(DATA [6] + " ".repeat(20 - DATA[6].length()) + b_verticalSpacesLine);
	    				}
		    			// GROUP OR CATEGORY
		    			for (int numHolder = 0; numHolder < 1; numHolder++) {
		    				System.out.println(DATA [7] + " ".repeat(50 - DATA[7].length()) + b_verticalSpacesLine);
		    			}
	    			}
	    			print.println(tabSpace + b_Texts + "—".repeat(173) + c_Reset);
	    			print.flush();
	    		}
	    		
		    	else if (decisionHolder.equalsIgnoreCase("Show an Item") || decisionHolder.equalsIgnoreCase("Item") ||  decisionHolder.equals("2")) {
		    		String askItem = "Enter Name of Item: ";
		    		System.out.println(" ".repeat(60 - askItem.length()) + tabLine + " ".repeat(25 - askItem.length()) + askItem);
		    		String itemHolder = mths.scan.nextLine();
		    		
		    		System.out.println(itemHolder);
		    	}
		    	else {
		    		System.out.println(tabLine + "TRY AGAIN");
		    		continue;
		    	}
	    	}
	    	
	    	catch(Exception e){
	    		System.out.println(e.getMessage());
	    	}
	    	
	    	finally {
    			System.out.println(tabSpace + " " + "—".repeat(170));
	    		System.out.println(tabSpace);
	        	System.out.println(" ".repeat(76) +  b_Texts + "========================================" + c_Reset);

		    	System.out.println(tabSpace + " ".repeat(80) + b_Texts + "Access Item to".toUpperCase() + c_Reset);
	            System.out.println(tabSpace + " ".repeat(46) + b_Texts +  "—".repeat(80) + "" + c_Reset);

		    	System.out.print(subCR55 + " |  [" + b_Texts + "1" + c_Reset + "]" + b_Texts + " Show an Item, again" + c_Reset);
		        System.out.println(" ".repeat(20) + "|" + " ".repeat(15) + "[" + b_Texts + "2" + c_Reset + "]" + b_Texts + " Add an Item" + " ".repeat(7) + "|" + c_Reset);
		        System.out.println(tabSpace + " ".repeat(46) + b_Texts + "" +  "—".repeat(80) + c_Reset);
		        System.out.print(subCR55 + " |  [" + b_Texts + "3" + c_Reset + "]" + b_Texts + " Remove an Item" + c_Reset);
		        System.out.println(" ".repeat(18) + "|" + " ".repeat(15) + "[" + b_Texts + "4" + c_Reset + "]" + b_Texts + " Exit and Go Back  |" + c_Reset);
		        System.out.println(tabSpace + " ".repeat(46) + b_Texts + "" +  "—".repeat(80) + "" + c_Reset);
		        System.out.print(subCR55 + b_Texts + " —> " + c_Reset);
		        String numOrStr = mths.scan.nextLine().trim();
		        
		        System.out.println(newLines);
		        if (numOrStr.equalsIgnoreCase("Show an Item, Again") || numOrStr.equalsIgnoreCase("Show") || numOrStr.equals("1")) {
		        	Logics_Inventory.getItemOrItems();	
					break;
				}
				else if (numOrStr.equalsIgnoreCase("Add an Item") || numOrStr.equalsIgnoreCase("Add") || numOrStr.equals("2")) {
					Logics_Inventory.setItem(); 
					break;
				}
				else if (numOrStr.equalsIgnoreCase("Remove an Item") || numOrStr.equalsIgnoreCase("Remove") || numOrStr.equals("3")) {
					Logics_Inventory.removeItem();
					break;
				}
				else if (numOrStr.equalsIgnoreCase("Exit and Go Back") || numOrStr.equals("4")){
					Logics_Inventory.firstDecisionDuplicate();
					break;
				}
				else if (numOrStr.equalsIgnoreCase(" ") || numOrStr.equals(" ")){
					System.out.println("\t | Try Again:");
					// THINK OF BETTER METHOD AFTER ENTERING BLANK
					continue;
				}
	    	}
    	}
    }
    
    public static void setItem() {
    	//MEHODS
    	Logics_Inventory mths = new Logics_Inventory();
    	PrintWriter print = new PrintWriter(System.out);
    	
    	// VARIABLES
    	String perishable;
    	final int repFirst = 50;
    	final int repSecond = 20;
    	final int repThird = 60;
    	
    	while(true) {
			try {
			mths.writer = new FileWriter(mths.fPath.toString(), true);
			
			print.println("\n");
			print.println(tabSpace + " " + "—".repeat(170));
			print.println(tabSpace + centerRepeat + " ".repeat(3) + b_Texts + "ADDING AN ITEM" + c_Reset); 
			print.println(b_Texts + " ".repeat(49) + "—".repeat(92) + c_Reset);
			print.println( " ".repeat(49) + b_verticalLine + " ".repeat(32) + b_Texts + "ENTER THE DETAILS NEEDED" + c_Reset + " ".repeat(34) + b_verticalLine); 
			
			
			print.flush();
				while(true) {
					Date now = new Date();
					mths.writer.write(now + " ;");
					
					System.out.println(" ".repeat(49) + b_verticalLine + " ".repeat(90) + b_verticalLine);
					System.out.print(" ".repeat(repFirst - "Item:".length()) + tabLine + " ".repeat(repSecond - "Item:".length()) + "Item: ");
					String item = mths.scan.nextLine().trim();
					mths.writer.write(item + ";");
					
					System.out.print(" ".repeat(repFirst - "Quantity:".length()) + tabLine + " ".repeat(repSecond - "Quantity:".length()) + "Quantity: ");
					double quant =  mths.scan.nextDouble();
					mths.writer.write(quant + ";");
					
					System.out.print(" ".repeat(repThird - "Price per Unit:".length()) + tabLine + " ".repeat(repSecond - "Price per Unit:".length()) + "Price per Unit: ");
					double price =  mths.scan.nextDouble();
					mths.writer.write(mths.currency.format(price) + ";");
					mths.writer.write(price*quant + ";");
					
					mths.scan.nextLine();
					System.out.print(" ".repeat(repFirst - "Group:".length()) + tabLine + " ".repeat(repSecond - "Group:".length()) + "Group: ");
					String group =  mths.scan.nextLine().trim();
					mths.writer.write(group + ";");

					while(true) {
						System.out.println(b_Texts + " ".repeat(59) + "—".repeat(82) + c_Reset);
						System.out.println(" ".repeat(59) + tabLine + "Is the Item Perishable or Not?");
						System.out.print(" ".repeat(59) + tabLine + b_Texts + "[" + c_Reset + "1" + b_Texts + "]" + " Yes" + c_Reset);
						System.out.println(tabLine + b_Texts + "[" + c_Reset + "2" + b_Texts + "]" + " No" + c_Reset);
						System.out.println(" ".repeat(59) + tabLine + b_Texts + " —>" + c_Reset);
						String perishableHolderDecision = mths.scan.nextLine();
						
						if(perishableHolderDecision.equalsIgnoreCase("Yes") || perishableHolderDecision.equals("1")) {
							System.out.print(" ".repeat(repFirst - "Expiration:".length()) + tabLine + " ".repeat(repSecond - "Expiration:".length()) + "Expiration: ");
							perishable =  mths.scan.nextLine().trim();
							mths.writer.write(perishable + ";");
							break;
						}
						
						else if(perishableHolderDecision.equalsIgnoreCase("No") || perishableHolderDecision.equals("2")) {
							System.out.print(" ".repeat(repFirst - "Expiration:".length()) + tabLine + " ".repeat(repSecond - "Expiration:".length()) + "Expiration: None");
							perishable = "None";
							mths.writer.write(perishable + ";");
							break;
						}
						else {
							continue;
						}
					}
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
				System.out.println(tabSpace + " " + "—".repeat(170));
	    		System.out.println(tabSpace);
	        	System.out.println(" ".repeat(76) +  b_Texts + "========================================" + c_Reset);

		    	System.out.println(tabSpace + " ".repeat(80) + b_Texts + "Access Item to".toUpperCase() + c_Reset);
	            System.out.println(tabSpace + " ".repeat(46) + b_Texts +  "—".repeat(80) + "" + c_Reset);

		    	System.out.print(subCR55 + " |  [" + b_Texts + "1" + c_Reset + "]" + b_Texts + " Show an Item, again" + c_Reset);
		        System.out.println(" ".repeat(20) + "|" + " ".repeat(15) + "[" + b_Texts + "2" + c_Reset + "]" + b_Texts + " Add an Item" + " ".repeat(7) + "|" + c_Reset);
		        System.out.println(tabSpace + " ".repeat(46) + b_Texts + "" +  "—".repeat(80) + c_Reset);
		        System.out.print(subCR55 + " |  [" + b_Texts + "3" + c_Reset + "]" + b_Texts + " Remove an Item" + c_Reset);
		        System.out.println(" ".repeat(18) + "|" + " ".repeat(15) + "[" + b_Texts + "4" + c_Reset + "]" + b_Texts + " Exit and Go Back  |" + c_Reset);
		        System.out.println(tabSpace + " ".repeat(46) + b_Texts + "" +  "—".repeat(80) + "" + c_Reset);
		        System.out.print(subCR55 + b_Texts + " —> " + c_Reset);
		        String numOrStr = mths.scan.nextLine().trim();
		        
		        if (numOrStr.equalsIgnoreCase("Show an Item, again") || numOrStr.equalsIgnoreCase("Show") || numOrStr.equals("1")) {
		        	Logics_Inventory.getItemOrItems();   	
					break;
				}
				else if (numOrStr.equalsIgnoreCase("Add an Item") || numOrStr.equalsIgnoreCase("Add") || numOrStr.equals("2")) {
					Logics_Inventory.setItem(); 
					break;
				}
				else if (numOrStr.equalsIgnoreCase("Remove an Item") || numOrStr.equalsIgnoreCase("Remove") || numOrStr.equals("3")) {
					Logics_Inventory.removeItem();
					break;
				}
				else if (numOrStr.equalsIgnoreCase("Exit and Go Back") || numOrStr.equals("5")){
					Logics_Inventory.firstDecisionDuplicate();
					break;
				}
				else if (numOrStr.equalsIgnoreCase(" ") || numOrStr.equals(" ")){
					System.out.println("\t | Try Again:");
					// THINK OF BETTER METHOD AFTER ENTERING BLANK
					continue;
				}
			}
		}
    }
    
    public static void removeItem() {
    	
    	// METHODS // OBJECTS
    	Logics_Inventory mths = new Logics_Inventory();
    	
    	//VARIABLES // UI
    	
    	
    	while(true) {
	    	try {
	    		System.out.println(" REMOVE ITEMMMM");
	    	}
	    	
	    	catch(Exception e){
	    		System.out.println(tabLine + "SOMETHING WENT WRONG IN REMOVEITEM " + e.getMessage());
	    	}
	    	
	    	finally {
	            System.out.println(tabSpace + " " + "—".repeat(170));
	    		System.out.println(tabSpace);
	        	System.out.println(" ".repeat(76) +  b_Texts + "========================================" + c_Reset);

		    	System.out.println(tabSpace + " ".repeat(80) + b_Texts + "Access Item to".toUpperCase() + c_Reset);
	            System.out.println(tabSpace + " ".repeat(46) + b_Texts +  "—".repeat(80) + "" + c_Reset);

		    	System.out.print(subCR55 + " |  [" + b_Texts + "1" + c_Reset + "]" + b_Texts + " Show an Item" + c_Reset);
		        System.out.println(" ".repeat(20) + "|" + " ".repeat(15) + "[" + b_Texts + "2" + c_Reset + "]" + b_Texts + " Add an Item" + " ".repeat(7) + "|" + c_Reset);
		        System.out.println(tabSpace + " ".repeat(46) + b_Texts + "" +  "—".repeat(80) + c_Reset);
		        System.out.print(subCR55 + " |  [" + b_Texts + "3" + c_Reset + "]" + b_Texts + " Remove an Item, again" + c_Reset);
		        System.out.println(" ".repeat(18) + "|" + " ".repeat(15) + "[" + b_Texts + "4" + c_Reset + "]" + b_Texts + " Exit and Go Back  |" + c_Reset);
		        System.out.println(tabSpace + " ".repeat(46) + b_Texts + "" +  "—".repeat(80) + "" + c_Reset);
		        System.out.print(subCR55 + b_Texts + " —> " + c_Reset);
		        String numOrStr = mths.scan.nextLine().trim();
		        
		        if (numOrStr.equalsIgnoreCase("Show an Item, Again") || numOrStr.equalsIgnoreCase("Show") || numOrStr.equals("1")) {
		        	Logics_Inventory.getItemOrItems();   	
					break;
				}
				else if (numOrStr.equalsIgnoreCase("Add an Item") || numOrStr.equalsIgnoreCase("Add") || numOrStr.equals("2")) {
					Logics_Inventory.setItem(); 
					break;
				}
				else if (numOrStr.equalsIgnoreCase("Remove an Item") || numOrStr.equals("3")) {
					Logics_Inventory.removeItem();
					break;
				}
				else if (numOrStr.equalsIgnoreCase("Exit and Go Back") || numOrStr.equals("5")){
					Logics_Inventory.firstDecisionDuplicate();
					break;
				}
				else if (numOrStr.equalsIgnoreCase(" ") || numOrStr.equals(" ")){
					System.out.println("\t | Try Again:");
					continue;
				}
	    	}
    	}
    }
    
    
    /* FOR ITEM DUPLICATION, THE SYSTEM CHECKS IF THE USER REALLY WANTS TO ADD ANOTHER ITEM THAT SEEMS A SIMILAR WITH AN ENTERED ONE, 
     * THEN THE SYSTEM PROCEEDS TO GET THE OTHER DETAILS IF THE USER CONTINUES.
	*/
    
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
}