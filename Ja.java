package Funtkionsplotter;

import java.util.Scanner;

import ch.aplu.turtle.Turtle;

import java.awt.Color;
import java.awt.font.GraphicAttribute;

public class Ja {
		
	Turtle Graph;

	public static void main(String[] args) {
		
			    
    double a = -1;
    double xs = 90;
    double ys = 40;
		
			Turtle Graph = new Turtle();
			Graph.setColor(Color.RED);
			int count = 1;
			Graph.setPos(xs, ys);
			

			
	
				while (count<=95)         
			  {
			    Graph.left(Math.pow(count, 1.2));
			    Graph.forward(30);   
			    count++;
			  }

			

	}
}



 
			
	

