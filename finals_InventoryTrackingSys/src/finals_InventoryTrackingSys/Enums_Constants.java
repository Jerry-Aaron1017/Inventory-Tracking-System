package finals_InventoryTrackingSys;

public enum Enums_Constants {
    INVENTORY(1, "inventory"), ITEM (2, "item"), CATEGORY(3,"category"), GROUP(3, "group"), EXIT(4, "exit"), DEFAULT(5, " ");

    private final int optionType;
    private final String optionTypeS;

    Enums_Constants (int optionType, String optionTypeS){
        this.optionType = optionType;
        this.optionTypeS = optionTypeS;
    }
    public int getOptType() {
		return this.optionType;
	}
    public String getOptTypeS() {
		return this.optionTypeS;
	}
    
    

}
