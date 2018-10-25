import java_cup.runtime.*;
import java.io.*;

public class Repl {

    public static final String PROMPT = ">";

    /**
     * Treat the command line arguments as file names, reading input from
     * each one, and finally dropping into a REPL to read input from stdin.
     * Each file is evaluated as a separate program, but in an environment
     * that is propagated from one file to the next.  This means that the
     * REPL will be evaluated with respect to an environment that has all of
     * the side effects of evaluating the files named on the command line.
     */
    public static void main(String args[]) {
	Environment env = new Environment();
	for (String name: args) {
	    if (name.startsWith("-")) {
		continue;	// eventually do something with flag
	    } else {
		try {
		    FileReader fr = new FileReader(new File(name));
		    parseEvalShow(fr, env);
		} catch (FileNotFoundException fnfe) {
		    System.out.println(fnfe.getMessage());
		    System.out.println("Warning: Ignoring input file " + name);
		}
	    }
	}
	usage();
	repl(env);
    }

    public static void usage() {
	System.out.println("Type a sequence of assignments and expressions");
	System.out.println("Enter EOF (Ctrl-D on *nix, Ctrl-Z on Windows)");
	System.out.println(" to evaluate your statements.");
    }

    /**
     * Repeatedly, read from standard input, evaluate the expression, and
     * show the result.
     * @param env The initial environment to begin evaluating with.
     */
    public static void repl(Environment env) {
	InputStreamReader reader = new InputStreamReader(System.in);
	while (true) {
	    parseEvalShow(reader, env);
	}
    }

    /**
     * Read a program from the given reader, evaluate it with respect to
     * the given environment, and print the result.
     */
    public static void parseEvalShow(Reader reader, Environment env) {
	ArithParser parser;
	Exp commands = null;
	int result;
	System.out.print(PROMPT);
	try {
	    parser = new ArithParser(new Lexer(reader));
	    commands = (ArithProgram) parser.parse().value;
	} catch (IOException ioe) {
	    System.out.println("Parse Error " + ioe.getMessage());
	} catch (Exception e) {
	    System.out.println("Fatal Error: " + e.getMessage());
	    System.exit(1);
	}

	if (commands != null)
	    try {
		result = commands.eval(env);
		System.out.println("\nResult: " + result);
	    } catch (Exception e) {
		System.out.println(e.getMessage());
	    }
    }

}
