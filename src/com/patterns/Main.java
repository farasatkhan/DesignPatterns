package com.patterns;

import com.iterator.BrowseHistory;
import com.iterator.Iterator;
import com.memento.Editor;
import com.memento.History;
import com.state.BrushTool;
import com.state.Canvas;
import com.state.EraserTool;
import com.state.SelectionTool;
import com.strategy.*;
import com.template.AuditTrail;
import com.template.TransferMoneyTask;
import command.AddCustomerCommand;
import command.CustomerService;
import command.fx.Button;

public class Main {
    public static void main(String[] args) {
        commandPattern();
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

    public static void nonFlexibleStrategyPattern(){
        var nonFlexibleImageStorage = new nonFlexibleImageStorage(new JpegCompressor(), new BlackAndWhiteFilter());
        nonFlexibleImageStorage.store("imageLocation");
    }

    public static void flexibleStrategyPattern(){
        var flexibleImageStorage = new FlexibleImageStorage();
        flexibleImageStorage.store("imageLocation", new PngCompressor(), new BlackAndWhiteFilter());
        flexibleImageStorage.store("imageLocation", new JpegCompressor(), new BlackAndWhiteFilter());
    }

    public static void templatePattern(){
        var task = new TransferMoneyTask(new AuditTrail());
        task.execute();
    }

    public static void commandPattern(){
        var service = new CustomerService();
        var command = new AddCustomerCommand(service);
        var button = new Button(command);
        button.click();
    }
}
