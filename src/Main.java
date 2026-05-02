import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Menu[] daftarMenu = {
                new Menu("Nasi Goreng", 25000, "Makanan"),
                new Menu("Mie Ayam", 20000, "Makanan"),
                new Menu("Ayam Bakar", 30000, "Makanan"),
                new Menu("Nasi Padang", 35000, "Makanan"),
                new Menu("Es Teh", 5000, "Minuman"),
                new Menu("Jus Alpukat", 15000, "Minuman"),
                new Menu("Kopi Hitam", 10000, "Minuman"),
                new Menu("Air Mineral", 4000, "Minuman")
        };

        System.out.println("=== MENU MAKANAN ===");
        System.out.println("1. " + daftarMenu[0].nama + " - " + daftarMenu[0].harga);
        System.out.println("2. " + daftarMenu[1].nama + " - " + daftarMenu[1].harga);
        System.out.println("3. " + daftarMenu[2].nama + " - " + daftarMenu[2].harga);
        System.out.println("4. " + daftarMenu[3].nama + " - " + daftarMenu[3].harga);

        System.out.println("\n=== MENU MINUMAN ===");
        System.out.println("5. " + daftarMenu[4].nama + " - " + daftarMenu[4].harga);
        System.out.println("6. " + daftarMenu[5].nama + " - " + daftarMenu[5].harga);
        System.out.println("7. " + daftarMenu[6].nama + " - " + daftarMenu[6].harga);
        System.out.println("8. " + daftarMenu[7].nama + " - " + daftarMenu[7].harga);

        int[] pilihan = new int[4];
        int[] jumlah = new int[4];

        System.out.println("\nMasukkan pesanan (maks 4):");

        System.out.print("Pesanan 1 (nomor menu): ");
        pilihan[0] = input.nextInt();
        System.out.print("Jumlah: ");
        jumlah[0] = input.nextInt();

        System.out.print("Pesanan 2 (nomor menu): ");
        pilihan[1] = input.nextInt();
        System.out.print("Jumlah: ");
        jumlah[1] = input.nextInt();

        System.out.print("Pesanan 3 (nomor menu): ");
        pilihan[2] = input.nextInt();
        System.out.print("Jumlah: ");
        jumlah[2] = input.nextInt();

        System.out.print("Pesanan 4 (nomor menu): ");
        pilihan[3] = input.nextInt();
        System.out.print("Jumlah: ");
        jumlah[3] = input.nextInt();

        if (pilihan[0] != 0) {
            switch (pilihan[0]) {
                case 1:
                    System.out.println("Anda memilih Nasi Goreng");
                    break;
                case 5:
                    System.out.println("Anda memilih Es Teh");
                    break;
                default:
                    System.out.println("Pilihan lainnya");
            }
        }

        int harga1 = (pilihan[0] == 0) ? 0 : daftarMenu[pilihan[0] - 1].harga * jumlah[0];
        int harga2 = (pilihan[1] == 0) ? 0 : daftarMenu[pilihan[1] - 1].harga * jumlah[1];
        int harga3 = (pilihan[2] == 0) ? 0 : daftarMenu[pilihan[2] - 1].harga * jumlah[2];
        int harga4 = (pilihan[3] == 0) ? 0 : daftarMenu[pilihan[3] - 1].harga * jumlah[3];

        int subtotal = harga1 + harga2 + harga3 + harga4;

        int totalMinuman = 0;
        if (pilihan[0] != 0 && daftarMenu[pilihan[0] - 1].kategori.equals("Minuman"))
            totalMinuman += jumlah[0];
        if (pilihan[1] != 0 && daftarMenu[pilihan[1] - 1].kategori.equals("Minuman"))
            totalMinuman += jumlah[1];
        if (pilihan[2] != 0 && daftarMenu[pilihan[2] - 1].kategori.equals("Minuman"))
            totalMinuman += jumlah[2];
        if (pilihan[3] != 0 && daftarMenu[pilihan[3] - 1].kategori.equals("Minuman"))
            totalMinuman += jumlah[3];

        int subtotalAsli = subtotal;

        double diskon = 0;
        if (subtotalAsli > 100000) {
            diskon = 0.1 * subtotalAsli;
        }

        int gratisMinuman = 0;
        int hargaMinumanTermurah = 4000;
        int potonganPromo = 0;

        if (subtotalAsli > 50000) {
            gratisMinuman = totalMinuman / 2;
            potonganPromo = gratisMinuman * hargaMinumanTermurah;
        }

        if (subtotalAsli > 50000) {
            if (totalMinuman > 0) {
                System.out.println("Promo minuman aktif");
            }
        }

        double setelahDiskon = subtotalAsli - diskon;
        double setelahPromo = setelahDiskon - potonganPromo;
        double pajak = 0.1 * setelahPromo;
        int service = 20000;
        double totalAkhir = setelahPromo + pajak + service;

        System.out.println("\n=== STRUK ===");

        if (pilihan[0] != 0)
            System.out.println(daftarMenu[pilihan[0] - 1].nama + " x" + jumlah[0] + " @"
                    + daftarMenu[pilihan[0] - 1].harga + " = " + harga1);

        if (pilihan[1] != 0)
            System.out.println(daftarMenu[pilihan[1] - 1].nama + " x" + jumlah[1] + " @"
                    + daftarMenu[pilihan[1] - 1].harga + " = " + harga2);

        if (pilihan[2] != 0)
            System.out.println(daftarMenu[pilihan[2] - 1].nama + " x" + jumlah[2] + " @"
                    + daftarMenu[pilihan[2] - 1].harga + " = " + harga3);

        if (pilihan[3] != 0)
            System.out.println(daftarMenu[pilihan[3] - 1].nama + " x" + jumlah[3] + " @"
                    + daftarMenu[pilihan[3] - 1].harga + " = " + harga4);

        System.out.println("\nSubtotal: " + subtotalAsli);
        System.out.println("Diskon: " + diskon);
        System.out.println("Setelah Diskon: " + setelahDiskon);
        System.out.println("Potongan Promo: " + potonganPromo);
        System.out.println("Setelah Promo: " + setelahPromo);
        System.out.println("Pajak (10%): " + pajak);
        System.out.println("Service: " + service);

        if (gratisMinuman > 0) {
            System.out.println("Promo Minuman: Gratis " + gratisMinuman + " (Potongan Rp " + potonganPromo + ")");
        }

        System.out.println("Total Bayar: " + totalAkhir);
    }
}