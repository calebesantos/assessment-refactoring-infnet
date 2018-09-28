package GildedRose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
	        Item item = items[i];

            updateQualityByName(item);
            
            updateSellIn(item);
            updateQualityToNormalize(item);
        }
    }

	private void updateQualityToNormalize(Item item) {
		if (item.sellIn < 0) {
		    if (!isAgedBrie(item)) {
		        if (!isBackstagePassesToAConcert(item)) {
		            decreaseQualityItem(item);
		        } else {
		            item.quality = item.quality - item.quality;
		        }
		    } else {
		        increaseQualityItem(item);
		    }
		}
	}

	private void updateSellIn(Item item) {
		if (!isSulfurasHandOfRagnaros(item)) {
			item.sellIn = item.sellIn - 1;
		}
	}

	private void updateQualityByName(Item item) {
		if (!isAgedBrie(item) && !isBackstagePassesToAConcert(item)) {
		    decreaseQualityItem(item);
		} else {
		    if (isInQualityLimitToIncrease(item)) {
				item.quality = item.quality + 1;

		        if (isBackstagePassesToAConcert(item)) {
		            if (item.sellIn < 11) {
		                increaseQualityItem(item);
		            }

		            if (item.sellIn < 6) {
		                increaseQualityItem(item);
		            }
		        }
		    }
		}
	}

	private boolean isSulfurasHandOfRagnaros(Item item) {
		return isNameEquals(item, "Sulfuras, Hand of Ragnaros");
	}

	private boolean isBackstagePassesToAConcert(Item item) {
		return isNameEquals(item, "Backstage passes to a TAFKAL80ETC concert");
	}

	private boolean isAgedBrie(Item item) {
		return isNameEquals(item, "Aged Brie");
	}

	private boolean isInQualityLimitToIncrease(Item item) {
		return item.quality < 50;
	}

	private boolean isNameEquals(Item item, String valueToCompare) {
		return item.name.equals(valueToCompare);
	}

	private void increaseQualityItem(Item item) {
		if (isInQualityLimitToIncrease(item)) {
		    item.quality = item.quality + 1;
		}
	}

	private void decreaseQualityItem(Item item) {
		if (item.quality > 0) {
		    if (!isSulfurasHandOfRagnaros(item)) {
		        item.quality = item.quality - 1;
		    }
		}
	}
}