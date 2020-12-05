public class Assigned {
    private Officer officer;
    private Shifts shift;
    private Duty duty;

    public Assigned(Officer officer, Shifts shift, Duty duty) {
        this.officer = officer;
        this.shift = shift;
        this.duty = duty;
    }

    public Officer getOfficer() {
        return officer;
    }

    public void setOfficer(Officer officer) {
        this.officer = officer;
    }

    public Shifts getShift() {
        return shift;
    }

    public void setShift(Shifts shift) {
        this.shift = shift;
    }

    public Duty getDuty() {
        return duty;
    }

    public void setDuty(Duty duty) {
        this.duty = duty;
    }

    @Override
    public String toString() {
        return "Assigned{" +
                "officer=" + officer.getBeltNo() +
                ", shift=" + shift +
                ", duty=" + duty +
                '}';
    }
}
