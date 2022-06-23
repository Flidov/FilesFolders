import java.util.Objects;

public class File {
    public String name;
    public String extension;

    public File(String name, String extension) {
        this.name = name;
        this.extension = extension;
    }


    @Override
    public String toString() {
        return name+'.'+extension;
    }

    @Override
    public boolean equals(Object o) {        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        File file = (File) o;
        return Objects.equals(name, file.name) && Objects.equals(extension, file.extension);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, extension);
    }
}
