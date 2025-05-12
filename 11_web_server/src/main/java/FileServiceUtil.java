import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileServiceUtil {
//    public static void main(String[] args) throws IOException {
//        System.out.println(new FileService().listWorkingDir());
//    }


    public static String getCurrentWorkingDir() throws IOException {
        return Paths
                .get("")
                .toString();

    }


    public static Set<String> listWorkingDir() throws IOException {
        String currentDir = Paths
                            .get("")
                            .toString();
        return listDir(currentDir);
    }



    public static Set<String> listDir(String dir) throws IOException {
        try(Stream<Path> stream = Files.list(Paths.get(dir))) {
            return stream
                    .map(Path::getFileName)
                    .map(Path::toString)
                    .collect(Collectors.toSet());
        }
    }
}
