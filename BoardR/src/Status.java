public enum Status {
    Open, ToDo, InProgress, Done, Verified;
    public Status next() {
        int nextIndex = ordinal() + 1;
        if (nextIndex >= values().length) {
            return null;
        }
        return values()[nextIndex];
    }

    public Status previous() {
        int prevIndex = ordinal() - 1;
        if (prevIndex < 0) {
            return null;
        }
        return values()[prevIndex];
    }
}
