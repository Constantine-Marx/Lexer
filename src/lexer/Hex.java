package lexer;

public class Hex extends Token{
    public final String value;
    public Hex(String v){
        super(Tag.HEX);
        value = v;

    }
    public String toString(){
        return value;
    }
}
