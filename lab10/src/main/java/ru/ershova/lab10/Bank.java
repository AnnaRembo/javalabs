package ru.ershova.lab10;

/**
 * @author Anna
 */
public class Bank {
    private static Account acc1;
    private static Account acc2;

    public static void main(String[] args) {
        acc1 = new Account("1", 100);
        acc2 = new Account("2", 0);

        Bank bank = new Bank();
        bank.doTransaction();
    }

    // обращение к методу теперь синхронизировано
    // но может возникнуть bottle neck
    public synchronized void transferMoney(Account acc1, Account acc2, int summ){
        if (positiveBalance(acc1, summ)) {
            acc1.decrement(summ);
            acc2.increment(summ);
        }
//        System.out.println("Баланс 1: " + acc1.getBalance());
//        System.out.println("Баланс 2: " + acc2.getBalance());
    }

    // баланс позволяет совершить транзакцию
    public boolean positiveBalance(Account acc, int summ) {
        if (acc.getBalance() - summ >= 0) {
            return true;
        } else {
            return false;
        }
    }

    public void doTransaction() {
        Thread thread1 = new Thread(() -> {
            for(int i = 0; i< 30; i++)
            {
                transferMoney(acc1, acc2, 1);
            }
        });

        Thread thread2 = new Thread(() -> {
            for(int i = 0; i< 30; i++)
            {
                transferMoney(acc1, acc2, 1);
            }
        });

        thread1.start();
        thread2.start();
    }
}
