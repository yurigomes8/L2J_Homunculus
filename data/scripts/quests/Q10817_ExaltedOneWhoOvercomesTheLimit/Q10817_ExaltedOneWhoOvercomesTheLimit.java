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
package quests.Q10817_ExaltedOneWhoOvercomesTheLimit;

import org.l2jmobius.Config;
import org.l2jmobius.gameserver.data.xml.CategoryData;
import org.l2jmobius.gameserver.enums.CategoryType;
import org.l2jmobius.gameserver.enums.ClassId;
import org.l2jmobius.gameserver.enums.Race;
import org.l2jmobius.gameserver.model.actor.Npc;
import org.l2jmobius.gameserver.model.actor.instance.PlayerInstance;
import org.l2jmobius.gameserver.model.quest.Quest;
import org.l2jmobius.gameserver.model.quest.QuestState;
import org.l2jmobius.gameserver.model.quest.State;

import quests.Q10811_ExaltedOneWhoFacesTheLimit.Q10811_ExaltedOneWhoFacesTheLimit;

/**
 * Exalted, One Who Overcomes the Limit (10817)
 * @URL https://l2wiki.com/Exalted,_One_Who_Overcomes_the_Limit
 * @author Mobius
 */
public class Q10817_ExaltedOneWhoOvercomesTheLimit extends Quest
{
	// NPC
	private static final int LIONEL = 33907;
	// Items
	private static final int PROOF_OF_RESISTANCE = 80823;
	private static final int LIONEL_MISSION_LIST_2 = 45632;
	// Rewards
	private static final int SPELLBOOK_DIGNITY_OF_THE_EXALTED = 45923;
	private static final int SPELLBOOK_BELIEF_OF_THE_EXALTED = 45925;
	private static final int SPELLBOOK_FAVOR_OF_THE_EXALTED = 45928;
	private static final int EXALSTED_WEAPON_UPGRADE_STONE = 81200;
	private static final int SECOND_EXALTED_QUEST_REWARD_P = 81209;
	private static final int SECOND_EXALTED_QUEST_REWARD_M = 81210;
	// Misc
	private static final int MIN_LEVEL = 101;
	private static final int MIN_COMPLETE_LEVEL = 102;
	private static final int PROOF_OF_RESISTANCE_NEEDED = 40000;
	// Monsters
	private static final int[] MONSTERS =
	{
		// Hellbound monsters
		23811, // Cantera Tanya
		23812, // Cantera Deathmoz
		23813, // Cantera Floxis
		23814, // Cantera Belika
		23815, // Cantera Bridget
		23354, // Decay Hannibal
		23355, // Armor Beast
		23356, // Klein Soldier
		23357, // Disorder Warrior
		23360, // Bizuard
		23361, // Mutated Fly
		24511, // Lunatikan
		24515, // Kandiloth
		24512, // Garion Neti
		24513, // Desert Wendigo
		24514, // Koraza
		// Abandoned Coal Mines
		24577, // Black Hammer Artisan
		24578, // Black Hammer Collector
		24579, // Black Hammer Protector
		// Blazing Swamp
		23492, // Lava Stone Golem
		23491, // Lava Wendigo
		23502, // Flame Salamander
		23503, // Flame Drake
		23500, // Flame Crow
		23501, // Flame Rael
		23494, // Magma Salamander
		23487, // Magma Ailith
		23495, // Magma Dre Vanul
		23488, // Magma Apophis
		23496, // Magma Ifrit
		// Enchanted Valley
		23581, // Apherus
		23568, // Nymph Lily
		23569, // Nymph Lily
		23570, // Nymph Tulip
		23571, // Nymph Tulip
		23572, // Nymph Cosmos
		23573, // Nymph Cosmos
		19600, // Flower Bud
		23566, // Nymph Rose
		23567, // Nymph Rose
		23578, // Nymph Guardian
		// Ivory Tower
		24422, // Stone Golem
		24425, // Steel Golem
		24421, // Stone Gargoyle
		24424, // Gargoyle Hunter
		24426, // Stone Cube
		24423, // Monster Eye
		// Silent Valley
		24506, // Silence Witch
		24508, // Silence Warrior
		24510, // Silence Hannibal
		24509, // Silence Slave
		24507, // Silence Preacle
		// Alligator Island
		24377, // Swamp Tribe
		24378, // Swamp Alligator
		24379, // Swamp Warrior
		24373, // Dailaon Lad
		24376, // Nos Lad
		// Tanor Canyon
		20941, // Tanor Silenos Chieftain
		20939, // Tanor Silenos Warrior
		20937, // Tanor Silenos Soldier
		20942, // Nightmare Guide
		20938, // Tanor Silenos Scout
		20943, // Nightmare Watchman
		24587, // Tanor Silenos
		// The Forest of Mirrors
		24466, // Demonic Mirror
		24465, // Forest Evil Spirit
		24461, // Forest Ghost
		24464, // Bewildered Dwarf Adventurer
		24463, // Bewildered Patrol
		24462, // Bewildered Expedition Member
		// Field of Silence
		24523, // Krotany
		24520, // Krotania
		24521, // Krophy
		24522, // Spiz Krophy
		// Isle of Prayer
		24451, // Lizardman Defender
		24449, // Lizardman Warrior
		24448, // Lizardman Archer
		24450, // Lizardmen Wizard
		24447, // Niasis
		24445, // Lizardman Rogue
		24446, // Island Guard
		// Brekas Stronghold
		24420, // Breka Orc Prefect
		24416, // Breka Orc Scout Captain
		24419, // Breka Orc Slaughterer
		24415, // Breka Orc Scout
		24417, // Breka Orc Archer
		24418, // Breka Orc Shaman
		// Sel Mahum Training Grounds
		24492, // Sel Mahum Soldier
		24494, // Sel Mahum Warrior
		24493, // Sel Mahum Squad Leader
		24495, // Keltron
		// Plains of the Lizardmen
		24496, // Tanta Lizardman Warrior
		24498, // Tanta Lizardman Wizard
		24499, // Priest Ugoros
		24497, // Tanta Lizardman Archer
		// Fields of Massacre
		24486, // Dismal Pole
		24487, // Graveyard Predator
		24489, // Doom Scout
		24491, // Doom Knight
		24490, // Doom Soldier
		24488, // Doom Archer
		// Wasteland
		24501, // Centaur Fighter
		24504, // Centaur Warlord
		24505, // Earth Elemental Lord
		24503, // Centaur Wizard
		24500, // Sand Golem
		24502, // Centaur Marksman
		// Fafurion Temple
		24329, // Starving Water Dragon
		24318, // Temple Guard Captain
		24325, // Temple Wizard
		24324, // Temple Guardian Warrior
		24326, // Temple Guardian Wizard
		24323, // Temple Guard
		24321, // Temple Patrol Guard
		24322, // Temple Knight Recruit
		// Dragon Valley
		24480, // Dragon Legionnaire
		24482, // Dragon Officer
		24481, // Dragon Peltast
		24483, // Dragon Centurion
		24484, // Dragon Elite Guard
		24485, // Behemoth Dragon
		// War-Torn Plains
		24585, // Vanor Silenos Mercenary
		24586, // Vanor Silenos Guardian
	};
	
