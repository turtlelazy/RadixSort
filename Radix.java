public class Radix{
    public static int nth(int n, int col){
        /*
        //Original nth method
        int modulo = n + 0; //copying without reference
        int power = 1;

        for(int i = 0; i < col; i++){
            power *= 10;
        }
        modulo /= power;

        return modulo % 10;
        */

        //new nth method although unsure if it works that well
        int input = n + 0;
        if(input < 0) {input *= -1;}
        String numberAsString = input + "";
        char digit = numberAsString.charAt(numberAsString.length()-(col+1));
        int returnDigit = digit - 48;

        return returnDigit;
    }

    public static int length(int n){
        int a = n + 0;
        
        if(a<0){
            a *= -1;
        }
        int length = 1;
        while(a>9){
            length ++;
            a/= 10;
        }

        return length;
    }

    public static void merge(MyLinkedList original, MyLinkedList[] buckets){
        for(int i = 0; i <buckets.length;i++){
            original.extend(buckets[i]);
        }
    }

}