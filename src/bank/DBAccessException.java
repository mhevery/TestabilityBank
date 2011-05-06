package bank;

public class DBAccessException extends RuntimeException {
  private static final long serialVersionUID = 8865462980318073091L;

  public DBAccessException() {
    super("If you get here then it means that your test is talking to the DB, "
        + "which means that you failed in issolating the code properly.");
  }
}
