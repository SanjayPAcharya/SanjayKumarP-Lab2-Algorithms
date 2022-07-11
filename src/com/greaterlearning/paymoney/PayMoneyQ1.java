package com.greaterlearning.paymoney;

import java.util.Scanner;

// found out that we can use this to add sum of integer arrays in a line, built in.
import java.util.stream.*;

public class PayMoneyQ1 {

	// main method to a read sequential inputs from user / console

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Size of transactions array: ");
		int size = sc.nextInt();
		int[] transactions = new int[size];
		for (int i =0; i < size; i++) {
			System.out.println("Enter daily transactions in corres of day : " + ( i + 1 ));
			transactions[i] = sc.nextInt();
		}
		
		System.out.println("Enter the total number of targets that needs to be achieved : ");
		size = sc.nextInt();
		int[] targets = new int[size];
		for (int i =0; i < size; i++) {
			System.out.println("Enter daily transactions in corres of day : " + ( i + 1 ));
			targets[i] = sc.nextInt();
		}
		displayTransactions(transactions, targets);
		sc.close();
	}
	
	// method to do the evaluation according to the given problem statement
	
	public static void displayTransactions(int[] transactions,int[] targets) {
		int transactionsSumation = 0;
		String sumString = "";
		String[] targetResuts = new String[targets.length];
		
		// looping the targets in the fist for, and then calculating the sum of integers until target is meet.
		// then storing the message itself in an array of strings.
		
		for (int i = 0; i < targets.length; i++) {
			sumString = "";
			transactionsSumation = 0;
			for (int j = 0; j < transactions.length; j++) {
				transactionsSumation += transactions[j];
				sumString += (sumString.length() > 0) ? " + " + transactions[j] : transactions[j];
				if (transactionsSumation >= targets[i]) {
					if (j == 0) {
						targetResuts[i] = "Target " + (i + 1) + " i.e " + targets[i] + " is achieved in the " + (j + 1) + "st transaction itself.";	
					} else if(j > 0) {
						targetResuts[i] = "Target " + (i + 1) + " i.e " + targets[i] + " is achieved after " + (j + 1) + " transactions, ( " + sumString + " )";
					}
					break;
				}
			}
		}
		
		
		// printing a meaning full message with reason

		for (int i = 0; i < targetResuts.length; i++) {
			if (targetResuts[i] != null) {
				System.out.println(targetResuts[i]);
			} else {
				String str = (transactions.length > 1) ? 
							"Since there are " + transactions.length + " transactions and sum of which is (" + IntStream.of(transactions).sum() + ") which does not achieve the given target value i,e (" + targets[i] + "), hence the target is not achieved.":
							"Since there is only " + transactions.length + " transaction which is (" + transactions[0] +") and the target value is " + targets[i] + ", the target is not achieved.";
				System.out.println(str);
			}
		}
	}

}
