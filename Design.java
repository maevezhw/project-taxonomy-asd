import java.util.Scanner;

public class Design{
  Scanner scan = new Scanner(System.in);
  BT pb = new BT();
  
  public void ClearScreen(){
    System.out.print("\033[H\033[2J");  
    System.out.flush();
  }
  
  public void opening(){ 
    ClearScreen();
    System.out.println(ConsoleColors.GREEN + "\n" +
"\t\t\t ████████  █████  ██   ██  ██████\n" + 
"\t\t\t    ██    ██   ██  ██ ██  ██    ██\n" +
"\t\t\t    ██    ███████   ███   ██    ██\n" + 
"\t\t\t    ██    ██   ██  ██ ██  ██    ██\n" + 
"\t\t\t    ██    ██   ██ ██   ██  ██████\n\n" + ConsoleColors.RED +
                       
"\t\t\t███    ██  ██████  ███    ███ ██    ██\n" + 
"\t\t\t████   ██ ██    ██ ████  ████  ██  ██\n" +
"\t\t\t██ ██  ██ ██    ██ ██ ████ ██   ████\n" + 
"\t\t\t██  ██ ██ ██    ██ ██  ██  ██    ██\n" + 
"\t\t\t██   ████  ██████  ██      ██    ██\n\n" + ConsoleColors.RESET);
    System.out.print(ConsoleColors.YELLOW +"\t\t\t\t  tekan enter untuk memulai..."+ ConsoleColors.BLUE);
    scan.nextLine();
    ClearScreen();
    menu();
  }
  
  public void menu(){
    int pilihan = -1;
    
    while(pilihan != 0){     
      System.out.println(ConsoleColors.GREEN +"\t\t\t--------------Klasifikasi--------------" + ConsoleColors.RESET);
      System.out.println("\t\t\t1. Berdasarkan Kingdom");
      System.out.println("\t\t\t2. Berdasarkan Kelas Animalia");
      System.out.println("\t\t\t3. Berdasarkan Kelas Plantae");
      System.out.println("\t\t\t4. Pohon Kingdom");
      System.out.println("\t\t\t5. Pohon Kelas Animalia");
      System.out.println("\t\t\t6. Pohon Kelas Plantae");
      System.out.println("\t\t\t0. Keluar");
      System.out.println(ConsoleColors.RED + "\t\t\t---------------------------------------\n" + ConsoleColors.RESET);
      System.out.print("\t\t\t" + ConsoleColors.BLUE +"Pilih yang mau dilakukan: " + ConsoleColors.RESET);
      pilihan = Integer.parseInt(scan.nextLine());
      //scan.nextLine();
      System.out.println();
      // jika program tidak dijalankan di replit, nama file txt harus disertai dengan path foldernya contoh: D:/kuliah/ASD java/takso/src/kingdom.txt
      switch(pilihan){
        case 1: pb.baca("kingdom.txt", pb); pb.pilih(pilihan, pb); break;
        case 2: pb.baca("animalia.txt", pb); pb.pilih(pilihan, pb); break;
        case 3: pb.baca("plantae.txt", pb); pb.pilih(pilihan, pb); break;
        case 4: pb.baca("kingdom.txt", pb); pb.printTree();  break;
        case 5: pb.baca("animalia.txt", pb); pb.printTree(); break;
        case 6: pb.baca("plantae.txt", pb); pb.printTree(); break;
        case 0:
          System.out.println(ConsoleColors.GREEN + "\t\t\tBerhasil Keluar Dari Program\n\t\t\tsemoga harimu menyenangkan :3" + ConsoleColors.BLUE);
          scan.nextLine();
          scan.close();
          System.exit(0);
          break;
        default:
          System.out.println(ConsoleColors.RED + "\t\t\tFitur lain belum tersedia!\n" + ConsoleColors.RESET + "\t\t\t\tNantikan fitur selanjutnya yaa!");
          break;
      }
      System.out.print(ConsoleColors.YELLOW +"\n\n\t\t\t\t tekan enter untuk melanjutkan..."+ ConsoleColors.BLUE);
      scan.nextLine();
      ClearScreen();
      pilihan = -1;
    }
  }
}