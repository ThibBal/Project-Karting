import java.util.Scanner;
public class Game {
	
	public static int X_MAX = 36; // Taille de l'écran
	public static int Y_MAX = 36;
	public static int t = 0; // Temps
	public static int f; // Numéro du terrain
	public static int q; // Arret du jeu

	
	static Car kart = new Car(Car.x, Car.y, 0, 0);
	
	
	public static void main(String[] args) {
		System.out.println("Bienvenue dans Project Karting !");
	    play();
		
	}
	
	public static void console() { 
		System.out.println("x = " + Car.x + " | y = " + Car.y);			
		System.out.println("Vx = " + Car.Vx + " | Vy = " + Car.Vy + " | Ax = " + Car.Ax + " | Ay = " + Car.Ay);			
		System.out.println("-");			
		System.out.println("Temps : " + t + " secondes");			
		System.out.println("--");			
		
	}	
	
	public static void play(){
		 Scanner fieldNumber=new Scanner(System.in);
	    System.out.println("Quelle carte voulez-vous ? (1-2-3-4-5)");
	  	f=fieldNumber.nextInt();
	  	
	  	Scanner colorNumber=new Scanner(System.in);
	    System.out.println("Quelle couleur pour la voiture ? (Rouge : 1 - Bleue : 2 - Vert : 3)");
	  	Car.color=colorNumber.nextInt();
	 	StdDraw.setCanvasSize(700, 700);
		StdDraw.setXscale(0, X_MAX); // Création de l'écran
		StdDraw.setYscale(0, Y_MAX);
		Land.fieldChoice(); 
		
		q = 1;
		Land.start(); // Démarrer
				
		while (q == 1) {
			
			kart.position();			
			kart.acceleration();	
			Car.wat = false;
			Land.end();	
		}
	}
}

