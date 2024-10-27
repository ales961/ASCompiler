import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import org.apache.commons.io.IOUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
       /* if (args.length != 2) {
            System.out.println("Usage: java CompilerMain <source_file> <bytecode_output_file>");
            return;
        }*/

        String sourceFilePath = "C:\\Users\\User\\IdeaProjects\\ASCompiler\\example.ts";//args[0];
        String bytecodeOutputFilePath = "C:\\Users\\User\\IdeaProjects\\ASCompiler\\example_output.bytecode"; //args[1];

        try {
            // Step 1: Read and parse the source file
            String sourceCode = readSourceFile(sourceFilePath);
            ASTNode ast = compileToAST(sourceCode);

            // Step 2: Generate bytecode from AST
            List<BytecodeInstruction> bytecodeInstructions = generateBytecode(ast);

            // Step 3: Write bytecode to output file
            BytecodeWriter writer = new BytecodeWriter();
            writer.writeToFile(bytecodeInstructions, bytecodeOutputFilePath);
        } catch (Exception e) {
            System.err.println("Error during compilation: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static String readSourceFile(String filePath) throws IOException {
        try(FileInputStream inputStream = new FileInputStream(filePath)) {
            String string = IOUtils.toString(inputStream);
            return string;
        }
    }

    public static ASTNode compileToAST(String sourceCode) {
        // Step 1: Create a CharStream that reads from the input string
        CharStream input = CharStreams.fromString(sourceCode);

        // Step 2: Create a lexer that feeds off the input CharStream
        AssemblyScriptLexer lexer = new AssemblyScriptLexer(input);

        // Step 3: Create a buffer of tokens between the lexer and parser
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        // Step 4: Create a parser that feeds off the tokens buffer
        AssemblyScriptParser parser = new AssemblyScriptParser(tokens);

        // Step 5: Begin parsing at the 'program' rule
        ParseTree tree = parser.program();

        // Step 6: Build AST using ASTBuilder visitor
        ASTBuilder astBuilder = new ASTBuilder();
        ASTNode ast = astBuilder.visit(tree);

        // Step 7: Perform semantic analysis
        System.out.println("Starting semantic analysis...");
        SemanticAnalyzer analyzer = new SemanticAnalyzer();
        if (ast != null) {
            ast.accept(analyzer);  // Traverse and analyze the AST
        } else {
            System.err.println("Error: AST is null.");
        }

        return ast;
    }

    public static List<BytecodeInstruction> generateBytecode(ASTNode ast) {
        // Generate bytecode from the AST
        BytecodeGenerator generator = new BytecodeGenerator();
        ast.accept(generator);
        return generator.getBytecode();
    }
}