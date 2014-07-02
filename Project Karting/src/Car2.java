public class Car2 {

	public static double x; // Position
	public static double y;
	public static double Vx; // Vitesse
	public static double Vy;
	public static int Ax; // Acceleration
	public static int Ay;
	public static int commande;
	public static boolean wat;

	Car2(double x, double y, double Vx, double Vy) {
		Car2.x = x;
		Car2.y = y;
		Car2.Vx = Vx;
		Car2.Vy = Vy;

	}

	public void Car2Display() { // Afficher la voiture
		if (Car2.Vx == 0 && Car2.Vy == 0) {
			StdDraw.picture(x, y, "car_b.png", 1, 1, -90);
		}
		if (Car2.Vx > 0 && Car2.Vy == 0) {
			StdDraw.picture(x, y, "car_b.png", 1, 1, -90);
		}
		if (Car2.Vx == 0 && Car2.Vy > 0) {
			StdDraw.picture(x, y, "car_b.png", 1, 1, 0);
		}
		if (Car2.Vx < 0 && Car2.Vy == 0) {
			StdDraw.picture(x, y, "car_b.png", 1, 1, 90);
		}
		if (Car2.Vx > 0 && Car2.Vy == 0) {
			StdDraw.picture(x, y, "car_b.png", 1, 1, -90);
		}
		if (Car2.Vx == 0 && Car2.Vy < 0) {
			StdDraw.picture(x, y, "car_b.png", 1, 1, 180);
		}
		if (Car2.Vx > 0 && Car2.Vy > 0) {
			StdDraw.picture(x, y, "car_b.png", 1, 1, -45);
		}
		if (Car2.Vx > 0 && Car2.Vy < 0) {
			StdDraw.picture(x, y, "car_b.png", 1, 1, -135);
		}
		if (Car2.Vx < 0 && Car2.Vy > 0) {
			StdDraw.picture(x, y, "car_b.png", 1, 1, 45);
		}
		if (Car2.Vx < 0 && Car2.Vy < 0) {
			StdDraw.picture(x, y, "car_b.png", 1, 1, 135);
		}

	}

	public void position() { // Déplacer la voiture
		 Land.water();
		// Land.grass();

		Vx += Ax;
		Vy += Ay;

		for (int k = 0; k < 15; k++) {
			
			Land.crash();			
			StdDraw.clear();
			// Land.grass();
			x += Vx / 15;
			y += Vy / 15;

			Land.texture();
		/*	Game.kart2.Car2Display();
			Game.kart2.circle();*/
			
			StdDraw.show(10); // Display and show for 10ms
		}
				
	//	Game.console();
		
		
	}

	public void circle() {
		StdDraw.setPenColor(StdDraw.BLUE);
		StdDraw.circle(x + Vx, y + Vy, 0.5);
		if (wat == false) {
			StdDraw.circle(x + Vx - 1, y + Vy + 1, 0.5);
			StdDraw.circle(x + Vx, y + Vy + 1, 0.5);
			StdDraw.circle(x + Vx + 1, y + Vy + 1, 0.5);
			StdDraw.circle(x + Vx - 1, y + Vy, 0.5);
			StdDraw.circle(x + Vx + 1, y + Vy, 0.5);
			StdDraw.circle(x + Vx - 1, y + Vy - 1, 0.5);
			StdDraw.circle(x + Vx, y + Vy - 1, 0.5);
			StdDraw.circle(x + Vx + 1, y + Vy - 1, 0.5);
		}
	}

	public void acceleration() { // Commande de l'acceleration

		commande = 1;
		while (commande == 1) {

			if ((StdDraw.isKeyPressed(65)) || (StdDraw.isKeyPressed(103))) { // a
																				// ou
																				// 7
				Ax = -1;
				Ay = 1;
				Game.t += 1;
				commande = 0;
			}
			if ((StdDraw.isKeyPressed(90)) || (StdDraw.isKeyPressed(104))) { // z
																				// ou
																				// 8
				Ax = 0;
				Ay = 1;
				Game.t += 1;
				commande = 0;
			}
			if ((StdDraw.isKeyPressed(69)) || (StdDraw.isKeyPressed(105))) { // e
																				// ou
																				// 9
				Ax = 1;
				Ay = 1;
				Game.t += 1;
				commande = 0;
			}
			if ((StdDraw.isKeyPressed(81)) || (StdDraw.isKeyPressed(100))) { // q
																				// ou
																				// 4
				Ax = -1;
				Ay = 0;
				Game.t += 1;
				commande = 0;
			}
			if ((StdDraw.isKeyPressed(83)) || (StdDraw.isKeyPressed(101))) { // s
																				// ou
																				// 5
				Ax = 0;
				Ay = 0;
				Game.t += 1;
				commande = 0;
			}
			if ((StdDraw.isKeyPressed(68)) || (StdDraw.isKeyPressed(102))) { // d
																				// ou
																				// 6
				Ax = 1;
				Ay = 0;
				Game.t += 1;
				commande = 0;
			}
			if ((StdDraw.isKeyPressed(87)) || (StdDraw.isKeyPressed(97))) { // w
																			// ou
																			// 1
				Ax = -1;
				Ay = -1;
				Game.t += 1;
				commande = 0;
			}
			if ((StdDraw.isKeyPressed(88)) || (StdDraw.isKeyPressed(98))) { // x
																			// ou
																			// 2
				Ax = 0;
				Ay = -1;
				Game.t += 1;
				commande = 0;
			}
			if ((StdDraw.isKeyPressed(67)) || (StdDraw.isKeyPressed(99))) { // c
																			// ou
																			// 3
				Ax = 1;
				Ay = -1;
				Game.t += 1;
				commande = 0;
			}

		}
	}
}
