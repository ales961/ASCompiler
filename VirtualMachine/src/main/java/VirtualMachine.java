import java.util.*;

public class VirtualMachine {
    private Stack<Integer> stack = new Stack<>();           // Stack for holding values
    private Map<String, Integer> memory = new HashMap<>();   // Memory for variables
    private List<BytecodeInstruction> bytecode;             // The bytecode to execute
    private int ip = 0;                                      // Instruction pointer

    // Constructor to initialize the VM with bytecode
    public VirtualMachine(List<BytecodeInstruction> bytecode) {
        this.bytecode = bytecode;
    }

    // Method to execute the bytecode
    public void execute() {
        while (ip < bytecode.size()) {
            BytecodeInstruction instr = bytecode.get(ip);
            System.out.println("Executing: " + instr);
            instr.execute(this);
            ip++;
        }
    }

    // Stack operations
    public void push(int value) {
        stack.push(value);
    }

    public int pop() {
        return stack.pop();
    }

    // Memory operations
    public void store(String variable, int value) {
        memory.put(variable, value);
    }

    public int load(String variable) {
        if (!memory.containsKey(variable)) {
            throw new RuntimeException("Variable " + variable + " is not initialized.");
        }
        return memory.get(variable);
    }

    // Jump to a label (absolute jump)
    public void jumpTo(int targetIp) {
        ip = targetIp - 1;  // Set instruction pointer (minus 1 because it increments after each loop)
    }

    // Branch if false
    public void branchIfFalse(int targetIp) {
        int condition = pop();
        if (condition == 0) {
            ip = targetIp - 1;  // Jump to the specified label if the condition is false
        }
    }

    // Method to find the label and return its index in the bytecode list
    public int findLabel(String label) {
        for (int i = 0; i < bytecode.size(); i++) {
            if (bytecode.get(i) instanceof LabelBytecode) {
                LabelBytecode lbl = (LabelBytecode) bytecode.get(i);
                if (lbl.label.equals(label)) {
                    return i;
                }
            }
        }
        throw new RuntimeException("Label not found: " + label);
    }
}
