import gui.MipsMainFrame;

import java.awt.EventQueue;


/**
 * 
 */

/**
 * @author Acid Flow
 *
 */
public final class MIPSimulator {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MipsMainFrame frame = new MipsMainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
