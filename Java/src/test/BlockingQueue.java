//package test;
//
//import java.util.LinkedList;
//import java.util.List;
//
///**
// * Created by Dorofeev on 4/8/2016.
// */
//public class BlockingQueue {
//
//    private List queue = new LinkedList();
//    private int  limit = 10;
//
//    public BlockingQueue(int limit){
//        this.limit = limit;
//    }
//
//
//    public synchronized void put(T item) throws InterruptedException  {
//        System.out.println("[BlockingQueue] try to put: " + item );
//        while (this.queue.size() == this.limit) {
//            System.out.println("[BlockingQueue] queue is full, waiting until space is free");
//            wait();
//        }
//        if (this.queue.size() == 0) {
//            System.out.println("[BlockingQueue] queue is empty, notify");
//            notifyAll();
//        }
//        this.queue.add(item);
//        System.out.println("[BlockingQueue] put ok: " + item );
//    }
//
//
//    public synchronized T take() throws InterruptedException{
//        System.out.println("[BlockingQueue] try to take");
//        while (this.queue.size() == 0){
//            System.out.println("[BlockingQueue] queue is empty, waiting until smth is put");
//            wait();
//        }
//        if (this.queue.size() == this.limit){
//            System.out.println("[BlockingQueue] queue is full, notify");
//            notifyAll();
//        }
//
//        T item = this.queue.remove(0);
//        System.out.println("[BlockingQueue] take ok: " + item );
//        return item;
//    }
//    }
