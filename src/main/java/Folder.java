import org.apache.commons.lang3.StringUtils;

import java.util.*;

public class Folder {
    public String name;
    public List<Folder> catalog = new ArrayList<>();
    public LinkedHashSet<File> files = new LinkedHashSet<>();
    public Folder(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public LinkedHashSet<File> getFiles() {
        return files;
    }

    public void subFolder(Folder folderName) {
        catalog.add(folderName);
    }
    public void addFile(File fileName) {
        files.add(fileName);
    }

    public List<Folder> getCatalog() {
        return catalog;
    }

    @Override
    public String toString() {
        return "" + name + "/"+StringUtils.join(files, ",");


    }
}
