package utilities;

public final class IdGenerator {

    private static long nextIsbn = 9780000000000L;
    private static int nextMemberId = 1001;

    private IdGenerator() {}

    public static String generateIsbn() {
        return String.valueOf(nextIsbn++);
    }

    public static String generateMemberId() {
        return "M" + nextMemberId++;
    }

    public static void setNextIsbn(long nextIsbn) {
        IdGenerator.nextIsbn = nextIsbn;
    }

    public static void setNextMemberId(int nextMemberId) {
        IdGenerator.nextMemberId = nextMemberId;
    }
}
