import java.util.HashMap;
import java.util.Map;

public class SemanticAnalyzer implements ASTVisitor {
    private Map<String, String> symbolTable = new HashMap<>(); // Store variable names and their types

    @Override
    public void visit(ProgramNode node) {
        for (ASTNode stmt : node.statements) {
            stmt.accept(this);
        }
    }

    @Override
    public void visit(VariableDeclNode node) {
        if (symbolTable.containsKey(node.variableName)) {
            throw new RuntimeException("Variable '" + node.variableName + "' is already declared.");
        }

        symbolTable.put(node.variableName, "int");  // Assume integer type for now
        if (node.expression != null) {
            node.expression.accept(this);
        }
    }

    @Override
    public void visit(MultiVariableDeclNode node) {
        for (VariableDeclNode decl : node.declarations) {
            decl.accept(this);
        }
    }

    @Override
    public void visit(AssignmentNode node) {
        if (!symbolTable.containsKey(node.variableName)) {
            throw new RuntimeException("Variable '" + node.variableName + "' is not declared.");
        }
        node.expression.accept(this);
    }

    @Override
    public void visit(IfNode node) {
        node.condition.accept(this);
        if (!isBooleanExpression(node.condition)) {
            throw new RuntimeException("If condition must be a boolean expression.");
        }
        node.thenBranch.accept(this);
    }

    @Override
    public void visit(WhileNode node) {
        node.condition.accept(this);
        if (!isBooleanExpression(node.condition)) {
            throw new RuntimeException("While loop condition must be a boolean expression.");
        }
        node.body.accept(this);
    }

    @Override
    public void visit(BinaryOperationNode node) {
        node.left.accept(this);
        node.right.accept(this);
        if (!isCompatibleOperation(node.operator, node.left, node.right)) {
            throw new RuntimeException("Incompatible operands for operator '" + node.operator + "'.");
        }
    }

    @Override
    public void visit(LiteralNode node) {
        // No additional checks needed for literals
    }

    @Override
    public void visit(BlockNode node) {
        for (ASTNode stmt : node.statements) {
            stmt.accept(this);
        }
    }

    @Override
    public void visit(VariableNode node) {
        if (!symbolTable.containsKey(node.name)) {
            throw new RuntimeException("Variable '" + node.name + "' is not declared.");
        }
    }

    @Override
    public void visit(FunctionNode node) {
        System.out.println("Analyzing function: " + node.functionName);

        // Analyze each parameter if parameters are added to the function
        for (ASTNode param : node.parameters) {
            param.accept(this); // This can be expanded to add parameters to the symbol table
        }

        // Analyze the function body
        node.body.accept(this);
    }

    @Override
    public void visit(ReturnNode node) {
        System.out.println("Analyzing return statement");
        if (node.expression != null) {
            node.expression.accept(this);  // Analyze the expression to be returned
        }
        // Additional checks can be added here, like ensuring return types match the function signature
    }


    // Helper methods
    private boolean isBooleanExpression(ASTNode condition) {
        if (condition instanceof BinaryOperationNode) {
            String operator = ((BinaryOperationNode) condition).operator;
            return operator.equals("!=") || operator.equals("==") || operator.equals(">") || operator.equals("<") ||
                    operator.equals(">=") || operator.equals("<=");
        }
        return false;
    }

    private boolean isCompatibleOperation(String operator, ASTNode left, ASTNode right) {
        return true;  // Placeholder; extend for actual type compatibility checks
    }
}
