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

package ru.jts.data.holder;

import ru.jts.annotations.data.Element;
import ru.jts.common.parser.AbstractHolder;
import ru.jts.data.holder.enchantoption.EnchantOption;

import java.util.List;

/**
 * @author : Camelion
 * @date : 27.08.12  2:01
 */
public class EnchantOptionHolder extends AbstractHolder {
    @Element(start = "enchant_option_begin", end = "enchant_option_end")
    public List<EnchantOption> enchantOptions;

    private static EnchantOptionHolder ourInstance = new EnchantOptionHolder();

    public static EnchantOptionHolder getInstance() {
        return ourInstance;
    }

    private EnchantOptionHolder() {
    }

    @Override
    public int size() {
        return enchantOptions.size();
    }

    public List<EnchantOption> getEnchantOptions() {
        return enchantOptions;
    }
}
