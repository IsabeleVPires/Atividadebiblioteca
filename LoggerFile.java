package br.univille.log;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

public class LoggerFile implements Logger {
    private final String filename;

    public LoggerFile(String filename) {
        this.filename = filename;
    }

    @Override
    public void log(Level level, String message) {
        try (PrintWriter out = new PrintWriter(new FileWriter(filename, true))) {
            out.println("[" + LocalDateTime.now() + "] " + level + ": " + message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
