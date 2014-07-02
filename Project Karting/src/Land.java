import java.util.Scanner;

public class Land {
	public static String[] text_line; // .txt en ligne
	public static char[][] decompo; // tableau des caractères de text_line
	public static int landX;
	public static int landY;
	public static int q;
	public static int o;
	public static String s;

	public static void fieldChoice() { // Choix de la carte
		if (Game.f == 1) {
			s = "grid.txt";
		}
		if (Game.f == 2) {
			s = "grid2.txt";
		}		
		if (Game.f == 3) {
			s = "grid3.txt";
		}		
		if (Game.f == 4) {
			s = "grid4.txt";
		}		
		if (Game.f == 5) {
			s = "grid5.txt";
		}
		In fichier = new In(s);
		text_line = fichier.readAll().split("\n");
			decompo = new char[text_line.length][text_line[0].length()];
			for (int i = 0; i < text_line.length; i++) {
				for (int j = 0; j < text_line[i].length(); j++) {
					decompo[i][j] = text_line[i].charAt(j);
			}

		}
	}

	public static void start() { // Placer la voiture sur la ligne de départ
		for (int i = 0; i < text_line.length; i++) {
			for (int j = 0; j < text_line[0].length(); j++) {
				if (decompo[i][j] == 'S') {
					Car.x = j;
					Car.y = Game.Y_MAX - i;
					System.out.println("3-2-1, PARTEZ !");
				}
			}
		}

	}

	public static void grass() {
		for (int i = 0; i < text_line.length; i++) {
			for (int j = 0; j < text_line[0].length(); j++) {

				if (decompo[i][j] == '.') {
					if (Math.round(Car.x) == j
							&& Math.round(Car.y) == Game.Y_MAX - i) {
						System.out
								.println("Mauvaises herbes ! Vitesse réduite !");
						if (Car.Vx > 1) {
							Car.Vx -= 1;
						}
						if (Car.Vy > 1) {
							Car.Vy -= 1;
						}
						if (Car.Vx < -1) {
							Car.Vx += 1;
						}
						if (Car.Vy < -1) {
							Car.Vy += 1;
						}
					}
				}
			}
		}
	}

	public static void water() {
		for (int i = 0; i < text_line.length; i++) {
			for (int j = 0; j < text_line[0].length(); j++) {

				if (decompo[i][j] == 'o') {
					if (Math.round(Car.x) == j
							&& Math.round(Car.y) == Game.Y_MAX - i) {
						System.out.println("Glou glou ! Accélération nulle !");
						Car.wat = true;
						Car.Ax = 0;
						Car.Ay = 0;
					}
				}
			}
		}
	}

	public static void crash() { // Prise en compte des crashs

		for (int i = 0; i < text_line.length; i++) {
			for (int j = 0; j < text_line[0].length(); j++) {

				if (decompo[i][j] == 'c') { // bord droite

					if (Math.round(Car.x) >= j
							&& Math.round(Car.y) == Game.Y_MAX - i) {
						Game.t += (Math.abs(Car.Vx) + Math.abs(Car.Vy));
						System.out.println("BOOM ! "
								+ (Math.abs(Car.Vx) + Math.abs(Car.Vy))
								+ " seconde(s) de pénalité !");
						Car.Vx = 0;
						Car.Vy = 0;
						Car.x = j - 1;
						Car.y = Game.Y_MAX - i;

					}

				}

				if (decompo[i][j] == 'd') { // bord bas
					if (Math.round(Car.x) == j
							&& Math.round(Car.y) <= Game.Y_MAX - i) {
						Game.t += (Math.abs(Car.Vx) + Math.abs(Car.Vy));
						System.out.println("BOOM ! "
								+ (Math.abs(Car.Vx) + Math.abs(Car.Vy))
								+ " seconde(s) de pénalité !");
						Car.Vx = 0;
						Car.Vy = 0;
						Car.x = j;
						Car.y = Game.Y_MAX - i + 1;

					}
				}
				if (decompo[i][j] == 'e') { // bord haut
					if (Math.round(Car.x) == j
							&& Math.round(Car.y) >= Game.Y_MAX - i) {
						Game.t += (Math.abs(Car.Vx) + Math.abs(Car.Vy));
						System.out.println("BOOM ! "
								+ (Math.abs(Car.Vx) + Math.abs(Car.Vy))
								+ " seconde(s) de pénalité !");
						Car.Vx = 0;
						Car.Vy = 0;
						Car.x = j;
						Car.y = Game.Y_MAX - i - 1;

					}
				}
				if (decompo[i][j] == 'f') { // bord gauche
					if (Math.round(Car.x) <= j
							&& Math.round(Car.y) == Game.Y_MAX - i) {
						Game.t += (Math.abs(Car.Vx) + Math.abs(Car.Vy));
						System.out.println("BOOM ! "
								+ (Math.abs(Car.Vx) + Math.abs(Car.Vy))
								+ " seconde(s) de pénalité !");
						Car.Vx = 0;
						Car.Vy = 0;
						Car.x = j + 1;
						Car.y = Game.Y_MAX - i;

					}
				}
				if (decompo[i][j] == 'x') { // obstacle gauche
					if (Math.round(Car.x) == j
							&& Math.round(Car.y) == Game.Y_MAX - i) {
						Game.t += (Math.abs(Car.Vx) + Math.abs(Car.Vy));
						System.out.println("BOOM ! "
								+ (Math.abs(Car.Vx) + Math.abs(Car.Vy))
								+ " seconde(s) de pénalité !");
						Car.Vx = 0;
						Car.Vy = 0;
						Car.x = j - 1;
						Car.y = Game.Y_MAX - i;

					}
				}
				if (decompo[i][j] == 'b') { // obstacle droite
					if (Math.round(Car.x) == j
							&& Math.round(Car.y) == Game.Y_MAX - i) {
						Game.t += (Math.abs(Car.Vx) + Math.abs(Car.Vy));
						System.out.println("BOOM ! "
								+ (Math.abs(Car.Vx) + Math.abs(Car.Vy))
								+ " seconde(s) de pénalité !");
						Car.Vx = 0;
						Car.Vy = 0;
						Car.x = j + 1;
						Car.y = Game.Y_MAX - i;

					}
				}
				if (decompo[i][j] == 'a') { // obstacle haut
					if (Math.round(Car.x) == j
							&& Math.round(Car.y) == Game.Y_MAX - i) {
						Game.t += (Math.abs(Car.Vx) + Math.abs(Car.Vy));
						System.out.println("BOOM ! "
								+ (Math.abs(Car.Vx) + Math.abs(Car.Vy))
								+ " seconde(s) de pénalité !");
						Car.Vx = 0;
						Car.Vy = 0;
						Car.x = j;
						Car.y = Game.Y_MAX - i + 1;

					}
				}
				if (decompo[i][j] == 'z') { // obstacle bas
					if (Math.round(Car.x) == j
							&& Math.round(Car.y) == Game.Y_MAX - i) {
						Game.t += (Math.abs(Car.Vx) + Math.abs(Car.Vy));
						System.out.println("BOOM ! "
								+ (Math.abs(Car.Vx) + Math.abs(Car.Vy))
								+ " seconde(s) de pénalité !");
						Car.Vx = 0;
						Car.Vy = 0;
						Car.x = j;
						Car.y = Game.Y_MAX - i - 1;

					}
				}
			}
		}
	}

