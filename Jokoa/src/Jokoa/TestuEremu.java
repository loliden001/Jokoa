package Jokoa;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.*;

public class TestuEremu extends JFrame {
	//Interfazea
	JLabel jLabel1 = new JLabel("Sartu zenbakia:");
	JTextField jTextField1 = new JTextField(10);
	JButton botoia = new JButton("Asmatu");
	JPanel panela = new JPanel();
	JPanel erdikoPanela = new JPanel();
	JPanel goikoPanela = new JPanel();
	RandomZenbakia randomZenbakia;
	JLabel testua = new JLabel();
	JDialog asmatuta = new JDialog();
	JPanel asmatutaGoikoPanela = new JPanel();
	JPanel asmatutaBehekoPanela = new JPanel();
	JButton bai = new JButton("Bai");
	JButton ez = new JButton("Ez");
	JLabel jLabel2 = new JLabel("Berriro ere jokatu nahi duzu");

	public TestuEremu() {
		setTitle("Testu-Eremuekin adibidea");
		panela.add(botoia);
		goikoPanela.add(jLabel1);
		goikoPanela.add(jTextField1);
		erdikoPanela.add(testua);
		randomZenbakia = new RandomZenbakia();
		int randomZenb = randomZenbakia.getZenbakia();
		System.out.println(randomZenb);
		jTextField1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				testua.setText("");
				String zenb = jTextField1.getText();
				int zenbakia = Integer.parseInt(zenb);
				System.out.println(zenbakia);
				
			}
	
		});
		
		
		jTextField1.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				testua.setText("");
				
			}
		});
		botoia.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String zenb = jTextField1.getText();
				int zenbakia = Integer.parseInt(zenb);
				System.out.println(zenbakia);					
				if (!randomZenbakia.asmatuDu(zenbakia)) {
					if (randomZenbakia.handiagoaDa(zenbakia)){
						testua.setText("Zenbakia txikiagoa da");
						
					}else{
						testua.setText("Zenbakia handiagoa da");
					}

				} else{
					JOptionPane.showMessageDialog(null, "Zorionak!! Asmatu duzu!!");
					asmatutaLeihoa();
				}
				bai.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						asmatuta.dispose();
						randomZenbakia = new RandomZenbakia();
						int randomZenb = randomZenbakia.getZenbakia();
						System.out.println(randomZenb);
						jTextField1.setText("");
						testua.setText("");


					}
				});
				
				ez.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						asmatuta.dispose();
						dispose();
					}
				});
			}
		});

	}

	private void hasi() {
		this.getContentPane().add(goikoPanela, BorderLayout.NORTH);
		this.getContentPane().add(erdikoPanela, BorderLayout.CENTER);
		this.getContentPane().add(panela, BorderLayout.SOUTH);
	}

	public static void main(String[] args) {
		TestuEremu testuEremu = new TestuEremu();
		testuEremu.hasi();
		testuEremu.setVisible(true);
		testuEremu.setSize(340, 110);
		testuEremu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void asmatutaLeihoa() {
		asmatuta.getContentPane().add(asmatutaGoikoPanela, BorderLayout.NORTH);
		asmatuta.getContentPane().add(asmatutaBehekoPanela, BorderLayout.SOUTH);
		asmatutaGoikoPanela.add(jLabel2);
		asmatutaBehekoPanela.add(bai, BorderLayout.EAST);
		asmatutaBehekoPanela.add(ez, BorderLayout.SOUTH);
		asmatuta.setVisible(true);
		asmatuta.setSize(250, 100);
		asmatuta.setTitle("Berriro jokatu nahi?");
		asmatuta.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

	}
}
