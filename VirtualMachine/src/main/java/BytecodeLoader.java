import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BytecodeLoader {
    private final Map<String, Integer> labelPositions = new HashMap<>();

    public List<BytecodeInstruction> loadFromFile(String filePath) throws IOException {
        List<BytecodeInstruction> bytecode = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            int instructionIndex = 0;

            // First pass to detect and store label positions
            while ((line = reader.readLine()) != null) {
                if (line.endsWith(":")) {
                    // This is a label line, so add it as a LabelBytecode and store its position
                    String label = line.substring(0, line.length() - 1);
                    labelPositions.put(label, instructionIndex);
                    bytecode.add(new LabelBytecode(label));  // Add the label as an instruction
                    instructionIndex++;
                } else {
                    // This is a regular bytecode instruction
                    bytecode.add(parseInstruction(line));
                    instructionIndex++;
                }
            }
        }
        return bytecode;
    }

    private BytecodeInstruction parseInstruction(String line) {
        String[] parts = line.split(" ");
        switch (parts[0]) {
            case "PUSH":
                return new PushBytecode(parts[1]);
            case "POP":
                return new PopBytecode(parts[1]);
            case "ADD":
                return new AddBytecode();
            case "SUB":
                return new SubBytecode();
            case "MUL":
                return new MulBytecode();
            case "DIV":
                return new DivBytecode();
            case "NEQ":
                return new NeqBytecode();
            case "EQ":
                return new EqBytecode();
            case "GT":
                return new GtBytecode();
            case "LT":
                return new LtBytecode();
            case "GTE":
                return new GteBytecode();
            case "LTE":
                return new LteBytecode();
            case "JUMP":
                return new JumpBytecode(parts[1]);
            case "BRANCH_IF_FALSE":
                return new BranchIfFalseBytecode(parts[1]);
            case "RETURN":
                return new ReturnBytecode();
            default:
                throw new UnsupportedOperationException("Unknown instruction: " + parts[0]);
        }
    }

    // Expose label positions so the VM can resolve jumps
    public Map<String, Integer> getLabelPositions() {
        return labelPositions;
    }
}
