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

package de.minestar.castaway.data;

import de.minestar.castaway.blocks.AbstractActionBlock;
import de.minestar.castaway.blocks.DungeonEndBlock;
import de.minestar.castaway.blocks.DungeonStartBlock;
import de.minestar.castaway.blocks.FullHealthBlock;

public enum BlockEnum {
    UNKNOWN(-1, null, null),

    DUNGEON_START(0, DungeonStartBlock.class, "START"),

    DUNGEON_END(1, DungeonEndBlock.class, "END"),

    SPECIAL_HEALTH_FULL(2, FullHealthBlock.class, "FULL_HEALTH");

    private final int ID;
    private final Class<? extends AbstractActionBlock> clazz;
    private final String commandName;

    private BlockEnum(int ID, Class<? extends AbstractActionBlock> clazz, String commandName) {
        this.ID = ID;
        this.clazz = clazz;
        this.commandName = commandName;
    }

    public int getID() {
        return this.ID;
    }

    public Class<? extends AbstractActionBlock> getClazz() {
        return this.clazz;
    }

    public String getCommandName() {
        return commandName;
    }

    public static BlockEnum byCommandName(String text) {
        for (BlockEnum type : BlockEnum.values()) {
            if (type.getCommandName().equalsIgnoreCase(text))
                return type;
        }
        return null;
    }

    public static Class<? extends AbstractActionBlock> byID(int ID) {
        for (BlockEnum type : BlockEnum.values()) {
            if (type.getID() == ID)
                return type.getClazz();
        }
        return UNKNOWN.getClazz();
    }
}