	public static void end() { // Arrivée
		for (int i = 0; i < text_line.length; i++) {
			for (int j = 0; j < text_line[0].length(); j++) {
				if (decompo[i][j] == '#') {
					if (Math.round(Car.x) == j
							&& Math.round(Car.y) == Game.Y_MAX - i) {
						Car.Vx = 0;
						Car.Vy = 0;
						Car.Ax = 0;
						Car.Ay = 0;
						System.out.println("Terminé ! Votre temps est de" + " "
								+ Game.t + " " + "secondes ! Bravo !");
						Game.q = 0;
						Scanner again = new Scanner(System.in);
						System.out
								.println("Voulez-vous rejouer ? (Oui : 1 / Non : 2)");
						o = again.nextInt();
						if (o == 1) {
							Game.t = 0;
							Game.play();
						}
						if (o == 2) {
							System.out
									.println("Merci d'avoir joué ! A bientôt ! ");
						}
					}
				}

			}
		}
	}

	public static void warp() { // warpzone
		for (int i = 0; i < text_line.length; i++) {
			for (int j = 0; j < text_line[0].length(); j++) {
				if (decompo[i][j] == 'w') {
					if (Math.round(Car.x) == j
							&& Math.round(Car.y) == Game.Y_MAX - i) {
						Car.x = Math.random() * Game.X_MAX - 2;
						Car.y = Math.random() * Game.Y_MAX - 2;
						q = 2;
					}
				}
			}
		}
	}

	public static void warp2() { // warpzone2

		for (int i = 0; i < text_line.length; i++) {
			for (int j = 0; j < text_line[0].length(); j++) {
				if (decompo[i][j] == 'y') {
					landX = j;
					landY = Game.Y_MAX - i;
				}
			}
		}

		for (int i = 0; i < text_line.length; i++) {
			for (int j = 0; j < text_line[0].length(); j++) {
				if (decompo[i][j] == 'Y') {
					if (Math.round(Car.x) == j
							&& Math.round(Car.y) == Game.Y_MAX - i) {
						Car.x = Math.round(landX);
						Car.y = Math.round(landY);
					}
				}
			}
		}
	}

	public static void texture() { // Détail de la composition du terrain

		for (int i = 0; i < text_line.length; i++) {
			for (int j = 0; j < text_line[0].length(); j++) {

				if (decompo[i][j] == '.') { // L'herbe
					StdDraw.picture(j, Game.Y_MAX - i, "grass.jpg", 1.2, 1.2);
				}
				if (decompo[i][j] == ' ') { // La route
					StdDraw.picture(j, Game.Y_MAX - i, "road.jpg", 1.2, 1.2);
				}
				if (decompo[i][j] == '#') { // L'arrivée
					StdDraw.picture(j, Game.Y_MAX - i, "finish.jpg", 1.2, 1.2);
				}
				if ((decompo[i][j] == 'x') || (decompo[i][j] == 'a')
						|| (decompo[i][j] == 'b') || (decompo[i][j] == 'z')) { // Les
																				// "obstacles"
					StdDraw.picture(j, Game.Y_MAX - i, "grey.jpg", 1.2, 1.2);
				}
				if (decompo[i][j] == 'S') { // Le départ
					StdDraw.picture(j, Game.Y_MAX - i, "finish.jpg", 1.2, 1.2);
				}
				if ((decompo[i][j] == 'c') || (decompo[i][j] == 'd')
						|| (decompo[i][j] == 'e') || (decompo[i][j] == 'f')) { // Les
																				// "crashs"
					StdDraw.picture(j, Game.Y_MAX - i, "brique.jpg", 1.2, 1.2);
				}
				if (decompo[i][j] == 'o') { // L'eau
					StdDraw.picture(j, Game.Y_MAX - i, "water.jpg", 1.2, 1.2);
				}
				if ((decompo[i][j] == 'w') || (decompo[i][j] == 'y')
						|| (decompo[i][j] == 'Y')) { // The WARPER !!!
					StdDraw.picture(j, Game.Y_MAX - i, "pipe.gif", 1.1, 1.1);
				}

			}
		}

	}
}
