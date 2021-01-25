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
package handlers.skillconditionhandlers;

import org.l2jmobius.gameserver.model.StatSet;
import org.l2jmobius.gameserver.model.WorldObject;
import org.l2jmobius.gameserver.model.actor.Creature;
import org.l2jmobius.gameserver.model.skills.ISkillCondition;
import org.l2jmobius.gameserver.model.skills.Skill;

/**
 * @author UnAfraid
 */
public class OpSkillSkillCondition implements ISkillCondition
{
	private final int _skillId;
	private final int _skillLevel;
	private final boolean _hasLearned;
	
	public OpSkillSkillCondition(StatSet params)
	{
		_skillId = params.getInt("skillId");
		_skillLevel = params.getInt("skillLevel");
		_hasLearned = params.getBoolean("hasLearned");
	}
	
	@Override
	public boolean canUse(Creature caster, Skill skill, WorldObject target)
	{
		final Skill requestedSkill = caster.getKnownSkill(_skillId);
		if (_hasLearned)
		{
			return (requestedSkill != null) && (requestedSkill.getLevel() == _skillLevel);
		}
		return (requestedSkill == null) || (requestedSkill.getLevel() != _skillLevel);
	}
}
