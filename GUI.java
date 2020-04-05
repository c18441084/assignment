package Assignment.java;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class GUI extends JFrame implements ActionListener
{

	//Attributes 
	JLabel label1, label2;
	JButton button1;
	JPanel centerPanel, southPanel, northPanel;
	JTextField text1;
	
	public GUI(String myTitle)
	{
		super(myTitle);
		setSize(600, 600);
		
		BorderLayout bl1 = new BorderLayout();
		setLayout(bl1);
		
		//Labels
		label1 = new JLabel("CoronaVirus Test");
		label2 = new JLabel("Enter Temperature");
		text1 = new JTextField("(hot/normal/cool/cold)");
		
		//Buttons
		button1 = new JButton("Test");
		button1.addActionListener(this);
		
		//set up Panels
		centerPanel = new JPanel();
		southPanel = new JPanel(); 
		northPanel = new JPanel();
		
		//Center Panel
		centerPanel.add(label2);
		centerPanel.add(text1);
		add(centerPanel, BorderLayout.CENTER);
		
		//North Panel
		northPanel.add(label1);
		add(northPanel, BorderLayout.NORTH);
		
		//South Panel
		southPanel.add(button1);
		add(southPanel, BorderLayout.SOUTH);
		
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent myEvent)
	{
		String temper = text1.getText();
		String[] answerArray = new String[4];
		int i = 0;
		if(myEvent.getSource() == button1)
		{			
			if(temper.contains("hot"))
			{
				answerArray[i] = temper;
				i++;
			}
			
			if(temper.contains("normal"))
			{
				answerArray[i] = temper;
				i++;
			}
			
			if(temper.contains("cool"))
			{
				answerArray[i] = temper;
				i++;
			}
			
			if(temper.contains("cold"))
			{
				answerArray[i] = temper;
				i++;
			}
			Controllor.main(answerArray);
		}
	}
}


