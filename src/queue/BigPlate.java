package queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/** ����һ�������࣬���Էż�����ȡ���� */  
public class BigPlate {  
  
    /** װ���������ӣ���СΪ5 */  
    private BlockingQueue<Object> eggs = new ArrayBlockingQueue<Object>(5);  
      
    /** �ż��� */  
    public void putEgg(Object egg) {  
        try {  
            eggs.put(egg);// ������ĩβ��һ������������������ˣ���ǰ�߳�����  
        } catch (InterruptedException e) {  
            e.printStackTrace();  
        }  
  
        // ���������ʱ��׼ȷ����Ϊ��put��������һ��ԭ�Ӳ���  
        System.out.println("���뼦��");  
    }  
      
    /** ȡ���� */  
    public Object getEgg() {  
        Object egg = null;  
        try {  
            egg = eggs.take();// �����ӿ�ʼȡһ��������������ӿ��ˣ���ǰ�߳�����  
        } catch (InterruptedException e) {  
            e.printStackTrace();  
        }  
  
        // ���������ʱ��׼ȷ����Ϊ��take��������һ��ԭ�Ӳ���  
        System.out.println("�õ�����");  
        return egg;  
    }  
      
    /** �ż����߳� */  
    static class AddThread extends Thread {  
        private BigPlate plate;  
        private Object egg = new Object();  
  
        public AddThread(BigPlate plate) {  
            this.plate = plate;  
        }  
  
        public void run() {  
            plate.putEgg(egg);  
        }  
    }  
  
    /** ȡ�����߳� */  
    static class GetThread extends Thread {  
        private BigPlate plate;  
  
        public GetThread(BigPlate plate) {  
            this.plate = plate;  
        }  
  
        public void run() {  
            plate.getEgg();  
        }  
    }  
      
    public static void main(String[] args) {  
        BigPlate plate = new BigPlate();  
        // ������10���ż����߳�  
        for(int i = 0; i < 10; i++) {  
            new Thread(new AddThread(plate)).start();  
        }  
        // ������10��ȡ�����߳�  
        for(int i = 0; i < 10; i++) {  
            new Thread(new GetThread(plate)).start();  
        }  
    }  
} 