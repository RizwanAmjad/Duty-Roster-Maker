import java.util.Arrays;

class DutyFullException extends Exception{
    private String message;
    public DutyFullException(String message){
        this.message = message;
    }
    @Override
    public String getMessage() {
        return this.message;
    }
}
public class DutyShift {
    private Officer[] tiger1 = new Officer[2];
    private Officer[] tiger2 = new Officer[2];
    private Officer[] tiger3 = new Officer[2];
    private Officer[] tiger4 = new Officer[2];
    private Officer weightStationNorth;
    private Officer weightStationSouth;
    private Officer shaheen;

    private Officer wirelessOperator;
    private Officer security;
    private Officer moherer;

    public DutyShift() {
    }

    public Officer[] getTiger1() {
        return tiger1;
    }

    public void setTiger1(Officer tiger) throws DutyFullException {
        if(this.tiger1[0] == null)
            this.tiger1[0] = tiger;
        else if(this.tiger1[1] == null){
            this.tiger1[1] = tiger;
        }
        else{
            throw new DutyFullException("Duty Full");
        }
    }

    public Officer[] getTiger2() {
        return tiger2;
    }

    public void setTiger2(Officer tiger) throws DutyFullException {
        if(this.tiger2[0] == null)
            this.tiger2[0] = tiger;
        else if(this.tiger2[1] == null){
            this.tiger2[1] = tiger;
        }
        else{
            throw new DutyFullException("Duty Full");
        }
    }


    public Officer[] getTiger3() {
        return tiger3;
    }

    public void setTiger3(Officer tiger) throws DutyFullException {
        if(this.tiger3[0] == null)
            this.tiger3[0] = tiger;
        else if(this.tiger3[1] == null){
            this.tiger3[1] = tiger;
        }
        else{
            throw new DutyFullException("Duty Full");
        }
    }

    public Officer[] getTiger4() {
        return tiger4;
    }

    public void setTiger4(Officer tiger) throws DutyFullException {
        if(this.tiger4[0] == null)
            this.tiger4[0] = tiger;
        else if(this.tiger4[1] == null){
            this.tiger4[1] = tiger;
        }
        else{
            throw new DutyFullException("Duty Full");
        }
    }

    public Officer getWeightStationNorth() {
        return weightStationNorth;
    }

    public void setWeightStationNorth(Officer weightStationNorth) throws DutyFullException {
        if (this.weightStationNorth == null)
            this.weightStationNorth = weightStationNorth;
        else throw new DutyFullException("Duty Full");
    }

    public Officer getWeightStationSouth() {
        return weightStationSouth;
    }

    public void setWeightStationSouth(Officer weightStationSouth) throws DutyFullException {
        if(this.weightStationSouth == null)
            this.weightStationSouth = weightStationSouth;
        else throw new DutyFullException("Duty Full");
    }

    public Officer getShaheen() {
        return shaheen;
    }

    public void setShaheen(Officer shaheen) throws DutyFullException {

        if (this.shaheen == null)
            this.shaheen = shaheen;
        else throw new DutyFullException("Duty Full");
    }

    public Officer getWirelessOperator() {
        return wirelessOperator;
    }

    public void setWirelessOperator(Officer wirelessOperator) throws DutyFullException {

        if (this.wirelessOperator==null)
            this.wirelessOperator = wirelessOperator;
        else throw new DutyFullException("Duty Full");
    }

    public Officer getSecurity() {
        return security;
    }

    public void setSecurity(Officer security) throws DutyFullException {

        if (this.security == null)
            this.security = security;
        else throw new DutyFullException("Duty Full");
    }

    public Officer getMoherer() {
        return moherer;
    }

    public void setMoherer(Officer moherer) throws DutyFullException {
        if (this.moherer == null)
            this.moherer = moherer;
        else throw new DutyFullException("Duty Full");
    }

    @Override
    public String toString() {
        return "DutyShift{" +
                "tiger1=" + Arrays.toString(tiger1) +
                ", tiger2=" + Arrays.toString(tiger2) +
                ", tiger3=" + Arrays.toString(tiger3) +
                ", tiger4=" + Arrays.toString(tiger4) +
                ", weightStationNorth=" + weightStationNorth +
                ", weightStationSouth=" + weightStationSouth +
                ", shaheen=" + shaheen +
                ", wirelessOperator=" + wirelessOperator +
                ", security=" + security +
                ", moherer=" + moherer +
                '}';
    }
}
