public class Car {

	public static double x; // Position
	public static double y;
	public static double Vx; // Vitesse
	public static double Vy;
	public static int Ax; // Acceleration
	public static int Ay;
	public static int commande;
	public static boolean wat;
	public static int color;
	public static String c;

	Car(double x, double y, double Vx, double Vy) {
		this.x = x;
		this.y = y;
		this.Vx = Vx;
		this.Vy = Vy;

	}

	public void carDisplay() { // Afficher la voiture
		if (color == 1) {
			c = "car_r.png";
		}
		if (color == 2) {
			c = "car_b.png";
		}
		if (color == 3) {
			c = "car_g.png";
		}

		if (Vx == 0 && Vy == 0) {
			StdDraw.picture(x, y, c, 1.0, 1.5, -90);
		}
		if (Vx > 0 && Vy == 0) {
			StdDraw.picture(x, y, c, 1.0, 1.5, -90);
		}
		if (Vx == 0 && Vy > 0) {
			StdDraw.picture(x, y, c, 1.0, 1.5, 0);
		}
		if (Vx < 0 && Vy == 0) {
			StdDraw.picture(x, y, c, 1.0, 1.5, 90);
		}
		if (Vx > 0 && Vy == 0) {
			StdDraw.picture(x, y, c, 1.0, 1.5, -90);
		}
		if (Vx == 0 && Vy < 0) {
			StdDraw.picture(x, y, c, 1.0, 1.5, 180);
		}
		if (Vx > 0 && Vy > 0) {
			StdDraw.picture(x, y, c, 1.0, 1.5, -45);
		}
		if (Vx > 0 && Vy < 0) {
			StdDraw.picture(x, y, c, 1.0, 1.5, -135);
		}
		if (Vx < 0 && Vy > 0) {
			StdDraw.picture(x, y, c, 1.0, 1.5, 45);
		}
		if (Vx < 0 && Vy < 0) {
			StdDraw.picture(x, y, c, 1.0, 1.5, 135);
		}

	}

	public void position() { // Déplacer la voiture
		Land.water();
		Vx += Ax;
		Vy += Ay;
		Land.grass();
		for (int k = 0; k < 10; k++) {
			Land.crash();
			StdDraw.clear();
			Land.warp();
			Land.warp2();

			x += Vx / 10;
			y += Vy / 10;
			Land.texture();
			Game.kart.carDisplay();
			Game.kart.circle();
			StdDraw.show(10); // Display and show for 10ms
			Land.end();
		}
		Game.console();
	}

	public void circle() {
		StdDraw.setFont(null); // Change la police de taille
		if (color == 1) {
			StdDraw.setPenColor(StdDraw.RED);
		}
		if (color == 2) {
			StdDraw.setPenColor(StdDraw.BLUE);
		}
		if (color == 3) {
			StdDraw.setPenColor(StdDraw.GREEN);
		}
		StdDraw.circle(x + Vx, y + Vy, 0.5);

		StdDraw.setPenColor(StdDraw.WHITE);
		StdDraw.text(x + Vx, y + Vy, "5");

		if (Car.wat == false) {
			if (color == 1) {
				StdDraw.setPenColor(StdDraw.RED);
			}
			if (color == 2) {
				StdDraw.setPenColor(StdDraw.BLUE);
			}
			if (color == 3) {
				StdDraw.setPenColor(StdDraw.GREEN);
			}
			StdDraw.circle(x + Vx - 1, y + Vy + 1, 0.5);
			StdDraw.circle(x + Vx, y + Vy + 1, 0.5);
			StdDraw.circle(x + Vx + 1, y + Vy + 1, 0.5);
			StdDraw.circle(x + Vx + 1, y + Vy - 1, 0.5);
			StdDraw.circle(x + Vx, y + Vy - 1, 0.5);
			StdDraw.circle(x + Vx - 1, y + Vy - 1, 0.5);
			StdDraw.circle(x + Vx + 1, y + Vy, 0.5);
			StdDraw.circle(x + Vx - 1, y + Vy, 0.5);

			StdDraw.setPenColor(StdDraw.WHITE);
			StdDraw.text(x + Vx - 1, y + Vy + 1, "7");
			StdDraw.text(x + Vx, y + Vy + 1, "8");
			StdDraw.text(x + Vx + 1, y + Vy + 1, "9");
			StdDraw.text(x + Vx - 1, y + Vy, "4");
			StdDraw.text(x + Vx + 1, y + Vy, "6");
			StdDraw.text(x + Vx - 1, y + Vy - 1, "1");
			StdDraw.text(x + Vx, y + Vy - 1, "2");
			StdDraw.text(x + Vx + 1, y + Vy - 1, "3");
		}
	}

	public void acceleration() { // Commande de l'acceleration

		commande = 1;
		while (commande == 1) {
			if (Car.wat == false) {
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
			if ((StdDraw.isKeyPressed(83)) || (StdDraw.isKeyPressed(101))) { // s
				// ou
				// 5
				Ax = 0;
				Ay = 0;
				Game.t += 1;
				commande = 0;
			}
		}
	}
}
