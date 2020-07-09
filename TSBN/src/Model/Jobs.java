package Model;

import java.io.IOException;
import java.util.ArrayList;

public class Jobs {
        private static Jobs Instance = new Jobs();
        private static ArrayList<Job> jobs_list= new ArrayList<Job>(); //create a list of jobs

        private Jobs() {

        }

        public static Jobs getMySingelton() { // create singleton and initialize it

            if(jobs_list.size()==0) {
                Job job1=new Job(1,"Name_1");
                Job job2=new Job(2,"Name_2");
                Job job3=new Job(3,"Name_3");
                Job job4=new Job(4,"Name_4");
                Job job5=new Job(5,"Name_5");
                jobs_list.add(job1);
                jobs_list.add(job2);
                jobs_list.add(job3);
                jobs_list.add(job4);
                jobs_list.add(job5);
            }return Instance;
        }

       public void addJob(Job new_job) {
            jobs_list.add(new_job);
        } // add new job to the list

        public void removeJob(Job remove_job) throws IOException { //remove job from the list
            jobs_list.remove(remove_job);

        }
        public Job searchingJobById(int ID) { // search job in the list by id
            for (int i = 0; i < this.jobs_list.size(); i++)
                if (jobs_list.get(i).getJob_ID() == ID)
                    return jobs_list.get(i);
            return null;
        }

        public Boolean SearchingJobBool(int ID) { // search job in the list by id, return boolean
            Jobs jobs_list = Jobs.getMySingelton();
            for (int i = 0; i < jobs_list.getSize(); i++)
                if (jobs_list.getJob_i(i).getJob_ID() == ID)
                    return true;
            return false;
        }

        public int getSize() {
            return jobs_list.size();
        }

        public Job getJob_i(int i) {
            return jobs_list.get(i);
        }

        public void setJob_List_i(int i, Job new_job) {
            jobs_list.set(i, new_job);
        }


}
