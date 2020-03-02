package com.gildedrose;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

import org.junit.Test;

public class GildedRoseTest {

    @Test
    public void should_reduce_quality_and_sell_in_when_other_name() {
        Item[] items = new Item[] { new Item("foo", 1, 5) };
        GildedRose app = new GildedRose(items);
        app.update_quality();
        assertEquals("foo", app.items[0].name);
        assertThat(app.items[0].quality, is(4));
        assertThat(app.items[0].sell_in, is(0));
    }

    @Test
    public void should_add_quality_when_name_equal_Aged_Brie_and_quality_less_than_50() {
        Item[] items = new Item[] { new Item("Aged Brie", 1, 5) };
        GildedRose app = new GildedRose(items);
        app.update_quality();
        assertEquals("Aged Brie", app.items[0].name);
        assertThat(app.items[0].quality, is(6));
        assertThat(app.items[0].sell_in, is(0));
    }

    @Test
    public void should_quality_and_sell_in_maintain_when_name_equal_Aged_Brie_and_quality_than_50() {
        Item[] items = new Item[] { new Item("Aged Brie", 1, 51) };
        GildedRose app = new GildedRose(items);
        app.update_quality();
        assertEquals("Aged Brie", app.items[0].name);
        assertThat(app.items[0].quality, is(51));
        assertThat(app.items[0].sell_in, is(0));
    }

    @Test
    public void should_quality_and_sel_in_maintain_when_name_equal_Sulfuras_Hand_of_Ragnaros() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 1, 5) };
        GildedRose app = new GildedRose(items);
        app.update_quality();
        assertEquals("Sulfuras, Hand of Ragnaros", app.items[0].name);
        assertThat(app.items[0].quality, is(5));
        assertThat(app.items[0].sell_in, is(1));
    }

}
