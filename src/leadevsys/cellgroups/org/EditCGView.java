
package leadevsys.cellgroups.org;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import leadevsys.members.org.MemberMgtView;

public class EditCGView extends AddCGView implements ActionListener{
    int selected_cg_id = 0;
    CellGroupDao selectedCGDao = new CellGroupDaoImpl(); 
    CellGroup selectedCG;
    public EditCGView(int selected_cg_id) {
        super();
        this.selected_cg_id = selected_cg_id;
        selectedCG = selectedCGDao.getCGById(selected_cg_id);
        cgLocationFld.setText(selectedCG.getCgLocation());
        cgDayFld.setText(selectedCG.getCgDay());
        cgTimeFld.setText(selectedCG.getCgTime());
        cgTypeFld.setSelectedIndex(selectedCG.getCgType());
        cgLeaderFld.setSelectedIndex(selectedCG.getLeader_id());
    }
    
        @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==saveCGBtn){ 
            selectedCG.setCgLocation(cgLocationFld.getText());
            selectedCG.setCgDay(cgDayFld.getText());
            selectedCG.setCgTime(cgTimeFld.getText());
            selectedCG.setCgType(cgTypeFld.getSelectedIndex());
            selectedCG.setLeader_id(cgLeaderFld.getSelectedIndex());
            selectedCG.setCg_id(selected_cg_id);
            selectedCGDao.updateCG(selectedCG);
            JOptionPane.showMessageDialog(null,"Saved successfully!");
            
                setVisible(false);
                this.dispose();
                CellGroupMgtView view = new CellGroupMgtView();
                view.setVisible(true);
        }else if(e.getSource()==cancelBtn){
                setVisible(false);
                this.dispose();
                CellGroupMgtView view = new CellGroupMgtView();
                view.setVisible(true);
        }
        
    }


}
