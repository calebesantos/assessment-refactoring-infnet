package GildedRose;

public class Item {

	public String name;

	public int sellIn;

	public int quality;

	public Item(String name, int sellIn, int quality) {
		this.name = name;
		this.sellIn = sellIn;
		this.quality = quality;
	}

	public void updateQualityToNormalize() {
		if (this.sellIn < 0) {
		    if (!isAgedBrie()) {
		        if (!isBackstagePassesToAConcert()) {
		        	this.decreaseQualityItem();
		        } else {
		        	this.quality = this.quality - this.quality;
		        }
		    } else {
		        increaseQualityItem();
		    }
		}
	}

	public void updateSellIn() {
		if (!isSulfurasHandOfRagnaros()) {
			this.sellIn = this.sellIn - 1;
		}
	}

	public void updateQualityByName() {
		if (!isAgedBrie() && !isBackstagePassesToAConcert()) {
		    decreaseQualityItem();
		} else {
		    if (isInQualityLimitToIncrease()) {
				this.quality = this.quality + 1;

		        if (isBackstagePassesToAConcert()) {
		            if (this.sellIn < 11) {
		                increaseQualityItem();
		            }

		            if (this.sellIn < 6) {
		                increaseQualityItem();
		            }
		        }
		    }
		}
	}

	public void increaseQualityItem() {
		if (isInQualityLimitToIncrease()) {
			this.quality = this.quality + 1;
		}
	}

	public void decreaseQualityItem() {
		if (this.quality > 0) {
			if (!isSulfurasHandOfRagnaros()) {
				this.quality = this.quality - 1;
			}
		}
	}

	private boolean isInQualityLimitToIncrease() {
		return this.quality < 50;
	}

	private boolean isSulfurasHandOfRagnaros() {
		return isNameEquals("Sulfuras, Hand of Ragnaros");
	}

	private boolean isBackstagePassesToAConcert() {
		return isNameEquals("Backstage passes to a TAFKAL80ETC concert");
	}

	private boolean isAgedBrie() {
		return isNameEquals("Aged Brie");
	}

	private boolean isNameEquals(String valueToCompare) {
		return this.name.equals(valueToCompare);
	}

	@Override
	public String toString() {
		return this.name + ", " + this.sellIn + ", " + this.quality;
	}
}
