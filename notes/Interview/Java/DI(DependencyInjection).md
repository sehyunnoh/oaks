# Composition has a (일체형)
- 안에 부품이 뭐가 있는지 알수가 없음
```java
class A
{
    private B b;

    public A(){
        b = new B();
    }
}

A a = new A();
```

# Association has a (조립형)
- 결합력이 낮아짐 (loose coupling)
- 부품을 마음대로 갈아 끼울수 있어서 더 선호됨
- 부품을 갈아 끼워야 되는 불편함이 있음
```java
class A
{
    private B b;

    public A(){};

    public void setB(B b){
        this.b = b;
    }
}

// 1. Setter Injection
B b = new B(); // Dependency
A a = new A();

a.setB(b); // Injection

// 2. Construction Injection
B b = new B();
A a = new A(b);
```