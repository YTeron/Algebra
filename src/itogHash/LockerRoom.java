package itogHash;

public class LockerRoom {
    public final Integer[] masiv = new Integer[10];
    private final int P;
    private int client;

    public LockerRoom(int P) {
        if (P <= 0 || P >= masiv.length || gcd(P, masiv.length) != 1) {
            throw new IllegalArgumentException(
                    "P должно быть взаимно просто с " + masiv.length);
        }
        this.P = P;
    }

    public LockerRoom addClient(int client) {
        this.client = client;
        return this;
    }

    public int addLocker() {
        int h1 = Math.floorMod(client, masiv.length);

        for (int i = 0; i < masiv.length; i++) {
            int pos = (h1 + i * P) % masiv.length;
            if (masiv[pos] == null) {
                masiv[pos] = client;
                return pos;
            }
        }
        return -1;
    }

    public boolean remove(int client) {
        int h1 = Math.floorMod(client, masiv.length);

        for (int i = 0; i < masiv.length; i++) {
            int pos = (h1 + i * P) % masiv.length;
            if (masiv[pos] == null) return false;
            if (masiv[pos] == client) {
                masiv[pos] = -1;
                return true;
            }
        }
        return false;
    }

    public int find(int client) {
        int h1 = Math.floorMod(client, masiv.length);

        for (int i = 0; i < masiv.length; i++) {
            int pos = (h1 + i * P) % masiv.length;
            if (masiv[pos] == null) return -1;
            if (masiv[pos] != -1 && masiv[pos] == client) return pos;
        }
        return -1;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Шкафчики (P=" + P + "):\n");
        for (int i = 0; i < masiv.length; i++) {
            String v = (masiv[i] == null) ? "— свободен —"
                    : (masiv[i] == -1)   ? "× удалён ×"
                    : String.valueOf(masiv[i]);
            sb.append(String.format("  [%d] %s%n", i, v));
        }
        return sb.toString();
    }

    private static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
