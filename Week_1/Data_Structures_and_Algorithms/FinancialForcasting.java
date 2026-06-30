class FinancialForcasting {
  public static double calculateFutureValue(double presentValue, double growthRate, int years) {
    if (years == 0)
      return presentValue;
    double newValue = presentValue + (presentValue * growthRate);
    return calculateFutureValue(newValue, growthRate, years - 1);
  }

  public static void main(String[] args) {
    System.out.print("Gained Value: ");
    System.out.println(calculateFutureValue(1000, 0.5, 6));
  }
}
