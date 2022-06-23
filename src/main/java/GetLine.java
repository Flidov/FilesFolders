import org.apache.commons.lang3.StringUtils;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class GetLine {
    public List<String> lineList;

    public  List<Folder> fileSystem = new ArrayList<>();
    public  List<Folder> foldersList = new ArrayList<>();

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

    public void print() {
        System.out.println(lineList);
    }
    public void createFoldersInLine(){
        foldersList.clear();
        for(int i=0; i<lineList.size(); i++){
            foldersList.add(new Folder(lineList.get(i)));
        }
    }
    public void create(){
        for(int i=foldersList.size()-1; i!=0;i--){
            foldersList.get(i-1).subFolder(foldersList.get(i));
        }
    }
    public int getIndex(){
        int answer=0;
        for (int i = 0; i != fileSystem.size(); i++) {
           if( fileSystem.get(i).name.equals(foldersList.get(0).name)){
               answer=i;
                }
        }
        return answer;
    }

    public boolean checkFileSystem() {
        int check=0;
        boolean answer=false;
        for (int i = 0; i != fileSystem.size(); i++) {
            if (fileSystem.get(i).name.equals(foldersList.get(0).name)) {
                check = 1;
                break;
            }
        }
        if(check==1)
            answer=true;
        return answer;
    }
    public void createFolders() {
       if(checkFileSystem()){
           fileSystem.get(getIndex()).subFolder(foldersList.get(1));

        }
        if(fileSystem.isEmpty()){
            fileSystem.add(foldersList.get(0));
        }
    }
    /* public void createFoldersFileOnLineTest(){
         Folder root=new Folder("root");
         fileSystem.add(root);
         Folder folder1=new Folder("folder1");
         File test=new File("test","txt");
         File test2=new File("test2","txt");
         folder1.addFile(test);
         folder1.addFile(test2);
         root.subFolder(folder1);
         Folder folder2=new Folder("folder2");
         root.subFolder(folder2);
     }*/
    public void printLine() {
        System.out.println(StringUtils.join(fileSystem, ""));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GetLine getLine = (GetLine) o;
        return Objects.equals(lineList, getLine.lineList) && Objects.equals(fileSystem, getLine.fileSystem);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lineList, fileSystem);
    }
}
