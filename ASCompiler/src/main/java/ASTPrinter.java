public class ASTPrinter implements ASTVisitor {

    public void visit(ProgramNode node) {
        System.out.println("Program:");
        for (ASTNode stmt : node.statements) {
            stmt.accept(this);
        }
    }

    public void visit(VariableDeclNode node) {
        System.out.print("Variable Declaration: " + node.variableName);
        if (node.expression != null) {
            System.out.print(" = ");
            node.expression.accept(this);
        }
        System.out.println();
    }

    public void visit(MultiVariableDeclNode node) {
        System.out.println("Multiple Variable Declarations:");
        for (VariableDeclNode decl : node.declarations) {
            decl.accept(this);
        }
    }

    public void visit(AssignmentNode node) {
        System.out.print("Assignment: " + node.variableName + " = ");
        node.expression.accept(this);
        System.out.println();
    }

    public void visit(IfNode node) {
        System.out.print("If condition: ");
        node.condition.accept(this);
        System.out.println("Then branch:");
        node.thenBranch.accept(this);
    }

    public void visit(WhileNode node) {
        System.out.print("While condition: ");
        node.condition.accept(this);
        System.out.println("While body:");
        node.body.accept(this);
    }

    public void visit(BinaryOperationNode node) {
        System.out.print("(");
        node.left.accept(this);
        System.out.print(" " + node.operator + " ");
        node.right.accept(this);
        System.out.print(")");
    }

    public void visit(LiteralNode node) {
        System.out.print(node.value);
    }

    @Override
    public void visit(BlockNode node) {
        System.out.println("Block of statements:");
        for (ASTNode stmt : node.statements) {
            stmt.accept(this);
        }
    }

    @Override
    public void visit(VariableNode node) {
        System.out.print("Variable: " + node.name);  // Print variable name reference
    }

    public void visit(FunctionNode node) {
        System.out.println("Function: " + node.functionName);
        System.out.println("Parameters:");
        for (ASTNode param : node.parameters) {
            param.accept(this);
        }
        System.out.println("Body:");
        node.body.accept(this);
    }

    public void visit(ReturnNode node) {
        System.out.print("Return statement: ");
        node.expression.accept(this);
        System.out.println();
    }
}
