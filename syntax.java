class syntax {
    public static int check_syntax(String[][] str, String[] last) {
        int cnt = 0;
        
        String[] key = {"abstract", "assert", "boolean", "break", "byte", "case", "catch", "char", "class", "continue",
                        "default", "do", "double", "else", "enum", "extends", "final", "finally", "float", "for", "if",
                        "implements", "import", "instanceof","int", "interface", "long", "native", "new", "null", "package",
                        "private", "protected", "public", "return", "short","static", "strictfp", "super", "switch", 
                        "synchronized", "this", "throw", "throws", "transient", "try", "void", "volatile", "while"}; 
        
        for (int i = 0; i < str.length; i++) {
            
            if (str[i][0].equals("int") || str[i][0].equals("string")) {}
            else {
                cnt++;
            }
            
            for (int j = 0; j < key.length; j++) {
                if (key[j].equals(str[i][1])) cnt++;
            }
            
            if (str[i][3].charAt(0) > 47 & str[i][3].charAt(0) < 58) {
                if (check_number(str[i][3]).equals("error")) cnt++;
            } else if (str[i][3].charAt(0) == '"') {
                if (check_string(str[i][3]).equals("error")) cnt++;
            } else {
                cnt++;
            }
        }

        
        //last string
        String[] array = new String[last.length / 2 + 1]; 
        int idx = 0;
        for (int i = 0; i < last.length; i++) {
            if (i % 2 == 0) {
                array[idx++] = last[i];
            }
        }
        //str string
        String[] array_str = new String[str.length]; 
        int idx_str = 0;
        for (int i = 0; i < str.length; i++) {
            array_str[idx_str++] = str[i][1];
        }
        
        
        // check
        for (int i = 0; i < array.length; i++) {
            int x = 0;
            for (int j = 0; j < array_str.length; j++) {
                if (!array[i].equals(array_str[j])) x++;
            }
            if (x == array_str.length) cnt++;

        }
        return cnt;
    }
    
    public static String check_number(String str) {
        int cnt = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) > 47 & str.charAt(i) < 58) cnt++;
        }
        if (cnt == str.length()) return "true";
        return "error";
    }
    
    public static String check_string(String str) {
        if (str.charAt(0) == '"' && str.charAt(str.length() - 1) == '"') return "true";
        return "error";
    }
    
}