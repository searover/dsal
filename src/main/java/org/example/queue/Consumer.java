package org.example.queue;

/**
 * @author luxz
 * @date 2024/11/8-22:30
 */
public class Consumer {
    private Queue queue;

    public Consumer(Queue queue) {
        this.queue = queue;
    }

    public void consume() throws InterruptedException {
        while (true) {
            Long data = queue.poll();
            if (data == null) {
                Thread.sleep(100);
            }
            System.out.println(data);
        }
    }
}
