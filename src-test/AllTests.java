import junit.framework.TestSuite;
import junit.textui.TestRunner;
import bank.AccountTest;
import bank.MockBankTest;

public class AllTests {
  public static void main(String[] args) {
    TestSuite suite = new TestSuite();
    suite.addTestSuite(HelloWorldTest.class);
    suite.addTestSuite(AccountTest.class);
    suite.addTestSuite(MockBankTest.class);
    TestRunner.run(suite);
  }
}
