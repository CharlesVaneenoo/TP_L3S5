package postfixees;
public class Q  extends Operateur implements Yytoken{
 
  protected int calcul(int... values){
    return values[0] % values[1];
  }
  
  public Q(String image){
    super(image,2);
  }
}
