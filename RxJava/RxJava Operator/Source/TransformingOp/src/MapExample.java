import io.reactivex.Observable;
import io.reactivex.functions.Function;

public class MapExample {

    private static String[] sports={"soccer","baseball","tennis"};

    public static void main(String[] args){

        Observable<String> observable= Observable.fromArray(sports)
                .map(str->str.toUpperCase());
        observable.subscribe(System.out::println);

        System.out.println("---------------");

        //Function 인테페이스사용 예
        Observable<String> funObservable=Observable.fromArray(new Integer(10),new Integer(20),new Integer(30))
                .map(getStringToInt());
        funObservable.subscribe(System.out::println);

    }


    //Integer를 받아서 String 값을 리턴
    public static Function<Integer,String> getStringToInt(){
        Function<Integer,String> function= integer-> "string 변환"+integer;
        return function;
    }
}
