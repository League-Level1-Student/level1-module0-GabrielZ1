package _04_gui_from_scratch._3_sound_effects_machine;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class SoundEffectsMachine implements ActionListener {

	JFrame frame = new JFrame();
	JPanel panel = new JPanel();

	JButton button1 = new JButton();
	JButton button2 = new JButton();
	JButton button3 = new JButton();


	public void showButtons() {
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

		button1.setText("Cymbal!");
		button2.setText("Fair Sound!");
		button3.setText("Sawing Wood!");


		panel.add(button1);
		panel.add(button2);
		panel.add(button3);

		frame.add(panel);
		frame.pack();

		frame.setTitle("Sound Effects Machine");
		
		button1.addActionListener(this);
		button2.addActionListener(this);	
		button3.addActionListener(this);

	}


	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		JButton buttonPressed = (JButton) arg0.getSource();

		if(buttonPressed == button1) {
			playSound("cymbal.wav");
		}
		else if(buttonPressed == button2) {
			playSound("fair1939.wav");
		}
		else if(buttonPressed == button3) {
			playSound("sawing-wood-daniel_simon.wav");
		}

	}



	//given method

	private void playSound(String soundFile) {
		String path = "src/_04_gui_from_scratch/_3_sound_effects_machine/";
		File sound = new File(path+soundFile);
		if (sound.exists()) {
			new Thread(() -> {
				try {
					Clip clip = AudioSystem.getClip();
					clip.open(AudioSystem.getAudioInputStream(sound));
					clip.start();
					Thread.sleep(clip.getMicrosecondLength()/1000);
				}
				catch (Exception e) {
					System.out.println("Could not play this sound");
				}}).start();
		}
		else {
			System.out.println("File does not exist");
		}

	}


}
