package ru.jts.nasc_loader.ai;

import ru.jts.gameserver.model.objects.Creature;
import ru.jts.gameserver.model.objects.Player;

public class ai_solina_learner extends wizard_use_skill {
	protected int Skill01_ID = 413335553;
	protected int Skill01_Check_Dist = 1;
	protected int Skill01_Dist_Min = 0;
	protected int Skill02_ID = 413401089;
	protected int Skill02_Check_Dist = 0;
	protected int Skill02_Dist_Min = 500;
	protected int Skill02_Dist_Max = 2000;
	protected int dist_check = 5000;

	protected void CREATED() {
myself.i_ai2 = 0;
myself.i_ai3 = 0;
myself.i_ai4 = 0;
super;
	}

	protected void SEE_CREATURE(HandlerParam creature) {
if (myself.GetLifeTime() > 7 && myself.InMyTerritory(myself.sm) && myself.IsNullCreature(myself.top_desire_target) == 1) {
if (creature.is_pc != 0 && myself.IsWeaponEquippedInHand(creature) == 1) {
if (myself.Skill_GetConsumeMP(Skill02_ID) < myself.sm.mp && myself.Skill_GetConsumeHP(Skill02_ID) < myself.sm.hp && myself.Skill_InReuseDelay(Skill02_ID) == 0) {
myself.AddUseSkillDesire(creature, Skill02_ID, 0, 1, 1000000);

}
myself.c_ai0 = creature;

}
super;

}
	}

	protected void ATTACKED(HandlerParam attacker, HandlerParam damage) {
if (gg.Rand(100) < 30) {
if (myself.i_ai2 == 0 && myself.DistFromMe(attacker) < 400) {
myself.AddTimerEx(100002, 2000);
myself.i_ai2 = 1;
myself.c_ai1 = attacker;

}

} else if (attacker.is_pc != 0 || myself.IsInCategory(12, attacker.npc_class_id)) {
if (myself.IsNullCreature(myself.top_desire_target) == 0) {
if (myself.top_desire_target == attacker) {
if (myself.Skill_GetConsumeMP(Skill01_ID) < myself.sm.mp && myself.Skill_GetConsumeHP(Skill01_ID) < myself.sm.hp) {
if (myself.Skill_InReuseDelay(Skill01_ID) == 0) {
myself.AddUseSkillDesire(attacker, Skill01_ID, 0, 1, 1000000);

} else {
myself.AddUseSkillDesire(attacker, Skill01_ID, 0, 1, 1000000);

}

} else {
myself.i_ai0 = 1;
myself.AddAttackDesire(attacker, 1, 1000);

}

}

}

}
super;
	}

	protected void TIMER_FIRED_EX(HandlerParam timer_id) {
if (timer_id == 100002) {
if (myself.Skill_GetConsumeMP(Skill02_ID) < myself.sm.mp && myself.Skill_GetConsumeHP(Skill02_ID) < myself.sm.hp && myself.Skill_InReuseDelay(Skill02_ID) == 0) {
myself.RemoveAllDesire();
myself.AddFleeDesire(myself.c_ai1, 10000000000);
myself.AddTimerEx(dist_check, 1000);

} else {
myself.i_ai2 = 0;

}

} else if (timer_id == dist_check) {
if (myself.DistFromMe(myself.c_ai1) > 200) {
myself.RemoveAllDesire();
if (myself.Skill_GetConsumeMP(Skill02_ID) < myself.sm.mp && myself.Skill_GetConsumeHP(Skill02_ID) < myself.sm.hp) {
if (myself.Skill_InReuseDelay(Skill02_ID) == 0) {
myself.AddUseSkillDesire(myself.c_ai1, Skill02_ID, 0, 1, 1000000);

} else {
myself.AddUseSkillDesire(myself.c_ai1, Skill02_ID, 0, 1, 1000000);

}

} else {
myself.i_ai0 = 1;
myself.AddAttackDesire(myself.c_ai1, 1, 1000);

}
myself.i_ai3 = 1;
myself.i_ai2 = 0;

} else {
myself.AddTimerEx(dist_check, 1000);
myself.i_ai2 = 0;

}

}
super;
	}

