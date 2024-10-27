abstract class BytecodeInstruction {
    public abstract void execute(ExecutionContext context);
    public abstract String toString();
}

// PUSH instruction
class PushBytecode extends BytecodeInstruction {
    String value;

    public PushBytecode(String value) {
        this.value = value;
    }

    @Override
    public void execute(ExecutionContext context) {
        if (value.matches("[a-zA-Z_][a-zA-Z_0-9]*")) {
            context.push(context.load(value));
        } else {
            context.push(Integer.parseInt(value));
        }
    }

    @Override
    public String toString() {
        return "PUSH " + value;
    }
}

// POP instruction
class PopBytecode extends BytecodeInstruction {
    String variable;

    public PopBytecode(String variable) {
        this.variable = variable;
    }

    @Override
    public void execute(ExecutionContext context) {
        int value = context.pop();
        context.store(variable, value);
    }

    @Override
    public String toString() {
        return "POP " + variable;
    }
}

// ADD instruction
class AddBytecode extends BytecodeInstruction {
    @Override
    public void execute(ExecutionContext context) {
        int b = context.pop();
        int a = context.pop();
        context.push(a + b);
    }

    @Override
    public String toString() {
        return "ADD";
    }
}

// SUB instruction: pops two values, subtracts them, and pushes the result
class SubBytecode extends BytecodeInstruction {
    @Override
    public void execute(ExecutionContext context) {
        int b = context.pop();
        int a = context.pop();
        context.push(a - b);
    }

    @Override
    public String toString() {
        return "SUB";
    }
}

// MUL instruction: pops two values, multiplies them, and pushes the result
class MulBytecode extends BytecodeInstruction {
    @Override
    public void execute(ExecutionContext context) {
        int b = context.pop();
        int a = context.pop();
        context.push(a * b);
    }

    @Override
    public String toString() {
        return "MUL";
    }
}

// DIV instruction: pops two values, divides them, and pushes the result
class DivBytecode extends BytecodeInstruction {
    @Override
    public void execute(ExecutionContext context) {
        int b = context.pop();
        int a = context.pop();
        context.push(a / b);  // Ensure division by zero handling in VM, if needed
    }

    @Override
    public String toString() {
        return "DIV";
    }
}

// NEQ instruction: pops two values, checks for inequality, and pushes 1 (true) or 0 (false)
class NeqBytecode extends BytecodeInstruction {
    @Override
    public void execute(ExecutionContext context) {
        int b = context.pop();
        int a = context.pop();
        context.push(a != b ? 1 : 0);
    }

    @Override
    public String toString() {
        return "NEQ";
    }
}

// EQ instruction: pops two values, checks for equality, and pushes 1 (true) or 0 (false)
class EqBytecode extends BytecodeInstruction {
    @Override
    public void execute(ExecutionContext context) {
        int b = context.pop();
        int a = context.pop();
        context.push(a == b ? 1 : 0);
    }

    @Override
    public String toString() {
        return "EQ";
    }
}

// GT instruction: pops two values, checks if first is greater, and pushes 1 or 0
class GtBytecode extends BytecodeInstruction {
    @Override
    public void execute(ExecutionContext context) {
        int b = context.pop();
        int a = context.pop();
        context.push(a > b ? 1 : 0);
    }

    @Override
    public String toString() {
        return "GT";
    }
}

// LT instruction: pops two values, checks if first is less, and pushes 1 or 0
class LtBytecode extends BytecodeInstruction {
    @Override
    public void execute(ExecutionContext context) {
        int b = context.pop();
        int a = context.pop();
        context.push(a < b ? 1 : 0);
    }

    @Override
    public String toString() {
        return "LT";
    }
}

// GTE instruction: pops two values, checks if first is greater or equal, and pushes 1 or 0
class GteBytecode extends BytecodeInstruction {
    @Override
    public void execute(ExecutionContext context) {
        int b = context.pop();
        int a = context.pop();
        context.push(a >= b ? 1 : 0);
    }

    @Override
    public String toString() {
        return "GTE";
    }
}

// LTE instruction: pops two values, checks if first is less or equal, and pushes 1 or 0
class LteBytecode extends BytecodeInstruction {
    @Override
    public void execute(ExecutionContext context) {
        int b = context.pop();
        int a = context.pop();
        context.push(a <= b ? 1 : 0);
    }

    @Override
    public String toString() {
        return "LTE";
    }
}

// JUMP instruction: unconditional jump to a label
class JumpBytecode extends BytecodeInstruction {
    String label;

    public JumpBytecode(String label) {
        this.label = label;
    }

    @Override
    public void execute(ExecutionContext context) {
        int targetIp = context.findLabel(label);
        context.jumpTo(targetIp);
    }

    @Override
    public String toString() {
        return "JUMP " + label;
    }
}

// BRANCH_IF_FALSE instruction: conditional jump if top of stack is 0 (false)
class BranchIfFalseBytecode extends BytecodeInstruction {
    String label;

    public BranchIfFalseBytecode(String label) {
        this.label = label;
    }

    @Override
    public void execute(ExecutionContext context) {
        int targetIp = context.findLabel(label);
        if (context.pop() == 0) {
            context.jumpTo(targetIp);
        }
    }

    @Override
    public String toString() {
        return "BRANCH_IF_FALSE " + label;
    }
}

// Example for BranchIfFalseBytecode
/*class BranchIfFalseBytecode extends BytecodeInstruction {
    String label;

    public BranchIfFalseBytecode(String label) {
        this.label = label;
    }

    @Override
    public void execute(ExecutionContext context) {
        int targetIp = context.findLabel(label);
        context.branchIfFalse(targetIp);
    }

    @Override
    public String toString() {
        return "BRANCH_IF_FALSE " + label;
    }
}*/

// LABEL instruction: no-op that marks a label in the bytecode
class LabelBytecode extends BytecodeInstruction {
    String label;

    public LabelBytecode(String label) {
        this.label = label;
    }

    @Override
    public void execute(ExecutionContext context) {
        // Labels do not perform any operation at runtime
    }

    @Override
    public String toString() {
        return label + ":";
    }
}

// RETURN instruction: indicates function return or end of program
class ReturnBytecode extends BytecodeInstruction {
    @Override
    public void execute(ExecutionContext context) {
        // Typically marks the end of execution for the VM
        // Implement return logic if VM supports multiple functions
    }

    @Override
    public String toString() {
        return "RETURN";
    }
}