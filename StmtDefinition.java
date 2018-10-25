
public class StmtDefinition extends Statement {

    String var;
    Exp exp;

    public StmtDefinition(String id, Exp e) {
	var = id;
	exp = e;
    }

    public int eval(Environment env) throws Exception {
	int result = exp.eval(env);
	env.put(var, result);
	return result;
    }
}
