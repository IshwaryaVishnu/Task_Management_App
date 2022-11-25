package se.lexicon.dao.impl;
import se.lexicon.model.TodoItem;
import se.lexicon.dao.TodoItemDao;
import se.lexicon.dao.impl.sequencer.TodoItemIdSequencer;

import java.util.ArrayList;
import java.util.List;

public class TodoItemDaoImpl implements TodoItemDao {
    private List<TodoItem> storage;
    // step2: define a static filed with the class type
    private static TodoItemDaoImpl instance;
    // step1 make constructor private
    private TodoItemDaoImpl () {
        storage = new ArrayList<>();
    }
    // step3: define a static method with if condition to check the object is null or no
    public static TodoItemDaoImpl getInstance(){
        if (instance == null) instance = new TodoItemDaoImpl();
        return instance;
    }

    @Override
    public TodoItem create(TodoItem model) {
        if (model == null) throw new IllegalArgumentException("TodoItem was null");
        model.setId(TodoItemIdSequencer.nextId());
        storage.add(model);
        return model;
    }

    @Override
    public TodoItem findById(Integer id) {
        if (id == null) throw new IllegalArgumentException("id was null");
        for (TodoItem model : storage)
            if (model.getId().equals(id)) return model;

        return null;
    }

    @Override
    public boolean deleteById(Integer id) {
        TodoItem result = findById(id);
        return storage.remove(result);
    }

    @Override
    public void update(TodoItem model) {
        if (model == null) throw new IllegalArgumentException("model data was null");
        for (TodoItem original : storage) {
            if (original.getId().equals(model.getId())) {
                original.setTitle(model.getTitle());
                original.setDescription(model.getDescription());
                original.setDeadLine(model.getDeadLine());
                original.setDone(model.isDone());
                break;
            }
        }


    }

    @Override
    public List<TodoItem> findAll() {
        return new ArrayList<>(storage);
    }

    @Override
    public List<TodoItem> findAllAvailable() {
        return new ArrayList<>(storage);
    }

    @Override
    public List<TodoItem> findExpiredAndInCompleted() {
        return new ArrayList<>(storage);
    }
}

