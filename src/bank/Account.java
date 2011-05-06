package bank;


public class Account {

  private final String accountId;

  public Account(String accountId) {
    this.accountId = accountId;
  }

  public static Account get(String accountId) {
    Account account = new Account(accountId);
    Bank.get().getTransactions(accountId);
    return account;
  }


  public double getBalance() {
    double balance = 0;
    for (Transaction transaction : Bank.get().getTransactions(accountId)) {
      balance += transaction.creditAmount() - transaction.debitAmount();
    }
    return balance;
  }

  public void addTransaction(Transaction transaction) {
    Bank.get().addTransactions(accountId, transaction);
  }

  public void transfer(String fromAccountId, double amount) {
    Account fromAccount = Account.get(fromAccountId);
    addTransaction(new WithdrawTransaction(amount));
    fromAccount.addTransaction(new DepositTransaction(amount));
  }

}
