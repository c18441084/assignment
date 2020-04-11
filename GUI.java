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
	JLabel label1, label2, label3, label4, label5, label6;
	JButton button1;
	JPanel centerPanel, southPanel, northPanel;
	JTextField text1, text2, text3, text4, text5;
	
	public GUI(String myTitle)
	{
		super(myTitle);
		setSize(600, 600);
		
		BorderLayout bl1 = new BorderLayout();
		setLayout(bl1);
		
		//Labels & texts
		label1 = new JLabel("CoronaVirus Test");
		label2 = new JLabel("Enter Temperature");
		label3 = new JLabel("Have you had aches?");
		label4 = new JLabel("Have you been coughing?");
		label5 = new JLabel("Do you have a sore throat?");
		label6 = new JLabel("Have you recently visited a country with COVID 19?");
		text1 = new JTextField("(hot/normal/cool/cold)");
		text2 = new JTextField("(yes/no)");
		text3 = new JTextField("(yes/no)");
		text4 = new JTextField("(yes/no)");
		text5 = new JTextField("(yes/no)");
		
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
		centerPanel.add(label3);
		centerPanel.add(text2);
		centerPanel.add(label4);
		centerPanel.add(text3);
		centerPanel.add(label5);
		centerPanel.add(text4);
		centerPanel.add(label6);
		centerPanel.add(text5);
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
		String ache = text2.getText();
		String cough = text3.getText(); 
		String sorethroat = text4.getText();
		String visited = text5.getText();
		String[] answerArray = new String[5];
		int i = 0;
		if(myEvent.getSource() == button1)
		{		
			//Temperature answer
			if(temper.contains("hot") || temper.contains("Hot"))
			{
				answerArray[i] = temper;
				i++;
			}
			
			if(temper.contains("normal") || temper.contains("Normal"))
			{
				answerArray[i] = temper;
				i++;
			}
			
			if(temper.contains("cool") || temper.contains("Cool"))
			{
				answerArray[i] = temper;
				i++;
			}
			
			if(temper.contains("cold") || temper.contains("Cold"))
			{
				answerArray[i] = temper;
				i++;
			}
			
			//Ache answer
			if(i == 1)
			{
				if(ache.contains("yes") || ache.contains("Yes") || ache.contains("y"))
				{
					answerArray[i] = ache;
					i++;
				}
			
				if(ache.contains("no") || ache.contains("No") || ache.contains("n"))
				{
					answerArray[i] = ache;
					i++;
				}
			}
			
			//Cough answer
			if(i == 2)
			{
				if(cough.contains("yes") || cough.contains("Yes") || cough.contains("y"))
				{
					answerArray[i] = cough;
					i++;
				}
				
				if(cough.contains("no") || cough.contains("No") || cough.contains("n"))
				{
					answerArray[i] = cough;
					i++;
				}
			}
			
			//Sore Throat answer
			if(i == 3)
			{
				if(sorethroat.contains("yes") || sorethroat.contains("Yes") || sorethroat.contains("y"))
				{
					answerArray[i] = sorethroat;
					i++;
				}
				
				if(sorethroat.contains("no") || sorethroat.contains("No") || sorethroat.contains("n"))
				{
					answerArray[i] = sorethroat;
					i++;
				}
			}
			
			//Recently Visited
			if(i == 4)
			{
				if(visited.contains("yes") || visited.contains("Yes") || visited.contains("y"))
				{
					answerArray[i] = visited;
					i++;
				}
				
				if(visited.contains("no") || visited.contains("No") || visited.contains("n"))
				{
					answerArray[i] = visited;
					i++;
				}
			}
			
			//Sending array of answers to the Controllor.java class
			Controllor.main(answerArray);
		}
	}
	
	//Method to tell the user whether they have the virus or not
	public void Conclusion(String Answer)
	{
		if(Answer.contains("yes"))
		{
			JOptionPane.showMessageDialog(this, "CoronaVirus test result: Positive");
		}
		if(Answer.contains("no"))
		{
			JOptionPane.showMessageDialog(this, "CoronaVirus test result: Negative");
		}
	}
}


