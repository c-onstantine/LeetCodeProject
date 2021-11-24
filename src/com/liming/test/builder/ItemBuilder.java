package com.liming.test.builder;

/**
 * @author ltf
 * @date 2021-11-10 10:02
 */
public abstract class ItemBuilder {
    protected Item item = new Item();
    public abstract void setNormal();

    public Item getResult(){
        return item;
    }
}
