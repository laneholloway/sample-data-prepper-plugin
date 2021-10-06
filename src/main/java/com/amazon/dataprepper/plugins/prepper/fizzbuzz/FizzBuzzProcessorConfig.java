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

import java.util.Locale;

public class FizzBuzzProcessorConfig {
    private static final String FIZZ = "fizz";
    private static final String BUZZ = "buzz";
    private final boolean doFizz;
    private final boolean doBuzz;

    /**
     * The standard constructor for the configuration.
     * @param doFizz true if you want to print Fizz
     * @param doBuzz true if you want to print Buzz
     */
    public FizzBuzzProcessorConfig(boolean doFizz, boolean doBuzz) {
        this.doBuzz = doBuzz;
        this.doFizz = doFizz;
    }

    public boolean isDoFizz() {
        return doFizz;
    }

    public boolean isDoBuzz() {
        return doBuzz;
    }

    public static FizzBuzzProcessorConfig buildConfiguration(final PluginSetting fizzBuzzProcessorSettings) {
        FizzBuzzProcessorConfig config;

        Object fizzObject = fizzBuzzProcessorSettings.getAttributeFromSettings(FIZZ);
        Object buzzObject = fizzBuzzProcessorSettings.getAttributeFromSettings(BUZZ);

        boolean fizz = getBooleanValue(fizzObject, FIZZ);
        boolean buzz = getBooleanValue(buzzObject, BUZZ);

        config = new FizzBuzzProcessorConfig(fizz, buzz);

        return config;
    }

    public static boolean getBooleanValue(Object object, String attributeName) {
        //should be a String, should be true or false
        if (object instanceof String) {
            String str = (String)object;
            if (str.toLowerCase(Locale.ROOT).equals("true")) {
                return true;
            } else if (str.toLowerCase(Locale.ROOT).equals("false")) {
                return false;
            } else {
                throw new IllegalArgumentException(attributeName + " must be 'true' or 'false'");
            }
        } else {
            throw new IllegalArgumentException(attributeName +  " must be a String of 'true' or 'false'");
        }
    }
}
