# 데이터를 가공하는 연산자
https://docs.microsoft.com/en-us/dotnet/csharp/language-reference/operators/



## 연산자의 우선 순위 



### Operator precedence
|Operators|Category or name|
|---|---|
|x.y, x?.y, x?[y], f(x), a[i], x++, x--, new, typeof, checked, unchecked, default, nameof, delegate, sizeof, stackalloc, x->y|Primary|
+x, -x, !x, ~x, ++x, --x, ^x, (T)x, await, &x, *x, true and false|Unary|
|x..y|Range|
|x * y, x / y, x % y|Multiplicative|
|x + y, x – y|Additive|
|x << y, x >> y|Shift|
|x < y, x > y, x <= y, x >= y, is, as|Relational and type-testing|
|x == y, x != y|Equality|
|x & y|Boolean logical AND or bitwise logical AND|
|x ^ y|Boolean logical XOR or bitwise logical XOR|
|x \| y|Boolean logical OR or bitwise logical OR|
|x && y|Conditional AND|
|x \|\| y|Conditional OR|
|x ?? y|Null-coalescing operator|
|c ? t : f|Conditional operator|
|x = y, x += y, x -= y, x *= y, x /= y, x %= y, x &= y, x \|= y, x ^= y, x <<= y, x >>= y, x ??= y, =>|Assignment and lambda declaration|

### Operator associativity
* Left-associative 
* Right-associative: The assignment operators, the null-coalescing operators, and the conditional operator ?:

### Operand evaluation
Unrelated to operator precedence and associativity, operands in an expression are evaluated from left to right. 

|Expression|Order of evaluation|
|---|---|
|a + b|a, b, +|
|a + b * c|a, b, c, *, +|
|a / b + c * d|a, b, /, c, d, *, +|
|a / (b + c) * d|a, b, c, +, /, d, *|

Some operators evaluate operands conditionally. That is, the value of the leftmost operand of such an operator defines if (or which) other operands should be evaluated


## 산술 연산자 Arithmetic Operators


### Increment operator ++
* Postfix increment operator: i++
* Prefix increment operator: ++i

### Decrement operator --
* Postfix decrement operator: i--
* Prefix decrement operator: --i

### Unary plus and minus operators: +i, -i

### Multiplication operator *
* The unary * operator is the pointer indirection operator.

### Division operator /
* Integer division: rounded towards zero
* Floating-point division
  * If one of the operands is decimal, another operand can be neither float nor double

### Remainder operator %
* Integer remainder
  * a % b = a - (a / b) * b
  * The sign of the non-zero remainder is the same as that of the left-hand operand.
* Floating-point remainder

    For the float and double operands, the result of x % y for the finite x and y is the value z such that
  * The sign of z, if non-zero, is the same as the sign of x.
  * The absolute value of z is the value produced by |x| - n * |y| where n is the largest possible integer that is less than or equal to |x| / |y| and |x| and |y| are the absolute values of x and y, respectively.

### Addition operator +

### Subtraction operator -

### Compound assignment
* x op= y is equivalent to x = x op y
  * +=
  * -=
  * *=
  * /=
  * %=

### Operator precedence and associativity
The following list orders arithmetic operators starting from the highest precedence to the lowest:
* Postfix increment x++ and decrement x-- operators
* Prefix increment ++x and decrement --x and unary + and - operators
* Multiplicative *, /, and % operators
* Additive + and - operators

Binary arithmetic operators are left-associative.

Use parentheses, (), to change the order of evaluation.

### Arithmetic overflow and division by zero
* Integer arithmetic overflow
  * Integer division by zero always throws a DivideByZeroException.
  * In a checked context
    * If overflow happens in a constant expression, a compile-time error occurs.
    * Otherwise, when the operation is performed at run time, an OverflowException is thrown.
  * In an unchecked context, the result is truncated by discarding any high-order bits that don't fit in the destination type.
  * Along with the checked and unchecked statements, you can use the checked and unchecked operators to control the overflow checking context, in which an expression is evaluated
* Floating-point arithmetic overflow

### Round-off errors
Because of general limitations of the floating-point representation of real numbers and floating-point arithmetic, round-off errors might occur in calculations with floating-point types.

That is, the produced result of an expression might differ from the expected mathematical result.


## 논리 연산자 Boolean Logical Operators


### Logical negation operator !

### Logical AND operator &

### Logical exclusive OR operator ^

### Logical OR operator |

### Conditional logical AND operator &&

### Conditional logical OR operator ||

### Nullable Boolean logical operators
|x|y|x&y|x\|y|
|---|---|---|
|true|true|true|true|
|true|false|false|true|
|true|null|null|true|
|false|true|false|true|
|false|false|false|false|
|false|null|false|null|
|null|true|null|true|
|null|false|false|null|
|null|null|null|null|

