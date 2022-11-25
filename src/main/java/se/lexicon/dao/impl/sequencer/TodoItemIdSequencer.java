package se.lexicon.dao.impl.sequencer;

public class TodoItemIdSequencer {
    private static int sequencer = 1000;

    public static int nextId() {
        return ++sequencer;
    }
}
