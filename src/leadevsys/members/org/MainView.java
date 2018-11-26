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

public class MainView extends JFrame implements ActionListener{
    
        MemberDao memberDao = new MemberDaoImpl();
        JLabel mainViewTitleLbl = new JLabel();
        JScrollPane jScrollPane1 = new JScrollPane();
        JTable memberTable = new JTable();
        JTextField searchMemberFld = new JTextField();
        JButton searchMemberBtn = new JButton();
        JButton addMemberBtn = new JButton();
        JButton addCGBtn = new JButton ();
        JButton addLeaderBtn = new JButton();
        
        
    public MainView(){
        initComponents();
    }
    
    private void initComponents(){
        JPanel mainViewPanel = new JPanel();
        mainViewTitleLbl.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        mainViewTitleLbl.setText("Leadership Management System");
             //  jScrollPane1.setViewportView(memberTable);
        searchMemberFld.setText("Enter search keyword");
        searchMemberBtn.setText("Search");
        addMemberBtn.setText("Add Member");
        addCGBtn.setText("Add CellGroup");
        addLeaderBtn.setText("Add Leader");

        FillTable();
        mainViewPanel.add(mainViewTitleLbl);
        mainViewPanel.add(jScrollPane1, BorderLayout.CENTER);
        mainViewPanel.add(searchMemberFld);
        mainViewPanel.add(searchMemberBtn);
        mainViewPanel.add(addMemberBtn);
        addMemberBtn.addActionListener(this);
        addCGBtn.addActionListener(this);
        addLeaderBtn.addActionListener(this);
        this.add(mainViewPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1000, 700);

//        memberTable.setModel(new DefaultTableModel(data,columnNames) {
//            Class[] types = new Class [] {
//                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
//            };
//
//            public Class getColumnClass(int columnIndex) {
//                return types [columnIndex];
//            }
//        });
        GroupLayout layout = new javax.swing.GroupLayout(mainViewPanel);
        mainViewPanel.setLayout(layout);
         layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(mainViewTitleLbl)
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
                                    .addComponent(addCGBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(addLeaderBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(34, 34, 34)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 639, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(136, 136, 136))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(mainViewTitleLbl)
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
                        .addComponent(addCGBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(addLeaderBtn)))
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
      }else if(e.getSource()==addCGBtn){
            setVisible(false);
            this.dispose();
            AddCGView view = new AddCGView();
            view.setVisible(true);
      }
    }
}
        

    
