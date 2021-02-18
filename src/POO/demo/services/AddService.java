package POO.demo.services;

public class AddService {

    private static AddService instance;
    public static AddService getInstance(){
        if(instance == null) {
            instance = new AddService();
            return instance;
        }
        else
            return instance;
    }
    private AddService(){}

    public int addition(int a, int b){
        return a + b;
    }

}
