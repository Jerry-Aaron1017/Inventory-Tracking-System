package finals_InventoryTrackingSys;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args){    
     // Instance Variables
    	boolean ContinueOpt = true;
    	
        try{
        	Logics_Inventory.profileUser();
        	if(Logics_Inventory.continueAccessSystem) {
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
	                    	Logics_Inventory.chooseGroupOption();
	                    	Logics_Inventory.getFourthDecision();
	                		break;
	            		
	                    case MANAGEACCOUNT:
	                    	Logics_Inventory.manageAccount();
	                    	Logics_Inventory.firstDecisionDuplicate();
	                    	break;
	                    	
	                    case EXIT:
	                    	Logics_Inventory.profileUser();
	                    	Logics_Inventory.firstDecision();
	                    	break;
	            			
	                    case DEFAULT:
	                    	System.out.println("\t | EXITING SYSTEM");
	            			break;
	            			
	                    default:
	            			System.out.println("\t | INVALID INPUT");
	            			break;
	                }
	                
	                if (Logics_Inventory.returnCons().toString().equalsIgnoreCase("exit")) {
	                	break;
	                }
	                //else if (Logics_Inventory.returnCons().toString().equalsIgnoreCase(""))
	                else {
	                	break;
	                }
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