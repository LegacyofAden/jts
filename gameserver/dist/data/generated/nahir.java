package ru.jts.nasc_loader.ai;

import ru.jts.gameserver.model.objects.Creature;
import ru.jts.gameserver.model.objects.Player;

public class nahir extends warrior_passive {
	protected void MY_DYING(HandlerParam always_list, HandlerParam c1, HandlerParam code_info, HandlerParam i9, HandlerParam last_attacker, HandlerParam lparty, HandlerParam member, HandlerParam random1_list, HandlerParam target) {
always_list = gg.AllocCodeInfoList();
random1_list = gg.AllocCodeInfoList();
target = last_attacker;
always_list.SetInfo(0, target);
while (gg.IsNull(code_info = always_list.Next()) == 0) {
switch (code_info.code) {
case 0: {
myself.SetCurrentQuestID(215);
target = code_info.RandomSelectOne();
if (gg.IsNull(target) == 0 && myself.DistFromMe(target) <= 1500) {
c1 = myself.GetLastAttacker();
if (c1.master) {
c1 = c1.master;

}
if (gg.HaveMemo(c1, 215) && gg.GetMemoState(c1, 215) == 10 && gg.OwnItemCount(c1, 2729) == 0) {
if (gg.Rand(5) <= 5) {
if (myself.GetCurrentTick() - c1.quest_last_reward_time > 1) {
c1.quest_last_reward_time = myself.GetCurrentTick();
myself.GiveItem1(c1, 2729, 1);
myself.SetMemoState(c1, 215, 11);
myself.SoundEffect(c1, "ItemSound.quest_middle");
myself.SetFlagJournal(c1, 215, 11);
myself.ShowQuestMark(c1, 215);

}

}

}

}
break;

}

}

}
code_info = random1_list.RandomSelectOne();
if (gg.IsNull(code_info) == 0) {
code_info.code;

}
super;
	}


}