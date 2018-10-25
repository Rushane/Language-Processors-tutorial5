import java.util.*;

public class StmtSequence extends Exp {

    ArrayList seq;		// sequence of commands

    public StmtSequence() {
	seq = new ArrayList();
    }

    public StmtSequence(Statement s) {
	this();
	seq.add(s);
    }

    public StmtSequence add(Statement s) {
	seq.add(s);
	return this;
    }

    public int eval(Environment env) throws Exception {
	Statement s;
	Iterator iter = seq.iterator();
	int result = 0;		// default result
	while(iter.hasNext()) {
	    s = (Statement) iter.next();
	    result = s.eval(env);
	}
	// return last value evaluated
	return result;
    }

    public String toString() {
	Iterator iter = seq.iterator();

	String result = "";
	while (iter.hasNext()) {
	    result = result + iter.next().toString() + "\n";
	}

	return result;
    }

}

