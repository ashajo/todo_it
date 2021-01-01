package se.lexicon.asha.data;

import se.lexicon.asha.model.Person;
import se.lexicon.asha.model.Todo;

import java.util.Arrays;

public class TodoItems {
    private static Todo[] Todos = {};
    private Todo[] todos;

    public int size(){
        return Todos.length;
    }

    public static Todo[] findAll() {
        return Todos;
    }

    public Todo findById(int personId){
        for(int i = 0; i < size(); i++){
            if(Todos[i].getTodoId() == personId){
                return Todos[i];
            }
        }
        return null;
    }

    public Todo addTodoItem(String firstName, String lastName){
        Todo newTodoItem = new Todo(TodoSequencer.nextTodoId(), firstName, lastName);
        Todos = Arrays.copyOf(Todos,size()+1);
        Todos[size()-1] = newTodoItem;
        return newTodoItem;
    }
    public void clear(){
        Todos = new Todo[0];
        PersonSequencer.reset();
    }

    public Todo findByDoneStatus(boolean doneStatus){
        for (int i =0; i < todos.length; i++){
            if(todos[i].isDone() == doneStatus){
                return todos[i];
            }
        }
        return findByDoneStatus(doneStatus);
    }
    public Todo [] findByAssignee(Person assignee) {
        for (int i = 0; i < size(); i++) {
            if (todos[i].getassignee() == assignee) {
                return todos;
            }
        }
        return  findByAssignee(assignee);


    }
    public Todo[] findUnassignedTodoItems() {
        return todos;
    }
}
