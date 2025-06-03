public class MoveXToEnd {
    public static StringBuilder moveXToEnd(StringBuilder str, int i, StringBuilder x){
        if(i >= str.length()-1){
            str.append(x);
            return str;
        }
        if(str.charAt(i) == 'x'){
            str.deleteCharAt(i);
            x.append('x');
            return moveXToEnd(str, i, x);
        }
        return moveXToEnd(str, i+1, x);
    }
    public static void main(String[] args) {
        System.out.println( moveXToEnd(new StringBuilder("axxbdxcefxhix"), 0, new StringBuilder()) );
    }
}
