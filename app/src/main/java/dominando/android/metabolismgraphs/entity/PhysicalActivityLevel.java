package dominando.android.metabolismgraphs.entity;

public enum PhysicalActivityLevel {
    SEDENTARY("Little or none", 1.2D),
    SLIGHTLY_ACTIVE("1 to 2 days a week", 1.375D),
    MODERATELY_ACTIVE("3 to 5 days a week", 1.65D),
    HIGHLY_ACTIVE("6 to 7 days a week", 1.725D),
    EXTREMELY_ACTIVE("Once or more times a day", 1.9D);

    String description;
    Double multiplyingFactor;

    private PhysicalActivityLevel(String description, Double multiplyingFactor) {
        this.description = description;
        this.multiplyingFactor = multiplyingFactor;
    }

    public Double getMultiplyingFactor() {
        return multiplyingFactor;
    }

    @Override
    public String toString() {
        return description;
    }
}
