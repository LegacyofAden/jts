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

package ru.jts.tests.parser;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.jts.data.holder.BuilderCmdAliasHolder;
import ru.jts.data.holder.buildercmdalias.Command;
import ru.jts.data.parser.BuilderCmdAliasParser;

/**
 * @author : Camelion
 * @date : 25.08.12  22:48
 */
public class BuilderCmdAliasParserTest extends Assert {

    @Before
    public void setUp() throws Exception {
        BuilderCmdAliasParser.getInstance().load();
    }

    @Test
    public void test() {
        BuilderCmdAliasHolder holder = BuilderCmdAliasHolder.getInstance();
        for (Command command : holder.getCommands()) {
            assertNotNull(command.command);
            assertFalse(command.command.isEmpty());
            assertNotNull(command.alias);
            assertFalse(command.alias.isEmpty());
        }
    }
}
