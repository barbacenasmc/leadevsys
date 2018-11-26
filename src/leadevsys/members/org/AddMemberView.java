package leadevsys.members.org;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AddMemberView extends JFrame implements ActionListener{
    MemberDao memberDao = new MemberDaoImpl(); 
    Member member = new Member();
    JTextField fnameFld = new JTextField();
    JLabel fnameLbl = new JLabel();
    JTextField mnameFld = new JTextField();
    JLabel mnameLbl = new JLabel();
    JLabel lnameLbl = new JLabel();
    JTextField lnameFld = new JTextField();
    JTextField memberLocationFld = new JTextField();
    JLabel memberLocationLbl = new JLabel();
    JTextField occupationFld = new JTextField();
    JLabel occupationLbl = new JLabel();
    JTextField schoolFld = new JTextField();
    JLabel schoolLbl = new JLabel();
    JTextField birthdateFld = new JTextField();;
    JLabel birthdateLbl = new JLabel();
    JTextField civilStatusFld = new JTextField();;
    JLabel civilStatusLbl = new JLabel();
    JTextField contactNoFld = new JTextField();;
    JLabel contactNoLbl = new JLabel();
    JTextField genderFld = new JTextField();
    JLabel genderLbl = new JLabel();
    private JButton cancelBtn = new JButton();
    private JButton saveBtn = new JButton();
    JLabel addMemberFormLbl = new JLabel();
   
    public AddMemberView(){
       initComponents();
    }
    
    private void initComponents(){
    JPanel addMemberPanel = new JPanel();
    //set label texts
    addMemberFormLbl.setFont(new java.awt.Font("Arial", 1, 14));
    addMemberFormLbl.setText("Add Member Profile");
  
    fnameLbl.setText("First Name");
    mnameLbl.setText("Middle Name");
    lnameLbl.setText("Last Name");

    memberLocationLbl.setText("Location");
    genderLbl.setText("Gender");
    civilStatusLbl.setText("Civil Status");
    contactNoLbl.setText("Contact No");
    birthdateLbl.setText("Birthdate");
    schoolLbl.setText("School");
    occupationLbl.setText("Occupation");
    saveBtn = new JButton("Save");
    cancelBtn = new JButton("Cancel");
    
   //add elements to panel
    addMemberPanel.add(addMemberFormLbl);
    addMemberPanel.add(fnameLbl);
    addMemberPanel.add(fnameFld);
    addMemberPanel.add(mnameLbl);
    addMemberPanel.add(mnameFld);
    addMemberPanel.add(lnameLbl);
    addMemberPanel.add(lnameFld);
    addMemberPanel.add(memberLocationLbl);
    addMemberPanel.add(memberLocationFld);
    addMemberPanel.add(genderLbl);
    addMemberPanel.add(genderFld);
    addMemberPanel.add(civilStatusLbl);
    addMemberPanel.add(civilStatusFld);
    addMemberPanel.add(contactNoLbl);
    addMemberPanel.add(contactNoFld);
    addMemberPanel.add(birthdateLbl);
    addMemberPanel.add(birthdateFld);
    addMemberPanel.add(schoolLbl);
    addMemberPanel.add(schoolFld);
    addMemberPanel.add(occupationLbl);
    addMemberPanel.add(occupationFld);
    addMemberPanel.add(saveBtn);
    addMemberPanel.add(cancelBtn);
    
    saveBtn.addActionListener(this);
    cancelBtn.addActionListener(this);
    
    this.add(addMemberPanel);
    this.setSize(800,800);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    GroupLayout layout = new GroupLayout(addMemberPanel);
        addMemberPanel.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(addMemberFormLbl)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fnameLbl)
                            .addComponent(mnameLbl)
                            .addComponent(lnameLbl)
                            .addComponent(memberLocationLbl)
                            .addComponent(genderLbl)
                            .addComponent(civilStatusLbl))
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(fnameFld, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
                            .addComponent(mnameFld)
                            .addComponent(lnameFld)
                            .addComponent(memberLocationFld)
                            .addComponent(genderFld)
                            .addComponent(civilStatusFld))
                        .addGap(92, 92, 92)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(contactNoLbl)
                                        .addComponent(birthdateLbl)
                                        .addComponent(schoolLbl))
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(contactNoFld, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
                                        .addComponent(birthdateFld)
                                        .addComponent(schoolFld)))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(occupationLbl)
                                    .addGap(18, 18, 18)
                                    .addComponent(occupationFld)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cancelBtn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(saveBtn)))))
                .addContainerGap(86, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(addMemberFormLbl)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fnameLbl)
                    .addComponent(fnameFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(contactNoLbl)
                    .addComponent(contactNoFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mnameLbl)
                    .addComponent(mnameFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(birthdateLbl)
                    .addComponent(birthdateFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lnameLbl)
                    .addComponent(lnameFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(schoolLbl)
                    .addComponent(schoolFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(memberLocationLbl)
                    .addComponent(memberLocationFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(occupationLbl)
                    .addComponent(occupationFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(genderFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(genderLbl))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(civilStatusLbl)
                    .addComponent(civilStatusFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(saveBtn)
                    .addComponent(cancelBtn))
                .addContainerGap(85, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==saveBtn){ 
            member.setFname(fnameFld.getText());
            member.setMname(mnameFld.getText());
            member.setLname(lnameFld.getText());
            memberDao.createMember(member);
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