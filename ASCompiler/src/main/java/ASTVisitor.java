public interface ASTVisitor {
    void visit(ProgramNode node);
    void visit(VariableDeclNode node);
    void visit(MultiVariableDeclNode node);
    void visit(AssignmentNode node);
    void visit(IfNode node);
    void visit(WhileNode node);
    void visit(BinaryOperationNode node);
    void visit(LiteralNode node);
    void visit(BlockNode node);
    void visit(VariableNode node);
    void visit(FunctionNode node);  // Added FunctionNode
    void visit(ReturnNode node);    // Added ReturnNode
}
