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
        
     // Instance Variables
    	boolean ContinueOpt = true;
    	
        try{
        	Logics_Inventory.profileUser();
        	Logics_Inventory.firstDecision();
        	
        	while(ContinueOpt){
                switch(Logics_Inventory.returnCons()){
                    case INVENTORY:
                    	// SECOND DECISION
                    	Logics_Inventory.chooseInventoryOption();
                    	// FUNCTION TO BE CALLED DEPENDING ON THE PREVIOUS DECISION
                    	Logics_Inventory.getSecondDecisions();
                    	break;
                    	
                    case ITEM:
                    	// SECOND DECISION
                    	Logics_Inventory.chooseItemOption();
                    	// FUNCTION TO BE CALLED DEPENDING ON THE PREVIOUS DECISION
                    	Logics_Inventory.getThirdDecision();
                    	
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