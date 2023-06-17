package _04_gui_from_scratch._1_fortune_cookie;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class FortuneCookie implements ActionListener {

	int rand;

	public void showButton() {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

		JButton button = new JButton();
		frame.add(button);
		frame.pack();

		button.addActionListener(this);


		rand = new Random().nextInt(4-0+1)+0;



		//this makes the program close by itself after 10 seconds

		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.exit(0);


	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JOptionPane.showMessageDialog(null, "Woohoo.");

		if(rand == 0) {
			JOptionPane.showMessageDialog(null, "You will have good luck.");
		}
		else if(rand == 1) {
			JOptionPane.showMessageDialog(null, "You will find someone for you soon.");
		}
		else if(rand == 2) {
			JOptionPane.showMessageDialog(null, "You will make many friends.");
		}
		else if(rand == 3) {
			JOptionPane.showMessageDialog(null, "You will find academic success.");
		}
		else if(rand == 4) {
			JOptionPane.showMessageDialog(null, "You will find lots of money in your life.");
		}


	}


}