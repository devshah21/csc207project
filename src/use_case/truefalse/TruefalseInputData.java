package use_case.truefalse;

public class TruefalseInputData {
    private int amount;
    private String difficulty;
    private String type;
    private String category;

    // constructor
    public TruefalseInputData(int amount, String difficulty, String type, String category) {
        this.amount = amount;
        this.difficulty = difficulty;
        this.type = type;
        this.category = category;
    }

    // getters
    public int getAmount() { return amount; }

    public String getDifficulty() {
        return difficulty;
    }

    public String getType() {
        return type;
    }

    public String getCategory() {
        return category;
    }
}
