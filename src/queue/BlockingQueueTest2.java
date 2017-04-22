package queue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * ���߳�ģ��ʵ�������ߣ�������ģ��
 *  
 * @author �ּ���
 * @version 1.0 2013-7-25 ����05:23:11
 */
public class BlockingQueueTest2 {
    /**
     * 
     * ����װƻ��������
     * 
     */
    public class Basket {
        // ���ӣ��ܹ�����3��ƻ��
        BlockingQueue<String> basket = new LinkedBlockingQueue<String>(3);
        
        Deque<String> basket1 = new ArrayDeque<String>(3);
        
        Queue<String> bq = new ConcurrentLinkedQueue<String>();

        // ����ƻ������������
        public void produce() throws InterruptedException {
        	basket1.add("23432");
        	bq.add("222");
            // put��������һ��ƻ������basket���ˣ��ȵ�basket��λ��
            basket.put("An apple");
        }

        // ����ƻ������������ȡ��
        public String consume() throws InterruptedException {
            // take����ȡ��һ��ƻ������basketΪ�գ��ȵ�basket��ƻ��Ϊֹ(��ȡ���Ƴ��˶��е�ͷ��)
            return basket.take();
        }
    }

    // ����ƻ��������
    class Producer implements Runnable {
        private String instance;
        private Basket basket;

        public Producer(String instance, Basket basket) {
            this.instance = instance;
            this.basket = basket;
        }

        public void run() {
            try {
                while (true) {
                    // ����ƻ��
                    System.out.println("������׼������ƻ����" + instance);
                    basket.produce();
                    System.out.println("!����������ƻ����ϣ�" + instance);
                    // ����300ms
                    Thread.sleep(300);
                }
            } catch (InterruptedException ex) {
                System.out.println("Producer Interrupted");
            }
        }
    }

    // ����ƻ��������
    class Consumer implements Runnable {
        private String instance;
        private Basket basket;

        public Consumer(String instance, Basket basket) {
            this.instance = instance;
            this.basket = basket;
        }

        public void run() {
            try {
                while (true) {
                    // ����ƻ��
                    System.out.println("������׼������ƻ����" + instance);
                    System.out.println(basket.consume());
                    System.out.println("!����������ƻ����ϣ�" + instance);
                    // ����1000ms
                    Thread.sleep(1000);
                }
            } catch (InterruptedException ex) {
                System.out.println("Consumer Interrupted");
            }
        }
    }

    public static void main(String[] args) {
        BlockingQueueTest2 test = new BlockingQueueTest2();

        // ����һ��װƻ��������
        Basket basket = test.new Basket();

        ExecutorService service = Executors.newCachedThreadPool();
        Producer producer = test.new Producer("������001", basket);
        Producer producer2 = test.new Producer("������002", basket);
        Consumer consumer = test.new Consumer("������001", basket);
        service.submit(producer);
        service.submit(producer2);
        service.submit(consumer);
        // ��������5s����������ֹͣ
//        try {
//            Thread.sleep(1000 * 5);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        service.shutdownNow();
    }

}