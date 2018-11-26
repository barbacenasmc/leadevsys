
package leadevsys.members.org;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import leadevsys.cellgroups.org.AddCGView;

public class MemberMgtView extends JFrame implements ActionListener{
        MemberDao memberDao = new MemberDaoImpl();
        JLabel memberMgtTitleLbl = new JLabel();
        JScrollPane jScrollPane1 = new JScrollPane();
        JTable memberTable = new JTable();
        JTextField searchMemberFld = new JTextField();
        JButton searchMemberBtn = new JButton();
        JButton addMemberBtn = new JButton();
        JButton editMemberBtn = new JButton ();
        JButton deleteMemberBtn = new JButton();
        
        
    public MemberMgtView(){
        initComponents();
    }
    
    private void initComponents(){
        JPanel mainViewPanel = new JPanel();
        memberMgtTitleLbl.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        memberMgtTitleLbl.setText("Member Management Dashboard");
        searchMemberFld.setText("Enter search keyword");
        searchMemberBtn.setText("Search");
        addMemberBtn.setText("Add Member");
        editMemberBtn.setText("Edit Member");
        deleteMemberBtn.setText("Delete Member");

        FillTable();
        mainViewPanel.add(memberMgtTitleLbl);
        mainViewPanel.add(jScrollPane1, BorderLayout.CENTER);
        mainViewPanel.add(searchMemberFld);
        mainViewPanel.add(searchMemberBtn);
        mainViewPanel.add(addMemberBtn);
        addMemberBtn.addActionListener(this);
        editMemberBtn.addActionListener(this);
        deleteMemberBtn.addActionListener(this);
        this.add(mainViewPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1000, 700);

        GroupLayout layout = new javax.swing.GroupLayout(mainViewPanel);
        mainViewPanel.setLayout(layout);
         layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(memberMgtTitleLbl)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(searchMemberFld, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(searchMemberBtn))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(addMemberBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(editMemberBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(deleteMemberBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(34, 34, 34)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 639, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(136, 136, 136))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(memberMgtTitleLbl)
                .addGap(61, 61, 61)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchMemberFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchMemberBtn))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(addMemberBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(editMemberBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(deleteMemberBtn)))
                .addContainerGap(163, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }
    
    
        private void FillTable(){  
       String [] columnNames = {"Member ID", "First Name", "Middle Name", "Last Name"};  
        DefaultTableModel tableModel = new DefaultTableModel(columnNames,0);
        
        memberTable = new JTable(tableModel);
        jScrollPane1 = new JScrollPane(memberTable);
        
        for (Member member : memberDao.getAllMembers()) {
         tableModel.addRow(new Object[] { member.getMemberId() , member.getFname(),member.getMname(), member.getLname()});
        }
       }

    @Override
    public void actionPerformed(ActionEvent e) {
      if (e.getSource()==addMemberBtn){
            setVisible(false);
            this.dispose();
            AddMemberView view = new AddMemberView();
            view.setVisible(true);
      }else if(e.getSource()==editMemberBtn){
            setVisible(false);
            this.dispose();
            AddCGView view = new AddCGView();
            view.setVisible(true);
      }
    }
}
