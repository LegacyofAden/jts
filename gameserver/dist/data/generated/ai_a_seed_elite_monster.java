package ru.jts.nasc_loader.ai;

import ru.jts.gameserver.model.objects.Creature;
import ru.jts.gameserver.model.objects.Player;

public class ai_a_seed_elite_monster extends combat_monster {
	protected int FieldCycle_ID = 0;
	protected int FieldCycle_point = 0;
	protected int max_desire = 10000000;

	protected void NO_DESIRE() {
myself.AddMoveAroundDesire(5, 5);
	}

	protected void PARTY_ATTACKED(HandlerParam attacker, HandlerParam damage, HandlerParam i10) {
if (myself.i_ai0 == 0) {
myself.i_ai0 = 1;

}
if (attacker.is_pc == 1) {
myself.AddHateInfo(attacker, 1, 0, 1, 1);

} else if (attacker.is_pc == 0 && myself.IsInCategory(12, attacker.npc_class_id) == 1) {
if (attacker.master.alive == 1) {
if (babble_mode == 1) {
myself.Say("솬수한테 맞았습니다. 주인이 살아 있어 주인 헤이트값을 쌓습니다.");

}
myself.AddHateInfo(attacker, 2, 0, 1, 1);
myself.AddHateInfo(attacker.master, 1, 0, 1, 1);
i10 = myself.GetHateInfoCount();
if (babble_mode == 1) {
myself.Say("헤이트 인포에 있는 값들은 총 " + i10 + "개 입니다.");

}

} else if (attacker.master.alive == 0) {
myself.AddAttackDesire(attacker, 1, 100);

}

}
super;
	}

	protected void CREATED() {
myself.c_ai0 = gg.GetNullCreature();
myself.c_ai1 = gg.GetNullCreature();
super;
	}

	protected void ATTACKED(HandlerParam attacker, HandlerParam i0, HandlerParam skill_name_id, HandlerParam damage) {
if (FieldCycle_ID == 4) {
i0 = gg.GetDBSavingMap(34);
if (i0 == 2 || i0 == 3) {
if (attacker.is_pc == 1) {
if (skill_name_id != 0 && myself.IsInCategory(5, attacker.occupation) == 1) {
myself.AddHateInfo(attacker, gg.FloatToInt(damage * 30), 0, 1, 1);

} else if (skill_name_id == 0 && myself.IsInCategory(5, attacker.occupation) == 1) {
myself.AddHateInfo(attacker, gg.FloatToInt(damage * 10), 0, 1, 1);

}

}

}

} else if (FieldCycle_ID == 5) {
i0 = gg.GetDBSavingMap(36);
if (i0 == 2 || i0 == 3) {
if (attacker.is_pc == 1) {
if (skill_name_id != 0 && myself.IsInCategory(5, attacker.occupation) == 1) {
myself.AddHateInfo(attacker, gg.FloatToInt(damage * 30), 0, 1, 1);

} else if (skill_name_id == 0 && myself.IsInCategory(5, attacker.occupation) == 1) {
myself.AddHateInfo(attacker, gg.FloatToInt(damage * 10), 0, 1, 1);

}

}

}

} else if (FieldCycle_ID == 6) {
i0 = gg.GetDBSavingMap(35);
if (i0 == 2 || i0 == 3) {
if (attacker.is_pc == 1) {
if (skill_name_id != 0 && myself.IsInCategory(5, attacker.occupation) == 1) {
myself.AddHateInfo(attacker, gg.FloatToInt(damage * 30), 0, 1, 1);

} else if (skill_name_id == 0 && myself.IsInCategory(5, attacker.occupation) == 1) {
myself.AddHateInfo(attacker, gg.FloatToInt(damage * 10), 0, 1, 1);

}

}

}

}
if (myself.IsNullCreature(myself.c_ai0) == 1) {
if (myself.IsInCategory(2, attacker.occupation) == 1) {
myself.c_ai0 = attacker;

}

} else if (myself.IsNullCreature(myself.c_ai1) == 1) {
if (myself.IsInCategory(2, attacker.occupation) == 1) {
myself.c_ai1 = attacker;

}

}
super;
	}

