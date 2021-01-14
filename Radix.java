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

    public static void merge( SortableLinkedList original, SortableLinkedList[]buckets){
        for(int i = 0; i <buckets.length;i++){
            original.extend(buckets[i]);
        }
    }

    public static void radixSortSimple(SortableLinkedList data){
        //initialize buckets
        SortableLinkedList[] buckets = new SortableLinkedList[10];
        for(int i = 0; i < buckets.length;i++){
            buckets[i] = new SortableLinkedList();
        }

        int length = 0;
        //fill in the buckets
        while(data.size() != 0){
            int iteration = data.remove(0);
            buckets[nth(iteration,0)].add(iteration);
            if (length(iteration) > length){
                length = length(iteration)-1;
            }
        }

        for(int i = 1; i <= length;i++){

            int[] originalSizes = new int[10];
            for (int z = 0; z < 10; z++) {
                originalSizes[z] = buckets[z].size();
            }

            for(int bucketNum = 0; bucketNum < buckets.length;bucketNum++){
                    int originalSize = originalSizes[bucketNum];
                    for(int bucketIter = 0; bucketIter < originalSize;bucketIter++){
                        int iteration = buckets[bucketNum].remove(0);
                        buckets[nth(iteration, i)].add(iteration);
                    }
            }
        }

        merge(data, buckets);
    }

}