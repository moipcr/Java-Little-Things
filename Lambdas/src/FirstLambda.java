public class FirstLambda {

    public static  void main(String[] args){
        Runnable runnableLambda = () -> System.out.println("Hello world from thread [" + Thread.currentThread().getName() + "]");
        Thread t = new Thread(runnableLambda);
        t.start();
    }
}
