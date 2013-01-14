package ru.jts.nasc_loader.ai;

import ru.jts.gameserver.model.objects.Creature;
import ru.jts.gameserver.model.objects.Player;

public class cristel extends citizen {
	protected void TALK_SELECTED(HandlerParam talker) {
if (_from_choice == 0) {
if (gg.HaveMemo(talker, 154) == 1 && gg.OwnItemCount(talker, 1032) < 10 && gg.OwnItemCount(talker, 1032) > 0) {
_choiceN = _choiceN + 1;
_code = 0;
myself.AddChoice(0, "Sacrifice to the Sea (In Progress)");

}
if (gg.HaveMemo(talker, 154) == 1 && gg.OwnItemCount(talker, 1032) >= 10 && gg.OwnItemCount(talker, 1033) == 0 && gg.OwnItemCount(talker, 1034) == 0 && gg.OwnItemCount(talker, 1034) < 10) {
_choiceN = _choiceN + 1;
_code = 1;
myself.AddChoice(1, "Sacrifice to the Sea (In Progress)");

}
if (gg.HaveMemo(talker, 154) == 1 && gg.OwnItemCount(talker, 1033) >= 1) {
_choiceN = _choiceN + 1;
_code = 2;
myself.AddChoice(2, "Sacrifice to the Sea (In Progress)");

}
if (gg.HaveMemo(talker, 154) == 1 && gg.OwnItemCount(talker, 1034) == 1) {
_choiceN = _choiceN + 1;
_code = 3;
myself.AddChoice(3, "Sacrifice to the Sea (In Progress)");

}
if (_choiceN > 1) {
myself.ShowChoicePage(talker, 1);
return;

}

}
if (_from_choice || _choiceN == 1) {
switch (_code) {
case 0: {
if (_from_choice == 0 || gg.HaveMemo(talker, 154) == 1 && gg.OwnItemCount(talker, 1032) < 10 && gg.OwnItemCount(talker, 1032) > 0) {
myself.SetCurrentQuestID(154);
if (myself.GetInventoryInfo(talker, 0) >= myself.GetInventoryInfo(talker, 1) * 0.800000 || myself.GetInventoryInfo(talker, 2) >= myself.GetInventoryInfo(talker, 3) * 0.800000) {
myself.ShowSystemMessage(talker, 1118);
return;

}
myself.ShowPage(talker, "cristel_q0304_01.htm");

}
break;

}
case 1: {
if (_from_choice == 0 || gg.HaveMemo(talker, 154) == 1 && gg.OwnItemCount(talker, 1032) >= 10 && gg.OwnItemCount(talker, 1033) == 0 && gg.OwnItemCount(talker, 1034) == 0 && gg.OwnItemCount(talker, 1034) < 10) {
myself.SetCurrentQuestID(154);
if (myself.GetInventoryInfo(talker, 0) >= myself.GetInventoryInfo(talker, 1) * 0.800000 || myself.GetInventoryInfo(talker, 2) >= myself.GetInventoryInfo(talker, 3) * 0.800000) {
myself.ShowSystemMessage(talker, 1118);
return;

}
if (myself.GetCurrentTick() - talker.quest_last_reward_time > 1) {
talker.quest_last_reward_time = myself.GetCurrentTick();
myself.ShowPage(talker, "cristel_q0304_02.htm");
myself.GiveItem1(talker, 1033, 1);
myself.DeleteItem1(talker, 1032, gg.OwnItemCount(talker, 1032));
myself.SetFlagJournal(talker, 154, 3);
myself.ShowQuestMark(talker, 154);
myself.SoundEffect(talker, "ItemSound.quest_middle");

}

}
break;

}
case 2: {
if (_from_choice == 0 || gg.HaveMemo(talker, 154) == 1 && gg.OwnItemCount(talker, 1033) >= 1) {
myself.SetCurrentQuestID(154);
if (myself.GetInventoryInfo(talker, 0) >= myself.GetInventoryInfo(talker, 1) * 0.800000 || myself.GetInventoryInfo(talker, 2) >= myself.GetInventoryInfo(talker, 3) * 0.800000) {
myself.ShowSystemMessage(talker, 1118);
return;

}
myself.ShowPage(talker, "cristel_q0304_03.htm");

}
break;

}
case 3: {
if (_from_choice == 0 || gg.HaveMemo(talker, 154) == 1 && gg.OwnItemCount(talker, 1034) == 1) {
myself.SetCurrentQuestID(154);
if (myself.GetInventoryInfo(talker, 0) >= myself.GetInventoryInfo(talker, 1) * 0.800000 || myself.GetInventoryInfo(talker, 2) >= myself.GetInventoryInfo(talker, 3) * 0.800000) {
myself.ShowSystemMessage(talker, 1118);
return;

}
myself.ShowPage(talker, "cristel_q0304_04.htm");

}
break;

}

}
return;

}
super;
	}


}