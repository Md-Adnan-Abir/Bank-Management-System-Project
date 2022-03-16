package bank.management.system;

import java.util.Scanner;

class Bank {

    private String accno;
    private String name;
    private long balance;

    Scanner KB = new Scanner(System.in);

    //method to open an account
    void openAccount() {
        System.out.print("Please Enter A Valid Account No.   : ");
        accno = KB.next();
        System.out.print("Please Enter The Customer Full Name: ");
        name = KB.next();
        System.out.print("Please Enter The Deposite Ammount  : ");
        balance = KB.nextLong();
    }

    //method to display account details
    void showAccount() {
        System.out.println("Account No:" + accno + "   Name:" + name + "   Ammount:" + balance);
    }

    //method to deposit money
    void deposit() {
        long amt;
        System.out.println("Enter Amount A Customer Want to Deposit : ");
        amt = KB.nextLong();
        balance = balance + amt;
    }

    //method to withdraw money
    void withdrawal() {
        long amt;
        System.out.println("Enter Amount A Customer Want to withdraw : ");
        amt = KB.nextLong();
        if (balance >= amt) {
            balance = balance - amt;
        } else {
            System.out.println("Less Balance..Transaction Failed..");
        }
    }

    //method to search an account number
    boolean search(String acn) {
        if (accno.equals(acn)) {
            showAccount();
            return (true);
        }
        return (false);
    }
}

public class BankManagementSystem {

    public static void main(String[] args) {
            Scanner KB = new Scanner(System.in);

        System.out.println("        Welcome to Bank Management System          ");
        System.out.print("How Many Customers Are Going To Open New Account : ");
        int n = KB.nextInt();
        Bank C[] = new Bank[n];
        for (int i = 0; i < C.length; i++) {
            C[i] = new Bank();
            C[i].openAccount();
        }

        //run loop until menu 5 is not pressed
        int ch;
        do {
            System.out.println("Main Menu\n1. Display All Customers Detaile\n 2. Search Customer By Account No.\n 3. Deposit Money By Account No.\n 4. Withdrawa Money By account No.\n 5.Log Out ");
            System.out.println("Enter Choice :");
            ch = KB.nextInt();
            switch (ch) {
                case 1:
                    for (Bank C1 : C) {
                        C1.showAccount();
                    }
                    break;

                case 2:
                    System.out.print("Enter Account No You Want to Search...: ");
                    String acn = KB.next();
                    boolean found = false;
                    for (Bank C1 : C) {
                        found = C1.search(acn);
                        if (found) {
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Search Failed..Account Not Exist..");
                    }
                    break;

                case 3:
                    System.out.print("Enter Account No : ");
                    acn = KB.next();
                    found = false;
                    for (Bank C1 : C) {
                        found = C1.search(acn);
                        if (found) {
                            C1.deposit();
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Search Failed..Account Not Exist..");
                    }
                    break;

                case 4:
                    System.out.print("Enter Account No : ");
                    acn = KB.next();
                    found = false;
                    for (Bank C1 : C) {
                        found = C1.search(acn);
                        if (found) {
                            C1.withdrawal();
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Search Failed..Account Not Exist..");
                    }
                    break;

                case 5:
                    System.out.println("Good Bye..");
                    break;
            }
        } while (ch != 5);
    }
    
}
