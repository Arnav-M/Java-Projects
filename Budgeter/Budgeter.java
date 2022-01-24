// Arnav Mathur
// 10/21/2019
// CSE 142 B
// TA: Jun Song
// Assignment #4
// This program is a budgeter that asks for user input to give total income and expense.
// It also calculates the amount saved or spent in a month.

import java.util.*;
public class Budgeter {
   public static final int DAYS = 31;
   public static void main(String[] args) {
      Scanner console = new Scanner(System.in);
      // initiates the doubles
      double incCat = 0;
      double incAmt = 0;
      double mOrD = 0;
      double expAmt = 0;
      double choice = 0;
      double totalday = 0;
      double totalday2 = 0;

      // Introductory line + asks for categories of income
      double total = askIncomeCategories(incCat, incAmt, console);
      // Asks for categories of expense
      double total2 = askCategoriesExpense(mOrD, expAmt, console);
      // Calculates Income
      double income =  incomeCalculator(total);
      double income2 = (100*income)/100;
      // Calculates Expense
      double expense = expenseCalculator(total2);
      double expense2 = (100*expense)/100;
      // Gives output for the saver
      save(income, income2, expense, expense2);
      // Gives output for the spender
      spender(income, income2, expense, expense2);
   }
   public static double askIncomeCategories(double incCat, double incAmt, Scanner console) {
      // incCat: income categories
      // incAmt: income Amount
      double sum = 0;
      System.out.println("This program asks for your monthly income and");
      System.out.println("expenses, then tells you your net monthly income.");
      System.out.println();
      System.out.print("How many categories of income? ");   
      incCat = console.nextDouble();      
      for (int i = 1; i<= incCat; i++) {
         System.out.print("    ");
         System.out.print("Next income amount? $");
         incAmt = console.nextDouble();
         sum = sum + incAmt;
         }
      System.out.println();
      return sum;  
   }
   public static double askCategoriesExpense(double mOrD, double expAmt, Scanner console) {
      // int mOrD: Monthly or Daily expense
      // int expAmt: Next Expense Amount
      double sum2 = 0;
      System.out.print("Enter 1) monthly or 2) daily expenses? ");
      double choice = console.nextDouble(); 
    
      System.out.print("How many categories of expense? ");
      mOrD = console.nextInt();
      for (int i = 1; i<= mOrD; i++) {
         System.out.print("    ");
         System.out.print("Next expense amount? $");
         expAmt = console.nextDouble();
         sum2 = sum2 + expAmt;
         }
      
      if (choice == 1)
      return sum2;
      else
      return sum2*DAYS;                
   } 
   public static double incomeCalculator(double total) {
      //totalday gets the total income per day
      System.out.println(); 
      double totalday = ((100*total)/DAYS)/100;
      System.out.printf("Total income = $%.2f ", total);
      System.out.printf("($%.2f/day)", totalday);
      System.out.println();
      return total;
   }
   public static double expenseCalculator(double total2) {
      //totalday2 gets the total expense per day
      double totalday2 = ((100*total2)/DAYS)/100;
      System.out.printf("Total expenses = $%.2f ", total2);
      System.out.printf("($%.2f/day) \n \n", totalday2);
      return total2;
   }
   public static double save(double income,double income2, double expense, double expense2) {
      double difference = income2-expense2;
      
      if (income2 > expense2) { 
      System.out.printf("You earned $%.2f more than you spent this month. \n", difference);
      
         if (difference > 250) {
            System.out.println("You're a big saver.");
            System.out.println("You are a person who really thinks for the future!");
            }
         else if (0 < difference && difference <= 250){
            System.out.println("You're a saver.");
            System.out.println("Enjoy your extra money once you retire");
            }
      }
      return difference;
   }
   public static double spender(double income,double income2, double expense, double expense2) {
      double difference = expense2 - income2;
      
      if (expense2 >= income2) {
      System.out.printf("You spent $%.2f more than you earned this month. \n", difference);
         if (difference >= 250){
            System.out.println("You're a big spender.");
            System.out.println("You spend way too much! Save some money for the future!");
            }
         else if(0 <= difference && difference < 250){
            System.out.println("You're a spender.");
            System.out.println("You enjoy spending but remember to save some money!");
            }
      }
      return difference;           
   }
}