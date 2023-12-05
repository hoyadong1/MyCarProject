package mycar;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import mycar.ui.Palette;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class CarStoreListPanel extends JPanel {
    private JTable carStoreTable;
    String[] columnNames;
    DefaultTableModel model;
    MyCarProgram mcp;
    CarListPanel carList;
    MainPagePanel mainPage;
    JLabel imageLabel;
    BookMarkPanel bookmarkPanel;

    public CarStoreListPanel(MyCarProgram mcp, CarListPanel carList, MainPagePanel mainPage) {
        this.mcp = mcp;
        this.carList = carList;
        this.mainPage = mainPage;
        this.setBackground(Palette.background);
        this.setBounds(0, 0, 1200, 800);
        this.setLayout(null);
        this.setVisible(false);

        JLabel lblNewLabel = new JLabel("지점 리스트");
        lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 30));
        lblNewLabel.setBounds(12, 10, 498, 36);
        this.add(lblNewLabel);

        imageLabel = new JLabel();
        imageLabel.setBounds(0, 300, 667, 436); // 적절한 위치와 크기로 설정
        this.add(imageLabel);

        JButton returntoMain = new JButton("Return to Main menu");
        returntoMain.setFont(new Font("굴림", Font.PLAIN, 20));
        returntoMain.setBounds(723, 10, 229, 36);
        returntoMain.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                imageLabel.setIcon(null); // 이미지 레이블의 아이콘을 초기화합니다.
                setVisible(false);
                carList.setVisible(false);
                mainPage.setVisible(true);
            }
        });
        this.add(returntoMain);
        columnNames = new String[] {"검색한 차량 코드", "회사 이름", "지점 이름", "보유중인 자동차의 수"};
        model = new DefaultTableModel(null, columnNames);
        carStoreTable = new JTable(model);
        carStoreTable.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 1) {
                    JTable target = (JTable) e.getSource();
                    int row = target.getSelectedRow();
                    if (row != -1) {
                        String storeLocation = (String) target.getValueAt(row, 2); // '지점 이름'은 세 번째
                                                                                   // 열에 있으므로, 열의
                                                                                   // 인덱스는 2입니다.
                        ImageIcon icon = new ImageIcon("./images/" + storeLocation + ".jpg"); // 이미지
                                                                                              // 파일의
                                                                                              // 경로와
                                                                                              // 이름이
                                                                                              // './images/지점
                                                                                              // 이름.jpg'라고
                                                                                              // 가정
                        Image image = icon.getImage().getScaledInstance(imageLabel.getWidth(),
                                imageLabel.getHeight(), Image.SCALE_DEFAULT);
                        imageLabel.setIcon(new ImageIcon(image));
                    }
                }
            }
        });

        bookmarkPanel = new BookMarkPanel();
        bookmarkPanel.setBounds(950, 67, 240, 446); // 적절한 위치와 크기로 설정
        this.add(bookmarkPanel);

        // 즐겨찾기 버튼
        JButton favoriteButton = new JButton("즐겨찾기 추가");
        favoriteButton.setBounds(950, 10, 240, 36);
        favoriteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = carStoreTable.getSelectedRow();
                if (row != -1) {
                    String storeLocation = (String) carStoreTable.getValueAt(row, 2);
                    bookmarkPanel.addFavorite(storeLocation);
                    JOptionPane.showMessageDialog(null, "즐겨찾기에 저장되었습니다.");
                }
            }
        });
        this.add(favoriteButton, BorderLayout.SOUTH);
        // 해제 버튼

        TableColumnModel columnModel = carStoreTable.getColumnModel();
        for (int i = 0; i < columnNames.length; i++) {
            TableColumn column = columnModel.getColumn(i);
            column.setHeaderValue(columnNames[i]);
        }
        carStoreTable.setBackground(Palette.secondPanel);
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
