
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import javax.swing.*;

import org.jpl7.*;
import org.jpl7.Integer;
import org.jpl7.fli.*;

public class check extends JFrame {
	
	JLabel l1;
	JButton b1;
	JPanel p = new JPanel();
	JMenuBar mb = new JMenuBar();
	JMenu m = new JMenu("SOLUTION");
	JMenuItem mi = new JMenuItem("Run");
	JMenuItem mi2 = new JMenuItem("Reset");
	
	static JButton[][] squares = new JButton[9][9];
	static Icon img = new ImageIcon("C:\\Users\\Umer Ahmed\\workspace\\GUI\\src\\abc.png");
	public static int i; 
	public static int j;
	public static int count=0;
//	public static String[] list;
	public static final ArrayList<String> list = new ArrayList<String>();
	public static final ArrayList<String> list2 = new ArrayList<String>();
	org.jpl7.Integer[] arr = new org.jpl7.Integer[9];
	
	HashMap h = new HashMap();
	
	Set<String> set = new HashSet<String>(list);
	
	public check(){
		
		
		setSize(750,750);
		p.setLayout(new GridLayout(8,8));
		
		OnClick click = new OnClick();
		OnClick2 click2 = new OnClick2();
		OnClick3 click3 = new OnClick3();
		
		mb.add(m);
		m.add(mi);
		m.add(mi2);
	//	mb.setLayout(new GridBagLayout());
		setJMenuBar(mb);
		mi.addActionListener(click2);
	//	m.addActionListener(click2);
		mi2.addActionListener(click3);
		
		for(i=1;i<=8;i++){
			for(j=1;j<=8;j++){
				squares[i][j] = new JButton();
				
				
				if( (i+j) % 2 != 0)
				{
					squares[i][j].setBackground(Color.black);
				}
				else{
					squares[i][j].setBackground(Color.WHITE);
				}
				squares[i][j].addActionListener(click);
				
				
				p.add(squares[i][j]);
				add(p);
				//pack();
				
			}
		}
		
		
		
	}
	
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		check c = new check();
		//squares[2][3].setIcon(img);
		
		
		c.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		c.setVisible(true);
		
		c.setResizable(false);
		
		
		
		
		
		
		
	}
	public void ProcessClicked(int i,int j){
		if(count<8){
			squares[i][j].setIcon(img);
			//setTitle(list.toString());
			count++;
		}
		
	}
	public void ShowResult(Object s){
		setTitle(s.toString());
	}
	public class OnClick implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			Object source = e.getSource();
			for(int i=1;i<=8;i++){
				
				for(int j=1;j<=8;j++){
					
					if(source == squares[i][j]){
					
						
					list.add(i+"/Y"+i);
					set.add(i+"/Y"+i);
					if(set.size() == list.size()){
						
						ProcessClicked(i,j);
						return;
					}
					else{
						list.remove(list.size()-1);
						set.remove(set.size()-1);
					}
					
					}
				}
				
			}
			
		}
		

	}
	public class OnClick2 implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			String s1 = "consult('C:/Users/Umer Ahmed/Documents/Prolog/8queen.pl')";
			Query q1 = new Query(s1);
			
			ShowResult(q1.hasSolution() ?"success":"fail");
			
			String s2 = "solution("+ list +").";
		//	String s2 = "solution("+ getTitle() +").";
			Query q2 = new Query(s2);
			
			Object solution = null;
			String s = null;
			
			while ( q2.hasMoreSolutions() )
	        {
	            solution = q2.nextSolution();
	          //  s = q2.nextSolution().toString();
	            
	            
	        }
		//	System.out.println(solution);
		//	ShowResult(solution);
		/*	String a[] = s.split("=");
			
			for (String temp: a){
		          ShowResult(temp);
		       }*/
			h = (HashMap) solution;
			//ShowResult(h.get("Y1"));
			
			for(int i=1 ; i<=8 ; i++) {
				arr[i] = (Integer) h.get("Y"+i);
			}
			
			for(int i=1 ; i<=8 ; i++){
				for(int j=1 ; j<=8 ; j++){
					
					squares[i][j].setIcon(null);
				}
			}	
		//	squares[1][1].setIcon(img);
		//	ShowResult(h.get("Y1"));
		//	ShowResult(arr[1].intValue());
		//	for(int i=1 ; i<=8 ; i++){
				for(int j=1 ; j<=8 ; j++){
					int var = arr[j].intValue();
					squares[j][var].setIcon(img);
				} 
		//	}
		}
		
	}
	

	public class OnClick3 implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			for(int i=1 ; i<=8 ; i++){
				for(int j=1 ; j<=8 ; j++){
					
					squares[i][j].setIcon(null);
				}
			}
			
			
		}
		

	}
	
}
