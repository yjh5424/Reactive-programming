import io.reactivex.Maybe;
import io.reactivex.Observable;

public class ReduceExample {
    public static void main(String[] args){
        String[] balls={"1","3","5"};
        Maybe<String> maybe= Observable.fromArray(balls)
                .reduce((ball1,ball2)->ball2+"("+ball1+")");
        maybe.subscribe(System.out::println);
        //Maybe 데이터를 하나 혹은 0개 발행


        //곱하기 연산
        Integer[] values={0,1};
        int count=10;

    }
}
