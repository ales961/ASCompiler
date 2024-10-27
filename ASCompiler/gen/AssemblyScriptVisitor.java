// Generated from C:/Users/User/IdeaProjects/ASCompiler/src/main/java/AssemblyScript.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link AssemblyScriptParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface AssemblyScriptVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link AssemblyScriptParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(AssemblyScriptParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link AssemblyScriptParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(AssemblyScriptParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link AssemblyScriptParser#varDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDecl(AssemblyScriptParser.VarDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link AssemblyScriptParser#letDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLetDecl(AssemblyScriptParser.LetDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link AssemblyScriptParser#varList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarList(AssemblyScriptParser.VarListContext ctx);
	/**
	 * Visit a parse tree produced by {@link AssemblyScriptParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(AssemblyScriptParser.AssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link AssemblyScriptParser#functionDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionDecl(AssemblyScriptParser.FunctionDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link AssemblyScriptParser#returnStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStmt(AssemblyScriptParser.ReturnStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link AssemblyScriptParser#ifStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStmt(AssemblyScriptParser.IfStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link AssemblyScriptParser#whileStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStmt(AssemblyScriptParser.WhileStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link AssemblyScriptParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(AssemblyScriptParser.ExprContext ctx);
}