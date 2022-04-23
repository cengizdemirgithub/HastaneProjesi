import java.util.Scanner;

public class HastaneRunner {

    private static Hastane hastane = new Hastane();
    private static String aktüelDurum;


    public static void main(String[] args) {

        //String hastaDurumu = "Kalp hastaliklari";
        //String unvan  = doktorUnvan(hastaDurumu);

        //hastane.setDoktor(doktorBul(unvan));


        //System.out.println("Doktor ismi: "+hastane.getDoktor().getIsim());
        //System.out.println("Doktor soy isim: "+hastane.getDoktor().getSoyIsim());
        //System.out.println("Doktor unvani: "+hastane.getDoktor().getUnvan());

        giris();//burada giris paneli olusturulup hastadan bazi bilgiler alinacak(dotorunvan metodu ve doktor bul metodu ile
        hastaDurumuBul(aktüelDurum);//burada hastanin durumunun aciliyetine bakilacak
        hastaBul(aktüelDurum);


    }

    public static void giris() {
        Hasta hasta = new Hasta();
        Scanner scanner = new Scanner(System.in);
        System.out.println("adinizi giriniz");
        hasta.setIsim(scanner.next());
        System.out.println("soyadinizi giriniz");
        hasta.setSoyIsim(scanner.next());

        System.out.print("asagidaki seceneklerden hastaliginizi giriniz\nAllerrji:1\nBas agrisi:2\nDiabet:3\nSoguk alginligi:4\nMigren:5\nKalp hastaliklari:6\nSeciminiz:");
        int secim = scanner.nextInt();
        switch (secim) {
            case 1:
                aktüelDurum = "Allerji";
                break;
            case 2:
                aktüelDurum = "Bas agrisi";
                break;
            case 3:
                aktüelDurum = "Diabet";
                break;
            case 4:
                aktüelDurum = "Soguk alginligi";
                break;
            case 5:
                aktüelDurum = "Migren";
                break;
            case 6:
                aktüelDurum = "Kalp hastaliklari";
                break;
            default:
                System.out.println(" yanlis secim lütfen tekrar deneyiniz");
                giris();
                break;
        }
        String unvan=doktorUnvan(aktüelDurum);
        Doktor doktor=doktorBul(unvan);
        System.out.println("Doktorunuz "+unvan+ " bölümünden "+ doktor.toString()+ "dur.");








        /*
        1) kullanicidan hastaligini girmesini isteyiniz,// swictch case ile hastaligini numara ile girsin
        -elimizde kullanicaidan gelen hastalik ismi var

        2) aciliyet durumu metodu cagrilsin (true ya da false) (bilgilendrime yazilabilir)
        -kullanicidan gelen aciliyet durumu var

        3)doktorun unvani istenilecek (doktorUnvan metodu ile)
        -metoddan doktorun unvanini aliyoruz#

        4)"doktorunuz su isimdeki su unvandaki kisidir" vb yazdirilacak.

         */
    }

    public static Durum hastaDurumuBul(String aktüelDurum) {
        Durum hastaDurumu = new Durum();
        hastaDurumu.setAktüelDurum(aktüelDurum);

        for (int i = 0; i < aktüelDurum.length(); i++) {

            hastaDurumu.setAktüelDurum(aktüelDurum);
            switch (aktüelDurum){
                case "Allerji":
                    hastaDurumu.setAciliyet(false);
                    break;
                case "Bas Agrisi":
                    hastaDurumu.setAciliyet(false);
                    break;
                case "Diabet":
                    hastaDurumu.setAciliyet(false);
                    break;
                case "Soguk alginligi":
                    hastaDurumu.setAciliyet(false);
                    break;
                case "Migren":
                    hastaDurumu.setAciliyet(true);
                    break;
                case "Kalp hastaliklari":
                    hastaDurumu.setAciliyet(true);
                    break;
                default:
                    System.out.println("Gecerli bir durum degil");


            }
        }

        return hastaDurumu;
    }

    /*
        1)Durum classindan bir Obje olusturunuz// Durum hastaDurumu = new Durum(); gibi
        2)asagidaki durumlari switch veya if ile set ediniz
        case " Allerji":  aciliyet => false
        case " Bas agrisi":  aciliyet => false
        case " Diabet":  aciliyet => false
        case " Soguk alginligi":  aciliyet => false
        case " Migren":  aciliyet => true
        case " Kalp hastaliklari":  aciliyet => true
        default:
        System.out.println(“Gecerli bir durum degil");
        Ve return hastaDurumu;

         */

    public static Hasta hastaBul(String aktüelDurum) {
        Hasta hasta = new Hasta();

        /*
        1)Loop kullaniniz ve aktuelDurumu kiyaslayiniz veri bankasi classindan
        2) hasta bilgilerini kullanip hasta objesindeki bilgileri set ediniz
        3)Ve sonra hastaDurumuBul method unu cagiriniz ve Durum Objesini set
ediniz
         */


        return hasta;
    }


    public static String doktorUnvan(String aktüelDurum) {

        if (aktüelDurum.equals("Allerji")) {
            return hastane.unvanlar[0];
        } else if (aktüelDurum.equals("Bas agrisi")) {
            return hastane.unvanlar[1];
        } else if (aktüelDurum.equals("Diabet")) {
            return hastane.unvanlar[2];
        } else if (aktüelDurum.equals("Soguk alginligi")) {
            return hastane.unvanlar[3];
        } else if (aktüelDurum.equals("Migren")) {
            return hastane.unvanlar[4];
        } else if (aktüelDurum.equals("Kalp hastaliklari")) {
            return hastane.unvanlar[5];
        }

        return "yanlis durum";


    }

    public static Doktor doktorBul(String unvan) {

        Doktor doktor = new Doktor();

        for (int i = 0; i < hastane.unvanlar.length; i++) {

            if (unvan.equals(hastane.unvanlar[i])) {
                doktor.setIsim(hastane.doctorIsimleri[i]);
                doktor.setSoyIsim(hastane.doctorSoyIsimleri[i]);
                doktor.setUnvan(unvan);
            }


        }

        return doktor;

    }
}

