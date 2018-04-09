
import io.reactivex.Observable;
import io.reactivex.subjects.BehaviorSubject;
import io.reactivex.subjects.Subject;

public class BehaviorSubjectExample {

    private static String[] values={"a","b","c"};

    public static void main(String[] args){
        //values 들어가면 오류
        BehaviorSubject<String> behaviorSubject=BehaviorSubject.createDefault("D");
        behaviorSubject.subscribe(System.out::println);
    }
}
