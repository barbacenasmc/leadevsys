
package leadevsys.cellgroups.org;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import demo.MainView;

public class AddCGView extends JFrame implements ActionListener{
    CellGroupDao cgDao = new CellGroupDaoImpl();
    CellGroup cellgroup = new CellGroup();
    JTextField cgDayFld = new JTextField();
    JLabel cgDayLbl = new JLabel();
    JTextField cgLeaderFld = new JTextField();
    JLabel cgLeaderLbl = new JLabel();
    JTextField cgLocationFld = new JTextField();
    JLabel cgLocationLbl = new JLabel();
    JTextField cgTimeFld = new JTextField();
    JLabel cgTimeLbl = new JLabel();
    JComboBox cgTypeFld = new JComboBox();
    JLabel cgTypeLbl = new JLabel();
    JLabel addCellgroupTitleLbl = new JLabel();
    
    JButton cancelBtn = new JButton();
    JButton saveCGBtn = new JButton();
    
    public AddCGView(){
        initComponents();
    }
    
    private void initComponents(){
        JPanel addCGPanel = new JPanel();
        cgLocationLbl.setText("Location");
        addCellgroupTitleLbl.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        addCellgroupTitleLbl.setText("Add Cellgroup");
        cgDayLbl.setText("Day");
        cgTimeLbl.setText("Time");
        cgTypeLbl.setText("Type");
        cgLeaderLbl.setText("Leader");
        String[] cgTypeList = {"Youth Girls","Youth Boys","Women","Men","Senior Women", "Senior Men","Kids Boys","Kids Girls"};
        cgTypeFld = new JComboBox(cgTypeList);
        cgTypeFld.setSelectedIndex(0);
        saveCGBtn.setText("Save Cellgroup");
        cancelBtn.setText("Cancel");
        addCGPanel.add(cgLocationFld);
        addCGPanel.add(cgLocationLbl);
        addCGPanel.add(addCellgroupTitleLbl);
        addCGPanel.add(cgDayLbl);
        addCGPanel.add(cgTimeLbl);
        addCGPanel.add(cgTypeLbl);
        addCGPanel.add(cgLeaderLbl);
        addCGPanel.add(cgDayFld);
        addCGPanel.add(cgTimeFld);
        addCGPanel.add(cgLeaderFld);
        addCGPanel.add(saveCGBtn);
        addCGPanel.add(cancelBtn);
        
        cancelBtn.addActionListener(this);
        saveCGBtn.addActionListener(this);
        
        this.add(addCGPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        GroupLayout layout = new javax.swing.GroupLayout(addCGPanel);
        addCGPanel.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(addCellgroupTitleLbl)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(cancelBtn)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(saveCGBtn))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(cgLocationLbl)
                                .addComponent(cgDayLbl)
                                .addComponent(cgTimeLbl)
                                .addComponent(cgTypeLbl)
                                .addComponent(cgLeaderLbl))
                            .addGap(45, 45, 45)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(cgLocationFld, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE)
                                .addComponent(cgDayFld, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(cgTimeFld, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(cgTypeFld, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(cgLeaderFld, javax.swing.GroupLayout.Alignment.LEADING)))))
                .addContainerGap(56, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(addCellgroupTitleLbl)
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cgLocationLbl)
                    .addComponent(cgLocationFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cgDayLbl)
                    .addComponent(cgDayFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cgTimeLbl)
                    .addComponent(cgTimeFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cgTypeLbl)
                    .addComponent(cgTypeFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cgLeaderFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cgLeaderLbl))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveCGBtn)
                    .addComponent(cancelBtn))
                .addContainerGap(52, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==saveCGBtn){ 
            cellgroup.setCgLocation(cgLocationFld.getText());
            cellgroup.setCgDay(cgDayFld.getText());
            cellgroup.setCgTime(cgTimeFld.getText());
            cellgroup.setCgType(cgTypeFld.getSelectedIndex());
            cellgroup.setLeader_id(Integer.valueOf(cgLeaderFld.getText()));
            cgDao.createCG(cellgroup);
            cgDao.insertCGType(cellgroup);
            JOptionPane.showMessageDialog(null,"Saved successfully!");
            
                setVisible(false);
                this.dispose();
                MainView mainView = new MainView();
                mainView.setVisible(true);
        }else if(e.getSource()==cancelBtn){
                setVisible(false);
                this.dispose();
                MainView mainView = new MainView();
                mainView.setVisible(true);
        }
    }
}

