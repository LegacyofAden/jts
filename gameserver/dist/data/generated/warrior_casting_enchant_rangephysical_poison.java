package ru.jts.nasc_loader.ai;

import ru.jts.gameserver.model.objects.Creature;
import ru.jts.gameserver.model.objects.Player;

public class warrior_casting_enchant_rangephysical_poison extends warrior_casting_enchant_physical_poison {
	protected int RangePhysicalSpecial = 458752001;

	protected void ATTACKED(HandlerParam attacker) {
if (attacker.is_pc != 0 || myself.IsInCategory(12, attacker.npc_class_id)) {
if (myself.IsNullCreature(myself.top_desire_target) == 0) {
if (gg.Rand(100) < 33 && myself.top_desire_target != attacker) {
if (myself.Skill_GetConsumeMP(RangePhysicalSpecial) < myself.sm.mp && myself.Skill_GetConsumeHP(RangePhysicalSpecial) < myself.sm.hp) {
if (myself.Skill_InReuseDelay(RangePhysicalSpecial) == 0) {
myself.AddUseSkillDesire(attacker, RangePhysicalSpecial, 0, 1, 1000000);

} else {
myself.AddUseSkillDesire(attacker, RangePhysicalSpecial, 0, 1, 1000000);

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


}