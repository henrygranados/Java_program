/**
 * Author: Henry Granados
 * Website: http://henrygranados.github.io
 */
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int[] arr = new int[3]; 
		char answer;
		char choice;

		do {
			// Getting input from user and checking for only numbers
			for (int i = 0; i < arr.length; i++) {
			    try {
			        System.out.printf("Please enter a number for arr[%d]:%n", i);
			        arr[i] = scan.nextInt();
			    } catch (Exception ex) {
			        i--;
			        System.out.printf("%s is not a number.%n", scan.next());
			    }
			}
			
            // Finding largest and smallest numbers
			int smallest = arr[0];
			int largest = arr[0];

			for (int i = 1; i < arr.length; i++) {
				if (arr[i] > largest) {
					largest = arr[i];
				} else if (arr[i] < smallest) {
					smallest = arr[i];
				}
			}

			System.out.println("Would you like to select the largest or smallest number \na)Largest\nb)Smallest");
			choice = scan.next().toLowerCase().trim().charAt(0);

			// Validating user's choice to see the smallest, largest or all numbers are the same message.
			switch (choice) {
			case 'a':
				if (areAllElementsTheSame(arr)) {
					System.out.println("All numbers are the same");
					break;
				} else {
					System.out.println("The largest number is: " + largest);
					break;
				}
			case 'b':
				if (areAllElementsTheSame(arr)) {
					System.out.println("All numbers are the same");
					break;
				} else {
					System.out.println("The smallest number is: " + smallest);
					break;
				}
			default:
				System.out.println("Invalid input");
				break;
			}

			System.out.println("Would you like to go again or exit (y or n)");
			answer = scan.next().toLowerCase().trim().charAt(0);

		} while (answer != 'n'); // Exiting do while loop in case user's types 'n'
		System.out.println("Good Bye!.");

	}

	//This method checks if all user's inputs are the same
	public static boolean areAllElementsTheSame(int[] arr) {
		if (arr.length == 0) {
			return true;
		} else {
			int first = arr[0];
			for (int element : arr) {
				if (element != first) {
					return false;
				}
			}
			return true;
		}
	}
}