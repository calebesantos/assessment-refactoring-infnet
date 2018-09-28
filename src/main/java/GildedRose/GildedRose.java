package GildedRose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            if (!isNameEquals(i, "Aged Brie")
                    && !isNameEquals(i, "Backstage passes to a TAFKAL80ETC concert")) {
                decreaseQualityItem(i);
            } else {
                if (isInQualityLimitToIncrease(i)) {
                    items[i].quality = items[i].quality + 1;

                    if (isNameEquals(i, "Backstage passes to a TAFKAL80ETC concert")) {
                        if (items[i].sellIn < 11) {
                            increaseQualityItem(i);
                        }

                        if (items[i].sellIn < 6) {
                            increaseQualityItem(i);
                        }
                    }
                }
            }

            if (!isNameEquals(i, "Sulfuras, Hand of Ragnaros")) {
                items[i].sellIn = items[i].sellIn - 1;
            }

            if (items[i].sellIn < 0) {
                if (!isNameEquals(i, "Aged Brie")) {
                    if (!isNameEquals(i, "Backstage passes to a TAFKAL80ETC concert")) {
                        decreaseQualityItem(i);
                    } else {
                        items[i].quality = items[i].quality - items[i].quality;
                    }
                } else {
                    increaseQualityItem(i);
                }
            }
        }
    }

	private boolean isInQualityLimitToIncrease(int i) {
		return items[i].quality < 50;
	}

	private boolean isNameEquals(int i, String valueToCompare) {
		return items[i].name.equals(valueToCompare);
	}

	private void increaseQualityItem(int i) {
		if (isInQualityLimitToIncrease(i)) {
		    items[i].quality = items[i].quality + 1;
		}
	}

	private void decreaseQualityItem(int i) {
		if (items[i].quality > 0) {
		    if (!isNameEquals(i, "Sulfuras, Hand of Ragnaros")) {
		        items[i].quality = items[i].quality - 1;
		    }
		}
	}
}