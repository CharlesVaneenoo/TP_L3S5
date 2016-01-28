package jadelex;

/**
 *  YYtoken implementation for STEP_LENGTH token type
 */

public class StepLength extends BaseToken{
    private int length;

    public int getLength(){
        return length;
    }
    public StepLength(int l){
        super(TokenType.STEP_LENGTH);
        this.length = l;
    }
    public String toString(){
        return super.toString()+"["+length+"]";
    }
}