package leadevsys.members.org;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class EditMemberView extends AddMemberView implements ActionListener{

    int selected_member_id = 0;
    MemberDao selectedMemberDao = new MemberDaoImpl(); 
    Member selectedMember;
    public EditMemberView(int selected_member_id){
        super();
        this.selected_member_id = selected_member_id;  

        selectedMember = selectedMemberDao.getMemberById(selected_member_id);
        fnameFld.setText(selectedMember.getFname());
        mnameFld.setText(selectedMember.getMname());
        lnameFld.setText(selectedMember.getLname());
        memberLocationFld.setText(selectedMember.getMemberLocation());
        genderFld.setSelectedItem(selectedMember.getGender());
        civilStatusFld.setSelectedIndex(selectedMember.getCivilStatus());
        contactNoFld.setText(selectedMember.getContactNo());
        birthdateFld.setText(selectedMember.getBirthdate());
        schoolFld.setText(selectedMember.getSchool());
        occupationFld.setText(selectedMember.getOccupation());
        leaderFld.setSelectedIndex(selectedMember.getLeader_id());
 
    }
    
       @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==saveBtn){ 
            selectedMember.setFname(fnameFld.getText());
            selectedMember.setMname(mnameFld.getText());
            selectedMember.setLname(lnameFld.getText());
            selectedMember.setMemberLocation(memberLocationFld.getText());
            selectedMember.setGender(String.valueOf(genderFld.getSelectedItem()));
            selectedMember.setCivilStatus(civilStatusFld.getSelectedIndex());
            selectedMember.setContactNo(contactNoFld.getText());
            selectedMember.setBirthdate(birthdateFld.getText());
            selectedMember.setSchool(schoolFld.getText());
            selectedMember.setOccupation(occupationFld.getText());
            selectedMember.setLeader_id(leaderFld.getSelectedIndex());
            selectedMember.setMember_id(selected_member_id);
            selectedMemberDao.updateMember(selectedMember);
            JOptionPane.showMessageDialog(null,"Saved successfully!");
            
                setVisible(false);
                this.dispose();
                MemberMgtView memberMgtView = new MemberMgtView();
                memberMgtView.setVisible(true);
        }else if(e.getSource()==cancelBtn){
                setVisible(false);
                this.dispose();
                MemberMgtView memberMgtView = new MemberMgtView();
                memberMgtView.setVisible(true);
        }
        
    }
 
}
