import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GameOverFrame extends JFrame {
	private static final int FRAME_WIDTH = 690;
	private static final int FRAME_HEIGHT = 650;
	Operator o= null;
	ImageIcon i = new ImageIcon("gameoverImage.png");
    Image im=i.getImage();

	GameOverFrame(Operator _o){
		Database b=new Database();
		b.Score(Database.id);
		b.Score1st();
		b.Score2nd();
		b.Score3rd();
		o=_o;
		
		MyPanel panel=new MyPanel();
		JLabel s= new JLabel();
		JLabel s1= new JLabel();
		JLabel s2= new JLabel();
		JLabel s3= new JLabel();
		JLabel ss= new JLabel();
		
		ss.setText("BEST SCORE");
		ss.setForeground(Color.WHITE);
		ss.setBounds(270, 150, 180, 200);
		//1등의 라벨
		s1.setText("1ST: "+Database.name1);
		s1.setForeground(Color.WHITE);
		s1.setBounds(260, 200, 180, 200);
		//2등의 라벨
		s2.setText("2ND: "+Database.name2);
		s2.setForeground(Color.WHITE);
		s2.setBounds(260, 250, 180, 200);
		//3등의 라벨
		s3.setText("3RD: "+Database.name3);
		s3.setForeground(Color.WHITE);
		s3.setBounds(260, 300, 180, 200);
		
		
		//로그인한 id의 점수.
		s.setForeground(Color.ORANGE);
		s.setText("Score: "+Database.id+"▶ "+pacman.count+" 초");
		s.setBounds(220, 10, 300, 120);
		Font myFont = new Font("돋움", Font.BOLD, 25);
		Font myFont1 = new Font("돋움", Font.BOLD, 25);
		Font myFont2 = new Font("돋움", Font.BOLD, 25);
		Font myFont3 = new Font("돋움", Font.BOLD, 25);
		Font myFont4 = new Font("돋움", Font.BOLD, 25);
		
		s1.setFont(myFont1);
		s.setFont(myFont2);
		s2.setFont(myFont3);
		s3.setFont(myFont4);
		ss.setFont(myFont);
		

		
		add(panel);
		panel.setLayout(null);
		panel.add (s);
		panel.add (ss);
		panel.add(s1);
		panel.add(s2);
		panel.add(s3);
		
		setTitle("PacmanGame");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
		setVisible(false);
		
		
		
		
	}
	class MyPanel extends JPanel{
		
		public void paintComponent(Graphics g){
			super.paintComponent(g);
			g.drawImage(im,0,0,getWidth(),getHeight(),this);
		}
	}
	
	

}
