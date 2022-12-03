package com.javarush.hibernate_project.middleware;

import com.javarush.hibernate_project.command.abstracts.AbstractCommand;

public abstract class Middleware {
    private Middleware next;

    public static Middleware link(Middleware first, Middleware... chain) {
        Middleware head = first;
        for (Middleware nextInChain : chain) {
            head.next = nextInChain;
            head = nextInChain;
        }
        return first;
    }

    public abstract boolean check(AbstractCommand command);

    protected boolean checkNext(AbstractCommand command) {
        if (next == null) {
            return true;
        }
        return next.check(command);
    }
}