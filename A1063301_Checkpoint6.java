
import java.awt.image.*;
import java.io.*;
import java.util.*;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class A1063301_Checkpoint6 {
	private static final String driver ="com.mysql.cj.jdbc.Driver";
    	private static final String protocol = "jdbc:mysql:";
	public static ArrayList<String> a = new ArrayList<String>();
	public static ArrayList<String> round_And_turn = new ArrayList<String>();
	public static ArrayList<String> C_PLACE_NUMBER = new ArrayList<String>();
	public static ArrayList<String> C_owner = new ArrayList<String>();
	public static ArrayList<String> C_LAND_PRICE = new ArrayList<String>();
	public static ArrayList<String> C_TOLLS = new ArrayList<String>();
	public static String test,land_test;
	public static Character[] Character;
	public static Land[] Land;
	public static int round_Count=0,ch_num=0;
	public static int x[]= {550,590,550,590};
	public static int y[]= {570,570,610,610};
	public static JButton start,load,exit;
	public static void main(String[] args) throws IOException{
		JFrame frame=new JFrame();
		frame.setSize(200,200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLayout(new BorderLayout());
		JPanel win=new JPanel();
		win.setLayout(new GridLayout(5,1));
		JPanel winn=new JPanel();
		winn.setPreferredSize(new Dimension(20,20));
		frame.add(winn,BorderLayout.NORTH);
		JPanel winw=new JPanel();
		winw.setPreferredSize(new Dimension(20,20));
		frame.add(winw,BorderLayout.WEST);
		JPanel wine=new JPanel();
		wine.setPreferredSize(new Dimension(20,20));
		frame.add(wine,BorderLayout.EAST);
		JPanel wins=new JPanel();
		wins.setPreferredSize(new Dimension(20,20));
		frame.add(wins,BorderLayout.SOUTH);
		start=new JButton("Start");
		
		start.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				File filec= new File("Character.txt");
				File filel= new File("Land.txt");
				try {
					filec.createNewFile();
					filel.createNewFile();
					BufferedWriter charwriter=new BufferedWriter(new FileWriter("Character.txt"));
					int count=0;
					int size2=4;
					charwriter.write("Round:1,Turn:1");
					charwriter.newLine();
					for(int k=0;k<size2;k++) {
						charwriter.write("0,"+(k+1)+",2000,1,Character_"+(k+1)+".png");
						charwriter.newLine();
			        }
					charwriter.flush();
					charwriter.close();
					
					BufferedWriter landwrite=new BufferedWriter(new FileWriter("Land.txt"));
					landwrite.write("LOCATION_NUMBER, owner");
					landwrite.newLine();
					for(int k=0;k<20;k++) {
						if(k%5==0) {
						}
						else {
							landwrite.write(k+",0");
							landwrite.newLine();
						}
			        }
					landwrite.flush();
					landwrite.close();
					
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				A1063301_GUI gui=new A1063301_GUI();
				frame.setVisible(false); 
			}
		});
		win.add(start);
		JLabel j1=new JLabel();
		j1.setPreferredSize(new Dimension(20,20));
		win.add(j1);
		load=new JButton("Load");
		load.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				File filec2 = new File("Character.txt");
				File filel2 = new File("Land.txt");
				if(filec2.exists()&&filel2.exists()) {
					try {
						Load("Character.txt","Land.txt");
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					A1063301_GUI gui=new A1063301_GUI();
					frame.setVisible(false); 
				}else {
					JFrame frame2=new JFrame();
					frame2.setSize(150,100);
					frame2.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
					frame2.setResizable(false);
					frame2.setLayout(new GridLayout(2,1));
					JLabel attention=new JLabel("          \tWithout record");
					frame2.add(attention);
					JButton confirm=new JButton("Confirm");
					confirm.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e){
							frame2.setVisible(false);
						}
					});
					frame2.add(confirm);
					frame2.setVisible(true);
				}
			}
		});
		win.add(load);
		JLabel j2=new JLabel();
		j2.setPreferredSize(new Dimension(20,20));
		win.add(j2);
		exit=new JButton("Exit");
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				System.exit(0);
			}
		});
		win.add(exit);
		frame.add(win,BorderLayout.CENTER);
		frame.setVisible(true);
		
		//A1063301_GUI gui=new A1063301_GUI();
		//// TODO: Announce your GUI object to make the GUI ////
		//// TODO: This time we won't give you a function to realize our demands (Please look for demands on the document).
		//// TODO: So, you can make it in anyway whatever you like. 

	}
	
	public static void Load(String filename, String filename2) throws IOException {
        //// TODO: You should load the variables from the files. ////
        a.clear();
	round_And_turn.clear();
	C_PLACE_NUMBER.clear();
	C_owner.clear();
	C_LAND_PRICE.clear();
	C_TOLLS.clear();
        BufferedReader bufferedreader=new BufferedReader(new FileReader(filename));
        String line;
        int f=0;
        while((line=bufferedreader.readLine())!=null) {
            if(f==0){
                test=line;
                f++;
                continue;
            } 
            for(String line2:line.split(","))	
                a.add(line2);		
        }

        BufferedReader landreader=new BufferedReader(new FileReader(filename2));
        String land_line;
        int f2=0;
        int land_count=0;
        while((land_line=landreader.readLine())!=null) {
            if(f2==0){
                land_test=land_line;
                f2++;
                continue;
            } 
            for(String land_line2:land_line.split(",")) {	
                if(land_count==0) {
                    C_owner.add("0");
                    C_owner.add("-1");
                }
                else if(land_count==8) {
                    C_owner.add("5");
                    C_owner.add("-1");
                }
                else if(land_count==16){
                    C_owner.add("10");
                    C_owner.add("-1");
                }
                else if(land_count==24){
                    C_owner.add("15");
                    C_owner.add("-1");
                }
                C_owner.add(land_line2);
                land_count++;
            }
        }

        for(String sss:test.replaceAll("[^0-9]", ",").split(",")){
            if (sss.length()>0)
                round_And_turn.add(sss);
        }
        round_Count=Integer.parseInt(round_And_turn.get(0));
        ch_num=Integer.parseInt(round_And_turn.get(1))-1;
        //calculate round and turn
        bufferedreader.close();

        final int size=(a.size())/5; 
        Character=new Character[size];
        int count=0;
        for(int j=0;j<size;j++) {
            Character[j] =new Character(j, j, j, j, null);
        }

        for(int k=0;k<size;k++) {
            Character[k].location=Integer.parseInt(a.get(count));
            a.set(count,""+ Character[k].location);
            count++;
            Character[k].CHARACTER_NUMBER=Integer.parseInt(a.get(count));
            count++;
            Character[k].money=Integer.parseInt(a.get(count));
            a.set(count,""+ Character[k].money);
            count++;
            Character[k].status=Integer.parseInt(a.get(count));
            count++;
            Character[k].IMAGE_FILENAME=a.get(count);
            count++;
        }		

        for(int j=0;j<size;j++) {
            if(Character[j].location<=5) {
                if(j==0) {
                    if(Character[j].location==0){
                        x[j]=550-(Character[j].location*95);
                    }
                    else{
                        x[j]=550-(Character[j].location*95)-10;
                    }
                    y[j]=570;
                }
                else if(j==1) {
                    if(Character[j].location==0){
                        x[j]=590-(Character[j].location*95);
                    }
                    else{
                        x[j]=590-(Character[j].location*95)-10;
                    }
                    y[j]=570;
                }
                else if(j==2) {
                    if(Character[j].location==0){
                        x[j]=550-(Character[j].location*95);
                    }
                    else{
                        x[j]=550-(Character[j].location*95)-10;
                    }
                    y[j]=610;
                }
                else{
                    if(Character[j].location==0){
                        x[j]=590-(Character[j].location*95);
                    }
                    else{
                        x[j]=590-(Character[j].location*95)-10;
                    }
                    y[j]=610;
                }
            }
            else if(Character[j].location>5 && Character[j].location<=10) {
                if(j==0) {
                    if(Character[j].location==0){
                        y[j]=570-((Character[j].location-5)*95);
                    }
                    else{
                        y[j]=570-((Character[j].location-5)*95)-10;
                    }
                    x[j]=65;
                }
                else if(j==1) {
                    if(Character[j].location==0){
                        y[j]=570-((Character[j].location-5)*95);
                    }
                    else{
                        y[j]=570-((Character[j].location-5)*95)-10;
                    }
                    x[j]=105;
                }
                else if(j==2) {
                    if(Character[j].location==0){
                        y[j]=610-((Character[j].location-5)*95);
                    }
                    else{
                        y[j]=610-((Character[j].location-5)*95)-10;
                    }
                    x[j]=65;
                }
                else{
                    if(Character[j].location==0){
                        y[j]=610-((Character[j].location-5)*95);
                    }
                    else{
                        y[j]=610-((Character[j].location-5)*95)-10;
                    }
                    x[j]=105;
                }
            }
            else if(Character[j].location>10 && Character[j].location<=15) {
                if(j==0) {
                    if(Character[j].location==0){
                        x[j]=65+((Character[j].location-10)*95);
                    }
                    else{
                        x[j]=65+((Character[j].location-10)*95)+10;
                    }
                    y[j]=85;
                }
                else if(j==1) {
                    if(Character[j].location==0){
                        x[j]=105+((Character[j].location-10)*95);
                    }
                    else{
                        x[j]=105+((Character[j].location-10)*95)+10;
                    }
                    y[j]=85;
                }
                else if(j==2) {
                    if(Character[j].location==0){
                        x[j]=65+((Character[j].location-10)*95);
                    }
                    else{
                        x[j]=65+((Character[j].location-10)*95)+10;
                    }
                    y[j]=125;
                }
                else{
                    if(Character[j].location==0){
                        x[j]=105+((Character[j].location-10)*95);
                    }
                    else{
                        x[j]=105+((Character[j].location-10)*95)+10;
                    }
                    y[j]=125;
                }
            }
            else {
                if(j==0) {
                    if(Character[j].location==0){
                        y[j]=85+((Character[j].location-15)*95);
                    }
                    else{
                        y[j]=85+((Character[j].location-15)*95)+10;
                    }
                    x[j]=550;
                }
                else if(j==1) {
                    if(Character[j].location==0){
                        y[j]=85+((Character[j].location-15)*95);
                    }
                    else{
                        y[j]=85+((Character[j].location-15)*95)+10;
                    }
                    x[j]=590;
                }
                else if(j==2) {
                    if(Character[j].location==0){
                        y[j]=125+((Character[j].location-15)*95);
                    }
                    else{
                        y[j]=125+((Character[j].location-15)*95)+10;
                    }
                    x[j]=550;
                }
                else{
                    if(Character[j].location==0){
                        y[j]=125+((Character[j].location-15)*95);
                    }
                    else{
                        y[j]=125+((Character[j].location-15)*95)+10;
                    }
                    x[j]=590;
                }
            }
        }
        try{
            Class.forName(driver).newInstance();
            System.out.println("Loaded the embedded driver.");
        }
        catch (Exception err){
            System.err.println("Unable to load the embedded driver.");
            err.printStackTrace(System.err);
            System.exit(0);
        }
        String url = "//140.127.220.220/"; 
        String username = "checkpoint";
        String password = "ckppwd";
        String dbName = "CHECKPOINT";
        Connection conn = null;
        try{
            conn = DriverManager.getConnection(protocol + url + dbName, username, password);
            Statement s = conn.createStatement();
            Statement s2 = conn.createStatement();
            Statement s3 = conn.createStatement();
            ResultSet rs;
            ResultSet rs2;
            ResultSet rs3;
            rs = s.executeQuery("SELECT PLACE_NUMBER from LAND ");
            if(rs.next()==true){
                int ncount=0;
                C_PLACE_NUMBER.add("0");
                ncount++;
                C_PLACE_NUMBER.add(rs.getString("PLACE_NUMBER"));
                while(rs.next()) {
                    if(ncount==4) {
                        C_PLACE_NUMBER.add("5");
                    }
                    else if(ncount==8){
                        C_PLACE_NUMBER.add("10");
                    }
                    else if(ncount==12){
                        C_PLACE_NUMBER.add("15");
                    }
                    ncount++;
                    C_PLACE_NUMBER.add(rs.getString("PLACE_NUMBER"));
                }
            }

            rs2 = s2.executeQuery("SELECT LAND_PRICE from LAND ");
            if(rs2.next()==true){
                int ncount2=0;
                C_LAND_PRICE.add("0");
                ncount2++;
                C_LAND_PRICE.add(rs2.getString("LAND_PRICE"));
                while(rs2.next()) {
                    if(ncount2==4) {
                        C_LAND_PRICE.add("0");
                    }
                    else if(ncount2==8){
                        C_LAND_PRICE.add("0");
                    }
                    else if(ncount2==12){
                        C_LAND_PRICE.add("0");
                    }
                    ncount2++;
                    C_LAND_PRICE.add(rs2.getString("LAND_PRICE"));
                }
            }

            rs3 = s3.executeQuery("SELECT TOLLS from LAND ");
            if(rs3.next()==true){
                int ncount3=0;
                C_TOLLS.add("0");
                ncount3++;
                C_TOLLS.add(rs3.getString("TOLLS"));
                while(rs3.next()) {
                    if(ncount3==4) {
                        C_TOLLS.add("0");
                    }
                    else if(ncount3==8){
                        C_TOLLS.add("0");
                    }
                    else if(ncount3==12){
                        C_TOLLS.add("0");
                    }
                    ncount3++;
                    C_TOLLS.add(rs3.getString("TOLLS"));
                }
            }
            conn.close();

        }
        catch (SQLException err){
            System.err.println("SQL error.");
            err.printStackTrace(System.err);
            System.exit(0);
        }



        Land=new Land[20];
        int c_count=0;
        for(int j=0;j<20;j++) {
            Land[j] =new Land(j, j, j, j);
        }
        for(int kk=0;kk<20;kk++) {
            Land[kk].PLACE_NUMBER=Integer.parseInt(C_PLACE_NUMBER.get(c_count));
            Land[kk].owner=Integer.parseInt(C_owner.get(2*(c_count)+1));
            C_owner.set(2*(c_count)+1,""+ Land[kk].owner);
            Land[kk].LAND_PRICE=Integer.parseInt(C_LAND_PRICE.get(c_count));
            Land[kk].TOLLS=Integer.parseInt(C_TOLLS.get(c_count));
            c_count++;
        }
    }

    public static void Save(String filename, String filename2) throws IOException {
        //// TODO: You should save the changed variables into original data (filename). ////
        BufferedWriter characterwriter=new BufferedWriter(new FileWriter(filename));
        int count=0;
        int size2=(a.size())/5;
        characterwriter.write("Round:"+round_Count+","+"Turn:"+(ch_num+1));
        characterwriter.newLine();
        for(int k=0;k<size2;k++) {
            characterwriter.write(Character[k].location+",");
            characterwriter.write(Character[k].CHARACTER_NUMBER+",");
            characterwriter.write(Character[k].money+",");
            characterwriter.write(Character[k].status+",");
            characterwriter.write(Character[k].IMAGE_FILENAME);
            characterwriter.newLine();
        }
        characterwriter.flush();
        characterwriter.close();

        BufferedWriter landwriter=new BufferedWriter(new FileWriter(filename2));
        landwriter.write(land_test);
        landwriter.newLine();
        for(int k=0;k<20;k++) {
            if(k%5==0) {
            }
            else {
                landwriter.write(Land[k].PLACE_NUMBER+",");
                landwriter.write(Land[k].owner+"");
                landwriter.newLine();
            }
        }
        landwriter.flush();
        landwriter.close();
    }

    public static void Random() {
        //// TODO: while calling the Random function, Character.location should plus the random value, and Character.status should minus one.
        //// TODO: While Character.status more than zero(not include zero), Character can move(plus the random value).
        int size3=(a.size())/5;
        if(Character[ch_num].status>0) {
            A1063301_GUI.random_math = (int)(Math.random() * 6 + 1);
            if(Character[ch_num].location+A1063301_GUI.random_math>=20){
                Character[ch_num].location=(Character[ch_num].location+A1063301_GUI.random_math)-20;
            }
            else {
                Character[ch_num].location=Character[ch_num].location+A1063301_GUI.random_math;
            }
            Character[ch_num].status=Character[ch_num].status-1;
        }
    }

}
