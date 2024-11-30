import assertions.BrokersPageAssertions;
import driverfactory.DriverFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.WebDriver;
import pages.BrokersPage;
import util.Configuration;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BrokersPageTests {

    private static WebDriver driver;
    private static BrokersPage brokersPage;
    private BrokersPageAssertions brokersPageAssertions = new BrokersPageAssertions();
    static List<String> brokerList = new ArrayList<>();

    public static Stream<Arguments> brokerListToStream() {
        return brokerList.stream().map(Arguments::of);
    }

    @BeforeAll
    public static void setUp() throws InterruptedException {
        driver = DriverFactory.initializeDriver("chrome");
        driver.manage().window().maximize();
        driver.get(Configuration.BROKERS_URL);
        brokersPage = new BrokersPage(driver);
        brokersPage.acceptCookies();

        brokersPage.scrollTillTheEndOfPage();

        brokerList = brokersPage.everyBrokerName();
        driver.quit();
    }

    @BeforeEach
    public void setUpp() {
        driver = DriverFactory.initializeDriver("chrome");
        driver.manage().window().maximize();
        driver.get(Configuration.BROKERS_URL);
        brokersPage = new BrokersPage(driver);
        brokersPage.acceptCookies();
    }

    @ParameterizedTest
    @MethodSource("brokerListToStream")
    void test2(String name) throws InterruptedException {
        brokersPage.searchForBroker(name);
        Thread.sleep(2000);
        assertEquals(1, brokersPage.getNumberOfBrokers());
        brokersPageAssertions.cardInfoAssert(brokersPage, name);
        brokersPage.clickDetails();
        brokersPageAssertions.cardDetailsAssert(brokersPage);
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

}
