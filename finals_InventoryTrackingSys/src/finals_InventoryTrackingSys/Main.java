package finals_InventoryTrackingSys;

public class Main {
    public static void main(String[] args){    
     // Instance Variables
    	boolean ContinueOpt = true;
    	
        try{
        	Logics_ProfileUser.profileUser();
        	
        	if(Logics_ManageAccount.getContinueAccessSystem()) {
        		Logics_AccessSystem.firstDecision();

	        	while(ContinueOpt){
	                switch(Logics_AllDecisions.returnCons()){
	                    case INVENTORY:
	                    	// SECOND DECISION
	                    	Logics_Inventory.chooseInventoryOption();
	                    	// FUNCTION TO BE CALLED DEPENDING ON THE PREVIOUS DECISION
	                    	Logics_AllDecisions.getSecondDecisions();
	                    	break;
	                    	
	                    case ITEM:
	                    	// SECOND DECISION
	                    	Logics_Item.chooseItemOption();
	                    	// FUNCTION TO BE CALLED DEPENDING ON THE PREVIOUS DECISION
	                    	Logics_AllDecisions.getThirdDecision();
	                    	
	                    	break;
	                    	
	                    case GROUP, CATEGORY:
	                    	Logics_Group.chooseGroupOption();
	                    	Logics_AllDecisions.getFourthDecision();
	                		break;
	            		
	                    case MANAGEACCOUNT:
	                    	Logics_ManageAccount.chooseManageAccountOption();
	                    	Logics_AllDecisions.getFifthDecision();
	                    	break;
	                    	
	                    case EXIT:
	                    	Logics_ProfileUser.profileUserDuplicate();
	                    	Logics_AccessSystem.firstDecisionDuplicate();
	                    	break;
	            			
	                    case DEFAULT:
	                    	Logics_AccessSystem.firstDecisionDuplicate();
	                    	// MAKE A METHOD PROMPT THAT ASKS THE USER TO CONFIRM EXITING AND ENDING THE PROGRAM
	                    	break;
	            			
	                    default:
	            			System.out.println("\t | INVALID INPUT");
	            			continue;
	                }
	                
	                if (Logics_AllDecisions.returnCons().toString().equalsIgnoreCase("exit")) {
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