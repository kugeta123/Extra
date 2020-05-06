class expr {
    public static int int_expression(int a, int b, String op) {
        if (op.equals("+")) return add(a, b);
        if (op.equals("-")) return minus(a, b);
        if (op.equals("*")) return multi(a, b);
        if (op.equals("/")) return divide(a, b);
        return 9999;
    }
    
    public static int add (int a, int b) {
        int res=a;
        int xor=a^b;
        int forward=(a&b)<<1;
        if(forward!=0){
            res=add(xor, forward);
        }else{
            res=xor;
        }
        return res; 
    }

    public static int minus(int a,int b) {
        int B=~(b-1);
        return add(a, B);        
    }

    public static int multi(int a,int b){
        int i=0;
        int res=0;
        while(b!=0){
            
            if((b&1)==1){
                res+=(a<<i);
                b=b>>1;
                ++i;
            }else{
                b=b>>1;
                ++i;
            }
        }
        return res;
    }
    
    public static int divide(int a,int b) {
        int res=-1;
        if(a<b){
            return 0;
        }else{
            res= divide(minus(a, b), b)+1;
        }
        return res;
    }
}