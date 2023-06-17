package _04_gui_from_scratch._4_cuteness_tv;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URI;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class CutenessTV implements ActionListener {

	JFrame frame = new JFrame();
	JPanel panel = new JPanel();

	JButton duckButton = new JButton();
	JButton frogButton = new JButton();
	JButton fluffyUnicornButton = new JButton();

	public void showButtons() {

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

		duckButton.setText("Duck Video");
		frogButton.setText("Frog Video");
		fluffyUnicornButton.setText("Fluffy Unicorn Video");

		panel.add(duckButton);
		panel.add(frogButton);
		panel.add(fluffyUnicornButton);

		frame.add(panel);
		frame.pack();

		frame.setTitle("CutenessTV");

		duckButton.addActionListener(this);
		frogButton.addActionListener(this);
		fluffyUnicornButton.addActionListener(this);
	}


	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		JButton buttonPressed = (JButton) arg0.getSource();

		if(buttonPressed == duckButton) {
			showDucks();
		}
		else if(buttonPressed == frogButton) {
			showFrog();
		}
		else if(buttonPressed == fluffyUnicornButton) {
			showFluffyUnicorns();
		}
	}



	//given methods (not mine)

	void showDucks() {
		playVideo("https://www.youtube.com/watch?v=MtN1YnoL46Q");
	}

	void showFrog() {
		playVideo("https://www.youtube.com/watch?v=cBkWhkAZ9ds");
	}

	void showFluffyUnicorns() {
		playVideo("https://www.youtube.com/watch?v=qRC4Vk6kisY");
	}

	void playVideo(String videoID) {

		// Workaround for Linux because "Desktop.getDesktop().browse()" doesn't
		//work on some Linux implementations
		try {
			if (System.getProperty("os.name").toLowerCase().contains("linux")) {
				if (Runtime.getRuntime().exec(new String[] {
						"which", "xdg- open" }).getInputStream().read() != -1) {
					Runtime.getRuntime().exec(new String[] { "xdg-open", videoID });
				}
			} else {
				URI uri = new URI(videoID);
				java.awt.Desktop.getDesktop().browse(uri);
			}      } catch (Exception e) {
				e.printStackTrace();
			}
	}


}
