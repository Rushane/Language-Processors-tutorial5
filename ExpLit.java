public class ExpLit extends Exp {

  int val;

  public ExpLit(Integer v) {
    val = v.intValue();
  }

  public int eval(Environment env) throws Exception {
    return val;
  }

  public String toString() {
    return Integer.toString(val);
  }
}