### Compound assignment
* x op= y is equivalent to x = x op y
  * &=
  * |=
  * ^=
* The conditional logical operators && and || don't support compound assignment.

### Operator precedence
The following list orders logical operators starting from the highest precedence to the lowest:
* Logical negation operator !
* Logical AND operator &
* Logical exclusive OR operator ^
* Logical OR operator |
* Conditional logical AND operator &&
* Conditional logical OR operator ||

Use parentheses, (), to change the order of evaluation.


## 비트 연산자 Bitwise and Shift Operators

### Bitwise complement operator ~
* Before: 00001111000011110000111100001100
* After~: 11110000111100001111000011110011
* You can also use the ~ symbol to declare finalizers.

### Left-shift operator <<
* Before: 11001001000000000000000000010001
* << 4:   10010000000000000000000100010000
* Because the shift operators are defined only for the int, uint, long, and ulong types, the result of an operation always contains at least 32 bits.
* If the left-hand operand is of another integral type (sbyte, byte, short, ushort, or char), its value is converted to the int type.

### Right-shift operator >>
* Before: 1001
* After >> 2: 10
* int or long: Arithmetic Shift
* Non-negtive => Zero, Negative => One
  * Before: 10000000000000000000000000000000
  * After >> 3:  11110000000000000000000000000000
* uint or ulong: Logic Shift
  * Before: 10000000000000000000000000000000
  * After >> 3:  10000000000000000000000000000

### Logical AND operator &

### Logical exclusive OR operator ^

### Logical OR operator |

### Compound assignment
* x op= y is equivalent to x = x op y
  * &=
  * |=
  * ^=
  * <<=
  * \>>=

### Operator precedence
The following list orders bitwise and shift operators starting from the highest precedence to the lowest:
* Bitwise complement operator ~
* Shift operators << and >>
* Logical AND operator &
* Logical exclusive OR operator ^
* Logical OR operator |

Use parentheses, (), to change the order of evaluation

### Shift count of the shift operators
For the shift operators << and >>, the type of the right-hand operand must be int

For the x << count and x >> count expressions, the actual shift count depends on the type of x as follows:
* If the type of x is int or uint, the shift count is defined by the low-order five bits of the right-hand operand, count & 0x1F (or count & 0b_1_1111).
* If the type of x is long or ulong, the shift count is defined by the low-order six bits of the right-hand operand. That is, the shift count is computed from count & 0x3F (or count & 0b_11_1111).
  * 0000 0001 << 1110 0001 => 0000 0010
  * 0000 0100 >> 1110 0001 => 0000 0010 


## Equality operators


### Equality operator ==

### Inequality operator !=


## Comparison operators 

### Less than operator <

### Greater than operator >

### Less than or equal operator <=

### Greater than or equal operator >=


## Member access operators

### Member access operator .

### Indexer operator []

### Null-conditional operators ?. and ?[]

### Invocation operator ()

### Index from end operator ^
The ^ operator indicates the element position from the end of a sequence
```
int[] xs = new[] { 0, 10, 20, 30, 40 };
int last = xs[^1];
Console.WriteLine(last);  // output: 40

var lines = new List<string> { "one", "two", "three", "four" };
string prelast = lines[^2];
Console.WriteLine(prelast);  // output: three

string word = "Twenty";
Index toFirst = ^word.Length;
char first = word[toFirst];
Console.WriteLine(first);  // output: T
```

### Range operator ..
The .. operator specifies the start and end of a range of indices as its operands.
```
int[] numbers = new[] { 0, 10, 20, 30, 40, 50 };
int start = 1;
int amountToTake = 3;
int[] subset = numbers[start..(start + amountToTake)];
Display(subset);  // output: 10 20 30

int margin = 1;
int[] inner = numbers[margin..^margin];
Display(inner);  // output: 10 20 30 40

string line = "one two three";
int amountToTakeFromEnd = 5;
Range endIndices = ^amountToTakeFromEnd..^0;
string end = line[endIndices];
Console.WriteLine(end);  // output: three

void Display<T>(IEnumerable<T> xs) => Console.WriteLine(string.Join(" ", xs));
```

* a.. is equivalent to a..^0
* ..b is equivalent to 0..b
* .. is equivalent to 0..^0


## Type-testing and cast operators

### is operator: to check if the runtime type of an expression is compatible with a given type

### as operator: to explicitly convert an expression to a given type if its runtime type is compatible with that type

### Cast operator (): to perform an explicit conversion

### typeof operator: to obtain the System.Type instance for a type
