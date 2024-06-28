import java.util.Scanner;

public class CreationAccount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        String[] events = {
            "Day 1: God creates light, separating light from darkness (Day and Night) - Genesis 1:3-5",
            "Day 2: God creates the sky, separating waters above from waters below - Genesis 1:6-8",
            "Day 3: God gathers waters to create dry land (Earth) and seas, and makes vegetation (plants and trees) - Genesis 1:9-13",
            "Day 4: God creates the sun, moon, and stars to give light to the Earth and to separate day from night - Genesis 1:14-19",
            "Day 5: God creates sea creatures and birds - Genesis 1:20-23",
            "Day 6: God creates land animals and humans (male and female), giving them dominion over the earth - Genesis 1:24-31",
            "Day 7: God rests, blessing and sanctifying the seventh day - Genesis 2:1-3"
        };
        
        while (true) {
            System.out.println("Enter a day of the creation week (1-7) or 0 to exit:");
            int day = scanner.nextInt();
            
            if (day == 0) {
                break;
            } else if (day >= 1 && day <= 7) {
                System.out.println(events[day - 1]);
            } else {
                System.out.println("Invalid day. Please enter a number between 1 and 7.");
            }
            
            System.out.println("Do you want the verse reference? (yes/no)");
            scanner.nextLine(); // Consume newline left-over
            String response = scanner.nextLine();
            
            if (response.equalsIgnoreCase("yes")) {
                System.out.println(events[day - 1].split(" - ")[1]);
            }
        }
        
        scanner.close();
    }
}