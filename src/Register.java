import java.awt.Color;
import java.awt.Toolkit;
import java.awt.Dialog.ModalityType;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import Database.ConnectDB;
import Model.User;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.ButtonGroup;
import javax.swing.JDialog;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.Font;

public class Register extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtUsername;
	private JPasswordField passwordField;
	private JTextField txtFirstNmae;
	private JTextField txtLastName;
	private JTextField txtLearnerUername; 
	 
	public Register() {
		
		setTitle("Anezile Academy");
		setResizable(false);
		setBackground(Color.YELLOW);
		setIconImage(Toolkit.getDefaultToolkit().getImage("img/Anezile icon.PNG"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 420, 420);
		setVisible(true);
		setContentPane(contentPane = new JPanel());
		contentPane.setBackground(Color.YELLOW);
		contentPane.setLayout(null);
		
		JLabel lblRegisterUser = new JLabel("Register User");
		lblRegisterUser.setFont(new Font("Chiller", Font.BOLD, 36));
		lblRegisterUser.setBounds(37, 25, 275, 30);
		contentPane.add(lblRegisterUser);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Chiller", Font.BOLD, 22));
		lblUsername.setBounds(10, 82, 92, 22);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Chiller", Font.BOLD, 22));
		lblPassword.setBounds(10, 115, 92, 22);
		contentPane.add(lblPassword);
		
		JLabel lblFirstname = new JLabel("First Name");
		lblFirstname.setFont(new Font("Chiller", Font.BOLD, 22));
		lblFirstname.setBounds(10, 148, 92, 22);
		contentPane.add(lblFirstname);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setFont(new Font("Chiller", Font.BOLD, 22));
		lblLastName.setBounds(10, 188, 92, 22);
		contentPane.add(lblLastName);
		
		txtUsername = new JTextField();
		txtUsername.setForeground(Color.YELLOW);
		txtUsername.setBackground(Color.BLACK);
		txtUsername.setBounds(115, 82, 256, 22);
		contentPane.add(txtUsername);
		txtUsername.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setForeground(Color.YELLOW);
		passwordField.setBackground(Color.BLACK);
		passwordField.setBounds(115, 115, 256, 20);
		contentPane.add(passwordField);
		
		txtFirstNmae = new JTextField();
		txtFirstNmae.setBackground(Color.BLACK);
		txtFirstNmae.setForeground(Color.YELLOW);
		txtFirstNmae.setColumns(10);
		txtFirstNmae.setBounds(115, 148, 256, 22);
		contentPane.add(txtFirstNmae);
		
		txtLastName = new JTextField();
		txtLastName.setForeground(Color.YELLOW);
		txtLastName.setBackground(Color.BLACK);
		txtLastName.setColumns(10);
		txtLastName.setBounds(115, 188, 256, 22);
		contentPane.add(txtLastName);
		
		JLabel lblRole = new JLabel("Role");
		lblRole.setFont(new Font("Chiller", Font.BOLD, 22));
		lblRole.setBounds(10, 233, 92, 22);
		contentPane.add(lblRole);
		
		JRadioButton rdbtnlearner = new JRadioButton("Learner");
		rdbtnlearner.setFont(new Font("Chiller", Font.PLAIN, 16));
		rdbtnlearner.setForeground(Color.YELLOW);
		rdbtnlearner.setBackground(Color.BLACK);
		rdbtnlearner.setBounds(115, 234, 74, 23);
		contentPane.add(rdbtnlearner);
		
		JRadioButton rdbtnTeacher = new JRadioButton("Teacher");
		rdbtnTeacher.setForeground(Color.YELLOW);
		rdbtnTeacher.setFont(new Font("Chiller", Font.PLAIN, 16));
		rdbtnTeacher.setBackground(Color.BLACK);
		rdbtnTeacher.setBounds(200, 233, 74, 23);
		contentPane.add(rdbtnTeacher);
		
		JRadioButton rdbtnParent = new JRadioButton("Parent");
		rdbtnParent.setFont(new Font("Chiller", Font.PLAIN, 16));
		rdbtnParent.setBackground(Color.BLACK);
		rdbtnParent.setForeground(Color.YELLOW);
		rdbtnParent.setBounds(297, 233, 74, 23);
		contentPane.add(rdbtnParent);
		ButtonGroup group = new ButtonGroup();
		group.add(rdbtnlearner);
		group.add(rdbtnTeacher);
		group.add(rdbtnParent);
		
		
		JLabel lblLearnerUsername = new JLabel("If your are Parent Learner Username");
		lblLearnerUsername.setLabelFor(lblLearnerUsername);
		lblLearnerUsername.setFont(new Font("Chiller", Font.BOLD, 18));
		lblLearnerUsername.setBounds(115, 266, 236, 22);
		contentPane.add(lblLearnerUsername);
		
		txtLearnerUername = new JTextField();
		txtLearnerUername.setForeground(Color.YELLOW);
		txtLearnerUername.setBackground(Color.BLACK);
		txtLearnerUername.setFont(new Font("Chiller", Font.PLAIN, 16));
		txtLearnerUername.setEnabled(true);
		txtLearnerUername.setColumns(10);
		txtLearnerUername.setBounds(115, 299, 222, 22);
		contentPane.add(txtLearnerUername);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.setBackground(Color.BLACK);
		btnRegister.setForeground(Color.YELLOW);
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ConnectDB dbconn = new ConnectDB();
				//Login 
				String role="";
				
				
								
				if(rdbtnlearner.isSelected()) {
					 role ="student";
				}
				if(rdbtnParent.isSelected()) {
					 role ="parent";
				}
				if(rdbtnTeacher.isSelected()) {
					 role ="teacher";
				}
			    @SuppressWarnings("deprecation")
				User  user = new User(1,txtUsername.getText(), txtFirstNmae.getText(),txtLastName.getText(), passwordField.getText(), role);
				try {
					
					if(user.getFirstName().equals("") || user.getPassword().equals("")){
						ErrorLogin dialog = new ErrorLogin();
				        dialog.setModalityType(ModalityType.APPLICATION_MODAL);
				        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				        dialog.setVisible(true);
					}
					else {
						dbconn.Register(user);
						ConfirmRegister dialog = new ConfirmRegister();
				        dialog.setModalityType(ModalityType.APPLICATION_MODAL);
				        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				        dialog.setVisible(true);
					    dispose();		
					}
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		btnRegister.setFont(new Font("Chiller", Font.BOLD, 26));
		btnRegister.setBounds(10, 324, 341, 45);
		contentPane.add(btnRegister);
	}
}
