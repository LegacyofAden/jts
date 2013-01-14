package ru.jts.nasc_loader.ai;

import ru.jts.gameserver.model.objects.Creature;
import ru.jts.gameserver.model.objects.Player;

public class br_santa_white extends default_npc {
	protected int turkey_attack_item = 0;
	protected int event_stop = 0;
	protected int event_fighting = 1;
	protected int event_gift = 2;

	protected void CREATED() {
super;
myself.AddTimerEx(1225, 1000);
	}

	protected void TALKED(HandlerParam talker, HandlerParam i0) {
myself.ShowPage(talker, "br_xmas_2009_santa001.htm");
super;
	}

	protected void TIMER_FIRED_EX(HandlerParam timer_id, HandlerParam c0) {
if (timer_id == 1225) {
if (gg.Rand(2) == 0) {
myself.Say(gg.MakeFString(1900016, "", "", "", "", ""));

} else {
myself.Say(gg.MakeFString(1900134, "", "", "", "", ""));

}
myself.AddTimerEx(1225, 60000 + gg.Rand(30000));

}
	}

	protected void MENU_SELECTED(HandlerParam talker, HandlerParam ask, HandlerParam reply, HandlerParam fhtml0, HandlerParam i0, HandlerParam i1, HandlerParam i2) {
if (ask == 50010) {
switch (reply) {
case 1: {
if (myself.GetInventoryInfo(talker, 1) - myself.GetInventoryInfo(talker, 0) >= 4) {
if (gg.OwnItemCount(talker, 20763) >= 1) {
myself.ShowPage(talker, "br_xmas_2009_santa004.htm");

} else if (gg.OwnItemCount(talker, 57) < 1000) {
myself.ShowPage(talker, "br_xmas_2009_santa032.htm");

} else {
myself.CreatePet(talker, 20760, 1001538, 1);
myself.CreatePet(talker, 20760, 1001538, 1);
myself.CreatePet(talker, 20760, 1001538, 1);
myself.GiveItem1(talker, 20769, 3);
myself.GiveItem1(talker, 20763, 1);
myself.DeleteItem1(talker, 57, 1000);
myself.ShowPage(talker, "br_xmas_2009_santa003.htm");

}

} else {
myself.ShowSystemMessage(talker, 6006);

}
break;

}
case 2: {
if (gg.OwnItemCount(talker, 20756) < 1) {
myself.ShowPage(talker, "br_xmas_2009_santa007.htm");

} else {
i1 = 4 + gg.Rand(13);
myself.GiveItemEx(talker, 20759, i1, 1);
myself.DeleteItem1(talker, 20756, 1);
myself.ShowPage(talker, "br_xmas_2009_santa006.htm");

}
break;

}
case 3: {
if (gg.OwnItemCount(talker, 20757) > 0) {
myself.ShowPage(talker, "br_xmas_2009_santa035.htm");

} else if (gg.OwnItemCount(talker, 20755) > 0) {
myself.ShowPage(talker, "br_xmas_2009_santa009.htm");

} else {
myself.ShowPage(talker, "br_xmas_2009_santa024.htm");

}
break;

}
case 4: {
if (gg.OwnItemCount(talker, 20762) < 1) {
myself.ShowPage(talker, "br_xmas_2009_santa031.htm");

} else {
myself.CreatePet(talker, 20761, 1001561, 1);
myself.DeleteItem1(talker, 20762, 1);
myself.ShowPage(talker, "br_xmas_2009_santa030.htm");

}
break;

}
case 5: {
if (gg.OwnItemCount(talker, 57) < 500) {
myself.ShowPage(talker, "br_xmas_2009_santa034.htm");

} else {
myself.DeleteItem1(talker, 57, 500);
myself.GiveItem1(talker, 20769, 1);
myself.ShowPage(talker, "br_xmas_2009_santa033.htm");

}
break;

}
case 6: {
if (gg.OwnItemCount(talker, 57) < 2009) {
myself.ShowPage(talker, "br_xmas_2009_santa038.htm");

} else {
myself.GiveEventItem(talker, 57, 2009, 20901, 1, 0, 24, 0, 0);
myself.ShowPage(talker, "br_xmas_2009_santa037.htm");

}
break;

}
case 10: {
i1 = 20109;
i2 = 2500;
break;

}
case 11: {
i1 = 20123;
i2 = 2500;
break;

}
case 12: {
i1 = 20137;
i2 = 2500;
break;

}
case 13: {
i1 = 20151;
i2 = 2500;
break;

}
case 14: {
i1 = 20165;
i2 = 2500;
break;

}
case 15: {
i1 = 20110;
i2 = 81;
break;

}
case 16: {
i1 = 20124;
i2 = 81;
break;

}
case 17: {
i1 = 20138;
i2 = 81;
break;

}
case 18: {
i1 = 20152;
i2 = 81;
break;

}
case 19: {
i1 = 20166;
i2 = 81;
break;

}
case 20: {
i1 = 20111;
i2 = 236;
break;

}
case 21: {
i1 = 20125;
i2 = 236;
break;

}
case 22: {
i1 = 20139;
i2 = 236;
break;

}
case 23: {
i1 = 20153;
i2 = 236;
break;

}
case 24: {
i1 = 20167;
i2 = 236;
break;

}
case 25: {
i1 = 20112;
i2 = 164;
break;

}
case 26: {
i1 = 20126;
i2 = 164;
break;

}
case 27: {
i1 = 20140;
i2 = 164;
break;

}
case 28: {
i1 = 20154;
i2 = 164;
break;

}
case 29: {
i1 = 20168;
i2 = 164;
break;

}
case 30: {
i1 = 20113;
i2 = 7902;
break;

}
case 31: {
i1 = 20127;
i2 = 7902;
break;

}
case 32: {
i1 = 20141;
i2 = 7902;
break;

}
case 33: {
i1 = 20155;
i2 = 7902;
break;

}
case 34: {
i1 = 20169;
i2 = 7902;
break;

}
case 35: {
i1 = 20114;
i2 = 7895;
break;

}
case 36: {
i1 = 20128;
i2 = 7895;
break;

}
case 37: {
i1 = 20142;
i2 = 7895;
break;

}
case 38: {
i1 = 20156;
i2 = 7895;
break;

}
case 39: {
i1 = 20170;
i2 = 7895;
break;

}
case 40: {
i1 = 20115;
i2 = 213;
break;

}
case 41: {
i1 = 20129;
i2 = 213;
break;

}
case 42: {
i1 = 20143;
i2 = 213;
break;

}
case 43: {
i1 = 20157;
i2 = 213;
break;

}
case 44: {
i1 = 20171;
i2 = 213;
break;

}
case 45: {
i1 = 20116;
i2 = 270;
break;

}
case 46: {
i1 = 20130;
i2 = 270;
break;

}
case 47: {
i1 = 20144;
i2 = 270;
break;

}
case 48: {
i1 = 20158;
i2 = 270;
break;

}
case 49: {
i1 = 20172;
i2 = 270;
break;

}
case 50: {
i1 = 20117;
i2 = 289;
break;

}
case 51: {
i1 = 20131;
i2 = 289;
break;

}
case 52: {
i1 = 20145;
i2 = 289;
break;

}
case 53: {
i1 = 20159;
i2 = 289;
break;

}
case 54: {
i1 = 20173;
i2 = 289;
break;

}
case 55: {
i1 = 20118;
i2 = 305;
break;

}
case 56: {
i1 = 20132;
i2 = 305;
break;

}
case 57: {
i1 = 20146;
i2 = 305;
break;

}
case 58: {
i1 = 20160;
i2 = 305;
break;

}
case 59: {
i1 = 20174;
i2 = 305;
break;

}
case 60: {
i1 = 20119;
i2 = 5706;
break;

}
case 61: {
i1 = 20133;
i2 = 5706;
break;

}
case 62: {
i1 = 20147;
i2 = 5706;
break;

}
case 63: {
i1 = 20161;
i2 = 5706;
break;

}
case 64: {
i1 = 20175;
i2 = 5706;
break;

}
case 65: {
i1 = 20120;
i2 = 9340;
break;

}
case 66: {
i1 = 20134;
i2 = 9340;
break;

}
case 67: {
i1 = 20148;
i2 = 9340;
break;

}
case 68: {
i1 = 20162;
i2 = 9340;
break;

}
case 69: {
i1 = 20176;
i2 = 9340;
break;

}
case 70: {
i1 = 20121;
i2 = 9344;
break;

}
case 71: {
i1 = 20135;
i2 = 9344;
break;

}
case 72: {
i1 = 20149;
i2 = 9344;
break;

}
case 73: {
i1 = 20163;
i2 = 9344;
break;

}
case 74: {
i1 = 20177;
i2 = 9344;
break;

}
case 75: {
i1 = 20122;
i2 = 9348;
break;

}
case 76: {
i1 = 20136;
i2 = 9348;
break;

}
case 77: {
i1 = 20150;
i2 = 9348;
break;

}
case 78: {
i1 = 20164;
i2 = 9348;
break;

}
case 79: {
i1 = 20178;
i2 = 9348;
break;

}

}
if (reply >= 10 && reply <= 79) {
if (gg.OwnItemCount(talker, 20757) > 0) {
myself.DeleteItem1(talker, 20757, 1);
myself.GiveItemEx(talker, i2, 12, 1);
myself.ShowPage(talker, "br_xmas_2009_santa026.htm");

} else if (gg.OwnItemCount(talker, 20755) > 0) {
myself.DeleteItem1(talker, 20755, 1);
myself.GiveItemEx(talker, i1, 8 + gg.Rand(9), 1);
myself.ShowPage(talker, "br_xmas_2009_santa025.htm");

} else {
myself.ShowPage(talker, "br_xmas_2009_santa024.htm");

}

}

}
	}


}