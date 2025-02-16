package br.ce.caue.core;


import br.ce.caue.page.DSL;

public class BasePage {
    protected DSL dsl;

    public BasePage() {
        dsl = new DSL();
    }
}
