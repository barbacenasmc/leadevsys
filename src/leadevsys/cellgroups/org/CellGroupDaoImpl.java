
package leadevsys.cellgroups.org;
import leadevsys.utils.org.ConnectDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CellGroupDaoImpl implements CellGroupDao{
    
    private final Connection conn = ConnectDB.getConnection();
    private final String SQL_CREATE_CELLGROUP = "INSERT INTO CELLGROUPS (cg_id,cglocation,cgDay,cgTime,cgType,leader_id) VALUES (?,?,?,?,?,?)";
    private final String SQL_INSERT_CELLGROUP_CGTYPE = "INSERT INTO CELLGROUP_CGTYPE (cellgroup_cgtype_id,cg_id,cgtype_id) VALUES (?,?,?)";
    private final String SQL_GET_CELLGROUP_BY_ID = "SELECT* FROM CELLGROUPS WHERE cg_id=?";
    private final String SQL_GET_ALL_CELLGROUPS =   "SELECT * FROM CELLGROUPS";
    private final String SQL_UPDATE_MEMBER = "UPDATE CELLGROUPS SET cgLocation = ?, cgDay = ?, cgTime = ?, cgType = ?, leader_id = ? WHERE cg_id = ?";
    private final String SQL_DELETE_MEMBER = "DELETE FROM CELLGROUPS WHERE cg_id = ?";
    @Override
    
    public ArrayList<CellGroup> getAllCellgroups(){
        ArrayList<CellGroup> allCellgroups = new ArrayList();
        try(PreparedStatement ps = conn.prepareStatement(SQL_GET_ALL_CELLGROUPS);
                ResultSet rs =  ps.executeQuery()){
                while (rs.next()){
                    CellGroup cellgroup = new CellGroup();
                    cellgroup.setCg_id(rs.getInt(1));
                    cellgroup.setCgLocation(rs.getString(2));
                    cellgroup.setCgDay(rs.getString(3));                  
                    cellgroup.setCgTime(rs.getString(4));
                    cellgroup.setCgType(rs.getInt(5));
                    cellgroup.setLeader_id(rs.getInt(6));
                    allCellgroups.add(cellgroup);
                }
            
       } catch (SQLException ex) {  
            Logger.getLogger(CellGroupDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }  
        return allCellgroups;
    }

    @Override
    public CellGroup getCGById(int cg_id) {
        CellGroup cellgroup = new CellGroup();
        try(PreparedStatement ps = conn.prepareStatement(SQL_GET_CELLGROUP_BY_ID)){
            ps.setInt(1,cg_id);
            try(ResultSet rs = ps.executeQuery()){
                while(rs.next()){
                    cellgroup.setCg_id(rs.getInt(1));
                    cellgroup.setCgLocation(rs.getString(2)); 
                    cellgroup.setCgDay(rs.getString(3));                  
                    cellgroup.setCgTime(rs.getString(4));
                    cellgroup.setCgType(rs.getInt(5));
                    cellgroup.setLeader_id(rs.getInt(6));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(CellGroupDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return cellgroup;
    }

    @Override
    public void createCG(CellGroup cellgroup) {
       try(PreparedStatement ps = conn.prepareStatement(SQL_CREATE_CELLGROUP,Statement.RETURN_GENERATED_KEYS)){
           ps.setInt(1,cellgroup.getCg_id());
           ps.setString(2,cellgroup.getCgLocation());
           ps.setString(3, cellgroup.getCgDay());
           ps.setString(4, cellgroup.getCgTime());          
           ps.setInt(5, cellgroup.getCgType());          
           ps.setInt(6, cellgroup.getLeader_id());
           ps.executeUpdate();
           try(ResultSet generatedKeys= ps.getGeneratedKeys()){
            if(generatedKeys.next()){
                cellgroup.setCg_id(generatedKeys.getInt(1));
            }   
           }
 
       } catch (SQLException ex) {  
            Logger.getLogger(CellGroupDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }
    @Override
    public void updateCG(CellGroup cellgroup) {
        try(PreparedStatement ps = conn.prepareStatement(SQL_UPDATE_MEMBER)){
           ps.setString(1,cellgroup.getCgLocation());
           ps.setString(2, cellgroup.getCgDay());
           ps.setString(3, cellgroup.getCgTime());          
           ps.setInt(4, cellgroup.getCgType());          
           ps.setInt(5, cellgroup.getLeader_id());
           ps.setInt(6,cellgroup.getCg_id());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CellGroupDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void deleteCG(int cg_id) {
        try(PreparedStatement ps = conn.prepareStatement(SQL_DELETE_MEMBER)){
            ps.setInt(1, cg_id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CellGroupDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void insertCGType(CellGroup cellgroup) {
       try(PreparedStatement ps = conn.prepareStatement(SQL_INSERT_CELLGROUP_CGTYPE,Statement.RETURN_GENERATED_KEYS)){
           ps.setInt(1,cellgroup.getCg_cgType_id());
           ps.setInt(2,cellgroup.getCg_id());
           ps.setInt(3,cellgroup.getCgType());
           ps.executeUpdate();
           try(ResultSet generatedKeys= ps.getGeneratedKeys()){
            if(generatedKeys.next()){
                cellgroup.setCg_cgType_id(generatedKeys.getInt(1));
            }   
           }
 
       } catch (SQLException ex) {  
            Logger.getLogger(CellGroupDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }


    
}
