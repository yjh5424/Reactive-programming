# Single 클래스
RxJava 1.x 버전부터 존재하였고 
Observable 특수한 형태로 오직 1개의 데이터만 발행하도록 제한한다. 
주로 보통 **서버 APi 호줄**할 때 사용된다. (즉 클라이언트 요청하나에 대한 결과 하나만 받으면 된다.)

## Single 흐름의 단계  
Observable에서의 onNext(), onComplete() 함수가 
onSuccess() 함수로 통합되었다. 

즉 **onSuccess()**, **onError()** 로 흐름이 진행된다. 

## 사용방법 

<pre>
Single< String >  single=Single.just("Hello");
single.subscribe(System.out::println);

결과 : Hello
</pre>

Obserable 하고 똑같이 사용하면되고 단지 주위할 점은 Single로 **여러개의 데이터가 발행**하면 오류가 뜨니간 이점은 조심해야된다.  


## Single 클래스 활용

1. Obserable에서 Single 객체로 변환 
//추가예정

## 참고자료
