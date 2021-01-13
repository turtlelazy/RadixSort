public class Radix{
    public static int nth(int n, int col){
        if (n < 0) {n *= -1;}
        int place = (int) Math.pow(10, col);
        return (n / place)%10; 

    }

    public static int length(int n){
        if(n == 0) {return 1;}
        if(n<0) {n *= -1;}
        return (int) Math.log10(n)+1;
    }

    public static void merge(MyLinkedList original, MyLinkedList[] buckets){
        for(int i = 0; i <buckets.length;i++){
            original.extend(buckets[i]);
        }
    }

}