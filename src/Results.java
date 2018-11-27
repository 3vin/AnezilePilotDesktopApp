import java.awt.BorderLayout;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Results extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;


	/**
	 * Create the frame.
	 */
	public Results() {
		super("Anezile academy");
		setIconImage(Toolkit.getDefaultToolkit().getImage(".\\img\\Anezile icon.PNG"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 690, 505);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JLabel imgContainer = new JLabel();
		imgContainer.setIcon(new ImageIcon(".\\img\\Anezile background.png"));
		imgContainer.setBounds(0, 0, 685, 470);
		contentPane.add(imgContainer);
	}

}
