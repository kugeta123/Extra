class lexical {
    public static int check_lexical(String[][] str, String[] last) {
        int cnt = 0;
        for (int i = 0; i < str.length; i++) {
            if (str[i][0].length() == 3 && !str[i][0].equals("int")) {
                if (check_sam(str[i][0], "int").equals("true")) cnt++; 
            }
            if (str[i][0].length() == 5 && !str[i][0].equals("float")) {
                if (check_sam(str[i][0], "float").equals("true")) cnt++;
            }
        }
        return cnt;
    }
        
    public static String check_sam(String stringA, String stringB) {
	int lenA = stringA.length();
	int lenB = stringB.length();
	if(lenA != lenB){
	    return "error";
	}
			
	int[] strA = new int[256];
	int[] strB = new int[256];
	for(int i = 0; i < lenA; i++){
	    strA[stringA.charAt(i)]++;
	    strB[stringB.charAt(i)]++;
	}
			
	for(int i = 0;i<256;i++){
	    if(strA[i]!=strB[i]){
		 return "error";
	    }
	}
	return "true";
    }
}

