package com.patterns;

import com.memento.Editor;
import com.memento.History;
import com.state.BrushTool;
import com.state.Canvas;
import com.state.EraserTool;
import com.state.SelectionTool;

public class Main {
    public static void main(String[] args) {
        statePattern();
    }

    // Momento Pattern
    public static void momentoPattern(){
        var editor = new Editor();
        var history = new History();

        editor.setContent("hello 1");
        history.push(editor.createState());

        editor.setContent("hello 2");
        history.push(editor.createState());

        editor.setContent("hello 3");
        history.push(editor.createState());

        editor.restore(history.pop());
        System.out.println(editor.getContent());

        editor.restore(history.pop());
        System.out.println(editor.getContent());

        editor.restore(history.pop());
        System.out.println(editor.getContent());
    }

    // State Pattern
    public static void statePattern(){
        var canvas = new Canvas();
        canvas.setCurrentTool(new SelectionTool());
        canvas.mouseDown();
        canvas.mouseUp();

        canvas.setCurrentTool(new BrushTool());
        canvas.mouseDown();
        canvas.mouseUp();

        canvas.setCurrentTool(new EraserTool());
        canvas.mouseDown();
        canvas.mouseUp();
    }
}
