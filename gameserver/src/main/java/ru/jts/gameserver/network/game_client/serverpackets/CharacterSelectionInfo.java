/*
 * Copyright 2012 jts
 *
 * Licensed under the Apache License, Version 2.0 (the "License")
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package ru.jts.gameserver.network.game_client.serverpackets;

import ru.jts.common.network.ServerPacket;

/**
 * @author : Camelion
 * @date : 20.08.12  22:42
 */
public class CharacterSelectionInfo extends ServerPacket {
    @Override
    protected void writeImpl() {
        writeC(0x09);

        writeD(0); // size

        writeD(0x07); //Kamael, 0x07 ?
        writeC(0); //разрешает или запрещает создание игроков

        writeC(1);// Unknown (GOD)
        writeD(0);// Unknown (GOD)

        // for(...) // Characters info
    }
}