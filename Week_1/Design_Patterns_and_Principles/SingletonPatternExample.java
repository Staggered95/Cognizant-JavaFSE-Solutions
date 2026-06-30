//from what i understand, singleton design means one class itself makes a static instance of itself and only shares it with others with some method instead of letting other code/class/functions create new instance of it.

class Logger {
  private static Logger logger = new Logger();

  private Logger() {
  };

  public static Logger getInstance() {
    return logger;
  }
}

class SingletonPatternExample {
  public static void main(String[] args) {
    Logger logger1 = Logger.getInstance();
    Logger logger2 = Logger.getInstance();

    System.out.print("Are these two instances actually same?: ");
    System.out.println(logger1 == logger2);
  }
}
