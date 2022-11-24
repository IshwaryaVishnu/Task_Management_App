package se.lexicon.model.dao.impl.sequencer;

public class TodoItemIdSequencer {
    private static int sequencer = 500;

    public static int nextId() {
        return ++sequencer;
    }
}
