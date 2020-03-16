import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Theatre {
    public static void main(String[] args) {
        Account acc = new Account();
        Date date;
        Show show;
        Floor floor;
        Scanner sc1 = new Scanner(System.in);
        System.out.println("Enter U to sign up, I to sign in and X to exit");

        if (sc1.hasNext()) {
            String letter = sc1.next();
            while (!letter.equals("X")) {
                if (letter.equals("U")) {
                    System.out.println("Enter a unique ID: ");
                    String id = sc1.next();

                    System.out.println("Enter a password: ");
                    String pw = sc1.next();

                    acc.signUp(id, pw);
                    System.out.println("You have successfully signed up. Now enter I to sign in or X to exit");
                    letter = sc1.next();

                }
                if (letter.equals("I")) {
                    System.out.println("Enter your ID: ");
                    String id = sc1.next();

                    System.out.println("Enter your password: ");
                    String pw = sc1.next();


                    if (acc.signIn(id, pw)) {
                        System.out.println("Welcome!");
                        System.out.println("Enter R to reserve, V to view, C to cancel and O to sign out");
                        if (sc1.next().equals("R")) {
                            System.out.println("Enter the year 2020 or 2021 for which you'd like to reserve");
                            int year = sc1.nextInt();
                            int day = 1;
                            if (year != 2020 && year != 2021) {
                                System.out.println("You can only reserve for either 2020 or 2021");
                            } else {
                                System.out.println("For month, enter 11 for December and 0 for January");
                                int month = sc1.nextInt();
                                if (month != 0 && month != 11) {
                                    System.out.println("You can only reserve for either December or January");
                                } else {
                                    if (month == 11) {
                                        System.out.println("Enter the day between 23 to 31 for which you'd like to reserve");
                                        day = sc1.nextInt();
                                        if (day < 23 || day > 31) {
                                            System.out.println("Invalid date. Please choose a valid date between 23 to 31");
                                        }
                                    } else if (month == 0) {
                                        System.out.println("Enter the day between 1 to 2 for which you'd like to reserve");
                                        day = sc1.nextInt();
                                        if (day < 1 || day > 2) {
                                            System.out.println("Invalid date. Please choose a valid date between 1 and 2");
                                        }
                                    }

                                    System.out.println("Would you like to reserve a 6:30 show or 8:30 show?");
                                    System.out.println("Enter hour");
                                    int hour = sc1.nextInt();
                                    int min = 30;
                                    if (hour != 6 && hour != 8) {
                                        System.out.println("Invalid time. Choose either 6 or 8");
                                    } else {
                                        date = new Date(year, month, day, hour, min);
                                        if (hour == 6) {
                                            System.out.println("You've chosen show A");
                                        } else if (hour == 8) {
                                            System.out.println("You've chosen show B");
                                        }
                                        show = new Show();
                                        ArrayList all_Avail_Seats = show.displayAvailableSeats();
                                        System.out.println(all_Avail_Seats);

                                        System.out.println("Enter seat number/s");
                                        ArrayList seat = new ArrayList();
                                        String name = "";
                                        String num = "";

                                        while (sc1.hasNext()) {
                                            seat.add(sc1.nextInt());
                                        }
                                        ArrayList<String> names = new ArrayList<>();
                                        ArrayList<String> seatNum = new ArrayList<>();
                                        for (Object o : seat) {
                                            String s = (String) o;
                                            int i = 0;
                                            while (!Character.isDigit(s.charAt(i))) {
                                                i++;
                                            }
                                            name = s.substring(0, i);
                                            names.add(name);
                                            num = s.substring(i);
                                            seatNum.add(num);
                                        }
                                        for (String n : names) {
                                            floor = new Floor();
                                            if (show.checkAvailabiility(seat)) {
                                                System.out.println("Entered seats are available. Please wait while we reserve");
//                                                floor.reserve(seat);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            System.out.println("You have exited the program");
        }
    }
}
