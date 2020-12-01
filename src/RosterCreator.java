import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

enum Shifts {
    Morning,
    Evening,
    Night,
}

enum OfficerType{
    Senior,
    Junior
}

enum Duty{
    Tiger1,
    Tiger2,
    Tiger3,
    Tiger4,
    WeightStationNorth,
    WeightStationSouth,
    Shaheen,
    WirelessOperator,
    Security,
    Moherer
}

public class RosterCreator {
    private DutyRoster dutyRoster = new DutyRoster();
    private List<Officer> officers;

    public RosterCreator(List<Officer> officers) {
        this.officers = officers;
    }

    public DutyRoster generateRoster(){
        List<Officer>[] separated = separateSeniorJuniors();

        List<Officer> senior = separated[0];
        List<Officer> junior = separated[1];

        // assign duties to junior officers

        while (senior.size()!=0){
            Officer officer = senior.remove(0);
            Shifts shift = officer.getShiftPreference();
            // this will store reference of shift from duty roster object's attribute
            DutyShift dutyShift;
            Duty[] duties = officer.getDutyPreference();

            // here we are selecting the shift of officer at current iteration
            switch (shift){
                case Morning:
                    dutyShift = dutyRoster.getMorningShift();
                    break;
                case Evening:
                    dutyShift = dutyRoster.getEveningShift();
                    break;
//                case Night:
//                    dutyShift = dutyRoster.getNightShift();
//                    break;
                default:
                    dutyShift = dutyRoster.getNightShift();
                    break;
            }
            // now we will select duty preference and then set it
            for (Duty duty:
                    duties) {
                boolean isSet = false;
                try{
                    switch (duty){
                        case Tiger1:
                            dutyShift.setTiger1(officer);
                            isSet = true;
                            break;
                        case Tiger2:
                            dutyShift.setTiger2(officer);
                            isSet = true;
                            break;
                        case Tiger3:
                            dutyShift.setTiger3(officer);
                            isSet = true;
                            break;
                        case Tiger4:
                            dutyShift.setTiger4(officer);
                            isSet = true;
                            break;
                    }
                }catch (DutyFullException e){
                    System.out.println("Just to check if it is raising");
                }
                if (isSet){
                    break;
                }
            }

            }

        // assign duties to junior officers

        while (junior.size()!=0){
            Officer officer = junior.remove(0);
            Shifts shift = officer.getShiftPreference();
            // this will store reference of shift from duty roster object's attribute
            DutyShift dutyShift;
            Duty[] duties = officer.getDutyPreference();
            // here we are selecting the shift of officer at current iteration
            switch (shift){
                case Morning:
                    dutyShift = dutyRoster.getMorningShift();
                    break;
                case Evening:
                    dutyShift = dutyRoster.getEveningShift();
                    break;
//                case Night:
//                    dutyShift = dutyRoster.getNightShift();
//                    break;
                default:
                    dutyShift = dutyRoster.getNightShift();
                    break;
            }
            // now we will select duty preference and then set it
            for (Duty duty:
                 duties) {
                boolean isSet = false;
                switch (duty){
                    case Moherer:
                        dutyShift.setMoherer(officer);
                        isSet = true;
                        break;
                    case Security:
                        dutyShift.setSecurity(officer);
                        isSet = true;
                        break;
                    case Shaheen:
                        dutyShift.setShaheen(officer);
                        isSet = true;
                        break;
                    case WirelessOperator:
                        dutyShift.setWirelessOperator(officer);
                        isSet = true;
                        break;
                    case WeightStationSouth:
                        dutyShift.setWeightStationSouth(officer);
                        isSet = true;
                        break;
                    case WeightStationNorth:
                        isSet = true;
                        dutyShift.setWeightStationNorth(officer);
                        break;
                }
                if (isSet){
                    break;
                }
            }
        }



        return dutyRoster;
    }

    private List<Officer>[] separateSeniorJuniors(){
        List<Officer> seniors = new ArrayList<>();
        List<Officer> juniors = new ArrayList<>();
        // separate senior and junior officers
        for (Officer officer:
                officers
             ) {
            if(officer.getType() == OfficerType.Senior){
                seniors.add(officer);
            }else if(officer.getType() == OfficerType.Junior){
                juniors.add(officer);
            }
        }
        sortOfficerList(seniors);
        sortOfficerList(juniors);
        List[] returning = {seniors,juniors};
        return returning;
    }

    private void sortOfficerList(List<Officer> list){
        int n = list.size();
        for (int i = 1; i < n; ++i) {
            Officer key = list.get(i);
            int j = i - 1;

            /* Move elements of arr[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
            while (j >= 0 && list.get(j).getQualityScore() < key.getQualityScore()) {
                list.set(j + 1,  list.get(j));
                j = j - 1;
            }
            list.set(j + 1, key);
        }
    }

}
