import java.util.Random;

public class SessionTokenPOC {
    public static void main(String[] args) {
        long seed = System.currentTimeMillis(); // or nanoTime
        String token = generateSessionToken(seed);
        System.out.println("Generated token: " + token);
        
        // Attacker knows the seed
        String predicted = generateSessionToken(seed);
        System.out.println("Predicted token: " + predicted);
    }

    private static String generateSessionToken(long seed) {
        Random random = new Random(seed);
        StringBuilder sb = new StringBuilder(16);
        for (int i = 0; i < 16; i++) {
            sb.append("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789".charAt(random.nextInt(62)));
        }
        return sb.toString();
    }
}
