import org.jetbrains.annotations.NotNull;

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
        // separateSeniorJuniors separates officers, add to rotation and then sort them
        List<Officer>[] separated = separateSeniorJuniors();

        List<Officer> senior = separated[0];
        List<Officer> junior = separated[1];

        // assign duties to senior officers

        List<Officer> officers = assignSeniorDuties(senior);
        System.out.println(officers.size());
        assignWithoutPreferenceSenior(officers);

        // assign duties to junior officers

        officers = assignJuniorDuties(junior);
        System.out.println(officers.size());
        assignWithoutPreferenceSenior(officers);

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
        // add two seniors to Rotation before sorting them
        dutyRoster.addToRotation(seniors.remove(0));
        dutyRoster.addToRotation(seniors.remove(0));
        sortOfficerList(seniors);
        // add two juniors to Rotation before sorting
        dutyRoster.addToRotation(juniors.remove(0));
        dutyRoster.addToRotation(juniors.remove(0));
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

    private List<Officer> assignSeniorDuties(@NotNull List<Officer> senior){
        List<Officer> notAssigned = new ArrayList<>();

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
            for(int i=0; i<duties.length; i++) {
                Duty duty = duties[i];
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
                        case WeightStationSouth:
                            dutyShift.setWeightStationSouth(officer);
                            isSet = true;
                            break;
                        case WeightStationNorth:
                            dutyShift.setWeightStationNorth(officer);
                            isSet = true;
                            break;
                        case Shaheen:

                            System.out.println("Shaheen");
                            dutyShift.setShaheen(officer, shift);
                            isSet = true;
                            break;
                    }
                }catch (DutyFullException e){
                    //System.out.println("Just to check if it is raising");
                    if(i+1 == duties.length && !isSet){
                        // this officer's preferences are already filled
                        notAssigned.add(officer);
                    }
                }

                if (isSet){
                    dutyRoster.addToAssigned(officer, officer.getShiftPreference(), duties[i]);
                    break;
                }
            }

        }
        return notAssigned;
    }

    private List<Officer> assignJuniorDuties(@NotNull List<Officer> junior){
        List<Officer> notAssigned = new ArrayList<>();
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
            for (int i=0; i<duties.length; i++) {
                Duty duty = duties[i];
                boolean isSet = false;
                try{
                    switch (duty){
                        case Moherer:
                            dutyShift.setMoherer(officer);
                            isSet = true;
                            break;
                        case Security:
                            dutyShift.setSecurity(officer);
                            isSet = true;
                            break;
                        case WirelessOperator:
                            dutyShift.setWirelessOperator(officer);
                            isSet = true;
                            break;

                    }
                }catch (Exception e){
                    //System.out.println("Junior duty me exception");
                    if(i+1 == duties.length && !isSet){
                        // this officer's preferences are already filled
                        notAssigned.add(officer);
                    }
                }

                if (isSet){
                    dutyRoster.addToAssigned(officer, officer.getShiftPreference(), duties[i]);
                    break;
                }

            }
        }
        return notAssigned;
    }

    private void assignWithoutPreferenceSenior(List<Officer> officers){
        // we call this method for those whose preferences are given to others on the basis of their priority

        for (Officer officer:
             officers) {
            boolean isSet = false;
            for (Shifts shift:
                    new Shifts[]{Shifts.Morning, Shifts.Evening, Shifts.Night}){
                switch (shift){
                    case Morning:
                        isSet = assignDuty(officer, dutyRoster.getMorningShift(), officer.getType(), shift);
                        break;
                    case Evening:
                        isSet = assignDuty(officer, dutyRoster.getEveningShift(), officer.getType(), shift);
                        break;
                    case Night:
                        isSet = assignDuty(officer, dutyRoster.getNightShift(), officer.getType(), shift);
                        break;
                }
                if(isSet){
                    break;
                }
            }
        }
    }
    private boolean assignDuty(Officer officer, DutyShift dutyShift, OfficerType officerType, Shifts shift){
        if(officerType == OfficerType.Senior){
            for(int i=0; i<7; i++){

                Duty duty = Duty.values()[i];
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
                        case WeightStationSouth:
                            dutyShift.setWeightStationSouth(officer);
                            isSet = true;
                            break;
                        case WeightStationNorth:
                            dutyShift.setWeightStationNorth(officer);
                            isSet = true;
                            break;
                        case Shaheen:
                            dutyShift.setShaheen(officer, shift);
                            isSet = true;
                            break;
                    }
                }catch (DutyFullException e){
                    //System.out.println("UFFFFFFFFFFF "+officer);
                }

                if (isSet){
                    dutyRoster.addToAssigned(officer, shift, duty);
                    System.out.println("Assigned my self"+ shift+ duty);
                    return true;
                }
            }
        }


        if(officerType == OfficerType.Junior){
            for(int i=8; i<10; i++){

                Duty duty = Duty.values()[i];
                boolean isSet = false;
                try{
                    switch (duty){
                        case Moherer:
                            dutyShift.setMoherer(officer);
                            isSet = true;
                            break;
                        case Security:
                            dutyShift.setSecurity(officer);
                            isSet = true;
                            break;
                        case WirelessOperator:
                            dutyShift.setWirelessOperator(officer);
                            isSet = true;
                            break;

                    }
                }catch (DutyFullException e){
                    //System.out.println("UFFFFFFFFFFF "+officer);
                }

                if (isSet){
                    dutyRoster.addToAssigned(officer, shift, duty);
                    System.out.println("Assigned my self"+ shift+ duty);
                    return true;
                }
            }
        }

        return false;
    }
}
