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


        //rxjava1 에서는 RxJavaMath가 있었지만 rxjava2에서는 지원을 안해서 RxJava2Extensions 라이브러리를 등록해야한다.
/*
        Observable.fromArray(1,2,4,3).to(s->MathObservable.max(s))
                .subscribe(max->System.out.println(max));

        Flowable.fromArray(integers).to(MathFlowable::max)
                .subscribe(max->System.out.println(max));
*/


        //observable를 리턴해서 MathObservable 인자로 넘겨줌
        Observable<Integer> sumObservable=Observable.just(0)
                .flatMap(i ->Observable.range(1,9))
                .to(flatMapObservable-> MathObservable.sumInt(flatMapObservable));
        sumObservable.subscribe(sum->System.out.println(sum));


    }
}
