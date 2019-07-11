package org.jenkinsci.plugins.heavy_job;

import hudson.model.JobProperty;
import org.jenkinsci.plugins.workflow.cps.SnippetizerTester;
import org.jenkinsci.plugins.workflow.multibranch.JobPropertyStep;
import org.junit.Rule;
import org.junit.Test;
import org.jvnet.hudson.test.JenkinsRule;

import java.util.Collections;

public class HeavyJobPropertyTest {
    @Rule
    public JenkinsRule j = new JenkinsRule();

    @Test
    public void configProps() throws Exception {
        JobProperty property = new HeavyJobProperty(2);
        SnippetizerTester tester = new SnippetizerTester(j);
        tester.assertRoundTrip(new JobPropertyStep(Collections.singletonList(property)), "properties([jobWeight(2)])");
    }
}
