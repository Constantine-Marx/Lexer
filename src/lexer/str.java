package lexer;

public class str extends Token{
    public final String value;
    public str(String v){
        super(Tag.STRING);
        value = v;

    }
    public String toString(){
        return value;
    }
}