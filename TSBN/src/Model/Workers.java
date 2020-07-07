package Model;


import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

    public class Workers implements Serializable {
        private static Workers Instance=new Workers();
        private static ArrayList<Worker> worker_List=new ArrayList<Worker>();
        private Workers() { }

        public static ArrayList<Worker> getWorker_List() {
            return worker_List;
        }

        public static Workers getMySingelton(){
            return Instance;
        }

        void addWorker(Worker new_worker){
            worker_List.add(new_worker);
            //File.fileWrite();
//            Excel.add_Worker_To_Excel(new_worker);
        }
        void removeWorker(Worker remove_worker) throws IOException {
            worker_List.remove(remove_worker);
//            Excel.fired_Workers_Excel(remove_worker);
 //           Excel.clear_Excel();
            for(int i=0;i<worker_List.size();i++){
                Worker worker=this.worker_List.get(i);
 //               Excel.add_Worker_To_Excel(worker);

            }
        }
        Worker searchingWorker(int ID){
            for (int i=0;i<this.worker_List.size();i++)
                if(worker_List.get(i).getIDperson()==ID)
                    return worker_List.get(i);
            return null;


        }
        public int getSize(){
            return worker_List.size();
        }
        public  Worker getWorker_i(int i){
            return worker_List.get(i);
        }
        public void setWorker_List_i(int i,Worker new_worker){
            worker_List.set(i,new_worker);}
        public double calculateSalaryById(int ID){
            Worker worker=searchingWorker(ID);
            return worker.calculateSalary();
        }



}
