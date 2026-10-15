import itogHash.LockerRoom;
import itogHash.Shop;
import itogHash.Teatr;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {
    Shop shop=new Shop();
    shop.addCar(1);
    shop.addPark();
    shop.addCar(3);
    shop.addPark();
    shop.addCar(5);
    shop.addPark();
    shop.addCar(6);
    shop.addPark();
    shop.remove(1);
    System.out.println(shop.toString());

    Teatr g = new Teatr(10);

    int[] clothes = {15, 25, 35, 5, 45, 55, 65, 75, 85, 95, 105};

    for (int c : clothes) {
        int h = Math.floorMod(c, 10);
        boolean ok = g.hang(c);
        System.out.printf("Вещь %d -> крючок %d %s%n",
                c, h, ok ? "" : "(уже висела)");
    }

    System.out.println("\nСостояние гардероба:");

    g.print();
    LockerRoom room = new LockerRoom(7);

    int[] clients = {15, 25, 35, 5, 45, 55, 65, 75, 85, 95, 105};

    for (int c : clients) {
        int locker = room.addClient(c).addLocker();
        int h1 = Math.floorMod(c, 10);
        if (locker >= 0) {
            System.out.printf("Клиент %d (h1=%d) -> шкафчик %d%n", c, h1, locker);
        } else {
            System.out.printf("Всё занято");
        }
    }

    System.out.println("\n" + room);

    room.remove(35);

    System.out.println("5  = " + room.find(5));
    System.out.println("35 = " + room.find(35));
}

