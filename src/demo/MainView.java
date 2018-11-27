package demo;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import leadevsys.members.org.MemberMgtView;

public class MainView extends JFrame implements ActionListener{
    
    JLabel mainDashboardLbl = new JLabel();
    JButton manageAttendanceBtn = new JButton();
    JButton manageLeadersBtn = new JButton();
    JButton manageCellGroupsBtn = new JButton();
    JButton manageMembersBtn = new JButton();
    JButton manageTrainingsBtn = new JButton();
        
    public MainView(){
        initComponents();
    }
    
    private void initComponents(){
        JPanel mainViewPanel = new JPanel();

        mainDashboardLbl.setFont(new java.awt.Font("Arial", 1, 18)); 
        mainDashboardLbl.setText("Leadership Management System");
        manageMembersBtn.setText("Manage Members");
        manageLeadersBtn.setText("Manage Leaders");
        manageCellGroupsBtn.setText("Manage Cell Groups");
        manageTrainingsBtn.setText("Manage Trainings");
        manageAttendanceBtn.setText("Manage Attendance");

        mainViewPanel.add(mainDashboardLbl);
        mainViewPanel.add(manageMembersBtn);
        mainViewPanel.add(manageCellGroupsBtn);
        mainViewPanel.add(manageTrainingsBtn);
        mainViewPanel.add(manageAttendanceBtn);
        
        manageMembersBtn.addActionListener(this);
        manageCellGroupsBtn.addActionListener(this);
        manageTrainingsBtn.addActionListener(this);
        manageAttendanceBtn.addActionListener(this);
        this.add(mainViewPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);

        GroupLayout layout = new javax.swing.GroupLayout(mainViewPanel);
        mainViewPanel.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(117, Short.MAX_VALUE)
                .addComponent(manageMembersBtn)
                .addGap(95, 95, 95)
                .addComponent(manageCellGroupsBtn)
                .addGap(62, 62, 62)
                .addComponent(manageLeadersBtn)
                .addGap(78, 78, 78)
                .addComponent(manageTrainingsBtn)
                .addGap(76, 76, 76)
                .addComponent(manageAttendanceBtn)
                .addGap(113, 113, 113))
            .addGroup(layout.createSequentialGroup()
                .addGap(432, 432, 432)
                .addComponent(mainDashboardLbl)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(mainDashboardLbl)
                .addGap(66, 66, 66)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(manageMembersBtn)
                    .addComponent(manageCellGroupsBtn)
                    .addComponent(manageTrainingsBtn)
                    .addComponent(manageAttendanceBtn)
                    .addComponent(manageLeadersBtn))
                .addContainerGap(305, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
      if (e.getSource()==manageMembersBtn){
            setVisible(false);
            this.dispose();
            MemberMgtView view = new MemberMgtView();
            view.setVisible(true);
      }else if(e.getSource()==manageCellGroupsBtn){
            /*setVisible(false);
            this.dispose();
            CellGroupMgtView view = new CellgroupMgtView();
            view.setVisible(true);
            */
      }else if(e.getSource()==manageLeadersBtn){
            /*setVisible(false);
            this.dispose();
            LeaderMgtView view = new LeaderMgtView();
            view.setVisible(true);
            */
      }else if(e.getSource()==manageTrainingsBtn){
            /*setVisible(false);
            this.dispose();
            TrainingMgtView view = new TrainingtView();
            view.setVisible(true);
            */
      }else if(e.getSource()==manageAttendanceBtn){
            /*setVisible(false);
            this.dispose();
            AttendanceMgtView view = new AttendanceMgtView();
            view.setVisible(true);
            */
      }
    }
}
        

    