	protected void CLAN_ATTACKED(HandlerParam attacker, HandlerParam damage, HandlerParam i6, HandlerParam h0) {
if (myself.GetLifeTime() > 7 && myself.InMyTerritory(myself.sm)) {
myself.RemoveAllHateInfoIF(1, 0);
if (myself.GetLifeTime() > 7 && attacker.is_pc != 0 || myself.IsInCategory(12, attacker.npc_class_id) && myself.GetHateInfoCount() == 0) {
if (myself.DistFromMe(attacker) > 100) {
if (myself.Skill_GetConsumeMP(Skill02_ID) < myself.sm.mp && myself.Skill_GetConsumeHP(Skill02_ID) < myself.sm.hp) {
if (myself.Skill_InReuseDelay(Skill02_ID) == 0) {
myself.AddUseSkillDesire(attacker, Skill02_ID, 0, 1, 1000000);

} else {
myself.AddUseSkillDesire(attacker, Skill02_ID, 0, 1, 1000000);

}

} else {
myself.i_ai0 = 1;
myself.AddAttackDesire(attacker, 1, 1000);

}

} else if (myself.Skill_GetConsumeMP(Skill01_ID) < myself.sm.mp && myself.Skill_GetConsumeHP(Skill01_ID) < myself.sm.hp) {
if (myself.Skill_InReuseDelay(Skill01_ID) == 0) {
myself.AddUseSkillDesire(attacker, Skill01_ID, 0, 1, 1000000);

} else {
myself.AddUseSkillDesire(attacker, Skill01_ID, 0, 1, 1000000);

}

} else {
myself.i_ai0 = 1;
myself.AddAttackDesire(attacker, 1, 1000);

}

}

}
super;
	}

	protected void USE_SKILL_FINISHED(HandlerParam h0, HandlerParam i0, HandlerParam target, HandlerParam skill_name_id) {
h0 = myself.GetMaxHateInfo(0);
i0 = 0;
if (myself.IsNullHateInfo(h0) == 0) {
if (myself.IsNullCreature(h0.creature) == 0) {
i0 = 1;

}

}
if (i0 == 1) {
if (myself.i_ai3 == 1 && gg.Rand(100) < 33) {
if (myself.Skill_GetConsumeMP(Skill01_ID) < myself.sm.mp && myself.Skill_GetConsumeHP(Skill01_ID) < myself.sm.hp) {
if (myself.Skill_InReuseDelay(Skill01_ID) == 0) {
myself.AddUseSkillDesire(h0.creature, Skill01_ID, 0, 1, 1000000);

} else {
myself.AddUseSkillDesire(h0.creature, Skill01_ID, 0, 1, 1000000);

}

} else {
myself.i_ai0 = 1;
myself.AddAttackDesire(h0.creature, 1, 1000);

}
myself.i_ai3 = 0;

} else if (myself.Skill_GetConsumeMP(Skill02_ID) < myself.sm.mp && myself.Skill_GetConsumeHP(Skill02_ID) < myself.sm.hp) {
if (myself.Skill_InReuseDelay(Skill02_ID) == 0) {
myself.AddUseSkillDesire(h0.creature, Skill02_ID, 0, 1, 1000000);

} else {
myself.AddUseSkillDesire(h0.creature, Skill02_ID, 0, 1, 1000000);

}

} else {
myself.i_ai0 = 1;
myself.AddAttackDesire(h0.creature, 1, 1000);

}

} else if (skill_name_id == Skill02_ID) {
if (myself.i_ai4 == 0) {
myself.Say(gg.MakeFString(1121006, "", "", "", "", ""));
myself.i_ai4 = 1;

}
myself.AddAttackDesire(myself.c_ai0, 1, 10000);

}
super;
	}

	protected void MY_DYING(HandlerParam c0) {
c0 = myself.GetLastAttacker();
if (myself.IsNullCreature(c0) == 0) {
if (gg.HaveMemo(c0, 457) == 0 && gg.GetDailyQuestFlag(c0, 457) == 1 && c0.level >= 82) {
if (gg.Rand(100) < 1) {
myself.CreateOnePrivateEx(1032759, "lost_villager", 0, 0, gg.FloatToInt(myself.sm.x), gg.FloatToInt(myself.sm.y), gg.FloatToInt(myself.sm.z), myself.GetDirection(myself.sm), 0, 0, 0);

}

}

}
super;
	}


}