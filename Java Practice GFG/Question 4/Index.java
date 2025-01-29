class SeriesCalculator{
    private int n;
    public SeriesCalculator(int n){
        this.n = n;
    }
    public int  calculateSum()
    {
        int sum =  (n/2) * (2*1+(n-1)*2);
        return sum ;
    }

}
public class Index {
    public static void main(String[] args) {
        SeriesCalculator cal = new SeriesCalculator(10);
        System.out.println("Sum of the series is : "+cal.calculateSum());
        
    }    
}
