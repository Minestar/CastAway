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

import java.util.HashMap;
import java.util.Map;

import de.minestar.castaway.blocks.AbstractActionBlock;
import de.minestar.castaway.blocks.DungeonEndBlock;
import de.minestar.castaway.blocks.DungeonStartBlock;
import de.minestar.castaway.blocks.FullHealthBlock;

public enum ActionBlockType {

    DUNGEON_START(0, DungeonStartBlock.class, "START"),

    DUNGEON_END(1, DungeonEndBlock.class, "END"),

    SPECIAL_HEALTH_FULL(2, FullHealthBlock.class, "FULL_HEALTH");

    private final int ID;
    private final Class<? extends AbstractActionBlock> clazz;
    private final String commandName;

    private static Map<Integer, ActionBlockType> mapByID;

    static {
        mapByID = new HashMap<Integer, ActionBlockType>();
        for (ActionBlockType b : ActionBlockType.values()) {
            mapByID.put(b.ID, b);
        }
    }

    private ActionBlockType(int ID, Class<? extends AbstractActionBlock> clazz, String commandName) {
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

    public static ActionBlockType byCommandName(String text) {
        for (ActionBlockType type : ActionBlockType.values()) {
            if (type.getCommandName().equalsIgnoreCase(text))
                return type;
        }
        return null;
    }

    public static ActionBlockType byID(int ID) {
        return mapByID.get(ID);
    }
}