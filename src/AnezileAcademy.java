import java.awt.EventQueue;
import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AnezileAcademy {

	private JFrame frame;


//	 Launch the application.
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AnezileAcademy window = new AnezileAcademy();
					window.frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// Create the application.
	public AnezileAcademy() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Anezile Academy");
		frame.setResizable(false);
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("img/Anezile_icon.PNG"));
		frame.setBounds(100, 100, 528, 306);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setBackground(Color.YELLOW);
		
		JLabel lblClickHereTo = new JLabel("Click here to continue...");
		lblClickHereTo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Campus frmcampus = new Campus();
				frmcampus.setfrm();
				frame.dispose();
				}
		});
		lblClickHereTo.setForeground(Color.BLACK);
		lblClickHereTo.setFont(new Font("Chiller", Font.BOLD, 18));
		lblClickHereTo.setBounds(182, 211, 165, 22);
		frame.getContentPane().add(lblClickHereTo);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("img/Anezile_welcome.jpg"));
		label.setBounds(0, 0, 525, 284);
		frame.getContentPane().add(label);
	}
}
