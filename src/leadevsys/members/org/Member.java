package leadevsys.members.org;

public class Member {
    private int member_id;
    private String fname;
    private String mname;
    private String lname;

    
    public int getMemberId(){
        return member_id;
    }
    
    public void setMemberId(int member_id){
        this.member_id = member_id;
    }
    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }
    
    
}
