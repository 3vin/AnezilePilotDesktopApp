import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;

public class ConfirmRegister extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();


	 // Create the dialog.
	 
	public ConfirmRegister() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("/img/Anezile_icon.PNG"));
		setBounds(100, 100, 456, 212);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.YELLOW);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblPleaseEnterCorrect = new JLabel("User Registered , Go sign In");
			lblPleaseEnterCorrect.setBounds(40, 41, 347, 41);
			lblPleaseEnterCorrect.setFont(new Font("Chiller", Font.BOLD | Font.ITALIC, 30));
			lblPleaseEnterCorrect.setHorizontalAlignment(SwingConstants.CENTER);
			contentPanel.add(lblPleaseEnterCorrect);
		}
		{
			JButton cancelButton = new JButton("Close");
			cancelButton.setBackground(Color.BLACK);
			cancelButton.setForeground(Color.YELLOW);
			cancelButton.setBounds(194, 125, 59, 23);
			contentPanel.add(cancelButton);
			cancelButton.setHorizontalAlignment(SwingConstants.RIGHT);
			cancelButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					 dispose();
				}
			});
			cancelButton.setActionCommand("Cancel");
		}
	}

}
