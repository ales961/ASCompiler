import java.util.ArrayList;
import java.util.List;

public class BytecodeGenerator implements ASTVisitor {
    private List<BytecodeInstruction> bytecode = new ArrayList<>();
    private int labelCounter = 0;

    public List<BytecodeInstruction> getBytecode() {
        return bytecode;
    }

    // Helper to generate unique labels
    private String generateLabel(String base) {
        return base + "_" + (labelCounter++);
    }

    @Override
    public void visit(ProgramNode node) {
        for (ASTNode stmt : node.statements) {
            stmt.accept(this);
        }
    }

    @Override
    public void visit(BlockNode node) {
        for (ASTNode stmt : node.statements) {
            stmt.accept(this);  // Generate bytecode for each statement in the block
        }
    }

    @Override
    public void visit(VariableNode node) {
        bytecode.add(new PushBytecode(node.name));  // Push the variable's value onto the stack
    }

    @Override
    public void visit(VariableDeclNode node) {
        System.out.println("Generating bytecode for variable declaration: " + node.variableName);
        if (node.expression != null) {
            node.expression.accept(this);       // Generate bytecode for the assigned expression
            bytecode.add(new PopBytecode(node.variableName));  // Store in variable
        }
    }

    @Override
    public void visit(MultiVariableDeclNode node) {
        System.out.println("Generating bytecode for multiple variable declarations...");
        for (VariableDeclNode decl : node.declarations) {
            decl.accept(this);  // Each declaration is handled by visit(VariableDeclNode)
        }
    }

    @Override
    public void visit(AssignmentNode node) {
        System.out.println("Generating bytecode for assignment: " + node.variableName);
        node.expression.accept(this);           // Generate bytecode for the expression on the right-hand side
        bytecode.add(new PopBytecode(node.variableName));  // Store result in the variable
    }

    @Override
    public void visit(IfNode node) {
        System.out.println("Generating bytecode for if statement...");
        String falseLabel = generateLabel("false");
        String endLabel = generateLabel("endIf");

        node.condition.accept(this);            // Generate bytecode for the condition expression
        bytecode.add(new BranchIfFalseBytecode(falseLabel)); // Jump if condition is false

        node.thenBranch.accept(this);           // Generate bytecode for the "then" branch
        bytecode.add(new JumpBytecode(endLabel));            // Jump to the end of if

        bytecode.add(new LabelBytecode(falseLabel));         // Label for false branch
        bytecode.add(new LabelBytecode(endLabel));           // End of if
    }

    @Override
    public void visit(WhileNode node) {
        System.out.println("Generating bytecode for while loop...");
        String loopStart = generateLabel("loopStart");
        String loopEnd = generateLabel("loopEnd");

        bytecode.add(new LabelBytecode(loopStart));          // Mark start of the loop

        node.condition.accept(this);                         // Generate bytecode for the loop condition
        bytecode.add(new BranchIfFalseBytecode(loopEnd));    // Exit loop if condition is false

        node.body.accept(this);                              // Generate bytecode for the loop body
        bytecode.add(new JumpBytecode(loopStart));           // Jump back to the loop start

        bytecode.add(new LabelBytecode(loopEnd));            // Mark end of the loop
    }

    @Override
    public void visit(BinaryOperationNode node) {
        System.out.println("Generating bytecode for binary operation: " + node.operator);
        node.left.accept(this);                // Generate bytecode for left operand
        node.right.accept(this);               // Generate bytecode for right operand

        switch (node.operator) {
            case "+":
                bytecode.add(new AddBytecode());
                break;
            case "-":
                bytecode.add(new SubBytecode());
                break;
            case "*":
                bytecode.add(new MulBytecode());
                break;
            case "/":
                bytecode.add(new DivBytecode());
                break;
            case "!=":
                bytecode.add(new NeqBytecode());
                break;
            case "==":
                bytecode.add(new EqBytecode());
                break;
            case ">":
                bytecode.add(new GtBytecode());
                break;
            case "<":
                bytecode.add(new LtBytecode());
                break;
            case ">=":
                bytecode.add(new GteBytecode());
                break;
            case "<=":
                bytecode.add(new LteBytecode());
                break;
            default:
                throw new UnsupportedOperationException("Operator " + node.operator + " not supported.");
        }
    }

    @Override
    public void visit(LiteralNode node) {
        System.out.println("Generating bytecode for literal: " + node.value);
        bytecode.add(new PushBytecode(node.value));          // Push literal value onto the stack
    }

    @Override
    public void visit(FunctionNode node) {
        System.out.println("Generating bytecode for function: " + node.functionName);
        for (ASTNode param : node.parameters) {
            param.accept(this); // Generate bytecode for each parameter if needed
        }
        node.body.accept(this); // Generate bytecode for the function body
    }

    @Override
    public void visit(ReturnNode node) {
        System.out.println("Generating bytecode for return statement");
        node.expression.accept(this);  // Generate bytecode for the return expression
        bytecode.add(new ReturnBytecode());  // Add RETURN instruction
    }
}
