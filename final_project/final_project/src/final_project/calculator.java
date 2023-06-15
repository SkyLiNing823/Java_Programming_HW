package final_project;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;


public class calculator extends JFrame {
    private String str = "";
    private JPanel contentPane;
    private int brackets = 1;
    //Set btn str
    private String []BtnList = {"1","2","3","+","4","5","6","-","7","8","9","*",".","0","%","/","AC","()","^","="};
    
    public calculator(){
        super("calculator");
        //set panel
        contentPane = new JPanel();
        //Set text field
        JTextField text_input = new JTextField(30);
        text_input.setHorizontalAlignment(JTextField.RIGHT);
        text_input.setBorder(null);
        text_input.setFont(new Font("Monospaced", Font.BOLD, 25));
        text_input.setBackground(Color.BLACK);
        text_input.setForeground(Color.WHITE);
        contentPane.add(text_input);
        //set btn
        JButton[] btn = new JButton[BtnList.length];
        for (int count = 0; count < BtnList.length; count++) {
        	btn[count] = new JButton(BtnList[count]);
        	//set btn font
        	btn[count].setFont(new Font("Monospaced", Font.BOLD, 22));
        	btn[count].addActionListener(new ActionListener() {
    			public void actionPerformed(ActionEvent e) {
    				setBackground(Color.RED);
    				String command = e.getActionCommand();
    				//identify using left bracket or right bracket
                    brackets = setShowTextFiledNew(text_input, command, brackets);
    			}
    		});
        	btn[count].setFocusable(false);
        	btn[count].setBackground(Color.ORANGE);
            contentPane.add(btn[count]);
        }

        contentPane.setLayout(null);
        contentPane.setBackground(Color.BLACK);
        //set content bounds
        text_input.setBounds(0, 0, 340, 100);
        for(int i = 0; i < 5; i++)
        {
    
        	btn[i*4 + 0].setBounds(10, i*60+110, 70, 50);
        	btn[i*4 + 1].setBounds(90, i*60+110, 70, 50);
        	btn[i*4 + 2].setBounds(170, i*60+110, 70, 50);
        	btn[i*4 + 3].setBounds(250, i*60+110, 80, 50);
        	
        }
        
        add(contentPane);
        setSize(360, 450);
        //set unresizable
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    public int setShowTextFiledNew(JTextField text_input, String command, int brackets){
    	str = text_input.getText();
    	// replace text
    	str = str.replace("ERROR",""); // calculate ERROR
    	str = str.replace("NaN",""); // when 0 / 0
    	str = str.replace("Infinity",""); // when N / 0
    	switch(command)
    	{
    	case "=":
    		if(str.charAt(1) == '-') // for - x beginning
    			str=getResult("0 "+str);
    		else
    			str=getResult(str);
    		break;
    	case "AC":
    		str="";
    		break;
    	case "()":	
    		if(brackets == 1)
    			str+=" ( ";
    		else
    			str+=" ) ";
    		brackets *= -1;
    		break;
    	case "+","-","/","*","%","^":
    		str+=" "+command+" ";
		break;
    	default:
    		str+=command;
    		break;
    	}
    	text_input.setText(str);
    	return brackets;
    }
    
    public int priority(char c)
    {
    	//get operators priority
    	switch(c) {
    	case '^':
    		return 3;
    	case '*','/':
    		return 2;
    	case '+','-':
    		return 1;
    	default:
    		return 0;
    	}
    }
    
    public String toPostfix(String infix) {
    	//infix to postfix
        LinkedList<Character> stack = new LinkedList<>();
        StringBuilder output = new StringBuilder();
        for(char c : infix.toCharArray()) {
            if(c == '(') { 
            	stack.add(c);
            	}
            else if("+-*/%^".indexOf(c) != -1) {
                while(!stack.isEmpty() && priority(stack.getLast()) >= priority(c)) { 
                    output.append(stack.removeLast());
                } 
                stack.add(c);
            }
            else if(c == ')') {
                while(stack.getLast() != '(') { 
                    output.append(stack.removeLast());
                } 
                stack.removeLast();
            }
            else { 
            	output.append(c); 
            	}
        }
        
        while(!stack.isEmpty()) { 
        	output.append(stack.removeLast());
        	}
        return output.toString();
    }
    
    
    public String getResult(String str){
    	int i;
        Double result=0.0;
        str = toPostfix(str);
        System.out.println(str);
        str = str.replace("+"," + ");
        str = str.replace("-"," - ");
        str = str.replace("/"," / ");
        str = str.replace("*"," * ");
        str = str.replace("%"," % ");
        str = str.replace("^"," ^ ");
        //remove excess space
        str = str.replaceAll("\\s+"," ");
        String[] sp = str.split(" ");
        Stack<String> operands = new Stack<String>();
        String a;
		String b;
        for(i=0;i<sp.length;i++){   		
        	try
        	{
        	switch (sp[i]){
        	case "+":
        		result = Double.parseDouble(operands.pop()) + Double.parseDouble(operands.pop());
        		operands.push(result+"");
        		break;
        	case "-":
        		a = operands.pop();
        		b = operands.pop();
        		result = Double.parseDouble(b) - Double.parseDouble(a);
        		operands.push(result+"");
        		break;
        	case "*":
        		result = Double.parseDouble(operands.pop()) * Double.parseDouble(operands.pop());
        		operands.push(result+"");
        		break;
        	case "/":
        		a = operands.pop();
        		b = operands.pop();
        		result = Double.parseDouble(b) / Double.parseDouble(a);
        		operands.push(result+"");
        		break;
        	case "%":
        		a = operands.pop();
        		b = operands.pop();
        		result = Double.parseDouble(b) % Double.parseDouble(a);
        		operands.push(result+"");
        		break;
        	case "^":
        		a = operands.pop();
        		b = operands.pop();
        		result = Math.pow(Double.parseDouble(b),Double.parseDouble(a));
        		operands.push(result+"");
        		break;
        	default:
        		operands.push(sp[i]);
        	}
        	}
        	catch(Exception e){
        		//if calculating failed
        		return "ERROR";
        	}
        }
        result = Double.parseDouble(operands.pop());
        return result+""; //to string
    }

    public static void main(String[] args) {
        new calculator();
    }
}
