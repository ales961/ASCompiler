import java.util.ArrayList;
import java.util.List;

public class ASTBuilder extends AssemblyScriptBaseVisitor<ASTNode> {

    @Override
    public ASTNode visitProgram(AssemblyScriptParser.ProgramContext ctx) {
        List<ASTNode> statements = new ArrayList<>();
        for (AssemblyScriptParser.StatementContext stmtCtx : ctx.statement()) {
            ASTNode statement = visit(stmtCtx);
            if (statement != null) {  // Ensure no null statements are added
                statements.add(statement);
            }
        }
        return new ProgramNode(statements);
    }

    @Override
    public ASTNode visitVarDecl(AssemblyScriptParser.VarDeclContext ctx) {
        List<VariableDeclNode> declarations = new ArrayList<>();
        for (int i = 0; i < ctx.varList().IDENTIFIER().size(); i++) {
            String varName = ctx.varList().IDENTIFIER(i).getText();
            ASTNode expr = ctx.varList().expr(i) != null ? visit(ctx.varList().expr(i)) : null;
            declarations.add(new VariableDeclNode(varName, expr));
        }
        return new MultiVariableDeclNode(declarations);
    }

    @Override
    public ASTNode visitLetDecl(AssemblyScriptParser.LetDeclContext ctx) {
        List<VariableDeclNode> declarations = new ArrayList<>();
        for (int i = 0; i < ctx.varList().IDENTIFIER().size(); i++) {
            String varName = ctx.varList().IDENTIFIER(i).getText();
            ASTNode expr = ctx.varList().expr(i) != null ? visit(ctx.varList().expr(i)) : null;
            declarations.add(new VariableDeclNode(varName, expr));
        }
        return new MultiVariableDeclNode(declarations);
    }

    @Override
    public ASTNode visitAssignment(AssemblyScriptParser.AssignmentContext ctx) {
        String varName = ctx.IDENTIFIER().getText();
        ASTNode expr = visit(ctx.expr());
        return new AssignmentNode(varName, expr);
    }

    @Override
    public ASTNode visitFunctionDecl(AssemblyScriptParser.FunctionDeclContext ctx) {
        // Get the function name (first identifier)
        String functionName = ctx.IDENTIFIER(0).getText();

        // Process function parameters (remaining identifiers after the function name)
        List<ASTNode> parameters = new ArrayList<>();
        for (int i = 1; i < ctx.IDENTIFIER().size(); i++) {
            String paramName = ctx.IDENTIFIER(i).getText();
            parameters.add(new VariableDeclNode(paramName, null)); // Parameters have no initial expression here
        }

        // Process function body statements
        List<ASTNode> body = new ArrayList<>();
        for (AssemblyScriptParser.StatementContext stmtCtx : ctx.statement()) {
            ASTNode statement = visit(stmtCtx);
            if (statement != null) {  // Ensure no null statements are added
                body.add(statement);
            }
        }

        // Return the FunctionNode with the name, parameters, and a block for the body
        return new FunctionNode(functionName, parameters, new BlockNode(body));
    }


    @Override
    public ASTNode visitReturnStmt(AssemblyScriptParser.ReturnStmtContext ctx) {
        ASTNode expr = visit(ctx.expr());
        return new ReturnNode(expr);
    }

    @Override
    public ASTNode visitIfStmt(AssemblyScriptParser.IfStmtContext ctx) {
        ASTNode condition = visit(ctx.expr());
        List<ASTNode> thenBranch = new ArrayList<>();
        for (AssemblyScriptParser.StatementContext stmtCtx : ctx.statement()) {
            ASTNode statement = visit(stmtCtx);
            if (statement != null) {  // Ensure no null statements are added
                thenBranch.add(statement);
            }
        }
        return new IfNode(condition, new BlockNode(thenBranch));
    }

    @Override
    public ASTNode visitWhileStmt(AssemblyScriptParser.WhileStmtContext ctx) {
        ASTNode condition = visit(ctx.expr());
        List<ASTNode> body = new ArrayList<>();
        for (AssemblyScriptParser.StatementContext stmtCtx : ctx.statement()) {
            ASTNode statement = visit(stmtCtx);
            if (statement != null) {  // Ensure no null statements are added
                body.add(statement);
            }
        }
        return new WhileNode(condition, new BlockNode(body));
    }

    @Override
    public ASTNode visitExpr(AssemblyScriptParser.ExprContext ctx) {
        if (ctx.INT_LITERAL() != null) {
            return new LiteralNode(ctx.INT_LITERAL().getText());
        } else if (ctx.IDENTIFIER() != null) {
            return new VariableNode(ctx.IDENTIFIER().getText());
        } else if (ctx.getChildCount() == 3) {  // Binary operation
            ASTNode left = visit(ctx.getChild(0));
            ASTNode right = visit(ctx.getChild(2));
            String operator = ctx.getChild(1).getText();
            return new BinaryOperationNode(left, right, operator);
        }
        return null;
    }
}
