
package leadevsys.users.org;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import demo.MainView;
import leadevsys.members.org.MemberMgtView;

public class LoginView extends JFrame implements ActionListener{
    JTextField unameFld = new JTextField();
    JPasswordField pwordFld = new JPasswordField();
    JLabel unameLbl = new JLabel();
    JLabel pwordLbl = new JLabel();
    JButton loginBtn = new JButton();
    JLabel loginTitleLbl = new JLabel();
    
    public LoginView(){
     initComponents();   
    }
    
    private void initComponents(){
        JPanel loginPanel = new JPanel();
        unameLbl.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        unameLbl.setText("Username");

        pwordLbl.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        pwordLbl.setText("Password");

        loginBtn.setText("Login");
        loginBtn.addActionListener(this);
        loginTitleLbl.setFont(new java.awt.Font("Arial", 1, 14)); 
        loginTitleLbl.setText("Leadership Development System");
            
    this.add(loginPanel);
		
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    GroupLayout layout = new GroupLayout(loginPanel);
        loginPanel.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(loginBtn)
                .addGap(181, 181, 181))
            .addGroup(layout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(pwordLbl)
                    .addComponent(unameLbl))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(unameFld, GroupLayout.PREFERRED_SIZE, 187, GroupLayout.PREFERRED_SIZE)
                    .addComponent(pwordFld, GroupLayout.PREFERRED_SIZE, 187, GroupLayout.PREFERRED_SIZE))
                .addContainerGap(98, Short.MAX_VALUE))
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(loginTitleLbl)
                .addGap(88, 88, 88))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(loginTitleLbl)
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(unameFld, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(unameLbl))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(pwordLbl)
                    .addComponent(pwordFld, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(loginBtn)
                .addContainerGap(67, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
   
          UserDao userDao = new UserDaoImpl();
          String username = unameFld.getText();
          String password = pwordFld.getText();

            User user = userDao.getUserByCredentials(username, password);
            if(user.getUsername().equals(username)&&(user.getPassword().equals(password))){
                setVisible(false);
                this.dispose();
                //View view = new AddMemberView();
                //view.setVisible(true);
                    MainView mainView = new MainView();
                    mainView.setVisible(true);
                 // MemberMgtView memberMgtview = new MemberMgtView();
                 // memberMgtview.setVisible(true);
                  
            }else {
                JOptionPane.showMessageDialog(null,"Invalid Credentials!");
            }

    }
}
