package mycar.selectoption.swing;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import mycar.Car;
import mycar.Option;
import mycar.User;
import mycar.purchasecar.swing.MainPanel;
import mycar.purchasecar.swing.comparepanel.CarComparePanel;
import mycar.ui.Palette;

public class CarOptionSelect extends JPanel{
	//JFrame frame;
	JTextField totalCal;
	int calNum = 0;
	public CarOptionSelect(Car car) {
		//프레임 크기(실행용)
		//frame = new JFrame("test");
		//frame.setSize(964, 530);
		//frame.setLocation(400, 250);
		setSize(1200, 800);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//Container contentPane = frame.getContentPane();
		Palette pal = new Palette();
		setBackground(pal.background);
		//차 가격
		if(car!=null)
			calNum = car.getCarPrice();
		else
			calNum = 0;
		
		//메인 페널 생성
		setLayout(new BorderLayout());
		
		//라벨(맨 위 리스트 이름)
		CarOptionSelectNamePanel namePanel = new CarOptionSelectNamePanel();
		add(namePanel, BorderLayout.NORTH);
		
		//텍스트 필드
		//선택한 옵션들 표기
		SelectOptionListPanel selectOptionList = new SelectOptionListPanel(car);
		
		//현제 선택한 옵션들 가격 합
		OptionTotalCalPanel totalCalP = new OptionTotalCalPanel();
		selectOptionList.add(totalCalP);

        add(selectOptionList, BorderLayout.WEST);

        //전체 옵션 표기	(버튼 포함)(버튼 기능 구현)
        //============================================================
        //추가 버튼================================================
        AllOptionListPanel optionJList = new AllOptionListPanel(car);
        ActionListener listener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String data = optionJList.makeList.getSelectedValue();
				selectOptionList.selectCarOptionModel.addElement(data);
				optionJList.makeList.clearSelection();
				//클릭 시 총합 가격 변동
				for(Option option : optionJList.optionList.mList) {
					if((option.getName()).equals(data)) {
						calNum += option.getPrice();
						car.addOptionList(option);
					}
						
				}
				
			}
		};
		optionJList.btnPanel.plusBtn.addActionListener(listener);
		//삭제 버튼================================================
		ActionListener deleteListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String data = selectOptionList.tempJList.getSelectedValue();
				selectOptionList.selectCarOptionModel.removeElement(data);
				optionJList.makeList.clearSelection();
				//클릭 시 총합 가격 변동
				for(Option option : optionJList.optionList.mList) {
					if((option.getName()).equals(data))
						calNum -= option.getPrice();
				}
			}
		};
		totalCalP.deleteBtn.addActionListener(deleteListener);
		//계산 버튼 ===============================================
		ActionListener calListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				totalCalP.totalCal.setText("합계 : "+ calNum);
			}
		};
		
		optionJList.btnPanel.calBtn.addActionListener(calListener);
		
		//저장 버튼 ===============================================

		ActionListener saveListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				User saveOp = User.getInstance();
				String answer = JOptionPane.showInputDialog("견적 이름을 입력해주세요.");
				JOptionPane.showMessageDialog(null, answer+"가 저장되었습니다.", "저장 알림", JOptionPane.INFORMATION_MESSAGE);
				saveOp.addBasket(answer, car);
			}
		};
		optionJList.btnPanel.saveBtn.addActionListener(saveListener);
		//견적 버튼 ===============================================
		ActionListener compareListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println(car.getCarName());
				CarComparePanel panel3 = new CarComparePanel(car, null);
				MainPanel.getInstance().add(panel3, "panel3");
				MainPanel.getInstance().showPanel("panel3");
			}
		};

        
		optionJList.btnPanel.compareBtn.addActionListener(compareListener);

		add(optionJList);
		//============================================================
		//contentPane.add(this);

		//frame.setVisible(true);
	}
    public static void main(String[] args) {
        new CarOptionSelect(null);
    }

}