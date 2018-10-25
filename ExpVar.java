public class ExpVar extends Exp {

    String var;

    public ExpVar(String id) {
	var = id;
    }

    public int eval(Environment env) throws Exception {
	return env.get(var);
    }

    public String toString() {
	return var;
    }
}
