package itogHash;

public class Teatr {
    private final int hooks;
    private final Node[] buckets;

    private static class Node {
        int item;
        Node next;

        Node(int item, Node next) {
            this.item = item;
            this.next = next;
        }
    }

    public Teatr(int hooks) {
        this.hooks = hooks;
        this.buckets = new Node[hooks];
    }

    public boolean hang(int item) {
        int h = Math.floorMod(item, hooks);

        for (Node cur = buckets[h]; cur != null; cur = cur.next) {
            if (cur.item == item) return false;
        }

        buckets[h] = new Node(item, buckets[h]);
        return true;
    }

    public boolean take(int item) {
        int h = Math.floorMod(item, hooks);

        Node prev = null;
        Node cur = buckets[h];
        while (cur != null) {
            if (cur.item == item) {
                if (prev == null) buckets[h] = cur.next;
                else              prev.next = cur.next;
                return true;
            }
            prev = cur;
            cur = cur.next;
        }
        return false;
    }

    public boolean has(int item) {
        int h = Math.floorMod(item, hooks);
        for (Node cur = buckets[h]; cur != null; cur = cur.next) {
            if (cur.item == item) return true;
        }
        return false;
    }

    public void print() {
        for (int i = 0; i < hooks; i++) {
            System.out.printf("Крючок %d: ", i);
            if (buckets[i] == null) {
                System.out.println(" ");
                continue;
            }
            for (Node cur = buckets[i]; cur != null; cur = cur.next) {
                System.out.print(cur.item);
                if (cur.next != null) System.out.print(" -> ");
            }
            System.out.println();
        }
    }
}
