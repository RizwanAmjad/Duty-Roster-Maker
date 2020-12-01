import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args){
        List<Officer> officers = new ArrayList<>();
        for(int i=0; i<42; i++){
            Shifts shiftPreference = Shifts.values()[new Random().nextInt(3)];
            OfficerType officerType = OfficerType.values()[new Random().nextInt(2)];
            // generate random number between low and high
            int low = 0;
            int high = 3;
            Duty[] duty = new Duty[3];
            duty[0] = Duty.values()[new Random().nextInt(high-low) + low];
            duty[1] =  Duty.values()[new Random().nextInt(high-low) + low];
            duty[2] =  Duty.values()[new Random().nextInt(high-low) + low];

            officers.add(new Officer(
                    String.valueOf(i),
                    "First Name"+i,
                    "Last Name"+i,
                    "Phone Number"+i,
                    officerType,
                    shiftPreference,
                    duty,
                    new Random().nextInt(100)
            ));
        }
        for(int i=0; i<14; i++){
            Shifts shiftPreference = Shifts.values()[new Random().nextInt(3)];
            OfficerType officerType = OfficerType.values()[new Random().nextInt(2)];
            // generate random number between low and high
            int low = 3;
            int high = 10;
            Duty[] duty = new Duty[3];
            duty[0] = Duty.values()[new Random().nextInt(high-low) + low];
            duty[1] =  Duty.values()[new Random().nextInt(high-low) + low];
            duty[2] =  Duty.values()[new Random().nextInt(high-low) + low];
            officers.add(new Officer(
                    String.valueOf(i),
                    "First Name"+i,
                    "Last Name"+i,
                    "Phone Number"+i,
                    officerType,
                    shiftPreference,
                    duty,
                    new Random().nextInt(100)
            ));
        }
        for (Officer officer:
                officers
             ) {
            System.out.println(officer);
        }
        System.out.println("OKAY");
//        DutyRoster roster = new DutyRoster();
//        roster.setMorningShift(new DutyShift());
//        roster.setEveningShift(new DutyShift());
//        roster.setNightShift(new DutyShift());
        RosterCreator rosterCreator = new RosterCreator(officers);
        System.out.println(rosterCreator.generateRoster());
    }
}
