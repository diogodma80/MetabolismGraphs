package dominando.android.metabolismgraphs.entity;

import java.io.Serializable;

public class Graph implements Serializable {
    Double metabolicLevel;
    Double breakfast;
    Double morningSnack;
    Double lunch;
    Double afternoonSnack;
    Double dinner;
    Double eveningSnack;

    public Double getMetabolicLevel() {
        return metabolicLevel;
    }

    public void setMetabolicLevel(Double metabolicLevel) {
        this.metabolicLevel = metabolicLevel;
    }

    public Double getBreakfast() {
        return breakfast;
    }

    public void setBreakfast(Double breakfast) {
        this.breakfast = breakfast;
    }

    public Double getMorningSnack() {
        return morningSnack;
    }

    public void setMorningSnack(Double morningSnack) {
        this.morningSnack = morningSnack;
    }

    public Double getLunch() {
        return lunch;
    }

    public void setLunch(Double lunch) {
        this.lunch = lunch;
    }

    public Double getAfternoonSnack() {
        return afternoonSnack;
    }

    public void setAfternoonSnack(Double afternoonSnack) {
        this.afternoonSnack = afternoonSnack;
    }

    public Double getDinner() {
        return dinner;
    }

    public void setDinner(Double dinner) {
        this.dinner = dinner;
    }

    public Double getEveningSnack() {
        return eveningSnack;
    }

    public void setEveningSnack(Double eveningSnack) {
        this.eveningSnack = eveningSnack;
    }
}
