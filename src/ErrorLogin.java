import javax.swing.JButton;
import javax.swing.JDialog;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import java.awt.Font;

public class ErrorLogin extends JDialog {

	private static final long serialVersionUID = 1L;
	 
	public ErrorLogin() {
		getContentPane().setBackground(Color.YELLOW);
		setBounds(100, 100, 469, 190);
		getContentPane().setLayout(null);
		{
			JLabel lblPleaseEnterCorrect = new JLabel("PLEASE ENTER CORRECT  DETAILS");
			lblPleaseEnterCorrect.setFont(new Font("Chiller", Font.BOLD | Font.ITALIC, 30));
			lblPleaseEnterCorrect.setBounds(10, 34, 432, 48);
			getContentPane().add(lblPleaseEnterCorrect);
			lblPleaseEnterCorrect.setHorizontalAlignment(SwingConstants.CENTER);
		}
		{
			JButton cancelButton = new JButton("Close");
			cancelButton.setFont(new Font("Chiller", Font.BOLD, 20));
			cancelButton.setBackground(Color.BLACK);
			cancelButton.setForeground(Color.YELLOW);
			cancelButton.setBounds(197, 93, 69, 35);
			getContentPane().add(cancelButton);
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
