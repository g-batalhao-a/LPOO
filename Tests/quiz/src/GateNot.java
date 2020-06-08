public class GateNot extends LogicGate {
    public GateNot(LogicVariable output, LogicVariable input) {
        super(output, input);
        this.getOutput().setFormula("NOT("+input.getFormula()+")");
    }
    @Override
    public String getSymbol(){
        return "NOT";
    }
    @Override
    public String getFormula(){
        return this.getOutput().getFormula();
    }
    @Override
    public boolean getValue(){
        return !super.getInput().getValue();
    }}
