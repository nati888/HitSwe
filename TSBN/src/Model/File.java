//package Model;
//
//import org.w3c.dom.ls.LSOutput;
//
//import java.io.*;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.util.Scanner;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.stream.Stream;
//
//
//public class File {
//
//        static void fileRead() {
//           String filename = "WorkersDB.txt";
//           ObjectInputStream inputStream = null;
//           Workers worker_list = Workers.getMySingelton();
//           //List<Worker> workers=Workers.getWorker_List();     ***First try***
////            try {
////                inputStream = new ObjectInputStream(new FileInputStream(filename));
////                //workers = (List<Worker>) inputStream.readObject();
////                for (Worker worker : worker_list) {
////                    System.out.println(worker.toString());
////                    worker_list.addWorker(worker);
////                }                                             ***End first try***
////            Scanner sc = null;                                ***Second try***
////            try {
////                //sc = new Scanner(new BufferedReader(new FileReader("WorkersDB.txt")));
////                inputStream = new ObjectInputStream(new FileInputStream(filename));
////            } catch (FileNotFoundException e) {
////                e.printStackTrace();
////            } catch (IOException e) {
////                e.printStackTrace();
////            }
////            try {
////                System.out.println("Available: "+inputStream.readObject(byte[] bytes, int off=0, int len=10));
////            } catch (IOException | ClassNotFoundException e) {
////                e.printStackTrace();
////            }
//////                int rows = 4;
//////                int columns = 10;
//////                int [][] myArray = new int[rows][columns];
//////                while(sc.hasNextLine()) {
//////                    for (int i=0; i<myArray.length; i++) {
//////                        String[] line = sc.nextLine().trim().split(" ");
//////                        for (int j=0; j<line.length; j++) {
//////                            myArray[i][j] = Integer.parseInt(line[j]);
//////                        }
//////                    }
//////                }
//////                System.out.println(Arrays.deepToString(myArray));
//
////            } catch (IOException | ClassNotFoundException e) {
////                e.printStackTrace();
////            } finally {
////                try {
////                    inputStream.close();
////                } catch (IOException e1) {
////                    e1.printStackTrace();
////                }
////            }                                             ***End Second try
//            StringBuilder contentBuilder = new StringBuilder();
//
////            try(Stream<String> stream = Files.lines(path));
//
////            finally {
//                try {
//                    inputStream.close();
//                } catch (IOException e1) {
//                    e1.printStackTrace();
//                }
//            }
//
//        }
//
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
