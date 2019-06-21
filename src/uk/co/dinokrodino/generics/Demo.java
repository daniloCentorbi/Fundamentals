package uk.co.dinokrodino.generics;

import java.awt.*;
import java.awt.event.WindowListener;

public class Demo extends Frame {
    public Demo(String title) throws HeadlessException {
        super(title);
    }

    @Override
    public synchronized void addWindowListener(WindowListener l) {
        super.addWindowListener(l);
    }

}
