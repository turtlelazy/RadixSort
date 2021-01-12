public class Radix{
    public static int nth(int n, int col){
        int modulo = n + 0; //copying without reference
        int power = 1;

        for(int i = 0; i < col; i++){
            power *= 10;
        }
        modulo /= power;

        return modulo % 10;
    }

}