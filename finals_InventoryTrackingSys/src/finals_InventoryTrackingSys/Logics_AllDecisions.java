package finals_InventoryTrackingSys;

public class Logics_AllDecisions implements InventoryVars{
	
	
	// VARIABLES FOR COLOR/UI OUTPUT
	static String c_Red = "\u001B[31m";
    static String c_Green = "\u001B[32m";
    static String b_Texts = "\u001B[1m";
    static String u_Texts = "\u001B[4m";
    static String c_Reset = "\u001B[0m";
    
	
	final static String tab = "\t";
	final static String tabSpace = "\t ";
	final static String tabLine = "\t | ";
	
	final static String minorCR48 = " ".repeat(48);  
	
	final static String newLines = ("\n\n\n\n\n");
    
	
	// VARIABLE FOR DECISIONS
	String firstDecision;
	private static String secondChoice;
	private static String thirdChoice;
	private static String fourthChoice;
	private static String fifthChoice;
    
    // ENUM CLASS
    static Enums_Constants enumShow = null;
    

	// First Decision == First Level ==
	public void setFirstDecisions(String firstChoice) {
		this.firstDecision = firstChoice;
	        try {
		        // VALIDATION OF INVENTORY
		        if (firstChoice.equalsIgnoreCase("inventory")|| (firstChoice.equals("1"))) {
		        	//System.out.println("\t | inventory");
		        	enumShow = Logics_AllDecisions.fromString("inventory");
		        }
		        
		        // VALIDATION OF ITEM
		        else if (firstChoice.equalsIgnoreCase("item") || (firstChoice.equals("2"))) {
		        	if (firstChoice.equalsIgnoreCase("item"))
		        		enumShow = Logics_AllDecisions.fromString("item");
		        	
		        	else if (firstChoice.equalsIgnoreCase("2"))
		        		enumShow = Logics_AllDecisions.fromInt(2);
		        }
		        
		        // VALIDATION OF GROUP or CATEGORY
		        else if ((firstChoice.equalsIgnoreCase("group")) || (firstChoice.equalsIgnoreCase("category")) || (firstChoice.equalsIgnoreCase("group or category")) || (firstChoice.equals("3"))) {
		        	if (firstChoice.equalsIgnoreCase("group"))
		        		enumShow = Logics_AllDecisions.fromString("group");
		        	
		        	else if (firstChoice.equalsIgnoreCase("category"))
		        		enumShow = Logics_AllDecisions.fromString("category");
		        	
		        	else if (firstChoice.equalsIgnoreCase("group or category"))
		        		enumShow = Logics_AllDecisions.fromString("category");
		        	
		        	else if (firstChoice.equals("3"))
		        		enumShow = Logics_AllDecisions.fromInt(3);
		        }
		        
		        // VALIDATE THE INPUT FOR Manage Accounts
		        else if ((firstChoice.equalsIgnoreCase("manage")) || (firstChoice.equalsIgnoreCase("manage account")) || (firstChoice.equals("4"))) {
		        	if (firstChoice.equalsIgnoreCase("manage"))
		        		enumShow = Logics_AllDecisions.fromString("manageaccount");
		        	
		        	else if (firstChoice.equals("manageaccount"))
		        		enumShow = Logics_AllDecisions.fromString("manageaccount");
		        	
		        	else if (firstChoice.equals("4"))
		        		enumShow = Logics_AllDecisions.fromInt(4);
		        }
		        
		        // VALIDATE THE INPUT FOR Exit to Profile
		        else if ((firstChoice.equalsIgnoreCase("exit to profile")) || (firstChoice.equalsIgnoreCase("to profile")) || (firstChoice.equals("5"))) {
		        	if (firstChoice.equalsIgnoreCase("exit"))
		        		enumShow = Logics_AllDecisions.fromString("exit");
		        	
		        	else if (firstChoice.equals("5"))
		        		enumShow = Logics_AllDecisions.fromInt(5);
		        }
		        
		        // VALIDATE THE INPUT FOR Exit the System
		        else if ((firstChoice.equalsIgnoreCase("exit")) || (firstChoice.equalsIgnoreCase("exit the system")) || (firstChoice.equals("6"))) {
		        	if (firstChoice.equalsIgnoreCase("exit"))
		        		enumShow = Logics_AllDecisions.fromString("exit");
		        	
		        	else if (firstChoice.equals("exit the system"))
		        		enumShow = Logics_AllDecisions.fromString("exit the system");
		        	
		        	else if (firstChoice.equals("6"))
		        		enumShow = Logics_AllDecisions.fromInt(6);
		        }
		        
		        // VALIDATE THE INPUT FOR DEFAULT
		        else {
		        	if(firstChoice.equals(firstChoice))
		        		enumShow = Logics_AllDecisions.fromInt(6);
		        	else if(firstChoice.equals(firstChoice))
		        		enumShow = Logics_AllDecisions.fromString("default");
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
    
    // Second Decision == Internal Inventory ==
    public void setSecondDecision(String secondChoice) {
    	Logics_AllDecisions.secondChoice = secondChoice;
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
					Logics_Group.setNewGroup();
					break;
	    		}
				
				else if (secondChoice.equalsIgnoreCase("Exit and Go Back") || secondChoice.equals("5")){
					System.out.println(tabLine + b_Texts + "Exited and Went Back..." + c_Reset);
					Logics_AccessSystem.firstDecisionDuplicate();
					break;
				}
				
				else {
					System.out.println(tabSpace + minorCR48 + "Try Another: ");
					Logics_Inventory.chooseInventoryOptionDuplicate();
					break;
				}
			}
		} 
    	catch (Exception e) {
			e.printStackTrace();
		}
    }

