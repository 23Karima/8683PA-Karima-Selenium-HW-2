package test_app.build_acceptance.integration;

import annotations.RetryCount;
import config.Config;
import org.testng.Assert;
import org.testng.annotations.Test;
import base_test.BaseTest;
import utils.RetryAnalyzer;

import java.io.IOException;
import java.net.InetAddress;
import java.sql.SQLException;

public class TestConnectivity extends BaseTest {

    @RetryCount(2)
    @Test (groups = {"integration", "bat", "connectivity"}, retryAnalyzer = RetryAnalyzer.class)
    public void testAppServerConnectivity() {
        boolean isConnected = false;

        try {
            InetAddress host = InetAddress.getByName(appConfig.get(Config.AppProperties.HOST));
            if (host.isReachable(5000)) {
                System.out.println("HOST RESPONSE: 200");
                isConnected = true;
            }
        } catch (IOException e) {
            System.out.println("HOST IS UNREACHABLE");
            e.printStackTrace();
        }

        Assert.assertTrue(isConnected);
    }

    @RetryCount(3)
    @Test (groups = {"integration", "bat", "connectivity"}, retryAnalyzer = RetryAnalyzer.class)
    public void testDatabaseConnectivity() throws SQLException {
        String query = "SELECT 1 FROM DUAL";
        String response = db.executeQueryReadOne(query).toString();
        Assert.assertEquals(response, "1", "DATABASE NOT CONNECTED");
    }
}
