import java.util.Scanner;

public class TugasAkhir {
    
    public static double hitungKalori(String olahraga, int durasi, double beratBadan) {
        double kaloriPerMenit = 0;

        String[] jenisOlahraga = {"lari", "renang", "jalan"};
        boolean valid = false;
        for (String olahragaValid : jenisOlahraga) {
            if (olahragaValid.equalsIgnoreCase(olahraga)) {
            valid = true;
            break;
             }
        }
        if (!valid) {
            System.out.println("Jenis olahraga tidak valid!");
            return 0;    
        }       
        
        // Menentukan kalori per menit berdasarkan jenis olahraga
        switch (olahraga.toLowerCase()) {
            case "lari":
                kaloriPerMenit = 0.12; // Kalori per kg per menit untuk lari
                break;
            case "renang":
                kaloriPerMenit = 0.13; // Kalori per kg per menit untuk renang
                break;
            case "jalan":
                kaloriPerMenit = 0.05; // Kalori per kg per menit untuk jalan
                break;
            default:
                System.out.println("Jenis olahraga tidak valid!");
                return 0;
        }
        
        // Menghitung kalori terbakar
        return kaloriPerMenit * beratBadan * durasi;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("Pilih jenis olahraga (lari, renang, jalan) atau ketik 'keluar' untuk berhenti: ");
            String olahraga = scanner.nextLine();
            if (olahraga.equalsIgnoreCase("keluar")) {
                System.out.println("Terima kasih telah menggunakan aplikasi!");
                break; 
            }
            System.out.println("Masukkan durasi olahraga (dalam menit): ");
            int durasi = scanner.nextInt();
            
            System.out.println("Masukkan berat badan Anda (dalam kg): ");
            double beratBadan = scanner.nextDouble();

            if (durasi <= 0 || beratBadan <= 0) {
                System.out.println("Durasi dan berat badan harus lebih besar dari 0!");
                continue; 
            }         
            
            // Menghitung kalori yang terbakar
            double kaloriTerbakar = hitungKalori(olahraga, durasi, beratBadan);
            
            if (kaloriTerbakar > 0) {
                System.out.printf("Kalori yang terbakar saat %s selama %d menit: %.2f kalori%n", olahraga, durasi, kaloriTerbakar);
            }
            
            scanner.close();
        }
    }
}

