package jadelex;

/**
 *  YYtoken implementation for REPEAT token type
 */

public class Repeat extends BaseToken{
    private int occurences;

    public int getOccurences(){
        return occurences;
    }
    public Repeat(int occurences){
        super(TokenType.REPEAT);
        this.occurences = occurences;
    }
    public String toString(){
        return super.toString()+"["+occurences+"]";
    }
}