# Observable   
 
## Obserable 이해  
---
Observable은 말그래도 관찰 가능한이다. 어떤 관찰자가 
**구독을 할 수 도있고 관찰만 할 수도** 있다. 

## Observalbe 흐름의 단계 
----

* onNext   
데이터 발행을 알려준다. 즉 데이터의 흐름의 시작이다.
* onComplete  
모든 데이터의 발행이 끝나면 알려준다. onComplete 한번만 발생하고   
데이터 발행이 끝나면 onNext를 호출해서는 안된다. 
* onError  
에러가 발생했을때 알려준다. 에러가 발생하면 onNext, onComplete 이벤트를 실행하지 않는다. 


## Observalbe 생성  
----
Observable 생성할 때는 직접 인스턴스를 생성하지 않고 정적 팩토리함수를 호출한다. 


## RxJava 1.x 과 RxJava 2.x 차이  
RxJava 1.x 에서는 Observalbe로만 스트림을 만들어줬지만    
RxJava 2.x 에서는 Maybe, Flowable, Obserable 3가지 경우로 나눠서 스트림을 지정해준다. 

