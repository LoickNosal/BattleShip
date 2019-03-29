import java.util.Random;

public class test {

	public static void main(String[] args) {
		int entier0 = 0;
		int entier1 = 0;
		int entier2 = 0;
		int entier3 = 0;
		int entier4 = 0;
		int entier5 = 0;
		int entier6 = 0;
		int entier7 = 0;
		int entier8 = 0;
		int entier9 = 0;
				
		while(true) {
			int test = nombreAle();
			switch (test) {
			case 0:
				entier0 +=1;
				break;
			case 1:
				entier1 +=1;
				break;
			case 2:
				entier2 +=1;
				break;
			case 3:
				entier3 +=1;
				break;
			case 4:
				entier4 +=1;
				break;
			case 5:
				entier5 +=1;
				break;
			case 6:
				entier6 +=1;
				break;
			case 7:
				entier7 +=1;
				break;
			case 8:
				entier8 +=1;
				break;
			case 9:
				entier9 +=1;
				break;
			default:
				break;
			}
			System.out.println("0 : " + entier0);
			System.out.println("1 : " + entier1);
			System.out.println("2 : " + entier2);
			System.out.println("3 : " + entier3);
			System.out.println("4 : " + entier4);
			System.out.println("5 : " + entier5);
			System.out.println("6 : " + entier6);
			System.out.println("7 : " + entier7);
			System.out.println("8 : " + entier8);
			System.out.println("9 : " + entier9);
		}
		

	}

	public static int nombreAle() {
		int x = (int)(Math.random() * (9+1));
		return x;
	}

}
