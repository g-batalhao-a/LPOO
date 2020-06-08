import java.util.HashSet;
import java.util.Set;

public class CombinatorialCircuit {
    private Set<LogicVariable> logicVariables;
    public CombinatorialCircuit(){
        this.logicVariables=new HashSet<>();
    }
    public boolean addVariable(LogicVariable logicVariable){
        return logicVariables.add(logicVariable);
    }
    public LogicVariable getVariableByName(String name){
        for(LogicVariable v: logicVariables){
            if(v.getName()==name) return v;
        }
        return null;
    }
}
