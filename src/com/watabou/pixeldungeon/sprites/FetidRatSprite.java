/*
 * Pixel Dungeon
 * Copyright (C) 2012-2015 Oleg Dolya
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>
 */
package com.watabou.pixeldungeon.sprites;

import com.nikita22007.multiplayer.noosa.particles.Emitter;
import com.watabou.pixeldungeon.actors.Char;
import com.watabou.pixeldungeon.effects.Speck;
import org.jetbrains.annotations.NotNull;

public class FetidRatSprite extends RatSprite {

	private Emitter cloud;

	@Override
	public void link(@NotNull Char ch ) {
		super.link( ch );

		if (cloud == null) {
			cloud = emitter();
			cloud.pour( Speck.factory( Speck.PARALYSIS ), 0.7f );
		}
	}

	@Override
	public void die() {
		super.die();

		if (cloud != null) {
			cloud.on = false;
		}
	}
}
