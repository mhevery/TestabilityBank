package bank;

public class WithdrawTransaction implements Transaction {

  private final double amount;

  public WithdrawTransaction(double amount) {
    this.amount = amount;
  }

  @Override
  public double creditAmount() {
    return 0;
  }

  @Override
  public double debitAmount() {
    return amount;
  }

}
