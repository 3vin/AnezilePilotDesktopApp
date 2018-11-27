import java.awt.Color;
import java.awt.Toolkit;
import java.awt.Dialog.ModalityType;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import Database.ConnectDB;
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

	
	 // Create the 
	 
	public Register() {
		
		setTitle("Anezile Academy");
		setResizable(false);
		setBackground(Color.WHITE);
		setIconImage(Toolkit.getDefaultToolkit().getImage("img/Anezile icon.PNG"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 690, 510);
		setVisible(true);
		setContentPane(contentPane = new JPanel());
		contentPane.setBackground(Color.YELLOW);
		contentPane.setLayout(null);
		
		JLabel lblRegisterUser = new JLabel("Register User");
		lblRegisterUser.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblRegisterUser.setBounds(140, 23, 275, 30);
		contentPane.add(lblRegisterUser);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(10, 82, 157, 22);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(10, 115, 157, 22);
		contentPane.add(lblPassword);
		
		JLabel lblFirstname = new JLabel("First Name");
		lblFirstname.setBounds(10, 148, 157, 22);
		contentPane.add(lblFirstname);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setBounds(10, 188, 157, 22);
		contentPane.add(lblLastName);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(177, 83, 222, 22);
		contentPane.add(txtUsername);
		txtUsername.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(177, 116, 222, 20);
		contentPane.add(passwordField);
		
		txtFirstNmae = new JTextField();
		txtFirstNmae.setColumns(10);
		txtFirstNmae.setBounds(177, 149, 222, 22);
		contentPane.add(txtFirstNmae);
		
		txtLastName = new JTextField();
		txtLastName.setColumns(10);
		txtLastName.setBounds(177, 189, 222, 22);
		contentPane.add(txtLastName);
		
		JLabel lblRole = new JLabel("Role");
		lblRole.setBounds(10, 233, 157, 22);
		contentPane.add(lblRole);
		
		JRadioButton rdbtnlearner = new JRadioButton("Learner");
		rdbtnlearner.setBounds(174, 233, 74, 23);
		contentPane.add(rdbtnlearner);
		
		JRadioButton rdbtnTeacher = new JRadioButton("Teacher");
		rdbtnTeacher.setBounds(274, 233, 74, 23);
		contentPane.add(rdbtnTeacher);
		
		JRadioButton rdbtnParent = new JRadioButton("Parent");
		rdbtnParent.setBounds(381, 233, 74, 23);
		contentPane.add(rdbtnParent);
		ButtonGroup group = new ButtonGroup();
		group.add(rdbtnlearner);
		group.add(rdbtnTeacher);
		group.add(rdbtnParent);
		
		
		JLabel lblLearnerUsername = new JLabel("IF your are Parent Learner Username");
		lblLearnerUsername.setBounds(177, 260, 222, 22);
		lblLearnerUsername.setVisible(false);
		contentPane.add(lblLearnerUsername);
		
		txtLearnerUername = new JTextField();
		txtLearnerUername.setEnabled(true);
		txtLearnerUername.setColumns(10);
		txtLearnerUername.setBounds(177, 286, 222, 22);
		contentPane.add(txtLearnerUername);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ConnectDB dbconn = new ConnectDB();
				//Login 
				
				String username =txtUsername.getText();
				@SuppressWarnings("deprecation")
				String password= passwordField.getText();
				String firstName = txtFirstNmae.getText();
				String lastName = txtLastName.getText();
				String role="";
				String Studentusername =txtLearnerUername.getText();
				
				if(rdbtnlearner.isSelected()) {
					 role ="student";
				}
				if(rdbtnParent.isSelected()) {
					 role ="parent";
				}
				if(rdbtnTeacher.isSelected()) {
					 role ="teacher";
				}
			    
				try {
					
					if(username.trim().equals("") || password.trim().equals("")){
						ErrorLogin dialog = new ErrorLogin();
				        dialog.setModalityType(ModalityType.APPLICATION_MODAL);
				        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				        dialog.setVisible(true);
					    dispose();
					
					}
					else {
						dbconn.Register(username, password, firstName, lastName, role, Studentusername);
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
		btnRegister.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnRegister.setBounds(174, 347, 241, 45);
		contentPane.add(btnRegister);
	}
}
