import java.util.List;

abstract class ASTNode {
    public abstract void accept(ASTVisitor visitor);
}

// Program node to represent the entire program
class ProgramNode extends ASTNode {
    List<ASTNode> statements;

    public ProgramNode(List<ASTNode> statements) {
        this.statements = statements;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}

// Node for a single variable declaration
class VariableDeclNode extends ASTNode {
    String variableName;
    ASTNode expression;

    public VariableDeclNode(String variableName, ASTNode expression) {
        this.variableName = variableName;
        this.expression = expression;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}

// Node for multi-variable declarations (e.g., var a = 0, b = 1)
class MultiVariableDeclNode extends ASTNode {
    List<VariableDeclNode> declarations;

    public MultiVariableDeclNode(List<VariableDeclNode> declarations) {
        this.declarations = declarations;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}

// Node for an assignment operation
class AssignmentNode extends ASTNode {
    String variableName;
    ASTNode expression;

    public AssignmentNode(String variableName, ASTNode expression) {
        this.variableName = variableName;
        this.expression = expression;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}

// Node for if statements
class IfNode extends ASTNode {
    ASTNode condition;
    ASTNode thenBranch;

    public IfNode(ASTNode condition, ASTNode thenBranch) {
        this.condition = condition;
        this.thenBranch = thenBranch;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}

// Node for while statements
class WhileNode extends ASTNode {
    ASTNode condition;
    ASTNode body;

    public WhileNode(ASTNode condition, ASTNode body) {
        this.condition = condition;
        this.body = body;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}

// Node for binary operations (like +, -, !=)
class BinaryOperationNode extends ASTNode {
    ASTNode left;
    ASTNode right;
    String operator;

    public BinaryOperationNode(ASTNode left, ASTNode right, String operator) {
        this.left = left;
        this.right = right;
        this.operator = operator;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}

class BlockNode extends ASTNode {
    List<ASTNode> statements;

    public BlockNode(List<ASTNode> statements) {
        this.statements = statements;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}

// Node for literals (integers)
class LiteralNode extends ASTNode {
    String value;

    public LiteralNode(String value) {
        this.value = value;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}

class VariableNode extends ASTNode {
    String name;

    public VariableNode(String name) {
        this.name = name;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}

class FunctionNode extends ASTNode {
    String functionName;
    List<ASTNode> parameters; // For now, parameters list can be empty if no parameters are needed
    BlockNode body;

    public FunctionNode(String functionName, List<ASTNode> parameters, BlockNode body) {
        this.functionName = functionName;
        this.parameters = parameters;
        this.body = body;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}

class ReturnNode extends ASTNode {
    ASTNode expression; // Expression to return

    public ReturnNode(ASTNode expression) {
        this.expression = expression;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
