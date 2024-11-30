package assertions;

import pages.BrokersPage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BrokersPageAssertions {

    public void cardInfoAssert(BrokersPage brokersPage, String brokerName) {
        assertEquals(brokerName, brokersPage.getBrokerName());
        assertTrue(brokersPage.isAddressDisplayed());
    }

    public void cardDetailsAssert(BrokersPage brokersPage) {
        assertTrue(brokersPage.isNumberOfPropertiesDisplayed());
        assertTrue(brokersPage.isDepartmentDisplayed());
        assertTrue(brokersPage.isLandlinePhoneNumberDisplayed());
        assertTrue(brokersPage.isMobilePhoneNumberDisplayed());
    }
}
