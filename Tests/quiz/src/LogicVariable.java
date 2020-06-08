import java.util.Objects;

public class LogicVariable {
    private String name;
    private Boolean value;
    private LogicGate logicGate;
    private String formula;
    public LogicVariable(String name, boolean value){
        this.name=name;
        this.value=value;
        this.formula=name;
    }
    public LogicVariable(String name){
        this.name=name;
    }

    public LogicGate getLogicGate() {
        return logicGate;
    }

    public String getName() {
        return name;
    }

    public boolean getValue() {
        if(this.logicGate==null) return value;
        return this.logicGate.getValue();
    }

    public void setLogicGate(LogicGate logicGate) {
        this.logicGate = logicGate;
    }

    public void setValue(boolean value) {
        this.value = value;
    }

    public LogicGate getCalculatedBy(){
        if(this.logicGate==null) return null;
        else return logicGate;
    }

    public String getFormula(){
        return formula;
    }

    public void setFormula(String formula){
        this.formula=formula;
    }

    public void setValue(Boolean value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LogicVariable that = (LogicVariable) o;
        return value == that.value &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, value);
    }
}