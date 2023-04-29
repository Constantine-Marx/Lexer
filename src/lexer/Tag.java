package lexer;

// Tag 类定义了许多整型常量，用于表示不同类型的词法单元或符号
public class Tag {
    // 下面是这些常量的定义
    public final static int
            AND = 256,
            BASIC = 257,
            BREAK = 258,
            DO = 259,
            ELSE = 260,
            EQ = 261,
            FALSE = 262,
            GE = 263,
            ID = 264,
            IF = 265,
            INDEX = 266,
            LE = 267,
            MINUS = 268,
            NE = 269,
            NUM = 270,
            OR = 271,
            REAL = 272,
            TEMP = 273,
            TRUE = 274,
            WHILE = 275,
            HEX = 276,
            CLASS = 277,
            FOR = 278,
            VOID = 279,
            RETURN = 280,
            INT = 281,
            DOUBLE = 282,
            BOOL = 283,
            STRING = 284,
            NULL = 285,
            THIS = 286,
            EXTENDS = 287,
            CONTINUE = 288,
            NEW = 289,
            PRINT = 290,
            NEWARRAY = 291,
            READINTEGER = 292,
            READLINE = 293,
            STATIC = 294;


}

// 这些整型常量代表了不同类型的词法单元或符号。例如，AND 常量表示逻辑运算符 &&，BREAK 常量表示流程控制语句 break，NUM 常量表示数字字面量，等等。

// 在编写编译器时，通常需要将输入源代码转换成一系列词法单元，然后再对这些单元进行进一步的语法分析。这些整型常量可以用于指定这些不同类型的单元，以便更轻松地对它们进行识别和处理。