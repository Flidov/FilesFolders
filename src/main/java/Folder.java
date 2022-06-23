import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Folder {
    public String name;
    public List<Folder> catalog = new ArrayList<>();
    public List<File> files = new ArrayList<>();

    public Folder(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<File> getFiles() {
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
        return "" + name + "/" + StringUtils.join(catalog, "/") + "" + StringUtils.join(files, "\n") + "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Folder folder = (Folder) o;
        return Objects.equals(name, folder.name) && Objects.equals(catalog, folder.catalog) && Objects.equals(files, folder.files);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, catalog, files);
    }
}

