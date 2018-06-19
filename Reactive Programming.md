# Reactive Programming?  
명령형 프로그램밍은 상태를 바꾸는 것을 강조하고 함수형 프로그래밍에서는 함수의 응용을 강조한다. 

## 데이터의 흐름?   
----
리액티브에서는 데이터의 흐름을 스트림이라고 한다. 

## 관찰자의 역할?
----
데이터가 흘러가는 흐름을 관찰한다. 즉 스트림을 관찰한다고 볼 수 있다. 
스트림은(**Subject**) 관찰이 가능해서 **Observable** 라고 불린다.  
나중에 Subject 개념은 나중에 차가운 Observable, 뜨거운 Observable 바꿔줄 수 있다.  
이 부분은 RxJava 부분에서 나중에 설명하겠다. 

## 스트림의 처리과정 
---- 
**제가 이해한 바탕으로 설명한것입니다.**  
### 1. 스트림을(데이터흐름) 생성한다. 

#### 스트림이란?   
시간순서대로 정렬된 **이벤트**의 집합이다. 

##### 스트림위에 데이터가 흘러가는것을 이벤트라 한다. 

```
ex)  
Observable< String > observable=Observable.create(subscriber -> {
    subscriber.onNext("android");  
    subscriber.onCompleted();
```

onNext 는 "android" 값을 데이터흐름에 넣어준다는 뜻이고 onCompleted는 이제 데이터흐름에 값을 더 이상 안넣고 종료하겠다는 뜻이다. **(즉 관찰을 그만한다.)**  
암튼 여기서는 .create() 생성하였지만 생성연산자는 **defer,just,Range** 등 다양한 방식이있고 각각의 쓰임과 특징이있다.  


### 2. 데이터 흐름의 방향을 만들수있다.  
만약에 **하나의 흐름에 담긴 데이터를 변경 싶을때** 다른 방향을 만들어야 된다. 
  
<pre>
ex)  Observable< String > observable=Observable.create(subscriber -> {
subscriber.onNext("android");  
                
subscriber.onCompleted();       
        }).map(str->str.toString().toUpperCase());
</pre>
위의 결과는 ANDROID가 나올것이다. 하지만 여기 단계에서는 결과값은 나오지 않는다.   
.map으로 결과값을 바꾸듯이 **새로운 방향을 만들어 기존과 다른 데이터로 가공한다.** 물론 여기서도 .map 연산자 말고도 **flatmap,map,buffer** 등의 연산자가 있고 각각의 쓰임과 특징이있다.  

### 3. 관잘차가 관심이있는 것을 구독하여 사용한다. 
이제 관잘차가 원하는 결과가 나오는 흐름의 방향을 하나를 구독한다. 
이것을 **Subscribe** 라고한다.   
여기서는 **스트림 방향의 대한 결과를 가지고 어떤것을 하는 단계**이다.  

<pre>
ex) observable.subscribe(new Subscriber< String >() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(String s) {
                //필요한 작업 
            }
        });  
 </pre>
  
### **여기서의 이벤트는 문자열이 대문자로 바꾸는흐름을 이벤트라 한다.**
이제는 해당 값을 가지고 필요한 작업을 해주면된다. 예를 들자면 원하는 뷰에다가 데이터 바인딩 같은 것을 해주면 된다.
즉 **Subscribe**는 **원하는 이벤트가 발생하면 구독해서** 그다음 작업을 이어가는 역할을한다. 


위에 코드는 이해를 위해 람다식을 사용하지 않았다. 사용하면 더 간편해진다.   

<pre>
ex)observable.subscribe(s-> 필요한 작업);
</pre>    

----

## 대충 함수형 프로그램밍이 처리되는 느낌을 설명 했습니다. 좀 더 디테일한 부분은 각각의 RxJava, RxAnroid 에서 나름의 정리를 하도록 하겠습니다!. 





