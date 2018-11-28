
package leadevsys.cellgroups.org;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import leadevsys.utils.org.MemberFormConstants;

public class CellGroupMgtView extends JFrame implements ActionListener{
       
        JLabel dashboardTitleLbl = new JLabel();
        JScrollPane jScrollPane1 = new JScrollPane();
        JTable memberTable = new JTable();
        JTextField searchFld = new JTextField();
        JButton searchBtn = new JButton();
        JButton addBtn = new JButton();
        JButton editBtn = new JButton ();
        JButton deleteBtn = new JButton();
        
        
    public CellGroupMgtView(){
        initComponents();
    }
    
    private void initComponents(){
        JPanel mainViewPanel = new JPanel();
        dashboardTitleLbl.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        dashboardTitleLbl.setText("CellGroup Management Dashboard");
        searchFld.setText("Enter search keyword");
        searchBtn.setText("Search");
        addBtn.setText("Add");
        editBtn.setText("Edit");
        deleteBtn.setText("Delete");

        FillTable();
        mainViewPanel.add(dashboardTitleLbl);
        mainViewPanel.add(jScrollPane1, BorderLayout.CENTER);
        mainViewPanel.add(searchFld);
        mainViewPanel.add(searchBtn);
        mainViewPanel.add(addBtn);
        addBtn.addActionListener(this);
        editBtn.addActionListener(this);
        deleteBtn.addActionListener(this);
        searchBtn.addActionListener(this);
        
        this.add(mainViewPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       // this.setSize(2000, 1500);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);

        GroupLayout layout = new javax.swing.GroupLayout(mainViewPanel);
        mainViewPanel.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(dashboardTitleLbl)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(searchFld, javax.swing.GroupLayout.PREFERRED_SIZE, 567, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(searchBtn))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(addBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(editBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(deleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1111, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 24, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(dashboardTitleLbl)
                .addGap(61, 61, 61)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchBtn))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(addBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(editBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(deleteBtn))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(182, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(null);
    }
    
    
        private void FillTable(){  
        String [] columnNames = {"CellGroup ID", "Location", "Day", "Time","Type","Leader"};  
        DefaultTableModel tableModel = new DefaultTableModel(columnNames,0);
        
        memberTable = new JTable(tableModel);
        jScrollPane1 = new JScrollPane(memberTable);
        CellGroupDao cellgroupDao = new CellGroupDaoImpl();
        for (CellGroup cellgroup : cellgroupDao.getAllCellgroups()) {
         tableModel.addRow(new Object[] { cellgroup.getCg_id() , cellgroup.getCgLocation(),cellgroup.getCgDay(), cellgroup.getCgTime(), cellgroup.getCgType(), cellgroup.getLeader_id()});
        }
       }

        private int getSelectedItemId(){
            int row = memberTable.getSelectedRow();
            int selected_item_id = Integer.parseInt(memberTable.getModel().getValueAt(row, 0).toString());

            return selected_item_id;
        }
    @Override
    public void actionPerformed(ActionEvent e) {
       
      if (e.getSource()==addBtn){
            setVisible(false);
            this.dispose();
            AddCGView view = new AddCGView();
            view.setVisible(true);
      }else if(e.getSource()==editBtn){   

           setVisible(false);
            this.dispose();
            EditCGView view = new EditCGView(getSelectedItemId());
            view.setVisible(true);
            
      }else if(e.getSource()==deleteBtn){          
          int input = JOptionPane.showConfirmDialog(null, "Are you sure to delete?");
          if (input==0){
            CellGroupDao deletedCGDao = new CellGroupDaoImpl();
            deletedCGDao.deleteCG(getSelectedItemId()); 
            setVisible(false);
            this.dispose();
            CellGroupMgtView view = new CellGroupMgtView();
            view.setVisible(true);
       }else if(e.getSource()==searchBtn){
           /*CellGroupDao searchCGDao = new CellGroupDaoImpl();
           searchCGDao.getByName(searchFld.getText());
           setVisible(false);
           this.dispose();
           CellGroupMgtView view = new CellGroupMgtView();
           view.setVisible(true);
           */

      }
    }
  }
}    

