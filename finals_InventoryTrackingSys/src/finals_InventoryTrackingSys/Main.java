package finals_InventoryTrackingSys;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args){
    	
        String c_Red = "\u001B[31m";
        String c_Green = "\u001B[32m";
        String b_Texts = "\u001B[1m";
        String u_Texts = "\u001B[4m";
        String c_Reset = "\u001B[0m";
        
        try{
        	// Instance Variables
        	boolean ContinueOpt = true;
        	int loopChoice;
        	
        	
        	// Method
        	PrintWriter print = new PrintWriter(System.out);
        	
        	//Logic_Inventory METHOD
        	Logics_Inventory opts = new Logics_Inventory();
        	
        	// UI Format: 
        	int countFormat = 53;
        	print.println("\n");
        	print.println("\t " + b_Texts + "—".repeat(172) + c_Reset);
        	final String repetition57 = " ".repeat(54);
        	final String repetition59 = " ".repeat(56);
        	final String centerRepeat = " ".repeat(75);
        	final String subCenterRepeat = " ".repeat(55);

        	final String tab = "\t";
        	final String tabSpace = "\t ";
        	final String tabLine = "\t | ";
        	String welcome = 
        			"\t | " + " ".repeat(countFormat) + """
        			██╗    ██╗███████╗██╗      ██████╗ ██████╗ ███╗   ███╗███████╗""" + repetition57 + "| \n"  
        			
        	        + "\t | " + " ".repeat(countFormat) + """
        			██║    ██║██╔════╝██║     ██╔════╝██╔═══██╗████╗ ████║██╔════╝""" + repetition57 + "| \n" 
        	        
        			+ "\t | " + " ".repeat(countFormat) + """
        	        ██║ █╗ ██║█████╗  ██║     ██║     ██║   ██║██╔████╔██║█████╗""" + repetition59 + "| \n" 
        			
        	        + "\t | " +  " ".repeat(countFormat) + """
        	        ██║███╗██║██╔══╝  ██║     ██║     ██║   ██║██║╚██╔╝██║██╔══╝""" + repetition59 + "| \n" 
        	        
        	        + "\t | " +  " ".repeat(countFormat) + """
        	        ╚███╔███╔╝███████╗███████╗╚██████╗╚██████╔╝██║ ╚═╝ ██║███████╗""" + repetition57 + "| \n" 
        	        
        	        + "\t | " +  " ".repeat(countFormat + 1) + """
        	         ╚══╝╚══╝ ╚══════╝╚══════╝ ╚═════╝ ╚═════╝ ╚═╝     ╚═╝╚══════╝""" + repetition57 + "|" +
        	        """
        	        """;
        	
        		/*
        		 String inventoryHeader =
        		 "\t | + """ 
        		 """;
        		 */
        	
        	
        	print.println(welcome);
        	print.println("\t " + "—".repeat(172));
        	print.println("\t " + "█".repeat(172));
        	
        	print.flush();
        	
        	while(ContinueOpt){
        		 
        		// SCANNER METHOD
	        	Scanner scan = new Scanner (System.in);
	        		        	
	            // WHAT TO ACCESS, ASKED TO THE USER
	        	System.out.println("\n");
	        	System.out.println(tabSpace + " " + "_".repeat(169));
	        	System.out.println(tabSpace);
	        	System.out.println(centerRepeat +  b_Texts + "========================================" + c_Reset);
	            System.out.println(tabSpace + centerRepeat + "  " + b_Texts + "CHOOSE TO ACCESS" + "   " + c_Reset);
	            
	            String firstLineOption = (tabSpace + subCenterRepeat + "[" + b_Texts + "1" + c_Reset +  "] " + b_Texts + "Inventory " + c_Reset);
	            String secondtLineOption = (tabSpace + " ".repeat(25) + "[" + b_Texts + "2" + c_Reset +  "] " + b_Texts + "Item " + c_Reset);
	            String thirdtLineOption = (tabSpace + subCenterRepeat + "[" + b_Texts + "3" + c_Reset +  "] " + b_Texts + "Group or Category " + c_Reset);
	            String fourthtLineOption = (tabSpace + " ".repeat(17) + "[" + b_Texts + "4" + c_Reset +  "] " + b_Texts + "Exit the Program " + c_Reset);
	            String fifthLineScan = (tabSpace + subCenterRepeat + b_Texts +  "—> " + c_Reset);
	            
	            print.print(firstLineOption);
	            print.println(secondtLineOption);
	            print.print(thirdtLineOption);	            
	            print.println(fourthtLineOption);
	            print.print(fifthLineScan);
	            print.flush();
	            
	            String switch_Control = scan.nextLine();
	            opts.setFirstDecisions(switch_Control);
	            
                switch(Logics_Inventory.returnCons()){
                    case INVENTORY:
                    	// SECOND DECISION
                    	Logics_Inventory.chooseInventoryOption();
                    	// FUNCTION TO BE CALLED DEPENDING ON THE PREVIOUS DECISION
                    	Logics_Inventory.getSecondDecisions();
                    	break;
                    	
                    case ITEM:
                    	System.out.println("\t | ACCESS AN ITEM");
                    	break;
                    	
                    case GROUP, CATEGORY:
                    	System.out.println("\t | ACCESS A GROUP OR CATEGORY");
                		break;
            		
                    case EXIT:
            			System.out.println("\t | EXITING SYSTEM");
            			break;
            			
                    default:
            			System.out.println("\t | INVALID INPUT");
            			break;
                }
                
                if (Logics_Inventory.returnCons().toString().equalsIgnoreCase("exit")) {
                	break;
                }
                else {
                	continue;
                }
            }      
    	}
        
        catch(Exception e){
            System.out.println("\t | SOMETHING WENT WRONG." + e.getMessage());
        }
        
        finally {
        	System.out.println("\t | SYSTEM EXITED ");
        }
 
        
        
        
    }
}