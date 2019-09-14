## Won's Interview Questions (2019.09.14)

The following two questions were actually given to the interviewee multiple times in Won's job interviews.

#### Q1: [Topic: OOP]

##### "Can you describe differences between abstract classes and interfaces?"

- Both an abstract class and a interface has in common to do, which is enfocing rules, however they are different. First , they have differences in appearances. Interfaces can have only abstract methods, having method signatures without implementation, but abstract classes can have both abstract methods and concrete methods. Also, interfaces do not allow declaration and use of variables unlike abstract classes.
  In terms of inheritance, abstract classes can be inherited only one, but interfaces can be implemented by multiple classes.
  In addition, I believe abstract classes enforce inheritance to use or overrided abstract methods from child classes, but interfaces force to have same methods for cooperative work in projects.

##### "Okay. You mentioned inheritance, then do you know the reason why most languages bann multi-inheritance?"

- I'm not sure, but in my opinion it is quite related to polymorphism. I guess a method in an inherited class can behave in multiple forms: one is from an upper class and another is an overriden method in itself. If a class can inherit from multiple classes, it is hard to know how the driven class behaves. It can acts like an inherited method from A class or a method from B class.

##### "That's right. Do you know any language allowing multi-inheritance?"

- No, I don't.

##### "C++. But you need to use it at your own risk."

##### END of Q1

---

#### Q2: [Topic: Easy Problem Solving] (On white board)

##### "Given string your name, print it reverse. You cannot use reverse method. You can use any language you want."

- (I used C#)

            string name = "Choongwon";

            string reverse = null;

            for (int i = name.Length - 1; i >= 0; i--)
            {
              reverse += name[i];
            }

            foreach (var r in reverse)
            {
              Console.Write(r);
            }

##### END of Q2
