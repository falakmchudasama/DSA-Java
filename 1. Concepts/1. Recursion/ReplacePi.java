public class ReplacePi {
    public static StringBuilder replacePi(StringBuilder str, int i){
        if(i >= str.length()-1){
            return str;
        }
        if(str.charAt(i) == 'p' && str.charAt(i+1) == 'i'){
            str.delete(i,i+2);
            str.insert(i,"3.14");
            return replacePi(str, i+2);
        }
        return replacePi(str, i+1);
    }
    public static void main(String[] args) {
        StringBuilder str = new StringBuilder("piiipppi");
        System.out.println( replacePi(str, 0) );
    }
}