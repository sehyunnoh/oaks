# Chapter 08 Interface & Abstract

## 8.1 Interface 선언
> - 가능한 멤버: method, event, property, indexer?
> - No implementation
> - No instance (참조는 가능)
> - public
> - 인터페이스를 상속받은 클래스의 instance 생성 가능
>``` csharp
>interface ILogger
>{
>   void PrintLog(string log);
>}
>```
>``` csharp
>class ConsoleLogger : ILogger
>{
>   public void PrintLog(string message)
>   {
>       Console.WriteLine(message);
>   }
>}
>```
>``` csharp
>//No instance (참조는 가능), 인터페이스를 상속받은 클래스의 instance 생성 가능 
>ILogger logger = new ConsoleLogger();
>logger.PrintLog("Hello World");
>```

## 8.2 Interface는 약속이다
