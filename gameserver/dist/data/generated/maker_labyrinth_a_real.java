package ru.jts.nasc_loader.ai;

import ru.jts.gameserver.model.objects.Creature;
import ru.jts.gameserver.model.objects.Player;

public class maker_labyrinth_a_real extends inzone_maker {
	protected String fake_maker_name = "kamaloka03_1812_001m2";
	protected String d_maker_name = "kamaloka03_1812_001m5";

	protected void ON_NPC_DELETED(HandlerParam deleted_def, HandlerParam died, HandlerParam i0, HandlerParam i1, HandlerParam maker0, HandlerParam reply, HandlerParam c0) {
i0 = myself.GetInZoneID();
maker0 = gg.InstantZone_GetNpcMaker(i0, d_maker_name);
if (gg.IsNull(maker0) == 0) {
gg.SendMakerScriptEvent(maker0, 1624002, 0, 0);

}
	}


}