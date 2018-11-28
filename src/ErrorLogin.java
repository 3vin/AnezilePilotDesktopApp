import java.awt.BorderLayout;
import java.awt.FlowLayout;

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

public class ErrorLogin extends JDialog {

	private static final long serialVersionUID = 1L;

	
	//Create the dialog.
	 
	public ErrorLogin() {
		getContentPane().setBackground(Color.YELLOW);
		setBounds(100, 100, 490, 223);
		getContentPane().setLayout(null);
		{
			JLabel lblPleaseEnterCorrect = new JLabel("PLEASE ENTER CORRECT  DETAILS");
			lblPleaseEnterCorrect.setFont(new Font("Chiller", Font.BOLD | Font.ITALIC, 30));
			lblPleaseEnterCorrect.setBounds(24, 60, 432, 48);
			getContentPane().add(lblPleaseEnterCorrect);
			lblPleaseEnterCorrect.setHorizontalAlignment(SwingConstants.CENTER);
		}
		{
			JButton cancelButton = new JButton("Close");
			cancelButton.setForeground(Color.YELLOW);
			cancelButton.setBounds(193, 130, 59, 31);
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
