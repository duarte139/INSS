package aplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Company;
import entities.Individual;
import entities.TaxPayer;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		List<TaxPayer> list = new ArrayList<>();

		System.out.println("Enter the number of tax payers: ");
		int n = sc.nextInt();

		for (int i = 1; i <= n; i++) {
			try {
				System.out.println("Tax payer #" + i + "data:");
				System.out.print("Individual or company (i/c)? ");
				char ch = sc.next().charAt(0);
				System.out.print("Name: ");
				sc.nextLine();
				String name = sc.nextLine();
				System.out.print("Anual income: ");
				double annualIncome = sc.nextDouble();

				if (ch == 'i') {
					System.out.println("Health expenditures: ");
					double healthExpenditures = sc.nextDouble();
					list.add(new Individual(name, annualIncome, healthExpenditures));
				} else {
					System.out.print("Number of employees: ");
					int numberOfEmployees = sc.nextInt();
					list.add(new Company(name, annualIncome, numberOfEmployees));
				}
			} catch (java.util.InputMismatchException e) {
				System.out.println("Please you must user number system  americano");
			}

		}
		double sum = 0;
		System.out.println();
		System.out.println("TAXES PAID: ");

		for (TaxPayer tp : list) {
			double tax = tp.tax();
			System.out.println(tp.getName() + ": $ " + String.format("%.2f", tax));
			sum += tax;
		}
		System.out.println();
		System.out.println("TOTAL TAXES: $ " + String.format("%.2f", sum));

		sc.close();

	}

}
