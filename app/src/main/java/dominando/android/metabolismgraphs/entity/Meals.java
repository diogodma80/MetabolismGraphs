package dominando.android.metabolismgraphs.entity;

public enum Meals {
    BREAKFAST(25D),
    MORNING_SNACK(5D),
    LUNCH(35D),
    AFTERNOON_SNACK(5D),
    DINNER(25D),
    EVENING_SNACK(5D);

    Double caloriesPercentage;

    private Meals(Double caloriesPercentage) {
        this.caloriesPercentage = caloriesPercentage;
    }

    public static Meals getValue(Integer ordinal) {
        if(ordinal == null || ordinal < 0 || ordinal >= Meals.values().length) {
            return null;
        }

        return Meals.values()[ordinal];
    }

    public Double getCaloriesPercentage() {
        return caloriesPercentage;
    }
}
