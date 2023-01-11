// two threads, thread 1 prints 1 - 26, thread 2 prints a - z, alternatively
public class AlternateThreads {
    private volatile int num = 1;
    private volatile char ch = 'a';
    private volatile boolean flag = false; // false: print num; true: print char

    private synchronized void printChar() {
        try {
            while (!flag) {
                wait();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Thread.currentThread().getName() + " " + ch);
        flag = false;
        ch ++;
        notifyAll();
    }

    private synchronized void printNum() {
        try {
            while (flag) {
                wait();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Thread.currentThread().getName() + " " + num);
        flag = true;
        num ++;
        notifyAll();
    }

    public static void main(String[] args) {
        AlternateThreads threadClass = new AlternateThreads();
        // thread 1 print num
        Thread t1 = new Thread (
                () -> {
                    for (int i = 0; i < 26; i++) {
                        threadClass.printNum();
                    }
                }
        );
        t1.setName("Thread1");

        // thread 2 print char
        Thread t2 = new Thread(
                () -> {
                    for (int j = 0; j < 26; j++) {
                        threadClass.printChar();
                    }
                }
        );
        t2.setName("Thread2");

        // start the two threads
        t1.start();
        t2.start();


    }
}
