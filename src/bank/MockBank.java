package bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.Collections.unmodifiableList;

public class MockBank extends Bank {

  public Map<String, List<Transaction>> transactionsByAccount = new HashMap<String, List<Transaction>>();

  @Override
  public List<Transaction> getTransactions(String accountId) {
    List<Transaction> transactions = transactionsByAccount.get(accountId);
    if (transactions == null) {
      throw new AccountNotFoundException();
    }
    return unmodifiableList(transactions);
  }

  @Override
  public void addTransactions(String accountId, Transaction transaction) {
    List<Transaction> transactions = transactionsByAccount.get(accountId);
    if (transactions == null) {
      transactions = new ArrayList<Transaction>();
      transactionsByAccount.put(accountId, transactions);
    }
    transactions.add(transaction);
  }

}
