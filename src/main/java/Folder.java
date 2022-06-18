import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class Folder {
    public String name;
    public final List<Folder> catalog = new ArrayList<>();
    public final List<File> files = new ArrayList<>();

    public Folder(String name) {
        this.name = name;
    }

    public void subFolder(Folder folderName) {
        catalog.add(folderName);

    }

    public void addFile(File fileName) {
        files.add(fileName);
    }

    @Override
    public String toString() {
        return ""+name + "\n " + StringUtils.join(catalog, "") +"" +StringUtils.join(files, "\n")+"\n";
    }
}

