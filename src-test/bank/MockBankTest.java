package bank;

import junit.framework.TestCase;

import static org.hamcrest.Matchers.is;

import static org.hamcrest.MatcherAssert.assertThat;

import static java.util.Arrays.asList;


public class MockBankTest extends TestCase {

  MockBank bank = new MockBank();

  public void testShouldThrowOnNoAccount() throws Exception {
    try {
      bank.getTransactions("IdontExist");
      fail("Exception expected");
    } catch (AccountNotFoundException e) {
    }
  }

  public void testItShouldAddAndRetrieveTransaction() throws Exception {
    Transaction tx = new DepositTransaction(0);
    bank.addTransactions("123", tx);
    assertThat(bank.getTransactions("123"), is(asList(tx)));
  }

  public void testItShouldAddMultipleAndRetrieveInSameOrder() throws Exception {
    Transaction tx1 = new DepositTransaction(1);
    Transaction tx2 = new DepositTransaction(2);
    Transaction tx3 = new DepositTransaction(3);
    bank.addTransactions("123", tx1);
    bank.addTransactions("123", tx2);
    bank.addTransactions("456", tx3); // make sure we have separate lists
    assertThat(bank.getTransactions("123"), is(asList(tx1, tx2)));

  }
}
