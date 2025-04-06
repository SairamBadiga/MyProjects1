public class Adder implements Runnable {
    Counter count;
    public Adder(Counter count) {
        this.count = count;
    }
    @Override
    public void run() {
        count.cnt = count.cnt + 1;

    }
}
