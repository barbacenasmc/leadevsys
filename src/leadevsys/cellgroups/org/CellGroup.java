package leadevsys.cellgroups.org;

public class CellGroup {
   private int cg_id;
   private int leader_id;
   private String cgLocation;
   private String cgTime;
   private String cgDay;
   private int cgType;
   private int cg_cgType_id;

    public int getCg_cgType_id() {
        return cg_cgType_id;
    }

    public void setCg_cgType_id(int cg_cgType_id) {
        this.cg_cgType_id = cg_cgType_id;
    }
   
   
   
    public int getCg_id() {
        return cg_id;
    }

    public void setCg_id(int cg_id) {
        this.cg_id = cg_id;
    }
   
    
    public int getLeader_id() {
        return leader_id;
    }

    public void setLeader_id(int leader_id) {
        this.leader_id = leader_id;
    }

    public String getCgLocation() {
        return cgLocation;
    }

    public void setCgLocation(String cgLocation) {
        this.cgLocation = cgLocation;
    }

    public String getCgDay() {
        return cgDay;
    }

    public void setCgDay(String cgDay) {
        this.cgDay = cgDay;
    }
    
    public String getCgTime() {
        return cgTime;
    }

    public void setCgTime(String cgTime) {
        this.cgTime = cgTime;
    }

    public int getCgType() {
        return cgType;
    }

    public void setCgType(int cgType) {
        this.cgType = cgType;
    }
   
   
   
}
