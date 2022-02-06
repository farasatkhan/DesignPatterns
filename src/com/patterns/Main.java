package com.patterns;

import com.iterator.BrowseHistory;
import com.iterator.Iterator;
import com.memento.Editor;
import com.memento.History;
import com.state.BrushTool;
import com.state.Canvas;
import com.state.EraserTool;
import com.state.SelectionTool;

public class Main {
    public static void main(String[] args) {
        iteratorPattern();
    }

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

    public static void iteratorPattern(){
        var history = new BrowseHistory();
        history.push("https://facebook.com");
        history.push("https://youtube.com");
        history.push("https://github.com");

        Iterator iterator = history.createIterator();

        while(iterator.hasNext()){
            System.out.println(iterator.current());
            iterator.next();
        }
    }
}
