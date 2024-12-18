package org.example.queue;

/**
 * @author luxz
 * @date 2024/11/8-22:28
 */
public class Producer {
    private Queue queue;

    public Producer(Queue queue) {
        this.queue = queue;
    }

    public void produce(Long data) throws InterruptedException{
        while (!queue.add(data)){
            Thread.sleep(100);
        }
    }
}
