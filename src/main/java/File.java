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
}
