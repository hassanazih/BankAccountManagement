# BankAccountManagement
This repository is created only for test purposes answering the kata below.


# Test Driven Developement

In this exercise, i started with writing failing tests and then implementation. I did also some refactors that bringed back my tests to red zone, and finally all went OK.

# Behaviour Driven Developement

Because i'm a craftmanship, i used to work with my product owner, clients and business to best describe the new functionalities using best tools.

I'm a fan of cucumber (coupled with juint or selenium), so i used it to do my unit tests.

# Branching

Each feature is realized on a separate branch. In the end of each user story, and to be full compliant with the definition of done, the feature branch should be merged with integration branch and new tag should be created.

# Logging using Spring AOP & AspectJ

Because logging is one of the most important functionalities of an entreprise application, i used slf4j and aop to keep trace of each method execution.

# Conclusion

I think that the principal purpose of this kata is just to evaluate the working way of candidates. So i didn't create a real repository for account (even if i used some spring core annotations), nor web frontend.


# Bank account kata

Think of your personal bank account experience When in doubt, go for the simplest solution

# Requirements

Deposit and Withdrawal
Account statement (date, amount, balance)
Statement printing
User Stories

# US 1:

In order to save money
As a bank client
I want to make a deposit in my account

# US 2:

In order to retrieve some or all of my savings
As a bank client
I want to make a withdrawal from my account

# US 3:

In order to check my operations
As a bank client
I want to see the history (operation, date, amount, balance) of my operations
