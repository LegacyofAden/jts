package ru.jts.nasc_loader.ai;

import ru.jts.gameserver.model.objects.Creature;
import ru.jts.gameserver.model.objects.Player;

public class baar_dre_vanul extends warrior_aggressive {
	protected void MY_DYING(HandlerParam always_list, HandlerParam code_info, HandlerParam i0, HandlerParam i9, HandlerParam last_attacker, HandlerParam lparty, HandlerParam member, HandlerParam random1_list, HandlerParam target) {
always_list = gg.AllocCodeInfoList();
random1_list = gg.AllocCodeInfoList();
target = last_attacker;
if (gg.HaveMemo(target, 415) == 1 && gg.GetMemoState(target, 415) == 4 && gg.OwnItemCount(target, 8546) < 1) {
random1_list.SetInfo(0, target);

}
if (gg.HaveMemo(target, 415) == 1 && gg.GetMemoState(target, 415) == 4 && gg.OwnItemCount(target, 8546) < 1) {
random1_list.SetInfo(0, target);

}
if (gg.IsNull(lparty) == 0) {
for (i9 = 0; i9 < lparty.member_count; i9 = i9 + 1) {
target = myself.GetMemberOfParty(lparty, i9);
if (gg.HaveMemo(target, 415) == 1 && gg.GetMemoState(target, 415) == 4 && gg.OwnItemCount(target, 8546) < 1) {
random1_list.SetInfo(0, target);

}

}

}
while (gg.IsNull(code_info = always_list.Next()) == 0) {
code_info.code;

}
code_info = random1_list.RandomSelectOne();
if (gg.IsNull(code_info) == 0) {
switch (code_info.code) {
case 0: {
myself.SetCurrentQuestID(415);
target = code_info.RandomSelectOne();
if (gg.IsNull(target) == 0 && myself.DistFromMe(target) <= 1500) {
if (target.attack_type == 5 || target.attack_type == 9) {
i0 = gg.Rand(100);
if (i0 < 90) {
myself.GiveItem1(target, 8546, 1);
myself.SetFlagJournal(target, 415, 18);
myself.ShowQuestMark(target, 415);
myself.SoundEffect(target, "ItemSound.quest_middle");

}

}

}
break;

}

}

}
super;
	}


}