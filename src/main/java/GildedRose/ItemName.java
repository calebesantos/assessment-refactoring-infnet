package GildedRose;

public class ItemName {

	private String name;
	
	public ItemName() {
		this("");
	}
	
	public ItemName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isSulfurasHandOfRagnaros() {
		return isNameEquals("Sulfuras, Hand of Ragnaros");
	}

	public boolean isBackstagePassesToAConcert() {
		return isNameEquals("Backstage passes to a TAFKAL80ETC concert");
	}

	public boolean isAgedBrie() {
		return isNameEquals("Aged Brie");
	}

	public boolean isNameEquals(String valueToCompare) {
		return this.getName().equals(valueToCompare);
	}
}
