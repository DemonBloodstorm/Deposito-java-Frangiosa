import java.util.Scanner;

public class Bank {

    static class BankAccount {
        String accountHolderName = "Gabriele";
        String passwordAccount = "Frangiosa";
        double balance;

        void deposit(double amount) {
            balance += amount;
        }

        void withdraw(double amount) {
            if (amount > balance) {
                System.out.println("Credito insufficiente");
            } else {
                balance -= amount;
            }
        }

        void displayBalance() {
            System.out.println("Saldo attuale: " + balance);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BankAccount account = new BankAccount();

        System.out.println("Benvenuto");
        System.out.print("Nome utente: ");
        String username = sc.nextLine();
        System.out.print("Password: ");
        String password = sc.nextLine();

        // Autenticazione
        if (account.accountHolderName.equals(username) && account.passwordAccount.equals(password)) {
            System.out.println("Login riuscito. Benvenuto " + username);

            while (true) {
                System.out.println("\n1. Deposita");
                System.out.println("2. Preleva");
                System.out.println("3. Mostra saldo");
                System.out.println("4. Esci");
                System.out.print("Scelta: ");
                int scelta = sc.nextInt();

                switch (scelta) {
                    case 1:
                        System.out.print("Inserisci l'importo da depositare: ");
                        double depositAmount = sc.nextDouble();
                        account.deposit(depositAmount);
                        break;
                    case 2:
                        System.out.print("Inserisci l'importo da prelevare: ");
                        double withdrawAmount = sc.nextDouble();
                        account.withdraw(withdrawAmount);
                        break;
                    case 3:
                        account.displayBalance();
                        break;
                    case 4:
                        System.out.println("Uscita dal programma.");
                        sc.close();
                        return;
                    default:
                        System.out.println("Scelta non valida.");
                }
            }
        } else {
            System.out.println("Nome utente o password non corretti. Accesso negato.");
            sc.close();
        }
    }
}

