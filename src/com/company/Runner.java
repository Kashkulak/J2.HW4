package com.company;

public class Runner extends Thread {
    private String name;
    private int number = 2;

    public int getNumber() {
        return number++;
    }

    public Runner(String name) {
        this.name = name;
    }

    public synchronized void run() {

        for (int i = 1; i <= 5; i++) {

            System.out.print(name + i + " берет палочку\n");
            if (number<6) {
                System.out.println(name + i + " бежит к " + name + getNumber());
            }
            else if (number >5) {
                System.out.println(name + i + " бежит к финишу");
            }
            try {
                sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("");
        }
        number--;

        for (int i = 5; i > 0; i--) {
            number--;
            if (number>0)
                System.out.println(name + i + " бежит к "+name+number+"\n"+name+number+" берет палочку\n");
            try {
                sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
