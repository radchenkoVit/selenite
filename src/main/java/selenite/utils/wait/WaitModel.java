package selenite.utils.wait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class WaitModel {
    private Duration timeout;
    private Duration interval;
    private Supplier<String> message = () -> null;
    List<Class<? extends Throwable>> ignoredExceptions = new ArrayList<>();
    private WaitMode waitMode;

    public WaitModel() {}

    private WaitModel(Builder builder) {
        timeout = builder.timeout;
        interval = builder.interval;
        message = builder.message;
        ignoredExceptions = builder.ignoredExceptions;
        waitMode = builder.waitMode;
    }

    public Duration getTimeout() {
        return timeout;
    }

    public Duration getInterval() {
        return interval;
    }

    public Supplier<String> getMessage() {
        return message;
    }

    public List<Class<? extends Throwable>> getIgnoredExceptions() {
        return ignoredExceptions;
    }

    public static class Builder {
        private Duration timeout = Duration.ofMillis(4000L);
        private Duration interval = Duration.ofMillis(500L);
        private Supplier<String> message = () -> null;
        private List<Class<? extends Throwable>> ignoredExceptions = new ArrayList<>();
        private WaitMode waitMode = WaitMode.HARD;

        public Builder setTimeout(int timeout) {
            this.timeout = Duration.ofSeconds(timeout);
            return this;
        }

        public Builder setInterval(int interval) {
            this.interval = Duration.ofMillis(interval);
            return this;
        }

        public Builder setMessage(Supplier<String> message) {
            this.message = message;
            return this;
        }

        public Builder setIgnoredExceptions(List<Class<? extends Throwable>> ignoredExceptions) {
            this.ignoredExceptions = ignoredExceptions;
            return this;
        }

        public Builder setWaitMode(WaitMode mode) {
            this.waitMode = mode;
            return this;
        }

        public WaitModel build() {
            return new WaitModel(this);
        }
    }
}
