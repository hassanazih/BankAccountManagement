package fr.sg.account;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(format={"pretty", "html:target/cucumber-reports/account/deposit"},features="classpath:features/account/account_deposit.feature")
public class AccountDepositTest {
}
