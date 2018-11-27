import java.awt.Color;
import java.awt.Dialog.ModalityType;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JDialog;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import Database.ConnectDB;
import Model.User;

public class Campus extends JFrame {

	private static final long serialVersionUID = 1L;
	// initialize objects
	private JFrame frame;
	private JPanel contentPane;
	private JPasswordField passwordField;
	private JTextField txtusername;
	private JLabel lblusername;
	private JLabel lblpassword;
	private JButton btnSignin;
	private JButton btnRegister;
	private JLabel About1 = new JLabel("1");
	private JLabel About2 = new JLabel("2");
	private JLabel About3 = new JLabel("3");
	private JLabel About4 = new JLabel("4");
	private JLabel lblHome;
	private JLabel lblAboutus;
	private JLabel lblOurprog;
	private JLabel lblContactus;
	private JLabel imgSelector;

	// Create the frame.
	public Campus() {
		frame = new JFrame();
		frame.setTitle("Anezile Academy");
		frame.setResizable(false);
		frame.setBackground(Color.WHITE);
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("/img/Anezile_icon.PNG"));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 690, 510);
		frame.setVisible(true);
		frame.setContentPane(contentPane = new JPanel());
		contentPane.setBackground(Color.YELLOW);
		contentPane.setLayout(null);
	}

	public void setfrm() {
		lblHome = new JLabel("Home");
		lblHome.setForeground(Color.BLACK);
		lblHome.setFont(new Font("Chiller", Font.BOLD | Font.ITALIC, 28));
		lblHome.setBounds(50, 115, 70, 25);
		contentPane.add(lblHome);

		lblAboutus = new JLabel("About us");
		lblAboutus.setForeground(Color.BLACK);
		lblAboutus.setFont(new Font("Chiller", Font.PLAIN, 18));
		lblAboutus.setBounds(140, 115, 100, 25);
		contentPane.add(lblAboutus);

		lblOurprog = new JLabel("Our programme");
		lblOurprog.setForeground(Color.BLACK);
		lblOurprog.setFont(new Font("Chiller", Font.PLAIN, 18));
		lblOurprog.setBounds(260, 115, 150, 25);
		contentPane.add(lblOurprog);

		lblContactus = new JLabel("Contact Us");
		lblContactus.setForeground(Color.BLACK);
		lblContactus.setFont(new Font("Chiller", Font.PLAIN, 18));
		lblContactus.setBounds(430, 115, 150, 25);
		contentPane.add(lblContactus);

		About1.setForeground(Color.BLACK);
		About1.setFont(new Font("Chiller", Font.BOLD, 48));
		About1.setBounds(60, 400, 50, 50);
		About1.setVisible(false);
		contentPane.add(About1);

		About2.setForeground(Color.BLACK);
		About2.setFont(new Font("Chiller", Font.BOLD, 48));
		About2.setBounds(210, 400, 50, 50);
		About2.setVisible(false);
		contentPane.add(About2);

		About3.setForeground(Color.BLACK);
		About3.setFont(new Font("Chiller", Font.BOLD, 48));
		About3.setBounds(360, 400, 50, 50);
		About3.setVisible(false);
		contentPane.add(About3);

		About4.setForeground(Color.BLACK);
		About4.setFont(new Font("Chiller", Font.BOLD, 48));
		About4.setBounds(510, 400, 50, 50);
		About4.setVisible(false);
		contentPane.add(About4);

		passwordField = new JPasswordField();
		passwordField.setEchoChar('*');
		passwordField.setForeground(Color.YELLOW);
		passwordField.setBackground(Color.BLACK);
		passwordField.setBounds(273, 246, 150, 30);
		contentPane.add(passwordField);

		txtusername = new JTextField();
		txtusername.setBackground(Color.BLACK);
		txtusername.setForeground(Color.YELLOW);
		txtusername.setBounds(273, 205, 150, 30);
		contentPane.add(txtusername);
		txtusername.setColumns(10);

		lblusername = new JLabel("Username");
		lblusername.setFont(new Font("Chiller", Font.BOLD | Font.ITALIC, 20));
		lblusername.setBounds(158, 213, 82, 25);
		contentPane.add(lblusername);

		lblpassword = new JLabel("Password");
		lblpassword.setFont(new Font("Chiller", Font.BOLD | Font.ITALIC, 20));
		lblpassword.setBounds(158, 250, 72, 22);
		contentPane.add(lblpassword);

		btnSignin = new JButton("Sign in");
		btnSignin.setFont(new Font("Chiller", Font.BOLD, 16));
		btnSignin.setBackground(Color.BLACK);
		btnSignin.setForeground(Color.YELLOW);
		btnSignin.setBounds(252, 288, 89, 23);
		contentPane.add(btnSignin);

		btnRegister = new JButton("Register");
		btnRegister.setFont(new Font("Chiller", Font.BOLD, 16));
		btnRegister.setBackground(Color.BLACK);
		btnRegister.setForeground(Color.YELLOW);
		btnRegister.setBounds(350, 288, 89, 23);
		contentPane.add(btnRegister);

		// register

		imgSelector = new JLabel();
		imgSelector.setForeground(Color.YELLOW);
		imgSelector.setBounds(10, 135, 650, 340);
		imgSelector.setIcon(new ImageIcon("img/Home.png"));
		contentPane.add(imgSelector);

		JLabel imgContainer = new JLabel();
		imgContainer.setIcon(new ImageIcon("img/Anezile_background.png"));
		imgContainer.setBounds(0, 0, 700, 470);
		contentPane.add(imgContainer);

		propEvent();
	}

	private void propEvent() {
		btnSignin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ConnectDB dbconn = new ConnectDB();
				// Login

				String username = txtusername.getText();
				@SuppressWarnings("deprecation")
				String password = passwordField.getText();

				try {

					if (username.trim()
							.equals(dbconn.userLogin(username.trim(), password.trim()).getUserName().trim())) {
						User user = new User();
						user = dbconn.userLogin(username.trim(), password.trim());
						Classroom frmclass = new Classroom(user);
						frmclass.setVisible(true);
						frame.setVisible(false);
					
					} else {
						txtusername.setText("");

						ErrorLogin dialog = new ErrorLogin();
						dialog.setModalityType(ModalityType.APPLICATION_MODAL);
						dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
						dialog.setVisible(true);
					}

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
		lblHome.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				lblHome.setFont(new Font("Chiller", Font.BOLD | Font.ITALIC, 32));
				lblAboutus.setFont(new Font("Chiller", Font.PLAIN, 18));
				lblOurprog.setFont(new Font("Chiller", Font.PLAIN, 18));
				lblContactus.setFont(new Font("Chiller", Font.PLAIN, 18));
				imgSelector.setIcon(new ImageIcon("img/Home.png"));
				passwordField.setVisible(true);
				txtusername.setVisible(true);
				lblusername.setVisible(true);
				lblpassword.setVisible(true);
				btnSignin.setVisible(true);
				btnRegister.setVisible(true);
				setaboutpage();
			}
		});

		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