    // Third Decision == Internal Item == 
    public void setThirdDecision(String thirdChoice) {
        Logics_AllDecisions.thirdChoice = thirdChoice;
	}

    // VALIDATION FOR THE NEXT DECISION THE THIRD DECISION WITHIN THE ITEM CASE
    public static void getThirdDecision() {
    	try {
    		while (true) {
				if (thirdChoice.equalsIgnoreCase("Show") || thirdChoice.equals("1")) {
					Logics_Item.getItemOrItems();   	
					break;
				}
				
				else if (thirdChoice.equalsIgnoreCase("Add") || thirdChoice.trim().equalsIgnoreCase("Add an Item") || thirdChoice.equals("2")) {
					Logics_Item.setItem();    	                                    
					/* METHOD FROM INVENTORY BUT WE CAN MAKE ANOTHER AND AS WE UPDATE THE 
					   FEATURES OR WE WANT TO HAVE SPECIFICATIONS ON THE MODULE OF ITEM ALONE
					*/
					break;
				}
				
				else if (thirdChoice.equalsIgnoreCase("Remove") || thirdChoice.trim().equalsIgnoreCase("Remove an Item") || thirdChoice.equals("3")) {
					Logics_Item.removeItem();
					break;
	    		}
				
				else if (thirdChoice.equalsIgnoreCase("Exit") || thirdChoice.trim().equalsIgnoreCase("Exit and Go Back") || thirdChoice.equals("4")) {
					Logics_AccessSystem.firstDecisionDuplicate();
					break;
				}
				
				else if (thirdChoice.isEmpty() || thirdChoice.equals("") || thirdChoice.equals(" ")) {
					System.out.println("\t | Try Again:");
					Logics_Item.chooseItemOptionDuplicate();
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

	// Fourth Decision == Internal Group == 
    public void setFourthDecision(String fourthChoice) {
    	Logics_AllDecisions.fourthChoice = fourthChoice;
	}
    
    //
    public static void getFourthDecision() {
    	try {
    		while (true) {
				if (fourthChoice.equalsIgnoreCase("Show") || fourthChoice.equalsIgnoreCase("Show Group") || fourthChoice.equalsIgnoreCase("Show Group List") || fourthChoice.equals("1")) {
					Logics_Group.getGroup();   	
					break;
				}
				
				else if (fourthChoice.equalsIgnoreCase("Add") || fourthChoice.trim().equalsIgnoreCase("Remove Group") || fourthChoice.trim().equalsIgnoreCase("Add a Group") || fourthChoice.equals("2")) {
					Logics_Group.setNewGroup();    	                                    
					/* METHOD FROM INVENTORY BUT WE CAN MAKE ANOTHER AND AS WE UPDATE THE 
					   FEATURES OR WE WANT TO HAVE SPECIFICATIONS ON THE MODULE OF ITEM ALONE
					*/
					break;
				}
				
				else if (fourthChoice.equalsIgnoreCase("Remove") || fourthChoice.trim().equalsIgnoreCase("Remove Group")  || fourthChoice.trim().equalsIgnoreCase("Remove a Group") || fourthChoice.equals("3")) {
					Logics_Group.removeGroup();
					break;
	    		}
				
				else if (fourthChoice.equalsIgnoreCase("Exit") || fourthChoice.trim().equalsIgnoreCase("Exit and Go Back") || fourthChoice.trim().equalsIgnoreCase("Go Back")  || fourthChoice.equals("4")) {
					Logics_AccessSystem.firstDecisionDuplicate();
					break;
				}
				
				else if (fourthChoice.isEmpty() || fourthChoice.equals("") || fourthChoice.equals(" ")) {
					System.out.println(tabSpace + minorCR48 + "Try Another: ");
					Logics_Group.chooseGroupOptionDuplicate();
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
    
	// Fourth Decision == Manage Account == 
    public void setFifthDecision(String fifthChoice) {
    	Logics_AllDecisions.fifthChoice = fifthChoice;
	}
    
    //
    public static void getFifthDecision() {
    	try {
    		while (true) {
				if (fifthChoice.equals("1")  || fifthChoice.equalsIgnoreCase("Change") || fifthChoice.equalsIgnoreCase("Forgot") || fifthChoice.equalsIgnoreCase("Password") || fifthChoice.equalsIgnoreCase("Forgot Password")) {
					Logics_ManageAccount.forgottenPassword();
					//>>verification >>checks accountForDuplication >> if passes>> write.acc
					break;
				}
				else if (fifthChoice.equals("2") || fifthChoice.equalsIgnoreCase("Create") || fifthChoice.equalsIgnoreCase("Create New Account") || fifthChoice.equalsIgnoreCase("New Account")) {
					Logics_ManageAccount.createAccount(); 
					// >>verification >>checks accountForDuplication(similar with accountChecker) >> if passes>> write.acc
					break;
				} 
				
				else if (fifthChoice.equals("3") || fifthChoice.equalsIgnoreCase("Delete") || fifthChoice.equalsIgnoreCase("Delete an Account")) {
					Logics_ManageAccount.removeAccount(); 
					//>>verification >> >> if passes>> write.acc
					break;
				}
				
				else if (fifthChoice.equals("4") || fifthChoice.equalsIgnoreCase("Use Other") || fifthChoice.equalsIgnoreCase("Use Other Account") || fifthChoice.equalsIgnoreCase("Retry")) {
					Logics_ManageAccount.retryEnteringAcccount(); 
					//>>verification >> >> if passes>> continue to system
					break;
				}
				
				else if (fifthChoice.equals("5") || fifthChoice.equalsIgnoreCase("Exit") || fifthChoice.equalsIgnoreCase("Exit and Go Back") || fifthChoice.equalsIgnoreCase("Go Back")) {
					Logics_AccessSystem.firstDecisionDuplicate();
					break;
				}
				
				else if (fifthChoice.isEmpty() || fifthChoice.equals("") || fifthChoice.equals(" ")) {
					System.out.println(tabSpace + minorCR48 + "Try Another: ");
					Logics_ManageAccount.chooseManageAccountOptionDuplicate();
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
	
}
