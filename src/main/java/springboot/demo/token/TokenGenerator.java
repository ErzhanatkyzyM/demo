package springboot.demo.token;

import java.util.UUID;

public class TokenGenerator {

    public static String generateToken() {
        // Генерируем случайный UUID
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }
}
