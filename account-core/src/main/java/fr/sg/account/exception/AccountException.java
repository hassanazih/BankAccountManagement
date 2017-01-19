package fr.sg.account.exception;

import fr.sg.common.BusinessException;

public final class AccountException extends BusinessException{

    public enum AccountError{
        NOT_FOUND,
        AVAILABLE_BALANCE_IS_INSUFFICIENT,
        MANY_ACCOUNTS_WITH_SAME_IDENTIFIER;
    }

    private final AccountError error;

    public AccountException(AccountError error) {
        this.error = error;
    }

    public AccountError getError() {
        return error;
    }
}
