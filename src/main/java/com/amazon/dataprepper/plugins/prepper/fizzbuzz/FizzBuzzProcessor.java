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

import com.amazon.dataprepper.model.PluginType;
import com.amazon.dataprepper.model.annotations.DataPrepperPlugin;
import com.amazon.dataprepper.model.configuration.PluginSetting;
import com.amazon.dataprepper.model.prepper.AbstractPrepper;
import com.amazon.dataprepper.model.record.Record;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

@DataPrepperPlugin(name="FizzBuzz", type=PluginType.PREPPER)
public class FizzBuzzProcessor extends AbstractPrepper<Record<String>, Record<String>> {

    public FizzBuzzProcessor(PluginSetting fizzBuzzProcessorSettings) {
        super(fizzBuzzProcessorSettings);
        FizzBuzzProcessorConfig fizzBuzzProcessorConfig = FizzBuzzProcessorConfig.buildConfiguration(fizzBuzzProcessorSettings);
    }

    @Override
    public Collection<Record<String>> doExecute(final Collection<Record<String>> collection) {
        final List<Record<String>> recordsOut = new LinkedList<>();

        for (Record<String> record : collection) {
            //find the numbers in the string
            //see if the numbers are divisible by 3 (fizz) or 5 (buzz)
            //replace the numbers with fizz and/or buzz
        }

        return recordsOut;
    }

    @Override
    public void prepareForShutdown() {
        //we could drain the queue... but, meh, let's just shutdown.
    }

    @Override
    public boolean isReadyForShutdown() {
        return true;
    }

    @Override
    public void shutdown() {
        //NO-OP
    }
}
