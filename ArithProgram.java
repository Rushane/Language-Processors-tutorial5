public class ArithProgram extends Exp {
    Exp exp;

    public ArithProgram(Exp e) {
	exp = e;
    }

    public int eval(Environment env) throws Exception {
	return exp.eval(env);
    }

    public String toString() {
	return exp.toString();
    }
}
