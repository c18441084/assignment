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
	JButton button1, button2;
	JPanel centerPanel, southPanel, northPanel;
	JTextField text1, text2, text3, text4, text5;
	int times = 0;
	
	public GUI(String myTitle, int k)
	{
		super(myTitle);
		setSize(600, 600);
		
		BorderLayout bl1 = new BorderLayout();
		setLayout(bl1);
		
		//Labels & texts
		label1 = new JLabel("CoronaVirus Test");
		label2 = new JLabel("Enter Temperature: ");
		label3 = new JLabel("Have you had aches?: ");
		label4 = new JLabel("Have you been coughing?: ");
		label5 = new JLabel("Do you have a sore throat?: ");
		label6 = new JLabel("Have you recently visited a country with COVID 19?: ");
		text1 = new JTextField("(hot/normal/cool/cold)");
		text2 = new JTextField("(yes/no)");
		text3 = new JTextField("(yes/no)");
		text4 = new JTextField("(yes/no)");
		text5 = new JTextField("(yes/no)");
		
		//Buttons
		button1 = new JButton("Test");
		button2 = new JButton("Reset");
		button1.addActionListener(this);
		button2.addActionListener(this);
		
		
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
		southPanel.add(button2);
		add(southPanel, BorderLayout.SOUTH);
		
		button2.setEnabled(false);
		if(k == 0)
		{
			setVisible(true);
		}
		else
		{
			setVisible(false);
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent myEvent)
	{
		String temper = text1.getText();
		temper.toLowerCase();
		String ache = text2.getText();
		ache.toLowerCase();
		String cough = text3.getText(); 
		cough.toLowerCase();
		String sorethroat = text4.getText();
		sorethroat.toLowerCase();
		String visited = text5.getText();
		visited.toLowerCase();
		String[] answerArray = new String[6];
		int i = 0;
		if(myEvent.getSource() == button1)
		{		
			//Temperature answer
			if(i == 0)
			{
				if(temper.contains("hot") || temper.contains("normal") || temper.contains("cool") || temper.contains("cold"))
				{
					answerArray[i] = temper;
					i++;
				}
				else
				{
					JOptionPane.showMessageDialog(this, "Please enter correct answers only");
					for(i = 0; i < 5; i++)
					{
						answerArray[i] = "";
					}
				}
			}
			
			
			//Ache answer
			if(i == 1)
			{
				if(ache.contains("yes") || ache.contains("no"))
				{
					answerArray[i] = ache;
					i++;
				}
				else
				{
					JOptionPane.showMessageDialog(this, "Please enter correct answers only");
					for(i = 0; i < 5; i++)
					{
						answerArray[i] = "";
					}
				}
			}
			
			//Cough answer
			if(i == 2)
			{
				if(cough.contains("yes") || cough.contains("no"))
				{
					answerArray[i] = cough;
					i++;
				}
				else
				{
					JOptionPane.showMessageDialog(this, "Please enter correct answers only");
					for(i = 0; i < 5; i++)
					{
						answerArray[i] = "";
					}
				}
			}
			
			//Sore Throat answer
			if(i == 3)
			{
				if(sorethroat.contains("yes") || sorethroat.contains("no"))
				{
					answerArray[i] = sorethroat;
					i++;
				}
				else
				{
					JOptionPane.showMessageDialog(this, "Please enter correct answers only");
					for(i = 0; i < 5; i++)
					{
						answerArray[i] = "";
					}
				}
			}
			
			//Recently Visited
			if(i == 4)
			{
				if(visited.contains("yes") || visited.contains("no"))
				{
					answerArray[i] = visited;
					i++;
				}
				else
				{
					JOptionPane.showMessageDialog(this, "Please enter one of the correct answers");
					for(i = 0; i < 5; i++)
					{
						answerArray[i] = "";
					}
				}
			}
			//Sending array of users answers to the Controllor.java class
			Controllor.main(answerArray);
			button1.setEnabled(false);
			button2.setEnabled(true);
		}
		
		if(myEvent.getSource() == button2)
		{
			for(i = 0; i < 5; i++)
			{
				answerArray[i] = "";
			}
			JOptionPane.showMessageDialog(this, "The GUI has been reset. Enter new options.");
			button1.setEnabled(true);
			button2.setEnabled(false);
		}
	}
	
	//Method to tell the user whether they have the virus or not
	public void Conclusion(String Answer, double accuracy)
	{
		if(Answer.contains("yes"))
		{
			JOptionPane.showMessageDialog(this, "CoronaVirus test result: Positive \nMachine Accuracy: " + accuracy + "%");
		}
		if(Answer.contains("no"))
		{
			JOptionPane.showMessageDialog(this, "CoronaVirus test result: Negative \nMachine Accuracy: " + accuracy + "%");
		}
		
	}

}


