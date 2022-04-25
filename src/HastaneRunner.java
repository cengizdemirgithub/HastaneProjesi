import java.util.Scanner;

public class HastaneRunner {

    private static Hastane hastane = new Hastane();//Hastane sinifindan bir hastane objesi olusturuldu
    private static String aktüelDurum;
    private static Hasta hasta = new Hasta();
    private static String hastaIsim;
    private static String hastaSoyIsim;
    private static int hastaId;
    static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {


        giris();//burada giris paneli olusturulup hastadan bazi bilgiler alinacak(doktorunvan metodu ve doktor bul metodu ile
        //System.out.println(hastaDurumuBul(aktüelDurum).aciliyetDurumu());//burada hastanin durumunun aciliyetine bakilacak
        //  System.out.println(hastaBul(aktüelDurum));//
        secim();
       //hastaBul();

        son(hastaBul());


    }

    private static void secim() { System.out.print("asagidaki seceneklerden hastaliginizi giriniz\nAllerrji:1\nBas agrisi:2\nDiabet:3\nSoguk alginligi:4\nMigren:5\nKalp hastaliklari:6\nSeciminiz:");
        int secim = scanner.nextInt();
        switch (secim) {
            case 1:
                aktüelDurum = hastane.durumlar[0];

                break;
            case 2:
                aktüelDurum = hastane.durumlar[1];
                break;
            case 3:
                aktüelDurum = hastane.durumlar[2];
                break;
            case 4:
                aktüelDurum = hastane.durumlar[3];
                break;
            case 5:
                aktüelDurum =hastane.durumlar[4];
                break;
            case 6:
                aktüelDurum = hastane.durumlar[5];
                break;
            default:
                System.out.println(" yanlis secim lütfen tekrar deneyiniz");
                giris();
                break;
        }
        String unvan = doktorUnvan(aktüelDurum);//burasi bize doktor unvanini verecek
        Doktor doktor = doktorBul(unvan);//yukardan gelen unvana sahip doktor isim ve soyismini dönecek

        System.out.println("Doktorunuz " + unvan + " bölümünden " + doktor.toString() + "dur.");
    }

    private static void son(Hasta hastaBul) {

        System.out.println("----------------------------------------------\n");
        System.out.println("hastanin son bilgileri: \n" + hastaBul.toString());
        hastaDurumuBul(aktüelDurum);
        System.out.println("----------------------------------------------");
    }

    public static void giris() {

        System.out.print("Adinizi giriniz: ");//girdigi ad veri banksayilyal uyusmasi lazim
        hastaIsim = scanner.next();
        System.out.print("Soyadinizi giriniz: ");
        hastaSoyIsim = scanner.next();
        System.out.print("Id giriniz: ");
        hastaId = scanner.nextInt();
        hastaBul();










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
        System.out.println("Hastanin aktüel durumu:  " + hastaDurumu.getAktüelDurum());


        switch (aktüelDurum) {
            case "Allerji":
                System.out.println("hastanin aciliyet durumu : " + hastaDurumu.setAciliyet(false));
                break;
            case "Bas Agrisi":
                System.out.println("hastanin aciliyet durumu : " + hastaDurumu.setAciliyet(false));
                break;
            case "Diabet":
                System.out.println("hastanin aciliyet durumu : " + hastaDurumu.setAciliyet(false));
                break;
            case "Soguk alginligi":
                System.out.println("hastanin aciliyet durumu : " + hastaDurumu.setAciliyet(false));
                break;
            case "Migren":
                System.out.println("hastanin aciliyet durumu : " + hastaDurumu.setAciliyet(true));
                break;
            case "Kalp hastaliklari":
                System.out.println("hastanin aciliyet durumu : " + hastaDurumu.setAciliyet(true));
                break;
            default:
                System.out.println("Gecerli bir durum degil");




        }


        return hastaDurumu;
    }



    public static Hasta hastaBul() {//burasi bize ilgili hasta ile ilgili bilgilerin dogrulugunu kontrol edecek


        for (String each : hastane.hastaIsimleri
        ) {
            if (hastaIsim.equals(each)) {
                hasta.setIsim(hastaIsim);
                break;
            }
        }

        if (hastaIsim == hasta.getIsim()) {
        } else {
            System.out.println("isminizi yanlis girdiniz girise yönlendiriliyorsunuz");
            giris();

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



        for (String each : hastane.hastaSoyIsimleri
        ) {
            if (hastaSoyIsim.equals(each)) {
                hasta.setSoyIsim(hastaSoyIsim);
                break;
            }
        }
        if (hastaSoyIsim == hasta.getSoyIsim()) {
        } else {
            System.out.println("soyisminizi yanlis girdiniz girise yönlendiriliyorsunuz");
            giris();
        }


        for (Integer each : hastane.hastaIDleri
        ) {
            if (hastaId == each) {
                hasta.setHastaID(hastaId);
                break;

            }

        }
        if (hastaId == hasta.getHastaID()) {
        } else {
            System.out.println("idnizi yanlis girdiniz girise yönlediriliyorsunuz");
            giris();
        }

        hasta.setHastaDurumu(aktüelDurum);


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

