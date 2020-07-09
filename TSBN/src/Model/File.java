
package Model;


import java.io.*;
import java.util.ArrayList;


public class File {
    public static void main(String[]args) {
      fileWrite(); // call to file write function
        fileRead(); // call to file read function
    }

    public static void fileWrite () {

        ObjectOutputStream outputStream = null; // create an output stream object
        try {
            Workers worker_list = Workers.getMySingelton();
            ArrayList<Worker> workers = new ArrayList();


            for (int i = 0; i < worker_list.getSize(); i++) { // convert singelton to array list
                workers.add(worker_list.getWorker_i(i));
            }
            String filename = "WorkersDB.txt";
            outputStream = new ObjectOutputStream(new FileOutputStream(filename));
            outputStream.writeObject(workers); // writing into file
        } catch (IOException e) { // if wasnt able to open a file
            e.printStackTrace();
        } finally {  // final block code
            try {
                outputStream.close(); // closing file
            } catch (IOException e1) { // if wasnt able to close
                e1.printStackTrace();
            }
        }
    }

    static void fileRead() {
        String filename = "WorkersDB.txt";
        ObjectInputStream inputStream=null; // intialize input object
        Workers worker_list = Workers.getMySingelton();
        Worker worker1=new Worker("irani","sapir",315424283,"sapir@gmail.com",5,1,105,52,"sapir","irani");
        worker_list.addWorker(worker1);
        worker1.setHours(5);
        ArrayList<Worker> workers;
        try {
            inputStream = new ObjectInputStream(new FileInputStream(filename)); // creating a new input object
            workers = (ArrayList<Worker>) inputStream.readObject(); // reading from file to a temp array list
//            for (Worker worker : workers)
//                worker.printWorker();
            for (Worker worker : workers) // copy to singeltone
                worker_list.addWorker(worker);
//           worker_list.getWorker_i(0).printWorker();
//
//            System.out.println("our list: ");
//            for (int i = 0; i < worker_list.getSize(); i++)
//                (worker_list.getWorker_i(i)).printWorker();
        }
        catch(IOException | ClassNotFoundException e) // wasnt able to open the file | wasnt able to find the file
        {
            e.printStackTrace();
        }finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }




//        public static void main(String[]args) { // experiments
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

