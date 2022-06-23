import org.apache.commons.lang3.StringUtils;


import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GetLine {
    public int fileId;
    public List<String> lineList;
    public List<String> fileName;
    public File memory;
    public List<Folder> fileSystem = new ArrayList<>();
    public List<Folder> foldersList = new ArrayList<>();

    public GetLine() {

    }

    public String scan() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    public void line() {
        System.out.println("Enter");
        lineList = List.of(scan().split("\\\\"));
    }

    public void setLineList() {
        line();
    }

    public File createFilesInLine() {
        fileName = List.of(lineList.get(lineList.size() - 1).split("\\."));
        memory = new File(fileName.get(0), fileName.get(1));
        return memory;
    }

    public boolean checkFilesInLine() {
        Pattern pattern = Pattern.compile("\\w+\\.+\\w");
        Matcher mch = pattern.matcher(lineList.get(lineList.size() - 1));
        return mch.find();

    }

    public void createFoldersInLine() {
        foldersList.clear();
        int size = lineList.size();
        if (checkFilesInLine()) {
            size = size - 1;
            fileId = size;
        }
        for (int i = 0; i < size; i++) {
            foldersList.add(new Folder(lineList.get(i)));
        }
    }

    public void create() {
        for (int i = foldersList.size() - 1; i != 0; i--) {
            foldersList.get(i - 1).subFolder(foldersList.get(i));
        }
    }

    public int getIndex() {
        int answer = 0;
        for (int i = 0; i != fileSystem.size(); i++) {
            if (fileSystem.get(i).name.equals(foldersList.get(0).name)) {
                answer = i;
            }
        }
        return answer;
    }

    public boolean checkFileSystem() {
        int check = 0;
        boolean answer = false;
        for (int i = 0; i != fileSystem.size(); i++) {
            if (fileSystem.get(i).name.equals(foldersList.get(0).name)) {
                check = 1;
                break;
            }
        }
        if (check == 1)
            answer = true;
        return answer;
    }

    public boolean checkSubFolder1() {
        int check = 0;
        boolean answer = false;
        for (int i = 0; i != mainFolder().catalog.size(); i++) {
            if (mainFolder().catalog.get(i).name.equals(foldersList.get(1).name)) {
                check = 1;
                break;
            }
        }
        if (check == 1)
            answer = true;
        return answer;
    }

    public int getIndexSubFolder1() {
        int answer = 0;
        for (int i = 0; i != mainFolder().catalog.size(); i++) {
            if (mainFolder().catalog.get(i).name.equals(foldersList.get(1).name)) {
                answer = i;
            }
        }
        return answer;
    }

    public boolean checkSubFolder2() {
        int check = 0;
        boolean answer = false;
        for (int i = 0; i != folderSub().catalog.size(); i++) {
            if (folderSub().catalog.get(i).name.equals(foldersList.get(1).name)) {
                check = 1;
                break;
            }
        }
        if (check == 1)
            answer = true;
        return answer;
    }

    public int getIndexSubFolder2() {
        int answer = 0;
        for (int i = 0; i != folderSub().catalog.size(); i++) {
            if (folderSub().catalog.get(i).name.equals(foldersList.get(1).name)) {
                answer = i;
            }
        }
        return answer;
    }

    public Folder mainFolder() {
        return fileSystem.get(getIndex());
    }

    public Folder folderSub() {
        return mainFolder().catalog.get(getIndexSubFolder1());
    }

    public Folder folderSubSub() {
        return folderSub().catalog.get(getIndexSubFolder2());
    }

    public void addFileToFolder() {
        if (checkFilesInLine()) {
            createFilesInLine();
            switch (fileId) {
                case 1 -> mainFolder().addFile(memory);
                case 2 -> folderSub().addFile(memory);
                case 3 -> folderSubSub().addFile(memory);
            }
        }


    }

    public boolean checkFolders() {
        boolean answer = false;
        if (checkFileSystem() && fileId == 1)
            answer = true;
        if (checkSubFolder1() && fileId == 2)
            answer = true;
        if (checkSubFolder2() && fileId == 3)
            answer = true;

        return answer;

    }

    public void createFolders() {
        if(fileSystem.isEmpty()||!checkFolders())
            if (!checkFileSystem() | fileSystem.isEmpty())
                fileSystem.add(foldersList.get(0));
            else {
                if (!checkSubFolder1() | mainFolder().catalog.isEmpty())
                    mainFolder().subFolder(foldersList.get(1));
                else {
                    if (!checkSubFolder2() | folderSub().catalog.isEmpty())
                        folderSub().subFolder(foldersList.get(2));
                    else {
                        folderSubSub().subFolder(foldersList.get(3));
                    }
                }

        }
    }

    public void createFoldersFileOnLineTest() {
        Folder root = new Folder("root");
        fileSystem.add(root);
        Folder folder1 = new Folder("folder1");
        File test = new File("test", "txt");
        File test2 = new File("test2", "txt");
        folder1.addFile(test);
        folder1.addFile(test2);
        root.subFolder(folder1);
        Folder folder2 = new Folder("folder2");
        root.subFolder(folder2);
    }

    public void printFileSystem() {
        for (int i = 0; i != fileSystem.size(); i++) {
            System.out.print("\n" + fileSystem.get(i));
            if (!fileSystem.get(i).catalog.isEmpty()) {
                for (int j = 0; j != fileSystem.get(i).catalog.size(); j++) {
                    System.out.print("\n    " + fileSystem.get(i).catalog.get(j));
                    if (!fileSystem.get(i).catalog.get(j).catalog.isEmpty()) {
                        for (int k = 0; k != fileSystem.get(i).catalog.get(j).catalog.size(); k++) {
                            System.out.print("\n        " + fileSystem.get(i).catalog.get(j).catalog.get(k));
                        }
                    }
                }
            }
        }
        System.out.println();
    }
}