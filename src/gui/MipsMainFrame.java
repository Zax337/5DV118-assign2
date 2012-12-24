package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Dimension;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

public class MipsMainFrame extends JFrame {

	private JPanel contentPane;
	private JTable instructionTable;
	private JTable table;
	private JTable table_1;
	private JTable table_2;

	/**
	 * Create the frame.
	 */
	public MipsMainFrame() {
		setTitle("MipSimulator");
		setPreferredSize(new Dimension(800, 600));
		setName("mainFrame");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel instructionPanel = new JPanel();
		instructionPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JPanel numericalFieldsPanel = new JPanel();
		numericalFieldsPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JPanel pcPanel = new JPanel();
		pcPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JPanel registerPanel = new JPanel();
		registerPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JPanel memoryPanel = new JPanel();
		memoryPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JPanel optionsPanel = new JPanel();
		optionsPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JPanel controlsPanel = new JPanel();
		controlsPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(controlsPanel, GroupLayout.PREFERRED_SIZE, 196, GroupLayout.PREFERRED_SIZE)
						.addComponent(instructionPanel, GroupLayout.PREFERRED_SIZE, 196, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(numericalFieldsPanel, GroupLayout.DEFAULT_SIZE, 461, Short.MAX_VALUE)
						.addComponent(pcPanel, GroupLayout.DEFAULT_SIZE, 461, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(registerPanel, GroupLayout.DEFAULT_SIZE, 237, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(memoryPanel, GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(optionsPanel, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(instructionPanel, GroupLayout.DEFAULT_SIZE, 347, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(controlsPanel, GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE))
						.addComponent(optionsPanel, GroupLayout.DEFAULT_SIZE, 549, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(pcPanel, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(numericalFieldsPanel, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(memoryPanel, 0, 0, Short.MAX_VALUE)
								.addComponent(registerPanel, GroupLayout.DEFAULT_SIZE, 401, Short.MAX_VALUE))))
					.addGap(3))
		);
		
		JLabel lblOptions = new JLabel("Options");
		
		JButton btnStep = new JButton("Step");
		
		JButton btnRun = new JButton("Run");
		
		JButton btnReset = new JButton("Reset");
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Decimal", "Hexadecimal"}));
		GroupLayout gl_optionsPanel = new GroupLayout(optionsPanel);
		gl_optionsPanel.setHorizontalGroup(
			gl_optionsPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_optionsPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_optionsPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(comboBox, 0, 85, Short.MAX_VALUE)
						.addGroup(gl_optionsPanel.createParallelGroup(Alignment.LEADING, false)
							.addComponent(lblOptions)
							.addComponent(btnReset, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(btnRun, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(btnStep, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
					.addContainerGap())
		);
		gl_optionsPanel.setVerticalGroup(
			gl_optionsPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_optionsPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnStep)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnRun)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnReset)
					.addGap(52)
					.addComponent(lblOptions)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(368, Short.MAX_VALUE))
		);
		optionsPanel.setLayout(gl_optionsPanel);
		
		JLabel lblMemory = new JLabel("Memory");
		
		JPanel panel_2 = new JPanel();
		GroupLayout gl_memoryPanel = new GroupLayout(memoryPanel);
		gl_memoryPanel.setHorizontalGroup(
			gl_memoryPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_memoryPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_memoryPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
						.addComponent(lblMemory))
					.addContainerGap())
		);
		gl_memoryPanel.setVerticalGroup(
			gl_memoryPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_memoryPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblMemory)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 357, Short.MAX_VALUE)
					.addContainerGap())
		);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane_3 = new JScrollPane();
		panel_2.add(scrollPane_3, BorderLayout.CENTER);
		
		table_2 = new JTable();
		table_2.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
			},
			new String[] {
				"New column", "New column"
			}
		));
		scrollPane_3.setViewportView(table_2);
		memoryPanel.setLayout(gl_memoryPanel);
		
		JLabel lblRegisters = new JLabel("Registers");
		
		JPanel panel_1 = new JPanel();
		GroupLayout gl_registerPanel = new GroupLayout(registerPanel);
		gl_registerPanel.setHorizontalGroup(
			gl_registerPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_registerPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_registerPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
						.addComponent(lblRegisters))
					.addContainerGap())
		);
		gl_registerPanel.setVerticalGroup(
			gl_registerPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_registerPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblRegisters)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 357, Short.MAX_VALUE)
					.addContainerGap())
		);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane_2 = new JScrollPane();
		panel_1.add(scrollPane_2, BorderLayout.CENTER);
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
			},
			new String[] {
				"New column", "New column"
			}
		));
		scrollPane_2.setViewportView(table_1);
		registerPanel.setLayout(gl_registerPanel);
		
		JLabel lblNumericalFields = new JLabel("Numerical fields");
		GroupLayout gl_numericalFieldsPanel = new GroupLayout(numericalFieldsPanel);
		gl_numericalFieldsPanel.setHorizontalGroup(
			gl_numericalFieldsPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_numericalFieldsPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNumericalFields)
					.addContainerGap(354, Short.MAX_VALUE))
		);
		gl_numericalFieldsPanel.setVerticalGroup(
			gl_numericalFieldsPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_numericalFieldsPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNumericalFields)
					.addContainerGap(26, Short.MAX_VALUE))
		);
		numericalFieldsPanel.setLayout(gl_numericalFieldsPanel);
		
		JLabel lblPc = new JLabel("PC");
		GroupLayout gl_pcPanel = new GroupLayout(pcPanel);
		gl_pcPanel.setHorizontalGroup(
			gl_pcPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pcPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblPc)
					.addContainerGap(354, Short.MAX_VALUE))
		);
		gl_pcPanel.setVerticalGroup(
			gl_pcPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pcPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblPc)
					.addContainerGap(29, Short.MAX_VALUE))
		);
		pcPanel.setLayout(gl_pcPanel);
		
		JLabel lblControls = new JLabel("Controls");
		
		JPanel panel = new JPanel();
		GroupLayout gl_controlsPanel = new GroupLayout(controlsPanel);
		gl_controlsPanel.setHorizontalGroup(
			gl_controlsPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_controlsPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_controlsPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
						.addComponent(lblControls))
					.addContainerGap())
		);
		gl_controlsPanel.setVerticalGroup(
			gl_controlsPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_controlsPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblControls)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
					.addContainerGap())
		);
		panel.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane_1 = new JScrollPane();
		panel.add(scrollPane_1, BorderLayout.CENTER);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
			},
			new String[] {
				"New column", "New column"
			}
		));
		scrollPane_1.setViewportView(table);
		controlsPanel.setLayout(gl_controlsPanel);
		
		JLabel lblInstructions = new JLabel("Instructions");
		
		JPanel arrayInsContainer = new JPanel();
		GroupLayout gl_instructionPanel = new GroupLayout(instructionPanel);
		gl_instructionPanel.setHorizontalGroup(
			gl_instructionPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_instructionPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_instructionPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(arrayInsContainer, GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
						.addComponent(lblInstructions))
					.addContainerGap())
		);
		gl_instructionPanel.setVerticalGroup(
			gl_instructionPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_instructionPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblInstructions)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(arrayInsContainer, GroupLayout.DEFAULT_SIZE, 291, Short.MAX_VALUE)
					.addContainerGap())
		);
		arrayInsContainer.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		arrayInsContainer.add(scrollPane, BorderLayout.CENTER);
		
		instructionTable = new JTable();
		instructionTable.setModel(new DefaultTableModel(
			new Object[][] {
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
			},
			new String[] {
				"New column"
			}
		));
		scrollPane.setViewportView(instructionTable);
		instructionPanel.setLayout(gl_instructionPanel);
		contentPane.setLayout(gl_contentPane);
	}
}