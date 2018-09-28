package GildedRose;

public class Item {

	public ItemName name;

	public int sellIn;

	public int quality;

	public Item(String name, int sellIn, int quality) {
		this.name = new ItemName(name);
		this.sellIn = sellIn;
		this.quality = quality;
	}

	public void updateQuality() {
		updateQualityByName();
		updateSellIn();
		updateQualityToNormalize();
	}

	public void updateQualityToNormalize() {
		if (this.sellIn < 0) {
			if (!this.name.isAgedBrie()) {
				if (!this.name.isBackstagePassesToAConcert()) {
					this.decreaseQualityItem();
				} else {
					this.quality = this.quality - this.quality;
					System.out.println(this.quality);
				}
			} else {
				increaseQualityItem();
			}
		}
	}

	public void updateSellIn() {
		if (!this.name.isSulfurasHandOfRagnaros()) {
			this.sellIn = this.sellIn - 1;
		}
	}

	public void updateQualityByName() {
		if (!this.name.isAgedBrie() && !this.name.isBackstagePassesToAConcert()) {
			decreaseQualityItem();
		} else {
			if (isInQualityLimitToIncrease()) {
				this.quality = this.quality + 1;

				if (this.name.isBackstagePassesToAConcert()) {
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
			if (!this.name.isSulfurasHandOfRagnaros()) {
				this.quality = this.quality - 1;
			}
		}
	}

	private boolean isInQualityLimitToIncrease() {
		return this.quality < 50;
	}

	@Override
	public String toString() {
		return this.name + ", " + this.sellIn + ", " + this.quality;
	}
}
