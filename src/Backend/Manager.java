package Backend;

public class Manager {
    public static void main(String[] args) {
    }
}

class Station {
    private String name;
    private String code;

    Station(String name, String code) {
        this.name = name;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}

class Train {
    private String code;
    private int coachCount;
    private int maxCapacity;
    private int currCapacity;
    private int currStation;

    Train(String code, int coachCount) {
        this.code = code;
        this.coachCount = coachCount;
    }

    public String getCode() {
        return code;
    }

    public int getCoachCount() {
        return coachCount;
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
}

class Route {
    private String name;
    private String code;
    private int stationCount;
    private Station[] stationList;
    // private Train[] train;

    Route(String name, String code) {
        this.name = name;
        this.code = code;
    }

    Route(String name, String code, int stationCount, Station[] stationList) {
        this.name = name;
        this.code = code;
        this.stationCount = stationCount;
        this.stationList = stationList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getStationCount() {
        return stationCount;
    }

    public void setStationCount(int stationCount) {
        this.stationCount = stationCount;
    }

    public Station[] getStationList() {
        return stationList;
    }

    public void setStationList(Station[] stationList) {
        this.stationList = stationList;
    }
}