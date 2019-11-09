## 6. Method로 코드 간추리기
> 6.1- Method란? 일련의 코드를 하나로 묶음. method, function(c, c++), procedure(pascal), subroutine
(visual basic)
>``` csharp
>namespace Method 
>{
> class Calculator
> {
>   public static int Plus(int a, int b)
>   {
>       return a + b;
>   } 
>
>   public static int Minus(int a, int b)
>   {
>       return a - b;
>   } 
> }
>
> class MainApp
> {
>   public static void Main()
>   {
>       int result = Calculator.Plus(3, 4);
>       Console.WriteLin(result);
>       
>       result = Calculator.Minus(5, 2);
>       Console.WriteLin(result);
>   } 
> }
>}
>```

> 6.2- Return에 대하여: 점프문의 한 종류, 어느 위치나 호출 가능
>``` csharp
> int Fibonacci
> {
>   if (n<2) 
>       return n;
>   else 
>       return Fibonacci(n-1) + Fibonacci(n-2);
> }
>```
>``` csharp
> void PrintProfile(string name, string phone)
> {
>   if (name == "") 
>   {
>       Console.WriteLine("이름을 입력해주세요");
>       return;
>       //여기서 return은 문장의 흐름만 바꿈
>   }
>   Console.WriteLine("Name:{0}, Phone:{1}", name, phone);
> }
>```

> 6.3- 매개 변수에 대하여, 참조에 의한 매개 변수 전달
>``` csharp
>namespace SwapByValue 
>{
> class MainApp
> {
>   static void Swap(int a, int b)
>   {
>       int temp = b;
>       b = a;
>       a = tem[;]
>   } 
>
>   static void Main(string[] args)
>   {
>       int x = 3;
>       int y = 4;
>       Console.WriteLine("x:{0}, y:{1}", x, y);
>       
>       Swap(x, y);
>       Console.WriteLine("x:{0}, y:{1}", x, y);
>   } 
> }
>}
>```
>``` csharp
>namespace SwapByRef 
>{
> class MainApp
> {
>   static void Swap(ref int a, ref int b)
>   {
>       int temp = b;
>       b = a;
>       a = tem;
>   } 
>
>   static void Main(string[] args)
>   {
>       int x = 3;
>       int y = 4;
>       Console.WriteLine("x:{0}, y:{1}", x, y);
>       
>       Swap(ref x, ref y);
>       Console.WriteLine("x:{0}, y:{1}", x, y);
>   } 
> }
>}
>```
> 6.5- 메소드의 결과를 참조로 반환하기 (이때에도 ref를 사용)
>``` csharp
> class SomeClass
> {
>   int SomeValue = 10;
>   public ref int SomeMethod()
>   {
>   return ref SomeValue;
>   } 
> }
>```
> 두가지 방식의 반환 방법**
>``` csharp
> SomeClass obj = new SomeClass();
> int result = obj.SomeMethod();   
>```
>``` csharp
> SomeClass obj = new SomeClass();
> ref int result = ref obj.SomeMethod(); //result는 참조 지역 변수  
>```
>``` csharp
>namespace RefReturn 
>{
> class Product
> {
>   private int price = 100;
>   
>   public ref int GetPrice();
>   {
>       return ref price;
>   } 
>
>   public void PrintPrice()
>   {
>       Console.WriteLine($"Price:{price}");
>   } 
> }
> class MainApp 
> {
>   static void Main(string[] args)
>   {
>       Product carrot = new Product();
>       ref int ref_local_price = ref carrot.GetPrice();
>       int normal_local_price = carrot.GetPrice();
>       
>       carrot.PrintPrice();
>       Console.WriteLine($"Ref Local Price:{ref_local_price}");
>       Console.WriteLine($"Normal Local Price:{Normal_local_price}");
>       //100, 100, 100
>           
>       ref_local_price = 200;
>       carrot.PrintPrice();
>       Console.WriteLine($"Ref Local Price:{ref_local_price}");
>       Console.WriteLine($"Normal Local Price:{Normal_local_price}");
>       //200, 200, 100
>   } 
> }
>}
>```
> 6.6- 출력 전용 매개 변수
> -ref를 이용하는 방법(안전하지 않아서 권장하진 않음)
>``` csharp
> void Divide(int a, int b, ref int quotient, ref int remainder)
> {
>   quotient = a / b; 
>   remainder = a % b;
> }
>```
> -out 키워드를 이용한 방법(컴파일러를 통해 결과를 할당하지 않은 버그를 만들 가능성 제거)
>``` csharp
> void Divide(int a, int b, out int quotient, out int remainder)
> {
>   quotient = a / b; 
>   remainder = a % b;
> }
>```
> 6.7- 메소드 오버로딩
>``` csharp
> int Plus(int a, int b)
> {
>   return a + b;
> }
>
> double Plus(double a, double b)
> {
>   return a + b;
> }
>
>```
> 6.8- 가변길이 매개 변수
>``` csharp
> int Sum(params int[] args)
> {
>   int sum = 0;
>   
>   for(int i=0; i<args.Length; i++)
>   {
>       sum += args[i];
>   }
> return sum;
> }
>```
> 6.9- 명명된 매개 변수: 이름에 근거한 데이타 할당
>``` csharp
> static void PrintProfile(string name, string phone)
> {
>   Console.WriteLine("Name:{0}, Phone:{1}", name, phone);
> }
> static void Main(string[] args)
> {
>   PrintProfile(name: "Yui", phone: "647-000-0000");
> }
>```
> 6.10- 선택적 매개 변수: 필요에 따라 할당 또는 할당 안할 수 있다
>``` csharp
> void MyMethod_0{int a = 0}
> {
>   Console.WriteLine("{0}", a);
> }
> void MyMethod_1{int a, int b = 0}
> {
>   Console.WriteLine("{0}, {1}", a, b);
> }
>```
> 6.11- 로컬 함수: 클래스 멤버가 아니라서 함수라고 함
>``` csharp
> public void SomeMethod()//메소드 선언
> {
>   int count = 0;
>   SomeLocalFunction(1, 2);//로컬 함수 호출
>   SomeLocalFunction(3, 4);
>
> 
>   void SomeLocalFunction(int a, int b)//로컬 함수 선언
>   {
>       Console.WriteLine($"count: {++count}");//로컬 함수는 자신이 소속한 메소드의 지역 변수를 사용할 수 있다.
>   }
> }
>```
