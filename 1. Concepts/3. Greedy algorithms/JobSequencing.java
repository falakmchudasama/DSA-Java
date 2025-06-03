import java.util.ArrayList;
import java.util.Collections;

public class JobSequencing {
    static class Job {
        int id;
        int deadline;
        int profit;

        public Job(int a, int b, int c){
            id = a;
            deadline = b;
            profit = c;
        }
    }

    public static ArrayList<Integer> jobSequencing(ArrayList<Job> jobs){
        ArrayList<Integer> sequence = new ArrayList<>();
        int time = 0;
        for(int i = 0; i < jobs.size(); i++){
            Job current = jobs.get(i);
            if(current.deadline > time){
                time++;
                sequence.add(current.id);
            }
        }
        return sequence;
    }
    public static void main(String[] args) {
        int jobInfo[][] = {{4,20}, {1,10}, {1,40}, {1,30}};
        ArrayList<Job> jobs = new ArrayList<>();

        for(int i = 0; i < jobInfo.length; i++){
            jobs.add( new Job(i, jobInfo[i][0], jobInfo[i][1]) );
        }

        Collections.sort(jobs, (a,b) -> b.profit - a.profit);
        ArrayList<Integer> sequence = jobSequencing(jobs);
        System.out.println(sequence);

    }
}
