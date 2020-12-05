import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args){
        List<Officer> officers = new ArrayList<>();
        for(int i=0; i<35; i++){
            Shifts shiftPreference = Shifts.values()[new Random().nextInt(3)];
            OfficerType officerType = OfficerType.Senior;
            // generate random number between low and high
            int low = 0;
            int high = 6;
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
        for(int i=0; i<12; i++){
            Shifts shiftPreference = Shifts.values()[new Random().nextInt(3)];
            OfficerType officerType = OfficerType.Junior;
            // generate random number between low and high
            int low = 7;
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

        RosterCreator rosterCreator = new RosterCreator(officers);
        DutyRoster dutyRoster = rosterCreator.generateRoster();
        System.out.println(dutyRoster);
        System.out.println("On Rotation" + dutyRoster.getOnRotation());
        System.out.println(dutyRoster.getAssigned().size());

    }
}
