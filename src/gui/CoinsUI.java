package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Observable;
import java.util.Observer;
import coinmachine.*;

/**
 * Coins User Interface
 * @author Patipol Wangjaitham
 *
 */
public class CoinsUI extends JFrame implements Observer{
	private JTextField textField;
	private int currentBalance = 0;
	private JPanel panel;
	private JLabel coins, accept;
	/**
	 * Create the application.
	 */
	public CoinsUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		initialize();
	}
	/**
	 * Launch the application.
	 */
	public void run(){
		pack();
		setBounds(100, 100, 213, 125);
		setVisible(true);
		setResizable(false);
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		
		getContentPane().setLayout(new GridLayout(2,1));
		getContentPane().setBackground(Color.black);
		
		panel = new JPanel();
		getContentPane().add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
		panel.setBackground(Color.black);
		
		coins = new JLabel("#Coins: ");
		coins.setForeground(Color.white);
		panel.add(coins);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBackground(Color.black);
		textField.setForeground(Color.white);
		panel.add(textField);
		textField.setColumns(10);
		
		accept = new JLabel("Empty!");
		accept.setHorizontalAlignment(SwingConstants.CENTER);
		accept.setForeground(Color.white);
		getContentPane().add(accept);
	}
	/**
	 *  update when something happen
	 */
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		textField.setText(((CoinMachine) arg).getCount()+"");
		accept.setText("Accepting Coins " + Demo.coinMachineRun.getCoins().get(Demo.coinMachineRun.getCoins().size()-1).toString());
		accept.setForeground(Color.GREEN);
		if(Integer.parseInt(textField.getText())==Demo.capacity){
			accept.setText("Machine is Full!");
			accept.setForeground(Color.red);
		}
	}
	
}	