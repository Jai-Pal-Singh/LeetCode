package test.practice;

class Practice {
    public static void main(String[] args) {
        MyThreadA threadA = new MyThreadA();
        Thread tA = new Thread(threadA);
        MyThreadB threadB = new MyThreadB();
        Thread tB = new Thread(threadB);
        tA.start();
        tB.start();
    }
}

class MyThreadA implements Runnable {

    @Override
    public void run() {
        // Print p = new Print();
        Print.printAndSleepForA();
    }
}

class MyThreadB implements Runnable {

    @Override
    public void run() {
        // Print p = new Print();
        Print.printAndSleepForB();
    }
}

class Print {
    public static synchronized void printAndSleepForA() {
        for (int i = 0; i <= 10; i++) {
            try {
                Thread.sleep(5000);
                System.out.println("printAndSleepForA calling printAndSleepForB");
                printAndSleepForB();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static synchronized void printAndSleepForB() {
        for (int i = 0; i <= 10; i++) {
            try {
                Thread.sleep(5000);
                System.out.println("printAndSleepForB calling printAndSleepForA");
                printAndSleepForA();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}