import java.io.*;

public class SMPLrepl{
	static SMPLEvaluator interp;
	static SMPLContext globalEnv;

	static String lastResult;

	public static void main(String[] args){
		interp = new SMPLEvaluator();
		globalEnv =  interp.mkInitialContext();

		boolean interactive = true;
		for(String arg: args){
			if (arg.equals("-e")){
				interactive = false;
			}
			else{
				try{
					parseEvalShow(new FileReader(new File(arg)), globalEnv);
				}
				catch(FileNotFoundException fnf){
					System.out.println("Could not find file" +arg);
				}
			}
		}
		if (interactive)
			repl(System.in, globalEnv);
	}
	public static void repl(InputStream is, SMPLContext genv){
		final String FIRST_PROMPT = "SMPL->";
		final String NEXT_PROMPT = "... ";
		BufferedReader reader = new BufferedReader(new InputStreamReader(is));
		try{
			while (true){
				System.out.println(FIRST_PROMPT);
				StringBuffer input = new StringBuffer();
				String line = reader.readLine();
				while(line != null && !line.equals(".")){
					System.out.println(NEXT_PROMPT);
					input.append("\n");
					input.append(line);
					line = reader.readLine();
				}

				StringReader r = new StringReader(new String(input));
				parseEvalShow(r,genv);
			}
		}
		catch (IOException ioe){
			System.out.println("Closing Program");
		}
	}

	public static void parseEvalShow(Reader r, SMPLContext env){
		SMPLLexer lexer;
		SMPLParser parser;
		SMPLProgram commands = null;

		try{
			lexer = new SMPLLexer(r);
			parser = new SMPLParser(lexer);
			commands = (SMPLProgram)parser.parse().value;
		}
		catch (Exception e){
			System.out.println("Syntax Error:"+ e.getMessage());

		}

		String result;
		if (commands != null)
		    try {
			result = commands.visit(interp, env);
			if (result != "") {
	                    System.out.println("\n" + result.toString());
			} else {
			    System.out.println("\nNo result");
			}
		    } catch (SMPLException smple) {
			System.out.println("Runtime Error: " + smple.report());
		    }
	    }
}