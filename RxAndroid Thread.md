# Rx가 안드로이드 쓰레드에서 처리되는 과정 
 ### 1. .subscribeOn() stream을 시작하는 observable의 쓰레드 스케쥴러를 변경한다.
 <code>
 subscribeOn(Schedulers.io()).  
 //여기서는 io 쓰레드가 처리해준다.    
//API 호출 등 네트워크를 사용한 호출 시 사용됩니다.
 </code>

 ### 2. .observeOn()은 이후에 나오는 오퍼레이터, subscribe의 스케쥴러를 변경을 할수있다.   
 <code>

observeOn(AndroidSchedulers.mainThread()).  
//네트워크 통신후 받은 값을 메인쓰레드에서  처리를 한다.   
//네트워크 통신은 메인쓰레드에서 진행할수없으므로 헷갈리면 안된다. 
 </code>

 ### rx, retrofit 를 이용한 네트워크 통신 예제  

 <pre>

    private void login(String id, String password) {
        Service service = Connector.HttpService();
        service.login(id, password).subscribeOn(Schedulers.io()).
                observeOn(AndroidSchedulers.mainThread()).
                subscribe(auth -> {
                    Log.d("token",auth.getToken());
                    Log.d("refreshToken",auth.getRefreshToken());
                },throwable -> {
                    //오류
                });
    }

 </pre>

## Observable이 작동 할 스케줄러 지정
3. ![screenshot](http://reactivex.io/documentation/operators/images/schedulers.png)

* 황색 : Observable   
* 파란색 : Subscribe
* 핑크색 : Observable 




