package finals_InventoryTrackingSys;


import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.NumberFormat;
import java.util.*;
import static java.nio.file.AccessMode.*;

public class Logics_Inventory implements InventoryVars{
	
	private static final File filePath = new File ("C:\\Users\\Jerry Aaron\\git\\Inventory-Tracking-System\\finals_InventoryTrackingSys\\src\\InventoryData");
	
	// VARIABLES FOR COLOR OUTPUT
	static String c_Red = "\u001B[31m";
    static String c_Green = "\u001B[32m";
    static String c_Reset = "\u001B[0m";
	
	// VARIABLE INSTANCES
	String firstChoice;
	static String secondChoice;
    static String thirdChoice;
    
    // ENUM CLASS INSTANCE
    static Enums_Constants enumShow = null;
    
    // METHODS
	Scanner scan = new Scanner(System.in);
	
	// FILE DECLARATIONS
	Path fPath = Paths.get(filePath.getAbsolutePath());
	FileWriter writer;
	FileReader fReader;
	
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
	        
	        // VALIDATE THE INPUT FOR EXIT DECISION
	        else if ((this.firstChoice.equalsIgnoreCase("exit")) || (this.firstChoice.equals("4"))) {
	        	if (this.firstChoice.equalsIgnoreCase("exit"))
	        		enumShow = Logics_Inventory.fromString("exit");
	        	
	        	else if (this.firstChoice.equals("4"))
	        		enumShow = Logics_Inventory.fromInt(4);
	        }
	        