	public Q10817_ExaltedOneWhoOvercomesTheLimit()
	{
		super(10817);
		addStartNpc(LIONEL);
		addTalkId(LIONEL);
		addKillId(MONSTERS);
		addCondMinLevel(MIN_LEVEL, "33907-07.html");
		addCondCompletedQuest(Q10811_ExaltedOneWhoFacesTheLimit.class.getSimpleName(), "33907-02.html");
		registerQuestItems(LIONEL_MISSION_LIST_2, PROOF_OF_RESISTANCE_NEEDED);
	}
	
	@Override
	public String onAdvEvent(String event, Npc npc, PlayerInstance player)
	{
		String htmltext = null;
		final Race race = player.getRace();
		final ClassId classId = player.getBaseTemplate().getClassId();
		final QuestState qs = getQuestState(player, false);
		if (qs == null)
		{
			return htmltext;
		}
		
		switch (event)
		{
			case "33907-03.htm":
			case "33907-04.htm":
			{
				htmltext = event;
				break;
			}
			case "33907-05.html":
			{
				if (qs.isCreated())
				{
					giveItems(player, LIONEL_MISSION_LIST_2, 1);
					qs.startQuest();
					htmltext = event;
				}
				break;
			}
			case "33907-09.html":
			{
				if (qs.isCond(2) && (player.getLevel() >= MIN_COMPLETE_LEVEL))
				{
					giveItems(player, SPELLBOOK_DIGNITY_OF_THE_EXALTED, 1);
					giveItems(player, SPELLBOOK_BELIEF_OF_THE_EXALTED, 1);
					giveItems(player, SPELLBOOK_FAVOR_OF_THE_EXALTED, 1);
					giveItems(player, EXALSTED_WEAPON_UPGRADE_STONE, 1);
					
					switch (race)
					{
						case HUMAN:
						case ELF:
						case DARK_ELF:
						{
							if (CategoryData.getInstance().isInCategory(CategoryType.SIXTH_FEOH_GROUP, classId.getId()) || (CategoryData.getInstance().isInCategory(CategoryType.SIXTH_WYNN_GROUP, classId.getId())))
							{
								giveItems(player, SECOND_EXALTED_QUEST_REWARD_M, 1);
							}
							else if (CategoryData.getInstance().isInCategory(CategoryType.SIXTH_EOLH_GROUP, classId.getId()))
							{
								giveItems(player, SECOND_EXALTED_QUEST_REWARD_M, 1);
							}
							else if (CategoryData.getInstance().isInCategory(CategoryType.SIXTH_OTHEL_GROUP, classId.getId()))
							{
								giveItems(player, SECOND_EXALTED_QUEST_REWARD_P, 1);
							}
							else if (CategoryData.getInstance().isInCategory(CategoryType.SIXTH_YR_GROUP, classId.getId()))
							{
								giveItems(player, SECOND_EXALTED_QUEST_REWARD_P, 1);
							}
							else if (CategoryData.getInstance().isInCategory(CategoryType.SIXTH_IS_GROUP, classId.getId()) || (player.getClassId() == ClassId.TYRR_DUELIST))
							{
								giveItems(player, SECOND_EXALTED_QUEST_REWARD_P, 1);
							}
							else if (player.getClassId() == ClassId.TYRR_DREADNOUGHT)
							{
								giveItems(player, SECOND_EXALTED_QUEST_REWARD_P, 1);
							}
							else if (CategoryData.getInstance().isInCategory(CategoryType.SIXTH_SIGEL_GROUP, classId.getId()))
							{
								giveItems(player, SECOND_EXALTED_QUEST_REWARD_P, 1);
							}
							else if (CategoryData.getInstance().isInCategory(CategoryType.DIVISION_WIZARD, classId.getId()))
							{
								giveItems(player, SECOND_EXALTED_QUEST_REWARD_M, 1);
							}
							else if (CategoryData.getInstance().isInCategory(CategoryType.SUBJOB_GROUP_BOW, classId.getId()))
							{
								giveItems(player, SECOND_EXALTED_QUEST_REWARD_P, 1);
							}
							else if (CategoryData.getInstance().isInCategory(CategoryType.SUBJOB_GROUP_DAGGER, classId.getId()))
							{
								giveItems(player, SECOND_EXALTED_QUEST_REWARD_P, 1);
							}
							else if (CategoryData.getInstance().isInCategory(CategoryType.SUBJOB_GROUP_DANCE, classId.getId()) || (player.getClassId() == ClassId.GLADIATOR))
							{
								giveItems(player, SECOND_EXALTED_QUEST_REWARD_P, 1);
							}
							else if (player.getClassId() == ClassId.WARLORD)
							{
								giveItems(player, SECOND_EXALTED_QUEST_REWARD_P, 1);
							}
							else if (player.getClassId() == ClassId.DUELIST)
							{
								giveItems(player, SECOND_EXALTED_QUEST_REWARD_P, 1);
							}
							else if (CategoryData.getInstance().isInCategory(CategoryType.TANKER_GROUP, classId.getId()))
							{
								giveItems(player, SECOND_EXALTED_QUEST_REWARD_P, 1);
							}
							else if (CategoryData.getInstance().isInCategory(CategoryType.RECOM_WARRIOR_GROUP, classId.getId()))
							{
								giveItems(player, SECOND_EXALTED_QUEST_REWARD_P, 1);
							}
							else
							{
								giveItems(player, SECOND_EXALTED_QUEST_REWARD_P, 1);
							}
							break;
						}
						case DWARF:
						{
							if (CategoryData.getInstance().isInCategory(CategoryType.SIXTH_OTHEL_GROUP, classId.getId()))
							{
								giveItems(player, SECOND_EXALTED_QUEST_REWARD_P, 1);
							}
							else if (CategoryData.getInstance().isInCategory(CategoryType.DWARF_BOUNTY_CLASS, classId.getId()))
							{
								giveItems(player, SECOND_EXALTED_QUEST_REWARD_P, 1);
							}
							else
							{
								giveItems(player, SECOND_EXALTED_QUEST_REWARD_P, 1);
							}
							break;
						}
						case ORC:
						{
							if (CategoryData.getInstance().isInCategory(CategoryType.SIXTH_IS_GROUP, classId.getId()))
							{
								giveItems(player, SECOND_EXALTED_QUEST_REWARD_P, 1);
							}
							else if (player.getClassId() == ClassId.TYRR_GRAND_KHAVATARI)
							{
								giveItems(player, SECOND_EXALTED_QUEST_REWARD_P, 1);
							}
							else if (player.getClassId() == ClassId.TYRR_TITAN)
							{
								giveItems(player, SECOND_EXALTED_QUEST_REWARD_P, 1);
							}
							else if (player.isMageClass())
							{
								giveItems(player, SECOND_EXALTED_QUEST_REWARD_P, 1);
							}
							else if (CategoryData.getInstance().isInCategory(CategoryType.LIGHT_ARMOR_CLASS, classId.getId()))
							{
								giveItems(player, SECOND_EXALTED_QUEST_REWARD_P, 1);
							}
							else
							{
								giveItems(player, SECOND_EXALTED_QUEST_REWARD_P, 1);
							}
							break;
						}
						case KAMAEL:
						{
							if (CategoryData.getInstance().isInCategory(CategoryType.SIXTH_FEOH_GROUP, classId.getId()))
							{
								giveItems(player, SECOND_EXALTED_QUEST_REWARD_M, 1);
							}
							else if (CategoryData.getInstance().isInCategory(CategoryType.SIXTH_YR_GROUP, classId.getId()))
							{
								giveItems(player, SECOND_EXALTED_QUEST_REWARD_P, 1);
							}
							else if (CategoryData.getInstance().isInCategory(CategoryType.DIVISION_WIZARD, classId.getId()))
							{
								giveItems(player, SECOND_EXALTED_QUEST_REWARD_M, 1);
							}
							else if (CategoryData.getInstance().isInCategory(CategoryType.DIVISION_ARCHER, classId.getId()))
							{
								giveItems(player, SECOND_EXALTED_QUEST_REWARD_P, 1);
							}
							else
							{
								giveItems(player, SECOND_EXALTED_QUEST_REWARD_P, 1);
								break;
							}
							break;
						}
						case ERTHEIA:
						{
							if (player.isMageClass())
							{
								giveItems(player, SECOND_EXALTED_QUEST_REWARD_M, 1);
							}
							else
							{
								giveItems(player, SECOND_EXALTED_QUEST_REWARD_P, 1);
							}
							break;
						}
					}
					
					qs.exitQuest(false, true);
					htmltext = event;
				}
				break;
			}
		}
		return htmltext;
	}
	
