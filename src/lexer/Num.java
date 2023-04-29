package lexer;

// Token 是一个抽象类，表示源代码中的所有词法单元（token）
public class Num extends Token {

    // value 字段表示数字字面量的实际值，使用 final 关键字修饰
    public int value;

    // 构造方法将数字字面量的值作为参数传入，并调用父类构造方法
    // 调用父类构造方法时，传入 Tag.NUM 表示此 token 是一个数字类型
    public Num(int v) {
        super(Tag.NUM);
        value = v;
    }

    // 该方法返回数字字面量的字符串表示形式
    public String toString() {
        return "" + value;
    }

}

// 这个代码定义了一个名为 Num 的类，它用于在源代码中表示数字。具体来说，它是 Token 类的子类，而 Token 是一个抽象类，代表了源代码中的所有词法单元。下面详细解释每行代码的含义：

// 第 1 行：package lexer; 表示这个类位于 lexer 包中。
// 第 4 行：public class Num extends Token { 声明了一个名为 Num 的公共类，它扩展了 Token 类，即 Num 是 Token 的子类。
// 第 7 行：public final int value; 定义了一个公共、不可修改的整型字段 value，用于存储数字字面量的值。
// 第 10～16 行：定义了一个构造函数 Num(int v)。它使用传入的整数值 v 来初始化 value 字段，并调用父类的构造函数 Token(Tag.NUM)，其中 Tag.NUM 表示这个 token 是一个数字类型。
// 第 19～23 行：toString() 方法返回数字字面量的字符串表示形式。在这个实现中，它将 value 值转换成字符串并返回。
// 总之，Num 类是一个简单的表示数字字面量的类，它继承了 Token 并添加了一个 value 字段，以便可以从源代码中正确地解析和识别数字。

