public class RationalNumber{
  private int n;
  private int d;
  public RationalNumber(int num, int denom) {
    n = num;
    d = denom;
  }
  
  public int getN() {
    return n;
  }
  
  public int getD() {
    return d;
  }
  
  public double getValue() {
    return getN() / getD();
  }
  
}
