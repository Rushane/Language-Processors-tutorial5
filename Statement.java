public class Statement extends Exp {

    Exp exp;

    public Statement() {
	super();
    }

    public Statement(Exp e) {
	exp = e;
    }

    public int eval(Environment env) throws Exception {
	return exp.eval(env);
    }

    public String toString() {
	return exp.toString();
    }
}
