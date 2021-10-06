/*
 *  SPDX-License-Identifier: Apache-2.0
 *
 *  The OpenSearch Contributors require contributions made to
 *  this file be licensed under the Apache-2.0 license or a
 *  compatible open source license.
 *
 *  Modifications Copyright OpenSearch Contributors. See
 *  GitHub history for details.
 */

package com.amazon.dataprepper.plugins.prepper.fizzbuzz;

import com.amazon.dataprepper.model.configuration.PluginSetting;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FizzBuzzProcessorConfigTest {
    private static final String PLUGIN_NAME = "FizzBuzz";

    @Test
    public void test_default_throws_illegal_argument_exceptions() {
        assertThrows(IllegalArgumentException.class, () -> { FizzBuzzProcessorConfig.buildConfiguration(new PluginSetting(PLUGIN_NAME, null)); });
    }
}