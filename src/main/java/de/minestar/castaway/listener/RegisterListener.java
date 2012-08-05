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

package de.minestar.castaway.listener;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import com.bukkit.gemo.utils.UtilPermissions;

import de.minestar.castaway.core.CastAwayCore;
import de.minestar.minestarlibrary.utils.PlayerUtils;

public class RegisterListener {

    @EventHandler(ignoreCancelled = true)
    public void onPlayerInteract(PlayerInteractEvent event) {
        // only some actions are handled
        if (event.getAction() != Action.LEFT_CLICK_BLOCK && event.getAction() != Action.RIGHT_CLICK_BLOCK) {
            return;
        }

        // is the itemInHand correct?
        if (event.getPlayer().getItemInHand().getType().equals(Material.BONE)) {
            // check permissions?
            if (!UtilPermissions.playerCanUseCommand(event.getPlayer(), "castaway.admin")) {
                PlayerUtils.sendError(event.getPlayer(), CastAwayCore.NAME, "You are not allowed to do this!");
                event.setCancelled(true);
                return;
            }

            Player player = event.getPlayer();
            boolean isLeftClick = (event.getAction() == Action.LEFT_CLICK_BLOCK);
            if (player.isSneaking()) {
            }
        }

    }
}