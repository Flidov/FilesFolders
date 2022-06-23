import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GetLine program1 = new GetLine();
        boolean run=true;
        System.out.println("Выберите \n 1 для ввода строки \n 2 для вывода на экран ");
        while (run) {
            switch (sc.nextInt()) {
                case 1:
                    program1.setLineList();
                    program1.createFoldersInLine();
                    program1.create();
                    program1.createFolders();
                    program1.addFileToFolder();
                    break;
                case 2:
                    program1.printFileSystem();
                    break;
                case 3:
                    run = false;

            }
        }
    }

}