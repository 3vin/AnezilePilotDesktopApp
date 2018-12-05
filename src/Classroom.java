import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.border.LineBorder;
import Model.User;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;

public class Classroom extends JFrame {

	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JButton btnBack;
	public JPanel pnlmethod;
	public JPanel pnladd;
	public JPanel pnlsub;
	public JPanel pnlmul;
	public JPanel pnldiv;	
	private JLabel lbldavlabel;
	private JLabel lblstatement;
	private JLabel lblplus;
	private JLabel lbldivide;
	private JLabel lbltimes;
	private JLabel lblminus;
	private JLabel lblhello;
	private JTextField txtans1;
	private JTextField txtans2;
	private JTextField txtans3;
	private JTextField txtans4;
	private JButton btnSubmit;
	private JLabel lblquestion;
	private JButton btnDisplayTheFirst;
	private JButton btnNewButton;
	private JLabel lblQuestion;
	private String setMethod;
	JLabel lblComputerBox;
	JLabel lbllearner;		
	@SuppressWarnings("rawtypes")
	JList listcomputer;
	@SuppressWarnings("rawtypes")
	JList listlearner;
//	private User user;

	// Create the frame.
	@SuppressWarnings("rawtypes")
	public Classroom(User user) {
		super("Anezile academy");
		setIconImage(Toolkit.getDefaultToolkit().getImage("img/Anezile_icon.PNG"));
		setResizable(false);
		setBounds(100, 100, 690, 505);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(Color.YELLOW);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		pnlsub = new JPanel();
		pnladd = new JPanel();
		pnlmul = new JPanel();
		pnldiv = new JPanel();
		txtans1 = new JTextField();
		txtans2 = new JTextField();
		txtans3 = new JTextField();
		txtans4 = new JTextField();
		btnSubmit = new JButton("Submit");
		btnSubmit.setBackground(Color.BLACK);
		btnSubmit.setForeground(Color.YELLOW);
		btnSubmit.setFont(new Font("Chiller", Font.BOLD, 22));
		lblquestion = new JLabel();
		lblQuestion = new JLabel("Question");
		lblComputerBox = new JLabel("Computer Box");
		lbllearner = new JLabel("Learner Box");		
		listcomputer = new JList();
		listlearner = new JList();
		btnDisplayTheFirst = new JButton("Generate next question");
		btnDisplayTheFirst.setBackground(Color.BLACK);
		btnDisplayTheFirst.setForeground(Color.YELLOW);
		btnDisplayTheFirst.setFont(new Font("Chiller", Font.PLAIN, 18));
		btnNewButton = new JButton("Provide next question");
		btnNewButton.setBackground(Color.BLACK);
		btnNewButton.setForeground(Color.YELLOW);
		btnNewButton.setFont(new Font("Chiller", Font.PLAIN, 18));
//		this.user =user;
		
		lblhello = new JLabel("Hello "+ user.getFirstName() + " " + user.getLastName()+", All the best with you excerises");
		lblhello.setForeground(Color.BLACK);
		lblhello.setFont(new Font("Chiller", Font.BOLD, 28));
		lblhello.setBounds(53, 114, 470, 60);
		contentPane.add(lblhello);
		methodselector();
		
		JLabel imgContainer = new JLabel();
		imgContainer.setBounds(0, 0, 700, 470);
		contentPane.add(imgContainer);
		imgContainer.setIcon(new ImageIcon("img/Anezile_background.png"));
		
		labelEvent();
		calculationpnl();
	}
	
