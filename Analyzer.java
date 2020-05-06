import java.util.*;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

class Analyzer {
    public static void main(String[] args) {
        BufferedReader br = null;
        String line;
        StringBuilder sb = new StringBuilder();
        
        try {
            br = new BufferedReader(new FileReader("E:/GSU/2nd/PLC/test.txt"));
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        String string = sb.toString();

    	Analyzer analysis = new Analyzer();
    	
    	int row = 0;
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == ';') row++;
        }
        String[][] str = analysis.array(string, row);
        String[] last = analysis.array_alter(string, row);
        
        int cnt_lexical = lexical.check_lexical(str, last);
        int cnt_syntax = syntax.check_syntax(str, last);
        int cnt_semantic = semantic.check_semantic(str, last);
        
        if (cnt_lexical == 0 && cnt_syntax == 0 && cnt_semantic == 0) {
            System.out.println("No error"); 
            int x = 0;
            for (int i = 0; i < str.length; i++) {
                if (str[i][0].equals("int")) x++;
            }
            if (x == str.length) {
                int result = calculation.calcuate(str, last);
                System.out.println("the calculation result is: " + result);
            }
        } else {
            System.out.println("the number of lexical errors: " + cnt_lexical);
            System.out.println("the number of syntax errors: " + cnt_syntax);
            System.out.println("the number of semantic errors: " + cnt_semantic);
        }
        
    }
    
    public String[][] array(String string, int row) {
        String[] array = new String[row];
        int idx = 0;
        int cnt = 0;
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == ';') {
                array[cnt] = string.substring(idx, i);
                idx = i + 1;
                cnt++;
            }
        }
        return twoDarray(array, row);
    }
    
    public String[][] twoDarray(String[] array, int row) {
        String[][] twoDarray = new String[row - 1][4];
        for (int i = 0; i < array.length - 1; i++) {
            int idx = 0;
            int cnt = 0;
            for (int j = 0; j < array[i].length(); j++) {
                char c = array[i].charAt(j);
                if (c == ' ') {
                    twoDarray[i][cnt] = array[i].substring(idx, j);
                    idx = j + 1;
                    cnt++;
                }
            }
            twoDarray[i][cnt] = array[i].substring(idx, array[i].length());
        }
        
        return twoDarray;
    }
    
    public String[] array_alter(String string,int row) {
        String[] array_alter = new String[row];
        int idx = 0;
        int cnt = 0;
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == ';') {
                array_alter[cnt] = string.substring(idx, i);
                idx = i + 1;
                cnt++;
            }
        }
        return Last(array_alter);
    }
    
    public String[] Last(String[] array) {
        int space = 0;
        for (int i = 0; i < array[array.length - 1].length(); i++) {
            char c = array[array.length - 1].charAt(i);
            if (Character.isWhitespace(c)) space++;
        }
        String[] Last = new String[space + 1];
        
        int idx = 0;
        int cnt = 0;
        
        for (int i = 0; i < array[array.length - 1].length() - 1; i++) {
            
            char c = array[array.length - 1].charAt(i);
            if (Character. isWhitespace(c)) {
                Last[cnt] = array[array.length - 1].substring(idx, i);
                idx = i + 1;
                cnt++;
            }
        }
        Last[Last.length - 1] = array[array.length - 1].substring(idx, array[array.length - 1].length());
        return Last;
    }
}
    