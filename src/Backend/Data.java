package Backend;

import java.util.Timer;
import java.util.TimerTask;

class Station {
    private String name;
    private String code;

    Station() {
    }

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


public class Data {
    private String[] StationList = {
            "Dahisar(East)",
            "Anand Nagar",
            "Kandarpada",
            "Mandapeshwar-I C Colony",
            "Eksar",
            "Borivali(West)",
            "Pahadi Eksar",
            "Kandivali(West)",
            "Dahanukarwadi",
            "Valnai",
            "Malad(West)",
            "Lower Malad",
            "Pahadi Goregaon",
            "Goregaon (West)",
            "Oshiwara",
            "Lower Oshiwara",
            "Andheri (West)"
    };

    private int StationCount = 17;
    private Station[] Stations;
    private int TrainCount = 0;
    private Train[] Trains = new Train[34];

    public Timer timer = new Timer();

    private int ctr = 5;

    class initialize extends TimerTask {
        public void run() {
            new generateTrains().run();
        }
    }

    class generateTrains extends TimerTask {
        public void run() {
            if (TrainCount < 34) {
                Trains[TrainCount] = new Train(
                        String.valueOf(TrainCount + 200),
                        6,
                        5,
                        0,
                        30,
                        0);
                TrainCount++;
                Trains[TrainCount] = new Train(
                        String.valueOf(TrainCount + 200),
                        6,
                        5,
                        StationCount - 1,
                        30,
                        1);
                TrainCount++;
            }
            
            new updateTrains().run();
            timer.schedule(new updateTime(), 5000);
        }
    }

    class updateTime extends TimerTask {
        public void run() {
            System.out.println("Update");
            for(int i = 0; i < TrainCount; i++){
                Trains[i].setTimeNextStation(Trains[i].getTimeNextStation() - 5);
            }
            ctr --;
            if(ctr != 0) {
                timer.schedule(new updateTime(), 5000);
            }
            else {
                timer.schedule(new updateTrains(), 5000);
                ctr = 5;
            }
        }
    }

    class updateTrains extends TimerTask {
        public void run() {
            int end;
            if(TrainCount > 34) {
                end = TrainCount;
            } else {
                end = TrainCount - 2;
            }

            for (int i = 0; i < end; i++) {
                if (Trains[i].getDirection() == 0) {
                    if (Trains[i].getCurrStation() == 15) {
                        Trains[i].setDirection(1);
                        Trains[i].setCurrStation(16);
                    } else {
                        Trains[i].setCurrStation(Trains[i].getCurrStation() + 1);
                    }
                } else {
                    if (Trains[i].getCurrStation() == 1) {
                        Trains[i].setDirection(0);
                        Trains[i].setCurrStation(0);
                    } else {
                        Trains[i].setCurrStation(Trains[i].getCurrStation() - 1);
                    }
                }
                Trains[i].setTimeNextStation(30);
            }
            timer.schedule(new generateTrains(), 30000);
        }
    }

    public Data() {
        Stations = new Station[StationCount];

        int ctr = 0;
        for (String name : StationList) {
            Stations[ctr] = new Station(name, String.valueOf(ctr + 200));
            ctr++;
        }

        new initialize().run();
    }

    public int getStationCount() {
        return StationCount;
    }

    public int getTrainCount() {
        return TrainCount;
    }

    public Station[] getStations() {
        return Stations;
    }

    public Train[] getTrains(){
        return Trains;
    }

    public String[] getStationList() {
        return StationList;
    }

    public void endTimer() {
        timer.cancel();
    }
} 