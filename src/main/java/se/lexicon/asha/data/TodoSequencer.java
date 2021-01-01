package se.lexicon.asha.data;

public class TodoSequencer {
    private static int TodoId;

    public static int nextTodoId() {
        TodoId = ++TodoId;
        return TodoId;
    }

    static void reset() {
        TodoId = 0;
    }
}
