package week12;
import javax.swing.*;
import java.awt.event.*;

class MyJFrame extends JFrame{
	private JPanel contentPane;
	MyJFrame(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 300);
		setVisible(true);
		contentPane = new JPanel();
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lb1 = new JLabel("請輸入年所得：");
		lb1.setBounds(10, 10, 96, 23);
		contentPane.add(lb1);
		
		JLabel lb2 = new JLabel("");
		lb2.setBounds(10, 60, 500, 23);
		contentPane.add(lb2);
		
		JTextField txt = new JTextField();
		txt.setBounds(10, 30, 100, 23);
		contentPane.add(txt);
		
		JButton btn = new JButton("確定");
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double income = Float.parseFloat(txt.getText());
				if(income > 5000000)
				{
					lb2.setText("年所得"+income+"元，應繳所得稅"+(income*0.3)+"元");
				}
				else if(income > 1500000)
				{
					lb2.setText("年所得"+income+"元，應繳所得稅"+(income*0.2)+"元");
				}
				else if(income > 900000)
				{
					lb2.setText("年所得"+income+"元，應繳所得稅"+(income*0.12)+"元");
				}
				else if(income > 600000)
				{
					lb2.setText("年所得"+income+"元，應繳所得稅"+(income*0.06)+"元");
				}
				else if(income > 300000)
				{
					lb2.setText("年所得"+income+"元，應繳所得稅"+(income*0.03)+"元");
				}
				else
				{
					lb2.setText("年所得"+income+"元，應繳所得稅"+(income*0)+"元");
				}
			}
		});
		btn.setBounds(150, 30, 96, 23);
		contentPane.add(btn);
		setVisible(true);
	}
}

public class hw12 {
	public static void main(String[] args) {
		MyJFrame jFrame = new MyJFrame();
	}
}
