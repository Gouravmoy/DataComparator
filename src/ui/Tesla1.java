package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Tesla1 {

	private JFrame frame;

	public Tesla1() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 980, 568);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel panelProject = new JPanel();
		panelProject.setBounds(646, 11, 194, 405);
		frame.getContentPane().add(panelProject);

		JButton btnAddProject = new JButton("ADD PROJECT");
		btnAddProject.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		btnAddProject.setBounds(646, 448, 194, 23);
		frame.getContentPane().add(btnAddProject);
	}
}
