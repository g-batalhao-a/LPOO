import java.lang.reflect.Array;
import java.util.ArrayList;

public abstract class LogicGate {
    private LogicVariable output;
    private LogicVariable input;
    public LogicGate(LogicVariable output, LogicVariable input){
        if(output.getLogicGate()!=null) throw new ColisionException();
        if(input.getLogicGate()!=null)
            if(input.getLogicGate().getInputs()[0].equals(output)) throw new CycleException();
        this.input=input;
        this.output=output;
        this.output.setLogicGate(this);
    }

    public LogicVariable getOutput() {
        return output;
    }

    public LogicVariable getInput() {
        return input;
    }

    public LogicVariable[] getInputs(){
        LogicVariable[] inputs=new LogicVariable[] {input};
        return inputs;
    }
    public String getSymbol(){
        return "";
    }
    public String getFormula(){
        return "";
    }
    public boolean getValue(){
        return false;
    }
}
