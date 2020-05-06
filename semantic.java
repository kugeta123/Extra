class semantic {
    public static int check_semantic(String[][] str, String[] last) {
        int cnt = 0;        
        
        for (int i = 0; i < str.length; i++) {
            if (!str[i][2].equals("=")) cnt++;
        }
        
        for (int i = 0; i < last.length; i++) {
            if (i % 2 == 1) {
                if (last[i].equals("+") || last[i].equals("-") || last[i].equals("*") || last[i].equals("/")) {
                    continue;
                } else {
                    cnt++;
                }
            }
        }
        
        for (int i = 0; i < str.length; i++) {
            if (str[i][0].equals("int")) {
                if (check_number(str[i][3]) == "error") cnt++;
            }
            if (str[i][0].equals("string")) {
                if (check_string(str[i][3]) == "error") cnt++;
            }
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