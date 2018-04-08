import hu.akarnokd.rxjava2.math.MathFlowable;
import hu.akarnokd.rxjava2.math.MathObservable;
import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOperator;
import io.reactivex.functions.Function;

public class FlatMapExample {

    private static String[] sports={"soccer","baseball","tennis"};
    private static Integer[] integers = {1,2,4,3};

    public static void main(String[] args){

        Observable<String> observable=Observable.fromArray(sports)
                .flatMap(str-> Observable.just("운동: "+str));
        observable.subscribe(System.out::println);

        System.out.println("----------------------");

        //observable를 리턴해서 MathObservable 인자로 넘겨줌
        int result=0; //초기값
        Observable<String> sumObservable=Observable.just(result)
                .flatMap(num -> Observable.range(1,9)
                .to(flatMapObservable-> MathObservable.sumInt(flatMapObservable)
                .map(sum -> "총합은 "+(sum+result))));
        sumObservable.subscribe(sum->System.out.println(sum));

        System.out.println("----------------------");
        //구구단
        int dan=3;
        Observable<String> guguDan=Observable.just(dan)
                .flatMap(num->Observable.range(1,9)
                        .map(row-> num+"*"+row+"="+row*num));

        guguDan.subscribe(System.out::println);



    }
}
