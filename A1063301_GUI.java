
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;
import javax.swing.*;

public class A1063301_GUI extends JFrame implements ActionListener,Runnable{
	public int size=(A1063301_Checkpoint5.a.size());
	public Image img1,img2,img3,img4;
	public static JLabel[] character_money;
	public static JLabel[] label_n;
	public static JLabel[] label_s;
	public static JLabel[] label_w;
	public static JLabel[] label_e;
	public JLabel turn,round,display_dicenum_label;
	public JButton Save,Load,Exit,dicebtn;
	public static int random_math=0,total_move=0;
	public static long move_second;
	public A1063301_GUI() {
		
		super("Checkpoint6");
		try {
			A1063301_Checkpoint5.Load("Character.txt","Land.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setSize(700, 700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setLayout(new BorderLayout());
		getContentPane().setBackground(Color.WHITE);
		
		

        JPanel button=new JPanel();
        button.setBackground(Color.WHITE);
        button.setLayout(new FlowLayout(FlowLayout.LEADING));
        JPanel p1=new JPanel();
        p1.setBackground(Color.WHITE);
        Save=new JButton("Save");
        Load=new JButton("Load");
        p1.setLayout(new GridLayout(1,10,30,10));
        Save.addActionListener(this);
        p1.add(Save);
        Load.addActionListener(this);
        p1.add(Load);
        p1.setPreferredSize(new Dimension(180,20));
        button.add(p1);
        
        JPanel character_panel=new JPanel();
        character_panel.setLayout(new FlowLayout(FlowLayout.CENTER));
        character_panel.setBackground(Color.WHITE);
        //character_panel.setPreferredSize(new Dimension(500,50));
        int size3=(A1063301_Checkpoint5.a.size()/5);
        JPanel[] character_numpanel2=new JPanel[size3];
        JLabel[] character_num=new JLabel[size3];
        character_money=new JLabel[size3];
        for(int c=0;c<size3;c++) {
        	character_numpanel2[c]=new JPanel();
        	character_numpanel2[c].setLayout(new GridLayout(2,1));
            character_numpanel2[c].setBackground(Color.WHITE);
            character_num[c]=new JLabel("Character"+A1063301_Checkpoint5.Character[c].CHARACTER_NUMBER);
            character_num[c].setFont(new Font("Character"+A1063301_Checkpoint5.Character[c].CHARACTER_NUMBER, Font.BOLD, 13));
            character_num[c].setPreferredSize(new Dimension(100,13));
            character_numpanel2[c].add(character_num[c]);
            character_money[c]=new JLabel("  "+"  "+"  "+A1063301_Checkpoint5.Character[c].money);
            character_money[c].setFont(new Font("  "+"  "+"  "+A1063301_Checkpoint5.Character[c].money, Font.BOLD, 13));
            character_money[c].setPreferredSize(new Dimension(100,13));
            character_numpanel2[c].add(character_money[c]);
        	character_panel.add(character_numpanel2[c]);
        }
        character_panel.setPreferredSize(new Dimension(420,35));
        button.add(character_panel);
        button.setPreferredSize(new Dimension(690,35));
        add(button,BorderLayout.NORTH);
        
        JPanel map=new JPanel();
        map.setLayout(new BorderLayout());
        map.setBackground(Color.WHITE);
       
        JPanel map_CENTER=new JPanel();
        map_CENTER.setLayout(new BorderLayout());
        map_CENTER.setBackground(Color.WHITE);
        JPanel bigtitle=new JPanel();
        bigtitle.setLayout(new FlowLayout(FlowLayout.LEADING));
        bigtitle.setBackground(Color.WHITE);
        ImageIcon title = new ImageIcon("title.png");
        JLabel title_label = new JLabel(title);
        bigtitle.add(title_label);
        map_CENTER.add(bigtitle,BorderLayout.NORTH);
        
        JPanel dicePanel=new JPanel();
        dicePanel.setLayout(new GridLayout(1,2));
        dicePanel.setBackground(Color.WHITE);
        JPanel bigdice=new JPanel();
        bigdice.setBackground(Color.WHITE);
        ImageIcon dice = new ImageIcon("Dice.png");
        dicebtn= new JButton(dice);
        dicebtn.setBackground(Color.WHITE);
        dicebtn.addActionListener(this);
        dicebtn.setPreferredSize(new Dimension(159,158));
        dicebtn.setBorder(null);
        bigdice.add(dicebtn);
        dicePanel.add(bigdice);
        
        JPanel display=new JPanel();
        display.setLayout(new GridLayout(2,1));
        display.setBackground(Color.WHITE);
        
        ImageIcon display_dicenum = new ImageIcon("display_dicenum.png");
        display_dicenum_label = new JLabel(){
        	public void paintComponent(Graphics g) {
        		g.drawImage(display_dicenum.getImage(),30, 0, null);
        		super.paintComponent(g);
          }
        };
        display_dicenum_label.setText("0");
        display_dicenum_label.setBackground(Color.WHITE);
        display_dicenum_label.setHorizontalAlignment(display_dicenum_label.CENTER);
        display_dicenum_label.setFont(new Font("", Font.BOLD, 50));
        display.add(display_dicenum_label);
        
        round= new JLabel("Round"+A1063301_Checkpoint5.round_Count);
        round.setHorizontalAlignment(round.CENTER);
        round.setFont(new Font("Round"+A1063301_Checkpoint5.round_Count, Font.BOLD, 25));
        display.add(round);
        
        dicePanel.add(display);
        map_CENTER.add(dicePanel,BorderLayout.CENTER);
        
        JPanel bigturn=new JPanel();
        bigturn.setLayout(new FlowLayout(FlowLayout.TRAILING));
        turn= new JLabel("Turn  Character "+A1063301_Checkpoint5.Character[A1063301_Checkpoint5.ch_num].CHARACTER_NUMBER);
        turn.setFont(new Font("Turn  Character"+A1063301_Checkpoint5.Character[A1063301_Checkpoint5.ch_num].CHARACTER_NUMBER, Font.BOLD, 28));
        bigturn.setBackground(Color.WHITE);
        bigturn.add(turn);
        map_CENTER.add(bigturn,BorderLayout.SOUTH);
        
        map.add(map_CENTER,BorderLayout.CENTER);
        
        JPanel map_NORTH=new JPanel();
        //map_NORTH.setPreferredSize(new Dimension(670,120));
        map_NORTH.setLayout(new FlowLayout(FlowLayout.CENTER,0,0));
        map_NORTH.setBackground(Color.WHITE);
        label_n= new JLabel[6];
        ImageIcon change_1 = new ImageIcon("10.png");
        label_n[0]=new JLabel(change_1);
        map_NORTH.add(label_n[0]);
        ImageIcon change_2 = new ImageIcon("11.png");
        //label_n[1]=new JLabel(change_2);
        label_n[1]=new JLabel(){
        	public void paintComponent(Graphics g) {
        		g.drawImage(change_2.getImage(),0, 0, null);
        		super.paintComponent(g);
          }
        };
        if(A1063301_Checkpoint5.Land[11].owner>0) {
    		label_n[1].setText(""+A1063301_Checkpoint5.Land[11].owner);
    	}
        else {
        	label_n[1].setText("");
        }
        label_n[1].setPreferredSize(new Dimension(91,119));
        label_n[1].setHorizontalAlignment(label_n[1].CENTER);
        label_n[1].setFont(new Font("", Font.BOLD, 50));
        map_NORTH.add(label_n[1]);
        ImageIcon change_3 = new ImageIcon("12.png");
        //label_n[2]=new JLabel(change_3);
        label_n[2]=new JLabel(){
        	public void paintComponent(Graphics g) {
        		g.drawImage(change_3.getImage(),0, 0, null);
        		super.paintComponent(g);
          }
        };
        if(A1063301_Checkpoint5.Land[12].owner>0) {
    		label_n[2].setText(""+A1063301_Checkpoint5.Land[12].owner);
    	}
        else {
        	label_n[2].setText("");
        }
        label_n[2].setPreferredSize(new Dimension(91,119));
        label_n[2].setHorizontalAlignment(label_n[2].CENTER);
        label_n[2].setFont(new Font("", Font.BOLD, 50));
        map_NORTH.add(label_n[2]);
        ImageIcon change_4 = new ImageIcon("13.png");
        //label_n[3]=new JLabel(change_4);
        label_n[3]=new JLabel(){
        	public void paintComponent(Graphics g) {
        		g.drawImage(change_4.getImage(),0, 0, null);
        		super.paintComponent(g);
          }
        };
        if(A1063301_Checkpoint5.Land[13].owner>0) {
    		label_n[3].setText(""+A1063301_Checkpoint5.Land[13].owner);
    	}
        else {
        	label_n[3].setText("");
        }
        label_n[3].setPreferredSize(new Dimension(91,119));
        label_n[3].setHorizontalAlignment(label_n[3].CENTER);
        label_n[3].setFont(new Font("", Font.BOLD, 50));
        map_NORTH.add(label_n[3]);
        ImageIcon change_5 = new ImageIcon("14.png");
        //label_n[4]=new JLabel(change_5);
        label_n[4]=new JLabel(){
        	public void paintComponent(Graphics g) {
        		g.drawImage(change_5.getImage(),0, 0, null);
        		super.paintComponent(g);
          }
        };
        if(A1063301_Checkpoint5.Land[14].owner>0) {
    		label_n[4].setText(""+A1063301_Checkpoint5.Land[14].owner);
    	}
        else {
        	label_n[4].setText("");
        }
        label_n[4].setPreferredSize(new Dimension(91,119));
        label_n[4].setHorizontalAlignment(label_n[4].CENTER);
        label_n[4].setFont(new Font("", Font.BOLD, 50));
        map_NORTH.add(label_n[4]);
        ImageIcon change_6 = new ImageIcon("15.png");
        label_n[5]=new JLabel(change_6);
        map_NORTH.add(label_n[5]);
        map.add(map_NORTH,BorderLayout.NORTH);
        
        JPanel map_SOUTH=new JPanel();
        //map_SOUTH.setPreferredSize(new Dimension(670,120));
        map_SOUTH.setLayout(new FlowLayout(FlowLayout.CENTER,0,0));
        map_SOUTH.setBackground(Color.WHITE);
        label_s= new JLabel[6];
        ImageIcon change_s1 = new ImageIcon("5.png");
        label_s[5]=new JLabel(change_s1);
        map_SOUTH.add(label_s[5]);
        ImageIcon change_s2 = new ImageIcon("4.png");
        //label_s[4]=new JLabel(change_s2);
        label_s[4]=new JLabel(){
        	public void paintComponent(Graphics g) {
        		g.drawImage(change_s2.getImage(),0, 0, null);
        		super.paintComponent(g);
          }
        };
        if(A1063301_Checkpoint5.Land[4].owner>0) {
    		label_s[4].setText(""+A1063301_Checkpoint5.Land[4].owner);
    	}
        else {
        	label_s[4].setText("");
        }
        label_s[4].setPreferredSize(new Dimension(91,119));
        label_s[4].setHorizontalAlignment(label_s[4].CENTER);
        label_s[4].setFont(new Font("", Font.BOLD, 50));
        map_SOUTH.add(label_s[4]);
        ImageIcon change_s3 = new ImageIcon("3.png");
        //label_s[3]=new JLabel(change_s3);
        label_s[3]=new JLabel(){
        	public void paintComponent(Graphics g) {
        		g.drawImage(change_s3.getImage(),0, 0, null);
        		super.paintComponent(g);
          }
        };
        if(A1063301_Checkpoint5.Land[3].owner>0) {
    		label_s[3].setText(""+A1063301_Checkpoint5.Land[3].owner);
    	}
        else {
        	label_s[3].setText("");
        }
        label_s[3].setPreferredSize(new Dimension(91,119));
        label_s[3].setHorizontalAlignment(label_s[3].CENTER);
        label_s[3].setFont(new Font("", Font.BOLD, 50));
        map_SOUTH.add(label_s[3]);
        ImageIcon change_s4 = new ImageIcon("2.png");
        //label_s[2]=new JLabel(change_s4);
        label_s[2]=new JLabel(){
        	public void paintComponent(Graphics g) {
        		g.drawImage(change_s4.getImage(),0, 0, null);
        		super.paintComponent(g);
          }
        };
        if(A1063301_Checkpoint5.Land[2].owner>0) {
    		label_s[2].setText(""+A1063301_Checkpoint5.Land[2].owner);
    	}
        else {
        	label_s[2].setText("");
        }
        label_s[2].setPreferredSize(new Dimension(91,119));
        label_s[2].setHorizontalAlignment(label_s[2].CENTER);
        label_s[2].setFont(new Font("", Font.BOLD, 50));
        
        map_SOUTH.add(label_s[2]);
        ImageIcon change_s5 = new ImageIcon("1.png");
        //label_s[1]=new JLabel(change_s5);
        label_s[1]=new JLabel(){
        	public void paintComponent(Graphics g) {
        		g.drawImage(change_s5.getImage(),0, 0, null);
        		super.paintComponent(g);
          }
        };
        if(A1063301_Checkpoint5.Land[1].owner>0) {
    		label_s[1].setText(""+A1063301_Checkpoint5.Land[1].owner);
    	}
        else {
        	label_s[1].setText("");
        }
        label_s[1].setPreferredSize(new Dimension(91,119));
        label_s[1].setHorizontalAlignment(label_s[1].CENTER);
        label_s[1].setFont(new Font("", Font.BOLD, 50));
        map_SOUTH.add(label_s[1]);
        ImageIcon change_s6 = new ImageIcon("0.png");
        label_s[0]=new JLabel(change_s6);
        map_SOUTH.add(label_s[0]);
        map.add(map_SOUTH,BorderLayout.SOUTH);
        
        JPanel map_WEST=new JPanel();
        //map_WEST.setPreferredSize(new Dimension(150,0));
        map_WEST.setLayout(new GridLayout(4,1,0,0));
        map_WEST.setBackground(Color.WHITE);
        label_w= new JLabel[4];
        ImageIcon change_w1 = new ImageIcon("9.png");
        //label_w[3]=new JLabel(change_w1);
        label_w[3]=new JLabel(){
        	public void paintComponent(Graphics g) {
        		g.drawImage(change_w1.getImage(),0,0,change_w1.getIconWidth(),change_w1.getIconHeight(),null);
        		super.paintComponent(g);
          }
        };
        if(A1063301_Checkpoint5.Land[9].owner>0) {
    		label_w[3].setText(""+A1063301_Checkpoint5.Land[9].owner);
    	}
        else {
        	label_w[3].setText("");
        }
        label_w[3].setPreferredSize(new Dimension(change_w1.getIconWidth(),change_w1.getIconHeight()));
        label_w[3].setHorizontalAlignment(label_w[3].CENTER);
        label_w[3].setFont(new Font("", Font.BOLD, 50));
        map_WEST.add(label_w[3]);
        ImageIcon change_w2 = new ImageIcon("8.png");
        //label_w[2]=new JLabel(change_w2);
        label_w[2]=new JLabel(){
        	public void paintComponent(Graphics g) {
        		g.drawImage(change_w2.getImage(),0, 0, null);
        		super.paintComponent(g);
          }
        };
        if(A1063301_Checkpoint5.Land[8].owner>0) {
    		label_w[2].setText(""+A1063301_Checkpoint5.Land[8].owner);
    	}
        else {
        	label_w[2].setText("");
        }
        label_w[2].setPreferredSize(new Dimension(90,0));
        label_w[2].setHorizontalAlignment(label_w[2].CENTER);
        label_w[2].setFont(new Font("", Font.BOLD, 50));
        map_WEST.add(label_w[2]);
        ImageIcon change_w3 = new ImageIcon("7.png");
        //label_w[1]=new JLabel(change_w3);
        label_w[1]=new JLabel(){
        	public void paintComponent(Graphics g) {
        		g.drawImage(change_w3.getImage(),0,0,change_w3.getIconWidth(),change_w3.getIconHeight(),null);
        		super.paintComponent(g);
          }
        };
        if(A1063301_Checkpoint5.Land[7].owner>0) {
    		label_w[1].setText(""+A1063301_Checkpoint5.Land[7].owner);
    	}
        else {
        	label_w[1].setText("");
        }
        label_w[1].setPreferredSize(new Dimension(change_w3.getIconWidth(),change_w3.getIconHeight()));
        label_w[1].setHorizontalAlignment(label_w[1].CENTER);
        label_w[1].setFont(new Font("", Font.BOLD, 50));
        map_WEST.add(label_w[1]);
        ImageIcon change_w4 = new ImageIcon("6.png");
        //label_w[0]=new JLabel(change_w4);
        label_w[0]=new JLabel(){
        	public void paintComponent(Graphics g) {
        		g.drawImage(change_w4.getImage(),0,0,change_w4.getIconWidth(),change_w4.getIconHeight(),null);
        		super.paintComponent(g);
          }
        };
        if(A1063301_Checkpoint5.Land[6].owner>0) {
    		label_w[0].setText(""+A1063301_Checkpoint5.Land[6].owner);
    	}
        else {
        	label_w[0].setText("");
        }
        label_w[0].setPreferredSize(new Dimension(change_w4.getIconWidth(),change_w4.getIconHeight()));
        label_w[0].setHorizontalAlignment(label_w[0].CENTER);
        label_w[0].setFont(new Font("", Font.BOLD, 50));
        map_WEST.add(label_w[0]);
        map.add(map_WEST,BorderLayout.WEST);
        
        JPanel map_EAST=new JPanel();
        //map_EAST.setPreferredSize(new Dimension(150,0));
        map_EAST.setLayout(new GridLayout(4,1,0,0));
        map_EAST.setBackground(Color.WHITE);
        label_e= new JLabel[4];
        ImageIcon change_e1 = new ImageIcon("16.png");
        //label_e[0]=new JLabel(change_e1);
        label_e[0]=new JLabel(){
        	public void paintComponent(Graphics g) {
        		g.drawImage(change_e1.getImage(),0,0,change_e1.getIconWidth(),change_e1.getIconHeight(),null);
        		super.paintComponent(g);
          }
        };
        if(A1063301_Checkpoint5.Land[16].owner>0) {
    		label_e[0].setText(""+A1063301_Checkpoint5.Land[16].owner);
    	}
        else {
        	label_e[0].setText("");
        }
        label_e[0].setPreferredSize(new Dimension(change_e1.getIconWidth(),change_e1.getIconHeight()));
        label_e[0].setHorizontalAlignment(label_e[0].CENTER);
        label_e[0].setFont(new Font("", Font.BOLD, 50));
        map_EAST.add(label_e[0]);
        ImageIcon change_e2 = new ImageIcon("17.png");
        //label_e[1]=new JLabel(change_e2);
        label_e[1]=new JLabel(){
        	public void paintComponent(Graphics g) {
        		g.drawImage(change_e2.getImage(),0,0,change_e2.getIconWidth(),change_e2.getIconHeight(),null);
        		super.paintComponent(g);
          }
        };
        if(A1063301_Checkpoint5.Land[17].owner>0) {
    		label_e[1].setText(""+A1063301_Checkpoint5.Land[17].owner);
    	}
        else {
        	label_e[1].setText("");
        }
        label_e[1].setPreferredSize(new Dimension(change_e2.getIconWidth(),change_e2.getIconHeight()));
        label_e[1].setHorizontalAlignment(label_e[1].CENTER);
        label_e[1].setFont(new Font("", Font.BOLD, 50));
        map_EAST.add(label_e[1]);
        ImageIcon change_e3 = new ImageIcon("18.png");
        //label_e[2]=new JLabel(change_e3);
        label_e[2]=new JLabel(){
        	public void paintComponent(Graphics g) {
        		g.drawImage(change_e3.getImage(),0,0,change_e3.getIconWidth(),change_e3.getIconHeight(),null);
        		super.paintComponent(g);
          }
        };
        if(A1063301_Checkpoint5.Land[18].owner>0) {
    		label_e[2].setText(""+A1063301_Checkpoint5.Land[18].owner);
    	}
        else {
        	label_e[2].setText("");
        }
        label_e[2].setPreferredSize(new Dimension(change_e3.getIconWidth(),change_e3.getIconHeight()));
        label_e[2].setHorizontalAlignment(label_e[2].CENTER);
        label_e[2].setFont(new Font("", Font.BOLD, 50));
        map_EAST.add(label_e[2]);
        ImageIcon change_e4 = new ImageIcon("19.png");
        //label_e[3]=new JLabel(change_e4);
        label_e[3]=new JLabel(){
        	public void paintComponent(Graphics g) {
        		g.drawImage(change_e4.getImage(),0,0,change_e4.getIconWidth(),change_e4.getIconHeight(),null);
        		super.paintComponent(g);
          }
        };
        if(A1063301_Checkpoint5.Land[19].owner>0) {
    		label_e[3].setText(""+A1063301_Checkpoint5.Land[19].owner);
    	}
        else {
        	label_e[3].setText("");
        }
        label_e[3].setPreferredSize(new Dimension(change_e4.getIconWidth(),change_e4.getIconHeight()));
        label_e[3].setHorizontalAlignment(label_e[3].CENTER);
        label_e[3].setFont(new Font("", Font.BOLD, 50));
        map_EAST.add(label_e[3]);
        map.add(map_EAST,BorderLayout.EAST);
        
        add(map,BorderLayout.CENTER);
        
        JLabel west=new JLabel("          ");
        add(west,BorderLayout.WEST);
        JLabel east=new JLabel("           ");
        add(east,BorderLayout.EAST);
       
        JPanel p2=new JPanel();
        p2.setBackground(Color.WHITE);
        p2.setLayout(new FlowLayout(FlowLayout.TRAILING));
        Exit=new JButton("Exit");
        Exit.addActionListener(this);
        p2.add(Exit);
        add(p2,BorderLayout.SOUTH);
       
        img1= Toolkit.getDefaultToolkit().getImage("Character_1.png");
        img2= Toolkit.getDefaultToolkit().getImage("Character_2.png");
        img3= Toolkit.getDefaultToolkit().getImage("Character_3.png");
        img4= Toolkit.getDefaultToolkit().getImage("Character_4.png");
        
        setVisible(true);
	}
	
		public void actionPerformed(ActionEvent e) {
			final int size=(A1063301_Checkpoint5.a.size()/5);
			String command = e.getActionCommand();
            if (command=="Load") {
					setVisible(false); 
					try {
						A1063301_Checkpoint5.Load("Character.txt","Land.txt");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					//setVisible(false); 
					A1063301_GUI gui2=new A1063301_GUI();
										
					character_money[1]=new JLabel("  "+"  "+"  "+A1063301_Checkpoint5.Character[1].money);
		            character_money[1].setFont(new Font("  "+"  "+"  "+A1063301_Checkpoint5.Character[1].money, Font.BOLD, 15));
            }
            if (command=="Save") {
            	try {
            		A1063301_Checkpoint5.Save("Character.txt","Land.txt");
				} catch (IOException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
            }
			if (command=="Exit") {
				System.exit(0);
			}
			if (e.getSource()==dicebtn) {
				int size6=(A1063301_Checkpoint5.a.size()/5);
				if(A1063301_Checkpoint5.ch_num<=size6) {
					dicebtn.setEnabled(false);
					A1063301_Checkpoint5.Random();
					display_dicenum_label.setText(""+random_math);
					startThread();
				}
			}
		}
		@Override
		public void run() { 
			int size5=(A1063301_Checkpoint5.a.size()/5);
			//System.out.println("c:"+A1063301_Checkpoint5.ch_num);
				/*if(A1063301_Checkpoint5.ch_num==0) {
					A1063301_Checkpoint5.ch_num=(size5-1);
				}
				else {
					A1063301_Checkpoint5.ch_num-=1;
				}*/
				total_move=95*random_math;
				if(random_math >=1 && random_math <=3) {
					move_second=2000/total_move;
				}
				else {
					move_second=3000/total_move;
				}
					if(A1063301_Checkpoint5.y[A1063301_Checkpoint5.ch_num]>=560 && A1063301_Checkpoint5.x[A1063301_Checkpoint5.ch_num]>130) { //south
						int x_move=0;
						if(A1063301_Checkpoint5.ch_num==0 || A1063301_Checkpoint5.ch_num==2) { 
							if(A1063301_Checkpoint5.x[A1063301_Checkpoint5.ch_num]-95*random_math<65) {
								if(A1063301_Checkpoint5.x[A1063301_Checkpoint5.ch_num]>=550) {
									A1063301_Checkpoint5.y[A1063301_Checkpoint5.ch_num]-=10;
								}
								x_move=A1063301_Checkpoint5.x[A1063301_Checkpoint5.ch_num]-65;
								int x_run=0;
								while(x_run<x_move) {
									A1063301_Checkpoint5.x[A1063301_Checkpoint5.ch_num]--;
									doNothing(move_second);
									repaint();
									x_run++;
								}
								int y_move=((95*random_math)-x_move);
								A1063301_Checkpoint5.y[A1063301_Checkpoint5.ch_num]-=10;
								int y_run=0;
								while(y_run<y_move) {
									A1063301_Checkpoint5.y[A1063301_Checkpoint5.ch_num]--;
									doNothing(move_second);
									repaint();
									y_run++;
								}
							}
							else {
								x_move=95*random_math;
								int x_run=0;
								if(A1063301_Checkpoint5.x[A1063301_Checkpoint5.ch_num]==550) {
									A1063301_Checkpoint5.x[A1063301_Checkpoint5.ch_num]-=10;
								}
								while(x_run<x_move) {
									A1063301_Checkpoint5.x[A1063301_Checkpoint5.ch_num]--;
									doNothing(move_second);
									repaint();
									x_run++;
								}
							}
						}
						else if(A1063301_Checkpoint5.ch_num==1 || A1063301_Checkpoint5.ch_num==3) {  
							if(A1063301_Checkpoint5.x[A1063301_Checkpoint5.ch_num]-95*random_math<105) {
								if(A1063301_Checkpoint5.x[A1063301_Checkpoint5.ch_num]>=550) {
									A1063301_Checkpoint5.y[A1063301_Checkpoint5.ch_num]-=10;
								}
								x_move=A1063301_Checkpoint5.x[A1063301_Checkpoint5.ch_num]-105;
								int x_run=0;
								while(x_run<x_move) {
									A1063301_Checkpoint5.x[A1063301_Checkpoint5.ch_num]--;
									doNothing(move_second);
									repaint();
									x_run++;
								}
								int y_move=((95*random_math)-x_move);
								A1063301_Checkpoint5.y[A1063301_Checkpoint5.ch_num]-=10;
								int y_run=0;
								while(y_run<y_move) {
									A1063301_Checkpoint5.y[A1063301_Checkpoint5.ch_num]--;
									doNothing(move_second);
									repaint();
									y_run++;
								}
							}
							else {
								x_move=95*random_math;
								int x_run=0;
								if(A1063301_Checkpoint5.x[A1063301_Checkpoint5.ch_num]==590) {
									A1063301_Checkpoint5.x[A1063301_Checkpoint5.ch_num]-=10;
								}
								while(x_run<x_move) {
									A1063301_Checkpoint5.x[A1063301_Checkpoint5.ch_num]--;
									doNothing(move_second);
									repaint();
									x_run++;
								}
							}
						}
					}
					else if(A1063301_Checkpoint5.x[A1063301_Checkpoint5.ch_num]<=145 && A1063301_Checkpoint5.y[A1063301_Checkpoint5.ch_num]>125) {
						int y_move=0;
						if((A1063301_Checkpoint5.ch_num==0) || (A1063301_Checkpoint5.ch_num==1)) { 
							if(A1063301_Checkpoint5.y[A1063301_Checkpoint5.ch_num]-95*random_math<85) {
								if(A1063301_Checkpoint5.y[A1063301_Checkpoint5.ch_num]>=570) {
									A1063301_Checkpoint5.x[A1063301_Checkpoint5.ch_num]+=10;
								}
								y_move=A1063301_Checkpoint5.y[A1063301_Checkpoint5.ch_num]-85;
								int y_run=0;
								while(y_run<y_move) {
									A1063301_Checkpoint5.y[A1063301_Checkpoint5.ch_num]--;
									doNothing(move_second);
									repaint();
									y_run++;
								}
								int x_run=0;
								int x_move=(95*random_math)-y_move;
								A1063301_Checkpoint5.x[A1063301_Checkpoint5.ch_num]+=10;
								while(x_run<x_move) {
									A1063301_Checkpoint5.x[A1063301_Checkpoint5.ch_num]++;
									doNothing(move_second);
									repaint();
									x_run++;
								}
							}
							else {
								y_move=95*random_math;
								int y_run=0;
								if(A1063301_Checkpoint5.y[A1063301_Checkpoint5.ch_num]==570) {
									A1063301_Checkpoint5.y[A1063301_Checkpoint5.ch_num]-=10;
								}
								while(y_run<y_move) {
									A1063301_Checkpoint5.y[A1063301_Checkpoint5.ch_num]--;
									doNothing(move_second);
									repaint();
									y_run++;
								}
							}
						}
						else if((A1063301_Checkpoint5.ch_num==2) || (A1063301_Checkpoint5.ch_num==3)){  
							if(A1063301_Checkpoint5.y[A1063301_Checkpoint5.ch_num]-95*random_math<125) {
								if(A1063301_Checkpoint5.y[A1063301_Checkpoint5.ch_num]>=570) {
									A1063301_Checkpoint5.x[A1063301_Checkpoint5.ch_num]+=10;
								}
								y_move=A1063301_Checkpoint5.y[A1063301_Checkpoint5.ch_num]-125;
								int y_run=0;
								while(y_run<y_move) {
									A1063301_Checkpoint5.y[A1063301_Checkpoint5.ch_num]--;
									doNothing(move_second);
									repaint();
									y_run++;
								}
								int x_run=0;
								int x_move=(95*random_math)-y_move;
								A1063301_Checkpoint5.x[A1063301_Checkpoint5.ch_num]+=10;
								while(x_run<x_move) {
									A1063301_Checkpoint5.x[A1063301_Checkpoint5.ch_num]++;
									doNothing(move_second);
									repaint();
									x_run++;
								}
							}
							else {
								y_move=95*random_math;
								int y_run=0;
								if(A1063301_Checkpoint5.y[A1063301_Checkpoint5.ch_num]==610) {
									A1063301_Checkpoint5.y[A1063301_Checkpoint5.ch_num]-=10;
								}
								while(y_run<y_move) {
									A1063301_Checkpoint5.y[A1063301_Checkpoint5.ch_num]--;
									doNothing(move_second);
									repaint();
									y_run++;
								}
							}
						}
					}
					else if(A1063301_Checkpoint5.y[A1063301_Checkpoint5.ch_num]<=145 && A1063301_Checkpoint5.x[A1063301_Checkpoint5.ch_num]<550) {
						int x_move=0;
						if(A1063301_Checkpoint5.ch_num==0 || A1063301_Checkpoint5.ch_num==2) { 
							if(A1063301_Checkpoint5.x[A1063301_Checkpoint5.ch_num]+95*random_math>550) {
								if(A1063301_Checkpoint5.x[A1063301_Checkpoint5.ch_num]<=105) {
									A1063301_Checkpoint5.y[A1063301_Checkpoint5.ch_num]+=10;
								}
								x_move=550-A1063301_Checkpoint5.x[A1063301_Checkpoint5.ch_num];
								int x_run=0;
								while(x_run<x_move) {
									A1063301_Checkpoint5.x[A1063301_Checkpoint5.ch_num]++;
									doNothing(move_second);
									repaint();
									x_run++;
								}
								int y_move=((95*random_math)-x_move);
								A1063301_Checkpoint5.y[A1063301_Checkpoint5.ch_num]+=10;
								int y_run=0;
								while(y_run<y_move) {
									A1063301_Checkpoint5.y[A1063301_Checkpoint5.ch_num]++;
									doNothing(move_second);
									repaint();
									y_run++;
								}
								
							}
							else {
								x_move=95*random_math;
								int x_run=0;
								if(A1063301_Checkpoint5.x[A1063301_Checkpoint5.ch_num]==65) {
								A1063301_Checkpoint5.x[A1063301_Checkpoint5.ch_num]+=10;
								}
								while(x_run<x_move) {
									A1063301_Checkpoint5.x[A1063301_Checkpoint5.ch_num]++;
									doNothing(move_second);
									repaint();
									x_run++;
								}
							}
						}
						else if((A1063301_Checkpoint5.ch_num==1) || (A1063301_Checkpoint5.ch_num==3)){  
							if(A1063301_Checkpoint5.x[A1063301_Checkpoint5.ch_num]+95*random_math>590) {
								if(A1063301_Checkpoint5.x[A1063301_Checkpoint5.ch_num]<=105) {
									A1063301_Checkpoint5.y[A1063301_Checkpoint5.ch_num]+=10;
								}
								x_move=590-A1063301_Checkpoint5.x[A1063301_Checkpoint5.ch_num];
								int x_run=0;
								while(x_run<x_move) {
									A1063301_Checkpoint5.x[A1063301_Checkpoint5.ch_num]++;
									doNothing(move_second);
									repaint();
									x_run++;
								}
								int y_move=((95*random_math)-x_move);
								A1063301_Checkpoint5.y[A1063301_Checkpoint5.ch_num]+=10;
								int y_run=0;
								while(y_run<y_move) {
									A1063301_Checkpoint5.y[A1063301_Checkpoint5.ch_num]++;
									doNothing(move_second);
									repaint();
									y_run++;
								}
							}
							else {
								x_move=95*random_math;
								int x_run=0;
								if(A1063301_Checkpoint5.x[A1063301_Checkpoint5.ch_num]==105) {
									A1063301_Checkpoint5.x[A1063301_Checkpoint5.ch_num]+=10;
									}
								while(x_run<x_move) {
									A1063301_Checkpoint5.x[A1063301_Checkpoint5.ch_num]++;
									doNothing(move_second);
									repaint();
									x_run++;
								}
							}
						}
					}
					else if(A1063301_Checkpoint5.x[A1063301_Checkpoint5.ch_num]>=540 && A1063301_Checkpoint5.y[A1063301_Checkpoint5.ch_num]<570) {
						int y_move=0;
						if((A1063301_Checkpoint5.ch_num==0) || (A1063301_Checkpoint5.ch_num==1)) { 
							if(A1063301_Checkpoint5.y[A1063301_Checkpoint5.ch_num]+95*random_math>570) {
								if(A1063301_Checkpoint5.y[A1063301_Checkpoint5.ch_num]<=125) {
									A1063301_Checkpoint5.x[A1063301_Checkpoint5.ch_num]-=10;
								}
								y_move=570-A1063301_Checkpoint5.y[A1063301_Checkpoint5.ch_num];
								int y_run=0;
								while(y_run<y_move) {
									A1063301_Checkpoint5.y[A1063301_Checkpoint5.ch_num]++;
									doNothing(move_second);
									repaint();
									y_run++;
								}
								int x_run=0;
								int x_move=(95*random_math)-y_move;
								A1063301_Checkpoint5.x[A1063301_Checkpoint5.ch_num]-=10;
								while(x_run<x_move) {
									A1063301_Checkpoint5.x[A1063301_Checkpoint5.ch_num]--;
									doNothing(move_second);
									repaint();
									x_run++;
								}
							}
							else {
								int y_run=0;
								y_move=95*random_math;
								if(A1063301_Checkpoint5.y[A1063301_Checkpoint5.ch_num]==85) {
										A1063301_Checkpoint5.y[A1063301_Checkpoint5.ch_num]+=10;
								}
								while(y_run<y_move) {
									A1063301_Checkpoint5.y[A1063301_Checkpoint5.ch_num]++;
									doNothing(move_second);
									repaint();
									y_run++;
								}
							}
						}
						else if((A1063301_Checkpoint5.ch_num==2) || (A1063301_Checkpoint5.ch_num==3)){  
							if(A1063301_Checkpoint5.y[A1063301_Checkpoint5.ch_num]+95*random_math>610) {
								if(A1063301_Checkpoint5.y[A1063301_Checkpoint5.ch_num]<=125) {
									A1063301_Checkpoint5.x[A1063301_Checkpoint5.ch_num]-=10;
								}
								y_move=610-A1063301_Checkpoint5.y[A1063301_Checkpoint5.ch_num];
								int y_run=0;
								while(y_run<y_move) {
									A1063301_Checkpoint5.y[A1063301_Checkpoint5.ch_num]++;
									doNothing(move_second);
									repaint();
									y_run++;
								}
								int x_run=0;
								int x_move=(95*random_math)-y_move;
								A1063301_Checkpoint5.x[A1063301_Checkpoint5.ch_num]-=10;
								while(x_run<x_move) {
									A1063301_Checkpoint5.x[A1063301_Checkpoint5.ch_num]--;
									doNothing(move_second);
									repaint();
									x_run++;
								}
							}
							else {
								int y_run=0;
								y_move=95*random_math;
								if(A1063301_Checkpoint5.y[A1063301_Checkpoint5.ch_num]==125) {
									A1063301_Checkpoint5.y[A1063301_Checkpoint5.ch_num]+=10;
								}
								while(y_run<y_move) {
									A1063301_Checkpoint5.y[A1063301_Checkpoint5.ch_num]++;
									doNothing(move_second);
									repaint();
									y_run++;
								}
							}
						}
					}
					if((A1063301_Checkpoint5.Character[A1063301_Checkpoint5.ch_num].location-random_math)<0){
						A1063301_Checkpoint5.Character[A1063301_Checkpoint5.ch_num].money+=2000;
						character_money[A1063301_Checkpoint5.ch_num].setText("  "+"  "+"  "+A1063301_Checkpoint5.Character[A1063301_Checkpoint5.ch_num].money);
					}
					else if(A1063301_Checkpoint5.Character[A1063301_Checkpoint5.ch_num].location==0){
						A1063301_Checkpoint5.Character[A1063301_Checkpoint5.ch_num].money+=2000;
						character_money[A1063301_Checkpoint5.ch_num].setText("  "+"  "+"  "+A1063301_Checkpoint5.Character[A1063301_Checkpoint5.ch_num].money);
					}

					if((A1063301_Checkpoint5.Character[A1063301_Checkpoint5.ch_num].location)%5!=0) {
						if(A1063301_Checkpoint5.Land[A1063301_Checkpoint5.Character[A1063301_Checkpoint5.ch_num].location].owner==0) {
							if(A1063301_Checkpoint5.Character[A1063301_Checkpoint5.ch_num].money>=A1063301_Checkpoint5.Land[A1063301_Checkpoint5.Character[A1063301_Checkpoint5.ch_num].location].LAND_PRICE) {
							int buy_opt=JOptionPane.showConfirmDialog(null,"Do you want to buy?\n"+"            \t$"+A1063301_Checkpoint5.Land[A1063301_Checkpoint5.Character[A1063301_Checkpoint5.ch_num].location].LAND_PRICE,"Buy the land,yes or no?",JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE);
							if (buy_opt==JOptionPane.YES_OPTION) {
								A1063301_Checkpoint5.Character[A1063301_Checkpoint5.ch_num].money-=A1063301_Checkpoint5.Land[A1063301_Checkpoint5.Character[A1063301_Checkpoint5.ch_num].location].LAND_PRICE;
								character_money[A1063301_Checkpoint5.ch_num].setText("  "+"  "+"  "+A1063301_Checkpoint5.Character[A1063301_Checkpoint5.ch_num].money);
								A1063301_Checkpoint5.Land[A1063301_Checkpoint5.Character[A1063301_Checkpoint5.ch_num].location].owner=A1063301_Checkpoint5.Character[A1063301_Checkpoint5.ch_num].CHARACTER_NUMBER;
								if(A1063301_Checkpoint5.Character[A1063301_Checkpoint5.ch_num].location<5) {
									label_s[A1063301_Checkpoint5.Character[A1063301_Checkpoint5.ch_num].location].setText(""+A1063301_Checkpoint5.Land[A1063301_Checkpoint5.Character[A1063301_Checkpoint5.ch_num].location].owner);
									repaint();
								}
								else if(A1063301_Checkpoint5.Character[A1063301_Checkpoint5.ch_num].location<10) {
									label_w[(A1063301_Checkpoint5.Character[A1063301_Checkpoint5.ch_num].location)-6].setText(""+A1063301_Checkpoint5.Land[A1063301_Checkpoint5.Character[A1063301_Checkpoint5.ch_num].location].owner);
									repaint();
								}
								else if(A1063301_Checkpoint5.Character[A1063301_Checkpoint5.ch_num].location<15) {
									label_n[(A1063301_Checkpoint5.Character[A1063301_Checkpoint5.ch_num].location)-10].setText(""+A1063301_Checkpoint5.Land[A1063301_Checkpoint5.Character[A1063301_Checkpoint5.ch_num].location].owner);
									repaint();
								}
								else {
									label_e[(A1063301_Checkpoint5.Character[A1063301_Checkpoint5.ch_num].location)-16].setText(""+A1063301_Checkpoint5.Land[A1063301_Checkpoint5.Character[A1063301_Checkpoint5.ch_num].location].owner);
									repaint();
								}
								
							}
							else if (buy_opt==JOptionPane.NO_OPTION) {
							}
							}
						}
						else if(A1063301_Checkpoint5.Land[A1063301_Checkpoint5.Character[A1063301_Checkpoint5.ch_num].location].owner>0) {
							if(A1063301_Checkpoint5.Land[A1063301_Checkpoint5.Character[A1063301_Checkpoint5.ch_num].location].owner==A1063301_Checkpoint5.Character[A1063301_Checkpoint5.ch_num].CHARACTER_NUMBER) {
								
							}
							else {
								JOptionPane.showMessageDialog(null, "land owner is Character"+A1063301_Checkpoint5.Land[A1063301_Checkpoint5.Character[A1063301_Checkpoint5.ch_num].location].owner+",Character"+A1063301_Checkpoint5.Character[A1063301_Checkpoint5.ch_num].CHARACTER_NUMBER+" need to pay $"+A1063301_Checkpoint5.Land[A1063301_Checkpoint5.Character[A1063301_Checkpoint5.ch_num].location].TOLLS, "pay for tolls!!",JOptionPane.PLAIN_MESSAGE);
								A1063301_Checkpoint5.Character[A1063301_Checkpoint5.ch_num].money-=A1063301_Checkpoint5.Land[A1063301_Checkpoint5.Character[A1063301_Checkpoint5.ch_num].location].TOLLS;
								character_money[A1063301_Checkpoint5.ch_num].setText("  "+"  "+"  "+A1063301_Checkpoint5.Character[A1063301_Checkpoint5.ch_num].money);
								A1063301_Checkpoint5.Character[(A1063301_Checkpoint5.Land[A1063301_Checkpoint5.Character[A1063301_Checkpoint5.ch_num].location].owner)-1].money+=A1063301_Checkpoint5.Land[A1063301_Checkpoint5.Character[A1063301_Checkpoint5.ch_num].location].TOLLS;
								character_money[(A1063301_Checkpoint5.Land[A1063301_Checkpoint5.Character[A1063301_Checkpoint5.ch_num].location].owner)-1].setText("  "+"  "+"  "+A1063301_Checkpoint5.Character[(A1063301_Checkpoint5.Land[A1063301_Checkpoint5.Character[A1063301_Checkpoint5.ch_num].location].owner)-1].money);
								
							}
						}
						
					}
					/*if(A1063301_Checkpoint5.ch_num==(size5-1)) {
						A1063301_Checkpoint5.ch_num=0;
					}
					else {
						A1063301_Checkpoint5.ch_num+=1;
					}*/
					//dicebtn.setEnabled(true);
					
					if(A1063301_Checkpoint5.ch_num<=size5) {
						A1063301_Checkpoint5.ch_num++;
						if(A1063301_Checkpoint5.ch_num<size5) {
							if(A1063301_Checkpoint5.Character[A1063301_Checkpoint5.ch_num].status<=0) {
								A1063301_Checkpoint5.ch_num++;
								if(A1063301_Checkpoint5.ch_num==size5) {
									A1063301_Checkpoint5.ch_num=0;
									A1063301_Checkpoint5.round_Count+=1;
									round.setText("Round"+A1063301_Checkpoint5.round_Count);
									turn.setText("Turn Character "+A1063301_Checkpoint5.Character[A1063301_Checkpoint5.ch_num].CHARACTER_NUMBER);
									for(int j=0;j<size5;j++) {
										A1063301_Checkpoint5.Character[j].status+=1;
									}
								}
								turn.setText("Turn Character "+A1063301_Checkpoint5.Character[A1063301_Checkpoint5.ch_num].CHARACTER_NUMBER);
								dicebtn.setEnabled(true);
								return;
							}
							turn.setText("Turn Character "+A1063301_Checkpoint5.Character[A1063301_Checkpoint5.ch_num].CHARACTER_NUMBER);
							dicebtn.setEnabled(true);
							return;
						}
						if(A1063301_Checkpoint5.ch_num==size5) {
							A1063301_Checkpoint5.ch_num=0;
							A1063301_Checkpoint5.round_Count+=1;
							round.setText("Round"+A1063301_Checkpoint5.round_Count);
							turn.setText("Turn Character "+A1063301_Checkpoint5.Character[A1063301_Checkpoint5.ch_num].CHARACTER_NUMBER);
							for(int j=0;j<size5;j++) {
								A1063301_Checkpoint5.Character[j].status+=1;
							}
							dicebtn.setEnabled(true);
							return;
						}
					}
					//dicebtn.setEnabled(true);

		}
		public void startThread() {
			Thread theThread=new Thread(this);
			theThread.start();
		}
		public void doNothing(double move_second2) {
			try {
				Thread.sleep((long) move_second2);
			}catch(InterruptedException e){
				System.exit(0);
			}
		}
		public void paint(Graphics g){
			super.paint(g);
			int size4=(A1063301_Checkpoint5.a.size()/5);
			if(size4==1) {
				g.drawImage(img1, A1063301_Checkpoint5.x[0], A1063301_Checkpoint5.y[0], this);
			}
			else if(size4==2) {
				g.drawImage(img1, A1063301_Checkpoint5.x[0], A1063301_Checkpoint5.y[0], this);
				g.drawImage(img2, A1063301_Checkpoint5.x[1], A1063301_Checkpoint5.y[1], this);
			}
			else if(size4==3) {
				g.drawImage(img1, A1063301_Checkpoint5.x[0], A1063301_Checkpoint5.y[0], this);
				g.drawImage(img2, A1063301_Checkpoint5.x[1], A1063301_Checkpoint5.y[1], this);
				g.drawImage(img3, A1063301_Checkpoint5.x[2], A1063301_Checkpoint5.y[2], this);
			}
			else {
				g.drawImage(img1, A1063301_Checkpoint5.x[0], A1063301_Checkpoint5.y[0], this);
				g.drawImage(img2, A1063301_Checkpoint5.x[1], A1063301_Checkpoint5.y[1], this);
				g.drawImage(img3, A1063301_Checkpoint5.x[2], A1063301_Checkpoint5.y[2], this);
				g.drawImage(img4, A1063301_Checkpoint5.x[3], A1063301_Checkpoint5.y[3], this);
			}
		}
		
		
}
