package Backend;

public class Train {
    private String code;
    private int coachCount;
    private int maxCapacity;
    private int currCapacity;
    private int currStation;
    private int timeNextStation;
    private int direction;

    Train(String code, int coachCount, int maxCapacity, int currStation, int timeNextStation, int direction) {
        this.code = code;
        this.coachCount = coachCount;
        this.maxCapacity = maxCapacity;
        this.currStation = currStation;
        this.timeNextStation = timeNextStation;
        this.direction = direction;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getCoachCount() {
        return coachCount;
    }

    public void setCoachCount(int coachCount) {
        this.coachCount = coachCount;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public int getCurrCapacity() {
        return currCapacity;
    }

    public void setCurrCapacity(int currCapacity) {
        this.currCapacity = currCapacity;
    }

    public int getCurrStation() {
        return currStation;
    }

    public void setCurrStation(int currStation) {
        this.currStation = currStation;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public int getTimeNextStation() {
        return timeNextStation;
    }

    public void setTimeNextStation(int timeNextStation) {
        this.timeNextStation = timeNextStation;
    }

}
