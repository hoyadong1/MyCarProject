package mycar;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CarStoreListPanel extends JPanel {
	private JTable carStoreTable;
	String[] columnNames;
	DefaultTableModel model;
	MyCarProgram mcp;
	CarListPanel carList;
	MainPagePanel mainPage;

	public CarStoreListPanel(MyCarProgram mcp, CarListPanel carList, MainPagePanel mainPage) {
		this.mcp = mcp;
		this.carList = carList;
		this.mainPage = mainPage;
		this.setBounds(0, 0, 964, 523);
		this.setLayout(null);
		this.setVisible(false);

		JLabel lblNewLabel = new JLabel("List of car stores that have the car");
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 30));
		lblNewLabel.setBounds(12, 10, 498, 36);
		this.add(lblNewLabel);

		JButton returntoMain = new JButton("Return to Main menu");
		returntoMain.setFont(new Font("굴림", Font.PLAIN, 20));
		returntoMain.setBounds(723, 10, 229, 36);
		returntoMain.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				carList.setVisible(false);
				mainPage.setVisible(true);
			}
		});
		this.add(returntoMain);

		columnNames = new String[] { "Store name", "Store location", "Number of cars" };
		model = new DefaultTableModel(null, columnNames);
		carStoreTable = new JTable(model);
		TableColumnModel columnModel = carStoreTable.getColumnModel();
		for (int i = 0; i < columnNames.length; i++) {
			TableColumn column = columnModel.getColumn(i);
			column.setHeaderValue(columnNames[i]);
		}
		carStoreTable.setFont(new Font("굴림", Font.BOLD, 13));
		carStoreTable.setPreferredScrollableViewportSize(new Dimension(700, 600));
		carStoreTable.setFillsViewportHeight(true);
		JScrollPane scrollPane = new JScrollPane(carStoreTable);
		scrollPane.setSize(940, 446);
		scrollPane.setLocation(12, 67);
		this.add(scrollPane);
	}

	public void updateTableData(Object[][] data) {
		model.setDataVector(data, columnNames);
	}
}