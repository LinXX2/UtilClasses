package me.linxx.util.woolcolor;


import org.bukkit.inventory.ItemStack;


public class WoolColor {

	public String getColor( ItemStack wool ) {
		return WoolColors.getByInt( wool.getDurability() ).getName();

	}

	public enum WoolColors {

		WHITE( 0, "White" ), ORANGE( 1, "Orange" ), MAGENTA( 2, "Magenta" ), LIGHT_BLUE( 3, "Light Blue" ), YELLOW( 4,
				"Yellow" ), Lime( 5, "Lime" ), PINK( 6, "Pink" ), GRAY( 7, "Gray" ), LIGHT_GRAY( 8,
						"Light Gray" ), CYAN( 9, "Cyan" ), PURPLE( 10, "Purple" ), BLUE( 11, "Blue" ), BROWN( 12,
								"Brown" ), GREEN( 13, "Green" ), RED( 14, "RED" ), BLACK( 15, "Black" );

		int Damage;
		String Name;

		private WoolColors( int Damage, String Name ) {
			this.Damage = Damage;
			this.Name = Name;
		}

		private String getName() {
			return Name;
		}

		private int getDamage() {
			return Damage;
		}

		public static WoolColors getByInt( int Damage ) {
			for ( WoolColors check : WoolColors.values() ) {
				if ( check.getDamage() == Damage ) {
					return check;
				}
			}
			return null;
		}
	}
}
