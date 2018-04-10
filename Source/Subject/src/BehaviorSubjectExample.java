
import io.reactivex.Observable;
import io.reactivex.subjects.BehaviorSubject;
import io.reactivex.subjects.Subject;

public class BehaviorSubjectExample {

    private static String[] values={"a","b","c"};

    public static void main(String[] args){
        //values 들어가면 오류
        BehaviorSubject<String> behaviorSubject=BehaviorSubject.createDefault("A");
        behaviorSubject.subscribe(data -> System.out.println("sub 1:"+data));
        behaviorSubject.onNext("B");
        behaviorSubject.subscribe(data -> System.out.println("sub 2:"+data));
        behaviorSubject.onNext("C");
        behaviorSubject.subscribe(data -> System.out.println("sub 3:"+data));
        behaviorSubject.onNext("D");
    }
}
