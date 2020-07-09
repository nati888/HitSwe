
package Model;


import java.io.*;
import java.util.ArrayList;


public class File_Ex {
    public static void main(String[] args) {
        fileWrite(); // call to file write function
        fileRead(); // call to file read function
    }

    public static void fileWrite() {

        ObjectOutputStream outputStream = null; // create an output stream object
        try {
            Ex_Workers ex_worker_list = Ex_Workers.getMySingelton();
            ArrayList<Ex_Worker> workers = new ArrayList();

            for (int i = 0; i < ex_worker_list.getSize(); i++) { // convert singelton to array list
                workers.add(ex_worker_list.getWorker_i(i));
            }
            String filename = "ExWorkersDB.txt";
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
        String filename = "ExWorkersDB.txt";
        ObjectInputStream inputStream = null; // intialize input object
        Ex_Workers ex_worker_list = Ex_Workers.getMySingelton();

        ArrayList<Ex_Worker> workers;
        try {
            inputStream = new ObjectInputStream(new FileInputStream(filename)); // creating a new input object
            workers = (ArrayList<Ex_Worker>) inputStream.readObject(); // reading from file to a temp array list
//            for (Worker worker : workers)
//                worker.printWorker();
            for (Ex_Worker worker : workers) // copy to singeltone
                ex_worker_list.addWorker(worker);
//           worker_list.getWorker_i(0).printWorker();
//
//            System.out.println("our list: ");
//            for (int i = 0; i < worker_list.getSize(); i++)
//                (worker_list.getWorker_i(i)).printWorker();
        } catch (IOException | ClassNotFoundException e) // wasnt able to open the file | wasnt able to find the file
        {
            e.printStackTrace();
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}