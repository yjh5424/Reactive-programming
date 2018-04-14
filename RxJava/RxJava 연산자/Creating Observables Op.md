# Create Observable 연산자    

## 1. Just  

빨강원은 Observalbe 에서 발행하는 데이터로 중간에 있는 just() 함수를 흐름에따라 만나게 되면 들어온 **데이터를 그대로 발행**해준다는 뜻이다.  

만약에 2개이상의 데이터가 들어오게 된다면 순서대로 1~N까지 발행하고 완료한다(onComplete)  

![screenshot](https://raw.githubusercontent.com/wiki/ReactiveX/RxJava/images/rx-operators/Single.just.png)

## 사진출처 
http://reactivex.io/documentation/operators.html 문서 참고

## 2. Create  
    
![screenshot](http://reactivex.io/documentation/operators/images/create.c.png)

**Just 와 Create 의 차이점?**  
just는 사용하자마자 이벤트가 발생하지만 create 함수는  
발행, 완료를 직접 명시해야된다. create 발행을 안할시 아무일도 안일어난다.  

**create 사용할 때 주의할 점** 
