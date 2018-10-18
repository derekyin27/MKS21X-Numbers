public class RationalNumber extends RealNumber
{
  private int numerator, denominator;

  /**Initialize the RationalNumber with the provided values
  *  if the denominator is 0, make the fraction 0/1 instead
  *@param nume the numerator
  *@param deno the denominator
  */
  public RationalNumber(int nume, int deno){
    super(0);//this value is ignored! 
    numerator = nume;
    denominator = deno;
  }

  public double getValue(){
    return (double)numerator / denominator;
  }

  /**
  *@return the numerator
  */
  public int getNumerator(){
    return numerator;
  }
  /**
  *@return the denominator
  */
  public int getDenominator(){
    return denominator;
  }
  /**
  *@return a new RationalNumber that has the same numerator
  *and denominator as this RationalNumber but reversed.
  */
  public RationalNumber reciprocal(){
    RationalNumber recip = new RationalNumber(denominator, numerator);
    return recip;
  }
  /**
  *@return true when the RationalNumbers have the same numerators and denominators, false otherwise.
  */
  public boolean equals(RationalNumber other){
    return this.getValue() == other.getValue();
  }


  /**
  *@return the value expressed as "3/4" or "8/3"
  */
  public String toString(){
    return numerator + "/" + denominator;
  }



  /**Calculate the GCD of two integers.
  *@param a the first integers
  *@param b the second integer
  *@return the value of the GCD
  */
  private static int gcd(int a, int b){
    int gcdz = 0;
    for(int i = 1; i <= a && i <= b; ++i)
        {
            if(a % i==0 && b % i==0)
                gcdz = i;
        }
        return gcdz;
  }



  /**
  *Divide the numerator and denominator by the GCD
  *This must be used to maintain that all RationalNumbers are
  *reduced after construction.
  */
  private void reduce(){
numerator = numerator / gcd(numerator, denominator);
denominator = denominator / gcd(numerator, denominator);
  }



  /******************Operations!!!!****************/


  /**
  *Return a new RationalNumber that is the product of this and the other
  */
  public RationalNumber multiply(RationalNumber other){
  RationalNumber res = new RationalNumber(this.getNumerator() * other.getNumerator(), other.getDenominator() * this.getDenominator());
    return res;
  }

  /**
  *Return a new RationalNumber that is the this divided by the other
  */
  public RationalNumber divide(RationalNumber other){
    RationalNumber res = new RationalNumber(this.getNumerator() * other.getDenominator(), other.getNumerator() * this.getDenominator());
    return res;
  }

  /**
  *Return a new RationalNumber that is the sum of this and the other
  */
  public RationalNumber add(RationalNumber other){
    RationalNumber res = new RationalNumber(this.reduce() + other.reduce(), this.gcd());
    return res;
  }
  /**
  *Return a new RationalNumber that this minus the other
  */
  public RationalNumber subtract(RationalNumber other){
    RationalNumber res = new RationalNumber(this.reduce() - other.reduce(), this.gcd());
    return res;
  }
} 
