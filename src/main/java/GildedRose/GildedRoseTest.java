package GildedRose;

import static org.junit.Assert.*;

import org.junit.Test;

public class GildedRoseTest {

	@Test
	public void should_Aged_Brie_have_max_50_quality_when_incresase() {
		Item item = new Item("Aged Brie", 2, 5);
		for (int i = 0; i < 100; i++) {
			item.updateQuality();
		}

		assertTrue(item.quality <= 50);
	}

	@Test
	public void should_any_item_have_min_0_quality_when_decrease() {
		Item item = new Item("Foo", 2, 80);
		for (int i = 0; i < 100; i++) {
			item.updateQuality();
		}

		assertTrue(item.quality >= 0);
	}

	@Test
	public void should_sulfuras_hand_ragnaros_have_same_quality_when_update_quality() {
		Item item = new Item("Sulfuras, Hand of Ragnaros", 5, 10);
		for (int i = 0; i < 100; i++) {
			item.updateQuality();
		}

		assertEquals(item.quality, 10);
	}

	@Test
	public void should_sulfuras_hand_ragnaros_have_same_sellIn_when_update_quality() {
		Item item = new Item("Sulfuras, Hand of Ragnaros", 5, 10);
		for (int i = 0; i < 100; i++) {
			item.updateQuality();
		}

		assertEquals(item.sellIn, 5);
	}

	@Test
	public void should_backstage_have_0_quality_when_sellIn_Date() {
		Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 0, 500);
		item.updateQuality();

		assertEquals(item.quality, 0);
	}

	@Test
	public void should_backstage_have_12_quality_when_sellIn_less_than_11_and_quality_10() {
		Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 10, 10);
		item.updateQuality();

		assertEquals(item.quality, 12);
	}

	@Test
	public void should_backstage_have_13_quality_when_sellIn_less_than_6_and_quality_10() {
		Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 5, 10);
		item.updateQuality();

		assertEquals(item.quality, 13);
	}

	@Test
	public void should_any_item_have_8_quality_when_sellIn_date_and_quality_10() {
		Item item = new Item("Foo", 0, 10);
		item.updateQuality();

		assertEquals(item.quality, 8);
	}

}
