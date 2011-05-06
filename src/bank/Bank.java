package bank;

import java.util.List;


public class Bank {

  private static final Bank instance = new Bank();

  public static Bank get() {
    return instance;
  }

  public Account createAccount(String accountId, double initialDeposit) {
    Account account = new Account(accountId);
    account.addTransaction(new DepositTransaction(initialDeposit));
    return account;
  }

  public List<Transaction> getTransactions(String accountId) {
    throw new DBAccessException();
  }

  public void addTransactions(String accountId, Transaction transaction) {
    throw new DBAccessException();
  }

}
