public class Basic {
    public static void main(String[] args) {
        Mythread mythread = new Mythread();
        mythread.start();
    }
    public static class Mythread extends Thread {
        @Override
        public void run(){
            System.out.println("in thread " + currentThread().getName());
        }
    }
}