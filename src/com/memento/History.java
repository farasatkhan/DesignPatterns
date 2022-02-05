package com.memento;

import java.util.ArrayList;
import java.util.List;

// careTaker
public class History {
    private List<EditorState> states = new ArrayList<>();

    public void push(EditorState state){
        states.add(state);
    }

    public EditorState pop(){
        var lastState = states.get(states.size() - 1);
        states.remove(lastState);

        return lastState;
    }
}
