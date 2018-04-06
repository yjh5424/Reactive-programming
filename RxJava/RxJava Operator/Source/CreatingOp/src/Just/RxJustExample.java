package Just;

import rx.Observable;

public class RxJustExample {
    public static void main(String[] args){

        Observable.just("Rx Java").subscribe(System.out::println);
        //System.out::println  data->System.out.println(data); 와동일
        System.out.println("------------------");
        Observable.just(1,2,3,4,5,6,7,8,9,10).subscribe(System.out::println);
    }
}

