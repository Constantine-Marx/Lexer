package lexer;

// Real 是 Token 的子类，表示源代码中的实数
public class Real extends Token {
    // value 字段表示实数的值，使用 final 关键字修饰
    public final float value;

    // 构造方法将实数的值作为参数传入，并调用父类构造方法
    // 调用父类构造方法时，传入 Tag.REAL 表示此 token 是一个实数类型
    public Real(float v) {
        super(Tag.REAL);
        value = v;
    }

    // 该方法返回实数的字符串表示形式
    public String toString() {
        return "" + value;
    }
}

// Real 类表示源代码中的实数（浮点数）。与之前介绍的 Num 类似，这个类拥有一个名为 value 的不可修改的字段，用于存储实数的值。其他值得注意的点包括：

// Real 类构造函数接收一个参数，即实数的值。
// 构造函数在调用其父类构造函数时，将 Tag.REAL 标记作为参数传递，以表示这是一个实数类型的词法单元。
// toString() 方法返回实数的字符串表示形式。
// 总之，Real 类表示源代码中的实数，用于将实数值从源代码中正确地解析和识别出来。