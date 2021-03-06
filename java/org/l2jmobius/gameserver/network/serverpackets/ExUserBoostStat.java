/*
 * This file is part of the L2J Mobius project.
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */
package org.l2jmobius.gameserver.network.serverpackets;

import org.l2jmobius.commons.network.PacketWriter;
import org.l2jmobius.gameserver.model.actor.instance.PlayerInstance;
import org.l2jmobius.gameserver.model.stats.Stat;
import org.l2jmobius.gameserver.network.OutgoingPackets;

/**
 * @author Mobius
 */
public class ExUserBoostStat implements IClientOutgoingPacket
{
	private final PlayerInstance _player;
	
	public ExUserBoostStat(PlayerInstance player)
	{
		_player = player;
	}
	
	@Override
	public boolean write(PacketWriter packet)
	{
		OutgoingPackets.EX_USER_BOOST_STAT.writeId(packet);
		
		final int currentVitalityPoints = _player.getStat().getVitalityPoints();
		int vitalityBonus = 0;
		if (currentVitalityPoints > 105000)
		{
			vitalityBonus = 300;
		}
		else if (currentVitalityPoints > 70000)
		{
			vitalityBonus = 250;
		}
		else if (currentVitalityPoints > 35000)
		{
			vitalityBonus = 200;
		}
		else if (currentVitalityPoints > 0)
		{
			vitalityBonus = 150;
		}
		
		// final int bonus = (int) (_player.getStat().getExpBonusMultiplier() * 100);
		final int bonus = (int) (_player.getStat().getValue(Stat.BONUS_EXP, 0) + vitalityBonus);
		packet.writeC(bonus > 0 ? 2 : 0);
		packet.writeC(bonus > 0 ? 2 : 0);
		packet.writeH(bonus);
		
		return true;
	}
}
