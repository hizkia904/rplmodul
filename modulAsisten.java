import java.util.ArrayList;
import java.util.Scanner;

public class modulAsisten{
    static ArrayList<Kesibukan>  jadwal;
    static ArrayList<Kesibukan> jadwalMatkul;
   public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        jadwal = new ArrayList<>();
        System.out.println("Silahkan masukan nilai :");
        char nilai  = sc.next().charAt(0);
        if(!(nilai=='C'||nilai=='D'||nilai=='E')){
            System.out.println("Silahkan masukkan jadwal,jika sudah selesai masukan Stop");
            String hari;
            do{
                hari = sc.next();
                if(!hari.equals("Stop")){
                    int jamMulai = sc.nextInt();
                    int jamSelesai = sc.nextInt();
                    Kesibukan kesibukan = new Kesibukan(hari,jamMulai,jamSelesai);
                    jadwal.add(kesibukan);
                }
            }while(!hari.equals("Stop"));
            jadwalMatkul = new ArrayList<>();
            buatJadwalAsistensi(jadwalMatkul);
            boolean hasilPerbandingan = compare();
            if(hasilPerbandingan){
                System.out.println("Bentrok");
            }
            else{
                System.out.println("Tidak ada bentrok");
            }
        }
        else{
            System.out.println("Maaf anda tidak memenuhi syarat nilai");
        }
   }
   public static boolean compare(){
        boolean hasil = false;
        for(int i=0;i<jadwalMatkul.size();i++){
            String hariMatkul = jadwalMatkul.get(i).hari;
            for(int j=0;j<jadwal.size();j++){
                if(jadwal.get(j).hari.equals(hariMatkul)){
                    Kesibukan matkul = jadwalMatkul.get(i);
                    Kesibukan sendiri = jadwal.get(j);
                    if(sendiri.jamMulai>=matkul.jamMulai){
                        if(sendiri.jamMulai<matkul.jamSelesai){
                            hasil = true;
                        }
                    
                    }
                    if(sendiri.jamMulai<matkul.jamMulai){
                        if(sendiri.jamSelesai>matkul.jamMulai){
                            hasil = true;
                        }
                    }

                }
            }
            if(hasil==true){
                break;
            }
        }
        return hasil;
   }
   public static void buatJadwalAsistensi(ArrayList<Kesibukan> jadwalMatkul){
        jadwalMatkul.add(new Kesibukan("Senin", 13, 15));
        jadwalMatkul.add(new Kesibukan("Selasa", 9, 11));
        jadwalMatkul.add(new Kesibukan("Kamis", 15, 17));
   }

}
class Kesibukan{
    public String hari;
    public int jamMulai;
    public int jamSelesai;
    public Kesibukan(String hari,int jamMulai,int jamSelesai){
        this.hari = hari;
        this.jamMulai = jamMulai;
        this.jamSelesai = jamSelesai;
    }
}