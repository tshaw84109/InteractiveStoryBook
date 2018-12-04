/* 
 * 1410 Team Assignment
 * by Ahmed Alghafli, Nathan Goldhardt, Tyler Shaw 
 * 12/6/16
 */

import java.awt.EventQueue;


import javax.swing.JFrame;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;

import java.awt.Color;
import java.awt.Font;
import java.awt.BorderLayout;
import javax.swing.JTextArea;
/**
 * Gui, main class. This application is an interactive storybook. Enjoy!
 */
public class AppInterface {


    private JFrame frame;
    Scanner input = new Scanner(System.in);
    private JPanel mainPanel, pagePanel_0, pagePanel_1, pagePanel_2, pagePanel_3, pagePanel_4, pagePanel_5, pagePanel_6;
    private JTextField nameField;
    String name;
    Story myStory;
    private JButton pastPlayersButton;
    private JPanel pastPlayerPanel;
    private JTextArea pastPlayerTextArea;
    private JButton btnReturnToStory;


    
     public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AppInterface window = new AppInterface();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }


    
     
    public AppInterface() {
        initialize();
    }

    
    private void initialize() {
        //create the frame
    	frame = new JFrame();
        frame.setBounds(100, 100, 800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new CardLayout(0, 0));
        
        //holds all of the initialized imageicons
        ImageIcons myImageIcons = new ImageIcons();
        
        //main panel
        mainPanel = new JPanel();
        mainPanel.setBackground(Color.WHITE);
        frame.getContentPane().add(mainPanel, "name_13355907652124");
        mainPanel.setLayout(null);
        
        JLabel ImageMainPageLabel = new JLabel("");
        ImageMainPageLabel.setIcon(myImageIcons.main_title);
        ImageMainPageLabel.setSize(570, 398);
        ImageMainPageLabel.setBounds(125, 13, 570, 398);
        mainPanel.add(ImageMainPageLabel);
        
        JTextPane EnterYourNameLable = new JTextPane();
        EnterYourNameLable.setEditable(false);
        EnterYourNameLable.setText("Enter your name... ?");
        
        EnterYourNameLable.setBounds(256, 445, 134, 22);
        mainPanel.add(EnterYourNameLable);
        
        nameField = new JTextField();
        nameField.setBounds(256, 480, 326, 22);
        mainPanel.add(nameField);        
        nameField.setColumns(10);
        
        
        JButton startButton = new JButton("Start your Adventure");
        startButton.setToolTipText("Start the Game");
        startButton.setForeground(Color.BLACK);
        startButton.setFont(new Font("Times New Roman", Font.BOLD, 18));
        startButton.setBackground(Color.WHITE);
        startButton.setBounds(256, 515, 326, 25);
        mainPanel.add(startButton);
        
        
        //past players
        pastPlayersButton = new JButton("See Past Players");
        pastPlayersButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e)
        	{
        		mainPanel.setVisible(false);
                pagePanel_0.setVisible(false);
                pastPlayerPanel.setVisible(true);
                System.out.println(readPastPlayers());
        	}
        });
        pastPlayersButton.setBounds(617, 480, 134, 23);
        mainPanel.add(pastPlayersButton);
       
        
       //page 0
       pagePanel_0 = new JPanel();
       pagePanel_0.setBackground(Color.WHITE);
       frame.getContentPane().add(pagePanel_0, "name_13360303551642");
       pagePanel_0.setLayout(null);
       JLabel ImagePageLabel_0 = new JLabel("");
       ImagePageLabel_0.setIcon(myImageIcons.page0);;
       ImagePageLabel_0.setBounds(95, 13, 545, 361);
       pagePanel_0.add(ImagePageLabel_0);
       
       pastPlayerPanel = new JPanel();
       frame.getContentPane().add(pastPlayerPanel, "name_230187875331008");
       pastPlayerPanel.setLayout(new BorderLayout(0, 0));
       
       pastPlayerTextArea = new JTextArea();
       pastPlayerPanel.add(pastPlayerTextArea, BorderLayout.CENTER);
       pastPlayerTextArea.setText("The Past Players Were:\n\n" + readPastPlayers());
       
       btnReturnToStory = new JButton("Return to Story");
       btnReturnToStory.addActionListener(new ActionListener() {
       	public void actionPerformed(ActionEvent e)
       	{
       		pastPlayerPanel.setVisible(false);
       		mainPanel.setVisible(true);
       	}
       });
       pastPlayerPanel.add(btnReturnToStory, BorderLayout.SOUTH);
       
       //Everything that follows is inside the action listener. It's ugly, sorry I couldn't figure a better way - Tyler
       startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                mainPanel.setVisible(false);
                pagePanel_0.setVisible(true);
                name = nameField.getText();
                
                myStory = new Story(name);
            
                writePlayerName(name);
        

		        JButton chButton_1 = new JButton("Stop and investigate");
		        chButton_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		        chButton_1.setForeground(Color.BLACK);
		        chButton_1.setBackground(Color.WHITE);
		        chButton_1.addActionListener(new ActionListener() {
		            public void actionPerformed(ActionEvent e) {
		                pagePanel_0.setVisible(false);
		                pagePanel_1.setVisible(true);
		            }
		        });
		        chButton_1.setBounds(12, 488, 758, 25);
		        pagePanel_0.add(chButton_1);
		        
		        JButton chButton_2 = new JButton("Continue home to Earth");
		        chButton_2.setFont(new Font("Times New Roman", Font.BOLD, 18));
		        chButton_2.setForeground(Color.BLACK);
		        chButton_2.setBackground(Color.WHITE);
		        chButton_2.addActionListener(new ActionListener() {
		            public void actionPerformed(ActionEvent e) {
		                pagePanel_0.setVisible(false);
		                pagePanel_2.setVisible(true);
		            }
		        });
		        chButton_2.setBounds(12, 515, 758, 25);
		        pagePanel_0.add(chButton_2);
		        
		        JTextPane firstStoryTxt = new JTextPane();
		        firstStoryTxt.setFont(new Font("Tekton Pro Ext", Font.PLAIN, 18));
		        firstStoryTxt.setEditable(false);
		        firstStoryTxt.setText(myStory.getTxtPage_0());
		        firstStoryTxt.setBounds(12, 394, 758, 81);
		        pagePanel_0.add(firstStoryTxt);
		        
		        
		        //page 1
		        pagePanel_1 = new JPanel();
		        pagePanel_1.setBackground(Color.WHITE);
		        frame.getContentPane().add(pagePanel_1, "name_13363779068921");
		        pagePanel_1.setLayout(null);
		        
		        JLabel imagePage_1Label = new JLabel("");
		        imagePage_1Label.setIcon(myImageIcons.page1);
		        imagePage_1Label.setBounds(104, 13, 546, 356);
		        pagePanel_1.add(imagePage_1Label);
		        
		        JTextPane txtPage_1 = new JTextPane();
		        txtPage_1.setEditable(false);
		        txtPage_1.setText(myStory.getTxtPage_1());
		        txtPage_1.setBounds(12, 396, 758, 61);
		        pagePanel_1.add(txtPage_1);
		        
		        JButton chPage1_1Button = new JButton("Explore the cave");
		        chPage1_1Button.setFont(new Font("Times New Roman", Font.BOLD, 18));
		        chPage1_1Button.setForeground(Color.BLACK);
		        chPage1_1Button.setBackground(Color.WHITE);
		        chPage1_1Button.addActionListener(new ActionListener() {
		            public void actionPerformed(ActionEvent e) {
		                pagePanel_1.setVisible(false);
		                pagePanel_3.setVisible(true);
		            }
		        });
		        chPage1_1Button.setBounds(12, 490, 758, 25);
		        pagePanel_1.add(chPage1_1Button);
		        
		        JButton chPage1_2Button = new JButton("Explore the rover");
		        chPage1_2Button.setFont(new Font("Times New Roman", Font.BOLD, 18));
		        chPage1_2Button.setForeground(Color.BLACK);
		        chPage1_2Button.setBackground(Color.WHITE);
		        chPage1_2Button.addActionListener(new ActionListener() {
		            public void actionPerformed(ActionEvent e) {
		                pagePanel_1.setVisible(false);
		                pagePanel_4.setVisible(true);
		            }
		        });
		        chPage1_2Button.setBounds(12, 515, 758, 25);
		        pagePanel_1.add(chPage1_2Button);
		        

		        //page 2
		        pagePanel_2 = new JPanel();
		        pagePanel_2.setBackground(Color.WHITE);
		        frame.getContentPane().add(pagePanel_2, "name_13366845143506");
		        pagePanel_2.setLayout(null);
		        
		        JLabel page2ImageLabel = new JLabel("");
		        imagePage_1Label.setIcon(myImageIcons.page2);
		        page2ImageLabel.setBounds(107, 13, 540, 358);
		        pagePanel_2.add(page2ImageLabel);
		        
		        JTextPane txtPage_2 = new JTextPane();
		        txtPage_2.setEditable(false);
		        txtPage_2.setText(myStory.getTxtPage_2());
		        txtPage_2.setBounds(12, 384, 758, 70);
		        pagePanel_2.add(txtPage_2);
		        
		        JButton chPage2_1Button = new JButton("Head back to Mars to investigate");
		        chPage2_1Button.setForeground(Color.BLACK);
		        chPage2_1Button.setFont(new Font("Times New Roman", Font.BOLD, 18));
		        chPage2_1Button.setBackground(Color.WHITE);
		        chPage2_1Button.addActionListener(new ActionListener() {
		            public void actionPerformed(ActionEvent e) {
		                pagePanel_2.setVisible(false);
		                pagePanel_4.setVisible(true);
		            }
		        });
		        chPage2_1Button.setBounds(12, 467, 758, 25);
		        pagePanel_2.add(chPage2_1Button);
		        
		        JButton chPage2_2Button = new JButton("Continue home to Earth");
		        chPage2_2Button.setBackground(Color.WHITE);
		        chPage2_2Button.setFont(new Font("Times New Roman", Font.BOLD, 18));
		        chPage2_2Button.addActionListener(new ActionListener() {
		            public void actionPerformed(ActionEvent e) {
		                pagePanel_2.setVisible(false);
		                pagePanel_6.setVisible(true);
		            }
		        });
		        chPage2_2Button.setBounds(12, 505, 758, 25);
		        pagePanel_2.add(chPage2_2Button);
		        
		        
		        
		        //page 3
		        pagePanel_3 = new JPanel();
		        pagePanel_3.setBackground(Color.WHITE);
		        frame.getContentPane().add(pagePanel_3, "name_13369447256847");
		        pagePanel_3.setLayout(null);
		        
		        JLabel page3ImageLable = new JLabel("");
		        page3ImageLable.setIcon(myImageIcons.page3);
		        page3ImageLable.setBounds(110, 13, 540, 352);
		        pagePanel_3.add(page3ImageLable);
		        
		        JTextPane txtPage_3 = new JTextPane();
		        txtPage_3.setEditable(false);
		        txtPage_3.setText(myStory.getTxtPage_3());
		        txtPage_3.setBounds(22, 378, 748, 83);
		        pagePanel_3.add(txtPage_3);
		        
		        JButton chPage3_1Button = new JButton("Refill at ship and explore the rover");
		        chPage3_1Button.setFont(new Font("Times New Roman", Font.BOLD, 18));
		        chPage3_1Button.setBackground(Color.WHITE);
		        chPage3_1Button.addActionListener(new ActionListener() {
		            public void actionPerformed(ActionEvent e) {
		                pagePanel_3.setVisible(false);
		                pagePanel_4.setVisible(true);
		            }
		        });
		        chPage3_1Button.setBounds(12, 474, 758, 25);
		        pagePanel_3.add(chPage3_1Button);
		        
		        JButton chPage3_2Button = new JButton("Continue towards the faint light");
		        chPage3_2Button.setBackground(Color.WHITE);
		        chPage3_2Button.setFont(new Font("Times New Roman", Font.BOLD, 18));
		        chPage3_2Button.addActionListener(new ActionListener() {
		            public void actionPerformed(ActionEvent e) {
		                pagePanel_3.setVisible(false);
		                pagePanel_5.setVisible(true);
		            }
		        });
		        chPage3_2Button.setBounds(12, 512, 758, 25);
		        pagePanel_3.add(chPage3_2Button);
		        
		        
		        //page 4
		        pagePanel_4 = new JPanel();
		        pagePanel_4.setBackground(Color.WHITE);
		        frame.getContentPane().add(pagePanel_4, "name_62083575736520");
		        pagePanel_4.setLayout(null);
		        
		        JLabel page4ImageLable = new JLabel("");
		        page4ImageLable.setIcon(myImageIcons.page4);
		        page4ImageLable.setBounds(133, 13, 550, 364);
		        pagePanel_4.add(page4ImageLable);
		        
		        JTextPane txtPage_4 = new JTextPane();
		        txtPage_4.setEditable(false);
		        txtPage_4.setText(myStory.getTxtPage_4());
		        txtPage_4.setBounds(12, 390, 758, 81);
		        pagePanel_4.add(txtPage_4);
		        
		        JButton chPage4_1Button = new JButton("Explore the coordinates");
		        chPage4_1Button.setFont(new Font("Times New Roman", Font.BOLD, 18));
		        chPage4_1Button.setBackground(Color.WHITE);
		        chPage4_1Button.addActionListener(new ActionListener() {
		            public void actionPerformed(ActionEvent e) {
		                pagePanel_4.setVisible(false);
		                pagePanel_5.setVisible(true);
		            }
		        });
		        chPage4_1Button.setBounds(12, 481, 758, 25);
		        pagePanel_4.add(chPage4_1Button);
		        
		        JButton chPage4_2Button = new JButton("Return to Earth");
		        chPage4_2Button.setFont(new Font("Times New Roman", Font.BOLD, 18));
		        chPage4_2Button.setBackground(Color.WHITE);
		        chPage4_2Button.addActionListener(new ActionListener() {
		            public void actionPerformed(ActionEvent e) {
		                pagePanel_4.setVisible(false);
		                pagePanel_6.setVisible(true);
		            }
		        });
		        chPage4_2Button.setBounds(12, 515, 758, 25);
		        pagePanel_4.add(chPage4_2Button);
		        
		        
		        
		        //page 5
		        pagePanel_5 = new JPanel();
		        pagePanel_5.setBackground(Color.WHITE);
		        frame.getContentPane().add(pagePanel_5, "name_62312805684484");
		        pagePanel_5.setLayout(null);
		        
		        JLabel page5ImageLable = new JLabel("");
		        page5ImageLable.setIcon(myImageIcons.page5);
		        page5ImageLable.setBounds(90, 13, 564, 360);
		        pagePanel_5.add(page5ImageLable);
		        
		        JTextPane txtPage_5 = new JTextPane();
		        txtPage_5.setEditable(false);
		        txtPage_5.setText(myStory.getTxtPage_5());
		        txtPage_5.setBounds(12, 386, 758, 82);
		        pagePanel_5.add(txtPage_5);
		        
		        JButton PlayAgainPage5Button = new JButton("play again");
		        PlayAgainPage5Button.setFont(new Font("Times New Roman", Font.BOLD, 18));
		        PlayAgainPage5Button.setBackground(Color.WHITE);
		        PlayAgainPage5Button.addActionListener(new ActionListener() {
		            public void actionPerformed(ActionEvent e) {
		                pagePanel_5.setVisible(false);
		                mainPanel.setVisible(true);
		            }
		        });
		        PlayAgainPage5Button.setBounds(12, 498, 758, 25);
		        pagePanel_5.add(PlayAgainPage5Button);
		        
		        
		        
		        //page 6
		         pagePanel_6 = new JPanel();
		         pagePanel_6.setBackground(Color.WHITE);
		        frame.getContentPane().add(pagePanel_6, "name_62451693018942");
		        pagePanel_6.setLayout(null);
		        
		        JLabel page6ImageLable = new JLabel("");
		        page6ImageLable.setIcon(myImageIcons.page6);
		        page6ImageLable.setBounds(118, 13, 548, 364);
		        pagePanel_6.add(page6ImageLable);
		        
		        JTextPane txtPage_6 = new JTextPane();
		        txtPage_6.setEditable(false);
		        txtPage_6.setText(myStory.getTxtPage_6());
		        txtPage_6.setBounds(12, 390, 758, 94);
		        pagePanel_6.add(txtPage_6);
		        
		        JButton PalyAgainPage6Button = new JButton("paly again");
		        PalyAgainPage6Button.setFont(new Font("Times New Roman", Font.BOLD, 18));
		        PalyAgainPage6Button.setBackground(Color.WHITE);
		        PalyAgainPage6Button.addActionListener(new ActionListener() {
		            public void actionPerformed(ActionEvent e) {
		                pagePanel_6.setVisible(false);
		                mainPanel.setVisible(true);
		            }
		        });
		        PalyAgainPage6Button.setBounds(12, 502, 758, 25);
		        pagePanel_6.add(PalyAgainPage6Button);
	        }
        });
        
    }
    
    //writes the entered player name, in the gui method, to an external file.
    //Writes to the bin folder (will not work if the code is put into a jar)
    private static void writePlayerName(String name)
    {
    	File file = new File("bin\\players.txt");
    	try(PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(file, true))))
		{
			writer.println(name);
		} catch (Exception e)
		{
			System.err.println("Something went wrong.");
			System.err.println(e);
		}
    }
    
    /*Reads an external file to get the names of the last players,
    * looks in a relative path for the folder, which means it will look in the bin folder
    */
    private static String readPastPlayers()
    {
    StringBuilder sb = new StringBuilder();
    
    	try (Scanner reader = new Scanner(AppInterface.class.getResourceAsStream("players.txt")))
		{
			while(reader.hasNext())
			{
				//get nextline in file
				String temp = reader.nextLine();
				//check that nextLine is not null
				if(temp != null)
				{
					//convert to mountain, then add to mountainList
					sb.append(temp + "\n");
				}
			}
		}
		catch(Exception e)
		{
			System.err.println("Could not find file");
			System.err.println(e);
		}
    	
    	return sb.toString();
    }
}