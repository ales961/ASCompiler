import java.util.HashMap;
import java.util.Map;

class SymbolTable {
    private Map<String, String> symbols = new HashMap<>();

    // Add a new symbol with a type (e.g., variable name and type)
    public void add(String name, String type) {
        symbols.put(name, type);
    }

    // Check if a symbol exists in the table
    public boolean contains(String name) {
        return symbols.containsKey(name);
    }

    // Retrieve the type of a symbol
    public String getType(String name) {
        return symbols.get(name);
    }

    // Print the current symbol table
    public void print() {
        System.out.println("Symbol Table:");
        for (Map.Entry<String, String> entry : symbols.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}