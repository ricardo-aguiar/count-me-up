package tech.experimental.countmeup.service.Integration.steps;

import cucumber.api.java.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import tech.experimental.countmeup.service.Integration.SharedStepData;
import tech.experimental.countmeup.service.Integration.config.TestContext;

/**
 * Cucumber hooks.
 */
@ContextConfiguration(classes = TestContext.class)
public class Hooks
{
    @Autowired
    private SharedStepData sharedStepData;

    /**
     * Cleans any data or previous state before each scenario is run.
     */
    @Before
    public void beforeEachScenario()
    {
        sharedStepData.clearTestData();
    }

}
