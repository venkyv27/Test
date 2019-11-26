package playground;

public class JavaPlayground {

    public static void main(String[] args){

        System.out.println("Hello There");
        System.out.println(Person.N_EYES);// calling a final int on Person, which does no require an instance
        //because this is a class level field that does not require specific instances

    }

    class Person{
        public static final int N_EYES = 2;
    }
}
