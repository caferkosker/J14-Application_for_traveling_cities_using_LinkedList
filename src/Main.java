import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;
public class Main {

    public static void write_transactation(){

        System.out.println("0 - View Transactions");
        System.out.println("1 - Go to The Next City");
        System.out.println("2 - Go to Previous City");
        System.out.println("3 - Exit The Application");
    }
    public static void travellingTheCities(LinkedList<String> cities){
        ListIterator<String> iterator = cities.listIterator();

        write_transactation();
        Scanner scanner = new Scanner(System.in);

        if(!iterator.hasNext()){
            System.out.println("There is no city...");
        }
        boolean exit = false;
        boolean next = true;
        while (!exit){
            System.out.println("Please choose a transactation : ");

            int islem = scanner.nextInt();
            switch (islem){
                case 0:
                    write_transactation();
                    break;
                case 1:
                    if(!next){
                        if(iterator.hasNext()){
                            iterator.next();
                        }
                        next = true;
                    }
                    if (iterator.hasNext()){
                        System.out.println("Going to the city : " + iterator.next());
                    }
                    else {
                        System.out.println("There is no city left to visit...");
                        next = true;
                    }
                    break;
                case 2:
                    if(next){
                        if (iterator.hasPrevious()){
                            iterator.previous();
                        }
                        next = false;
                    }
                    if (iterator.hasPrevious()){
                        System.out.println("Going to the city : " + iterator.previous());
                    }
                    else {
                        System.out.println("City tour started...");
                    }
                    break;
                case 3:
                    exit = true;
                    System.out.println("Exiting the application...");
                    break;


            }

        }

    }
    public static void main(String[] args) {
        LinkedList<String> cities = new LinkedList<String>();

        cities.add("Ankara");
        cities.add("Konya");
        cities.add("Istanbul");
        cities.add("Eskişehir");
        cities.add("Afyon");
        cities.add("Adana");
        travellingTheCities(cities);

    }
}