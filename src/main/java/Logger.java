import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {
    LocalDateTime dateTime = LocalDateTime.now();
    String fileName = "log" + dateTime.format(DateTimeFormatter.ofPattern("HHmmss")) + ".txt";
    File file = new File(fileName);
    protected int num = 1;
    private static Logger loggerInstance;

    private Logger() {
    }

    String formattedDate = dateTime.format(DateTimeFormatter.ofPattern("dd.MM.yy HH:mm:ss"));

    public static Logger getInstance() {
        if (loggerInstance == null) {
            loggerInstance = new Logger();
        }
        return loggerInstance;
    }

    public void log(String msg) {
        String text = "[" + formattedDate + " " + num++ + "] " + msg;
        System.out.println(text);
        // запись лога в файл
        try (FileWriter writer = new FileWriter(file, true)) {
            writer.write(text + "\n");
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
