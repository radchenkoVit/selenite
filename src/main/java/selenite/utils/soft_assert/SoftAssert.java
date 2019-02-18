package selenite.utils.soft_assert;

import java.util.ArrayList;
import java.util.List;

import static java.lang.String.format;
import static selenite.utils.soft_assert.SoftErrorSeeker.getFailPlace;

public class SoftAssert {
    private static ThreadLocal<List<String>> threadErrors = ThreadLocal.withInitial(ArrayList::new);
    private static final String FAILED_TEST_TOP_PATTERN = "Test failed\n. %s checks failed\n";

    public static void verifyErrors() {
        if (!isEmpty()) {
            StringBuilder sb = getAndClear();
            sb.insert(0, format(FAILED_TEST_TOP_PATTERN, sb.length()));

            throw new AssertionError("Soft Assert: " + sb.toString());
        }
    }

    public static void fail(String reason) {
        verifyOld(reason, false);
    }

    public static void verifyOld(String reason, boolean assertion) {
        try {
            if (!assertion) {
                throw new AssertionError(format("%s\nStack trace: \n%s", reason, getFailPlace()));
            }
        } catch (AssertionError e){
            get().add(e.getMessage());
        }
    }

    public static void verifyNew(String reason, boolean assertion) {
        if (!assertion) {
            get().add(new AssertionError(format("%s\nStack trace: \n%s", reason, getFailPlace())).getMessage());
        }
    }

    public static StringBuilder getAndClear() {
        StringBuilder stringBuilder = new StringBuilder();
        return getAndClear(stringBuilder);
    }

    public static StringBuilder getAndClear(StringBuilder resultBuilder) {
        List<String> errors = get();
        if (errors.isEmpty()) {
            return resultBuilder;
        }

        for (int i = 0; i < errors.size(); i++) {
            resultBuilder.append("\nFAIL #").append(i + 1).append(": ");
            resultBuilder.append(errors.get(i)).append('\n');
        }
        clear();
        return resultBuilder;
    }

    private static List<String> get() {
        return threadErrors.get();
    }

    private static boolean isEmpty() {
        return get().isEmpty();
    }

    public static void remove() {
        threadErrors.remove();
    }

    public static void clear() {
        threadErrors.get().clear();
    }
}