	@Override
	public String onTalk(Npc npc, PlayerInstance player)
	{
		String htmltext = getNoQuestMsg(player);
		final QuestState qs = getQuestState(player, true);
		
		switch (qs.getState())
		{
			case State.CREATED:
			{
				htmltext = "33907-01.htm";
				break;
			}
			case State.STARTED:
			{
				if (qs.isCond(2) && (player.getLevel() >= MIN_COMPLETE_LEVEL))
				{
					htmltext = "33907-08.html";
				}
				else
				{
					htmltext = "33907-06.html";
				}
				break;
			}
			case State.COMPLETED:
			{
				htmltext = getAlreadyCompletedMsg(player);
				break;
			}
		}
		return htmltext;
	}
	
	@Override
	public String onKill(Npc npc, PlayerInstance player, boolean isSummon)
	{
		executeForEachPlayer(player, npc, isSummon, true, false);
		return super.onKill(npc, player, isSummon);
	}
	
	@Override
	public void actionForEachPlayer(PlayerInstance player, Npc npc, boolean isSummon)
	{
		final QuestState qs = getQuestState(player, false);
		if ((qs != null) && qs.isCond(1) && player.isInsideRadius3D(npc, Config.ALT_PARTY_RANGE))
		{
			if (getQuestItemsCount(player, PROOF_OF_RESISTANCE) < PROOF_OF_RESISTANCE_NEEDED)
			{
				giveItemRandomly(player, PROOF_OF_RESISTANCE, 1, PROOF_OF_RESISTANCE_NEEDED, 1, true);
			}
			if ((getQuestItemsCount(player, PROOF_OF_RESISTANCE) >= PROOF_OF_RESISTANCE_NEEDED) && (player.getLevel() >= MIN_COMPLETE_LEVEL))
			{
				qs.setCond(2, true);
			}
		}
	}
	
}