	        // VALIDATE THE INPUT FOR DEFAULT
	        else {
	        	if(this.firstChoice.equals(firstChoice))
	        		enumShow = Logics_Inventory.fromInt(5);
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
    
    
    
    // Second Decision == Internal Inventory ==
    public void setSecondDecision(String secondChoice) {
    	this.secondChoice = secondChoice;
    }
    
    // VALIDATION OF THE SECOND DECISION WITHIN THE INVENTORY CASE
    public static void getSecondDecisions() {
    	try {
    		while (true) {
				if (secondChoice.equalsIgnoreCase("SHOW") || secondChoice.equals("1")) {
					Logics_Inventory.getWrittenInventory();    	
					break;
				}
				
				else if (secondChoice.equalsIgnoreCase("UPDATE") || secondChoice.equals("2")) {
					Logics_Inventory.setWriteInventory();
					break;
	    		}
				else {
					System.out.println("\t | Try Another: ");
					System.out.println("\t | ");
					break;
				}
			}
		} 
    	catch (Exception e) {
			e.printStackTrace();
		}
    }
    
	// ACCES UPDATE/WRITE 
    public static void setWriteInventory() {
    	Logics_Inventory mths = new Logics_Inventory();
    	
    	while(true) {
			try {
			mths.writer = new FileWriter(mths.fPath.toString(), true);
			
			// FORMATTING CURRENCY
			NumberFormat currency = NumberFormat.getCurrencyInstance();
			
				while(true) {
					Date now = new Date();
					mths.writer.write(now + " ;");
					
					System.out.println("\t | ");
					System.out.print("\t | Item: ");
					String item = mths.scan.nextLine();
					mths.writer.write(item + ";");
					
					System.out.print("\t | Quantity: ");
					double quant =  mths.scan.nextDouble();
					mths.writer.write(quant + ";");
					
					System.out.print("\t | Price: ");
					double price =  mths.scan.nextDouble();
					mths.writer.write(currency.format(price) + ";");
					
					mths.scan.nextLine();
					System.out.print("\t | Group: ");
					String group =  mths.scan.nextLine();
					mths.writer.write(group + ";");
					
					
					mths.writer.write("\n");
					mths.writer.flush();
					break;
				}
				mths.writer.close();
			}
			
			catch (Exception e) {
				System.out.println("\t | ");
				System.out.println("\t | SOMETHING WENT WRONG: " + e.getMessage());
				mths.scan.nextLine();
			}
			
			finally {
				System.out.println("\t | ");
				System.out.println("\t | ENTRY ENDED");
				System.out.println("\t | ");
				
				// Internal Decision to repeat or to choose other Action
				System.out.println("\t | CHOOSE NEXT DECISION: ");
				System.out.println("\t | [1] Show");
				System.out.println("\t | [2] Update Again");
				System.out.println("\t | [3] Exit and go back");
				System.out.print("\t | -> ");
				String num = mths.scan.nextLine();
				
				if (num.equalsIgnoreCase("update") || num.equals("2")) {
					continue;
				}
				else if (num.equalsIgnoreCase("show") || num.equals("1")) {
					Logics_Inventory.getWrittenInventory();
					break;
				}
				else if (num.equalsIgnoreCase("exit") || num.equals("3")) {
					//Main.main(null); Call dire
					break;
				}
			}
		}
    }
   
    // ACCESS CHECK/SHOW THE FILE
    public static void getWrittenInventory() {
    	Logics_Inventory mths = new Logics_Inventory();
    	
    	while(true) {
	    	try {
    			BufferedReader br = new BufferedReader(new FileReader(mths.fPath.toString()));
    			String LINE = "";
				Scanner scanLines = new Scanner (filePath); 	            
	            
	            	while ((LINE = br.readLine()) != null) {
		            	String[] val = LINE.split(";");
		            	String[] wB = LINE.split(" ");
		            	
		            	System.out.println("\t | ");
		            	System.out.println("\t | Item: " + c_Green + val[1] + c_Reset);
		            	System.out.println("\t | Quantity: " + c_Green + val [2] + c_Reset);
		            	System.out.println("\t | Price: " + c_Green + val [3] + c_Reset);
		            	System.out.println("\t | Group: " + c_Green + val [4] + c_Reset);
		            	System.out.println("\t | Time Log: " + c_Green + wB [3] + c_Reset);
		            	System.out.println("\t | Date Log: " + c_Green + wB [0] + " " + wB [1] + " " + wB [2] + ", " + wB [5] + c_Reset);
		    
						}
						br.close();
            		}

	    	catch(IOException e) {
	    		System.out.println("\t | SOMETHING WENT WRONG: "+ e.getMessage());
	    	}
    	
	    	finally {
	    		System.out.println("\t | ");
				System.out.println("\t | ENTRY ENDED");
				System.out.println("\t | ");
				// Internal Decision to repeat or to choose other Action
				System.out.println("\t | CHOOSE NEXT DECISION: ");
				System.out.println("\t | [1] Show Again");
				System.out.println("\t | [2] Update");
				System.out.println("\t | [3] Exit and go back");
				System.out.print("\t | -> ");
				String num = mths.scan.nextLine();
				
				if (num.equalsIgnoreCase("show") || num.equals("1")) {
					continue;
				}
				else if (num.equalsIgnoreCase("update") || num.equals("2")) {
					Logics_Inventory.setWriteInventory();
					break;
				}
				else if (num.equalsIgnoreCase("exit") || num.equals("3")) {
					//Main.main(null); Call dire
					break;
				}
	    	}
    	}
	}
	

    
    public static void chooseInventoryOption(){
    	Logics_Inventory mths = new Logics_Inventory();
    	try {
    		System.out.println("\t | ");
	    	System.out.println("\t | Choose Inventory Decision: ");
	    	System.out.println("\t | [1] SHOW ");
	        System.out.println("\t | [2] UPDATE ");
	        System.out.print("\t | —> ");
	        Logics_Inventory.secondChoice = mths.scan.nextLine();
    	}
    	
    	catch(Exception e){
    		System.out.println("\t | SOMETHING WENT WRONG IN INVENTORY OPTION: " + e.getMessage());
    	}
    }
    
    
    
    // Third Decision == Internal Item == 
    public void setThirdDecision(String thirdChoice) {
        this.thirdChoice = thirdChoice;
    }
    
    
    
    
}
