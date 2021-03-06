/*
 * Copyright (C) 2012 MineStar.de 
 * 
 * This file is part of CastAway.
 * 
 * CastAway is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, version 3 of the License.
 * 
 * CastAway is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with CastAway.  If not, see <http://www.gnu.org/licenses/>.
 */

package de.minestar.castaway.blocks;

import org.bukkit.entity.Player;

import de.minestar.castaway.core.CastAwayCore;
import de.minestar.castaway.data.ActionBlockType;
import de.minestar.castaway.data.BlockVector;
import de.minestar.castaway.data.Dungeon;
import de.minestar.castaway.data.DungeonOption;
import de.minestar.castaway.data.PlayerData;
import de.minestar.minestarlibrary.utils.PlayerUtils;

public class DungeonStartBlock extends AbstractActionBlock {

    public DungeonStartBlock(BlockVector vector, Dungeon dungeon) {
        super(vector, dungeon, ActionBlockType.DUNGEON_START);
        this.setHandlePhysical();
        this.setHandleLeftClick();
        this.setHandleRightClick();
        this.setExecuteIfNotInDungeon();
    }

    @Override
    public boolean execute(Player player, PlayerData data) {
        // player is not in a dungeon => join the dungeon
        if (!data.isInDungeon()) {
            if (this.dungeon.hasOption(DungeonOption.ALLOW_ONLY_ONE_PLAYER) && this.dungeon.getPlayerCount() > 0) {
                PlayerUtils.sendError(player, CastAwayCore.NAME, "Der Dungeon ist momentan besetzt!");
                PlayerUtils.sendInfo(player, "Warte bis der Dungeon wieder frei ist...");
                return true;
            } else {
                this.dungeon.playerJoin(data);
                return false;
            }
        } else {
            // player is in different dungeon => cancel & send message
            if (data.getDungeon().equals(this.dungeon)) {
                return false;
            }
            PlayerUtils.sendError(player, CastAwayCore.NAME, "Du bist momentan im Dungeon!");
            PlayerUtils.sendInfo(player, "Gib /respawn ein um dem Grauen zu entkommen.");
            return true;
        }

    }
}
