package com.szarpcode.samples.spring.lifecycle;


import org.springframework.context.Lifecycle;

public class LifecycleBean implements Lifecycle {

    private InnerThread innerThread = new InnerThread();

    private class InnerThread extends Thread {

        @Override
        public void run() {

            for (int i = 0; i < 5; ++i) {
                try {
                    Thread.sleep(500);
                    System.out.println(this.getClass().getName() + " iteration: " + (i + 1));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    @Override
    public void start() {
        System.out.println(this.getClass().getSimpleName() +": start");
        innerThread.start();
    }

    @Override
    public void stop() {
        try {
            innerThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(this.getClass().getSimpleName() +": stop");
    }

    @Override
    public boolean isRunning() {
        return this.innerThread.isAlive();
    }
}
