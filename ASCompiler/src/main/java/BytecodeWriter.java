import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class BytecodeWriter {
    public void writeToFile(List<BytecodeInstruction> bytecode, String filePath) throws IOException {
        try (FileWriter writer = new FileWriter(filePath)) {
            for (BytecodeInstruction instruction : bytecode) {
                writer.write(instruction.toString() + "\n");
            }
        }
    }
}
