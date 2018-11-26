package leadevsys.cellgroups.org;

import java.util.ArrayList;
public interface CellGroupDao {
    
    public ArrayList<CellGroup> getAllCellgroups();
    public CellGroup getCGById(int cg_id);
    public void createCG(CellGroup cellgroup);
    public void insertCGType(CellGroup cellgroup);
    public void updateCG(CellGroup cellgroup);
    public void deleteCG(int cellgroup_id);
    
}
