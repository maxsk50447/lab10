package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Observable;
import java.util.Observer;
import javax.swing.border.*;

import coinmachine.*;


/**
 * CoinMachine User Interface
 * @author Patipol Wangjaitham
 *
 */
public class CoinMachineUI extends JFrame implements Observer{

	private JButton oneBahtButton, fiveBahtButton, tenBahtButton;
	private CoinMachine coinMachine;
	private JProgressBar progressBar;
	private int currentBalance = 0;
	private JLabel balance, status, insert;
	private TitledBorder title;
	private JPanel panel;
	/**
	 * Create the application.
	 */
	public CoinMachineUI(CoinMachine mc) {
		coinMachine = mc;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		initialize();
	}
	/**
	 * Launch the application.
	 */
	public void run(){
		pack();
		setBounds(400, 100, 440, 265);
		setVisible(true);
		setResizable(false);
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		
		getContentPane().setLayout(null);
		getContentPane().setBackground(Color.black);
		
		balance = new JLabel("Balance:   " + 0 + " ");
		balance.setFont(new Font("Tahoma", Font.PLAIN, 17));
		balance.setBounds(29, 31, 99, 16);
		balance.setForeground(Color.white);
		getContentPane().add(balance);
		
		status = new JLabel("Status: ");
		status.setFont(new Font("Tahoma", Font.PLAIN, 17));
		status.setBounds(140, 31, 72, 16);
		status.setForeground(Color.white);
		getContentPane().add(status);
		
		progressBar = new JProgressBar();
		progressBar.setBounds(219, 31, 200, 16);
		progressBar.setStringPainted(true);
		progressBar.setMaximum(Demo.capacity);
		progressBar.setToolTipText("");
		getContentPane().add(progressBar);
		
	
		panel = new JPanel();
		panel.setBounds(12, 74, 407, 136);
		panel.setBackground(Color.black);
		getContentPane().add(panel);
		
		title = new TitledBorder("Insert Money");
		title.setTitleColor(Color.white);
		panel.setBorder(title);
		
		oneBahtButton = new JButton();
		oneBahtButton.setBounds(22, 97, 122, 108);
		panel.add(oneBahtButton);
		oneBahtButton.setIcon(new ImageIcon(CoinMachineUI.class.getResource("/images/1baht.png")));
		oneBahtButton.addActionListener(new coinButtonListener());
		
		fiveBahtButton = new JButton();
		fiveBahtButton.setBounds(150, 97, 131, 108);
		panel.add(fiveBahtButton);
		fiveBahtButton.setIcon(new ImageIcon(CoinMachineUI.class.getResource("/images/5baht.png")));
		fiveBahtButton.addActionListener(new coinButtonListener());
		
		tenBahtButton = new JButton();
		tenBahtButton.setBounds(294, 97, 113, 108);
		panel.add(tenBahtButton);
		tenBahtButton.setIcon(new ImageIcon(CoinMachineUI.class.getResource("/images/10baht.png")));
		tenBahtButton.addActionListener(new coinButtonListener());
	}
	/**
	 * ActionListener that use to insert the coin into the machine and show the message dialog
	 */
	class coinButtonListener implements ActionListener{

			@Override
		public void actionPerformed(ActionEvent e) {
			Object source = e.getSource();
			Coin coin = null;
			if(source == oneBahtButton) coin = new Coin(1,"Baht");
			else if(source == fiveBahtButton) coin = new Coin(5,"Baht");
			else if(source == tenBahtButton) coin = new Coin(10,"Baht");
			System.out.println(coin + " inserted");
			if(Demo.coinMachineRun.getCount() < Demo.coinMachineRun.getCapacity()-1)System.out.print("Values of coins to insart: ");
			if(Demo.coinMachineRun.isFull()) System.out.println("Machine is Full!");
			Demo.coinMachineRun.insert(coin);
			checkProgressBar();
		}
		
	}
	/**
	 * set the text of balance update follow the balance that you get from coinmachine
	 * and set value of progressbar follow the count that
	 */
	@Override
	public void update(Observable subject, Object info) {
		// TODO Auto-generated method stub
		currentBalance = ((CoinMachine) info).getBalance();
		balance.setText("Balance:   "+ currentBalance);
		progressBar.setValue(((CoinMachine) info).getCount());
		progressBar.setForeground(Color.green);
		if(progressBar.getValue() >= 5 && progressBar.getValue() < 8)progressBar.setForeground(Color.yellow);
		else if(progressBar.getValue() >= 8 && progressBar.getValue() < progressBar.getMaximum())progressBar.setForeground(Color.orange);
		else if(progressBar.getValue() == progressBar.getMaximum()) progressBar.setForeground(Color.red);
	}
	/**
	 * check that machine is full or not if it full show message dialog
	 */
	public void checkProgressBar(){
		if(Demo.coinMachineRun.isFull()) JOptionPane.showMessageDialog(this, "Machine is Full!", "Error !", JOptionPane.ERROR_MESSAGE);
	}
}
