package finals_InventoryTrackingSys;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args){
    	
        String c_Red = "\u001B[31m";
        String c_Green = "\u001B[32m";
        String c_Reset = "\u001B[0m";

        try{
        	// Instance Variables
        	boolean ContinueOpt = true;
        	int loopChoice;
        	int countFormat = 115;
        	
        	// Method
        	PrintWriter print = new PrintWriter(System.out);
        	
        	//Logic_Inventory METHOD
        	Logics_Inventory opts = new Logics_Inventory();
        	
        	
        	print.println("\n");
        	print.println("\t " + "—".repeat(300));
        	String welcome = 
        			"\t | " + " ".repeat(countFormat) + """
        			██╗    ██╗███████╗██╗      ██████╗ ██████╗ ███╗   ███╗███████╗""" + " ".repeat(120) + "| \n"  
        			
        	        + "\t | " + " ".repeat(countFormat) + """
        			██║    ██║██╔════╝██║     ██╔════╝██╔═══██╗████╗ ████║██╔════╝""" + " ".repeat(120) + "| \n" 
        	        
        			+ "\t | " + " ".repeat(countFormat) + """
        	        ██║ █╗ ██║█████╗  ██║     ██║     ██║   ██║██╔████╔██║█████╗""" + " ".repeat(122) + "| \n" 
        			
        	        + "\t | " +  " ".repeat(countFormat) + """
        	        ██║███╗██║██╔══╝  ██║     ██║     ██║   ██║██║╚██╔╝██║██╔══╝""" + " ".repeat(122) + "| \n" 
        	        
        	        + "\t | " +  " ".repeat(countFormat) + """
        	        ╚███╔███╔╝███████╗███████╗╚██████╗╚██████╔╝██║ ╚═╝ ██║███████╗""" + " ".repeat(120) + "| \n" 
        	        
        	        + "\t | " +  " ".repeat(countFormat) + """
        	         ╚══╝╚══╝ ╚══════╝╚══════╝ ╚═════╝ ╚═════╝ ╚═╝     ╚═╝╚══════╝""" + " ".repeat(121) + "|" +
        	        """
        	        """;
        	print.println(welcome);
        	print.println("\t" + "—".repeat(300));
        	print.println("\t"+ "█".repeat(300));
        	
        	print.flush();
        	System.out.println("\t | ");
        	
        	while(ContinueOpt){
        		 
        		// SCANNER METHOD
	        	Scanner scan = new Scanner (System.in);
	        		        	
	            // WHAT TO ACCESS, ASKED TO THE USER
	            System.out.println("\t | Enter What to Access: ");
	            System.out.println("\t | [1] Inventory ");
	            System.out.println("\t | [2] Item ");
	            System.out.println("\t | [3] Group or Category ");
	            System.out.println("\t | [4] Exit the Program ");
	            System.out.print("\t | —> ");
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