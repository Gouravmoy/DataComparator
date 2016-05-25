package ui;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.util.concurrent.TimeUnit;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class CardLayoutBehaviour extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected CardLayout layout;

	public static void main(String[] args) {
		CardLayoutBehaviour ct = new CardLayoutBehaviour();
		ct.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		int i = 0;
		while (true) {
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			i++;
			if (i % 3 == 0) {
				ct.displayTab("Red Tab");
				ct.setSize(400, 300);
				ct.setVisible(true);
			} else if (i % 3 == 1) {
				ct.displayTab("Green Tab");
				ct.setSize(400, 300);
				ct.setVisible(true);
			} else {
				ct.displayTab("Blue Tab");
				ct.setSize(400, 300);
				ct.setVisible(true);
			}

		}

	}

	public CardLayoutBehaviour() {
		JPanel tab;
		Container pane = getContentPane();
		layout = new CardLayout();
		pane.setLayout(layout);
		tab = new JPanel();
		tab.setBackground(Color.red);
		pane.add(tab, "Red Tab");
		tab = new JPanel();
		tab.setBackground(Color.green);
		pane.add(tab, "Green Tab");
		tab = new JPanel();
		tab.setBackground(Color.blue);
		pane.add(tab, "Blue Tab");
	}

	public void displayTab(String name) {
		layout.show(this.getContentPane(), name);
	}

}