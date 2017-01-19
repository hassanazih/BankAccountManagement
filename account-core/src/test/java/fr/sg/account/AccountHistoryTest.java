package fr.sg.account;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(format={"pretty", "html:target/cucumber-reports/account/history"},features="classpath:features/account/account_statements.feature")
public class AccountHistoryTest {
}
