import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        /*if (args.length != 1) {
            System.out.println("Usage: java VirtualMachineMain <bytecode_file>");
            return;
        }*/

        String bytecodeFilePath = "C:\\Users\\User\\IdeaProjects\\ASCompiler\\example_output.bytecode"; //args[0];

        try {
            // Step 1: Load bytecode from file
            BytecodeLoader loader = new BytecodeLoader();
            List<BytecodeInstruction> bytecodeInstructions = loader.loadFromFile(bytecodeFilePath);

            // Step 2: Initialize and execute the virtual machine
            VirtualMachine vm = new VirtualMachine(bytecodeInstructions);
            vm.execute();

            System.out.println("Final value of 'a': " + vm.load("a"));
        } catch (IOException e) {
            System.err.println("Error loading bytecode file: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("Error during execution: " + e.getMessage());
            e.printStackTrace();
        }
    }
}