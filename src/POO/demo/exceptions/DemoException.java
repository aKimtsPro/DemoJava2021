package POO.demo.exceptions;

public class DemoException {

    public static void main(String[] args) {
        try {
            System.out.println(2 / 0);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Je continue à fonctionner !!!");

        catchException();

    }

    private static void catchException() {
        try {
            launchException();
        } catch (NombrePairException e) {
            System.out.println(e.getClass().getSimpleName() + " : " + e.getMessage());
        } finally {
            System.out.println("Je passe toujours par ici !!!");
        }
    }

    public static int[] ints = {1, 2, 3, 4, 5, 6, 7, 8, 9};

    private static void launchException() throws NombrePairException {

        for (int value : ints) {
            if (value % 11 == 0) {
                throw new NombrePairException(String.valueOf(value));
            }

            System.out.println(value);
        }
    }
}
