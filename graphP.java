package Funtkionsplotter;

import java.awt.Color;
import java.util.Scanner;
import ch.aplu.turtle.Turtle;

public class graphP {
    static Scanner scan = new Scanner(System.in);
    public static int lenght_x = 400;
    public static int arrow_d = 135;
    static Turtle tur_graph = new Turtle();
    static Turtle par = new Turtle(tur_graph);
    private static int xs;
    private static int xs_f;
    private static int ergLaenge;
    
    public static void main(String[] args){ 				// Turtle 
    	tur_graph.setPenColor(Color.blue);
    	graphP.diagramm();
    	graphP.parPunkte();	
    
    }
    
    public static void diagramm() {									// Deklaration Achsen + Labeling
    	graphP.xAchse();
      graphP.yAchse();
      graphP.xArrow();
      graphP.yArrow();
      graphP.xLabeling();
      graphP.yLabeling();
    
    }

    
    public static void parPunkte(){									// Graph
    	double erg[];
    	double x_cord;
    	
    	par.setPenColor(Color.red);
    	par.hideTurtle();
    	
    	erg = new double[ergLaenge];
    	erg = graphP.yWerte();
    	x_cord = xs * 15;
    	
    	for(int i = xs_f; i < ergLaenge; i++) {
    		par.setPos(x_cord, erg[i] * 15);
    		par.dot(5);
    		x_cord = x_cord + 1;
    	}
    	
    	x_cord = xs * 15;
    	
    	for(int i = xs_f; i < ergLaenge; i++) {
    		par.setPos(x_cord, erg[i] * 15);
    		par.dot(5);
    		x_cord = x_cord - 1;
    	}
    
    }
    
    public static double[] yWerte(){									// Deklaration Werte + Berechnung der Wrte
    	double a;
    	double ys;
    	double erg[];
    	double xs_n;
    	double sollY;
    	double soll_Xp;
    	double soll_Xm;
    	double xs_p;
    	double xs_m;
    	int count;
    	
    	sollY = 0;
    	soll_Xp = 0;
    	soll_Xm = 0;
    	count = 0;
    	
    	System.out.println("Bitte geben sie den streck/stauch Faktor ein (ganze Zahlen fuer alle Werte)");
    	a = scan.nextDouble();
    	System.out.println("Bitte geben sie die Verschiebung in x Richtung ein. (Wie er auf dem Kord. ist)");
    	xs = scan.nextInt();
    	System.out.println("Bitte geben sie die Verschiebung in y Richtung ein.");
    	ys = scan.nextDouble();
  
    	xs_m = xs;
    	xs_p = xs;
    	
    	while(sollY < 200 & sollY > -200 & soll_Xp < 200 & soll_Xp > -200 | soll_Xm < 200 & soll_Xm > -200){
    		sollY = a * Math.pow(xs_p-xs,2) + ys;
    		soll_Xp = xs_p * 14.5;
    		soll_Xm = xs_m * 14.5;
    		
    		xs_p = xs_p + 0.07;
    		xs_m = xs_m - 0.07;	
    		count++;
    		
    	}
    	
    	if(xs < 0) {
    		xs_f = xs * -1;
    		xs_n = xs;
    		
    		count = count + xs_f;
    		erg = new double[count];
      	ergLaenge = count;
    		
    		for(int i = xs_f; i < erg.length; i++) {
      		erg[i] = a * Math.pow(xs_n-xs,2) + ys;
      		xs_n = xs_n + 0.07;
      		
    		}
    	
    	}else{
    		xs_f = xs;
    		xs_n = xs;
    		
    		count = count + xs_f;
    		erg = new double[count];
      	ergLaenge = count;
    		
    		for(int i = xs_f; i < erg.length; i++) {
      		erg[i] = a * Math.pow(xs_n-xs,2) + ys;
      		xs_n = xs_n + 0.07;
      		
      	}
    	} 
    	
    	return erg;
    }
    
    public static void xAchse() { 									// x Achse
        tur_graph.hideTurtle();
        tur_graph.right(90);
        
        for(int i = -1; i < 1; i++) {
        	tur_graph.setPos(-200, i);
          tur_graph.forward(lenght_x);
          
        }
    }
    
    public static void yAchse() {									// y Achse
    	tur_graph.home();
    	tur_graph.hideTurtle();
    	
    	for(int i = -1; i < 1; i++) {
    		tur_graph.setPos(i, -200);
    		tur_graph.forward(400);
    		
    	}

    }
    
