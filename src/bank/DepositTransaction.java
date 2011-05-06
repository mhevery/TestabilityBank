package bank;

public class DepositTransaction implements Transaction {

  private double amount;

  public DepositTransaction(double amount) {
    super();
    this.amount = amount;
  }

  @Override
  public double creditAmount() {
    return amount;
  }

  @Override
  public double debitAmount() {
    return 0;
  }

}
