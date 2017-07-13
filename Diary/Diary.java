import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class Diary {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Diary window = new Diary();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	Connection connection = null;
	private JTextField usernameField;
	private JPasswordField passwordField;
	private JTextField nameField;
	private JTextField usernameField1;
	private JPasswordField passwordField1;
	private JTextField ageField;
	/**
	 * Create the application.
	 * @throws Exception 
	 */
	public Diary(){
		initialize();
		connection = sqliteConnection.dbConnector();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 701, 461);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 11, 665, 400);
		frame.getContentPane().add(tabbedPane);
		
		JPanel login = new JPanel();
		tabbedPane.addTab("Login", null, login, null);
		login.setLayout(null);
		
		JLabel lblLogin = new JLabel("LOGIN");
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setBounds(273, 24, 94, 47);
		login.add(lblLogin);
		lblLogin.setFont(new Font("Garamond", Font.BOLD, 18));
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setBounds(218, 113, 65, 14);
		login.add(lblUsername);
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		usernameField = new JTextField();
		usernameField.setBounds(308, 111, 111, 20);
		login.add(usernameField);
		usernameField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(308, 142, 111, 20);
		login.add(passwordField);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(218, 144, 65, 14);
		login.add(lblPassword);
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(318, 173, 89, 23);
		login.add(btnLogin);
		
		JPanel signUp = new JPanel();
		tabbedPane.addTab("SignUp", null, signUp, null);
		signUp.setLayout(null);
		
		JLabel lblSignup = new JLabel("SIGNUP");
		lblSignup.setHorizontalAlignment(SwingConstants.CENTER);
		lblSignup.setFont(new Font("Garamond", Font.BOLD, 18));
		lblSignup.setBounds(263, 23, 94, 47);
		signUp.add(lblSignup);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblName.setBounds(199, 83, 65, 14);
		signUp.add(lblName);
		
		nameField = new JTextField();
		nameField.setColumns(10);
		nameField.setBounds(289, 81, 111, 20);
		signUp.add(nameField);
		
		JLabel lblAge = new JLabel("Age:");
		lblAge.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblAge.setBounds(199, 114, 65, 14);
		signUp.add(lblAge);
		
		JLabel lblUsername1 = new JLabel("Username:");
		lblUsername1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblUsername1.setBounds(199, 141, 65, 14);
		signUp.add(lblUsername1);
		
		usernameField1 = new JTextField();
		usernameField1.setColumns(10);
		usernameField1.setBounds(289, 139, 111, 20);
		signUp.add(usernameField1);
		
		JLabel lblPassword1 = new JLabel("Password:");
		lblPassword1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPassword1.setBounds(199, 172, 65, 14);
		signUp.add(lblPassword1);
		
		passwordField1 = new JPasswordField();
		passwordField1.setBounds(289, 170, 111, 20);
		signUp.add(passwordField1);
		
		JButton btnCreateAccount = new JButton("Create account");
		btnCreateAccount.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				try {
					String testQuery = "SELECT * FROM Login WHERE username=?";
					PreparedStatement testpst = connection.prepareStatement(testQuery);
					testpst.setString(1, usernameField1.getText());
					ResultSet testrs = testpst.executeQuery();
					if(testrs.next()) {
						JOptionPane.showMessageDialog(null, "Username has already been taken!");
						usernameField1.setText("");
						passwordField1.setText("");
					} else {
						String query = "INSERT INTO Login (name, username, password, age) VALUES (?, ?, ?, ?)";
						PreparedStatement pst = connection.prepareStatement(query);
						pst.setString(1, nameField.getText());
						pst.setString(2, usernameField1.getText());
						pst.setString(3, passwordField1.getText());
						pst.setInt(4, Integer.parseInt(ageField.getText()));
						pst.executeUpdate();
						JOptionPane.showMessageDialog(null, "Account has been created!");
						nameField.setText("");
						ageField.setText("");
						usernameField1.setText("");
						passwordField1.setText("");
						pst.close();
					}
					testpst.close();
					testrs.close();
				} catch(Exception e2) {
					JOptionPane.showMessageDialog(null, e2);
				}
			}
		});
		btnCreateAccount.setBounds(289, 201, 123, 23);
		signUp.add(btnCreateAccount);
		
		ageField = new JTextField();
		ageField.setColumns(10);
		ageField.setBounds(289, 112, 111, 20);
		signUp.add(ageField);
		btnLogin.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				try {
					String query = "SELECT * FROM Login WHERE username=? AND password=?";
					PreparedStatement pst = connection.prepareStatement(query);
					pst.setString(1, usernameField.getText());
					pst.setString(2, passwordField.getText());
					ResultSet rs = pst.executeQuery();
					if(rs.next()) {
						JOptionPane.showMessageDialog(null, "Login successful!!");
						usernameField.setText("");
						passwordField.setText("");
					} else {
						JOptionPane.showMessageDialog(null, "Incorrect credentials!!");
						usernameField.setText("");
						passwordField.setText("");
					}
					rs.close();
					pst.close();
				} catch(Exception e1) {
					JOptionPane.showMessageDialog(null, e1);
				}
			}
		});
	}
}
