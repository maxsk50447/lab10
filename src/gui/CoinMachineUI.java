package gui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CoinMachineUI extends JFrame{
	private Container main = new Container();
	private Container top = new Container();
	private JLabel coin = new JLabel("#Coins: ", JLabel.LEFT);
	private JTextField receive = new JTextField("",JLabel.RIGHT);
	public CoinMachineUI(){
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		run();
		initComponents();
	}
	private void initComponents(){
		this.add(main);
		main.setLayout(new GridLayout(2,1));
		
		top.setLayout(new FlowLayout());
		
		main.add(top);
		top.add(coin);
		top.add(receive);
	}
	public void run(){
		this.setVisible(true);
		this.setResizable(false);
		this.setBounds(0,0,100,80);
	}
}