//				ConnectDB dbconn = new ConnectDB();
				// Login

				Register dialog = new Register();
//				dialog.setModalityType(ModalityType.APPLICATION_MODAL);
				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog.setVisible(true);

			}
		});
		lblAboutus.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				lblAboutus.setFont(new Font("Chiller", Font.BOLD | Font.ITALIC, 28));
				lblHome.setFont(new Font("Chiller", Font.PLAIN, 18));
				lblOurprog.setFont(new Font("Chiller", Font.PLAIN, 18));
				lblContactus.setFont(new Font("Chiller", Font.PLAIN, 18));
				imgSelector.setIcon(new ImageIcon("imG/About 1.png"));
				About1.setVisible(true);
				About2.setVisible(true);
				About3.setVisible(true);
				About4.setVisible(true);
				sethomepage();
			}
		});
		lblContactus.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				lblContactus.setFont(new Font("Chiller", Font.BOLD | Font.ITALIC, 28));
				lblHome.setFont(new Font("Chiller", Font.PLAIN, 18));
				lblOurprog.setFont(new Font("Chiller", Font.PLAIN, 18));
				lblAboutus.setFont(new Font("Chiller", Font.PLAIN, 18));
				imgSelector.setIcon(new ImageIcon("img/Contact us.png"));
				setaboutpage();
				sethomepage();
			}
		});
		lblOurprog.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				lblOurprog.setFont(new Font("Chiller", Font.BOLD | Font.ITALIC, 28));
				lblHome.setFont(new Font("Chiller", Font.PLAIN, 18));
				lblContactus.setFont(new Font("Chiller", Font.PLAIN, 18));
				lblAboutus.setFont(new Font("Chiller", Font.PLAIN, 18));
				imgSelector.setIcon(new ImageIcon("img/Our programme.png"));
				setaboutpage();
				sethomepage();

			}
		});
		About1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				imgSelector.setIcon(new ImageIcon("img/About 1.png"));
			}
		});
		About2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				imgSelector.setIcon(new ImageIcon("img/About 2.png"));
			}
		});
		About3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				imgSelector.setIcon(new ImageIcon("img/About 3.png"));
			}
		});
		About4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				imgSelector.setIcon(new ImageIcon("img/About 4.png"));
			}
		});
	}

	private void sethomepage() {
		passwordField.setVisible(false);
		txtusername.setVisible(false);
		lblusername.setVisible(false);
		lblpassword.setVisible(false);
		btnSignin.setVisible(false);
		btnRegister.setVisible(false);
	}

	private void setaboutpage() {
		About1.setVisible(false);
		About2.setVisible(false);
		About3.setVisible(false);
		About4.setVisible(false);
	}
}
