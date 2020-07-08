
package Model;

import org.w3c.dom.ls.LSOutput;

import java.awt.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.stream.Stream;


public class File {
    public static void main(String[]args) {
        fileWrite();
        //fileRead();
    }

    public static void fileWrite () {
        ObjectOutputStream outputStream = null;
        try {
            Workers worker_list = Workers.getMySingelton();
            String filename = "WorkersDB.txt";
            ArrayList<Worker>workers =new ArrayList<Worker>();
            Worker worker=new Worker("irani","sapir",315424283,"sapir@gmail.com",5,2,105,52,"sapir","irani");
            Worker worker1=new Worker("Tal","Lalum",315424283,"Lalum@gmail.com",5,2,105,52,"tal","lalum");
            Worker worker2=new Worker("alon","ben",315424283,"alon@gmail.com",5,2,105,52,"ben","alon");
            Worker worker3=new Worker("terner","nati",315424283,"nati@gmail.com",5,2,105,52,"hello","world");
            worker_list.addWorker(worker);
            worker_list.addWorker(worker1);
            worker_list.addWorker(worker2);
            worker_list.addWorker(worker3);
            System.out.println(worker_list.getSize());// Delete
            outputStream = new ObjectOutputStream(new FileOutputStream(filename));
            //worker_list.getWorker_i(1).printWorker();
            for (int i=0;i<worker_list.getSize();i++){
                workers.add(worker_list.getWorker_i(i));
            }
            //System.out.println("success"+workers.size());
            //for (Worker user:workers) {
                System.out.println(workers);
                outputStream.writeObject(workers);
            //}
            System.out.println("Done!");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                outputStream.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }

    static void fileRead() {
        String filename = "WorkersDB.txt";
        ObjectInputStream inputStream = null;
        Workers worker_list = Workers.getMySingelton();
        try {
            inputStream = new ObjectInputStream(new FileInputStream(filename));
            //System.out.println(inputStream.readObject().getClass());
            Worker use= (Worker) inputStream.readObject();
            System.out.println(use);
//            ArrayList<Worker> workers = (ArrayList<Worker>) inputStream.readObject();
//            for (Worker user : workers) {
//                System.out.println(user.toString());
//            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }




//        public static void main(String[]args) {
//        //fileWrite();
//        fileRead();
//        }
//            public static void fileWrite () {
//                ObjectOutputStream outputStream = null;
//                try {
//                    Workers worker_list = Workers.getMySingelton();
//                    String filename = "WorkersDB.txt";
//                    Worker worker=new Worker("irani","sapir",315424283,"sapir@gmail.com",5,2,105,52,"sapir","irani");
//                    Worker worker1=new Worker("Tal","Lalum",315424283,"Lalum@gmail.com",5,2,105,52,"tal","lalum");
//                    Worker worker2=new Worker("alon","ben",315424283,"alon@gmail.com",5,2,105,52,"ben","alon");
//                    Worker worker3=new Worker("terner","nati",315424283,"nati@gmail.com",5,2,105,52,"hello","world");
//                    worker_list.addWorker(worker);
//                    worker_list.addWorker(worker1);
//                    worker_list.addWorker(worker2);
//                    worker_list.addWorker(worker3);
//                    System.out.println(worker_list.getSize());// Delete
//                    outputStream = new ObjectOutputStream(new FileOutputStream(filename));
//
//                     for (int i=0;i<worker_list.getSize();i++) {
//                         outputStream.writeObject(worker_list.getWorker_i(i));
//                         outputStream.writeObject("\n");
//                         worker_list.getWorker_i(i).printWorker();
//                    }
//                    System.out.println("Done!");
//                } catch (IOException e) {
//                    e.printStackTrace();
//                } finally {
//                    try {
//                        outputStream.close();
//                    } catch (IOException e1) {
//                        e1.printStackTrace();
//                    }
//                }
//            }
//
//
//}


    }
}

