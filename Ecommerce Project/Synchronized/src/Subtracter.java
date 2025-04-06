public class Subtracter implements Runnable {
    Counter count;

    public Subtracter(Counter count) {
        this.count = count;
    }
    @Override
    public void run() {
        count.cnt = count.cnt - 1;

    }
}
