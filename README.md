# Algorithm
### 완주하지 못한 선수
> [문제 링크](https://programmers.co.kr/learn/courses/30/lessons/42576)

   > 새로 알게된 것

&nbsp;&nbsp;&nbsp;**HashMap.getOrDefault(key, defaultValue);**

&nbsp;&nbsp;&nbsp;: 존재하지 않는 key면 defaultValue 반환하는 메소드
   
---
### Reverse Integer
> [문제 링크](https://leetcode.com/problems/reverse-integer/)

   > 새로 알게 된 

+ Math.abs(x) 메소드는 Integer.MIN_VALUE가 인자로 전달되면 그대로 Integer.MIN_VALUE를 반환

+ 이유 : Integer.MIN_VALUE = -2147483648 이 양수화 되면 2147483648이 나와야 하지만 이는 Integer가 표현할 수 있는 값의 범위를 넘어서기 때문

    + 부호 변경하기 : 1의 보수 취하기 = 비트 반전(~) + 1
    
             -(-1) = (~(0xFFFFFFFF)) + 1 = 0x00000000 + 1 = 0x00000001 = 1

    + Integer.MIN_VALUE의 부호 변경 :
    
              -(Integer.MIN_VALUE) = (~(0x80000000)) + 1 = 0x7FFFFFFF + 1 
                                     = 0x80000000 = Integer.MIN_VALUE