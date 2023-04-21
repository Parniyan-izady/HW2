
import java.util.Scanner;

public class Menus {
    Scanner scanner = new Scanner(System.in);
    Flights flights = new Flights();
    Passengers passengers = new Passengers(flights);
    Admin admin = new Admin(flights);
    public void menu()
    {
        while (true)
        {
            int a = 20;
            int b = 20;
            System.out.println();
            showFirstMenu();
            System.out.print(">>");
            a = scanner.nextInt();
            if(a == 1)
            {
                while ( b != 0) {
                    System.out.println();
                    showEnterPassengerMenu();
                    System.out.print(">>");
                    b = scanner.nextInt();
                    if(b == 1)
                    {
                        int y;
                        y = passengers.passengerSignIn();
                        while (y == 500)
                        {
                            System.out.println("This account doesn't exist");
                            y = passengers.passengerSignIn();
                        }
                        int s = 20 ;
                        while (s != 0)
                        {
                            showPassengerMenuOptions();
                            System.out.print(">>");
                            s = scanner.nextInt();
                            if(s == 1){
                                passengers.passenger[y].changePassengerPassword();
                            }
                            else if(s == 2){
                                passengers.passenger[y].searchFlightTicket();
                            }
                            else if(s == 3){
                                passengers.passenger[y].bookingTicket();
                            }
                            else if(s == 4){
                                passengers.passenger[y].ticketCancellation();
                            }
                            else if(s == 5){
                                passengers.passenger[y].showBookedTickets();
                            }
                            else if(s == 6){
                                passengers.passenger[y].addCharge();
                            }
                        }
                    }
                    else if(b == 2)
                    {
                        passengers.passengerSignUp();
                    }
                }
            }
            else if(a == 2) {
                int p = 20;
                admin.adminSignIn(p);
                int x = 10 ;
                while (x != 0)
                {
                    showAdminMenu();
                    System.out.print(">>");
                    x = scanner.nextInt();
                    if(x == 1)
                    {
                        admin.addFlight();
                    }
                    else if(x == 2)
                    {
                        admin.updateFlight();
                    }
                    else if(x == 3)
                    {
                        admin.removeFlight();
                    }
                    else if(x == 4)
                    {
                        admin.flightSchedules();
                    }
                }
            }
        }
    }
    public void showFirstMenu()
    {
        System.out.println("""
                -------------------------------------
                WELCOME TO AIRLINE RESERVATION SYSTEM
                -------------------------------------
                1> Passenger
                2> Admin""");
    }
    public void showEnterPassengerMenu(){
        System.out.println("""
                -------------------------------------
                          Passenger Menu
                -------------------------------------
                1> Sign in
                2> Sign up     
                0> Return to previous menu
                -------------------------------------""");
    }
    public void showAdminMenu(){
        System.out.println("""
                -------------------------------------
                            Admin Menu
                -------------------------------------
                1> Add
                2> Update
                3> Remove
                4> Flight Schedules
                0> Sign out
                -------------------------------------""");
    }
    public void showPassengerMenuOptions(){
        System.out.println("""
                -------------------------------------
                         Passenger Menu
                -------------------------------------
                1> Change Password
                2> Search Flight Ticket
                3> Booking Ticket
                4> Ticket Cancellation
                5> Booked Tickets
                6> Add charge
                0> Sign out
                -------------------------------------""");
    }
}
