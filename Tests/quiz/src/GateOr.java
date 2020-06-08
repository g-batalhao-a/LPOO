import java.util.ArrayList;

public class GateOr extends LogicGate{
    private LogicVariable input2;
    public GateOr(LogicVariable output, LogicVariable input, LogicVariable input2) {
        super(output, input);
        if(input2.getLogicGate()!=null)
            if(input2.getLogicGate().getInputs().equals(output)) throw new CycleException();
        this.input2=input2;
        this.getOutput().setFormula("OR("+input.getFormula()+","+input2.getFormula()+")");
    }
    @Override
    public LogicVariable[] getInputs(){
        LogicVariable[] inputs=new LogicVariable[] {super.getInput(),input2};
        return inputs;
    }
    @Override
    public String getSymbol(){
        return "OR";
    }
    @Override
    public String getFormula(){
        return this.getOutput().getFormula();
    }
    @Override
    public boolean getValue(){
        return super.getInput().getValue()||input2.getValue();
    }
}
