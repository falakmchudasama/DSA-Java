import java.util.PriorityQueue;

public class PQClass {
    static class Student implements Comparable<Student> {
        String name;
        int rank;
        int age;

        public Student(String str, int n1, int n2){
            this.name = str;
            this.rank = n1;
            this.age = n2;
        }

        @Override
        public int compareTo(Student s2){
            return this.rank - s2.rank;
        }
    }
    public static void main(String[] args) {
        PriorityQueue<Student> pq = new PriorityQueue<>();

        Student student1 = new Student("Alwin", 500, 15);
        pq.add(student1);

        Student student2 = new Student("Naomi", 150, 19);
        pq.add(student2);

        Student student3 = new Student("Karen", 10, 20);
        pq.add(student3);

        Student student4 = new Student("Eric", 900, 13);
        pq.add(student4);

        while(!pq.isEmpty()){
            System.out.println(pq.peek().name + " -> " + pq.peek().rank);
            pq.remove();
        }
    }
}
