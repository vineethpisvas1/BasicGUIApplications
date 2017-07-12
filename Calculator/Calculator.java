import java.awt.EventQueue;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

public class Calculator {

	private JFrame Calculator;
	private JTextField inputField1;
	private JTextField inputField2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calculator window = new Calculator();
					window.Calculator.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Calculator() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Calculator = new JFrame();
		ImageIcon img = new ImageIcon("C:\\Users\\Vineeth\\Java\\IDE\\CalculatorGUI\\src\\calculator.png");
		Calculator.setIconImage(img.getImage());
		Calculator.setTitle("Calculator by VINEETH");
		Calculator.getContentPane().setFont(new Font("Calibri", Font.PLAIN, 12));
		Calculator.setBounds(100, 100, 640, 333);
		Calculator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Calculator.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Contact author");
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,"Name:     Vineeth Karanam\nE-mail:    vineethpisvas1@gmail.com");
			}
		});
		btnNewButton.setBounds(448, 253, 126, 23);
		Calculator.getContentPane().add(btnNewButton);
		
		JLabel lblAnswer = new JLabel("");
		lblAnswer.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAnswer.setBounds(137, 154, 437, 38);
		Calculator.getContentPane().add(lblAnswer);
		
		inputField1 = new JTextField();
		inputField1.setBounds(137, 35, 86, 20);
		Calculator.getContentPane().add(inputField1);
		inputField1.setColumns(10);
		
		inputField2 = new JTextField();
		inputField2.setBounds(137, 66, 86, 20);
		Calculator.getContentPane().add(inputField2);
		inputField2.setColumns(10);
		
		JLabel lblInput1 = new JLabel("Input 1 :");
		lblInput1.setBounds(52, 35, 62, 20);
		Calculator.getContentPane().add(lblInput1);
		
		JLabel lblInput2 = new JLabel("Input 2 :");
		lblInput2.setBounds(52, 66, 62, 20);
		Calculator.getContentPane().add(lblInput2);
		
		JLabel lblAnswer1 = new JLabel("Answer :");
		lblAnswer1.setBounds(52, 162, 63, 20);
		Calculator.getContentPane().add(lblAnswer1);
		
		JLabel lblOperation = new JLabel("Operation :");
		lblOperation.setBounds(52, 121, 62, 20);
		Calculator.getContentPane().add(lblOperation);
		
		JButton addButton = new JButton("Add");
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) throws NumberFormatException {
				try{
					double answer = Double.parseDouble(inputField1.getText()) + Double.parseDouble(inputField2.getText());
					lblAnswer.setText(Double.toString(answer));
				} catch(Exception e1) {
					JOptionPane.showMessageDialog(null, "Please enter a valid number.");
					inputField1.setText("");
					inputField2.setText("");
					lblAnswer.setText("");
				}
			}
		});
		addButton.setBounds(134, 120, 89, 23);
		Calculator.getContentPane().add(addButton);
		
		JButton subtractButton = new JButton("Subtract");
		subtractButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					double answer = Double.parseDouble(inputField1.getText()) - Double.parseDouble(inputField2.getText());
					lblAnswer.setText(Double.toString(answer));
				} catch(Exception e1) {
					JOptionPane.showMessageDialog(null, "Please enter a valid number.");
					inputField1.setText("");
					inputField2.setText("");
					lblAnswer.setText("");
				}
			}
		});
		subtractButton.setBounds(233, 120, 86, 23);
		Calculator.getContentPane().add(subtractButton);
		
		JButton multiplyButton = new JButton("Multiply");
		multiplyButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					double answer = Double.parseDouble(inputField1.getText()) * Double.parseDouble(inputField2.getText());
					lblAnswer.setText(Double.toString(answer));
				} catch(Exception e1) {
					JOptionPane.showMessageDialog(null, "Please enter a valid number.");
					inputField1.setText("");
					inputField2.setText("");
					lblAnswer.setText("");
				}
			}
		});
		multiplyButton.setBounds(329, 120, 86, 23);
		Calculator.getContentPane().add(multiplyButton);
		
		JButton divideButton = new JButton("Divide");
		divideButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					double answer = Double.parseDouble(inputField1.getText()) / Double.parseDouble(inputField2.getText());
					lblAnswer.setText(Double.toString(answer));
				} catch(Exception e1) {
					JOptionPane.showMessageDialog(null, "Please enter a valid number.");
					inputField1.setText("");
					inputField2.setText("");
					lblAnswer.setText("");
				}
			}
		});
		divideButton.setBounds(425, 120, 86, 23);
		Calculator.getContentPane().add(divideButton);
		
		JButton btnCe = new JButton("Clear");
		btnCe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inputField1.setText("");
				inputField2.setText("");
				lblAnswer.setText("");
			}
		});
		btnCe.setBounds(521, 120, 89, 23);
		Calculator.getContentPane().add(btnCe);
	}
}