    public static void xArrow(){ 									// Pfeile der x Achse
    	int x_cord = -201; 
    	tur_graph.hideTurtle();
      tur_graph.home();
    	
      for(int i = 0; i < 5; i++) {
      	tur_graph.setPos(x_cord, 0);
      	tur_graph.left(90);
      	tur_graph.left(arrow_d);
      	tur_graph.forward(10);
      	
      	tur_graph.setPos(x_cord, 0);
      	tur_graph.right(arrow_d);
      	tur_graph.right(arrow_d);
      	tur_graph.forward(10);
      	tur_graph.left(arrow_d);
      	tur_graph.left(270);
      	x_cord++;
      	
      }
      
      x_cord = 201;
      
      for(int i = 0; i < 5; i++) {
      	tur_graph.setPos(x_cord, 0);
      	tur_graph.left(90);
      	tur_graph.left(45);
      	tur_graph.forward(10);
      	
      	tur_graph.setPos(x_cord, 0);
      	tur_graph.right(45);
      	tur_graph.right(45);
      	tur_graph.forward(10);
      	tur_graph.left(45);
      	tur_graph.right(90);
      	x_cord--;
      
      }
    
    }

    public static void yArrow() { 									// Pfeile der y Achse
    	int x_cord = -201;
    	tur_graph.home();
    	
    	for(int i = 0; i < 5; i++) {
      	tur_graph.setPos(-1, x_cord);
      	tur_graph.left(180);
      	tur_graph.left(arrow_d);
      	tur_graph.forward(10);
      	
      	tur_graph.setPos(0, x_cord);
      	tur_graph.right(arrow_d);
      	tur_graph.right(arrow_d);
      	tur_graph.forward(10);
      	tur_graph.left(arrow_d);
      	tur_graph.left(180);
      	x_cord++;
      	
      }
      
      x_cord = 201;
      
      for(int i = 0; i < 5; i++) {
      	tur_graph.setPos(-1, x_cord);
      	tur_graph.left(180);
      	tur_graph.left(45);
      	tur_graph.forward(10);
      	
      	tur_graph.setPos(0, x_cord);
      	tur_graph.right(45);
      	tur_graph.right(45);
      	tur_graph.forward(10);
      	tur_graph.left(45);
      	tur_graph.right(180);
      	x_cord--;
      
      }
    }
    
    public static void xLabeling() { 								// x Achse Labeling
    	double x_cord;
    	int x_print;
    	String x_cordS;
    	
    	x_cord = -180;
    	x_cordS = "";
    	
    	tur_graph.hideTurtle();
    	tur_graph.home();
    	tur_graph.setFontSize(10);
    	
    	for(int i = 0; i < 19; i++) {
    		tur_graph.setPos(x_cord, -5);
    		tur_graph.forward(10);
    		x_cord = x_cord + 30;
    		
    	}
    	
    	x_cord = -187;
    	x_print = -12;
    	
    	for(int i = 0; i < 19; i++) {
    		tur_graph.setPos(x_cord, -20);
    		x_cordS = Integer.toString(x_print);
    		tur_graph.label(x_cordS);
    		
    		x_print = x_print + 2;
    		x_cord = x_cord + 30;
    		
    		
    	}
    	
    }	

    public static void yLabeling(){							// y Achse Labeling
    	double y_cord;
    	double x_cord;
    	int y_print;
    	String y_cordS;
    	
    	y_cord = -180;
    	y_cordS = "";
    	
    	tur_graph.hideTurtle();
    	tur_graph.home();
    	tur_graph.right(90);
    	tur_graph.setFontSize(10);
    	
    	for(int i = 0; i < 19; i++) {
    		tur_graph.setPos(-5, y_cord);
    		tur_graph.forward(10);
    		y_cord = y_cord + 30;
    		
    	}
    	
    	y_cord = 26;
    	y_print = 2;
    	x_cord = -27;
    	
    	for(int i = 0; i < 10; i++) {
    		y_cordS = Integer.toString(y_print);
    		
    		if(y_cordS.equals("0")) {
    			y_cordS = "";
    			tur_graph.setPos(-27, y_cord);
    		
    		}else if(y_cordS.length() < 3) {
    			y_cordS = y_cordS + " ";
    			x_cord = -22;
    			tur_graph.setPos(x_cord, y_cord);
    			x_cord = -27;
    		
    		}else {
    			tur_graph.setPos(-27, y_cord);
    		
    		}
    		
    		tur_graph.label(y_cordS);
    		
    		y_print = y_print + 2;
    		y_cord = y_cord + 30;
    		
    	}
    
    	y_cord = -34;
    	y_print = -2;
    	x_cord = -20;
    	
    	for(int i = 0; i < 10; i++) {
    		y_cordS = Integer.toString(y_print);
    		
    		if(y_cordS.equals("0")) {
    			y_cordS = "";
    			tur_graph.setPos(x_cord, y_cord);
    		
    		}else if(y_cordS.length() < 4) {
    			y_cordS = y_cordS + " ";
    			x_cord = -25;
    			tur_graph.setPos(x_cord, y_cord);
    			x_cord = -30;
    		
    		}else {
    			tur_graph.setPos(x_cord, y_cord);
    		
    		}
    		
    		tur_graph.label(y_cordS);
    		
    		y_print = y_print - 2;
    		y_cord = y_cord - 30;
    			
    	}
    	
   }	  	
}
