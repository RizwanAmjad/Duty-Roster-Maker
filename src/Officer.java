public class Officer {
    // personal information
    private String beltNo;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private OfficerType type;

    //preferences

    private Shifts shiftPreference;
    private Duty[] dutyPreference;

    // quality score
    private int qualityScore;

    public Officer() {

    }

    public Officer(String beltNo, String firstName, String lastName,
                   String phoneNumber, OfficerType type, Shifts shiftPreference,
                   Duty[] dutyPreference, int qualityScore) {
        this.beltNo = beltNo;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.type = type;
        this.shiftPreference = shiftPreference;
        this.dutyPreference = dutyPreference;
        this.qualityScore = qualityScore;
    }

    public String getBeltNo() {
        return beltNo;
    }

    public void setBeltNo(String beltNo) {
        this.beltNo = beltNo;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getQualityScore() {
        return qualityScore;
    }

    public void setQualityScore(int qualityScore) {
        this.qualityScore = qualityScore;
    }

    public OfficerType getType() {
        return type;
    }

    public void setType(OfficerType type) {
        this.type = type;
    }

    public Shifts getShiftPreference() {
        return shiftPreference;
    }

    public void setShiftPreference(Shifts shiftPreference) {
        this.shiftPreference = shiftPreference;
    }

    public Duty[] getDutyPreference() {
        return dutyPreference;
    }

    public void setDutyPreference(Duty[] dutyPreference) {
        this.dutyPreference = dutyPreference;
    }

    @Override
    public String toString() {
        return "Officer{" +
                "beltNo='" + beltNo + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", type=" + type +
                ", shiftPreference=" + shiftPreference +
                ", dutyPreference=[" + dutyPreference[0] + ", "+ dutyPreference[1] + ", "+dutyPreference[2]+ "]"+
                ", qualityScore=" + qualityScore +
                '}';
    }
}
