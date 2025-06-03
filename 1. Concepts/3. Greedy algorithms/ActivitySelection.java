import java.util.*;

public class ActivitySelection {
    public static void main(String[] args) {
        int start[] = {1,3,0,5,8,5};
        int end[] = {2,4,6,7,9,9};

        int maxAct = 0;
        ArrayList<Integer> activities = new ArrayList<>();

        activities.add(0);
        maxAct++;

        int lastEnd = end[0];

        for(int i = 1; i < end.length; i++){
            if(start[i] >= lastEnd){
                maxAct++;
                activities.add(i);
                lastEnd = end[i];
            }
        }
        System.out.println(maxAct);
        System.out.println(activities);
    }
}
