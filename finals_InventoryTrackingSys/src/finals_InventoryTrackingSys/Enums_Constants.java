package finals_InventoryTrackingSys;

public enum Enums_Constants {
    INVENTORY(1, "inventory"), ITEM (2, "item"), CATEGORY(3,"category"), GROUP(3, "group"), MANAGEACCOUNT(4, "manageaccount") , EXIT(5, "exit"), DEFAULT(6, "default");

    private final int optionTypeInt;
    private final String optionTypeStr;

    Enums_Constants (int optionTypeInt, String optionTypeStr){
        this.optionTypeInt = optionTypeInt;
        this.optionTypeStr = optionTypeStr;
    }
    public int getOptType() {
		return this.optionTypeInt;
	}
    public String getOptTypeS() {
		return this.optionTypeStr;
	}
}