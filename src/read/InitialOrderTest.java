package read;

public class InitialOrderTest {   
  
    // ��̬����   
    public static String staticField = "��̬����";   
    // ����   
    public String field = "����";   
    // ��ʼ����   
    {   
    	System.out.println(field);   
    	System.out.println("��ʼ����");   
    }   
  
    // ��̬��ʼ����   
    static {   
        System.out.println(staticField);   
        System.out.println("��̬��ʼ����");   
    }   
  
  
    // ������   
    public InitialOrderTest() {   
        System.out.println("������");   
    }   
  
    public static void main(String[] args) {   
        new InitialOrderTest();   
    }   
}  