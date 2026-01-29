class MetroTicket {
    String name, source, destination, seatClass, discount;
    boolean roundTrip;

    MetroTicket(String n, String s, String d) {
        this(n, s, d, false, "Regular", "");
    }

    MetroTicket(String n, String s, String d, boolean r) {
        this(n, s, d, r, "Regular", "");
    }

    MetroTicket(String n, String s, String d, boolean r, String seat) {
        this(n, s, d, r, seat, "");
    }

    MetroTicket(String n, String s, String d, boolean r, String seat, String dis) {
        name = n;
        source = s;
        destination = d;
        roundTrip = r;
        seatClass = (seat.equals("Premium")) ? "Premium" : "Regular";
        discount = dis;
    }

    double calculateFare() {
        double fare;

        if (!roundTrip)
            fare = seatClass.equals("Premium") ? 150 : 100;
        else
            fare = seatClass.equals("Premium") ? 270 : 180;

        if (discount.equals("DIS10"))
            fare *= 0.9;

        return fare;
    }

    void displayTicketDetails() {
        System.out.println(name + " | " + source + " -> " + destination);
        System.out.println("Seat: " + seatClass + " | Round: " + roundTrip);
        System.out.println("Fare: " + calculateFare());
        System.out.println();
    }
}

public class Main {
    public static void main(String[] args) {
        MetroTicket t1 = new MetroTicket("A", "Dhaka", "Mirpur");
        MetroTicket t2 = new MetroTicket("B", "Uttara", "Banani", true);
        MetroTicket t3 = new MetroTicket("C", "Farmgate", "Gulshan", false, "Premium");
        MetroTicket t4 = new MetroTicket("D", "Motijheel", "Airport", true, "Premium", "DIS10");

        t1.displayTicketDetails();
        t2.displayTicketDetails();
        t3.displayTicketDetails();
        t4.displayTicketDetails();
    }
}
