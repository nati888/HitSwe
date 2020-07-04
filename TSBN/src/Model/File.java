package Model;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class File {
    public static void main(String[] args) {
        fileRead();
    }



        static void fileRead() {
            String filename = "WorkersDB.txt";
            ObjectInputStream inputStream = null;
           Workers worker_list = Workers.getMySingelton();
            List<Worker> workers=Workers.getWorker_List();
            try {
                inputStream = new ObjectInputStream(new FileInputStream(filename));
                workers = (List<Worker>) inputStream.readObject();
                for (Worker worker : workers) {
                    System.out.println(worker.toString());
                    worker_list.addWorker(worker);
                }
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            } finally {
                try {
                    inputStream.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }

        //public static void main (String[]args){}
        public static void fileWrite() {
            ObjectOutputStream outputStream = null;
            try {
                Workers worker_list = Workers.getMySingelton();
                String filename = "WorkersDB.txt";
                outputStream = new ObjectOutputStream(new FileOutputStream(filename));
                outputStream.writeObject(worker_list);
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

}
