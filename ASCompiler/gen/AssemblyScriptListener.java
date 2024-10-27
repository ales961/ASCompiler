// Generated from C:/Users/User/IdeaProjects/ASCompiler/src/main/java/AssemblyScript.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link AssemblyScriptParser}.
 */
public interface AssemblyScriptListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link AssemblyScriptParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(AssemblyScriptParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link AssemblyScriptParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(AssemblyScriptParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link AssemblyScriptParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(AssemblyScriptParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link AssemblyScriptParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(AssemblyScriptParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link AssemblyScriptParser#varDecl}.
	 * @param ctx the parse tree
	 */
	void enterVarDecl(AssemblyScriptParser.VarDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link AssemblyScriptParser#varDecl}.
	 * @param ctx the parse tree
	 */
	void exitVarDecl(AssemblyScriptParser.VarDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link AssemblyScriptParser#letDecl}.
	 * @param ctx the parse tree
	 */
	void enterLetDecl(AssemblyScriptParser.LetDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link AssemblyScriptParser#letDecl}.
	 * @param ctx the parse tree
	 */
	void exitLetDecl(AssemblyScriptParser.LetDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link AssemblyScriptParser#varList}.
	 * @param ctx the parse tree
	 */
	void enterVarList(AssemblyScriptParser.VarListContext ctx);
	/**
	 * Exit a parse tree produced by {@link AssemblyScriptParser#varList}.
	 * @param ctx the parse tree
	 */
	void exitVarList(AssemblyScriptParser.VarListContext ctx);
	/**
	 * Enter a parse tree produced by {@link AssemblyScriptParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(AssemblyScriptParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link AssemblyScriptParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(AssemblyScriptParser.AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link AssemblyScriptParser#functionDecl}.
	 * @param ctx the parse tree
	 */
	void enterFunctionDecl(AssemblyScriptParser.FunctionDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link AssemblyScriptParser#functionDecl}.
	 * @param ctx the parse tree
	 */
	void exitFunctionDecl(AssemblyScriptParser.FunctionDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link AssemblyScriptParser#returnStmt}.
	 * @param ctx the parse tree
	 */
	void enterReturnStmt(AssemblyScriptParser.ReturnStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link AssemblyScriptParser#returnStmt}.
	 * @param ctx the parse tree
	 */
	void exitReturnStmt(AssemblyScriptParser.ReturnStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link AssemblyScriptParser#ifStmt}.
	 * @param ctx the parse tree
	 */
	void enterIfStmt(AssemblyScriptParser.IfStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link AssemblyScriptParser#ifStmt}.
	 * @param ctx the parse tree
	 */
	void exitIfStmt(AssemblyScriptParser.IfStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link AssemblyScriptParser#whileStmt}.
	 * @param ctx the parse tree
	 */
	void enterWhileStmt(AssemblyScriptParser.WhileStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link AssemblyScriptParser#whileStmt}.
	 * @param ctx the parse tree
	 */
	void exitWhileStmt(AssemblyScriptParser.WhileStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link AssemblyScriptParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(AssemblyScriptParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link AssemblyScriptParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(AssemblyScriptParser.ExprContext ctx);
}