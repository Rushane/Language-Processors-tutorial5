public class ExpMod extends Exp {

  Exp exp1, exp2;

  public ExpMod(Exp e1, Exp e2) {
    exp1 = e1;
    exp2 = e2;
  }

  public int eval(Environment env) throws Exception {
    return exp1.eval(env) % exp2.eval(env);
  }

  public String toString() {
    return exp1.toString() + " % " + exp2.toString();
  }
}

