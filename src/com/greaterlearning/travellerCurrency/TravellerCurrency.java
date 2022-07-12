package com.greaterlearning.travellerCurrency;

import java.util.Scanner;

public class TravellerCurrency {

	public static void main(String[] args) {
		
		// reading the input from user as problem statement
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Number of Currency Denominations :  ");
		int size = sc.nextInt();
		int[] denominations = new int[size];
		for (int i =0; i < size; i++) {
			System.out.print("Enter denomination value " + (i + 1) + " : ");
			denominations[i] = sc.nextInt();
		}
		
		// sort the given Array of denominations
		
		sortArray sortArr = new sortArray();
		denominations = sortArr.mergeSort(denominations, 0, denominations.length - 1);

		// calculating the result output 

		System.out.print("Enter the amount you want to pay : ");
		int amount = sc.nextInt();
		sc.close();

		System.out.println("Your payment approach in order to give min no of notes will be : ");
		
		calculateDenominations(amount, denominations, denominations.length-1);
		
	}
	
	
	// recursive method to reduce number of iterations and code optimization,
	// calculation starts from reverse order of array, because sorted in ascending order,
	// searching from the end make the program optimized,
	// if the largest denomination found at end of the array is enough the recursion will stop,
	// since the first check is failing with amount being zero on first recursion.

	public static void calculateDenominations(int amount, int[] totalDenominations, int startIndex) {
		if ((startIndex >= 0) && (amount > 0)) {
			if (totalDenominations[startIndex] == amount) {
				System.out.println(totalDenominations[startIndex] + ":" + (totalDenominations[startIndex]/amount));
			} else if (amount < totalDenominations[startIndex]) {
				if ((totalDenominations[startIndex] % amount) > 0) {
					calculateDenominations(amount, totalDenominations, startIndex - 1);
				}
			} else if (amount > totalDenominations[startIndex]){
				System.out.println(totalDenominations[startIndex] + ":" + (amount / totalDenominations[startIndex]));
				calculateDenominations((amount % totalDenominations[startIndex]), totalDenominations, startIndex - 1);
			}
		}
	}

}
