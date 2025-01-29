class index extends A{

    index(int num, String name){
        super(num, name);
    }
    @Override
    protected void print(){
        System.out.println("num: " + num + ", name: " + name);
    }
    public static void main(String[] args) {
        index obj = new index(10, "John");
        obj.print();
    }
} 