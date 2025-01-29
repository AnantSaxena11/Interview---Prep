package OOPS.properties.inheritance;

public class BoxWeight extends Box{
    double weight;
    BoxWeight(double l ,double h, double w,double weight)
    {
        super(l,h,w);
        this.weight = weight; 
    }
}
