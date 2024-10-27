import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

public class VirtualMachineTest {

    private VirtualMachine createAndExecuteVM(List<BytecodeInstruction> instructions) {
        VirtualMachine vm = new VirtualMachine(instructions);
        vm.execute();
        return vm;
    }

    @Test
    public void testBasicArithmetic() {
        List<BytecodeInstruction> instructions = List.of(
                new PushBytecode("2"),
                new PushBytecode("3"),
                new AddBytecode(),
                new PopBytecode("result")
        );

        VirtualMachine vm = createAndExecuteVM(instructions);
        assertEquals(5, vm.load("result"), "Expected result to be 5");
    }

    @Test
    public void testStackManipulation() {
        List<BytecodeInstruction> instructions = List.of(
                new PushBytecode("10"),
                new PushBytecode("20"),
                new PopBytecode("a"),
                new PopBytecode("b")
        );

        VirtualMachine vm = createAndExecuteVM(instructions);
        assertEquals(20, vm.load("a"), "Expected a to be 20");
        assertEquals(10, vm.load("b"), "Expected b to be 10");
    }

    @Test
    public void testConditionalExecution() {
        List<BytecodeInstruction> instructions = new ArrayList<>();
        instructions.add(new PushBytecode("5"));
        instructions.add(new PushBytecode("3"));
        instructions.add(new GtBytecode());
        instructions.add(new BranchIfFalseBytecode("false_0"));
        instructions.add(new PushBytecode("1"));
        instructions.add(new PopBytecode("result"));
        instructions.add(new LabelBytecode("false_0"));

        VirtualMachine vm = createAndExecuteVM(instructions);
        assertEquals(1, vm.load("result"), "Expected result to be 1");
    }

    @Test
    public void testLoopExecution() {
        List<BytecodeInstruction> instructions = new ArrayList<>();
        instructions.add(new PushBytecode("3"));
        instructions.add(new PopBytecode("n"));
        instructions.add(new PushBytecode("0"));
        instructions.add(new PopBytecode("sum"));
        instructions.add(new LabelBytecode("loopStart"));
        instructions.add(new PushBytecode("n"));
        instructions.add(new PushBytecode("0"));
        instructions.add(new GtBytecode());
        instructions.add(new BranchIfFalseBytecode("loopEnd"));
        instructions.add(new PushBytecode("sum"));
        instructions.add(new PushBytecode("n"));
        instructions.add(new AddBytecode());
        instructions.add(new PopBytecode("sum"));
        instructions.add(new PushBytecode("n"));
        instructions.add(new PushBytecode("1"));
        instructions.add(new SubBytecode());
        instructions.add(new PopBytecode("n"));
        instructions.add(new JumpBytecode("loopStart"));
        instructions.add(new LabelBytecode("loopEnd"));

        VirtualMachine vm = createAndExecuteVM(instructions);
        assertEquals(6, vm.load("sum"), "Expected sum to be 6");
    }

    @Test
    public void testFunctionReturn() {
        List<BytecodeInstruction> instructions = List.of(
                new PushBytecode("7"),
                new PushBytecode("8"),
                new AddBytecode(),
                new ReturnBytecode()
        );

        VirtualMachine vm = createAndExecuteVM(instructions);
        int result = vm.pop(); // Assuming pop() gives the return value
        assertEquals(15, result, "Expected top of stack to be 15 after return");
    }
}
