import java.io.File;
import java.io.FileFilter;

public class Main {

    public static void main(){

        FileFilter filefilter = new FileFilter() {
            @Override
            public boolean accept(File file) {
                return file.getName().endsWith(".java");
            }
        };

        FileFilter filter = (File file) -> file.getName().endsWith(".java");
    }
}
