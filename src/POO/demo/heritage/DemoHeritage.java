package POO.demo.heritage;

public class DemoHeritage {

    public static void main(String[] args) {

        Article article1 = new Vetement("o","ax",0,0,"");
        Article article2 = new Velo("","",1,1);

        article1.presenter();

        System.out.println(article1);

        VeloDeCourse vdc = new VeloDeCourse("", "bobinet", 0, 0);
        vdc.presenter();
    }
}
