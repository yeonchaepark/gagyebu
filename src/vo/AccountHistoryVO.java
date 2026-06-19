package vo;

public class AccountHistoryVO {
    private final String type; // "수입" 또는 "지출"
    private final int amount;
    private final String description;

    public AccountHistoryVO(String type, int amount, String description) {
        this.type = type;
        this.amount = amount;
        this.description = description;
    }

    public String getType() { return type; }
    public int getAmount() { return amount; }
    public String getDescription() { return description; }
}
