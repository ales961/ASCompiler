abstract class BytecodeInstruction {
    public abstract void execute(VirtualMachine vm);

    public abstract String toString();  // Convert to string for debugging
}

// PUSH instruction: pushes a value onto the stack
class PushBytecode extends BytecodeInstruction {
    String value;

    public PushBytecode(String value) {
        this.value = value;
    }

    @Override
    public void execute(VirtualMachine vm) {
        // If value is a variable, load it from memory
        if (value.matches("[a-zA-Z_][a-zA-Z_0-9]*")) {
            vm.push(vm.load(value));
        } else {
            vm.push(Integer.parseInt(value));  // Otherwise, treat it as a literal
        }
    }

    @Override
    public String toString() {
        return "PUSH " + value;
    }
}

// POP instruction: pops the top of the stack into a variable
class PopBytecode extends BytecodeInstruction {
    String variable;

    public PopBytecode(String variable) {
        this.variable = variable;
    }

    @Override
    public void execute(VirtualMachine vm) {
        int value = vm.pop();
        vm.store(variable, value);
    }

    @Override
    public String toString() {
        return "POP " + variable;
    }
}

// ADD instruction: pops two values, adds them, and pushes the result
class AddBytecode extends BytecodeInstruction {
    @Override
    public void execute(VirtualMachine vm) {
        int b = vm.pop();
        int a = vm.pop();
        vm.push(a + b);
    }

    @Override
    public String toString() {
        return "ADD";
    }
}

// SUB instruction: pops two values, subtracts them, and pushes the result
class SubBytecode extends BytecodeInstruction {
    @Override
    public void execute(VirtualMachine vm) {
        int b = vm.pop();
        int a = vm.pop();
        vm.push(a - b);
    }

    @Override
    public String toString() {
        return "SUB";
    }
}

class MulBytecode extends BytecodeInstruction {
    @Override
    public void execute(VirtualMachine vm) {
        int b = vm.pop();
        int a = vm.pop();
        vm.push(a * b);
    }

    @Override
    public String toString() {
        return "MUL";
    }
}

class DivBytecode extends BytecodeInstruction {
    @Override
    public void execute(VirtualMachine vm) {
        int b = vm.pop();
        int a = vm.pop();
        vm.push(a / b); // Ensure handling of division by zero in the VM, if needed
    }

    @Override
    public String toString() {
        return "DIV";
    }
}

class NeqBytecode extends BytecodeInstruction {
    @Override
    public void execute(VirtualMachine vm) {
        int b = vm.pop();
        int a = vm.pop();
        vm.push(a != b ? 1 : 0);  // Push 1 for true, 0 for false
    }

    @Override
    public String toString() {
        return "NEQ";
    }
}

class EqBytecode extends BytecodeInstruction {
    @Override
    public void execute(VirtualMachine vm) {
        int b = vm.pop();
        int a = vm.pop();
        vm.push(a == b ? 1 : 0);  // Push 1 for true, 0 for false
    }

    @Override
    public String toString() {
        return "EQ";
    }
}

class GtBytecode extends BytecodeInstruction {
    @Override
    public void execute(VirtualMachine vm) {
        int b = vm.pop();
        int a = vm.pop();
        vm.push(a > b ? 1 : 0);  // Push 1 for true, 0 for false
    }

    @Override
    public String toString() {
        return "GT";
    }
}

class LtBytecode extends BytecodeInstruction {
    @Override
    public void execute(VirtualMachine vm) {
        int b = vm.pop();
        int a = vm.pop();
        vm.push(a < b ? 1 : 0);  // Push 1 for true, 0 for false
    }

    @Override
    public String toString() {
        return "LT";
    }
}

class GteBytecode extends BytecodeInstruction {
    @Override
    public void execute(VirtualMachine vm) {
        int b = vm.pop();
        int a = vm.pop();
        vm.push(a >= b ? 1 : 0);  // Push 1 for true, 0 for false
    }

    @Override
    public String toString() {
        return "GTE";
    }
}

class LteBytecode extends BytecodeInstruction {
    @Override
    public void execute(VirtualMachine vm) {
        int b = vm.pop();
        int a = vm.pop();
        vm.push(a <= b ? 1 : 0);  // Push 1 for true, 0 for false
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
    public void execute(VirtualMachine vm) {
        int targetIp = vm.findLabel(label);  // Use findLabel in VirtualMachine
        vm.jumpTo(targetIp);
    }

    @Override
    public String toString() {
        return "JUMP " + label;
    }
}

// BRANCH_IF_FALSE instruction: branch if the top of the stack is false (0)
class BranchIfFalseBytecode extends BytecodeInstruction {
    String label;

    public BranchIfFalseBytecode(String label) {
        this.label = label;
    }

    @Override
    public void execute(VirtualMachine vm) {
        int targetIp = vm.findLabel(label);  // Use findLabel in VirtualMachine
        vm.branchIfFalse(targetIp);
    }

    @Override
    public String toString() {
        return "BRANCH_IF_FALSE " + label;
    }
}

// LABEL instruction: marks a label in the bytecode (no-op in execution)
class LabelBytecode extends BytecodeInstruction {
    String label;

    public LabelBytecode(String label) {
        this.label = label;
    }

    @Override
    public void execute(VirtualMachine vm) {
        // Labels are no-ops, they are just markers
    }

    @Override
    public String toString() {
        return label + ":";
    }
}

// RETURN instruction: stops the execution of the program
class ReturnBytecode extends BytecodeInstruction {
    @Override
    public void execute(VirtualMachine vm) {
        // No specific action for now (as we only have one function)
    }

    @Override
    public String toString() {
        return "RETURN";
    }
}
