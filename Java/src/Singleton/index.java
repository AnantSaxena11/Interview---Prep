package src.Singleton;

public class index{

    private index()
    {
        // class which has only one instance is singleton
    }

    private  static index  instance;

    public static index getInstance()
    {
        return instance;
    }

}