package finals_InventoryTrackingSys;

import java.io.*;
import java.nio.file.*;
import java.text.NumberFormat;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Logics_Group {	
	// VARIABLES FOR COLOR/UI OUTPUT
	static String c_Red = "\u001B[31m";
    static String c_Green = "\u001B[32m";
    static String b_Texts = "\u001B[1m";
    static String c_Reset = "\u001B[0m";
    
    // VARS FOR UI FORMAT
	final static String centerRepeat = " ".repeat(75);
	final static String subCR53 = " ".repeat(53);
	final static String minorCR48 = " ".repeat(48);      // MINOR CENTER REPEAT
	final static String minorCR43 = " ".repeat(43);
	
	final static String newLines = ("\n\n\n\n\n");
	final static String tab = "\t";
	final static String tabSpace = "\t ";
	final static String tabLine = "\t │ ";
	final static String b_verticalLine = b_Texts + "│" + c_Reset;
	final static String b_verticalSpacesLine = b_Texts + " │ " + c_Reset;
        
    // METHODS
	private final Scanner scan = new Scanner(System.in);
	private final NumberFormat currency = NumberFormat.getCurrencyInstance();
	
	// FILE DECLARATIONS
	private final Path fPath = Path.of("src", "InventoryData");
	private final Path fPathGrp = Path.of("src", "InventoryGroups");
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
			print.println("\t " + b_Texts + "┌" + "─".repeat(170) + "┐" + c_Reset);
	    	final String group = tabLine + dashBFormat + " " + """
	    			 ████████╗█████████╗  █████████╗ ███╗   ███╗█████████╗  """ + " ".repeat(58) + "│ \n" +
	    			tabLine + dashBFormat + """
	    			███╔═════╝███╔═══███╗███╔════███╗███║   ███║███    ███╗ """ + " ".repeat(57) + "│ \n" +
	    			tabLine + dashBFormat + """
	    			███║ ████╗█████████╔╝███║    ███║███║   ███║█████████╔╝ """ + " ".repeat(57) + "│ \n" +
	    			tabLine + dashBFormat + """ 
	    			███║  ███║███╔═══███╗███║    ███║███║   ███║███╔═════╝  """ + " ".repeat(58) + "│ \n" +
	    			tabLine + dashBFormat + """
	    			╚████████║███║   ███║╚█████████╔╝ ████████╔╝███║        """ + " ".repeat(64) + "│ \n" +
	    			tabLine + dashBFormat + " " + """
	    			 ╚═══════╝╚══╝   ╚══╝ ╚════════╝  ╚═══════╝ ╚══╝        """ + " ".repeat(64) + "│" + """
	    			""";
    		print.println(group);
    		print.println(tabSpace + b_Texts + "└" + "─".repeat(170) + "┘" + c_Reset);
        	print.println(tabSpace + "█".repeat(172));
    		print.flush();
		    		
			print.println("\n");
			print.println(tabSpace + "—".repeat(172));
        	print.flush();
        	
    		System.out.println(tabSpace);
        	System.out.println(centerRepeat +  b_Texts + "========================================" + c_Reset);

	    	System.out.println(tabSpace + centerRepeat + " ".repeat(3) + b_Texts + "Access Group to".toUpperCase() + c_Reset);
            System.out.println(tabSpace + " ".repeat(56)  + b_Texts + "┌" + "─".repeat(28) + "┬" + "─".repeat(29) + "┐"  + "" + c_Reset);

	    	System.out.print(" ".repeat(65) + b_verticalLine + "  [" + c_Green + b_Texts + "1" + c_Reset + "]" + c_Green +  b_Texts + " Show Group List" + c_Reset);
	        System.out.println(" ".repeat(7) + b_verticalLine + " ".repeat(2) + "[" + c_Green + b_Texts + "2" + c_Reset + "]" + c_Green + b_Texts + " Add a Group  " + " ".repeat(10) + c_Reset + b_verticalLine );
	        System.out.println(tabSpace + " ".repeat(56)  + b_Texts + "" +  "├" + "─".repeat(28) + "┼" + "─".repeat(29) + "┤" + c_Reset);
	        
	        System.out.print(" ".repeat(65) + b_verticalLine + "  [" + c_Green + b_Texts + "3" + c_Reset + "]" + c_Green + b_Texts + " Remove a Group" + c_Reset);
	        System.out.println(" ".repeat(8) + b_verticalLine + " ".repeat(2) + "[" + c_Green + b_Texts + "4" + c_Reset + "]" + c_Green + b_Texts + " Exit and Go Back   " + " ".repeat(4) + c_Reset + b_verticalLine);
	        System.out.println(tabSpace + " ".repeat(56)  + b_Texts +  "└" + "─".repeat(28) + "┴" + "─".repeat(29) + "┘" + "" + c_Reset);
	        
	        System.out.print(" ".repeat(65) + b_Texts + " —> " + c_Reset);
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
    			print.println("\t " + b_Texts + "┌" + "─".repeat(170) + "┐" + c_Reset);
    	    	final String group = tabLine + dashBFormat + " " + """
    	    			 ████████╗█████████╗  █████████╗ ███╗   ███╗█████████╗  """ + " ".repeat(58) + "│ \n" +
    	    			tabLine + dashBFormat + """
    	    			███╔═════╝███╔═══███╗███╔════███╗███║   ███║███    ███╗ """ + " ".repeat(57) + "│ \n" +
    	    			tabLine + dashBFormat + """
    	    			███║ ████╗█████████╔╝███║    ███║███║   ███║█████████╔╝ """ + " ".repeat(57) + "│ \n" +
    	    			tabLine + dashBFormat + """ 
    	    			███║  ███║███╔═══███╗███║    ███║███║   ███║███╔═════╝  """ + " ".repeat(58) + "│ \n" +
    	    			tabLine + dashBFormat + """
    	    			╚████████║███║   ███║╚█████████╔╝ ████████╔╝███║        """ + " ".repeat(64) + "│ \n" +
    	    			tabLine + dashBFormat + " " + """
    	    			 ╚═══════╝╚══╝   ╚══╝ ╚════════╝  ╚═══════╝ ╚══╝        """ + " ".repeat(64) + "│" + """
    	    			""";
        		print.println(group);
        		print.println(tabSpace + "└" + "─".repeat(170) + "┘");
            	print.println(tabSpace + "█".repeat(172));
        		print.flush();
    		    		
    			print.println("\n");
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
	
    private static boolean boolContinueProcessgetGrp;
    
    public static void setBoolContinueProcessgetGrp(boolean boolContinueProcessgetGrp) {
    	Logics_Group.boolContinueProcessgetGrp = boolContinueProcessgetGrp;
    }
    
    public static boolean getBoolContinueProcessgetGrp() {
    	return boolContinueProcessgetGrp;
    }
    
    private static String gGrp;
	
	
    public static void getGroup() {
    	//METHODS
    	Logics_Group mths = new Logics_Group();
    	PrintWriter print = new PrintWriter(System.out);
    	
    	// VARIABLE
    	int numRepItem = 32;
    	final String dashBFormat = " ".repeat(numRepItem);
    	
    	while(true) {
    		try {
    			print.println("\n");
    			print.println("\t " + b_Texts + "┌" + "─".repeat(170) + "┐" + c_Reset);
    	    	final String groupList = tabLine + dashBFormat + " " + """
    	    			 ████████╗█████████╗  █████████╗ ███╗   ███╗█████████╗        ███╗      █████████╗█████████╗███████████╗ """ + " ".repeat(33) + "│ \n" +
    	    			tabLine + dashBFormat + """
    	    			███╔═════╝███╔═══███╗███╔════███╗███║   ███║███    ███╗       ███║         ███╔══╝███╔═════╝    ███╔═══╝ """ + " ".repeat(33) + "│ \n" +
    	    			tabLine + dashBFormat + """
    	    			███║ ████╗█████████╔╝███║    ███║███║   ███║█████████╔╝       ███║         ███║   █████████╗    ███║     """ + " ".repeat(37) + "│ \n" +
    	    			tabLine + dashBFormat + """ 
    	    			███║  ███║███╔═══███╗███║    ███║███║   ███║███╔═════╝        ███║         ███║   ╚═════███║    ███║     """ + " ".repeat(37) + "│ \n" +
    	    			tabLine + dashBFormat + """
    	    			╚████████║███║   ███║╚█████████╔╝ ████████╔╝███║              █████████╗█████████╗█████████║    ███║     """ + " ".repeat(37) + "│ \n" +
    	    			tabLine + dashBFormat + " " + """
    	    			 ╚═══════╝╚══╝   ╚══╝ ╚════════╝  ╚═══════╝ ╚══╝              ╚════════╝╚════════╝╚════════╝    ╚══╝     """ + " ".repeat(37) + "│" + """
    	    			""";
        		print.println(groupList);
        		print.println(tabSpace + "└" + "─".repeat(170) + "┘");
            	print.println(tabSpace + "█".repeat(172));
            	
            	print.println("\n");
    			print.println(tabSpace + "—".repeat(172));
        		print.flush();
        		
        		Set <String> dupli = new HashSet<>();
    			String groupPrintingHolder = "";
            	int numRepHolder = 0;
            	int numRep2Holder = 0;
            	// FOR PRINTING THE GROUPS
	            try {
					FileReader fR = new FileReader(mths.fPathGrp.toString());
					BufferedReader brAI = new BufferedReader(fR);
					String LINE;
					int numRep = 0;
					int numRep2 = 0;
			        int total = 0;
			        
			        print.println(b_Texts + " ".repeat(59) + "┌" + "─".repeat(34) + "┬" + "─".repeat(32) + "┐" + c_Reset);
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
		                    	System.out.print(" ".repeat(59) + b_verticalLine + "       " + c_Green + b_Texts + groupPrinting + " " + c_Reset);
		                    	
		                    }
		                    
		                    if (total % 2 == 0) {
		                    	System.out.print(b_verticalLine + "       " + c_Green + b_Texts + groupPrinting + c_Reset + " ".repeat(25 - (groupPrinting.length() + numRep)) + b_verticalLine);
		                    }
		                    
		                    if (brAI.ready()) 
		                    	System.out.print(" ".repeat(26 - (groupPrinting.length() + numRep2)));
		                    
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
	                    	print.println(b_Texts + " ".repeat(59) + "─".repeat(34) + "┴" + "─".repeat(32) + "┘" + c_Reset);
                    		print.flush();
	            		}
	            		
	            		else if (dupli.size() > 2) {
	                    	print.println(b_Texts + " ".repeat(59) + "└" + "─".repeat(34) + "┴" + "─".repeat(32) + "┘" + c_Reset);
                    		print.flush();
	            		}
	            	}
	            	
	            	if (dupli.size() % 2 != 0) {
	            		if (dupli.size() <= 3) {
	                    	System.out.print(" ".repeat(26 - (groupPrintingHolder.length() + numRep2Holder)) + b_verticalLine + "       " + c_Green + b_Texts + "GRP NAME " + c_Reset + " ".repeat(24 - ("GRP NAME".length() + numRepHolder)) + b_verticalLine);
	                    	System.out.println();
		            		print.println(b_Texts + " ".repeat(59) + "└" + "─".repeat(34) + "┴" + "─".repeat(32) + "┘" + c_Reset);
	                		print.flush();
	            		}
	            		
	            		else if (dupli.size() > 3) {
	                    	System.out.print(" ".repeat(26 - (groupPrintingHolder.length() + numRep2Holder)) + b_verticalLine + "       " + c_Green + b_Texts + "GRP NAME " + c_Reset + " ".repeat(24 - ("GRP NAME".length() + numRepHolder)) + b_verticalLine);
	                    	System.out.println();
		            		print.println(b_Texts + " ".repeat(59) + "└" + "─".repeat(34) + "┴" + "─".repeat(32) + "┘" + c_Reset);
	                		print.flush();
	            		}

	            	}
	            }
        		
				System.out.println(" ".repeat(76) +  b_Texts + "========================================" + c_Reset);
				System.out.println(tabSpace + " ".repeat(75) + b_Texts + "GET GROUP AND ITS ITEMS" + c_Reset);
	    		String askItem = "Enter Group Name";
	    		
		        System.out.println(b_Texts + " ".repeat(69) + "┌" + "─".repeat(24) + "┬" + "─".repeat(25) + "┐" + c_Reset);
		        System.out.println(" ".repeat(69) + b_verticalLine + " ".repeat(2) + c_Green + b_Texts + askItem + c_Reset + ";" + " ".repeat(5) + 
							  b_verticalLine + " ".repeat(3) + "or Enter '" + c_Green + "." + c_Reset + "' to Exit"+ " ".repeat(2) + b_verticalLine + c_Reset); 
		        System.out.println(b_Texts + " ".repeat(69) + "└" + "─".repeat(24) + "┴" + "─".repeat(25) + "┘"  + c_Reset);
	    		System.out.print(" ".repeat(69) + c_Green + b_Texts + " —> " + c_Reset);
	    		
	    		
	    		String groupHolder = mths.scan.nextLine();
	    		
	    		if (groupHolder != ".") {
	    			setBoolContinueProcessgetGrp(true);
	    			gGrp = groupHolder;
	    		}
	    		
	    		if(groupHolder.equalsIgnoreCase(".")) {
	    			setBoolContinueProcessgetGrp(false);
	    			break;
	    		}
    		}
    		
    		catch(Exception e) {
				e.printStackTrace();
    		}
    		
    		finally {
    			if (getBoolContinueProcessgetGrp()) {
    				try {
    		    		FileReader fR = new FileReader(mths.fPath.toString());
    					BufferedReader brIL2 = new BufferedReader(fR);
    					String LINE1;
    					
    		    		print.println("\n\n");
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
    							
    	    			while((LINE1 = brIL2.readLine()) != null) {
    	    				String DATA [] = LINE1.split(";");
    	    				String date [] = LINE1.split(Pattern.quote("\\"));
    	    				
    	    				if ((DATA [3].equals ("none") == false) && DATA [6].equalsIgnoreCase(gGrp)){
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
						System.out.println(tabSpace + b_Texts + "└" + "─".repeat(38) + "┴" + "─".repeat(22) + "┴" + "─".repeat(22) + "┴" + "─".repeat(22) + "┴" + "─".repeat(32) + "┴" + "─".repeat(29) + "┘"+ c_Reset);
    	    			brIL2.close();
    				}
    				
    		    	catch(Exception e){
    		    		System.out.println(tabLine + "SOMETHING WENT WRONG IN GroupList " + e.getMessage());
    		    		e.getStackTrace();
    		    	}
    			}
				System.out.println(newLines + newLines);
    			repeatingChooseAgainGroup();
    		}
    		break;
    	}
    }
    
	private static String group;
	boolean continueProcess;
	
	public void setContinueProcess(boolean setContinueProcess) {
		this.continueProcess = setContinueProcess;
	}
	
	public boolean getContinueProcess() {
		return continueProcess;
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
	    			╚══╝    ╚══╝╚═══════╝   ╚═══════╝           ╚═══════╝╚══╝   ╚══╝ ╚════════╝  ╚═══════╝ ╚══╝        """ + " ".repeat(39) + "│" + """
	    			""";
    		print.println(addItem);
    		print.println(tabSpace + "—".repeat(172));
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
				repeatingChooseAgainGroup();
			}
			break;
		}
    }
    
    private static boolean boolContinueProcessRG;
    public static void setBoolContinueProcessRG(boolean boolContinueProcessRG) {
    	Logics_Group.boolContinueProcessRG = boolContinueProcessRG;
    }
    
    public static boolean getBoolContinueProcessRG() {
    	return boolContinueProcessRG;
    }
    private static String rGroup;

    public static void removeGroup() {
    	//METHODS
    	Logics_Group mths = new Logics_Group();
    	PrintWriter print = new PrintWriter(System.out);
    	
    	// VARIABLES
    	final String dashBFormat = " ".repeat(23);
    	
    	while(true) {
    		try {    			
    			print.println("\n");
    			print.println("\t " + b_Texts + "┌" + "─".repeat(170) + "┐" + c_Reset);
    	    	final String removeGroup = tabLine + dashBFormat + """
    	    			█████████╗ █████████╗████╗    ████╗ █████████╗ ███╗   ███╗█████████╗        ████████╗█████████╗  █████████╗ ███╗   ███╗█████████╗  """ + " ".repeat(17) + "│ \n" +
    	    			tabLine + dashBFormat + """
    	    			███╔═══███╗███╔═════╝█████╗  █████║███╔════███╗███║   ███║███╔═════╝       ███╔═════╝███╔═══███╗███╔════███╗███║   ███║███    ███╗ """ + " ".repeat(16) + "│ \n" +
    	    			tabLine + dashBFormat + """
    	    			█████████╔╝███████╗  ███╔█████╔███║███║    ███║ ███╗ ███╔╝███████╗         ███║ ████╗█████████╔╝███║    ███║███║   ███║█████████╔╝ """ + " ".repeat(16) + "│ \n" +
    	    			tabLine + dashBFormat + """ 
    	    			███╔═══███╗███╔═══╝  ███║╚███╔╝███║███║    ███║ ███║ ███║ ███╔═══╝         ███║  ███║███╔═══███╗███║    ███║███║   ███║███╔═════╝  """ + " ".repeat(17) + "│ \n" +
    	    			tabLine + dashBFormat + """
    	    			███║   ███║█████████╗███║ ╚══╝ ███║╚█████████╔╝  ██████╔╝ █████████╗       ╚████████║███║   ███║╚█████████╔╝ ████████╔╝███║        """ + " ".repeat(23) + "│ \n" +
    	    			tabLine + dashBFormat + """
    	    			╚══╝   ╚══╝╚════════╝╚══╝      ╚══╝ ╚════════╝   ╚═════╝  ╚════════╝        ╚═══════╝╚══╝   ╚══╝ ╚════════╝  ╚═══════╝ ╚══╝        """ + " ".repeat(23) + "│" + """
    	    			""";
        		print.println(removeGroup);
        		print.println(tabSpace + "└" + "─".repeat(170) + "┘");
            	print.println(tabSpace + "█".repeat(172));
        		print.flush();
    		    		
				System.out.println();
				System.out.println(b_Texts + " ".repeat(62) + "┌" + "─".repeat(31) + "┬" + "─".repeat(30) + "┐" + c_Reset);
				System.out.println(" ".repeat(62) + b_Texts + "│" + c_Reset + " ".repeat(2) + "Enter Name Remove ('" + c_Green + "Name" + c_Reset +
								   "')" + ";" + " ".repeat(2) + b_Texts + "│" + c_Reset +
								   " ".repeat(7) + " or '" + c_Green + "." + c_Reset + "' to Exit " +  b_Texts + " ".repeat(7) + "│" + c_Reset);
				System.out.println(b_Texts + " ".repeat(62) + "└" + "─".repeat(31) + "┴" + "─".repeat(30) + "┘" + c_Reset);
				
		        System.out.print(" ".repeat(62) + c_Green + b_Texts + " —> " + c_Reset);						
		        String removeByNameAndID = mths.scan.nextLine().trim();
		        
		        if (removeByNameAndID != ".") {
		        	setBoolContinueProcessRG(true);
		        	rGroup = removeByNameAndID;
		        }
		        
		        if (removeByNameAndID.equals(".")) {
		        	setBoolContinueProcessRG(false);
		        	break;
		        }
	    	}
	    	
	    	catch(Exception e){
	    		System.out.println(tabLine + "SOMETHING WENT WRONG IN REMOVE ITEM " + e.getMessage());
	    		e.getStackTrace();
	    	}
	    	
	    	finally {
	    		if (getBoolContinueProcessRG()) {
	    			try {				        
						BufferedReader br1 = new BufferedReader(new FileReader(mths.fPathGrp.toString()));
						File oldFile = new File (mths.fPathGrp.toString());
						File newFile = new File ("temp.txt");
						
						FileWriter FW = new FileWriter("temp.txt", true);
						BufferedWriter BW = new BufferedWriter(FW);
						PrintWriter PW = new PrintWriter(BW);
						
				        String lineRead;
				        List <String> itemNames = new ArrayList<>(); 
				        
				        while((lineRead = br1.readLine()) != null) {
				        	String DATA [] = lineRead.split(";");
				        	
				        	if (!DATA[6].equalsIgnoreCase(rGroup)) {
				        			itemNames.add(lineRead);
				        	}
				        }
				        String joinedList = itemNames.stream().collect(Collectors.joining(System.lineSeparator()));
				        PW.write(joinedList);
				        PW.write("\n");
				        
				        PW.flush();
				        PW.close();
				        br1.close();
				        
				        oldFile.delete();
				        File dump = new File ("src/InventoryGroups");
				        newFile.renameTo(dump);
	    			}
	    	    	catch(Exception e){
	    	    		System.out.println(tabLine + "SOMETHING WENT WRONG IN REMOVE ITEM " + e.getMessage());
	    	    		e.getStackTrace();
	    	    	}
	    		}
	    		System.out.println(newLines + newLines);
	    		getGroup();
				System.out.println(newLines + newLines);
	    		repeatingChooseAgainGroup();
	    	}
		break;
    	}
    }
    
    public static void repeatingChooseAgainGroup() {
    	// METHODS
    	Logics_Group mths = new Logics_Group();
    	
    	while(true) {
    		try {
    			System.out.println(tabSpace + b_Texts + "—".repeat(172));
    			System.out.println(tabSpace);
            	System.out.println(centerRepeat +  b_Texts + "========================================" + c_Reset);

    	    	System.out.println(tabSpace + " ".repeat(72) + b_Texts + "CHOOSE AGAIN OR EXIT THE PROGRAM" + c_Reset);
                System.out.println(tabSpace + " ".repeat(56)  + b_Texts + "┌" + "─".repeat(28) + "┬" + "─".repeat(29) + "┐"  + "" + c_Reset);

    	    	System.out.print(" ".repeat(65) + b_verticalLine + "  [" + c_Green + b_Texts + "1" + c_Reset + "]" + c_Green +  b_Texts + " Show Group List" + c_Reset);
    	        System.out.println(" ".repeat(7) + b_verticalLine + " ".repeat(2) + "[" + c_Green + b_Texts + "2" + c_Reset + "]" + c_Green + b_Texts + " Add a Group  " + " ".repeat(10) + c_Reset + b_verticalLine );
    	        System.out.println(tabSpace + " ".repeat(56)  + b_Texts + "" +  "├" + "─".repeat(28) + "┼" + "─".repeat(29) + "┤" + c_Reset);
    	        
    	        System.out.print(" ".repeat(65) + b_verticalLine + "  [" + c_Green + b_Texts + "3" + c_Reset + "]" + c_Green + b_Texts + " Remove a Group" + c_Reset);
    	        System.out.println(" ".repeat(8) + b_verticalLine + " ".repeat(2) + "[" + c_Green + b_Texts + "4" + c_Reset + "]" + c_Green + b_Texts + " Exit and Go Back   " + " ".repeat(4) + c_Reset + b_verticalLine);
    	        System.out.println(tabSpace + " ".repeat(56)  + b_Texts +  "└" + "─".repeat(28) + "┴" + "─".repeat(29) + "┘" + "" + c_Reset);
    	        
    	        System.out.print(" ".repeat(65) + b_Texts + " —> " + c_Reset);
    	        
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