package jadelex;

/**
 *  YYtoken implementation for PEN_MODE token type
 */

public class Move extends BaseToken{
    private Direction direction;

    public Direction getDirection(){
        return direction;
    }
    public Move(Direction direction){
        super(TokenType.MOVE);
        this.direction = direction;
    }
    public String toString(){
        return super.toString()+"["+direction+"]";
    }
}