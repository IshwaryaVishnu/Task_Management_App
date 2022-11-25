package se.lexicon.dao.impl.sequencer;

public class PersonIdSequencer {
    private static int sequencer = 500;

    public static int nextId() {
        return ++sequencer;
    }
}
