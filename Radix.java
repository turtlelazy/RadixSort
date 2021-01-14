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
        for(int i = 0; i < data.size(); i ++){
            int iteration = data.remove(i);
            buckets[nth(iteration,0)].add(iteration);
            if (length(iteration) > length){
                length = length(iteration);
            }
        }

        for(int i = 1; i <= length;i++){
            for(int bucketNum = 0; bucketNum < buckets.length;bucketNum++){
                    for(int bucketIter = 0; bucketIter < buckets[bucketNum].size();bucketIter++){
                        int iteration = buckets[bucketNum].remove(bucketIter);
                        buckets[nth(iteration, i)].add(iteration);
                    }
            }
        }

        merge(data, buckets);
    }

}