import java.util.ArrayList;
import java.util.List;

public class DutyRoster {
    private DutyShift morningShift;
    private DutyShift eveningShift;
    private DutyShift nightShift;

    private List<Officer> onRotation = new ArrayList<>();
    private List<Officer> assigned = new ArrayList<>();

    public DutyRoster() {
        morningShift = new DutyShift();
        eveningShift = new DutyShift();
        nightShift = new DutyShift();
    }

    public DutyShift getMorningShift() {
        return morningShift;
    }

    public void setMorningShift(DutyShift morningShift) {
        this.morningShift = morningShift;
    }

    public DutyShift getEveningShift() {
        return eveningShift;
    }

    public void setEveningShift(DutyShift eveningShift) {
        this.eveningShift = eveningShift;
    }

    public DutyShift getNightShift() {
        return nightShift;
    }

    public void setNightShift(DutyShift nightShift) {
        this.nightShift = nightShift;
    }

    public void addToRotation(Officer officer){
        onRotation.add(officer);
    }

    public List<Officer> getOnRotation() {
        return onRotation;
    }

    public void addToAssigned(Officer officer){
        assigned.add(officer);
    }

    public List<Officer> getAssigned(){
        return assigned;
    }

    @Override
    public String toString() {
        return "DutyRoster{" +
                "morningShift=" + morningShift +
                ", \neveningShift=" + eveningShift +
                ", \nnightShift=" + nightShift +
                ", \nonRotation=" + onRotation +
                ", \nassigned=" + assigned +
                '}';
    }
}
