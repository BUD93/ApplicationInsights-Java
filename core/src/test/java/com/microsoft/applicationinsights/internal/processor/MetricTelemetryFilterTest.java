/*
 * ApplicationInsights-Java
 * Copyright (c) Microsoft Corporation
 * All rights reserved.
 *
 * MIT License
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this
 * software and associated documentation files (the ""Software""), to deal in the Software
 * without restriction, including without limitation the rights to use, copy, modify, merge,
 * publish, distribute, sublicense, and/or sell copies of the Software, and to permit
 * persons to whom the Software is furnished to do so, subject to the following conditions:
 * The above copyright notice and this permission notice shall be included in all copies or
 * substantial portions of the Software.
 * THE SOFTWARE IS PROVIDED *AS IS*, WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED,
 * INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR
 * PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE
 * FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR
 * OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER
 * DEALINGS IN THE SOFTWARE.
 */

package com.microsoft.applicationinsights.internal.processor;

import com.microsoft.applicationinsights.telemetry.MetricTelemetry;
import com.microsoft.applicationinsights.telemetry.PageViewTelemetry;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by gupele on 8/7/2016.
 */
public class MetricTelemetryFilterTest {
    @Test
    public void testNonMetricTelemetry() throws Exception {
        MetricTelemetryFilter tested = new MetricTelemetryFilter();
        boolean result = tested.process(new PageViewTelemetry());
        Assert.assertTrue(result);
    }

    @Test
    public void testNeededTelemetry() throws Throwable {
        MetricTelemetryFilter tested = new MetricTelemetryFilter();
        tested.setNotNeeded("name");
        boolean result = tested.process(new PageViewTelemetry("name111"));
        Assert.assertTrue(result);
    }

    @Test
    public void testNotNeededTelemetry() throws Throwable {
        MetricTelemetryFilter tested = new MetricTelemetryFilter();
        tested.setNotNeeded("name");
        boolean result = tested.process(new PageViewTelemetry("name"));
        Assert.assertTrue(result);
    }
}
