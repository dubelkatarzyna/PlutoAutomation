package StepDefinitions;

import Base.BaseUtil;
import Utils.DriverFactory;
import Utils.DriverType;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class GlobalHooks extends BaseUtil {

    private BaseUtil base;

    public GlobalHooks(BaseUtil base) {
        this.base = base;
    }

    @Before
    public void InitializeDriver() {
        base.Driver = DriverFactory.getInstance().getDriver(DriverType.FIREFOX);
    }

    @After
        public void TearDownTest() {
    }
}