	//method for picking which method of calculation to use
	void methodselector()	{
		
		pnlmethod = new JPanel();
		pnlmethod.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		pnlmethod.setBackground(Color.YELLOW);
		pnlmethod.setForeground(Color.YELLOW);
		pnlmethod.setBounds(10, 165, 654, 290);
		contentPane.add(pnlmethod);
		pnlmethod.setLayout(null);
		
		lbldavlabel = new JLabel("DIVISION");
		lbldavlabel.setBounds(474, 118, 141, 47);
		pnlmethod.add(lbldavlabel);
		lbldavlabel.setForeground(Color.BLACK);
		lbldavlabel.setFont(new Font("Chiller", Font.BOLD, 40));
		
		JLabel lblmullabel = new JLabel("MULTIPLUCATION");
		lblmullabel.setBounds(228, 195, 272, 47);
		pnlmethod.add(lblmullabel);
		lblmullabel.setForeground(Color.BLACK);
		lblmullabel.setFont(new Font("Chiller", Font.BOLD, 40));
		lblmullabel.setBackground(Color.BLACK);
		
		JLabel lblsublabel = new JLabel("SUBTRACTION");
		lblsublabel.setBounds(132, 91, 214, 47);
		pnlmethod.add(lblsublabel);
		lblsublabel.setForeground(Color.BLACK);
		lblsublabel.setFont(new Font("Chiller", Font.BOLD, 40));
		
		JLabel lbladdlabel = new JLabel("ADDITION");
		lbladdlabel.setBounds(22, 181, 152, 47);
		pnlmethod.add(lbladdlabel);
		lbladdlabel.setForeground(Color.BLACK);
		lbladdlabel.setFont(new Font("Chiller", Font.BOLD, 40));

		lblstatement = new JLabel("Please click which math method you want to learn");
		lblstatement.setForeground(Color.BLACK);
		lblstatement.setBounds(85, 18, 415, 29);
		pnlmethod.add(lblstatement);
		lblstatement.setFont(new Font("Chiller", Font.BOLD, 24));

		lblplus = new JLabel("+");
		lblplus.setBounds(48, 118, 70, 75);
		pnlmethod.add(lblplus);
		lblplus.setForeground(Color.BLACK);
		lblplus.setFont(new Font("Chiller", Font.BOLD, 99));

		lbldivide = new JLabel("÷");
		lbldivide.setBounds(459, 46, 100, 75);
		pnlmethod.add(lbldivide);
		lbldivide.setForeground(Color.BLACK);
		lbldivide.setFont(new Font("Chiller", Font.BOLD, 99));
		
		lbltimes = new JLabel("x");
		lbltimes.setBounds(375, 118, 78, 60);
		pnlmethod.add(lbltimes);
		lbltimes.setForeground(Color.BLACK);
		lbltimes.setFont(new Font("Chiller", Font.BOLD, 99));

		lblminus = new JLabel("-");
		lblminus.setBounds(201, 28, 78, 81);
		pnlmethod.add(lblminus);
		lblminus.setForeground(Color.BLACK);
		lblminus.setFont(new Font("Chiller", Font.BOLD, 99));
		
		btnBack = new JButton("Back");
		btnBack.setBounds(555, 131, 109, 26);
		btnBack.setBackground(Color.BLACK);
		btnBack.setForeground(Color.YELLOW);
		btnBack.setFont(new Font("Chiller", Font.PLAIN, 24));
		btnBack.setVisible(false);
		contentPane.add(btnBack);
		
	}
	//method for label event
	void labelEvent() {
		lblplus.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				pnlmethod.setVisible(false);
				btnBack.setVisible(true);
				additionpnl();
				lblhello.setText("Click the button to go back ->");
				pnlsub.setVisible(false);
				setMethod = "+";
				}
				@Override				
				public void mouseEntered(MouseEvent arg0) {
					lblplus.setText("start new plus exercise");
					lblplus.setFont(new Font("Chiller", Font.PLAIN, 30));
					lblplus.setBounds(48, 118, 200, 75);
					pnlmethod.setBackground(Color.BLACK);
					lblplus.setForeground(Color.YELLOW);
					lblstatement.setForeground(Color.YELLOW);
				}
				@Override
				public void mouseExited(MouseEvent arg0) {
					lblplus.setText("+");
					lblplus.setFont(new Font("Chiller", Font.PLAIN, 99));
					lblplus.setBounds(48, 118, 70, 75);
					pnlmethod.setBackground(Color.YELLOW);
					lblplus.setForeground(Color.BLACK);
					lblstatement.setForeground(Color.BLACK);
				}
		});
		lbldivide.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				pnlmethod.setVisible(false);
				btnBack.setVisible(true);
				pnladd.setVisible(false);
				pnlsub.setVisible(false);
				lblhello.setText("Click the button to go back ->");
				setMethod = "÷";
				}
				@Override				
				public void mouseEntered(MouseEvent arg0) {
					lbldivide.setText("start new divide exercise");
					lbldivide.setFont(new Font("Chiller", Font.PLAIN, 28));
					lbldivide.setBounds(400, 46, 250, 75);
					pnlmethod.setBackground(Color.BLACK);
					lbldivide.setForeground(Color.YELLOW);
					lblstatement.setForeground(Color.YELLOW);
				}
				@Override
				public void mouseExited(MouseEvent arg0) {
					lbldivide.setText("÷");
					lbldivide.setFont(new Font("Chiller", Font.PLAIN, 99));
					lbldivide.setBounds(500, 46, 100, 75);
					pnlmethod.setBackground(Color.YELLOW);
					lbldivide.setForeground(Color.BLACK);
					lblstatement.setForeground(Color.BLACK);
				}
			
		});
		lbltimes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				pnlmethod.setVisible(false);
				btnBack.setVisible(true);
				pnladd.setVisible(false);
				pnlsub.setVisible(false);
				lblhello.setText("Multiplication exercises");
				setMethod = "x";
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
				lbltimes.setText("start new times exercise");
				lbltimes.setFont(new Font("Chiller", Font.PLAIN, 28));
				lbltimes.setBounds(320, 130, 250, 75);
				pnlmethod.setBackground(Color.BLACK);
				lbltimes.setForeground(Color.YELLOW);
				lblstatement.setForeground(Color.YELLOW);
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				lbltimes.setText("x");
				lbltimes.setFont(new Font("Chiller", Font.PLAIN, 99));
				lbltimes.setBounds(320, 130, 100, 75);
				pnlmethod.setBackground(Color.YELLOW);
				lbltimes.setForeground(Color.BLACK);
				lblstatement.setForeground(Color.BLACK);
			}
		});
		lblminus.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				pnlmethod.setVisible(false);
				btnBack.setVisible(true);
				pnladd.setVisible(false);
				lblhello.setText("Substration Exercises");
				subtractionpnl();
				setMethod = "-";
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
				lblminus.setText("start new minus exercise");
				lblminus.setFont(new Font("Chiller", Font.PLAIN, 28));
				lblminus.setBounds(200, 40, 250, 50);
				pnlmethod.setBackground(Color.BLACK);
				lblminus.setForeground(Color.YELLOW);
				lblstatement.setForeground(Color.YELLOW);
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				lblminus.setText("-");
				lblminus.setFont(new Font("Chiller", Font.PLAIN, 99));
				lblminus.setBounds(200, 40, 100, 50);
				pnlmethod.setBackground(Color.YELLOW);
				lblminus.setForeground(Color.BLACK);
				lblstatement.setForeground(Color.BLACK);
			}
		});
	}
	
	//method for the calculation panel	
	void calculationpnl() {
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String test = lblhello.getText();
				
				if (test.equals("Click button to continue with exercise ->")) {
					pnlmethod.setVisible(false);
					if (setMethod.equals("+")){
						pnladd.setVisible(true);
						pnlsub.setVisible(false);
						lblhello.setText("Addition exercise. Good luck!");
					}
					else if (setMethod.equals("-")){
						pnladd.setVisible(false);
						pnlsub.setVisible(true);
						lblhello.setText("Substruction exercise. Good luck!");
					}
					else if (setMethod.equals("x")){
						pnladd.setVisible(false);
						pnlsub.setVisible(false);
						lblhello.setText("Multiplicatio exercise. Good luck!");
					}
					else if (setMethod.equals("÷")){
						pnladd.setVisible(false);
						pnlsub.setVisible(false);
						lblhello.setText("Division exercise. Good luck!");
					}

				}
				else {
					pnlmethod.setVisible(true);
					pnladd.setVisible(false);
					pnlsub.setVisible(false);
					lblhello.setText("Click  button  to  continue with exercise ->");
				}
			}
		});
		
		
	}
	//addition method
	void additionpnl() {
		pnladd.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		pnladd.setBackground(Color.YELLOW);
		pnladd.setForeground(Color.YELLOW);
		pnladd.setBounds(10, 165, 654, 290);
		pnladd.setVisible(true);
		contentPane.add(pnladd);
		pnladd.setLayout(null);
		
		btnDisplayTheFirst.setBounds(30, 10, 188, 25);
		btnDisplayTheFirst.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lblquestion.setText("");
				txtans1.setText("=");
				txtans2.setText("=");
				txtans3.setText("=");
				txtans4.setText("=");
			}
		});
		pnladd.add(btnDisplayTheFirst);
		
		btnNewButton.setBounds(30, 50, 188, 25);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String fnum = JOptionPane.showInputDialog("Enter first number");
				String Snum = JOptionPane.showInputDialog("Enter Second number");
				lblquestion.setText(fnum + "+" + Snum);
				txtans1.setText("=");
				txtans2.setText("=");
				txtans3.setText("=");
				txtans4.setText("=");
			}
		});
		pnladd.add(btnNewButton);
		
		lblQuestion.setBounds(30, 80, 60, 20);
		pnladd.add(lblQuestion);
		
		lblquestion.setText("E.g. : 123 + 456");
		lblquestion.setForeground(Color.BLACK);
		lblquestion.setFont(new Font("Chiller", Font.PLAIN, 30));
		lblquestion.setBounds(30, 110, 188, 40);
		pnladd.add(lblquestion);
		
		txtans1.setBackground(Color.BLACK);
		txtans1.setForeground(Color.YELLOW);
		txtans1.setText("=(100 + 400) + (20 + 50) + (3 + 6)");
		txtans1.setBounds(30, 150, 200, 20);
		pnladd.add(txtans1);
		txtans1.setColumns(10);
		
		txtans2.setBackground(Color.BLACK);
		txtans2.setForeground(Color.YELLOW);
		txtans2.setText("=500 + 70 + 9");
		txtans2.setBounds(30, 170, 200, 20);
		pnladd.add(txtans2);
		txtans2.setColumns(10);
		
		txtans3.setBackground(Color.BLACK);
		txtans3.setForeground(Color.YELLOW);
		txtans3.setText("=579");
		txtans3.setBounds(30, 190, 200, 20);
		pnladd.add(txtans3);
		txtans3.setColumns(10);
		
		txtans4.setBackground(Color.BLACK);
		txtans4.setForeground(Color.YELLOW);
		txtans4.setBounds(30, 210, 200, 20);
		pnladd.add(txtans4);
		txtans4.setColumns(10);
		
		btnSubmit.setBounds(30, 240, 200, 23);
		pnladd.add(btnSubmit);
		
		listlearner.setValueIsAdjusting(true);
		listlearner.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		listlearner.setBackground(Color.YELLOW);
		listlearner.setBounds(420, 170, 221, 114);
		pnladd.add(listlearner);

		listcomputer.setValueIsAdjusting(true);
		listcomputer.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		listcomputer.setBackground(Color.YELLOW);
		listcomputer.setBounds(420, 30, 221, 114);
		pnladd.add(listcomputer);

		lbllearner.setFont(new Font("Chiller", Font.BOLD, 24));
		lbllearner.setBounds(420, 150, 138, 25);
		lbllearner.setForeground(Color.BLACK);
		pnladd.add(lbllearner);
		
		lblComputerBox.setFont(new Font("Chiller", Font.BOLD, 24));
		lblComputerBox.setBounds(420, 5, 159, 29);
		lblComputerBox.setForeground(Color.BLACK);
		pnladd.add(lblComputerBox);
	}
	//subtraction method
	void subtractionpnl() {
		pnlsub.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		pnlsub.setBackground(Color.YELLOW);
		pnlsub.setForeground(Color.YELLOW);
		pnlsub.setBounds(10, 165, 654, 290);
		pnlsub.setVisible(true);
		contentPane.add(pnlsub);
		pnlsub.setLayout(null);
		
		lblquestion.setText("E.g. : 654 - 321");
		lblquestion.setFont(new Font("Chiller", Font.PLAIN, 30));
		lblquestion.setBounds(30, 30, 188, 42);
		lblquestion.setForeground(Color.BLACK);
		pnlsub.add(lblquestion);
		
		btnDisplayTheFirst.setBounds(231, 11, 163, 23);
		btnDisplayTheFirst.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lblquestion.setText("Substract");
				txtans1.setText("=");
				txtans2.setText("=");
				txtans3.setText("=");
				txtans4.setText("=");
			}
		});
		pnlsub.add(btnDisplayTheFirst);

		btnNewButton.setBounds(231, 44, 163, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String fnum = JOptionPane.showInputDialog("Enter first number");
				String Snum = JOptionPane.showInputDialog("Enter Second number");
				lblquestion.setText(fnum + "+" + Snum);
				txtans1.setText("=");
				txtans2.setText("=");
				txtans3.setText("=");
				txtans4.setText("=");
			}
		});
		pnlsub.add(btnNewButton);

		lblQuestion.setBounds(30, 15, 60, 30);
		lblQuestion.setForeground(Color.BLACK);
		pnlsub.add(lblQuestion);
		
		txtans1.setBackground(Color.BLACK);
		txtans1.setForeground(Color.YELLOW);
		txtans1.setText("=(600 - 300) + (50 - 20) + (4 - 1)");
		txtans1.setBounds(30, 80, 200, 20);
		pnlsub.add(txtans1);
		txtans1.setColumns(10);
		
		txtans2.setBackground(Color.BLACK);
		txtans2.setForeground(Color.YELLOW);
		txtans2.setText("=300 + 30 + 3");
		txtans2.setBounds(30, 100, 200, 20);
		pnlsub.add(txtans2);
		txtans2.setColumns(10);
		
		txtans3.setBackground(Color.BLACK);
		txtans3.setForeground(Color.YELLOW);
		txtans3.setText("=333");
		txtans3.setBounds(30, 120, 200, 20);
		pnlsub.add(txtans3);
		txtans3.setColumns(10);
		
		txtans4.setBackground(Color.BLACK);
		txtans4.setForeground(Color.YELLOW);
		txtans4.setBounds(30, 140, 200, 20);
		pnlsub.add(txtans4);
		txtans4.setColumns(10);
		
		btnSubmit.setBounds(30, 167, 89, 23);
		pnlsub.add(btnSubmit);

		listlearner.setValueIsAdjusting(true);
		listlearner.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		listlearner.setBackground(Color.YELLOW);
		listlearner.setBounds(420, 170, 221, 114);
		pnlsub.add(listlearner);

		listcomputer.setValueIsAdjusting(true);
		listcomputer.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		listcomputer.setBackground(Color.YELLOW);
		listcomputer.setBounds(420, 40, 221, 114);
		pnlsub.add(listcomputer);

		lbllearner.setFont(new Font("Chiller", Font.BOLD, 24));
		lbllearner.setBounds(420, 150, 138, 25);
		lbllearner.setForeground(Color.BLACK);
		pnlsub.add(lbllearner);
		
		
		lblComputerBox.setFont(new Font("Chiller", Font.BOLD, 24));
		lblComputerBox.setBounds(420, 5, 159, 29);
		lblComputerBox.setForeground(Color.BLACK);
		pnlsub.add(lblComputerBox);
	}
}
