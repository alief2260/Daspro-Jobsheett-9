import java.util.Scanner;

public class Tugas2kafe05 {

    // Linear search: mengembalikan indeks menu, atau -1 jika tidak ditemukan
    static int cariMenu(String[] menu, String nama) {
        for (int i = 0; i < menu.length; i++) {
            if (menu[i].equalsIgnoreCase(nama.trim())) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String[] menu = {"Nasi Goreng", "Mie Goreng", "Roti Bakar", "Kentang Goreng",
                "Teh Tarik", "Cappucino", "Chocolate Ice"};
        int[] harga = {15000, 13000, 10000, 12000, 8000, 18000, 20000};

        // Menampilkan daftar menu
        System.out.println("===== MENU KAFE KAMPUS =====");
        for (int i = 0; i < menu.length; i++) {
            System.out.printf("%d. %-15s Rp %d%n", (i + 1), menu[i], harga[i]);
        }

        String lagi;
        do {
            System.out.print("\nCari menu (ketik nama): ");
            String cari = input.nextLine();
            int idx = cariMenu(menu, cari);
            if (idx != -1) {
                System.out.println("Menu ditemukan: " + menu[idx] + " - Rp " + harga[idx]);
            } else {
                System.out.println("Maaf, menu \"" + cari + "\" tidak tersedia.");
            }
            System.out.print("Cari menu lagi? (y/n): ");
            lagi = input.nextLine();
        } while (lagi.equalsIgnoreCase("y"));

        int jumlah;
        do {
            System.out.print("\nMasukkan jumlah item yang ingin dipesan: ");
            jumlah = Integer.parseInt(input.nextLine().trim());
            if (jumlah <= 0) {
                System.out.println("Jumlah harus lebih dari 0!");
            }
        } while (jumlah <= 0);

        String[] pesanan = new String[jumlah];   // array pesanan, terpisah dari array menu
        int total = 0;

        for (int i = 0; i < jumlah; i++) {
            int idx;
            do {
                System.out.print("Pesanan ke-" + (i + 1) + " (nama menu): ");
                String nama = input.nextLine();
                idx = cariMenu(menu, nama);
                if (idx == -1) {
                    System.out.println("Menu tidak ada dalam daftar, silakan ulangi.");
                }
            } while (idx == -1);

            pesanan[i] = menu[idx];
            total += harga[idx];
        }

        System.out.println("\n========== RINCIAN PESANAN ==========");
        System.out.printf("%-4s %-18s %10s%n", "No", "Menu", "Harga");
        System.out.println("-------------------------------------");
        for (int i = 0; i < jumlah; i++) {
            int idx = cariMenu(menu, pesanan[i]);
            System.out.printf("%-4d %-18s Rp %7d%n", (i + 1), pesanan[i], harga[idx]);
        }
        System.out.println("-------------------------------------");
        System.out.printf("%-23s Rp %7d%n", "TOTAL BIAYA", total);
        System.out.println("=====================================");

        input.close();
    }
}