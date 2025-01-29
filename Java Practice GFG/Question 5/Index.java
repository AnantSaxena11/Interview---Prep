class Biggest{
    private int [] arr;
    public Biggest(int []arr)
    {
        this.arr = arr;
    }

    public int findBiggest()
    {
        int max = Integer.MIN_VALUE;
        for(int i = 0;i<arr.length;i++)
        {
            max = Math.max(arr[i],max);
        }
        return max;
    }
}

public class Index {
    public static void main(String[] args) {
        int []arr = new int[]{1,2,3,4,5,6,7,8,9,0};
        Biggest big = new Biggest(arr);
        System.out.println("Biggest number in the array is : "+big.findBiggest());
    }
    
}
