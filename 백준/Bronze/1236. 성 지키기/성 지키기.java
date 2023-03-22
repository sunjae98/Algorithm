import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();

		char[][] castle = new char[n][m];

		int result = 0;

		int count_Row = 0;
		int count_Col = 0;

		//경비원 할당 
		for (int i = 0; i < n; i++) {

			String str = sc.next();

			for (int j = 0; j < m; j++) {

				castle[i][j] = str.charAt(j);

			}

		}
		
		// 행에 필요한 경비
		for (int i = 0; i < n; i++) {
			boolean security_Row = false;

			for (int j = 0; j < m; j++) {

				if (castle[i][j] == 'X') {
					security_Row = true;
					break;
				}

			}

			if (security_Row == false) {
				count_Row++;

			}

		}

		// 열에 필요한 경비
		for (int j = 0; j < m; j++) {
			boolean security_Col = false;

			for (int i = 0; i < n; i++) {

				if (castle[i][j] == 'X') {
					security_Col = true;
					break;
				}

			}
			if (security_Col == false) {
				count_Col++;

			}

		}


		//	출력
		if (count_Row > count_Col) {
			System.out.println(count_Row);
		} else {
			System.out.println(count_Col);
		}

	}
}
