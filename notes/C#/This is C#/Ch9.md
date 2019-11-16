# Properties

* OOP 은닉성: 객체 데이터가 의도하지 않게 오염되는 것을 막을 수 있는 수단
* protected나 private보다 우아한 방법: 프로퍼티
<br><br>
#### public필드의 유혹
#### 메소드보타 프로퍼티
#### 자동 구현 프로퍼티
#### 프로퍼티와 생성자
#### 무명 형식
#### 인터페이스의 프로퍼티
#### 추상 클래스와 프로퍼티
<br><br>
## public필드의 유혹

* public필드: 데이터 오염 가능성
* get/set 메소드: 번거로움
<br><br><br>
## 메소드보타 프로퍼티
```C#
class MyClass{
    private int myField;
    public int MyField{
        get{ return myField; }
        set{ myField = value; }
    }
}
```
```C#
MyClass obj = new MyClass();
obj.MyField = 3;
Console.WriteLine(obj.MyField);
```

* 읽기전용: get만 구현
<br><br><br>
## 자동 구현 프로퍼티
<br>

#### 단순한 읽고 쓰기
```C#
public class NameCard{
    private string name;
    private string phoneNumber

    public string Name{
        get{ return name; }
        set{ name = value; }
    }
}
```
```C#
public class NameCard{
    public string Name{
        get; set;
    }

    private string phoneNumber{
        get; set;
    }
}
```
<br>

#### 선언과 동시 초기화 (7.0)
```C#
public class NameCard{
    public string Name{ get; set; } = "Unknown";
    private string phoneNumber{ get; set; } = "000-0000";
}
```
<br>

#### 직접 선언한 프로퍼티 vs 자동 구현 프로퍼티
![alt text](images\2019-11-16Image01.png "직접 선언한 프로퍼티 vs 자동 구현 프로퍼티")
컴파일러의 선언 형식: <필드명>k_BackingField_
<br><br><br>
## 프로퍼티와 생성자
<br>

* 객체 생성 시 프로퍼티를 이용한 필드 초기화
* 필요한 프로퍼티만 초기화 가능
```C#
BirthdayInfo birth = new BirthdayInfo(){
    name = "서현", Birthday = new DateTime(1991, 6, 28)
};
```
<br><br><br>
## 무명 형식
* 형식의 선언과 동시에 인스턴스 할당
* 인스턴스를 만들고 다시는 사용하지 않을 때
```C#
var myInstance = new { Name = "박상현", Age = "17" };
```
```C#
Console.WriteLine(myInstance.Name, myInstance.Age);
```
* 프로퍼티에 할당된 값은 변경 불가
<br><br><br>
## 인터페이스의 프로퍼티
* 인터페이스의 프로퍼티 선언과 클래스의 자동 구현 프로퍼티 선언 동일
  * 상속하는 클래스에서 프로퍼티 구현
```C#
interface IProduct{
   string ProductName{ get; set; }
}

class Product : IProduct{
    private string productName;

    public string ProductName{
        get{ return productName; }
        set{ productName = value; }
    }
}
```
<br><br><br>
## 추상 클래스와 프로퍼티
* 구현된 프로퍼티와 구현되지 않은 프로퍼티
* 구현되지 않은 프로퍼티
  * abstract 한정자 사용 ==> 구현 필수
```C#
abstract class Product{
    private static int serial = 0;

    public string SerialID{
        get{ return String.Format("{0:d5}". serial++)}
    }
    
    abstract public DateTime ProductDate{
        get; set;
    }

}

class MyProduct : Product{
    public override DateTime ProductDate{
        get; set;
    }
}
```
<br><br><br><br>
# Properties (C# Programming Guide)
https://docs.microsoft.com/en-us/dotnet/csharp/programming-guide/classes-and-structs/properties
<br><br>
A property is a member that provides a flexible mechanism to read, write, or compute the value of a private field. Properties can be used as if they are public data members, but they are actually special methods called accessors. This enables data to be accessed easily and still helps promote the safety and flexibility of methods.
<br><br>
## Properties overview
* A public way of getting and setting values, while hiding implementation or verification code
* get: return the property value
* set: assign a new value
* value: the value being assigned by set
* read-write (both get and set), read-only (get only), or write-only (set only)
```C#
using System;

class TimePeriod
{
   private double _seconds;

   public double Hours
   {
       get { return _seconds / 3600; }
       set { 
          if (value < 0 || value > 24)
             throw new ArgumentOutOfRangeException(
                   $"{nameof(value)} must be between 0 and 24.");

          _seconds = value * 3600; 
       }
   }
}

class Program
{
   static void Main()
   {
       TimePeriod t = new TimePeriod();
       // The property assignment causes the 'set' accessor to be called.
       t.Hours = 24;

       // Retrieving the property causes the 'get' accessor to be called.
       Console.WriteLine($"Time in hours: {t.Hours}");
   }
}
// The example displays the following output:
//    Time in hours: 24
```
<br><br>
## Expression body definitions
Expression body definitions consist of the => symbol followed by the expression to assign to or retrieve from the property.
```C#
using System;

public class Person
{
   private string _firstName;
   private string _lastName;
   
   public Person(string first, string last)
   {
      _firstName = first;
      _lastName = last;
   }

   public string Name => $"{_firstName} {_lastName}";   
}

public class Example
{
   public static void Main()
   {
      var person = new Person("Magnus", "Hedlund");
      Console.WriteLine(person.Name);
   }
}
// The example displays the following output:
//      Magnus Hedlund
```
<br><br>

```C#
using System;

public class SaleItem
{
   string _name;
   decimal _cost;
   
   public SaleItem(string name, decimal cost)
   {
      _name = name;
      _cost = cost;
   }

   public string Name 
   {
      get => _name;
      set => _name = value;
   }

   public decimal Price
   {
      get => _cost;
      set => _cost = value; 
   }
}

class Program
{
   static void Main(string[] args)
   {
      var item = new SaleItem("Shoes", 19.95m);
      Console.WriteLine($"{item.Name}: sells for {item.Price:C2}");
   }
}
// The example displays output like the following:
//       Shoes: sells for $19.95
```
<br><br>
## Auto-implemented properties
```C#
using System;

public class SaleItem
{
   public string Name 
   { get; set; }

   public decimal Price
   { get; set; }
}

class Program
{
   static void Main(string[] args)
   {
      var item = new SaleItem{ Name = "Shoes", Price = 19.95m };
      Console.WriteLine($"{item.Name}: sells for {item.Price:C2}");
   }
}
// The example displays output like the following:
//       Shoes: sells for $19.95
```

