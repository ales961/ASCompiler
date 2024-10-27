public interface ExecutionContext {
    void push(int value);
    int pop();
    int load(String variable);
    void store(String variable, int value);
    void jumpTo(int targetIp);
    void branchIfFalse(int targetIp);
    int findLabel(String label);
}
