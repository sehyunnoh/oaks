# Chapter 05 코드의 흐름 제어하기
*코드의 실행 순서를 자유자재로!*


## 5.1 분기문(Branching statement)
: 조건에 따라 프로그램의 흐름 변화
+ If-(else if)-else
  - condition이 true/false
>``` csharp
>if(number > 0)
>{
>    if(number % 2 == 0)
>    {
>        Console.WriteLine("positive even number");
>    }
>    else
>    {
>        Console.WriteLine("positive odd number");
>    }
>}
>else
>{
>    Console.WriteLine("negative number");
>}
>```
+ Switch
  - condition이 다양한 결과를 한 번에 평가 후 프로그램의 흐름을 나눌 때 사용
>``` csharp
>switch (day)
>{
>    case "일":
>        Console.WriteLine("Sunday");
>        break;
>    case "월":
>        Console.WriteLine("Monday");
>        break;
>    case "화":
>        Console.WriteLine("Tuesday");
>        break;
>    case "수":
>        Console.WriteLine("Wednesday");
>        break;
>    case "목":
>        Console.WriteLine("Thursday");
>        break;
>    case "금":
>        Console.WriteLine("Friday");
>        break;
>    case "토":
>        Console.WriteLine("Saturday");
>        break;
>    default:
>        Console.WriteLine($"{day}는(은) 요일이 아닙니다.");
>        break;
>}
>```

C# 7.0이후 조건식에 데이터타입 사용 가능
>``` csharp
>object obj = null;
>
>string s = Console.ReadLine();
>if (int.TryParse(s, out int out_i))
>    obj = out_i;
>else if (float.TryParse(s, out float out_f))
>    obj = out_f;
>else
>    obj = s;>
>
>switch (obj)
>{
>    case int i:
>        Console.WriteLine($"{i}는 int 형식입니다.");
>        break;                
>    case float f when f >= 0:
>        Console.WriteLine($"{f}는 양의 float 형식입니다.");
>        break;
>    case float f:
>        Console.WriteLine($"{f}는 음의 float 형식입니다.");
>        break;
>    default:
>        Console.Write($"{obj}는모르는 형식입니다.");
>        break;
>}

## 5.2 반복문(Loop)
+ while
>``` csharp
>/*[syntax]*/
>while (조건식)
>{
>    반복하여 실행할 코드
>}
>```
>``` csharp
>/*[Example]*/
>int n = 0;
>while (n < 5)
>{
>    Console.WriteLine(n); // 0 1 2 3 4
>    n++;
>}
>```

+ do while: 무조건 한번은 실행
>``` csharp
>/*[syntax]*/
>do
>{
>    반복하여 실행할 코드
>}
>while(조건식); //while과 다르게 ;사용
>```
>``` csharp
> /*[Example]*/
>int n = 0;
>
>do 
>{
>    Console.WriteLine(n); // 0
>} while (n > 0);
>```

- for
- foreach
>``` csharp
>/*[syntax]*/
>foreach(임시variable in array 또는 collection)
>{
>    반복하여 실행할 코드
>}
>```
>``` csharp
> /*[Example]*/
>string[] OaksMembers = ["Eric", "Yui", "Angela", "Brian"];
>
>foreach(String member in OaksMembers)
>{
>    Console.WriteLine(member); // Eric Yui Angela Brian
>}
>```
- Infinite Loop (for, while)
>``` csharp
>/*[syntax]*/
>for(;;)
>{
>    반복하여 실행할 코드
>    반복을 멈출 코드 (ex) if(i == 10) break; 
>}
>
>while(true)
>{
>    반복하여 실행할 코드
>    반복을 멈출 코드 (ex) if(i == 10) break; 
>}
>```

## 5.3 점프문
: 실행 흐름을 끊거나 실행 위치를 원하는 곳으로 이동
+ break
  - 현재 실행중인 Loop 또는 switch문 중단
+ continue
  - 반복문 안에서 주로 사용. 현재 반복을 건너 뛰고 반복 계속 수행. 반복 종료X
>``` csharp
>for(int i = 0; i < 5; i++>)
>{
>    if(i==3)
>       continue;
>
>    Console.WriteLine(i);
>}
>``` 
>``` csharp
>for(int i = 0; i < 5; i++>)
>{
>    if(i!=3)
>       Console.WriteLine(i);
>}
>```  
+ goto
  - label(레이블, 표지판)이 가리키는 곳으로 바로 건너 뛰는 구문
  - 실행 흐름을 복잡하게 만들어 가독성이 좋지 않다 => 권장 X
>``` csharp
>Console.WriteLine("1");
>
>goto JUMP;
>
>Console.WriteLine("2");
>Console.WriteLine("3");
>
>JUMP:
>Console.WriteLine("4");
>``` 
+ return
+ throw
