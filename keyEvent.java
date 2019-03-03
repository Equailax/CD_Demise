import java.awt.event.*;
import javax.swing.*;
public class keyEvent implements KeyListener{
	 
	 public void keyPressed(KeyEvent e){
		 if (e.getKeyCode() == 65){
		 //System.out.println(" Key Pressed "+ e.getKeyChar()); 
		 System.out.println("move left"); 
		 }
		 if (e.getKeyCode()== 87){
			 System.out.println("move up"); 
		 }
		 if (e.getKeyCode()== 83){
			 System.out.println("move down"); 
		 }
		 if (e.getKeyCode()== 68){
			 System.out.println("move right"); 
		 }
		 if (e.getKeyCode()== 38){
			 System.out.println("move up"); 
		 }
		 if (e.getKeyCode()== 40){
			 System.out.println("move down"); 
		 }
		 if (e.getKeyCode()== 37){
			 System.out.println("move left"); 
		 }
		 if (e.getKeyCode()== 39){
			 System.out.println("move right"); 
		 }
		 if (e.getKeyCode()== 32){
			 System.out.println("shoot"); 
		 }
			 
	 }
	  
	 public void keyReleased(KeyEvent e){
		 //System.out.println("re");
	 }
	 public void keyTyped(KeyEvent e){
		 //System.out.println("resw");
	 }
	 
	 public static void main(String arg[])
	 {
		 JFrame jf = new JFrame("key Event");
		 jf.setSize(400,400);
		 jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 
		 jf.addKeyListener(new keyEvent());
		 jf.setVisible(true);
	 }
}
 