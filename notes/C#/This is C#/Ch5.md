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
