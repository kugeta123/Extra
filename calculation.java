import java.util.HashMap;
public class calculation {
    public static int calcuate(String[][] str, String[] last) {
        //map (name with corresponding value) 
        HashMap<String, String> map = new HashMap<>(); 
        int idx_str = 0;
        for (int i = 0; i < str.length; i++) {
            map.put(str[i][1], str[i][3]);
        }
        
        int tmp = Integer.parseInt(map.get(last[0]));
        String op = "";
        
        for (int i = 1; i < last.length; i++) { 
            if (i % 2 == 1) op = last[i];
            if (i % 2 == 0) tmp = expr.int_expression(tmp, Integer.parseInt(map.get(last[i])), op);      
        }
        return tmp;
    }
}
