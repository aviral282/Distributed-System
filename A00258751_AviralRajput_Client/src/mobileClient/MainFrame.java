package mobileClient;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URISyntaxException;
import java.awt.event.ActionEvent;

public class MainFrame extends JFrame {

	private JFrame frame;
	private JTextField text_id;
	private JTextField text_name;
	private JTextField text_price;
	private JTextField text_des;
	MobileOperations mob = new MobileOperations();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame window = new MainFrame();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainFrame() {
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 504, 420);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblMobileId = new JLabel("Mobile ID");
		lblMobileId.setBounds(80, 86, 106, 16);
		frame.getContentPane().add(lblMobileId);

		JLabel lblMobileName = new JLabel("Mobile Name");
		lblMobileName.setBounds(80, 121, 106, 16);
		frame.getContentPane().add(lblMobileName);

		JLabel lblMobilePrice = new JLabel("Mobile Price");
		lblMobilePrice.setBounds(80, 150, 106, 16);
		frame.getContentPane().add(lblMobilePrice);

		JLabel lblMobileDescription = new JLabel("Mobile Description");
		lblMobileDescription.setBounds(80, 179, 125, 16);
		frame.getContentPane().add(lblMobileDescription);

		text_id = new JTextField();
		text_id.setBounds(304, 83, 116, 22);
		frame.getContentPane().add(text_id);
		text_id.setColumns(10);

		text_name = new JTextField();
		text_name.setBounds(304, 118, 116, 22);
		frame.getContentPane().add(text_name);
		text_name.setColumns(10);

		text_price = new JTextField();
		text_price.setBounds(304, 147, 116, 22);
		frame.getContentPane().add(text_price);
		text_price.setColumns(10);

		text_des = new JTextField();
		text_des.setBounds(304, 176, 116, 22);
		frame.getContentPane().add(text_des);
		text_des.setColumns(10);

		JButton btnInsert = new JButton("Insert");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					mob.insermobile(Integer.parseInt(text_id.getText()), text_name.getText(),
							Integer.parseInt(text_price.getText()), text_des.getText());
					JOptionPane.showMessageDialog(null, "Inserted");
				} catch (NumberFormatException | URISyntaxException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				text_id.setText("");
				text_name.setText("");
				text_price.setText("");
				text_des.setText("");
			}
		});
		btnInsert.setBounds(49, 229, 97, 25);
		frame.getContentPane().add(btnInsert);

		JButton btnUpate = new JButton("Upate");
		btnUpate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					mob.updatemobile(Integer.parseInt(text_id.getText()), text_name.getText(),
							Integer.parseInt(text_price.getText()), text_des.getText());
					JOptionPane.showMessageDialog(null, "Updated");
				} catch (NumberFormatException | URISyntaxException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				text_id.setText("");
				text_name.setText("");
				text_price.setText("");
				text_des.setText("");
			}
		});
		btnUpate.setBounds(191, 229, 97, 25);
		frame.getContentPane().add(btnUpate);

		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					mob.deletemobile(Integer.parseInt(text_id.getText()));
					JOptionPane.showMessageDialog(null, "Deleted");
				} catch (NumberFormatException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				text_id.setText("");
			}
		});
		btnDelete.setBounds(334, 229, 97, 25);
		frame.getContentPane().add(btnDelete);

		JButton btnShowReport = new JButton("Show Report");
		btnShowReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Generate();
				frame.dispose();
			}
		});
		btnShowReport.setBounds(163, 267, 216, 25);
		frame.getContentPane().add(btnShowReport);

		JLabel lblMyMobileShop = new JLabel("My Mobile Shop ");
		lblMyMobileShop.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblMyMobileShop.setBounds(212, 29, 229, 41);
		frame.getContentPane().add(lblMyMobileShop);
	}

}
