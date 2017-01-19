package fr.sg.account;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(format={"pretty", "html:target/cucumber-reports/account/withdraw"},features="classpath:features/account/account_withdrawal.feature")
public class AccountWithdrawalTest {

}
