import org.apache.commons.lang3.StringUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GetLine {
    public List<String> lineList;
    public final List<Folder> fileSystem=new ArrayList<>();
    public GetLine(){

    }
    public String scan(){
        Scanner sc=new Scanner(System.in);
        return sc.nextLine();
    }
    public void line(){
        lineList=List.of(scan().split("\\\\"));
    }
    public void setLineList(){
        line();}
    public void print(){
        System.out.println(lineList);
    }
    public void createFoldersFileInLine(){
        fileSystem.add(new Folder(lineList.get(0)));
        fileSystem.get(0).subFolder(new Folder(lineList.get(1)));
        for(int i=2; i<lineList.size();i++) {
              fileSystem.get(0).catalog.get(0).subFolder(new Folder(lineList.get(i)));
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
    public void printLine(){
        System.out.println(StringUtils.join(fileSystem, ""));
    }

}
