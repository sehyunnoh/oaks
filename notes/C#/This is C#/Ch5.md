# Chapter 05 코드의 흐름 제어하기
*코드의 실행 순서를 자유자재로!*


## 5.1 분기문(Branching statement)
: 조건에 따라 프로그램의 흐름 변화
- If-(else if)-else
: condition이 true/false
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
- Switch
:   condition이 다양한 결과를 한 번에 평가 후 프로그램의 흐름을 나눌 때 사용
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
- while
- do while
- for
- foreach