	protected void MY_DYING(HandlerParam pos0, HandlerParam c0, HandlerParam party0, HandlerParam c1, HandlerParam i0, HandlerParam i1, HandlerParam last_attacker) {
i0 = gg.GetStep_FieldCycle(FieldCycle_ID);
i1 = FieldCycle_point;
if (i0 == 1) {
gg.AddPoint_FieldCycle(FieldCycle_ID, FieldCycle_point, 1, myself.sm);

}
i0 = 0;
if (myself.IsNullCreature(last_attacker) == 0) {
if (last_attacker.is_pc == 1) {
c0 = last_attacker;

} else if (myself.IsInCategory(12, last_attacker.npc_class_id) == 1) {
c0 = last_attacker.master;

} else {
c0 = gg.GetNullCreature();

}
if (myself.IsNullCreature(c0) == 0) {
party0 = gg.GetParty(c0);
if (myself.IsNullParty(party0) == 0) {
c1 = myself.GetMemberOfParty(party0, gg.Rand(party0.member_count));
i0 = 10 + 10 * party0.member_count;
if (gg.GetStep_FieldCycle(FieldCycle_ID) == 2) {
i0 = i0 * 2;

}

}

}
if (myself.DistFromMe(c0) < 2000 && myself.DistFromMe(c1) < 2000 && gg.Rand(1000) < i0) {
pos0 = gg.GetRandomPosInCreature(c1, 10, 40);
myself.CreateOnePrivateEx(1018839, "ai_marguene", 0, 0, pos0.x, pos0.y, pos0.z, 0, 0, 0, gg.GetIndexFromCreature(c1));

}

}
if (FieldCycle_ID == 4) {
i0 = gg.GetDBSavingMap(34);
if (i0 == 3) {
if (myself.IsNullCreature(myself.c_ai0) == 0 && myself.IsNullCreature(myself.c_ai1) == 0) {
if (gg.Rand(100) < 70) {
myself.DropItem1(myself.sm, 8603, 1);

}
if (gg.Rand(100) < 70) {
myself.DropItem1(myself.sm, 8603, 1);

}
if (gg.Rand(100) > 70) {
myself.DropItem1(myself.sm, 8604, 1);

}

}

}

} else if (FieldCycle_ID == 5) {
i0 = gg.GetDBSavingMap(36);
if (i0 == 3) {
if (myself.IsNullCreature(myself.c_ai0) == 0 && myself.IsNullCreature(myself.c_ai1) == 0) {
if (gg.Rand(100) < 70) {
myself.DropItem1(myself.sm, 8603, 1);

}
if (gg.Rand(100) < 70) {
myself.DropItem1(myself.sm, 8603, 1);

}
if (gg.Rand(100) > 70) {
myself.DropItem1(myself.sm, 8604, 1);

}

}

}

} else if (FieldCycle_ID == 6) {
i0 = gg.GetDBSavingMap(35);
if (i0 == 3) {
if (myself.IsNullCreature(myself.c_ai0) == 0 && myself.IsNullCreature(myself.c_ai1) == 0) {
if (gg.Rand(100) < 70) {
myself.DropItem1(myself.sm, 8603, 1);

}
if (gg.Rand(100) < 70) {
myself.DropItem1(myself.sm, 8603, 1);

}
if (gg.Rand(100) > 70) {
myself.DropItem1(myself.sm, 8604, 1);

}

}

}

}
super;
	}

	protected void USE_SKILL_FINISHED(HandlerParam skill_name_id, HandlerParam skill_id, HandlerParam target, HandlerParam i1, HandlerParam i2, HandlerParam i3, HandlerParam i4, HandlerParam i5) {
super;
	}


}