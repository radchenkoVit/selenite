package selenite.utils.soft_assert;

public class SoftErrorSeeker {
    private static final String STACK_INVOCATION_METHOD = "invoke";
    private static final int DEFAULT_STACK_DEPTH = 10;

    public static String getFailPlace() {
        int failedStackPlaceIndex = findFailPlaceStackIndex();

        StringBuilder stringBuilder = new StringBuilder();
        int extraDeepStackTrace = 3;
        int deep = failedStackPlaceIndex + extraDeepStackTrace;
        for (int i = 0; i < deep; i++) {
            stringBuilder.append(getStackTraceInfo(i));
        }

        return stringBuilder.toString();
    }

    private static int findFailPlaceStackIndex() {
        StackTraceElement[] stack = Thread.currentThread().getStackTrace();
        for (int i = 0; i < stack.length; i++) {
            if(stack[i].getMethodName().equalsIgnoreCase(STACK_INVOCATION_METHOD)) {
                return i;
            }
        }

        return DEFAULT_STACK_DEPTH;
    }

    private static String getStackTraceInfo(int index) {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        String fullClassName = stackTrace[index].getClassName();
        String className = fullClassName.substring(fullClassName.lastIndexOf(".") + 1);
        String methodName = stackTrace[index].getMethodName();
        int lineNumber = stackTrace[index].getLineNumber();
        return String.format("    at %s(%s.%s.java:%s)%n", fullClassName, className, methodName, lineNumber);
    }
}
