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

package de.minestar.castaway.manager;

import java.util.Map;

import de.minestar.castaway.blocks.AbstractBlock;
import de.minestar.castaway.core.CastAwayCore;
import de.minestar.castaway.data.BlockVector;
import de.minestar.castaway.data.Dungeon;

public class GameManager {
    private Map<BlockVector, AbstractBlock> blockMap;
    private Map<Integer, Dungeon> dungeonMap;

    public void init() {
        this.dungeonMap = CastAwayCore.databaseManager.loadDungeon();
        this.blockMap = CastAwayCore.databaseManager.loadActionBlocks(this.dungeonMap);
    }

    public AbstractBlock getBlock(BlockVector vector) {
        return this.blockMap.get(vector);
    }

    public void addBlock(BlockVector vector, AbstractBlock block) {
        if (this.getBlock(vector) != null) {
            this.blockMap.put(vector.clone(), block);
        }
    }

    public Dungeon getDungeonByName(String dungeonName) {
        for (Dungeon dungeon : this.dungeonMap.values()) {
            if (dungeon.getDungeonName().equals(dungeonName)) {
                return dungeon;
            }
        }
        return null;
    }
}